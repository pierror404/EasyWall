package org.xtext.example.easywall.validation;

import org.eclipse.xtext.validation.Check
import org.xtext.example.easywall.easyWall.EFAllow
import org.xtext.example.easywall.easyWall.EFApplicationProtocolConstant
import org.xtext.example.easywall.easyWall.EFBlock
import org.xtext.example.easywall.easyWall.EFBuiltinFunction
import org.xtext.example.easywall.easyWall.EFDrop
import org.xtext.example.easywall.easyWall.EFField
import org.xtext.example.easywall.easyWall.EFIPv4Constant
import org.xtext.example.easywall.easyWall.EFMember
import org.xtext.example.easywall.easyWall.EFMethod
import org.xtext.example.easywall.easyWall.EFNetportConstant
import org.xtext.example.easywall.easyWall.EFNetworkConstant
import org.xtext.example.easywall.easyWall.EFNetworkProtocolConstant
import org.xtext.example.easywall.easyWall.EFReject
import org.xtext.example.easywall.easyWall.EFRuleClass
import org.xtext.example.easywall.easyWall.EFRulesTypes
import org.xtext.example.easywall.easyWall.EFTransportProtocolConstant
import org.xtext.example.easywall.easyWall.EFWriteLog
import org.xtext.example.easywall.easyWall.EasyWallPackage

class EasyWallValidator extends AbstractEasyWallValidator {
    
    // Error codes
    public static final String INVALID_IPV4_OCTET = "invalidIPv4Octet";
    public static final String INVALID_CIDR_PREFIX = "invalidCIDRPrefix";
    public static final String INVALID_PORT = "invalidPort";
    public static final String MISSING_MANDATORY_FIELD = "missingMandatoryField";
    public static final String MISSING_TRIGGER_METHOD = "missingTriggerMethod";
    public static final String BUILTIN_OUTSIDE_TRIGGER = "builtinOutsideTrigger";
    
    // ============================================
    // IPv4 Validation
    // ============================================
    @Check
    def void checkIPv4Format(EFIPv4Constant ip) {
        // Skip 'any' e 'localhost'
        if (ip.getAny() !== null || ip.getLocalhost() !== null) {
            return;
        }
        var first = Integer.parseInt(ip.ipv4.split("\\.").get(0));
        var second = Integer.parseInt(ip.ipv4.split("\\.").get(1));
        var third = Integer.parseInt(ip.ipv4.split("\\.").get(2));
        var fourth = Integer.parseInt(ip.ipv4.split("\\.").get(3));
        val int[] octets = #[first,second,third,fourth];
        
        for (var i = 0; i < 4; i++) {
            if (octets.get(i) < 0 || octets.get(i) > 255) {
                error(
                    "IPv4 octet must be between 0 and 255, got: " + octets.get(i),
                    ip,
                    EasyWallPackage.Literals.EFI_PV4_CONSTANT__IPV4,
                    INVALID_IPV4_OCTET
                );
            }
        }
    }
    
    // ============================================
    // CIDR Prefix Validation
    // ============================================
    @Check
    def void checkCIDRPrefix(EFNetworkConstant network) {
        // Controlla solo se è raw netmask (INT)
        if (network.getRawnetmask() != 0) {
            val int prefix = network.getRawnetmask();
            if (prefix < 0 || prefix > 32) {
                error(
                    "CIDR prefix must be between 0 and 32, got: " + prefix,
                    network,
                    EasyWallPackage.Literals.EF_NETWORK_CONSTANT__RAWNETMASK,
                    INVALID_CIDR_PREFIX
                );
            }
        }
    }
    
    // ============================================
    // Port Validation
    // ============================================
    @Check
    def void checkPortRange(EFNetportConstant port) {
        val int portNum = port.getNetport();
        if (portNum < 1 || portNum > 65535) {
            error(
                "Port number must be between 1 and 65535, got: " + portNum,
                port,
                EasyWallPackage.Literals.EF_NETPORT_CONSTANT__NETPORT,
                INVALID_PORT
            );
        }
    }
    
    // ============================================
    // Mandatory Fields per Rule
    // ============================================
    @Check
    def void checkMandatoryFields(EFRuleClass rule) {
        var boolean hasProtocol = false;
        var boolean hasDirection = false;
        
        for (EFMember member : rule.getMembers()) {
            if (member instanceof EFField) {
                var field = member as EFField;
                var String fieldName = field.getName().toLowerCase();
                
                if (fieldName.equals("rule_protocol")) {
                    hasProtocol = true;
                }
                if (fieldName.equals("rule_direction")) {
                    hasDirection = true;
                }
            }
        }
        
        if (!hasProtocol) {
            error(
                "Rule must define a 'rule_protocol' field",
                rule,
                EasyWallPackage.Literals.EF_RULE_CLASS__NAME,
                MISSING_MANDATORY_FIELD
            );
        }
        
        if (!hasDirection) {
            error(
                "Rule must define a 'rule_direction' field",
                rule,
                EasyWallPackage.Literals.EF_RULE_CLASS__NAME,
                MISSING_MANDATORY_FIELD
            );
        }
    }
    
