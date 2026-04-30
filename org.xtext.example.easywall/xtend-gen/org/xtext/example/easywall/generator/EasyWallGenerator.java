package org.xtext.example.easywall.generator;

import com.google.common.collect.Iterables;
import java.util.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.xtext.example.easywall.easyWall.APPLICATIONLAYERPROTOCOL;
import org.xtext.example.easywall.easyWall.EFAddExpression;
import org.xtext.example.easywall.easyWall.EFAllow;
import org.xtext.example.easywall.easyWall.EFAndExpression;
import org.xtext.example.easywall.easyWall.EFApplicationProtocolConstant;
import org.xtext.example.easywall.easyWall.EFAssignment;
import org.xtext.example.easywall.easyWall.EFBlock;
import org.xtext.example.easywall.easyWall.EFBoolConstant;
import org.xtext.example.easywall.easyWall.EFBracketsExpression;
import org.xtext.example.easywall.easyWall.EFDefaultAction;
import org.xtext.example.easywall.easyWall.EFDefaultPolicy;
import org.xtext.example.easywall.easyWall.EFDirectionConstant;
import org.xtext.example.easywall.easyWall.EFDirectionNativeType;
import org.xtext.example.easywall.easyWall.EFDrop;
import org.xtext.example.easywall.easyWall.EFEqualExpression;
import org.xtext.example.easywall.easyWall.EFExpression;
import org.xtext.example.easywall.easyWall.EFField;
import org.xtext.example.easywall.easyWall.EFFirewall;
import org.xtext.example.easywall.easyWall.EFFunctionCall;
import org.xtext.example.easywall.easyWall.EFGetPacketField;
import org.xtext.example.easywall.easyWall.EFGetTime;
import org.xtext.example.easywall.easyWall.EFHeader;
import org.xtext.example.easywall.easyWall.EFIPv4Constant;
import org.xtext.example.easywall.easyWall.EFIfStatement;
import org.xtext.example.easywall.easyWall.EFIntConstant;
import org.xtext.example.easywall.easyWall.EFLogLevel;
import org.xtext.example.easywall.easyWall.EFMember;
import org.xtext.example.easywall.easyWall.EFMemberSelection;
import org.xtext.example.easywall.easyWall.EFMethod;
import org.xtext.example.easywall.easyWall.EFMultExpression;
import org.xtext.example.easywall.easyWall.EFNetportConstant;
import org.xtext.example.easywall.easyWall.EFNetworkConstant;
import org.xtext.example.easywall.easyWall.EFNetworkNativeType;
import org.xtext.example.easywall.easyWall.EFNetworkProtocolConstant;
import org.xtext.example.easywall.easyWall.EFNotExpression;
import org.xtext.example.easywall.easyWall.EFOrExpression;
import org.xtext.example.easywall.easyWall.EFParameter;
import org.xtext.example.easywall.easyWall.EFPrimitiveType;
import org.xtext.example.easywall.easyWall.EFProgram;
import org.xtext.example.easywall.easyWall.EFReject;
import org.xtext.example.easywall.easyWall.EFRelExpression;
import org.xtext.example.easywall.easyWall.EFReturn;
import org.xtext.example.easywall.easyWall.EFRule;
import org.xtext.example.easywall.easyWall.EFRuleClass;
import org.xtext.example.easywall.easyWall.EFRuleReference;
import org.xtext.example.easywall.easyWall.EFRulesTypes;
import org.xtext.example.easywall.easyWall.EFStatement;
import org.xtext.example.easywall.easyWall.EFStringConstant;
import org.xtext.example.easywall.easyWall.EFSymbolRef;
import org.xtext.example.easywall.easyWall.EFTransportProtocolConstant;
import org.xtext.example.easywall.easyWall.EFWriteLog;
import org.xtext.example.easywall.easyWall.EFWriteLogLevel;
import org.xtext.example.easywall.easyWall.NETWORKLAYERPROTOCOL;
import org.xtext.example.easywall.easyWall.TRANSPORTLAYERPROTOCOL;

/**
 * Code Generator per EasyWall DSL
 * Genera classi Java che estendono Rule per java-firewall
 */
