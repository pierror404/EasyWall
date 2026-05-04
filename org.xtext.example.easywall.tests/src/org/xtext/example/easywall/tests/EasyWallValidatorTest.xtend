package org.xtext.example.easywall.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.xtext.example.easywall.easyWall.EFProgram
import org.xtext.example.easywall.validation.EasyWallValidator
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith

@ExtendWith(InjectionExtension)
@InjectWith(EasyWallInjectorProvider)
class EasyWallValidatorTest {

    @Inject ParseHelper<EFProgram> parser
    @Inject ValidationTestHelper validator

    // ============================================================
    // IPv4 VALIDATION
    // ============================================================

    @Test
    def void testInvalidIPv4Octet() {
        val input = '''
            firewall FW {
            		default allow;
                var ip1: netip = 999.10.10.10;
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)

        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.INVALID_IPV4_OCTET],
            "Expected INVALID_IPV4_OCTET"
        )
    }

    @Test
    def void testValidIPv4() {
        val input = '''
            firewall FW {
            		default deny;
                var ip1: netip = 192.168.1.1;
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // CIDR PREFIX VALIDATION
    // ============================================================

    @Test
    def void testInvalidCIDRPrefix() {
        val input = '''
            firewall FW {
            		default allow;
                var n: network = 10.0.0.1/99;
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)
        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.INVALID_CIDR_PREFIX],
            "Expected INVALID_CIDR_PREFIX"
        )
    }

    @Test
    def void testValidCIDRPrefix() {
        val input = '''
            firewall FW {
            		default allow;
                var n: network = 10.0.0.1 / 24;
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // PORT VALIDATION
    // ============================================================

    @Test
    def void testInvalidPort() {
        val input = '''
            firewall FW {
            		default deny;
                var p: netport = :70000;
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)

        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.INVALID_PORT],
            "Expected INVALID_PORT"
        )
    }

    @Test
    def void testValidPort() {
        val input = '''
            firewall FW {
            		default deny;
                var p: netport = :443;
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // MANDATORY FIELDS (protocol + direction)
    // ============================================================

    @Test
    def void testMissingMandatoryFields() {
        val input = '''
            rule R1 at NetworkLayer {
                var something: int = 1;
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)

        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.MISSING_MANDATORY_FIELD_DIRECTION],
            "Expected missing mandatory field errors"
        )
    }

    @Test
    def void testMandatoryFieldsPresent() {
        val input = '''
            rule R1 at NetworkLayer {
                var rule_protocol: protocol = IPv4;
                var rule_direction: direction = in;
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // TRIGGER METHOD VALIDATION
    // ============================================================

    @Test
    def void testMissingTriggerMethod() {
        val input = '''
            rule R1 at NetworkLayer {
                var rule_protocol: protocol = IPv4;
                var rule_direction: direction = in;
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)

        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.MISSING_TRIGGER_METHOD],
            "Expected MISSING_TRIGGER_METHOD"
        )
    }

    @Test
    def void testTriggerMethodPresent() {
        val input = '''
            rule R1 at NetworkLayer {
                var rule_protocol: protocol = IPv4;
                var rule_direction: direction = in;

                fun trigger():void {
                    allow();
                }
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // BUILTIN OUTSIDE TRIGGER
    // ============================================================

    @Test
    def void testBuiltinOutsideTrigger() {
        val input = '''
            rule R1 at NetworkLayer {
                var rule_protocol: protocol = IPv4;
                var rule_direction: direction = in;

                fun test():void {
                    allow();
                }
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)

        Assertions.assertTrue(
            issues.exists[it.code == EasyWallValidator.BUILTIN_OUTSIDE_TRIGGER],
            "Expected BUILTIN_OUTSIDE_TRIGGER"
        )
    }

    @Test
    def void testBuiltinInsideTrigger() {
        val input = '''
            rule R1 at NetworkLayer {
                var rule_protocol: protocol = IPv4;
                var rule_direction: direction = in;

                fun trigger():void {
                    allow();
                }
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }

    // ============================================================
    // PROTOCOL / LAYER COMPATIBILITY
    // ============================================================

    @Test
    def void testProtocolLayerMismatch() {
        val input = '''
            rule R1 at ApplicationLayer {
                var rule_protocol: protocol = TCP;
                var rule_direction: direction = in;

                fun trigger():void {}
            }
        '''
        val model = parser.parse(input)
        val issues = validator.validate(model)
        println(model.eAllContents.toList)

        Assertions.assertTrue(
            issues.exists[it.message.contains("Transport layer protocols")],
            "Expected protocol/layer mismatch"
        )
    }

    @Test
    def void testProtocolLayerCorrect() {
        val input = '''
            rule R1 at TransportLayer {
                var rule_protocol: protocol = TCP;
                var rule_direction: direction = in;

                fun trigger():void {}
            }
        '''
        val model = parser.parse(input)
        validator.assertNoErrors(model)
    }
}
