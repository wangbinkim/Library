package library.justin

import library.ellen.data.*

fun 추가하라관리자를() {
    println("아이디")
    var id = readLine()!!
    println("패스워드")
    var password = readLine()!!
    관리자들.add(관리자(id, password))
    println("추가되었습니다.")
}

fun 삭제하라관리자를() {
    println("삭제할 아이디")
    var id = readLine()!!
    println("삭제할 아이디의 패스워드")
    var password = readLine()!!
    var 검색된관리자 = 관리자들.find { it.아이디 == id }
    if (검색된관리자?.패스워드 == password) {
        관리자들.remove(검색된관리자)
        println(id + "님의 정보는 삭제되었습니다.")
    } else {
        println("삭제 실패")
    }
}

fun 변경하라관리자비밀번호를() {
    println("아이디")
    var id = readLine()!!
    println("패스워드")
    var password = readLine()!!
    var 찾은관리자 = 관리자들.find { it.아이디 == id }
    if (찾은관리자 != null) {
        찾은관리자?.패스워드 = password
        println(id + "님의 패스워드는 변경되었습니다.")
    } else {
        println("변경 실패")
    }

}

fun main() {
    library.ellen.data.loadData()
    print("아이디입력 :")
    var 아이디 = readLine()
    var a = 관리자들.find { it.아이디 == 아이디 }

    print("패스워드입력 :")
    var 패스워드 = readLine()
    if (a?.패스워드 != 패스워드) {
        println("로그인 실패")
        return
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

fun print대출현황을() {
    var 대출현황 = library.ellen.printBorrowedBook()
    if (대출현황 != null) {
        대출현황.forEach {
            print("책이름 : ")
            it.borrowedBookInfo.forEach { b ->
                print("[${b.name}] ")
            }
            println("회원번호 : ${it.personNum}")
        }
    } else {
        println("대출된 책이 없습니다.")
    }
    println()
}

fun runProgram() {
    minsung@ while (true) {
        println(
            "0: 반납 1: 검색 2: 대출 3:대출현황 4:종료 및 저장 5:있는 책과 회원이름 6:관리자 관리 " +
                    "7: 회원정보 관리 8: 책 관리"
        )
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
            "6" -> {
                println("1: 관리자 추가 2: 관리자 삭제 3: 관리자 비밀번호변경")
                var inputValue = readLine()!!
                when (inputValue) {
                    "1" -> 추가하라관리자를()
                    "2" -> 삭제하라관리자를()
                    "3" -> 변경하라관리자비밀번호를()
                }

            }
            "7" -> {
                println("1: 회원 추가 2: 회원 삭제 3: 회원 이름변경")
                var inputValue = readLine()!!
                when (inputValue) {
                    "1" -> {
                        println("추가할 회원이름 입력")
                        var personNameToAdd = readLine()!!
                        println("추가할 회원번호 입력")
                        var personNumberToAdd = readLine()!!
                        library.ellen.addPerson(personNameToAdd, personNumberToAdd)
                    }
                    "2" -> {
                        println("삭제할 회원번호 입력")
                        var personNumberToRemove = readLine()!!
                        library.ellen.removePerson(personNumberToRemove)
                    }
                    "3" -> {
                        println("수정할 회원번호 입력")
                        var personNumberToEdit = readLine()!!
                        library.ellen.editPerson(personNumberToEdit)
                    }
                }
            }
            "8" -> {
                println("1: 책 추가 2: 책 삭제 3: 책 이름변경")
                var inputValue = readLine()!!
                when (inputValue) {
                    "1" -> {
                        println("추가할 책 입력")
                        var bookNameToAdd = readLine()!!
                        println("추가할 책번호 입력")
                        var bookNumberToAdd = readLine()!!
                        library.ellen.addBook(bookNameToAdd, bookNumberToAdd)
                    }
                    "2" -> {
                        println("삭제할 책번호 입력")
                        var bookNumberToRemove = readLine()!!
                        library.ellen.removeBook(bookNumberToRemove)
                    }
                    "3" -> {
                        println("수정할 책번호 입력")
                        var bookNumberToEdit = readLine()!!
                        library.ellen.editBook(bookNumberToEdit)
                    }
                }
            }
            else -> {
                println("지원하지않습니다.")
            }
        }
    }
}