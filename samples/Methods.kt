package com.nursace

fun max(list: List<Int>): Int {
    if (list.isEmpty()) {
        return Int.MIN_VALUE
    }
    var mx = list[0]
    for (v in list) {
        if (v > mx) {
            mx = v
        }
    }

    return mx
}

fun max(vararg numbers: Int): Int {

    val mx = numbers[0]

    return mx
}

fun max(a: Short, b: Short) = if (a > b) a else b

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max(a: Double, b: Double): Double {
    return if (a > b) a else b
}

fun max(a: Double, b: Double, c: Double): Double {
    return max(a, max(b, c))
}

fun printMax(a: Int, b: Int) {
    if (a > b) {
        print(a)
    } else {
        print(b)
    }
}

fun describe(title: String, author: String, publisher: String, numberOfPages: Int, color: String) {
    println("Book is $title, $author, $publisher, $numberOfPages, $color")
}

fun main() {
//    val mx = max(1, 2, 3, 4, 5, 6, 7, 8, 9)
//
//    val mx2 = max(listOf(1, 2, 3, 4))
//    println(mx)

    describe(
        author = "Leo Tolstoy",
        title = "War and Peace",
        publisher = "St. Petersburg",
        numberOfPages = 900,
        color = "Red",
    )

}