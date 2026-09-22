# Lab 01 — First Program, Console, and Templates

**Course:** Introduction to Programming with Kotlin  
**After lecture:** `01-first-program-variables.tex`  
**Topics practised:** (1) First program · (2) Console + variables · (3) Special characters / templates

| | |
|---|---|
| **Estimated time** | 60–80 minutes |
| **Prerequisites** | Lecture 01; Kotlin toolchain or online playground that supports `fun main()` and `readln()` |

---

## Goals

By the end of this lab you can:

1. Write and run a complete Kotlin program with `fun main()`.
2. Read text from the console with `readln()` and store it in `val`.
3. Use escape sequences and string templates (`$name`, `${expression}`).

---

## How to work

- Write a **complete program** for each task (its own `fun main()` unless the lecturer asks for one file with several experiments).
- Prefer `val` for everything in this lab.
- Use `readln()` for input (not `Scanner`).
- Match sample I/O **style** (labels and line breaks) where samples are given.
- Ask a neighbour before asking the instructor; discuss ideas, not finished code dumps.

---

## Tasks

### Task 1 — Hello with your twist

Write a program that prints exactly three lines:

1. A greeting that includes your first name (hard-code the name in a `val`).
2. A blank line (use `\n` or an empty `println()`).
3. The text `Kotlin lab 01` with a tab before the word `lab` (use `\t`).

**Sample idea** (name `Sam`):

```text
Hello, Sam!

Kotlin	lab 01
```

**Hint:** Escape sequences live inside double-quoted strings.

---

### Task 2 — Echo machine

Read a single line from the user and print it back in this format:

```text
You said: <their line>
```

**Sample**

```text
Enter a line: I like tea
You said: I like tea
```

(Your prompt text may differ; the second line must use a template with `$`.)

---

### Task 3 — Two facts

Ask for:

1. A favourite colour (text)
2. A lucky number (text is fine; do **not** convert to `Int` yet)

Then print **one** line using a template:

```text
Colour: <colour>; lucky number: <number>
```

**Sample**

```text
Colour: blue; lucky number: 7
```

---

### Task 4 — Mini profile card

Ask for first name, last name, and city (three `readln()` calls).  
Print a multi-line “card” using templates and at least one `\n` **inside a single string** (not only three separate `println` calls for the blank structure—you may still use more than one `println` overall).

Required content (labels may be similar):

```text
Name: Ada Lovelace
City: London
```

Use `"$first $last"` (or `${...}`) for the full name—**no** string concatenation with `+` for that part.

---

### Task 5 — Quote with escapes

Print the following **exactly**, including the quotes and the backslash in the path (build it with escapes; do not paste a raw multiline file):

```text
She said: "Keep coding"
Path: C:\Kotlin\Lab01
```

**Hint:** You need `\"` and `\\`.

---

### Task 6 — Template arithmetic (text only)

Hard-code two `val` integers `a = 6` and `b = 4` (still topic warm-up for later number labs).  
Print using **one** template with `${...}`:

```text
6 + 4 = 10
```

Then change `a` and `b` and run again—the printed numbers must update automatically (do not hard-code `10` in the string).

---

### Challenge (optional)

Ask for a name and a year of birth (keep birth year as text for now). Print:

```text
Hello, <name>!
Born: <year>
```

using a string that contains `\n` between the two sentences.

---

## Done checklist

- [ ] Task 1 runs and shows tab / newline correctly  
- [ ] Task 2 uses `readln()` and a `$` template  
- [ ] Task 3 prints both facts on one line  
- [ ] Task 4 builds the full name with a template  
- [ ] Task 5 prints quotes and a Windows-style path with escapes  
- [ ] Task 6 uses `${a + b}` (or equivalent), not a hard-coded sum  

**Submit:** source files named like `Lab01Task2.kt` … (or as your lecturer specifies).
