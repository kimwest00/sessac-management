package method.console

import method.util.allPrint
import method.util.menuInput
import util.COMP
import util.EVENT
import util.IDOL

val menuName = mapOf("1" to "회사", "2" to "아이돌", "3" to "행사")

// print 컨트롤러
fun mainStart() {
    var menu: String?
    try {
        for (item in listOf(COMP, IDOL, EVENT)) {
            allPrint(item)
            println("\n")
        }
        do {
            printMain()
            menu = menuInput(3)
            if (menu == "exit") break
            choiceObject(menu)
        } while (true)
    } catch (e: Exception) {
        println("어딘가 에러 메시지 : $e")
    }
}

fun choiceObject(inputMenu: String?) {
    println("선택한 메뉴 : ${menuName[inputMenu]}")
    when (inputMenu) {
        "1" -> menuComp()
        "2" -> menuIdol()
        "3" -> menuEvent()
        else -> println("")
    }
}

// 전체 내용 출력

fun printMain() {
    println(
        "\n\n" +
                """            
열람 할 정보를 선택해주세요. (ex, 1-3)
1.회사		2. 아이돌	3. 행사

종료를 원하시면 "exit"을 입력해주세요.
    """.trimIndent()
    )
}