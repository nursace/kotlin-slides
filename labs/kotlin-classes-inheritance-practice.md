# Kotlin Classes and Inheritance Practice

> Focused code-writing sheet for **classes, inheritance, and polymorphism**.  
> Complements the full-module sheet [`kotlin-oop-practice-challenges.md`](kotlin-oop-practice-challenges.md).

**Course:** Kotlin Object-Oriented Programming  
**Related lectures:** `06-oop-intro-classes.tex`, `09-inheritance-polymorphism.tex`  
**Format:** Complete Kotlin classes + `fun main()` drivers  
**Level:** University / mid — multi-step; not fill-in-the-blank  
**No full solutions** — light hints only

|                    |                                                                                                                                            |
|--------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| **Estimated time** | 2.5–4 hours                                                                                                                                |
| **Scope**          | Classes & objects · primary constructors · visibility · `open` / `override` · `super` · upcast / downcast / smart cast · polymorphic lists |
| **Constraints**    | Several classes per file is fine. Prefer primary constructors. Mark hierarchies `open` where subclassing is required.                      |

---

## Goals

1. Build types with primary constructors, validation, and controlled visibility.
2. Extend open base classes with `override` and compose behaviour via `super`.
3. Use base-typed references (upcast), safe checks (`is` / `as?`), and polymorphic dispatch.
4. Combine inheritance + polymorphism in small domain models.

---

## Instructions

1. Write **compilable Kotlin** for every task — not sketches.
2. Honour encapsulation where asked (private state, public API).
3. Handle listed edge cases; crashing on bad input without `require` / clear failure is incomplete.
4. Match sample behaviour / I/O shape when given.
5. Discuss approaches freely; do not share finished solutions.

---

## Tasks

### Task 1 — Sensor with primary constructor

Implement `class Sensor(val id: String, var reading: Double)`:

- `init { require(id.isNotBlank()) }`
- `fun update(reading: Double)` — reject non-finite values
- `override fun toString(): String` → `Sensor(id=…, reading=…)`

In `main`, create two sensors, update one, print both.

**Edge case:** blank `id` must fail construction.

---

### Task 2 — Encapsulated counter

`class Counter(start: Int = 0)`:

- Store value in a **private** `var`
- `fun value(): Int`
- `fun inc(step: Int = 1)` / `fun reset()`
- Reject `step <= 0` on `inc`

Demonstrate default construction and `inc(2)` from `main`.

**Hint:** Header param `start` need not be a property if you assign a private field.

---

### Task 3 — Vehicle hierarchy (`open` / `override`)

```text
open class Vehicle(val brand: String) {
    open fun info(): String
    open fun maxSpeedKmh(): Int
}
```

- `class Car(brand, val doors: Int) : Vehicle(brand)` — override both methods
- `class Bike(brand, val gears: Int) : Vehicle(brand)` — override both

`info()` should mention brand and subclass-specific fields.  
In `main`, print `info()` and `maxSpeedKmh()` for one of each.

**Edge cases:** `doors >= 2`, `gears >= 1`, non-blank `brand`.

---

### Task 4 — Payroll with `super` (employee family)

Port the lecture idea into working code:

- `open class Employee(val name: String, val baseSalary: Int)`
    - `open fun pay(): Int = baseSalary`
    - `open fun describe(): String = "$name: ${pay()}"`
- `class Accountant(name, baseSalary, val bonusPercent: Int) : Employee(...)`
    - `pay()` = `super.pay()` plus percent bonus (integer arithmetic OK)
    - `describe()` may call `super.describe()` and prefix `"Accountant "`
- `class Intern(name, baseSalary, val mentor: String) : Employee(...)`
    - `pay()` = `super.pay() / 2` (still call `super.pay()`, do not duplicate the field read only)

Build a `List<Employee>` with all three kinds; print each `describe()` and the sum of `pay()`.

**Constraints:** `bonusPercent in 0..100`; salaries / names validated.

---

### Task 5 — Polymorphic shipping costs

```text
open class Parcel(val id: String, val weightKg: Double)
class ExpressParcel(...) : Parcel(...)
class EconomyParcel(...) : Parcel(...)
```

- Base: `open fun shippingCost(): Double` — e.g. `weightKg * 2.0`
- Express: override to `super.shippingCost() + 15.0` (surcharge on top of base formula)
- Economy: override to `super.shippingCost() * 0.8`

