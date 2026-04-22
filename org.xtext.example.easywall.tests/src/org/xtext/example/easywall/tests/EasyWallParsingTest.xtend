package org.xtext.example.easywall.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.xtext.example.easywall.easyWall.EFProgram
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith

@ExtendWith(InjectionExtension)
@InjectWith(EasyWallInjectorProvider)
class EasyWallParsingTest {

    @Inject ParseHelper<EFProgram> parser

    // ---------------------------------------
    // HEADER & IMPORTS
    // ---------------------------------------

    @Test
    def void testHeaderOnly() {
        val input = '''pack test;'''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testHeaderWithImports() {
        val input = '''
            pack my.firewall;
            import net.rules.*;
            import other.pkg.*;
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // FIREWALL
    // ---------------------------------------

    @Test
    def void testEmptyFirewall() {
        val input = '''
            firewall FW1 {
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testFirewallWithDefaultPolicy() {
        val input = '''
            firewall FW1 {
                default allow;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testFirewallWithMembers() {
        val input = '''
            firewall FW1 {
                var ip1: netip = 192.168.1.1;
                set mask: netmask = /24;

                fun check():bool {
                    return true;
                }
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // RULES
    // ---------------------------------------

    @Test
    def void testRuleParsing() {
        val input = '''
            rule R1 at NetworkLayer {
                var src: netip = 10.0.0.1;
                var dst: netip = any;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testRuleReference() {
        val input = '''
            firewall FW1 {
                apply my.rules.R1;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // NETWORK SYNTAX
    // ---------------------------------------

    @Test
    def void testIPv4Forms() {
        val input = '''
            firewall FW {
                var a: netip = 192.168.0.1;
                var b: netip = any;
                var c: netip = localhost;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testIPv6() {
        val input = '''
            firewall FW {
                var a: netipv6 = abcd:1234:5678:9abc:def0:1111:2222:3333;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    @Test
    def void testNetworkSyntaxAllForms() {
        val input = '''
            firewall FW {
                var n1: network = ip / mask;
                var n2: network = 192.168.1.1 / 24;
                var n3: network = 10.0.0.1 / mask;
                var n4: network = ip / 16;
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // EXPRESSIONS & OPERATORS
    // ---------------------------------------

    @Test
    def void testOperators() {
        val input = '''
            firewall FW {
                fun test():bool {
                    var x: int = 1 + 2 * 3;
                    var y: bool = true and false or true;
                    var z: bool = not false;
                    return y;
                }
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // BUILT-IN FUNCTIONS
    // ---------------------------------------

    @Test
    def void testBuiltinFunctions() {
        val input = '''
            firewall FW {
                fun test():bool {
                    writelog("hello");
                    writelog(info, "msg");
                    allow();
                    drop();
                    reject();
                    getTime();
                    getPacketField("srcip");
                    return true;
                }
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // MEMBER SELECTION
    // ---------------------------------------

    @Test
    def void testMemberSelection() {
        val input = '''
            firewall FW {
                var r: MyRule;
                fun test() : bool {
                    r->check();
                    return true;
                }
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

    // ---------------------------------------
    // FUNCTION CALLS
    // ---------------------------------------

    @Test
    def void testFunctionCall() {
        val input = '''
            firewall FW {
                fun test():int {
                    return math.util.add(1, 2);
                }
            }
        '''
        val program = parser.parse(input)
        Assertions.assertNotNull(program)
    }

}
