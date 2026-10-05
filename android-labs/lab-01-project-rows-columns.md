# Introduction to Android with Jetpack Compose

**Lab 01 — Project setup, Rows, Columns, and Alignment**  
*First Android Studio lab. Code-writing practice with Compose layouts.*

## Prerequisites

Before you start:

- **Android Studio** installed (Ladybug / Koala / newer is fine)
- Android SDK and at least one **Virtual Device** (AVD) created (API 34+ recommended)
- Basic Kotlin: functions, named arguments, trailing lambdas (enough to read Compose code)
- A working laptop with enough disk for the emulator

---

## Instructions

- Prefer **Empty Activity** with **Jetpack Compose** enabled.
- Work in `MainActivity.kt` (or a small composable file you create next to it). Keep one screen for this lab.
- Use Compose APIs: `Row`, `Column`, `Arrangement`, `Alignment`, `Modifier`, `Text`, `Button` / `OutlinedTextField` as needed.
- Submit **source + short screenshots/descriptions** of your running app — **not** a full solution APK.

**Allowed reminders**

- `Column` stacks children **top → bottom**; `Row` places them **start → end**
- `horizontalAlignment` on a `Column` aligns children across the width
- `verticalAlignment` on a `Row` aligns children across the height
- `horizontalArrangement` / `verticalArrangement` control **spacing along the main axis**
- `Modifier.weight(1f)` (inside `Row`/`Column` with a bounded size) shares leftover space

---

### A1. New project

1. Open **Android Studio** → **New Project**.
2. Choose **Empty Activity** (Compose template).
3. Settings (adjust names if your course requires a package):
   - **Name:** `CampusCardLab` (or similar)
   - **Package name:** e.g. `kg.iuca.campuscard`
   - **Minimum SDK:** API 24+ is fine
   - **Build configuration language:** Kotlin DSL (default)
4. Finish and wait for Gradle sync.

### A2. Emulator

1. **Device Manager** → create/start a phone AVD if needed.
2. Press **Run** (green triangle) and wait until the default “Hello Android” (or template) screen appears.
3. Confirm the app installs and stays open without crashing.

**Checkpoint:** You have a running Compose app. Do not continue to Part B until this works.

---

## Part B — First `Column`, then `Row`s (~25–35 min)

Open the main composable (often `MainActivity` → `setContent { … }` → a `@Composable` function such as `CampusCardScreen`).

### B1. Replace the template with a vertical stack

Build a **`Column`** that fills the screen and contains three `Text` children, for example:

- Title: `Campus Card`
- Subtitle: your name
- Line: `Student ID: …`

Starter shape (complete and adapt — do not paste blindly if your imports differ):

```kotlin
@Composable
fun CampusCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Campus Card", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Ada Lovelace")
        Text(text = "Student ID: 2026001")
    }
}
```

**What you should see (text sketch):**

```text
┌─────────────────────────────┐
│ Campus Card                 │
│ Ada Lovelace                │
│ Student ID: 2026001         │
│                             │
│                             │
└─────────────────────────────┘
```

### B2. Add a header `Row`

Above the name/ID block, add a **`Row`** with:

- A square “avatar” placeholder (`Box` with fixed `size(56.dp)` and a background color), **and**
- A nested **`Column`** with display name + short status (`Online` / `In class`).

```kotlin
Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(12.dp)
) {
    Box(
        modifier = Modifier
            .size(56.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
    )
    Column {
        Text("Ada Lovelace", style = MaterialTheme.typography.titleMedium)
        Text("In class · Building B")
    }
}
```

**What you should see:**

```text
┌─────────────────────────────┐
│ ┌────┐  Ada Lovelace        │
│ │    │  In class · Building B│
│ └────┘                      │
│ … more content below …      │
└─────────────────────────────┘
```

### B3. Alignment / arrangement experiments (ungraded warm-up)

On the **outer** `Column`, try each pair once and note what moves:

| Experiment | Change | Observe |
|---|---|---|
| 1 | `horizontalAlignment = Alignment.CenterHorizontally` | Texts shift to the center |
| 2 | `horizontalAlignment = Alignment.End` | Texts shift to the right |
| 3 | `verticalArrangement = Arrangement.Center` | Whole stack moves to vertical middle |
| 4 | `verticalArrangement = Arrangement.SpaceBetween` | Children push apart (needs `fillMaxSize`) |

Write one sentence in your report for **two** of these experiments.

---

## Part C — Concrete task: Campus schedule strip (~25–35 min)