Write `fun totalShipping(parcels: List<Parcel>): Double`.  
In `main`, mix types in one list and print the total (2 decimal places is fine).

---

### Task 6 — Upcast catalogue

Using Task 3’s `Vehicle` hierarchy (or an equivalent you rewrite in-file):

1. Create `val v: Vehicle = Car("Volvo", 4)` (explicit **upcast**).
2. Call `v.info()` and confirm the **Car** override runs.
3. Write `fun printFleet(fleet: List<Vehicle>)` that prints each `info()` on its own line.

**Sample shape**

```text
Car Volvo, doors=4
Bike Trek, gears=18
```

---

### Task 7 — Smart cast and safe downcast

Continue with `Vehicle` / `Car` / `Bike`:

```kotlin
fun doorsOrZero(v: Vehicle): Int
```

- If `v is Car`, return `v.doors` via **smart cast** (no `as`).
- Otherwise return `0`.

Also write a demo that:

1. Does `val c = (Bike("X", 3) as? Car)` and prints `null` / a clear message.
2. Shows that `as Car` on a `Bike` would throw — comment it out; do **not** leave a crashing line in the submitted `main`.

---

### Task 8 — Graded assessment hierarchy

Domain for a course module:

- `open class Assessment(val title: String, val maxPoints: Int)`
    - `open fun scoreTowardGrade(raw: Int): Double` — default: `(raw.coerceIn(0, maxPoints)).toDouble() / maxPoints`
- `class Quiz(title, maxPoints, val penaltyIfLate: Double) : Assessment(...)`
    - Override scoring: apply parent ratio, then multiply by `(1.0 - penaltyIfLate)` with `penaltyIfLate in 0.0..0.5`
    - Use `super.scoreTowardGrade(raw)` inside the override
- `class Project(title, maxPoints, val bonusCap: Double) : Assessment(...)`
    - If `raw > maxPoints`, allow up to `maxPoints * (1.0 + bonusCap)` before normalising to a ratio that may exceed `1.0` but not `1.0 + bonusCap`
    - Document your formula in a short comment; must call `super` at least once **or** justify in a comment why the parent formula is fully replaced (prefer calling `super` on the coerced raw portion)

In `main`, put quizzes/projects in `List<Assessment>`, print each title and computed score for a fixed `raw`.

---

### Task 9 — Notification channels (polymorphism + visibility)

```text
open class Notification(private val payload: String) {
    protected fun body(): String = payload
    open fun render(): String = body()
}
class EmailNotification(payload: String, val to: String) : Notification(payload)
class SmsNotification(payload: String, val phone: String) : Notification(payload)
```

- Subclasses override `render()` to include channel metadata **and** `body()` / equivalent access to payload (they can see `protected` `body()`).
- Outsiders must **not** read `payload` directly.
- `fun sendAll(items: List<Notification>)` prints each `render()`.

**Hint:** If you add a public `payload` property, you have broken the task.

---

### Task 10 — Zoo ticketing (combine hierarchy + casts)

```text
open class Ticket(val code: String, val basePrice: Int)
class AdultTicket(...) : Ticket(...)
class ChildTicket(..., val guardianCode: String) : Ticket(...)
class VipTicket(..., val loungeAccess: Boolean) : Ticket(...)
```

Rules:

- `open fun price(): Int = basePrice` on `Ticket`
- Child: `price()` = `super.price() / 2`
- VIP: `price()` = `super.price() + if (loungeAccess) 50 else 20`

Write:

```kotlin
fun checkout(tickets: List<Ticket>): Int
fun childGuardianCodes(tickets: List<Ticket>): List<String>
```

`childGuardianCodes` keeps order of appearance; use `is` + smart cast (or `filterIsInstance` **only if** you also show one explicit `is` loop elsewhere in the file).

In `main`, build a mixed list, print checkout total and guardian codes.

**Sample idea**

```text
total=230
guardians=G-1, G-9
```

---

## Lecture mapping

| Tasks     | Lecture focus                               |
|-----------|---------------------------------------------|
| 1–2       | 06 — class, object, constructor, visibility |
| 3–5, 8–10 | 09 — inheritance, `super`, polymorphism     |
| 6–7       | 09 — upcast, downcast, smart cast           |
