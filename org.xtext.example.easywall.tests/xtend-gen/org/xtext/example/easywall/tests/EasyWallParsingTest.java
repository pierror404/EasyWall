package org.xtext.example.easywall.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.xtext.example.easywall.easyWall.EFProgram;

@ExtendWith(InjectionExtension.class)
@InjectWith(EasyWallInjectorProvider.class)
@SuppressWarnings("all")
public class EasyWallParsingTest {
  @Inject
  private ParseHelper<EFProgram> parser;

  @Test
  public void testHeaderOnly() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pack test;");
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testHeaderWithImports() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pack my.firewall;");
      _builder.newLine();
      _builder.append("import net.rules.*;");
      _builder.newLine();
      _builder.append("import other.pkg.*;");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEmptyFirewall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW1 {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFirewallWithDefaultPolicy() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW1 {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("default allow;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFirewallWithMembers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW1 {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var ip1: netip = 192.168.1.1;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("set mask: netmask = /24;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun check():bool {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRuleParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("rule R1 at NetworkLayer {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var src: netip = 10.0.0.1;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var dst: netip = any;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRuleReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW1 {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("apply my.rules.R1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIPv4Forms() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var a: netip = 192.168.0.1;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var b: netip = any;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var c: netip = localhost;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIPv6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var a: netipv6 = abcd:1234:5678:9abc:def0:1111:2222:3333;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNetworkSyntaxAllForms() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n1: network = ip / mask;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n2: network = 192.168.1.1 / 24;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n3: network = 10.0.0.1 / mask;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var n4: network = ip / 16;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOperators() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun test():bool {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("var x: int = 1 + 2 * 3;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("var y: bool = true and false or true;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("var z: bool = not false;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return y;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBuiltinFunctions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun test():bool {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("writelog(\"hello\");");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("writelog(info, \"msg\");");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("allow();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("drop();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("reject();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("getTime();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("getPacketField(\"srcip\");");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMemberSelection() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("var r: MyRule;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun test() : bool {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("r->check();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return true;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFunctionCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("firewall FW {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("fun test():int {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return math.util.add(1, 2);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      final EFProgram program = this.parser.parse(input);
      Assertions.assertNotNull(program);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