@SuppressWarnings("all")
public class EasyWallGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IteratorExtensions.<EObject>head(resource.getAllContents());
    final EFProgram program = ((EFProgram) _head);
    String _xifexpression = null;
    EFHeader _header = program.getHeader();
    String _name = null;
    if (_header!=null) {
      _name=_header.getName();
    }
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      _xifexpression = program.getHeader().getName();
    } else {
      _xifexpression = "generated.rules";
    }
    final String packageName = _xifexpression;
    EList<EFRule> _rules = program.getRules();
    for (final EFRule rule : _rules) {
      this.generateRuleClass(rule.getRules(), packageName, fsa);
    }
    EFFirewall _firewall = program.getFirewall();
    boolean _tripleNotEquals_1 = (_firewall != null);
    if (_tripleNotEquals_1) {
      this.generateMainClass(program.getFirewall(), packageName, program.getRules(), fsa);
    }
  }

  public void generateRuleClass(final EFRuleClass rule, final String packageName, final IFileSystemAccess2 fsa) {
    final String className = rule.getName();
    String _replace = packageName.replace(".", "/");
    String _plus = (_replace + "/");
    String _plus_1 = (_plus + className);
    final String filePath = (_plus_1 + ".java");
    fsa.generateFile(filePath, this.compileRuleClass(rule, packageName));
  }

  public CharSequence compileRuleClass(final EFRuleClass rule, final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import rules.*;");
    _builder.newLine();
    _builder.append("import elements.*;");
    _builder.newLine();
    _builder.append("import java.util.Optional;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generated EasyWall Rule: ");
    String _name = rule.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* Layer: ");
    EFRulesTypes _type = rule.getType();
    _builder.append(_type, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = rule.getName();
    _builder.append(_name_1);
    _builder.append(" extends Rule {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Custom Fields");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    {
      final Function1<EFField, Boolean> _function = (EFField it) -> {
        boolean _isConfigField = this.isConfigField(it);
        return Boolean.valueOf((!_isConfigField));
      };
      Iterable<EFField> _filter = IterableExtensions.<EFField>filter(Iterables.<EFField>filter(rule.getMembers(), EFField.class), _function);
      for(final EFField field : _filter) {
        _builder.append("    ");
        CharSequence _compileField = this.compileField(field);
        _builder.append(_compileField, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Constructor");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    String _name_2 = rule.getName();
    _builder.append(_name_2, "    ");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(");
    _builder.newLine();
    _builder.append("            ");
    CharSequence _compileLayer = this.compileLayer(rule.getType());
    _builder.append(_compileLayer, "            ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    CharSequence _compileProtocolField = this.compileProtocolField(rule);
    _builder.append(_compileProtocolField, "            ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    CharSequence _compileSourceEndpoint = this.compileSourceEndpoint(rule);
    _builder.append(_compileSourceEndpoint, "            ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    CharSequence _compileDestinationEndpoint = this.compileDestinationEndpoint(rule);
    _builder.append(_compileDestinationEndpoint, "            ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    CharSequence _compileDirectionField = this.compileDirectionField(rule);
    _builder.append(_compileDirectionField, "            ");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("Action.ALLOW  // Default, will be overridden by trigger");
    _builder.newLine();
    _builder.append("        ");
    _builder.append(");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Trigger Method Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    final Function1<EFMethod, Boolean> _function_1 = (EFMethod it) -> {
      String _name_3 = it.getName();
      return Boolean.valueOf(Objects.equals(_name_3, "trigger"));
    };
    final EFMethod triggerMethod = IterableExtensions.<EFMethod>findFirst(Iterables.<EFMethod>filter(rule.getMembers(), EFMethod.class), _function_1);
    _builder.newLineIfNotEmpty();
    {
      if ((triggerMethod != null)) {
        _builder.append("    ");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("public Action trigger(MyPacket packet) {");
        _builder.newLine();
        {
          EList<EFStatement> _statements = triggerMethod.getBody().getStatements();
          for(final EFStatement stmt : _statements) {
            _builder.append("    ");
            _builder.append("    ");
            CharSequence _compileStatementInFunc = this.compileStatementInFunc(stmt);
            _builder.append(_compileStatementInFunc, "        ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// Helper Methods");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// ============================================");
    _builder.newLine();
    {
      final Function1<EFMethod, Boolean> _function_2 = (EFMethod it) -> {
        String _name_3 = it.getName();
        return Boolean.valueOf((!Objects.equals(_name_3, "trigger")));
      };
      Iterable<EFMethod> _filter_1 = IterableExtensions.<EFMethod>filter(Iterables.<EFMethod>filter(rule.getMembers(), EFMethod.class), _function_2);
      for(final EFMethod method : _filter_1) {
        _builder.append("    ");
        CharSequence _compileMethod = this.compileMethod(method);
        _builder.append(_compileMethod, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public boolean isConfigField(final EFField field) {
    final String name = field.getName().toLowerCase();
    return (((Objects.equals(name, "rule_protocol") || Objects.equals(name, "rule_direction")) || 
      Objects.equals(name, "source")) || Objects.equals(name, "destination"));
  }

  public CharSequence compileLayer(final EFRulesTypes type) {
    String _switchResult = null;
    if (type != null) {
      switch (type) {
        case IPLEVEL:
          _switchResult = "Layer.NETWORK";
          break;
        case TRANSPLEVEL:
          _switchResult = "Layer.TRANSPORT";
          break;
        case APPLEVEL:
          _switchResult = "Layer.APPLICATION";
          break;
        default:
          _switchResult = "Layer.NETWORK";
          break;
      }
    } else {
      _switchResult = "Layer.NETWORK";
    }
    return _switchResult;
  }

  public CharSequence compileProtocolField(final EFRuleClass rule) {
    final EFField protocolField = this.findFieldByName(rule, "rule_protocol");
    EFExpression _expression = null;
    if (protocolField!=null) {
      _expression=protocolField.getExpression();
    }
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      return this.compileProtocolExpression(protocolField.getExpression());
    }
    return "null";
  }

  public CharSequence compileProtocolExpression(final EFExpression expr) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (expr instanceof EFNetworkProtocolConstant) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("NetworkLayerProtocol.");
      NETWORKLAYERPROTOCOL _protocol = ((EFNetworkProtocolConstant)expr).getProtocol();
      _builder.append(_protocol);
      _switchResult = _builder;
    }
    if (!_matched) {
      if (expr instanceof EFTransportProtocolConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("TransportLayerProtocol.");
        TRANSPORTLAYERPROTOCOL _protocol = ((EFTransportProtocolConstant)expr).getProtocol();
        _builder.append(_protocol);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof EFApplicationProtocolConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("ApplicationLayerProtocol.");
        APPLICATIONLAYERPROTOCOL _protocol = ((EFApplicationProtocolConstant)expr).getProtocol();
        _builder.append(_protocol);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "null";
    }
    return _switchResult;
  }

  public CharSequence compileDirectionField(final EFRuleClass rule) {
    final EFField dirField = this.findFieldByName(rule, "rule_direction");
    EFExpression _expression = null;
    if (dirField!=null) {
      _expression=dirField.getExpression();
    }
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      return this.compileDirection(dirField.getExpression());
    }
    return "Direction.IN";
  }

  public CharSequence compileDirection(final EFExpression expr) {
    String _xifexpression = null;
    if ((expr instanceof EFDirectionConstant)) {
      String _switchResult = null;
      EFDirectionNativeType _direction = ((EFDirectionConstant)expr).getDirection();
      if (_direction != null) {
        switch (_direction) {
          case IN:
            _switchResult = "Direction.IN";
            break;
          case OUT:
            _switchResult = "Direction.OUT";
            break;
          case FORWARD:
            _switchResult = "Direction.FORWARD";
            break;
          default:
            _switchResult = "Direction.IN";
            break;
        }
      } else {
        _switchResult = "Direction.IN";
      }
      _xifexpression = _switchResult;
    } else {
      return "Direction.IN";
    }
    return _xifexpression;
  }

  public CharSequence compileSourceEndpoint(final EFRuleClass rule) {
    final EFField sourceField = this.findFieldByName(rule, "source");
    EFExpression _expression = null;
    if (sourceField!=null) {
      _expression=sourceField.getExpression();
    }
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      return this.compileEndpoint(sourceField.getExpression());
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Endpoint(Optional.empty(), Optional.empty(), Optional.empty())");
    return _builder;
  }

  public CharSequence compileDestinationEndpoint(final EFRuleClass rule) {
    final EFField destField = this.findFieldByName(rule, "destination");
    EFExpression _expression = null;
    if (destField!=null) {
      _expression=destField.getExpression();
    }
    boolean _tripleNotEquals = (_expression != null);
    if (_tripleNotEquals) {
      return this.compileEndpoint(destField.getExpression());
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Endpoint(Optional.empty(), Optional.empty(), Optional.empty())");
    return _builder;
  }

  public CharSequence compileEndpoint(final EFExpression expr) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (expr instanceof EFIPv4Constant) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new Endpoint(Optional.of(");
      CharSequence _compileIPv4 = this.compileIPv4(((EFIPv4Constant)expr));
      _builder.append(_compileIPv4);
      _builder.append("), Optional.empty(), Optional.empty())");
      _switchResult = _builder;
    }
    if (!_matched) {
      if (expr instanceof EFNetworkConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new Endpoint(Optional.empty(), Optional.of(");
        CharSequence _compileNetwork = this.compileNetwork(((EFNetworkConstant)expr));
        _builder.append(_compileNetwork);
        _builder.append("), Optional.empty())");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof EFNetportConstant) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new Endpoint(Optional.empty(), Optional.empty(), Optional.of(");
        CharSequence _compilePort = this.compilePort(((EFNetportConstant)expr));
        _builder.append(_compilePort);
        _builder.append("))");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (expr instanceof EFSymbolRef) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new Endpoint(Optional.ofNullable(");
        String _symbol = ((EFSymbolRef)expr).getSymbol();
        _builder.append(_symbol);
        _builder.append("), Optional.empty(), Optional.empty())");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new Endpoint(Optional.empty(), Optional.empty(), Optional.empty())");
      _switchResult = _builder;
    }
    return _switchResult;
  }

  public CharSequence compileField(final EFField field) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _contains = field.eContainmentFeature().getName().contains("set");
      if (_contains) {
        _xifexpression = "private final";
      } else {
        _xifexpression = "private";
      }
      final String modifier = _xifexpression;
      final String type = this.getJavaType(field);
      String _xifexpression_1 = null;
      EFExpression _expression = field.getExpression();
      boolean _tripleNotEquals = (_expression != null);
      if (_tripleNotEquals) {
        String _compileExpression = this.compileExpression(field.getExpression());
        _xifexpression_1 = (" = " + _compileExpression);
      } else {
        _xifexpression_1 = this.getDefaultValue(field);
      }
      final String init = _xifexpression_1;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(modifier);
      _builder.append(" ");
      _builder.append(type);
      _builder.append(" ");
      String _name = field.getName();
      _builder.append(_name);
      _builder.append(init);
      _builder.append(";");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public CharSequence compileFieldInFunc(final EFField field) {
    CharSequence _xblockexpression = null;
    {
      final String type = this.getJavaType(field);
      String _xifexpression = null;
      EFExpression _expression = field.getExpression();
      boolean _tripleNotEquals = (_expression != null);
      if (_tripleNotEquals) {
        String _compileExpression = this.compileExpression(field.getExpression());
        _xifexpression = (" = " + _compileExpression);
      } else {
        _xifexpression = this.getDefaultValue(field);
      }
      final String init = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(type);
      _builder.append(" ");
      String _name = field.getName();
      _builder.append(_name);
      _builder.append(init);
      _builder.append(";");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public String getJavaType(final EFField field) {
    EFPrimitiveType _primitivetype = field.getPrimitivetype();
    boolean _tripleNotEquals = (_primitivetype != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      EFPrimitiveType _primitivetype_1 = field.getPrimitivetype();
      if (_primitivetype_1 != null) {
        switch (_primitivetype_1) {
          case INT:
            _switchResult = "long";
            break;
          case STRING:
            _switchResult = "String";
            break;
          case BOOL:
            _switchResult = "boolean";
            break;
          default:
            _switchResult = "Object";
            break;
        }
      } else {
        _switchResult = "Object";
      }
      return _switchResult;
    } else {
      EFNetworkNativeType _nativetype = field.getNativetype();
      boolean _tripleNotEquals_1 = (_nativetype != null);
      if (_tripleNotEquals_1) {
        String _switchResult_1 = null;
        EFNetworkNativeType _nativetype_1 = field.getNativetype();
        if (_nativetype_1 != null) {
          switch (_nativetype_1) {
            case NETWORK:
              _switchResult_1 = "Network";
              break;
            case IPV4:
              _switchResult_1 = "IPv4";
              break;
            case IPV6:
              _switchResult_1 = "IPv6";
              break;
            case PORT:
              _switchResult_1 = "NetPort";
              break;
            case PROTOCOL:
              _switchResult_1 = "IProtocol";
              break;
            case DIRECTION:
              _switchResult_1 = "Direction";
              break;
            case NETMASK:
              _switchResult_1 = "int";
              break;
            default:
              _switchResult_1 = "Object";
              break;
          }
        } else {
          _switchResult_1 = "Object";
        }
        return _switchResult_1;
      }
    }
    return "Object";
  }

  public String getDefaultValue(final EFField field) {
    EFPrimitiveType _primitivetype = field.getPrimitivetype();
    boolean _tripleNotEquals = (_primitivetype != null);
    if (_tripleNotEquals) {
      String _switchResult = null;
      EFPrimitiveType _primitivetype_1 = field.getPrimitivetype();
      if (_primitivetype_1 != null) {
        switch (_primitivetype_1) {
          case INT:
            _switchResult = " = 0";
            break;
          case STRING:
            _switchResult = " = \"\"";
            break;
          case BOOL:
            _switchResult = " = false";
            break;
          default:
            _switchResult = "";
            break;
        }
      } else {
        _switchResult = "";
      }
      return _switchResult;
    }
    return "";
  }

  public CharSequence compileMethod(final EFMethod method) {
    CharSequence _xblockexpression = null;
    {
      final String returnType = this.getMethodReturnType(method);
      final String params = this.compileParameters(method.getParams());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private ");
      _builder.append(returnType);
      _builder.append(" ");
      String _name = method.getName();
      _builder.append(_name);
      _builder.append("(");
      _builder.append(params);
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        EList<EFStatement> _statements = method.getBody().getStatements();
        for(final EFStatement stmt : _statements) {
          _builder.append("    ");
          CharSequence _compileStatement = this.compileStatement(stmt);
          _builder.append(_compileStatement, "    ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  public String getMethodReturnType(final EFMethod method) {
    String _void = method.getVoid();
    boolean _tripleNotEquals = (_void != null);
    if (_tripleNotEquals) {
      return "void";
    }
    EFPrimitiveType _primitivetype = method.getPrimitivetype();
    boolean _tripleNotEquals_1 = (_primitivetype != null);
    if (_tripleNotEquals_1) {
      String _switchResult = null;
      EFPrimitiveType _primitivetype_1 = method.getPrimitivetype();
      if (_primitivetype_1 != null) {
        switch (_primitivetype_1) {
          case INT:
            _switchResult = "int";
            break;
          case STRING:
            _switchResult = "String";
            break;
          case BOOL:
            _switchResult = "boolean";
            break;
          default:
            _switchResult = "Object";
            break;
        }
      } else {
        _switchResult = "Object";
      }
      return _switchResult;
    }
    return "void";
  }

  public String compileParameters(final Iterable<EFParameter> params) {
    final Function1<EFParameter, String> _function = (EFParameter p) -> {
      String _javaType = this.getJavaType(((EFField) p));
      String _plus = (_javaType + " ");
      String _name = p.getName();
      return (_plus + _name);
    };
    return IterableExtensions.join(IterableExtensions.<EFParameter, String>map(params, _function), ", ");
  }

  public CharSequence compileStatement(final EFStatement stmt) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (stmt instanceof EFField) {
      _matched=true;
      CharSequence _compileField = this.compileField(((EFField)stmt));
      _switchResult = (_compileField + "\n");
    }
    if (!_matched) {
      if (stmt instanceof EFReturn) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return ");
        String _compileExpression = this.compileExpression(((EFReturn)stmt).getExpression());
        _builder.append(_compileExpression);
        _builder.append(";");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (stmt instanceof EFIfStatement) {
        _matched=true;
        _switchResult = this.compileIfStatement(((EFIfStatement)stmt));
      }
    }
    if (!_matched) {
      if (stmt instanceof EFExpression) {
        _matched=true;
        String _compileExpression = this.compileExpression(((EFExpression)stmt));
        _switchResult = (_compileExpression + ";");
      }
    }
    if (!_matched) {
      _switchResult = "// Unknown statement";
    }
    return _switchResult;
  }

  public CharSequence compileStatementInFunc(final EFStatement stmt) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (stmt instanceof EFField) {
      _matched=true;
      CharSequence _compileFieldInFunc = this.compileFieldInFunc(((EFField)stmt));
      _switchResult = (_compileFieldInFunc + "\n");
    }
    if (!_matched) {
      if (stmt instanceof EFReturn) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("return ");
        String _compileExpression = this.compileExpression(((EFReturn)stmt).getExpression());
        _builder.append(_compileExpression);
        _builder.append(";");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (stmt instanceof EFIfStatement) {
        _matched=true;
        _switchResult = this.compileIfStatement(((EFIfStatement)stmt));
      }
    }
    if (!_matched) {
      if (stmt instanceof EFExpression) {
        _matched=true;
        String _compileExpression = this.compileExpression(((EFExpression)stmt));
        _switchResult = (_compileExpression + ";");
      }
    }
    if (!_matched) {
      _switchResult = "// Unknown statement";
    }
    return _switchResult;
  }

  public CharSequence compileIfStatement(final EFIfStatement ifStmt) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    String _compileExpression = this.compileExpression(ifStmt.getExpression());
    _builder.append(_compileExpression);
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      EList<EFStatement> _statements = ifStmt.getThenBlock().getStatements();
      for(final EFStatement stmt : _statements) {
        _builder.append("    ");
        CharSequence _compileStatement = this.compileStatement(stmt);
        _builder.append(_compileStatement, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    {
      EFBlock _elseBlock = ifStmt.getElseBlock();
      boolean _tripleNotEquals = (_elseBlock != null);
      if (_tripleNotEquals) {
        _builder.append(" else {");
        _builder.newLineIfNotEmpty();
        {
          EList<EFStatement> _statements_1 = ifStmt.getElseBlock().getStatements();
          for(final EFStatement stmt_1 : _statements_1) {
            _builder.append("    ");
            CharSequence _compileStatement_1 = this.compileStatement(stmt_1);
            _builder.append(_compileStatement_1, "    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public String compileExpression(final EFExpression expr) {
    String _switchResult = null;
    boolean _matched = false;
    if (expr instanceof EFStringConstant) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _value = ((EFStringConstant)expr).getValue();
      _builder.append(_value);
      _builder.append("\"");
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      if (expr instanceof EFIntConstant) {
        _matched=true;
        _switchResult = Integer.valueOf(((EFIntConstant)expr).getValue()).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFBoolConstant) {
        _matched=true;
        _switchResult = ((EFBoolConstant)expr).getValue();
      }
    }
    if (!_matched) {
      if (expr instanceof EFAssignment) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExpression = this.compileExpression(((EFAssignment)expr).getLeft());
        _builder.append(_compileExpression);
        _builder.append(" = ");
        String _compileExpression_1 = this.compileExpression(((EFAssignment)expr).getRight());
        _builder.append(_compileExpression_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFOrExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExpression = this.compileExpression(((EFOrExpression)expr).getLeft());
        _builder.append(_compileExpression);
        _builder.append(" || ");
        String _compileExpression_1 = this.compileExpression(((EFOrExpression)expr).getRight());
        _builder.append(_compileExpression_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFAndExpression) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _compileExpression = this.compileExpression(((EFAndExpression)expr).getLeft());
        _builder.append(_compileExpression);
        _builder.append(" && ");
        String _compileExpression_1 = this.compileExpression(((EFAndExpression)expr).getRight());
        _builder.append(_compileExpression_1);
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFEqualExpression) {
        _matched=true;
        _switchResult = this.compileEqualExpression(((EFEqualExpression)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFRelExpression) {
        _matched=true;
        _switchResult = this.compileRelExpression(((EFRelExpression)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFAddExpression) {
        _matched=true;
        _switchResult = this.compileAddExpression(((EFAddExpression)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFMultExpression) {
        _matched=true;
        _switchResult = this.compileMultExpression(((EFMultExpression)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFNotExpression) {
        _matched=true;
        String _compileExpression = this.compileExpression(((EFNotExpression)expr).getExpression());
        _switchResult = ("!" + _compileExpression);
      }
    }
    if (!_matched) {
      if (expr instanceof EFSymbolRef) {
        _matched=true;
        _switchResult = ((EFSymbolRef)expr).getSymbol();
      }
    }
    if (!_matched) {
      if (expr instanceof EFFunctionCall) {
        _matched=true;
        _switchResult = this.compileFunctionCall(((EFFunctionCall)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFMemberSelection) {
        _matched=true;
        _switchResult = this.compileMemberSelection(((EFMemberSelection)expr));
      }
    }
    if (!_matched) {
      if (expr instanceof EFIPv4Constant) {
        _matched=true;
        _switchResult = this.compileIPv4(((EFIPv4Constant)expr)).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFNetworkConstant) {
        _matched=true;
        _switchResult = this.compileNetwork(((EFNetworkConstant)expr)).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFNetportConstant) {
        _matched=true;
        _switchResult = this.compilePort(((EFNetportConstant)expr)).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFDirectionConstant) {
        _matched=true;
        _switchResult = this.compileDirection(expr).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFNetworkProtocolConstant) {
        _matched=true;
        _switchResult = this.compileProtocolExpression(expr).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFTransportProtocolConstant) {
        _matched=true;
        _switchResult = this.compileProtocolExpression(expr).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFApplicationProtocolConstant) {
        _matched=true;
        _switchResult = this.compileProtocolExpression(expr).toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFBracketsExpression) {
        _matched=true;
        String _compileExpression = this.compileExpression(((EFBracketsExpression)expr).getExpression());
        String _plus = ("(" + _compileExpression);
        _switchResult = (_plus + ")");
      }
    }
    if (!_matched) {
      if (expr instanceof EFAllow) {
        _matched=true;
        _switchResult = "return Action.ALLOW";
      }
    }
    if (!_matched) {
      if (expr instanceof EFBlock) {
        _matched=true;
        _switchResult = "return Action.DENY";
      }
    }
    if (!_matched) {
      if (expr instanceof EFDrop) {
        _matched=true;
        _switchResult = "return Action.DROP";
      }
    }
    if (!_matched) {
      if (expr instanceof EFReject) {
        _matched=true;
        _switchResult = "return Action.REJECT";
      }
    }
    if (!_matched) {
      if (expr instanceof EFWriteLog) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("logger.Logger.writeOnLogFile(packet, \"firewall-log.txt\", logger.LogLevel.INFO,");
        String _compileExpression = this.compileExpression(((EFWriteLog)expr).getMessage());
        _builder.append(_compileExpression);
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFWriteLogLevel) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("logger.Logger.writeOnLogFile(packet, \"firewall-log.txt\", logger.LogLevel");
        EFLogLevel _level = ((EFWriteLogLevel)expr).getLevel();
        _builder.append(_level);
        _builder.append(",");
        String _compileExpression = this.compileExpression(((EFWriteLogLevel)expr).getMessage());
        _builder.append(_compileExpression);
        _builder.append(")");
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (expr instanceof EFGetTime) {
        _matched=true;
        _switchResult = "System.currentTimeMillis() / 1000";
      }
    }
    if (!_matched) {
      if (expr instanceof EFGetPacketField) {
        _matched=true;
        _switchResult = this.compileGetPacketField(((EFGetPacketField)expr));
      }
    }
    if (!_matched) {
      String _simpleName = expr.getClass().getSimpleName();
      String _plus = ("/* unknown: " + _simpleName);
      _switchResult = (_plus + " */");
    }
    return _switchResult;
  }

  public String compileEqualExpression(final EFEqualExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileExpression = this.compileExpression(expr.getLeft());
    _builder.append(_compileExpression);
    _builder.append(" == ");
    String _compileExpression_1 = this.compileExpression(expr.getRight());
    _builder.append(_compileExpression_1);
    return _builder.toString();
  }

  public String compileRelExpression(final EFRelExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileExpression = this.compileExpression(expr.getLeft());
    _builder.append(_compileExpression);
    _builder.append(" > ");
    String _compileExpression_1 = this.compileExpression(expr.getRight());
    _builder.append(_compileExpression_1);
    return _builder.toString();
  }

  public String compileAddExpression(final EFAddExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileExpression = this.compileExpression(expr.getLeft());
    _builder.append(_compileExpression);
    _builder.append(" + ");
    String _compileExpression_1 = this.compileExpression(expr.getRight());
    _builder.append(_compileExpression_1);
    return _builder.toString();
  }

  public String compileMultExpression(final EFMultExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _compileExpression = this.compileExpression(expr.getLeft());
    _builder.append(_compileExpression);
    _builder.append(" * ");
    String _compileExpression_1 = this.compileExpression(expr.getRight());
    _builder.append(_compileExpression_1);
    return _builder.toString();
  }

  public String compileGetPacketField(final EFGetPacketField expr) {
    String _xblockexpression = null;
    {
      final String field = expr.getField();
      String _switchResult = null;
      if (field != null) {
        switch (field) {
          case "srcip":
            _switchResult = "packet.sourceAddress().get().toString()";
            break;
          case "dstip":
            _switchResult = "packet.destinationAddress().get().toString()";
            break;
          case "srcport":
            _switchResult = "String.valueOf(packet.sourcePort().orElse(0))";
            break;
          case "dstport":
            _switchResult = "String.valueOf(packet.destinationPort().orElse(0))";
            break;
          default:
            _switchResult = "\"\"";
            break;
        }
      } else {
        _switchResult = "\"\"";
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  public String compileFunctionCall(final EFFunctionCall call) {
    String _xblockexpression = null;
    {
      final Function1<EFExpression, String> _function = (EFExpression it) -> {
        return this.compileExpression(it);
      };
      final String args = IterableExtensions.join(ListExtensions.<EFExpression, String>map(call.getArgs(), _function), ", ");
      String _functionName = call.getFunctionName();
      String _plus = (_functionName + "(");
      String _plus_1 = (_plus + args);
      _xblockexpression = (_plus_1 + ")");
    }
    return _xblockexpression;
  }

  public String compileMemberSelection(final EFMemberSelection sel) {
    String _xblockexpression = null;
    {
      final String receiver = this.compileExpression(sel.getReceiver());
      final String member = sel.getMember().getName();
      String _xifexpression = null;
      if (((sel.getArgs() != null) && (!sel.getArgs().isEmpty()))) {
        final Function1<EFExpression, String> _function = (EFExpression it) -> {
          return this.compileExpression(it);
        };
        String _join = IterableExtensions.join(ListExtensions.<EFExpression, String>map(sel.getArgs(), _function), ", ");
        String _plus = ("(" + _join);
        _xifexpression = (_plus + ")");
      } else {
        _xifexpression = "";
      }
      final String args = _xifexpression;
      _xblockexpression = (((receiver + ".") + member) + args);
    }
    return _xblockexpression;
  }

  public CharSequence compileIPv4(final EFIPv4Constant ip) {
    String _any = ip.getAny();
    boolean _tripleNotEquals = (_any != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("IPv4.of(\"0.0.0.0\")");
      return _builder;
    } else {
      String _localhost = ip.getLocalhost();
      boolean _tripleNotEquals_1 = (_localhost != null);
      if (_tripleNotEquals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("IPv4.of(\"127.0.0.1\")");
        return _builder_1;
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("IPv4.of(\"");
        String _ipv4 = ip.getIpv4();
        _builder_2.append(_ipv4);
        _builder_2.append("\")");
        return _builder_2;
      }
    }
  }

  public CharSequence compileNetwork(final EFNetworkConstant network) {
    String _rawip = network.getNetwork().getRawip();
    boolean _tripleNotEquals = (_rawip != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new Network(IPv4.of(\"");
      String _rawip_1 = network.getNetwork().getRawip();
      _builder.append(_rawip_1);
      _builder.append("\"), ");
      int _rawnetmask = network.getNetwork().getRawnetmask();
      _builder.append(_rawnetmask);
      _builder.append(")");
      return _builder;
    }
    return "null";
  }

  public CharSequence compilePort(final EFNetportConstant port) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("NetPort.of(");
    int _netport = port.getNetport();
    _builder.append(_netport);
    _builder.append(")");
    return _builder;
  }

  public void generateMainClass(final EFFirewall firewall, final String packageName, final Iterable<EFRule> rules, final IFileSystemAccess2 fsa) {
    final String className = firewall.getName();
    String _replace = packageName.replace(".", "/");
    String _plus = (_replace + "/");
    String _plus_1 = (_plus + className);
    final String filePath = (_plus_1 + ".java");
    fsa.generateFile(filePath, this.compileMainClass(firewall, packageName, rules));
  }

  public CharSequence compileMainClass(final EFFirewall firewall, final String packageName, final Iterable<EFRule> rules) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import firewall.NativeBridge;");
    _builder.newLine();
    _builder.append("import rules.Rule;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generated Firewall Main: ");
    String _name = firewall.getName();
    _builder.append(_name, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* Default Policy: ");
    Object _elvis = null;
    EFDefaultPolicy _defaultPolicy = firewall.getDefaultPolicy();
    EFDefaultAction _action = null;
    if (_defaultPolicy!=null) {
      _action=_defaultPolicy.getAction();
    }
    if (_action != null) {
      _elvis = _action;
    } else {
      _elvis = "DENY";
    }
    _builder.append(((Object)_elvis), " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = firewall.getName();
    _builder.append(_name_1);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("System.out.println(\"=================================\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("System.out.println(\"  ");
    String _name_2 = firewall.getName();
    _builder.append(_name_2, "        ");
    _builder.append(" Starting\");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("System.out.println(\"  Default Policy: ");
    Object _elvis_1 = null;
    EFDefaultPolicy _defaultPolicy_1 = firewall.getDefaultPolicy();
    EFDefaultAction _action_1 = null;
    if (_defaultPolicy_1!=null) {
      _action_1=_defaultPolicy_1.getAction();
    }
    if (_action_1 != null) {
      _elvis_1 = _action_1;
    } else {
      _elvis_1 = "DENY";
    }
    _builder.append(((Object)_elvis_1), "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("System.out.println(\"=================================\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("List<Rule> rules = new ArrayList<>();");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// Add generated rules");
    _builder.newLine();
    {
      EList<EFRuleReference> _ruleRefs = firewall.getRuleRefs();
      for(final EFRuleReference ruleRef : _ruleRefs) {
        _builder.append("        ");
        _builder.append("rules.add(new ");
        String _name_3 = ruleRef.getRule().getName();
        _builder.append(_name_3, "        ");
        _builder.append("());");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append("System.out.println(\"Loaded rule: ");
        String _name_4 = ruleRef.getRule().getName();
        _builder.append(_name_4, "        ");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("System.out.println(\"Total rules loaded: \" + rules.size());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("System.out.println(\"=================================\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// Start firewall with native bridge");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("new NativeBridge(rules).startFirewall();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public EFField findFieldByName(final EFRuleClass rule, final String name) {
    EList<EFMember> _members = rule.getMembers();
    for (final EFMember member : _members) {
      if ((member instanceof EFField)) {
        final EFField field = ((EFField) member);
        boolean _equalsIgnoreCase = field.getName().equalsIgnoreCase(name);
        if (_equalsIgnoreCase) {
          return field;
        }
      }
    }
    return null;
  }
}
