package org.xtext.example.easywall.validation;

import java.util.HashSet;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.xtext.example.easywall.easyWall.EFAllow;
import org.xtext.example.easywall.easyWall.EFApplicationProtocolConstant;
import org.xtext.example.easywall.easyWall.EFBlock;
import org.xtext.example.easywall.easyWall.EFBuiltinFunction;
import org.xtext.example.easywall.easyWall.EFDeny;
import org.xtext.example.easywall.easyWall.EFExpression;
import org.xtext.example.easywall.easyWall.EFField;
import org.xtext.example.easywall.easyWall.EFIPv4Constant;
import org.xtext.example.easywall.easyWall.EFIfStatement;
import org.xtext.example.easywall.easyWall.EFMember;
import org.xtext.example.easywall.easyWall.EFMethod;
import org.xtext.example.easywall.easyWall.EFNetportConstant;
import org.xtext.example.easywall.easyWall.EFNetworkConstant;
import org.xtext.example.easywall.easyWall.EFNetworkProtocolConstant;
import org.xtext.example.easywall.easyWall.EFReturn;
import org.xtext.example.easywall.easyWall.EFRuleClass;
import org.xtext.example.easywall.easyWall.EFRulesTypes;
import org.xtext.example.easywall.easyWall.EFStatement;
import org.xtext.example.easywall.easyWall.EFTransportProtocolConstant;
import org.xtext.example.easywall.easyWall.EFWriteLog;
import org.xtext.example.easywall.easyWall.EasyWallPackage;

@SuppressWarnings("all")
public class EasyWallValidator extends AbstractEasyWallValidator {
  public static final String INVALID_IPV4_OCTET = "invalidIPv4Octet";

  public static final String INVALID_CIDR_PREFIX = "invalidCIDRPrefix";

  public static final String INVALID_PORT = "invalidPort";

  public static final String MISSING_MANDATORY_FIELD_DIRECTION = "missingMandatoryFieldDirection";

  public static final String MISSING_MANDATORY_FIELD_PROTOCOL = "missingMandatoryFieldProtocol";

  public static final String MISSING_TRIGGER_METHOD = "missingTriggerMethod";

  public static final String BUILTIN_OUTSIDE_TRIGGER = "builtinOutsideTrigger";

  public static final String UNREACHABLE_CODE = "unreachableCode";

  public static final String DESTINATION_FIELD = "destinationField";

  public static final String SOURCE_FIELD = "sourceField";

  @Check
  public void checkIPv4Format(final EFIPv4Constant ip) {
    if (((ip.getAny() != null) || (ip.getLocalhost() != null))) {
      return;
    }
    int first = Integer.parseInt(ip.getIpv4().split("\\.")[0]);
    int second = Integer.parseInt(ip.getIpv4().split("\\.")[1]);
    int third = Integer.parseInt(ip.getIpv4().split("\\.")[2]);
    int fourth = Integer.parseInt(ip.getIpv4().split("\\.")[3]);
    final int[] octets = { first, second, third, fourth };
    for (int i = 0; (i < 4); i++) {
      if (((octets[i] < 0) || (octets[i] > 255))) {
        int _get = octets[i];
        String _plus = ("IPv4 octet must be between 0 and 255, got: " + Integer.valueOf(_get));
        this.error(_plus, ip, 
          EasyWallPackage.Literals.EFI_PV4_CONSTANT__IPV4, 
          EasyWallValidator.INVALID_IPV4_OCTET);
      }
    }
  }

  @Check
  public void checkCIDRPrefix(final EFNetworkConstant network) {
    int _rawnetmask = network.getRawnetmask();
    boolean _notEquals = (_rawnetmask != 0);
    if (_notEquals) {
      final int prefix = network.getRawnetmask();
      if (((prefix < 0) || (prefix > 32))) {
        this.error(
          ("CIDR prefix must be between 0 and 32, got: " + Integer.valueOf(prefix)), network, 
          EasyWallPackage.Literals.EF_NETWORK_CONSTANT__RAWNETMASK, 
          EasyWallValidator.INVALID_CIDR_PREFIX);
      }
    }
  }

  @Check
  public void checkPortRange(final EFNetportConstant port) {
    final int portNum = port.getNetport();
    if (((portNum < 1) || (portNum > 65535))) {
      this.error(
        ("Port number must be between 1 and 65535, got: " + Integer.valueOf(portNum)), port, 
        EasyWallPackage.Literals.EF_NETPORT_CONSTANT__NETPORT, 
        EasyWallValidator.INVALID_PORT);
    }
  }

