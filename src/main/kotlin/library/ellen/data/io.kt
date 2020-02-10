package library.ellen.data

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

fun saveData() {
    val mapper = jacksonObjectMapper()


    mapper
        .writerWithDefaultPrettyPrinter()
        .writeValue(File("./my_people_saveData.json"),people)

    mapper
        .writerWithDefaultPrettyPrinter()
        .writeValue(File("./my_books_saveData.json"), books)
    //저장
}

fun loadData() {
    val mapper = jacksonObjectMapper()

    books = mapper.readValue<ArrayList<Book>>(File("./my_books_saveData_json"))

    people = mapper.readValue<ArrayList<Person>>(File("./my_people_saveData.json"))

    //불러오기
}
