import method.notNullInput
import method.mangement.*
import method.menuInput
import method.menuUpdate


fun menuComp() {
    println(menuInfo("회사"))
    val menu = menuInput(5)
    when (menu) {
        "1" -> {
            addCompany()
            println(completeAdd)
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
            println(completeDelete)
        }
    }
}

fun menuIdol() {
    println(menuInfo("아이돌") + idolEventInfo)
    val menu = menuInput(8)
    when (menu) {
        "1" -> {
            addIdol()
            println(completeAdd)
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
            println("어느 아이돌을 삭제하시겠습니까?")
            val target = notNullInput("아이돌", searchIdol)
            deleteIdol(target!!)
            println(completeDelete)
        }

        "6" -> {
            println("어느 아이돌을 보내겠습니까?")
            val idolTarget = notNullInput("아이돌", searchIdol)

            println("어느 행사에 보내겠습니까?")
            val eventTarget = notNullInput("행사", searchEvent)

            if (addIdolEvent(idolTarget!!, eventTarget!!)) println("행사 컨택 완료")
        }

        "7" -> {
            val target = notNullInput("아이돌", searchIdol)
            readIdolEvent(target!!)
        }

        "8" -> {
            println("어느 아이돌의 행사를 삭제하겠습니까?")
            val idolTarget = notNullInput("아이돌", searchIdol)

            println("어느 행사를 삭제하시겠습니까?")
            val eventTarget = notNullInput("행사", searchEvent)

            deleteIdolEvent(idolTarget!!, eventTarget!!)
            println("${idolTarget}의 ${eventTarget} 행사 삭제 완료")
        }
    }
}

fun menuEvent() {
    println(menuInfo("메뉴"))
    val menu = menuInput(5)
    when (menu) {
        "1" -> {
            addEvent()
            println(completeAdd)
        }

        "2" -> {
            menuUpdate("행사", searchEvent)
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
            println(completeDelete)
        }
    }
}