  @Check
  public void checkMandatoryFields(final EFRuleClass rule) {
    boolean hasProtocol = false;
    boolean hasDirection = false;
    EList<EFMember> _members = rule.getMembers();
    for (final EFMember member : _members) {
      if ((member instanceof EFField)) {
        EFField field = ((EFField) member);
        String fieldName = field.getName().toLowerCase();
        boolean _equals = fieldName.equals("rule_protocol");
        if (_equals) {
          hasProtocol = true;
        }
        boolean _equals_1 = fieldName.equals("rule_direction");
        if (_equals_1) {
          hasDirection = true;
        }
      }
    }
    if ((!hasProtocol)) {
      this.error(
        "Rule must define a \'rule_protocol\' field", rule, 
        EasyWallPackage.Literals.EF_RULE_CLASS__NAME, 
        EasyWallValidator.MISSING_MANDATORY_FIELD_PROTOCOL);
    }
    if ((!hasDirection)) {
      this.error(
        "Rule must define a \'rule_direction\' field", rule, 
        EasyWallPackage.Literals.EF_RULE_CLASS__NAME, 
        EasyWallValidator.MISSING_MANDATORY_FIELD_DIRECTION);
    }
  }

  @Check
  public void checkTriggerMethod(final EFRuleClass rule) {
    boolean hasTrigger = false;
    EList<EFMember> _members = rule.getMembers();
    for (final EFMember member : _members) {
      if ((member instanceof EFMethod)) {
        EFMethod method = ((EFMethod) member);
        boolean _equals = method.getName().equals("trigger");
        if (_equals) {
          hasTrigger = true;
          boolean _isEmpty = method.getParams().isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            this.warning(
              "trigger() method should not have parameters", method, 
              EasyWallPackage.Literals.EF_METHOD__PARAMS);
          }
          return;
        }
      }
    }
    if ((!hasTrigger)) {
      this.warning(
        "Rule should define a \'trigger()\' method (otherwise default policy will be applied)", rule, 
        EasyWallPackage.Literals.EF_RULE_CLASS__NAME, 
        EasyWallValidator.MISSING_TRIGGER_METHOD);
    }
  }

  @Check
  public void checkBuiltinInTrigger(final EFBuiltinFunction builtin) {
    EObject container = builtin.eContainer();
    while ((container != null)) {
      {
        if ((container instanceof EFMethod)) {
          EFMethod method = ((EFMethod) container);
          boolean _equals = method.getName().equals("trigger");
          boolean _not = (!_equals);
          if (_not) {
            String _builtinName = this.getBuiltinName(builtin);
            String _plus = ("Built-in function \'" + _builtinName);
            String _plus_1 = (_plus + 
              "\' can only be used inside trigger() method");
            this.error(_plus_1, builtin, 
              null, 
              EasyWallValidator.BUILTIN_OUTSIDE_TRIGGER);
          }
          return;
        }
        container = container.eContainer();
      }
    }
    this.error(
      "Built-in function can only be used inside trigger() method", builtin, 
      null, 
      EasyWallValidator.BUILTIN_OUTSIDE_TRIGGER);
  }

  public String getBuiltinName(final EFBuiltinFunction builtin) {
    if ((builtin instanceof EFAllow)) {
      return "allow()";
    }
    if ((builtin instanceof EFDeny)) {
      return "drop()";
    }
    if ((builtin instanceof EFWriteLog)) {
      return "writelog()";
    }
    return "unknown";
  }

  @Check
  public void checkProtocolLayerCompatibility(final EFRuleClass rule) {
    EFRulesTypes layer = rule.getType();
    EFField protocolField = this.findFieldByName(rule, "rule_protocol");
    if ((protocolField == null)) {
      return;
    }
    EFExpression _expression = protocolField.getExpression();
    if ((_expression instanceof EFNetworkProtocolConstant)) {
      boolean _notEquals = (!Objects.equals(layer, EFRulesTypes.IPLEVEL));
      if (_notEquals) {
        this.error(
          "Network layer protocols can only be used in NetworkLayer rules", protocolField, 
          EasyWallPackage.Literals.EF_FIELD__EXPRESSION);
      }
    } else {
      EFExpression _expression_1 = protocolField.getExpression();
      if ((_expression_1 instanceof EFTransportProtocolConstant)) {
        boolean _notEquals_1 = (!Objects.equals(layer, EFRulesTypes.TRANSPLEVEL));
        if (_notEquals_1) {
          this.error(
            "Transport layer protocols can only be used in TransportLayer rules", protocolField, 
            EasyWallPackage.Literals.EF_FIELD__EXPRESSION);
        }
      } else {
        EFExpression _expression_2 = protocolField.getExpression();
        if ((_expression_2 instanceof EFApplicationProtocolConstant)) {
          boolean _notEquals_2 = (!Objects.equals(layer, EFRulesTypes.APPLEVEL));
          if (_notEquals_2) {
            this.error(
              "Application layer protocols can only be used in ApplicationLayer rules", protocolField, 
              EasyWallPackage.Literals.EF_FIELD__EXPRESSION);
          }
        }
      }
    }
  }

  @Check
  public void checkUnreachableCode(final EFBlock block) {
    boolean foundTerminal = false;
    EList<EFStatement> _statements = block.getStatements();
    for (final EFStatement stmt : _statements) {
      {
        if (foundTerminal) {
          this.error(
            "Unreachable code after allow()/deny()", stmt, 
            null, 
            EasyWallValidator.UNREACHABLE_CODE);
          return;
        }
        boolean _isTerminalStatement = this.isTerminalStatement(stmt);
        if (_isTerminalStatement) {
          foundTerminal = true;
        }
      }
    }
  }

  @Check
  public void checkWarningFields(final EFRuleClass rule) {
    HashSet<String> possibleDestinationNames = CollectionLiterals.<String>newHashSet("d", "dest", "ruleDestination", "dst", "destination");
    HashSet<String> possibleSourceNames = CollectionLiterals.<String>newHashSet("src", "source", "ruleSource", "s", "sour");
    EList<EFMember> _members = rule.getMembers();
    for (final EFMember member : _members) {
      if ((member instanceof EFField)) {
        EFField field = ((EFField) member);
        String fieldName = field.getName().toLowerCase();
        boolean _contains = possibleDestinationNames.contains(fieldName);
        if (_contains) {
          this.warning(
            "To be compiled, destination field must be: rule_dest (if you want to specify the port you must also write rule_dest_port)", field, 
            EasyWallPackage.Literals.EF_MEMBER__NAME, 
            EasyWallValidator.DESTINATION_FIELD);
        }
        boolean _contains_1 = possibleSourceNames.contains(fieldName);
        if (_contains_1) {
          this.warning(
            "To be compiled source field must be: rule_src (if you want to specify the port you must also write rule_src_port)", field, 
            EasyWallPackage.Literals.EF_MEMBER__NAME, 
            EasyWallValidator.SOURCE_FIELD);
        }
      }
    }
  }

  public EFField findFieldByName(final EFRuleClass rule, final String name) {
    EList<EFMember> _members = rule.getMembers();
    for (final EFMember member : _members) {
      if ((member instanceof EFField)) {
        EFField field = ((EFField) member);
        boolean _equalsIgnoreCase = field.getName().equalsIgnoreCase(name);
        if (_equalsIgnoreCase) {
          return field;
        }
      }
    }
    return null;
  }

  public boolean isTerminalStatement(final EFStatement stmt) {
    if ((stmt instanceof EFExpression)) {
      final EFExpression expr = ((EFExpression) stmt);
      return this.containsTerminal(expr);
    }
    if ((stmt instanceof EFReturn)) {
      return true;
    }
    if ((stmt instanceof EFIfStatement)) {
      final EFIfStatement ifStmt = ((EFIfStatement) stmt);
      return (this.isBlockTerminal(ifStmt.getThenBlock()) && ((ifStmt.getElseBlock() != null) && this.isBlockTerminal(ifStmt.getElseBlock())));
    }
    return false;
  }

  public boolean containsTerminal(final EFExpression expr) {
    if (((expr instanceof EFAllow) || (expr instanceof EFDeny))) {
      return true;
    }
    EList<EObject> _eContents = expr.eContents();
    for (final EObject child : _eContents) {
      if ((child instanceof EFExpression)) {
        boolean _containsTerminal = this.containsTerminal(((EFExpression) child));
        if (_containsTerminal) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isBlockTerminal(final EFBlock block) {
    EList<EFStatement> _statements = block.getStatements();
    for (final EFStatement stmt : _statements) {
      boolean _isTerminalStatement = this.isTerminalStatement(stmt);
      if (_isTerminalStatement) {
        return true;
      }
    }
    return false;
  }
}
