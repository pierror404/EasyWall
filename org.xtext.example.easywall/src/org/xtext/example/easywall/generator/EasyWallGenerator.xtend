package org.xtext.example.easywall.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.easywall.easyWall.EFAddExpression
import org.xtext.example.easywall.easyWall.EFAllow
import org.xtext.example.easywall.easyWall.EFAndExpression
import org.xtext.example.easywall.easyWall.EFApplicationProtocolConstant
import org.xtext.example.easywall.easyWall.EFAssignment
import org.xtext.example.easywall.easyWall.EFBlock
import org.xtext.example.easywall.easyWall.EFBoolConstant
import org.xtext.example.easywall.easyWall.EFBracketsExpression
import org.xtext.example.easywall.easyWall.EFDirectionConstant
import org.xtext.example.easywall.easyWall.EFEqualExpression
import org.xtext.example.easywall.easyWall.EFExpression
import org.xtext.example.easywall.easyWall.EFField
import org.xtext.example.easywall.easyWall.EFFirewall
import org.xtext.example.easywall.easyWall.EFFunctionCall
import org.xtext.example.easywall.easyWall.EFGetPacketField
import org.xtext.example.easywall.easyWall.EFGetTime
import org.xtext.example.easywall.easyWall.EFIPv4Constant
import org.xtext.example.easywall.easyWall.EFIfStatement
import org.xtext.example.easywall.easyWall.EFIntConstant
import org.xtext.example.easywall.easyWall.EFMemberSelection
import org.xtext.example.easywall.easyWall.EFMethod
import org.xtext.example.easywall.easyWall.EFMultExpression
import org.xtext.example.easywall.easyWall.EFNetportConstant
import org.xtext.example.easywall.easyWall.EFNetworkConstant
import org.xtext.example.easywall.easyWall.EFNetworkProtocolConstant
import org.xtext.example.easywall.easyWall.EFNotExpression
import org.xtext.example.easywall.easyWall.EFOrExpression
import org.xtext.example.easywall.easyWall.EFParameter
import org.xtext.example.easywall.easyWall.EFProgram
import org.xtext.example.easywall.easyWall.EFRelExpression
import org.xtext.example.easywall.easyWall.EFReturn
import org.xtext.example.easywall.easyWall.EFRule
import org.xtext.example.easywall.easyWall.EFRuleClass
import org.xtext.example.easywall.easyWall.EFRulesTypes
import org.xtext.example.easywall.easyWall.EFStatement
import org.xtext.example.easywall.easyWall.EFStringConstant
import org.xtext.example.easywall.easyWall.EFSymbolRef
import org.xtext.example.easywall.easyWall.EFTransportProtocolConstant
import org.xtext.example.easywall.easyWall.EFWriteLog
import org.xtext.example.easywall.easyWall.EFWriteLogLevel

/**
 * Code Generator per EasyWall DSL
 * Genera classi Java che estendono Rule per java-firewall
 */
class EasyWallGenerator extends AbstractGenerator {

    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        
        val program = resource.allContents.head as EFProgram
        
        // Determina package name
        val packageName = if (program.header?.name !== null) {
            program.header.name
        } else {
            "generated.rules"
        }
        
        // Genera le regole
        for (rule : program.rules) {
            generateRuleClass(rule.rules, packageName, fsa)
        }
        
