import method.notNullInput
import method.mangement.*
import method.menuUpdate


fun menuComp() {
    println("1. 회사 생성\t2. 회사 수정\t3. 전체 회사 출력\t4. 특정 회사 정보 출력\t5. 회사 삭제\n")
    val menu: String?
    menu = readLine()!!
    when (menu) {
        "1" -> {
            addCompany()
            println("추가 완료!")
        }

        "2" -> {
            menuUpdate("회사", searchCompany)
        }

        "3" -> allPrint(0)
        "4" -> {
            println("어느 회사를 보시겠습니까?")
            val target = notNullInput("회사", searchCompany)
            readCompany(target!!)
        }

        "5" -> {
            println("어느 회사를 삭제하시겠습니까?")
            val target = notNullInput("회사", searchCompany)
            deleteCompany(target!!)
            println("삭제 완료")
        }

        else -> {
            flag = true
            println("범위를 벗어난 입력")
        }
    }
}

fun menuIdol() {
    println("1. 아이돌 생성\t2. 아이돌 수정\t3. 전체 아이돌 출력\t4. 특정 아이돌 정보 출력 5. 아이돌 행사 보내기\t6. 아이돌 행사 출력\t7. 아이돌 행사 삭제 \t8. 아이돌 삭제")
    val menu: String?
    menu = ConsoleReader.consoleScanner()
    when (menu) {
        "1" -> {
            addIdol()
            println("추가 완료!")
        }

        "2" -> {
            menuUpdate("회사", searchIdol)
        }

        "3" -> allPrint(1)
        "4" -> {
            println("어느 아이돌의 정보를 보시겠습니까?")
            val target = notNullInput("아이돌", searchIdol)
            readIdol(target!!)
        }

        "5" -> {
            println("어느 아이돌을 보내겠습니까?")
            val idolTarget = notNullInput("아이돌", searchIdol)

            println("어느 행사에 보내겠습니까?")
            val eventTarget = notNullInput("행사", searchEvent)

            if (addIdolEvent(idolTarget!!, eventTarget!!)) println("행사 컨택 완료")
        }

        "6" -> {
            val target = notNullInput("아이돌", searchIdol)
            readIdolEvent(target!!)
        }

        "7" -> {
            println("어느 아이돌의 행사를 삭제하겠습니까?")
            val idolTarget = notNullInput("아이돌", searchIdol)

            println("어느 행사를 삭제하시겠습니까?")
            val eventTarget = notNullInput("행사", searchEvent)

            deleteIdolEvent(idolTarget!!, eventTarget!!)
            println("${idolTarget}의 ${eventTarget} 행사 삭제 완료")
        }

        "8" -> {
            println("어느 아이돌을 삭제하시겠습니까?")
            val target = notNullInput("아이돌", searchIdol)
            deleteIdol(target!!)
            println("삭제 완료")
        }

        else -> {
            flag = true
            println("범위를 벗어난 입력")
        }
    }
}

fun menuEvent() {
    println("1.행사 생성\t2. 행사 수정\t3. 전체 행사 출력\t4. 특정 행사 정보 출력\t5. 행사 삭제")
    val menu: String?
    menu = ConsoleReader.consoleScanner()
    when (menu) {
        "1" -> {
            addEvent()
            println("추가 완료")
        }

        "2" -> {
            menuUpdate("회사", searchEvent)
        }

        "3" -> allPrint(2)
        "4" -> {
            println("어느 행사의 정보를 보시겠습니까?")
            val target = notNullInput("행사", searchEvent)
            readEvent(target!!)
        }

        "5" -> {
            println("어느 행사를 삭제하시겠습니까?")
            val target = notNullInput("행사", searchEvent)
            deleteEvent(target!!)
            println("삭제 완료")
        }

        else -> {
            flag = true
            println("범위를 벗어난 입력")
        }
    }
}
