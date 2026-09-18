# Kotlin Practice 

> **Current practice sheet.** Use this file for course practice and homework.  
> The older `lab-01` … `lab-05` handouts remain available as **optional, easier** warm-ups after each lecture.

**Course:** Introduction to Programming with Kotlin  
**Format:** Code-writing Tasks (complete programs with `fun main()`)  
**Level:** Harder than Labs 01–05 — multi-step problems that combine topics  
**No full solutions** — light hints only

| | |
|---|---|
| **Estimated time** | 3–5 hours total (spread across sessions) |
| **Scope** | `val` / `var`, lists, `if` / `when`, loops (`for`, `while`, `repeat`, `do-while`), ranges, `split`, `Char` |
| **Constraints** | One file + `main` per Task (or as lecturer requires). No classes/OOP required. Prefer standard library basics only (`listOf`, `mutableListOf`, `split`, Char helpers). |

---

## Instructions

1. Write a **complete Kotlin program** for each Task.
2. Read from the console with `readln()` unless the Task specifies hard-coded test data.
3. Handle the **edge cases** listed in the task — that is part of the grade for difficulty.
4. Match sample I/O labels and line structure where samples are given.
5. You may use temporary `println` debugging, but submit clean output that matches the spec.
6. Do not paste solutions from classmates. Discuss approach, not finished code.

**Skills you must combine** (across the set, not necessarily every task):

- Immutable vs mutable bindings; building and updating lists
- Branching with `if` and `when` (including as expressions)
- Loops and ranges; stopping conditions that avoid infinite loops
- Parsing lines with `split`
- Character-level processing (`Char`, ranges like `'a'..'z'`, `isDigit()` / `isLetter()`)

---

## Tasks

### Task 1 — Running balance ledger

Read an opening balance as an `Int`, then repeatedly process transactions until the user enters `done`.

Each transaction line has the form:

```text
+ 50
```

or

```text
- 20
```

(space between sign and amount). Use `split` and update a `var balance`. After each successful transaction, print the new balance. Reject malformed lines with `Ignored` (do not change the balance). Empty amount or missing parts count as malformed.

When the user types exactly `done`, print:

```text
Final: <balance>
```

and stop. Use a loop that fits (`while` or `do-while`).

**Sample**

```text
Opening: 100
+ 50
Balance: 150
- 20
Balance: 130
oops
Ignored
done
Final: 130
```

**Hint:** After `split(" ")`, check `size` and that the amount parses as `Int`.

---

### Task 2 — Gradebook from one line

Read one line of integer scores separated by spaces (e.g. `90 80 70 100`).  
If there are **no** valid integers (empty line / only spaces), print `No scores` and exit.

Otherwise compute and print:

```text
count = ...
sum = ...
avg = ...
min = ...
max = ...
letter = ...
```

- `avg` is a `Double` (`sum.toDouble() / count`).
- `letter` uses a `when` expression on the average rounded **down** to an `Int` (truncate): A 90–100, B 80–89, C 70–79, D 60–69, else F. Cap the truncated average at 100 for letter purposes if a score sneaks above 100; still include that score in sum/min/max.

**Sample** (`90 80 70`)

```text
count = 3
sum = 240
avg = 80.0
min = 70
max = 90
letter = B
```

---

### Task 3 — Sparse histogram (0–9)

Read a line of integers in `0..9` separated by spaces.  
Ignore tokens that are not integers or not in `0..9` (skip them; do not crash).

Build frequencies for digits `0` through `9` using a `mutableListOf` of size 10 (all zeros), then update with a loop.

Print ten lines:

```text
0: ##
1:
2: #
...
```

where the number of `#` equals the frequency (use `repeat`). Digits with frequency 0 print an empty bar after the colon (still print the line).

**Sample** input `1 2 2 9 2 x 11 2`

```text
0:
1: #
2: ####
3:
4:
5:
6:
7:
8:
9: #
```

---

### Task 4 — Windowed range filter

Read three integers on separate lines: `low`, `high`, `n`.  
Then read `n` integers (one per line).

Collect into a list only those values `x` that satisfy `x in low..high`.  
Then print:

1. The kept values on one line, space-separated (or `none` if empty)
2. How many were rejected
3. `tight` if `low == high`, `wide` if `high - low >= 100`, otherwise `normal` — use a `when` expression for this label

**Edge cases:** If `low > high`, print `Bad range` and do not read the `n` values (or read and discard—either is acceptable if documented in a comment; prefer stopping early).

---

### Task 5 — Command shell (mini)

Implement a tiny command loop with `do-while` (or equivalent) until `quit`.

Supported commands (first word; rest may be arguments via `split`):

| Command | Behaviour |
|---------|-----------|
| `add <int>` | Append to a `mutableListOf<Int>` |
| `sum` | Print sum of the list (`0` if empty) |
| `max` | Print max, or `empty` if none |
| `clear` | Clear the list |
| `list` | Print elements space-separated, or `[]` if empty |
| `quit` | Exit |
| anything else | `Unknown command` |

Start with an empty list. Persist state across commands in `var` / the same mutable list.

**Sample**

```text
> add 3
> add 10
> sum
13
> max
10
> list
3 10
> quit
```

