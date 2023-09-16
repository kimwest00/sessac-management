import data.ObjectManagement
import kotlinx.coroutines.*
import method.mangement.*
import java.io.*

val menuName = mapOf("1" to "회사", "2" to "아이돌", "3" to "행사")
var flag = true

// print 컨트롤러
fun printController() {
    var line: String?
    try {
        do {
            printMain()
            line = ConsoleReader.consoleScanner()
            if (line.equals("exit")) break
            consoleController(line)
        } while (true)
    } catch (_: Exception) {
    }

}

// 콘솔 컨트롤러
fun consoleController(inputMenu: String?) {
    flag = false
    println("선택한 메뉴 : ${menuName[inputMenu]}")
    when (inputMenu) {
        "1" -> menuComp()
        "2" -> menuIdol()
        "3" -> menuEvent()
        else -> {
            flag = true
            println("잘못 입력")
        }
    }
}

fun menuComp() {
    println("1. 회사 생성\t2. 회사 수정\t3. 전체 회사 출력\t4. 특정 회사 정보 출력\t5. 회사 삭제\n")
    val menu: String?
    menu = ConsoleReader.consoleScanner()
    when (menu) {
        "1" -> addCompany()
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
            if (searchCompany(target) == null) println("없는 회사 입력")
        }
        "5" -> {
            println("어느 회사를 삭제하시겠습니까?")
            val target = ConsoleReader.consoleScanner()
            readCompany(target)
            if (searchCompany(target) == null) println("없는 회사 입력")
        }

        else -> {
            flag = true
            println("범위를 벗어난 입력")
        }
    }
}

fun menuIdol() {
    println("1. 아이돌 생성\t2. 아이돌 수정\t3. 전체 아이돌 출력\t4. 특정 아이돌 정보 출력 5. 아이돌 행사 보내기\t6. 아이돌 행사 출력\t7. 아이돌 행사 삭제 \t8. 아이돌 삭제")

}

fun menuEvent() {
    println("1.행사 생성\t2. 행사 수정\t3. 전체 행사 출력\t4. 특정 행사 정보 출력\t5. 행사 삭제")
}

fun allPrint(choiceMenu: Int) {
    val choice = when (choiceMenu) {
        0 -> ObjectManagement.compList
        1 -> ObjectManagement.idolList
        2 -> ObjectManagement.eventList
        else -> ObjectManagement.compList
    }
    choice.forEach {
        // 현재 직렬화 되어 있어 해당 부분 fix 필요
        print("회사 : ${it}")
    }
}

fun printMain() {
    println(
        """
열람 할 정보를 선택해주세요. (ex, 1-3)
1.회사		2. 아이돌	3. 행사

종료를 원하시면 "exit"을 입력해주세요.
    """.trimIndent()
    )
}