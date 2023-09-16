import method.mangement.*


fun menuComp() {
    println("1. 회사 생성\t2. 회사 수정\t3. 전체 회사 출력\t4. 특정 회사 정보 출력\t5. 회사 삭제\n")
    val menu: String?
    menu = ConsoleReader.consoleScanner()
    when (menu) {
        "1" -> {
            addCompany()
            println("추가 완료!")
        }
        "2" -> {
            println("어느 회사를 수정하시겠습니까?")
            val target = ConsoleReader.consoleScanner()

            val tempCompo = searchCompany(target)
            if (tempCompo == null) println("없는 회사 입력")

            println("수정 할 회사 이름을 입력해 주세요.")
            val name = ConsoleReader.consoleScanner()
            val tempName = searchCompany(name)
            if (tempName != null) println("중복 된 이름 입력")

            searchCompany(target)?.let { updateCompany(target, name, it.id) }
            println("수정 완료!")
        }

        "3" -> allPrint(0)
        "4" -> {
            println("어느 회사를 보시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            readCompany(target)
        }

        "5" -> {
            println("어느 회사를 삭제하시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            if (searchCompany(target) == null) println("없는 회사 입력")
            searchCompany(target)?.let { deleteCompany(it.id) }
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
            println("어느 아이돌을 수정하시겠습니까?")
            val target = ConsoleReader.consoleScanner()

            val tempIdol = searchIdol(target)
            if (tempIdol == null) println("없는 아이돌 입력")

            println("수정 할 회사 이름을 입력해 주세요.")
            val name = ConsoleReader.consoleScanner()
            val tempName = searchIdol(name)
            if (tempName != null) println("중복 된 이름 입력")

            searchIdol(target)?.let { updateIdol(target, name, it.id) }
            println("수정 완료!")
        }

        "3" -> allPrint(1)
        "4" -> {
            println("어느 아이돌의 정보를 보시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            readIdol(target)
        }

        "5" -> {
            println("어느 아이돌을 보내겠습니까?")
            val idolTarget = ConsoleReader.consoleScanner()
            if (searchIdol(idolTarget) == null) println("없는 아이돌 입력")

            println("어느 행사에 보내겠습니까?")
            val eventTarget = ConsoleReader.consoleScanner()
            if (searchEvent(eventTarget) == null) println("없는 행사 입력")

            if (addIdolEvent(idolTarget, eventTarget)) println("즐거운 행사")
            else println("행사 실패")
        }

        "6" -> {
            val target = ConsoleReader.consoleScanner()
            if (searchIdol(target) == null) println("없는 아이돌 입력")
            readIdolEvent(target)
        }

        "7" -> {
            println("어느 아이돌의 행사를 삭제하겠습니까?")
            val idolTarget = ConsoleReader.consoleScanner()
            if (searchIdol(idolTarget) == null) println("없는 아이돌 입력")

            println("어느 행사를 삭제하시겠습니까?")
            val eventTarget = ConsoleReader.consoleScanner()
            if (searchEvent(eventTarget) == null) println("없는 행사 입력")

            deleteIdolEvent(idolTarget, eventTarget)
            println("${idolTarget}의 ${eventTarget} 행사 삭제 완료")
        }

        "8" -> {
            println("어느 아이돌을 삭제하시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            if (searchIdol(target) == null) println("없는 아이돌 입력")
            searchIdol(target)?.let { deleteIdol(it.name) }
            println("아이돌 삭제 완료")
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
            println("어느 행사를 수정하시겠습니까?")
            val target = ConsoleReader.consoleScanner()

            val tempEvent = searchEvent(target)
            if (tempEvent == null) println("없는 행사 입력")

            println("수정 할 행사 이름을 입력해 주세요.")
            val name = ConsoleReader.consoleScanner()
            val tempName = searchEvent(name)
            if (tempName != null) println("중복 된 이름 입력")

            searchEvent(target)?.let { updateEvent(target, name, it.id) }
            println("수정 완료!")
        }

        "3" -> allPrint(2)
        "4" -> {
            println("어느 행사를 보시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            readEvent(target)
        }

        "5" -> {
            println("어느 행사를 삭제하시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            if (searchEvent(target) == null) println("없는 행사 입력")
            searchEvent(target)?.let { deleteEvent(it.id) }
            println("삭제 완료")
        }

        else -> {
            flag = true
            println("범위를 벗어난 입력")
        }
    }
}
