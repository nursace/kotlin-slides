# Lab 02 — Numbers and Mutable Variables

**Course:** Introduction to Programming with Kotlin  
**After lecture:** `02-numbers-mutable.tex`  
**Topics practised:** (4) `Int` · (5) Integer division · (8) Mutable vars · (9) Floats · (14) `Long` / `Short` / `Byte`

| | |
|---|---|
| **Estimated time** | 70–90 minutes |
| **Prerequisites** | Lecture 02; Lab 01 skills (`fun main()`, `readln()`, templates) |

---

## Goals

By the end of this lab you can:

1. Read and compute with `Int`, including `/` and `%`.
2. Use `var` when a value must change; prefer `val` otherwise.
3. Work with `Double` input via `toDouble()`.
4. Choose `Long` (and briefly `Short` / `Byte`) when size matters.

---

## How to work

- One complete program per task.
- Convert input with `.toInt()`, `.toLong()`, `.toDouble()` as needed.
- Do **not** use loops or lists yet (those come in Lab 04).

---

## Tasks

### Task 1 — Triple and square

Read one integer `n`. Print two lines:

```text
triple = <3n>
square = <n*n>
```

**Sample**

```text
Enter n: 5
triple = 15
square = 25
```

---

### Task 2 — Division report

Read two integers `a` and `b` (`b` ≠ 0 in your tests). Print:

```text
quotient = <a / b>
remainder = <a % b>
exact = <a as Double divided by b>
```

**Sample** (`a = 20`, `b = 3`)

```text
quotient = 6
remainder = 2
exact = 6.666...
```

(Exact formatting of the decimal may vary; it must **not** be the integer `6`.)

**Hint:** Use `a.toDouble() / b` or `a / b.toDouble()`.

---

### Task 3 — Seconds → h:m:s

Read a non-negative total number of seconds (`Int`).  
Convert to hours, minutes, and seconds using **only** integer `/` and `%`.  
Print:

```text
H:M:S -> 1:2:3
```

(Use your own spacing, but show three integer parts derived from the total.)

**Sample:** `3661` seconds → `1` hour, `1` minute, `1` second.

**Hint:** `hours = total / 3600`, then work on the remainder.

---

### Task 4 — Score accumulator (`var`)

Start with `var score = 0`.  
Read three integers (one per line). After each read, **add** it to `score` using `+=`.  
After all three, print:

```text
Final score: <score>
```

Do **not** create `score1`, `score2`, `score3` and add them only at the end—update the same `var` three times.

---

### Task 5 — Temperature mix

Read a Celsius value as `Double`. Compute Fahrenheit:

`f = c * 9.0 / 5.0 + 32.0`

Print:

```text
C = ...
F = ...
```

Then print whether `f` is below freezing in Fahrenheit (`32.0`), using a simple comparison printed as text `below freezing` or `not below freezing` (you may use `if` if you already know it from Lecture 03; otherwise print the boolean with a template).

---

### Task 6 — Population (`Long`)

Hard-code a `Long` literal for a large count, e.g. `8_100_000_000L`.  
Read an `Int` `extra` (people to add).  
Print the sum as a `Long` (convert `extra` with `.toLong()` before adding).

**Sample idea**

```text
Base: 8100000000
Extra: 500
Total: 8100000500
```

Explain in a comment why `Int` might be a bad choice for the base value.

---

### Task 7 — Tiny types (`Byte` / `Short`)

Declare:

- `val small: Byte = 100`
- `val medium: Short = 20_000`

Print `small + medium` and also print the **type name** of that sum in a comment or a string you write yourself (from the lecture: arithmetic often promotes to `Int`).

Then try changing `small` to `200`—what happens? Write one sentence in a comment.

---

### Challenge (optional)

Read price (`Double`) and quantity (`Int`).  
Maintain `var total = 0.0` and update it in a way that simulates adding the same price `quantity` times using a `var` counter and a `while` **only if** your lecturer already showed `while`; otherwise compute `price * quantity` once and still use a `var` to apply a 10% discount: `total = total * 0.9`.

---

## Done checklist

- [ ] Task 1: `toInt()` and templates  
- [ ] Task 2: integer `/`, `%`, and a true decimal quotient  
- [ ] Task 3: h:m:s with `/` and `%` only  
- [ ] Task 4: one `var score` updated with `+=`  
- [ ] Task 5: `toDouble()` temperature conversion  
- [ ] Task 6: `Long` literal + safe addition  
- [ ] Task 7: `Byte` / `Short` declaration attempt documented  

**Submit:** as specified by your lecturer (e.g. `Lab02Task1.kt` …).
