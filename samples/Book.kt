package com.nursace

class MyBook(
    val title: String,
    val author: String,
    val publisher: String,
) {

    fun describe() = println("$title $author $publisher")
}

fun main() {
    val book = MyBook(
        title = "War and Peace",
        author = "Leo Tolstoy",
        publisher = "St. Petersburg"
    )

    book.describe()
}