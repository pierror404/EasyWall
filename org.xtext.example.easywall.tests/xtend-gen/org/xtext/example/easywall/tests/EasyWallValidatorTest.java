package org.xtext.example.easywall.tests;

import com.google.inject.Inject;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.xtext.example.easywall.easyWall.EFProgram;
import org.xtext.example.easywall.validation.EasyWallValidator;

@ExtendWith(InjectionExtension.class)
@InjectWith(EasyWallInjectorProvider.class)
@SuppressWarnings("all")
public class EasyWallValidatorTest {
  @Inject
  private ParseHelper<EFProgram> parser;

  @Inject
  private ValidationTestHelper validator;

  @Test
  public void testInvalidIPv4Octet() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default allow;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var ip1: netip = 999.10.10.10;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.INVALID_IPV4_OCTET));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected INVALID_IPV4_OCTET");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testValidIPv4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default deny;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var ip1: netip = 192.168.1.1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidCIDRPrefix() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default allow;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n: network = 10.0.0.1/99;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.INVALID_CIDR_PREFIX));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected INVALID_CIDR_PREFIX");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testValidCIDRPrefix() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default allow;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n: network = 10.0.0.1 / 24;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInvalidPort() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default deny;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var p: netport = :70000;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.INVALID_PORT));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected INVALID_PORT");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testValidPort() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default deny;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var p: netport = :443;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMissingMandatoryFields() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var something: int = 1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.MISSING_MANDATORY_FIELD));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected missing mandatory field errors");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMandatoryFieldsPresent() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = IPv4;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMissingTriggerMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = IPv4;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.MISSING_TRIGGER_METHOD));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected MISSING_TRIGGER_METHOD");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testTriggerMethodPresent() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = IPv4;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun trigger():void {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("allow();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBuiltinOutsideTrigger() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = IPv4;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun test():void {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("allow();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equals(_code, EasyWallValidator.BUILTIN_OUTSIDE_TRIGGER));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected BUILTIN_OUTSIDE_TRIGGER");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBuiltinInsideTrigger() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = IPv4;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun trigger():void {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("allow();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testProtocolLayerMismatch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at ApplicationLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = TCP;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun trigger():void {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      final List<Issue> issues = this.validator.validate(model);
      InputOutput.<List<EObject>>println(IteratorExtensions.<EObject>toList(model.eAllContents()));
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        return Boolean.valueOf(it.getMessage().contains("Transport layer protocols"));
      };
      Assertions.assertTrue(
        IterableExtensions.<Issue>exists(issues, _function), 
        "Expected protocol/layer mismatch");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testProtocolLayerCorrect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at TransportLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_protocol: protocol = TCP;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var rule_direction: direction = in;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun trigger():void {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram model = this.parser.parse(input);
      this.validator.assertNoErrors(model);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
