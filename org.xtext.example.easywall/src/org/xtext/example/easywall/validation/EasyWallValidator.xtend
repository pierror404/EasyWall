package org.xtext.example.easywall.validation;

import org.eclipse.xtext.validation.Check
import org.xtext.example.easywall.easyWall.EFAllow
import org.xtext.example.easywall.easyWall.EFApplicationProtocolConstant
import org.xtext.example.easywall.easyWall.EFBuiltinFunction
import org.xtext.example.easywall.easyWall.EFField
import org.xtext.example.easywall.easyWall.EFIPv4Constant
import org.xtext.example.easywall.easyWall.EFMember
import org.xtext.example.easywall.easyWall.EFMethod
import org.xtext.example.easywall.easyWall.EFNetportConstant
import org.xtext.example.easywall.easyWall.EFNetworkConstant
import org.xtext.example.easywall.easyWall.EFNetworkProtocolConstant
import org.xtext.example.easywall.easyWall.EFRuleClass
import org.xtext.example.easywall.easyWall.EFRulesTypes
import org.xtext.example.easywall.easyWall.EFTransportProtocolConstant
import org.xtext.example.easywall.easyWall.EFWriteLog
import org.xtext.example.easywall.easyWall.EasyWallPackage
import org.xtext.example.easywall.easyWall.EFDeny
import org.xtext.example.easywall.easyWall.EFBlock
import org.xtext.example.easywall.easyWall.EFStatement
import org.xtext.example.easywall.easyWall.EFExpression
import org.eclipse.emf.ecore.EObject
import org.xtext.example.easywall.easyWall.EFIfStatement
import org.xtext.example.easywall.easyWall.EFReturn
import org.xtext.example.easywall.easyWall.EFIntConstant
import org.xtext.example.easywall.easyWall.EFStringConstant
import org.xtext.example.easywall.easyWall.EFBoolConstant
import org.xtext.example.easywall.easyWall.EFSymbolRef
import org.xtext.example.easywall.easyWall.EFAddExpression
import org.xtext.example.easywall.easyWall.EFEqualExpression
import org.xtext.example.easywall.easyWall.EFRelExpression
import org.xtext.example.easywall.easyWall.EFAndExpression
import org.xtext.example.easywall.easyWall.EFOrExpression
import org.xtext.example.easywall.easyWall.EFAssignment
import org.xtext.example.easywall.easyWall.EFDirectionConstant

class EasyWallValidator extends AbstractEasyWallValidator {
    
    // Error codes
    public static final String INVALID_IPV4_OCTET = "invalidIPv4Octet";
    public static final String INVALID_CIDR_PREFIX = "invalidCIDRPrefix";
    public static final String INVALID_PORT = "invalidPort";
    public static final String MISSING_MANDATORY_FIELD_DIRECTION = "missingMandatoryFieldDirection";
	public static final String MISSING_MANDATORY_FIELD_PROTOCOL = "missingMandatoryFieldProtocol";
    public static final String MISSING_TRIGGER_METHOD = "missingTriggerMethod";
    public static final String BUILTIN_OUTSIDE_TRIGGER = "builtinOutsideTrigger";
    public static final String UNREACHABLE_CODE = "unreachableCode";
    
