package library.justin.library.justin

import library.ellen.data.*

fun justin() {

}


fun main() {
    makeBasicInformation()

    books.forEach {
        println("BOOK : ${it.name} :: ${it.bookNum}")
    }

    println("BOOKS : $books ")

    people.forEach { p ->
        println("PERSON : ${p.name}")
    }


    while (true) {
        println("0:반납 1:검색 2:대출 3:대출현황 4:종료")
        var inpValue = readLine()!!
        if (inpValue == "4") {
            println("도서대출프로그램을 종료합니다.")
            break
        } else {
            runProgram(inpValue)
        }
    }

}

fun borrowBook(personNumber: String, bookNumber: String) {

}

fun checkBorrowedBook(bookNumber: String): Boolean {
    return true
}


fun 대출하라book() {
    println("책번호")
    var inpBookNumber = readLine()!! // 책번호
    println("회원번호")
    var inpPersonNumber = readLine()!! // 회원번호

    if (checkBorrowedBook(inpBookNumber) == true) {
        borrowBook(inpPersonNumber, inpBookNumber)
        println("대출되었습니다.")
    } else {
        println("대출이 불가능합니다.")
    }

}

fun returnBook(bookNumber: String) {

}

fun 반납하라book() {
    println("책번호")
    var 반납할책 = readLine()!!
    returnBook(반납할책)
    println("반납되었습니다.")

}

fun searchBook(bookName: String): ArrayList<Book>? {
    return null
}

fun 검색해서출력하라책을() {
    var 검색할책 = readLine()!!
    var 검색된책 = searchBook(검색할책)
    if (검색된책 == null) {
        println("검색결과가 없습니다.")
    } else {
        println(검색된책)
    }
}

fun returnBorrowedBooks(): ArrayList<Person>? {
    return ArrayList<Person>()
}

fun print대출현황을() {
    var 대출현황 = returnBorrowedBooks()
    println(대출현황)
}

fun runProgram(userValue: String) {
    when (userValue) {
        "0" -> {
            반납하라book()
        }
        "1" -> {
            검색해서출력하라책을()
        }
        "2" -> {
            대출하라book()
        }
        "3" -> {
            print대출현황을()
        }
        else -> {
            println("지원하지않습니다.")

        }
    }


}