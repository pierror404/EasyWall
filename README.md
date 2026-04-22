
# EasyWall

**EasyWall** is a Domain Specific Language (DSL) designed to make firewall configuration **readable, structured, and safe by construction**.  
Instead of wrestling with low-level, vendor-specific rule syntaxes, EasyWall lets you describe firewall behavior in a **typed, layered, and modular language**—very close to how you actually think about networks.

> A DSL for firewalls, developed as a project for  
> _“Attività progettuale di linguaggi e modelli computazionali M”_  
> Master’s Degree in Computer Engineering – University of Bologna.

---

## ✨ Key features

- **Strongly-typed network primitives**
  - `network` → CIDR networks, e.g. `192.168.0.0/24`
  - `netip` → IP addresses, e.g. `192.168.0.1`
  - `netport` → ports, e.g. `:8080`
  - `protocol`, `direction`, `netmask`, etc.
- **Layer-aware rules**
  - Rules are explicitly bound to OSI layers:
    - `NetworkLayer`
    - `TransportLayer`
    - `ApplicationLayer`
  - The validator checks **protocol/layer compatibility** (e.g. `TCP` only in `TransportLayer` rules).
- **Firewall-centric design**
  - Exactly one `firewall` definition acts as the “main” entry point.
  - Rules can be defined in separate files and applied from the firewall.
- **Packages & imports**
  - Java-like package and import system:
    - `pack my.firewall;`
    - `import my.rules.*;`
- **Constants vs variables**
  - `set` → constant
  - `var` → mutable variable
- **Built-in actions & helpers**
  - `allow()`, `block()`, `drop()`, `reject()`
  - `writelog(...)`, `getTime()`, `getPacketField("fieldName")`
- **Static validation**
  - IPv4 format and octet ranges
  - CIDR prefix validity (`0–32`)
  - Port range validity (`1–65535`)
  - Protocol vs layer mismatches
  - Mandatory fields and type correctness

---

## 🧠 Language overview

### Firewall definition

A firewall file is the central entry point—similar to a `main` class:

```easywall
firewall FW {
    default deny;

    var internal_net: network = 192.168.0.0/24;
    var web_server_ip: netip = 192.168.0.10;
    var https_port: netport = :443;

    apply WebRules;
}
```

- **`default allow;` / `default deny;`** define the default policy.
- `apply WebRules;` references a rule class defined elsewhere.

---

### Rules and layers

Rules are explicitly bound to a layer:

```easywall
rule WebRules at ApplicationLayer {
    var rule_protocol: protocol = HTTP;
    var rule_direction: direction = in;

    fun trigger(): void {
        // high-level logic here
        allow();
    }
}
```

Examples:

```easywall
rule NetFilter at NetworkLayer {
    var rule_protocol: protocol = IPv4;
    var rule_direction: direction = forward;

    fun trigger(): void {
        // ...
    }
}

rule TransportFilter at TransportLayer {
    var rule_protocol: protocol = TCP;
    var rule_direction: direction = in;

    fun trigger(): void {
        // ...
    }
}
```

The validator enforces that:

- Network-layer protocols (`IPv4`, `IPv6`, `ICMP`, …) are only used in `NetworkLayer` rules.
- Transport-layer protocols (`TCP`, `UDP`, `QUIC`, …) are only used in `TransportLayer` rules.
- Application-layer protocols (`HTTP`, `DNS`, `SMTP`, …) are only used in `ApplicationLayer` rules.

---

### Types and variables

Primitive and network-native types:

```easywall
// Primitive types
var retries: int = 3;
var enabled: bool = true;
var note: string = "frontend filter";

// Network-native types
var client_ip: netip = 10.0.0.5;
var dmz_net: network = 10.0.0.0/24;
var ssh_port: netport = :22;
var mask: netmask = /24;
var rule_protocol: protocol = TCP;
var rule_direction: direction = in;
```

Constants vs variables:

```easywall
set MAX_RETRIES: int = 5;        // constant
var current_retries: int = 0;    // mutable
```

---

### Expressions and conditions

EasyWall supports expressions, comparisons, and logical operators:

