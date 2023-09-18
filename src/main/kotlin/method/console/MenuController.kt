package method.console

import method.mangement.*
import method.util.allPrint
import method.util.menuInput
import method.util.menuUpdate
import method.util.notNullInput
import util.*

fun menuComp() {
    println(CHOICE_MENU(COMP))
    val menu = menuInput(5)
    when (menu) {
        "1" -> { // 회사 추가
            addCompany()
            println(COMP + ADD_MESSAGE)
        }

        "2" -> menuUpdate(COMP, searchCompany) // 회사 업데이트
        "3" -> allPrint(COMP) // 전체 회사 출력
        "4" -> { // 특정 회사 정보 출력
            println(READ_COMMENT(COMP))
            val target = notNullInput(COMP, searchCompany)
            readCompany(target!!)
        }

        "5" -> { // 회사 삭제
            println(DELETE_COMMENT(COMP))
            val target = notNullInput(COMP, searchCompany)
            deleteCompany(target!!)
            println(DELETE_MESSAGE)
        }
    }
}

fun menuIdol() {
    println(CHOICE_MENU(IDOL) + IDOL_EVENT_MENU)
    val menu = menuInput(8)
    when (menu) {
        "1" -> { // 아이돌 생성
            addIdol()
            println(IDOL + ADD_MESSAGE)
        }

        "2" -> menuUpdate(IDOL, searchIdol) // 아이돌 수정
        "3" -> allPrint(IDOL) // 전체 아이돌 출력
        "4" -> { // 특정 아이돌 정보 출력
            println(READ_COMMENT(IDOL))
            val target = notNullInput(IDOL, searchIdol)
            readIdol(target!!)
        }

        "5" -> { // 아이돌 삭제
            println(DELETE_COMMENT(IDOL))
            val target = notNullInput(IDOL, searchIdol)
            deleteIdol(target!!)
            println(DELETE_MESSAGE)
        }

        "6" -> { // 아이돌 행사 보내기
            println(MEET_IDOL)
            val idolTarget = notNullInput(IDOL, searchIdol)

            println(MEET_EVENT)
            val eventTarget = notNullInput(EVENT, searchEvent)
            if (addIdolEvent(idolTarget!!, eventTarget!!)) println("$EVENT $ADD_MESSAGE")
        }

        "7" -> { // 아이돌 전체 행사 출력
            val target = notNullInput(IDOL, searchIdol)
            readIdolEvent(target!!)
        }

        "8" -> { // 아이돌 행사 취소
            println(CANCEL_MEET)
            val idolTarget = notNullInput(IDOL, searchIdol)

            println(DELETE_COMMENT(EVENT))
            val eventTarget = notNullInput(EVENT, searchEvent)

            deleteIdolEvent(idolTarget!!, eventTarget!!)
            println("${idolTarget}의 ${eventTarget} $DELETE_MESSAGE")
        }
    }
}

fun menuEvent() {
    println(CHOICE_MENU(EVENT))
    val menu = menuInput(5)
    when (menu) {
        "1" -> { // 행사 추가
            addEvent()
            println(EVENT + ADD_MESSAGE)
        }

        "2" -> menuUpdate(EVENT, searchEvent) // 행사 업데이트
        "3" -> allPrint(EVENT) // 전체 행사 출력
        "4" -> { // 특정 행사출력
            println(READ_COMMENT(EVENT))
            val target = notNullInput(EVENT, searchEvent)
            readEvent(target!!)
        }

        "5" -> { // 행사 삭제
            println(DELETE_COMMENT(EVENT))
            val target = notNullInput(EVENT, searchEvent)
            deleteEvent(target!!)
            println(DELETE_MESSAGE)
        }
    }
}