(Your prompt character is optional.)

---

### Task 6 — Caesar encode / decode

Read a mode word: `encode` or `decode` (anything else → print `Bad mode` and stop).  
Read an integer shift `s` (may be negative or large; normalize with modulo 26 carefully for negatives).  
Read a line of text.

Transform only letters:

- Preserve case (`A` stays uppercase; `a` stays lowercase).
- Non-letters are copied unchanged.
- `decode` shifts in the opposite direction from `encode`.

Print the resulting string.

**Sample**

```text
encode
1
Abz!
Bca!
```

**Hint:** Work in `Char` space with `'a' + (ch - 'a' + shift).mod(26)` (or equivalent safe remainder).

---

### Task 7 — Password audit

Read one candidate password string. Print a report using a `when` expression for the **final strength label**, but compute flags with loops/`Char` checks:

Rules (check all):

1. Length at least 8
2. At least one uppercase letter
3. At least one lowercase letter
4. At least one digit
5. At least one character that is **not** a letter or digit (symbol)
6. No spaces (`' '` or other `isWhitespace()`)

Print six lines `rule1: OK` / `rule1: FAIL`, … then:

- `STRONG` if all six OK
- `MEDIUM` if at least four OK (but not all)
- `WEAK` otherwise

**Sample** (`Ab1!xyzz`)

```text
rule1: OK
rule2: OK
rule3: OK
rule4: OK
rule5: OK
rule6: OK
STRONG
```

---

### Task 8 — Merge and unique (stable)

Read two lines, each a space-separated list of integers (either may be empty).  
Build one list: all ints from line 1 (in order), then line 2 (in order).  
Then build a new list that keeps only the **first** occurrence of each value (stable unique).

Print:

```text
merged: ...
unique: ...
```

(space-separated; print `merged:` / `unique:` with nothing after the space if empty).

Do **not** use `distinct()` — implement uniqueness with loops and a list you maintain.

---

### Task 9 — Matrix-ish pair sums from flat input

Read integers `rows` and `cols` (`both >= 1`).  
Then read `rows * cols` integers on **one** line separated by spaces (must match length or print `Bad data` and stop).

Treat them as a grid in row-major order.  
For each row, print the **sum** of that row.  
Then print the column sums (one line, `cols` numbers).  
Finally print `square` if `rows == cols`, else `rect`, using an `if` expression assigned to a `val`.

**Sample**

```text
2
3
1 2 3 4 5 6
6
15
5 7 9
rect
```

(row sums `1+2+3=6`, `4+5+6=15`; column sums `1+4=5`, `2+5=7`, `3+6=9`)

---

### Task 10 — Token classifier pipeline

Read a line containing mixed tokens separated by spaces.  
For each token, classify with `when` / `if` and character scans:

| Class | Rule |
|-------|------|
| `INT` | Non-empty, optional leading `-`, then all digits (e.g. `-42`, `7`) |
| `WORD` | Length ≥ 1 and every char is a letter |
| `CODE` | Length ≥ 2, only letters+digits, at least one letter and one digit |
| `OTHER` | Anything else (including empty tokens from double spaces — skip empties) |

Print one line per kept token: `<token> -> <class>`.  
Afterward print counts: `INT=.. WORD=.. CODE=.. OTHER=..`.

**Sample**

```text
hi A1 42 -3 x9y !!
hi -> WORD
A1 -> CODE
42 -> INT
-3 -> INT
x9y -> CODE
!! -> OTHER
INT=2 WORD=1 CODE=2 OTHER=1
```

---

### Task 11 — Digits extract and rearrange

Read a single line of arbitrary text.  
Extract all digit characters (`Char` + `isDigit()`), in order, into a list of `Char` (or `Int` values 0–9).

If fewer than 2 digits, print `Need more digits` and stop.

Otherwise:

1. Print the digits concatenated (`3815` style).
2. Print their sum.
3. Using a `var` and loops, build a new sequence: **largest digit first, then the rest in original order excluding the first occurrence of that largest digit**. Print that sequence concatenated.
4. Print `palindrome` if the extracted digit string equals its reverse, else `no` (build reverse with a loop, not a library reverse helper if you want full control — either is OK).

**Sample** (`a3b8c1x5`)

```text
3815
17
8315
no
```

---

### Task 12 — Bounded walk simulator

A robot starts at position `0` on a number line.  
Read an integer bound `B` (`B >= 0`). The robot is allowed only on `-B..B`.  
Then process move commands until `stop`:

- `L` — try to move −1
- `R` — try to move +1
- `J <n>` — try to jump by integer `n` (may be negative; `split`)
- `stop` — end

If a move would leave `-B..B`, print `Blocked` and **do not** move; otherwise print `Pos: <p>`.  
Invalid commands print `Ignored`.

At the end print `Pos: <p>` again and `steps: <successfulMoves>` (blocked/ignored do not count).

Use ranges for the bound check (`newPos in -B..B`).

**Sample** (`B = 2`)

```text
2
R
Pos: 1
R
Pos: 2
R
Blocked
J -3
Blocked
J -1
Pos: 1
stop
Pos: 1
steps: 3
```

---
