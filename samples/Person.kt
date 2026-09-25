package com.nursace

class Person {
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun introduce() = println("$name is $age")
}

fun main() {
    val p: Person = Person("Ada", 35)

    p.introduce()
}