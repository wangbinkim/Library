package library.ellen

import library.ellen.data.*


fun main() {

    makeBasicInformation()
    saveData()

    // 전달 to 민성 시작할때 로드 종료할 때 세이브 할 것
}

fun searchBook(bookName: String): ArrayList<Book>? {
    var bookList = ArrayList<Book>()
    books.filter { it.name.contains(bookName) }.forEach { b ->
        //        L(b.name)
        bookList.add(b)
    }
    if (bookList != ArrayList<Book>()) {
        L(bookList)
        return bookList
    } else return null
} //완료됨

fun borrowBook(personNumber: String, bookNumber: String): ReturnedInfo {
    var p = people.find { it.personNum == personNumber }
    var b = books.find { it.bookNum == bookNumber }

    if (p != null) {
        if (b != null) {
            if (!b.borrowable) {
                L("대출중")
                return ReturnedInfo(p.name, b.name, 130)
            } else {
                L("${p.name} 님 ${b.name} 가 대출됨") // 지우기
                p.borrowedBookInfo.add(b)
                b.borrowable = false
//                L("대출됨")
                return ReturnedInfo(p.name, b.name, 120)

            }
        } else {
            L("책없음")
            return ReturnedInfo(null, null, 110)
        }
    }
    L("회원 없음")
    return ReturnedInfo(null, null, 100)
}


fun returnBorrowedBooks(bookNumber: String): ReturnedInfo {
    var b = books.find { it.bookNum == bookNumber }
    var p = people.find { it.borrowedBookInfo.contains(b) }

    if (b != null) {
        if (p != null) {
            b.borrowable = true
            p.borrowedBookInfo.remove(b)
            L("${p.name} 님 ${b.name} 반납됨") // 지우기
            return ReturnedInfo(p.name, b.name, 200)
        } else return ReturnedInfo(null, null, 210)
    } else return ReturnedInfo(null, null, 220)
} // 완료됨

fun printBorrowedBook(): List<Person>? {
    var p = people.filter { it.borrowedBookInfo.size > 0 }
    L("checkBorrowedBook()  :  " + p) // remove
    if (p.size > 0) {
        return p
    } else return null
}


fun L(s: Any) {
    println("ellen log : $s")
}

fun L(s: Any, n: Int): Int {
    println("ellen log : $s")
    return n
}


// 아빠답안지
/*
var p = people.find { it.personNum == personNumber }
var b = books.find { b -> b.bookNum == bookNumber }

if (b != null) {
    if (b.borrowed) L("대출중")
    else {
        if (p != null) {
            p.borrowedBookImf.add(b)
            b.borrowed = true
            L("${p.name} 님 ${b.name} 가 대출되었습니다")
        } else {
            L("사람없음")
        }
    }
} else {
    L("책없음")
}
*/


//  var borrowedcheck = false

//    myloop@ for (i in 0 until books.size) {
////        L(" i = $i")
//        for (o in 0 until people.size) {
////            L(" o = $o")
//            if (personNumber == people[o].personNum && bookNumber == books[i].bookNum) {
//                people[o].borrowedBook = books[i].name
//                books[i].borrowed = false
//                borrowedcheck = true
//                L("${people[o].name}님 ${books[i].name}가 대출되었습니다.")
//                L(people[o])
//                L(books[i])
//                break@myloop
//            }
//        }
//    }
//
//    if (!borrowedcheck) {
//        L("잘못된 입력값이 있습니다.")
//    }
//}

//fun runProgram() {}
//fun 대출하라책을() {}
//fun 반납하라책을() {}
//fun 검색해서출력하라책을() {}
//예제

// 아빠답안지
//    }
//        L("${it.name} -> ${it.borrowedBookImf}")
//    people.forEach {
//    L("----------사람마다빌린책------------------------")
//
//    }
//        L(it)
//    books.filter { it.borrowed }.forEach {
//    L("-----------대출중인책리스트확인-----------------------")
//
//    }
//        L("${it.name} -> ${it.borrowedBookImf}")
//    people.forEach {
//    L("----------사람마다빌린책------------------------")
//
//    borrowBook("003", "002")
//    borrowBook("001", "003")
//    L("----------대출실행------------------------")
//
//    }
//        people.find { p -> p.borrowedBookImf.contains(it) }?.borrowedBookImf?.remove(it)
//        it.borrowed=false
//        L(it)
//    books.filter { it.name.contains("Holm") }.forEach {
//    L("-----------Holm검색 후 반납-----------------------")
//
//    }
//        L("${it.name} -> ${it.borrowedBookImf}")
//    people.forEach {
//    L("----------사람마다빌린책------------------------")
//
//
//    borrowBook("001", "002")
//    borrowBook("001", "001")
//
//    borrowBook("001", "111")
//    borrowBook("111", "002")
//    L("----------대출실행------------------------")
//
//    }
//        L(it)
//    books.filter { it.borrowed }.forEach {
//    L("----------대출중------------------------")
//대출불가능일 때 -> false 리턴, 대출가능하면 true 리턴

//        L(it.name)
//    books.forEach {
//    }
//        L(i)
//    for( i in 1..books.size){

//fun returnBook(bookNumber: String) {
//    var loopValue = 0
//    for (i in 0 until people.size) {
//        if (bookNumber == people[i].borrowedBookImf) {
//            people[i].borrowedBookImf = "None"
//            books[i].borrowed = true
//            L("${people[i]}님 반납이 완료되었습니다.")
//        }
//    }
//    if (books[loopValue].borrowed != false) {
//        L("반납할 수 없는 책입니다.")
//    }
//
//}

// todo 저장 기능 만들기 ** data.kt && untitled  활용 