    // ============================================
    // Trigger Method Presence if not present it will show a warning but default policy will be applied
    // ============================================
    @Check
    def void checkTriggerMethod(EFRuleClass rule) {
        var boolean hasTrigger = false;
        
        for (EFMember member : rule.getMembers()) {
            if (member instanceof EFMethod) {
                var method = member as EFMethod;
                if (method.getName().equals("trigger")) {
                    hasTrigger = true;
                    
                    // Verifica signature: void trigger()
                    if (!method.getParams().isEmpty()) {
                        warning(
                            "trigger() method should not have parameters",
                            method,
                            EasyWallPackage.Literals.EF_METHOD__PARAMS
                        );
                    }
                    
                    return;
                }
            }
        }       
        if (!hasTrigger) {
            warning(
                "Rule should define a 'trigger()' method (otherwise default policy will be applied)",
                rule,
                EasyWallPackage.Literals.EF_RULE_CLASS__NAME,
                MISSING_TRIGGER_METHOD
            );
        }
    }
    
    // ============================================
    // Built-in Functions Only in Trigger
    // ============================================
    @Check
    def void checkBuiltinInTrigger(EFBuiltinFunction builtin) {
        // Naviga l'albero AST verso l'alto per trovare il metodo contenitore
        var container = builtin.eContainer();
        while (container !== null) {
            if (container instanceof EFMethod) {
                var method = container as EFMethod;
                if (!method.getName().equals("trigger")) {
                    error(
                        "Built-in function '" + getBuiltinName(builtin) + 
                        "' can only be used inside trigger() method",
                        builtin,
                        null,
                        BUILTIN_OUTSIDE_TRIGGER
                    );
                }
                return;
            }
            container = container.eContainer();
        }
        
        // Se arriviamo qui, la built-in non è in un metodo
        error(
            "Built-in function can only be used inside trigger() method",
            builtin,
            null,
            BUILTIN_OUTSIDE_TRIGGER
        );
    }
    
    def String getBuiltinName(EFBuiltinFunction builtin) {
        if (builtin instanceof EFAllow) return "allow()";
        if (builtin instanceof EFBlock) return "block()";
        if (builtin instanceof EFDrop) return "drop()";
        if (builtin instanceof EFReject) return "reject()";
        if (builtin instanceof EFWriteLog) return "writelog()";
        return "unknown";
    }
    
    // ============================================
    // Protocol/Layer Compatibility
    // ============================================
    @Check
    def void checkProtocolLayerCompatibility(EFRuleClass rule) {
        var EFRulesTypes layer = rule.getType();
        
        // Trova il field protocol
        var EFField protocolField = findFieldByName(rule, "rule_protocol");
        if (protocolField === null) return; // già segnalato da checkMandatoryFields
        
        // Estrai il valore del protocol
        if (protocolField.getExpression() instanceof EFNetworkProtocolConstant) {
            if (layer != EFRulesTypes.IPLEVEL) {
                error(
                    "Network layer protocols can only be used in NetworkLayer rules",
                    protocolField,
                    EasyWallPackage.Literals.EF_FIELD__EXPRESSION
                );
            }
        } else if (protocolField.getExpression() instanceof EFTransportProtocolConstant) {
            if (layer != EFRulesTypes.TRANSPLEVEL) {
                error(
                    "Transport layer protocols can only be used in TransportLayer rules",
                    protocolField,
                    EasyWallPackage.Literals.EF_FIELD__EXPRESSION
                );
            }
        } else if (protocolField.getExpression() instanceof EFApplicationProtocolConstant) {
            if (layer != EFRulesTypes.APPLEVEL) {
                error(
                    "Application layer protocols can only be used in ApplicationLayer rules",
                    protocolField,
                    EasyWallPackage.Literals.EF_FIELD__EXPRESSION
                );
            }
        }
    }
    
    // ============================================
    // Helper Methods
    // ============================================
    def EFField findFieldByName(EFRuleClass rule, String name) {
        for (EFMember member : rule.getMembers()) {
            if (member instanceof EFField) {
                var field = member as EFField;
                if (field.getName().equalsIgnoreCase(name)) {
                    return field;
                }
            }
        }
        return null;
    }
}