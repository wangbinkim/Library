package library.justin

import library.ellen.data.*

fun main() {
    library.ellen.data.loadData()
    //makeBasicInformation()
    var 관리자 = 관리자들
    var d = 관리자들.find { it.아이디 == "천재민성님" }
    println(d?.패스워드)

    var e = 관리자들.filter { it.아이디.contains("님") }
    e.forEach {
        println(it.패스워드)
    }
    print("아이디입력 :")
    var 아이디 = readLine()
    var a = 관리자들.find { it.아이디 == 아이디 }

    print("패스워드입력 :")
    var 패스워드 = readLine()
    if (a?.패스워드 != 패스워드) {
        println("로그인 실패")
        // return
    }
    println("로그인 성공")
    runProgram()
}

fun 대출하라book() {
    println("책번호를 입력해 주세요.")
    var inpBookNumber = readLine()!! // 책번호
    println("회원번호를 입력해 주세요.")
    var inpPersonNumber = readLine()!! // 회원번호
    var 결과값 = library.ellen.borrowBook(inpPersonNumber, inpBookNumber)
    when (결과값.code) {
        120 -> {
            println("${결과값.personName}님이 요청하신 ${결과값.bookName}은 대출되었습니다.")
        }
        100 -> {
            println("없는 회원번호입니다.")
        }
        110 -> {
            println("없는 책입니다.")
        }
        130 -> {
            println("대출중인 책입니다.")
        }
    }
// 101 102 103 104 사용
}


fun 반납하라book() {
    println("책번호를 입력해 주세요.")
    var 반납할책 = readLine()!!
    var 결과값 = library.ellen.returnBorrowedBooks(반납할책)


    when (결과값.code) {
        200 -> {

            println("${결과값.personName}님이 대출하신 ${결과값.bookName}은 반납이 완료되웠습니다.")
        }
        210 -> {
            println("존재하지않은 회원입니다.")
        }
        220 -> {
            println("책번호가 존재하지 않습니다.")
        }
    }
}


fun 검색해서출력하라책을() {
    println("검색할책을 입력해 주세요.")
    var 검색할책 = readLine()!!
    //var 검색된책 = searchBook(검색할책)

    var 검색된책 = library.ellen.searchBook(검색할책)

    if (검색된책 == null) {
        println("검색결과가 없습니다.")
    } else {
        검색된책.forEach {
            println("책이름 : ${it.name} 책번호 : ${it.bookNum}")
        }
    }
}

// todo 로그인하는 코드 만들기
fun print대출현황을() {
    var 대출현황 = library.ellen.printBorrowedBook()
    if (대출현황 != null) {
        대출현황.forEach {
            print("책이름 : ")
            it.borrowedBookInfo.forEach {
                    b -> print("[${b.name}] ")
            }
            println("회원번호 : ${it.personNum}")
        }
    } else {
        println("대출된 책이 없습니다.")
    }
    println()
}


fun runProgram() {
    minsung@while (true) {
        println("0:반납 1:검색 2:대출 3:대출현황 4:종료 및 저장 5:있는 책과 회원이름")
        var userValue = readLine()!!
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
            "4" -> {
                println("도서대출프로그램을 종료합니다.")
                library.ellen.data.saveData()
                break@minsung
            }
            "5" -> {
                books.forEach { it ->
                    println("${it.name} 책번호 : ${it.bookNum}")
                }
                people.forEach { p ->
                    println("${p.name} 회원번호 : ${p.personNum}")
                }
            }
            else -> {
                println("지원하지않습니다.")
            }
        }
    }
}

fun saveData(books: ArrayList<Book>, people: ArrayList<Person>) {

}

fun loadData() {

}