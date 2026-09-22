# Lab 03 — Conditionals and Expressions

**Course:** Introduction to Programming with Kotlin  
**After lecture:** `03-conditionals-expressions.tex`  
**Topics practised:** (6) Conditionals · (7) Combining conditions · (15) `if` / `when` expressions

| | |
|---|---|
| **Estimated time** | 70–90 minutes |
| **Prerequisites** | Lecture 03; Labs 01–02 (`readln()`, `Int`/`Double`, templates) |

---

## Goals

By the end of this lab you can:

1. Branch with `if` / `else if` / `else`.
2. Combine conditions with `&&`, `||`, and `!`.
3. Assign results using `if` and `when` **as expressions**.

---

## How to work

- Complete programs; read input from the console unless a task says to hard-code.
- Prefer expression style (`val x = if (...) ... else ...`) when the task asks for it.
- No lists or loops required (optional challenge may use a tiny loop only if you already know it).

---

## Tasks

### Task 1 — Pass / fail

Read an integer `score` (0–100 in your tests).  
Print `Pass` if `score >= 50`, otherwise `Fail`.

**Sample**

```text
Enter score: 49
Fail
```

---

### Task 2 — Temperature bands

Read an integer temperature (°C). Print exactly one label:

| Condition | Label |
|-----------|--------|
| `< 0` | `Freezing` |
| `0..14` | `Cold` |
| `15..24` | `Mild` |
| `>= 25` | `Warm` |

Use `if` / `else if` / `else` (not `when` yet).

---

### Task 3 — Cinema entry (combining)

Read:

1. `age` (`Int`)
2. `hasTicket` — user types `yes` or anything else

Print `Enter` only if `age >= 12 &&` the ticket answer is `yes`.  
Otherwise print a clear reason:

- `Too young` if age is the problem (even if they have a ticket)
- `Need a ticket` if age is OK but no ticket
- If both fail, print `Too young` (check age first)

**Hint:** Combine with `&&` / `else` carefully; order matters.

---

### Task 4 — Discount age

Read `age`. Print `Discount` if the person is a child (`age < 13`) **or** a senior (`age > 65`).  
Otherwise print `Regular`.

Use `||` in the condition.

---

### Task 5 — `if` as an expression

Read two integers `a` and `b`.  
Bind `val max = if (...) ... else ...` (no separate `println` inside the `if` branches for the result).  
Then print `max = <value>`.

**Sample**

```text
3
8
max = 8
```

---

### Task 6 — Grade with `when`

Read `score` (0–100). Assign `val grade` using a `when` **expression** and ranges (`in 90..100`, etc.):

| Score | Grade |
|------:|:-----:|
| 90–100 | A |
| 80–89 | B |
| 70–79 | C |
| 60–69 | D |
| else | F |

Print `Grade: X`.

---

### Task 7 — Subject-less `when`

Read an integer `n`. Using `when { ... }` (no argument), bind a label:

- `negative` if `n < 0`
- `zero` if `n == 0`
- `positive even` if `n > 0` and even
- `positive odd` otherwise

Print the label.

---

### Challenge (optional)

Read three integers. Using only `if` expressions (possibly nested) or `when`, print them in ascending order on one line (`1 2 3`).  
No lists / `sorted()`—only comparisons.

---

## Done checklist

- [ ] Task 1: simple `if` / `else`  
- [ ] Task 2: `else if` chain with correct bands  
- [ ] Task 3: `&&` and ordered error messages  
- [ ] Task 4: `||` discount rule  
- [ ] Task 5: `val max = if (...) ... else ...`  
- [ ] Task 6: `when` expression with `in` ranges  
- [ ] Task 7: subject-less `when`  

**Submit:** as specified by your lecturer.
