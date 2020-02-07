package library.ellen.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

fun writeBooks() {
    val mapper = jacksonObjectMapper()
    val books = ArrayList<Book>()
    var bookName = arrayListOf<String>("Harry Potter", "Sherlock Holmes #1", "Sherlock Holmes #2")

    // Add elem to collection.
    (1..3).forEach { n ->
        books.add(
            Book(
                bookName[n - 1],
                "00${n + 1}",
                true
            )
        )
    }

    // Convert Collection to JSON.
    mapper
        .writerWithDefaultPrettyPrinter()
        .writeValue(File("./my_books.json"), books)
}

fun readBooks() {
    val mapper = jacksonObjectMapper()
    val books = mapper.readValue<ArrayList<Book>>(File("./my_books.json"))
    println(books)
}


fun writePeople() {
    val mapper = jacksonObjectMapper()
    val people = ArrayList<Person>()
    var personName = arrayListOf<String>("Ellen", "Justin", "WB")

    // Add elem to collection.
    (1..3).forEach { n ->
        people.add(
            Person(
                personName[n - 1],
                "00${n + 1}"
            )
        )
    }

    // Convert Collection to JSON.
    mapper
        .writerWithDefaultPrettyPrinter()
        .writeValue(File("./my_people.json"), people)
}

fun readPeople() {
    val mapper = jacksonObjectMapper()
    val people = mapper.readValue<ArrayList<Person>>(File("./my_people.json"))
    println(people)
}