Extend the screen into a small **campus profile + today’s schedule** UI using **only nested `Row` / `Column`** (plus simple `Text` / `Box` / one `Button` or `TextButton`).

### Required structure

```text
Column (screen)
├── Row (header: avatar + name/status Column)
├── Text (“Today”)
├── Column (list of class slots)
│   ├── Row (time | course | room)   ← slot 1
│   ├── Row (time | course | room)   ← slot 2
│   └── Row (time | course | room)   ← slot 3
└── Row (actions: e.g. “Map” and “QR” buttons/text)
```

### Functional / visual requirements

1. At least **three** schedule rows; each row has **three** pieces of information (time, course code/title, room).
2. Header uses a **Row** with a nested **Column**.
3. Bottom action bar is a **Row** with two clickable items (`Button`, `TextButton`, or `clickable` Text).
4. Use `Modifier.fillMaxWidth()`, `padding`, and either `Arrangement.SpaceBetween` or `weight` so time stays left and room stays right (or clearly separated).
5. Content must remain readable in portrait on a phone emulator.

**Sample screenshot (text):**

```text
┌──────────────────────────────────┐
│ ╔══╗  Ada Lovelace               │
│ ║  ║  In class · Building B      │
│ ╚══╝                             │
│                                  │
│ Today                            │
│ 09:00   CS101 Intro      Lab 3   │
│ 11:00   MATH210          A-204   │
│ 14:00   Soft Skills      Hall 1  │
│                                  │
│ [ Map ]              [ Show QR ] │
└──────────────────────────────────┘
```

Hardcoding the three classes is fine. No database, no navigation graph, no networking.

---

## Graded exercises

Complete **all** of the following in your project. For each, leave the working code in the project (you may use comments like `// Exercise 3 variant`) **or** restore the final combined UI and describe the temporary experiment in a short `REPORT.md` / lab sheet.

### Exercise 1 — Horizontal alignment on a `Column`

Make the **title block** (`Campus Card` / name / ID, or your equivalent labels) use:

```kotlin
horizontalAlignment = Alignment.CenterHorizontally
```

Keep the **schedule rows** left-aligned (or full-width with internal spacing).  
**Deliverable:** screenshot + one sentence: what stayed left vs what centered.

### Exercise 2 — `SpaceBetween` vs `Center` on a `Row`

On the **bottom action row**, implement two versions (switch with a `var useSpaceBetween by remember { mutableStateOf(true) }` toggle, **or** show them in sequence and screenshot both):

1. `horizontalArrangement = Arrangement.SpaceBetween`
2. `horizontalArrangement = Arrangement.Center` with `Arrangement.spacedBy(16.dp)` (or similar)

**Deliverable:** both screenshots (or one with the toggle) + which arrangement you keep for the final UI and why (one sentence).

### Exercise 3 — Vertical alignment inside a schedule `Row`

For **one** schedule row, make the time `Text` use a larger style than the course title, then set:

```kotlin
verticalAlignment = Alignment.Top   // then try CenterVertically
```

**Deliverable:** brief note: when is `Top` visibly different from `CenterVertically`?

### Exercise 4 — `Modifier.weight` for flexible middle

In each schedule `Row`, give the **course title** `Modifier.weight(1f)` (and keep time/room without weight, or with fixed width). Confirm that long titles expand/shrink between time and room without pushing the room off-screen (use a long fake title to test).

**Deliverable:** one screenshot with a long course name wrapping or ellipsizing reasonably.

### Exercise 5 — Nested layout refactor

Extract at least two `@Composable` functions, for example:

- `fun ProfileHeader(name: String, status: String)`
- `fun ScheduleRow(time: String, title: String, room: String)`

Call them from the screen `Column`. Behavior must stay the same.

**Deliverable:** show the function signatures in your report or leave them clearly named in code.

### Exercise 6 — Arrangement experiment write-up (short)

Change the **outer** screen `Column` to `verticalArrangement = Arrangement.SpaceBetween` while keeping `fillMaxSize()`. Explain in **2–4 sentences** where the header, schedule block, and action row move, and whether that layout is better or worse for a campus card.

---

## What to submit

Follow your course channel, typically:

1. Project source (Git repo or zip **without** `build/` caches if possible)
2. Short report: name, student ID, answers for Exercises 1, 2, 3, and 6
3. 2–4 screenshots of the running emulator

**Grading focus:** correct use of `Row`/`Column`, intentional `Alignment`/`Arrangement`, nested structure, and clear experiments — not visual polish or branding.
