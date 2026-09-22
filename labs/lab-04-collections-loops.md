# Lab 04 — Collections, Loops, Ranges, and Split

**Course:** Introduction to Programming with Kotlin  
**After lecture:** `04-collections-loops.tex`  
**Topics practised:** (10) Collections intro · (11) `repeat` / `while` · (12) `for` + `size` · (13) Ranges · (17) `do-while` + `split`

| | |
|---|---|
| **Estimated time** | 80–100 minutes |
| **Prerequisites** | Lecture 04; Labs 01–03 |

---

## Goals

By the end of this lab you can:

1. Create lists with `listOf` / `mutableListOf` and use `.size` and indexing.
2. Repeat work with `repeat`, `while`, `for`, and `do-while`.
3. Loop over ranges (`..`, `until`, `downTo`, `step`).
4. Split a line of text into pieces and process them.

---

## How to work

- One program per task.
- Prefer `for (x in list)` when you need every element; use indices when the task requires them.
- Avoid infinite loops—always update the condition variable.

---

## Tasks

### Task 1 — List basics

Create `val nums = listOf(4, 8, 15, 16, 23)`. Print:

1. The first element  
2. The last element (use `size`, not a hard-coded index `4`)  
3. The size  

**Sample shape**

```text
first = 4
last = 23
size = 5
```

---

### Task 2 — Mutable shopping list

Start with `val items = mutableListOf("milk", "bread")`.  

1. `add` one more item read from the console.  
2. Change index `0` to `"oat milk"`.  
3. Print the whole list and its `size`.

---

### Task 3 — `repeat` banner

Read a positive integer `n`. Use `repeat(n)` to print `*` that many times on **one** line (use `print`, not `println`, inside the loop). Then print a newline.

**Sample** (`n = 5`)

```text
*****
```

---

### Task 4 — Countdown `while`

Read `n`. While `n > 0`, print `n`, then decrement. After the loop print `Go!`.

**Sample** (`n = 3`)

```text
3
2
1
Go!
```

---

### Task 5 — Sum with `for` and `size`

Hard-code `val xs = listOf(2, 1, 7, 4)`.  

- Version A: sum using `for (x in xs)`.  
- Version B (same program): sum again using indices `for (i in 0 until xs.size)`.  

Print both sums (they must match).

---

### Task 6 — Range printer

Using `for` loops only (no lists):

1. Print `1 2 3 4 5` using `1..5`  
2. Print `5 4 3 2 1` using `downTo`  
3. Print `0 1 2` using `until`  
4. Print `1 3 5 7 9` using `step`

Each sequence on its own line.

---

### Task 7 — Teen check with `in`

Read an age. Print `Teen` if `age in 13..19`, else `Not a teen`.

---

### Task 8 — Menu with `do-while`

Repeatedly:

1. Print a tiny menu: `1) Hello  2) Quit`  
2. Read the user’s choice  

Use `do-while` so the menu always appears at least once.  
If choice is `1`, print `Hello!` and show the menu again.  
If choice is `2`, stop.  
For anything else, print `Unknown` and continue.

---

### Task 9 — Sum a line with `split`

Read one line of integers separated by spaces, e.g. `10 20 30`.  
Use `split(" ")`, skip empty pieces if needed, convert with `toInt()`, and print the sum.

**Sample**

```text
Enter numbers: 10 20 30
Sum = 60
```

---

### Challenge (optional)

Read a comma-separated list of names (`Ada, Grace, Alan`).  
`split(",")`, `trim()` each name, and print each on its own line with an index using `for (i in names.indices)`:

```text
0: Ada
1: Grace
2: Alan
```

---

## Done checklist

- [ ] Task 1: indexing + `size`  
- [ ] Task 2: `mutableListOf` add / update  
- [ ] Task 3: `repeat`  
- [ ] Task 4: `while` countdown  
- [ ] Task 5: `for` over elements and over indices  
- [ ] Task 6: `..` / `downTo` / `until` / `step`  
- [ ] Task 7: `in` range check  
- [ ] Task 8: `do-while` menu  
- [ ] Task 9: `split` + sum  

**Submit:** as specified by your lecturer.