    // Warning codes
    public static final String DESTINATION_FIELD = "destinationField";
    public static final String SOURCE_FIELD = "sourceField";
    
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
                MISSING_MANDATORY_FIELD_PROTOCOL
            );
        }
        
        if (!hasDirection) {
            error(
                "Rule must define a 'rule_direction' field",
                rule,
                EasyWallPackage.Literals.EF_RULE_CLASS__NAME,
                MISSING_MANDATORY_FIELD_DIRECTION
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
        if (builtin instanceof EFDeny) return "drop()";
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
    
    @Check
	def void checkUnreachableCode(EFBlock block) {
	    var boolean foundTerminal = false
	    
	    for (EFStatement stmt : block.getStatements()) {
	        
	        if (foundTerminal) {
	            error(
	                "Unreachable code after allow()/deny()",
	                stmt,
	                null,
	                UNREACHABLE_CODE
	            )
	            return
	        }
	        
	        if (isTerminalStatement(stmt)) {
	            foundTerminal = true
	        }
	    }
	}
	
	
	@Check
    def void checkWarningFields(EFRuleClass rule) {
    	
    		var possibleDestinationNames = newHashSet("d", "dest", "ruleDestination", "dst", "destination");
    		var possibleSourceNames = newHashSet("src", "source", "ruleSource", "s", "sour")
    		for (EFMember member : rule.getMembers()) {
            if (member instanceof EFField) {
                var field = member as EFField;
                var String fieldName = field.getName().toLowerCase();
                
                if (possibleDestinationNames.contains(fieldName)) {
                    warning(
	                		"To be compiled, destination field must be: rule_dest (if you want to specify the port you must also write rule_dest_port)",
	                		field,
	                		EasyWallPackage.Literals.EF_MEMBER__NAME,
	                		DESTINATION_FIELD
	            		)
                }
                if (possibleSourceNames.contains(fieldName)) {
                    warning(
	                		"To be compiled source field must be: rule_src (if you want to specify the port you must also write rule_src_port)",
	                		field,
	                		EasyWallPackage.Literals.EF_MEMBER__NAME,
	                		SOURCE_FIELD
	            		)
                }
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
    
    	def boolean isTerminalStatement(EFStatement stmt) {
    
	    // Caso: expression;
	    if (stmt instanceof org.xtext.example.easywall.easyWall.EFExpression) {
	        val expr = stmt as org.xtext.example.easywall.easyWall.EFExpression
	        return containsTerminal(expr)
	    }
	    
	    // Caso: return ... (opzionale, ma utile)
	    if (stmt instanceof EFReturn) {
	        return true
	    }
	    
	    // Caso: if (...) { ... }
	    if (stmt instanceof EFIfStatement) {
	        val ifStmt = stmt as EFIfStatement
	        
	        // Se entrambi i rami sono terminali → anche questo è terminale
	        return isBlockTerminal(ifStmt.thenBlock) &&
	               (ifStmt.elseBlock !== null && isBlockTerminal(ifStmt.elseBlock))
	    }
	    
	    return false
	}
	
	def boolean containsTerminal(EFExpression expr) {
    
	    if (expr instanceof EFAllow || expr instanceof EFDeny) {
	        return true
	    }
	    
	    // Naviga figli (AST generico EMF)
	    for (EObject child : expr.eContents()) {
	        if (child instanceof EFExpression) {
	            if (containsTerminal(child as EFExpression)) {
	                return true
	            }
	        }
	    }
	    
	    return false
	}
	
	def boolean isBlockTerminal(EFBlock block) {
	    for (stmt : block.getStatements()) {
	        if (isTerminalStatement(stmt)) {
	            return true
	        }
	    }
	    return false
	}
	
	
	/*
	 * ==================
	 * TYPE CHECKER
	 * ==================
	 */
	def dispatch String typeOf(EFExpression e) {
    		"Object"
	} 
	def dispatch String typeOf(EFIntConstant e) {
	    "long"
	}
	
	def dispatch String typeOf(EFStringConstant e) {
	    "String"
	}
	
	def dispatch String typeOf(EFBoolConstant e) {
	    "boolean"
	}
	def dispatch String typeOf(EFNetworkConstant e) {
	    "Network"
	}
	def dispatch String typeOf(EFNetworkProtocolConstant e){
		"IProtocol"
	}
	def dispatch String typeOf(EFTransportProtocolConstant e){
		"IProtocol"
	}
	def dispatch String typeOf(EFApplicationProtocolConstant e){
		"IProtocol"
	}
	def dispatch String typeOf(EFDirectionConstant e) {
		"Direction"
	}
	def dispatch String typeOf(EFIPv4Constant e) {
	    "IPv4"
	}
	
	def dispatch String typeOf(EFNetportConstant e) {
	    "NetPort"
	}
	def dispatch String typeOf(EFSymbolRef e) {
	    
	    val obj = e.symbol   // <-- QUESTO deve essere risolto dallo scope
	
	    if (obj instanceof EFField) {
	        return declaredType(obj)
	    }
	
	    return "Object"
		}
	
	def dispatch String typeOf(EFAddExpression e) {
	    val l = typeOf(e.left)
	    val r = typeOf(e.right)
	
	    if (l == "long" && r == "long")
	        return "long"
	
	    return "Object"
	}
	def dispatch String typeOf(EFEqualExpression e) {
	    "boolean"
	}
	
	def dispatch String typeOf(EFRelExpression e) {
	    "boolean"
	}
	
	def dispatch String typeOf(EFAndExpression e) {
	    "boolean"
	}
	
	def dispatch String typeOf(EFOrExpression e) {
	    "boolean"
	}
	def String declaredType(EFField f) {
	    switch f.type {
	        case INT: "long"
	        case STRING: "String"
	        case BOOL: "boolean"
	
	        case NETWORK: "Network"
	        case IPV4: "IPv4"
	        case IPV6: "IPv6"
	        case PORT: "NetPort"
	        case PROTOCOL: "IProtocol"
	        case DIRECTION: "Direction"
	
	        default: "Object"
	    }
	}
	@Check
	def checkAssignment(EFAssignment e) {
	
	    val leftType = typeOf(e.left)
	    val rightType = typeOf(e.right)
	
	    if (leftType != rightType && rightType != "Object") {
	        error(
	            "Type mismatch: cannot assign " + rightType + " to " + leftType,
	            e,
	            null
	        )
	    }
	}
	@Check
	def checkFieldInit(EFField f) {
	    if (f.expression !== null) {
	        val declared = declaredType(f)
	        val actual = typeOf(f.expression)
	
	        if (declared != actual && actual != "Object") {
	            error(
	                "Invalid initialization: expected " + declared + " but got " + actual,
	                f,
	                null
	            )
	        }
	    }
	}
	@Check
	def checkReturn(EFReturn r) {
	    val method = r.eContainer as EFMethod
	
	    val expected = method.nativetype?.toString
	        ?: "void"
	
	    val actual = typeOf(r.expression)
	
	    if (expected != actual && expected != "void") {
	        error(
	            "Return type mismatch: expected " + expected + " but got " + actual,
	            r,
	            null
	        )
	    }
	}
	@Check
	def checkIfCondition(EFIfStatement i) {
	    val condType = typeOf(i.expression)
	
	    if (condType != "boolean") {
	        error(
	            "If condition must be boolean but was " + condType,
	            i,
	            null
	        )
	    }
	}
	
	@Check
	def checkField(EFField f) {
	
	    if (f.expression !== null) {
	
	        val declared = declaredType(f)
	        val actual = typeOf(f.expression)
	
	        if (declared != actual) {
	            error(
	                "Type mismatch: cannot assign " + actual + " to " + declared,
	                f,
	                null
	            )
	        }
	    }
	}
}