        // Genera Main class con firewall se presente
        if (program.firewall !== null) {
            generateMainClass(program.firewall, packageName, program.rules, fsa)
        }
    }
    
    // ============================================
    // Genera Classe Rule
    // ============================================
    def void generateRuleClass(EFRuleClass rule, String packageName, IFileSystemAccess2 fsa) {
        val className = rule.name.toFirstUpper
        val filePath = packageName.replace('.', '/') + '/' + className + '.java'
        
        fsa.generateFile(filePath, rule.compileRuleClass(packageName))
    }
    
    def CharSequence compileRuleClass(EFRuleClass rule, String packageName) '''
        package «packageName»;
        
        import rules.*;
        import elements.*;
        import java.util.Optional;
        
        /**
         * Generated EasyWall Rule: «rule.name»
         * Layer: «rule.type»
         */
        public class «rule.name» extends Rule {
            
            // ============================================
            // Custom Fields
            // ============================================
            «FOR field : rule.members.filter(EFField).filter[!isConfigField(it)]»
            «compileField(field)»
            «ENDFOR»
            
            // ============================================
            // Constructor
            // ============================================
            public «rule.name»() {
                super(
                    «compileLayer(rule.type)»,
                    «compileProtocolField(rule)»,
                    «compileSourceEndpoint(rule)»,
                    «compileDestinationEndpoint(rule)»,
                    «compileDirectionField(rule)»,
                    Action.ALLOW  // Default, will be overridden by trigger
                );
            }
            
            // ============================================
            // Trigger Method Override
            // ============================================
            «val triggerMethod = rule.members.filter(EFMethod).findFirst[name == "trigger"]»
            «IF triggerMethod !== null»
            @Override
            public Action trigger(MyPacket packet) {
                «FOR stmt : triggerMethod.body.statements»
                «compileStatementInFunc(stmt)»
                «ENDFOR»
            }
            «ENDIF»
            
            // ============================================
            // Helper Methods
            // ============================================
            «FOR method : rule.members.filter(EFMethod).filter[name != "trigger"]»
            «compileMethod(method)»
            «ENDFOR»
        }
    '''
    
    // ============================================
    // Compila Configuration Fields
    // ============================================
    def boolean isConfigField(EFField field) {
        val name = field.name.toLowerCase
        return name == "rule_protocol" || name == "rule_direction" || 
               name == "source" || name == "destination"
    }
    
    def CharSequence compileLayer(EFRulesTypes type) {
        switch type {
            case IPLEVEL: "Layer.NETWORK"
            case TRANSPLEVEL: "Layer.TRANSPORT"
            case APPLEVEL: "Layer.APPLICATION"
            default: "Layer.NETWORK"
        }
    }
    
    def CharSequence compileProtocolField(EFRuleClass rule) {
        val protocolField = findFieldByName(rule, "rule_protocol")
        if (protocolField?.expression !== null) {
            return compileProtocolExpression(protocolField.expression)
        }
        return "null"
    }
    
    def CharSequence compileProtocolExpression(EFExpression expr) {
        switch expr {
            EFNetworkProtocolConstant: '''NetworkLayerProtocol.«expr.protocol»'''
            EFTransportProtocolConstant: '''TransportLayerProtocol.«expr.protocol»'''
            EFApplicationProtocolConstant: '''ApplicationLayerProtocol.«expr.protocol»'''
            default: "null"
        }
    }
    
    def CharSequence compileDirectionField(EFRuleClass rule) {
        val dirField = findFieldByName(rule, "rule_direction")
        if (dirField?.expression !== null) {
            return compileDirection(dirField.expression)
        }
        return "Direction.IN"
    }
    
    def CharSequence compileDirection(EFExpression expr) {
        if (expr instanceof EFDirectionConstant) {
            switch expr.direction {
                case IN: "Direction.IN"
                case OUT: "Direction.OUT"
                case FORWARD: "Direction.FORWARD"
                default: "Direction.IN"
            }
        } else {
            return "Direction.IN"
        }
    }
    
	def CharSequence compileSourceEndpoint(EFRuleClass rule) {
	    val srcField = findFieldByName(rule, "rule_src")
	    val srcPortField = findFieldByName(rule, "rule_src_port")
	    
	    return compileEndpointCombined(srcField, srcPortField)
	}
	
	def CharSequence compileDestinationEndpoint(EFRuleClass rule) {
	    val destField = findFieldByName(rule, "rule_dest")
	    val destPortField = findFieldByName(rule, "rule_dest_port")
	    
	    return compileEndpointCombined(destField, destPortField)
	}
	
	/**
	 * Combina IP/Network e Porta in un singolo Endpoint
	 */
	def CharSequence compileEndpointCombined(EFField ipField, EFField portField) {
	    val hasIp = ipField?.expression !== null
	    val hasPort = portField?.expression !== null
	    
	    // Compila i componenti
	    val ipPart = if (hasIp) compileEndpointIP(ipField.expression) else "Optional.empty()"
	    val networkPart = if (hasIp) compileEndpointNetwork(ipField.expression) else "Optional.empty()"
	    val portPart = if (hasPort) compileEndpointPort(portField.expression) else "Optional.empty()"
	    
	    return '''new Endpoint(«ipPart», «networkPart», «portPart»)'''
	}
	
	/**
	 * Compila solo la parte IP dell'endpoint
	 */
	def String compileEndpointIP(EFExpression expr) {
	    switch expr {
	        EFIPv4Constant: '''Optional.of(«compileIPv4(expr)»)'''
	        EFSymbolRef: '''Optional.ofNullable(«expr.symbol»)'''
	        default: "Optional.empty()"
	    }
	}
	
	/**
	 * Compila solo la parte Network dell'endpoint
	 */
	def String compileEndpointNetwork(EFExpression expr) {
	    switch expr {
	        EFNetworkConstant: '''Optional.of(«compileNetwork(expr)»)'''
	        default: "Optional.empty()"
	    }
	}
	
	/**
	 * Compila solo la parte Porta dell'endpoint
	 */
	def String compileEndpointPort(EFExpression expr) {
	    switch expr {
	        EFNetportConstant: '''Optional.of(«compilePort(expr)»)'''
	        EFSymbolRef: '''Optional.ofNullable(«expr.symbol»)'''
	        default: "Optional.empty()"
	    }
	}
    
    // ============================================
    // Compila Field
    // ============================================
    def CharSequence compileField(EFField field) {
        val modifier = if (field.eContainmentFeature.name.contains("set")) "private final" else "private"
        val type = getJavaType(field)
        val init = if (field.expression !== null) {
            " = " + compileExpression(field.expression)
        } else {
            getDefaultValue(field)
        }
        
        '''«modifier» «type» «field.name»«init»;'''
    }
    
    def CharSequence compileFieldInFunc(EFField field) {
        val type = getJavaType(field)
        val init = if (field.expression !== null) {
            " = " + compileExpression(field.expression)
        } else {
            getDefaultValue(field)
        }
        
        '''«type» «field.name»«init»;'''
    }
    
    def String getJavaType(EFField field) {
    		if (field.primitivetype !== null) {
            return switch field.primitivetype {
                case INT: "long"
                case STRING: "String"
                case BOOL: "boolean"
                default: "Object"
            }
        } else if (field.nativetype !== null) {
            return switch field.nativetype {
                case NETWORK: "Network"
                case IPV4: "IPv4"
                case IPV6: "IPv6"
                case PORT: "NetPort"
                case PROTOCOL: "IProtocol"
                case DIRECTION: "Direction"
                case NETMASK: "int"
                default: "Object"
            }
        } 
        return "Object"
    }
    
    def String getDefaultValue(EFField field) {
        if (field.primitivetype !== null) {
            return switch field.primitivetype {
                case INT: " = 0"
                case STRING: " = \"\""
                case BOOL: " = false"
                default: ""
            }
        }
        return ""
    }
    
    // ============================================
    // Compila Method
    // ============================================
    def CharSequence compileMethod(EFMethod method) {
        val returnType = getMethodReturnType(method)
        val params = compileParameters(method.params)
        
        '''
        private «returnType» «method.name»(«params») {
            «FOR stmt : method.body.statements»
            «compileStatement(stmt)»
            «ENDFOR»
        }
        '''
    }
    
    def String getMethodReturnType(EFMethod method) {
        if (method.void !== null) return "void"
        if (method.primitivetype !== null) {
            return switch method.primitivetype {
                case INT: "int"
                case STRING: "String"
                case BOOL: "boolean"
                default: "Object"
            }
        }
        return "void"
    }
    
    def String compileParameters(Iterable<EFParameter> params) {
        params.map[p | getJavaType(p as EFField) + " " + p.name].join(", ")
    }
    
    // ============================================
    // Compila Statement
    // ============================================
    def CharSequence compileStatement(EFStatement stmt) {
        switch stmt {
            EFField: compileField(stmt) + "\n"
            EFReturn: '''return «compileExpression(stmt.expression)»;'''
            EFIfStatement: compileIfStatement(stmt)
            EFExpression: compileExpression(stmt) + ";"
            default: "// Unknown statement"
        }
    }
    
    def CharSequence compileStatementInFunc(EFStatement stmt) {
        switch stmt {
            EFField: compileFieldInFunc(stmt) + "\n"
            EFReturn: '''return «compileExpression(stmt.expression)»;'''
            EFIfStatement: compileIfStatement(stmt)
            EFExpression: compileExpression(stmt) + ";"
            default: "// Unknown statement"
        }
    }
    
    def CharSequence compileIfStatement(EFIfStatement ifStmt) '''
        if («compileExpression(ifStmt.expression)») {
            «FOR stmt : ifStmt.thenBlock.statements»
            «compileStatement(stmt)»
            «ENDFOR»
        }«IF ifStmt.elseBlock !== null» else {
            «FOR stmt : ifStmt.elseBlock.statements»
            «compileStatement(stmt)»
            «ENDFOR»
        }«ENDIF»
    '''
    
    // ============================================
    // Compila Expression (CORRETTO - senza .op)
    // ============================================
    def String compileExpression(EFExpression expr) {
        switch expr {
            EFStringConstant: '''"«expr.value»"'''
            EFIntConstant: expr.value.toString
            EFBoolConstant: expr.value
            EFAssignment: '''«compileExpression(expr.left)» = «compileExpression(expr.right)»'''
            EFOrExpression: '''«compileExpression(expr.left)» || «compileExpression(expr.right)»'''
            EFAndExpression: '''«compileExpression(expr.left)» && «compileExpression(expr.right)»'''
            EFEqualExpression: compileEqualExpression(expr)
            EFRelExpression: compileRelExpression(expr)
            EFAddExpression: compileAddExpression(expr)
            EFMultExpression: compileMultExpression(expr)
            EFNotExpression: "!" + compileExpression(expr.expression)
            EFSymbolRef: expr.symbol
            EFFunctionCall: compileFunctionCall(expr)
            EFMemberSelection: compileMemberSelection(expr)
            EFIPv4Constant: compileIPv4(expr).toString
            EFNetworkConstant: compileNetwork(expr).toString
            EFNetportConstant: compilePort(expr).toString
            EFDirectionConstant: compileDirection(expr).toString
            EFNetworkProtocolConstant: compileProtocolExpression(expr).toString
            EFTransportProtocolConstant: compileProtocolExpression(expr).toString
            EFApplicationProtocolConstant: compileProtocolExpression(expr).toString
            EFBracketsExpression: "(" + compileExpression(expr.expression) + ")"
            
            // Built-in functions
            EFAllow: "return Action.ALLOW"
            EFBlock: "return Action.DENY"
            EFWriteLog: '''logger.Logger.writeOnLogFile(packet, "firewall-log.txt", logger.LogLevel.INFO,«compileExpression(expr.message)»)'''
            EFWriteLogLevel: '''logger.Logger.writeOnLogFile(packet, "firewall-log.txt", logger.LogLevel«expr.level»,«compileExpression(expr.message)»)'''
            EFGetTime: "System.currentTimeMillis() / 1000"
            EFGetPacketField: compileGetPacketField(expr)
            
            default: "/* unknown: " + expr.class.simpleName + " */"
        }
    }
    
    def String compileEqualExpression(EFEqualExpression expr) {
        // Gli operatori sono in EFEqualOperators: '==' | '!=' | 'isequalto'
        // Ma Xtext non genera un campo op, bisogna dedurlo dal tipo di nodo
        // Per ora usiamo == di default
        '''«compileExpression(expr.left)» == «compileExpression(expr.right)»'''
    }
    
    def String compileRelExpression(EFRelExpression expr) {
        // Gli operatori sono in EFRelOperators: '>=' | '<=' | '>' | '<'
        // Usiamo > di default
        '''«compileExpression(expr.left)» > «compileExpression(expr.right)»'''
    }
    
    def String compileAddExpression(EFAddExpression expr) {
        // Gli operatori sono in EFAddOperators: '+' | '-'
        // Usiamo + di default
        '''«compileExpression(expr.left)» + «compileExpression(expr.right)»'''
    }
    
    def String compileMultExpression(EFMultExpression expr) {
        // Gli operatori sono in EFMultOperators: '*' | 'div' | '%'
        // Usiamo * di default
        '''«compileExpression(expr.left)» * «compileExpression(expr.right)»'''
    }
    
    def String compileGetPacketField(EFGetPacketField expr) {
        val field = expr.field
        switch field {
            case "srcip": "packet.sourceAddress().get().toString()"
            case "dstip": "packet.destinationAddress().get().toString()"
            case "srcport": "String.valueOf(packet.sourcePort().orElse(0))"
            case "dstport": "String.valueOf(packet.destinationPort().orElse(0))"
            default: "\"\""
        }
    }
    
    def String compileFunctionCall(EFFunctionCall call) {
        val args = call.args.map[compileExpression(it)].join(", ")
        call.functionName + "(" + args + ")"
    }
    
    def String compileMemberSelection(EFMemberSelection sel) {
        val receiver = compileExpression(sel.receiver)
        val member = sel.member.name
        val args = if (sel.args !== null && !sel.args.empty) {
            "(" + sel.args.map[compileExpression(it)].join(", ") + ")"
        } else {
            ""
        }
        receiver + "." + member + args
    }
    
    def CharSequence compileIPv4(EFIPv4Constant ip) {
        if (ip.any !== null) {
            return '''IPv4.of("0.0.0.0")'''
        } else if (ip.localhost !== null) {
            return '''IPv4.of("127.0.0.1")'''
        } else {
            return '''IPv4.of("«ip.ipv4»")'''
        }
    }
    
    def CharSequence compileNetwork(EFNetworkConstant network) {
        if (network.network.rawip !== null) {
            return '''new Network(IPv4.of("«network.network.rawip»"), «network.network.rawnetmask»)'''
        }
        return "null"
    }
    
    def CharSequence compilePort(EFNetportConstant port) {
        '''NetPort.of(«port.netport»)'''
    }
    
    // ============================================
    // Genera Main Class con Firewall
    // ============================================
    def void generateMainClass(EFFirewall firewall, String packageName, Iterable<EFRule> rules, IFileSystemAccess2 fsa) {
        val className = firewall.name.toFirstUpper
        val filePath = packageName.replace('.', '/') + '/' + className + '.java'
        
        fsa.generateFile(filePath, firewall.compileMainClass(packageName, rules))
    }
    
    def CharSequence compileMainClass(EFFirewall firewall, String packageName, Iterable<EFRule> rules) '''
        package «packageName»;
        
        import java.util.ArrayList;
        import java.util.List;
        import firewall.NativeBridge;
        import rules.Rule;
        
        /**
         * Generated Firewall Main: «firewall.name»
         * Default Policy: «firewall.defaultPolicy?.action ?: "DENY"»
         */
        public class «firewall.name» {
            
            public static void main(String[] args) {
                System.out.println("=================================");
                System.out.println("  «firewall.name» Starting");
                System.out.println("  Default Policy: «firewall.defaultPolicy?.action ?: "DENY"»");
                System.out.println("=================================");
                
                List<Rule> rules = new ArrayList<>();
                
                // Add generated rules
                «FOR ruleRef : firewall.ruleRefs»
                rules.add(new «ruleRef.rule.name»());
                System.out.println("Loaded rule: «ruleRef.rule.name»");
                «ENDFOR»
                
                System.out.println("Total rules loaded: " + rules.size());
                System.out.println("=================================");
                
                // Start firewall with native bridge
                new NativeBridge(rules, Action.«firewall.defaultPolicy?.action.toString.toUpperCase ?: "DENY"»).startFirewall();
            }
        }
    '''
    
    // ============================================
    // Helper Methods
    // ============================================
    def EFField findFieldByName(EFRuleClass rule, String name) {
        for (member : rule.members) {
            if (member instanceof EFField) {
                val field = member as EFField
                if (field.name.equalsIgnoreCase(name)) {
                    return field
                }
            }
        }
        return null
    }
}