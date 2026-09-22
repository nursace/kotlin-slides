# Lab 05 — Characters

**Course:** Introduction to Programming with Kotlin  
**After lecture:** `05-characters.tex`  
**Topics practised:** (16) Character data type (`Char`)

| | |
|---|---|
| **Estimated time** | 45–70 minutes |
| **Prerequisites** | Lecture 05; Lab 04 helpful (`for` over strings, ranges) |

---

## Goals

By the end of this lab you can:

1. Declare `Char` literals and contrast them with `String`.
2. Read characters from strings (`s[i]`, iteration).
3. Use codes, ranges (`'a'..'z'`), and helpers like `isDigit()` / `isLetter()`.

---

## How to work

- Complete programs with `fun main()`.
- Remember: `'A'` is `Char`, `"A"` is `String`.
- Loops over a string visit each `Char`.

---

## Tasks

### Task 1 — Char vs String

Declare `val letter: Char = 'K'` and `val word: String = "K"`.  
Print both. In comments, write one sentence explaining how their types differ.

Also print `word[0]` and confirm it is the same character as `letter`.

---

### Task 2 — First and last

Read a non-empty line. Print:

```text
first = ...
last = ...
```

Use indexing (`[0]` and `[length - 1]` or `.last()`).  
If the line is empty, print `Empty input` instead (use `if`).

---

### Task 3 — Classify one character

Read a line and take `ch = line[0]` (assume non-empty).  
Using `when (ch)` with ranges, print one of: `Digit`, `Uppercase`, `Lowercase`, `Other`.

**Sample**

```text
Enter char: G
Uppercase
```

---

### Task 4 — Digit to value

Read a line; assume the first character is a digit `'0'`..`'9'`.  
Compute `val value = ch - '0'` and print:

```text
value = 7
```

(for input starting with `7`).  
Then print `value * 2`.

---

### Task 5 — Count letters

Read a full line. Count how many characters satisfy `isLetter()`.  
Print `Letters: <n>`.

**Sample**

```text
Enter text: A1b2C!
Letters: 3
```

---

### Task 6 — Keep only letters

Read a line. Build a new string that contains only letters (use `var result = ""` and `+=` in a loop).  
Print the result.

**Sample** (`Kotlin 1.9!` → `Kotlin`)

---

### Task 7 — Helpers tour

Read one character (first of a line). Print on separate lines the boolean results of:

- `isDigit()`
- `isLetter()`
- `isWhitespace()`
- and the results of `lowercaseChar()` / `uppercaseChar()`

---

### Challenge (optional) — Tiny Caesar shift

Read a lowercase letter `'a'`..`'z'`.  
Shift it forward by 1 with wrap-around (`'z'` → `'a'`), as in the lecture demo.  
If the character is not a lowercase letter, print it unchanged.

**Hint:** `'a' + (ch - 'a' + 1) % 26`

---

## Done checklist

- [ ] Task 1: `Char` vs `String` clear in code + comment  
- [ ] Task 2: first / last indexing with empty guard  
- [ ] Task 3: `when` + character ranges  
- [ ] Task 4: `ch - '0'` numeric value  
- [ ] Task 5: count with `isLetter()`  
- [ ] Task 6: filter letters into a new string  
- [ ] Task 7: classification helpers  

**Submit:** as specified by your lecturer.