```easywall
if (enabled && retries < MAX_RETRIES) {
    writelog(info, "Retrying connection");
} else {
    drop();
}
```

Operators include:

- Logical: `&&`, `||`, `not`
- Comparison: `==`, `!=`, `>`, `<`, `>=`, `<=`
- Arithmetic: `+`, `-`, `*`, `div`, `%`

---

### Built-in functions

Some built-ins you can use inside `fun` bodies:

```easywall
fun trigger(): void {
    writelog(debug, "Packet received");
    var ts: int = getTime();
    var dst_ip: string = getPacketField("dst_ip");

    if (dst_ip == "192.168.0.10") {
        allow();
    } else {
        drop();
    }
}
```

Available built-ins include:

- `allow()`
- `block()`
- `drop()`
- `reject()`
- `writelog(level, message)`
- `getTime()`
- `getPacketField("fieldName")`

---

## 🧪 Testing & validation

The repo includes an Xtext-based test suite (`org.xtext.example.easywall.tests`) that validates:

- **IPv4 correctness**

  ```easywall
  var ip1: netip = 192.168.1.1;      // OK
  var ip2: netip = 999.168.1.1;      // Error: invalid octet
  ```

- **CIDR prefix validity**

  ```easywall
  var n1: network = 10.0.0.1/24;     // OK
  var n2: network = 10.0.0.1/99;     // Error: prefix out of range
  ```

- **Port range**

  ```easywall
  var p1: netport = :443;            // OK
  var p2: netport = :0;              // Error: invalid port
  ```

- **Protocol/layer mismatch**

  ```easywall
  rule R1 at ApplicationLayer {
      var rule_protocol: protocol = TCP;   // Error: transport protocol in app layer
      var rule_direction: direction = in;

      fun trigger(): void {
      }
  }
  ```

---

## 🏗️ Project structure

- `org.xtext.example.easywall`  
  Core Xtext grammar, model, and validator.

- `org.xtext.example.easywall.ide`  
  IDE integration (language server, etc.).

- `org.xtext.example.easywall.ui`  
  Eclipse UI support (editors, highlighting, etc.).

- `org.xtext.example.easywall.tests`  
  JUnit/Xtext tests for grammar and validation.

- `org.xtext.example.easywall.ui.tests`  
  UI-level tests.

---

## 🚀 Getting started (developer setup)

> This is an Xtext-based project. You’ll typically work with it inside Eclipse with the Xtext plugins installed.

1. **Clone the repository**

   ```bash
   git clone https://github.com/pierror404/EasyWall.git
   cd EasyWall
   ```

2. **Import into Eclipse**

   - `File → Import → Existing Projects into Workspace`
   - Select the root folder of the repo.
   - Import all `org.xtext.example.easywall*` projects.

3. **Generate Xtext artifacts**

   - Open `org.xtext.example.easywall/src/org/xtext/example/easywall/EasyWall.xtext`
   - Right-click in the editor → `Run As → Generate Xtext Artifacts`

4. **Clean & build**

   - `Project → Clean…`
   - Ensure all projects build without errors.

5. **Run tests**

   - Right-click on `org.xtext.example.easywall.tests` → `Run As → JUnit Plug-in Test`
   - Or run individual test classes as needed.

---

## 🌱 Possible extensions

EasyWall is a solid base for experimenting with:

- **Code generation**
  - Translate EasyWall rules into:
    - `iptables` / `nftables`
    - Windows Firewall rules
    - Cloud security group configs (AWS, GCP, Azure)
- **Static analysis**
  - Detect shadowed rules, unreachable rules, conflicting policies.
- **Higher-level abstractions**
  - Service groups, role-based policies, environment-aware rules.
- **Tooling**
  - VS Code extension via LSP
  - CLI validator for CI pipelines

---

## 📜 License & authorship

This project is a university project by **Pierluca** (GitHub: `pierror404`) for the  
_MSc in Computer Engineering_ at the University of Bologna.

License information is not explicitly stated in the repository at the time of writing—  
if you plan to use or extend EasyWall, consider opening an issue or contacting the author.

---
