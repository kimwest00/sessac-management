import data.Company
import data.ObjectManagement
import kotlinx.coroutines.*
import method.mangement.*
import java.io.*

val menuName = mapOf("1" to "회사", "2" to "아이돌", "3" to "행사")
var flag = true

// print 컨트롤러
fun printController() {
    var menu: String?
    try {
        do {
            printMain()
            menu = menuInput(3)
            if (menu == "exit") break
            consoleController(menu)
        } while (true)
    } catch (_: Exception) {
    }

}

// 콘솔 컨트롤러
fun consoleController(inputMenu: String?) {
    println("선택한 메뉴 : ${menuName[inputMenu]}")
    when (inputMenu) {
        "1" -> menuComp()
        "2" -> menuIdol()
        "3" -> menuEvent()
        else -> println("")
    }
}

fun menuInput(endNumber: Int): String {
    while (true) {
        val menu = readlnOrNull()
        if (menu.isNullOrEmpty() || menu.toInt() !in 1..endNumber)
        {
            println("올바른 메뉴 번호를 입력해주세요.")
            continue
        }
        return menu
    }
}

fun allPrint(comment: String) {
    println("$comment 목록은 다음과 같습니다.")
    when (comment) {
        COMP -> for (item in ObjectManagement.compList) print("${item.name} | ")
        IDOL -> for (item in ObjectManagement.idolList) print("${item.name} | ")
        EVENT -> for (item in ObjectManagement.eventList) print("${item.name} | ")
        else -> println("")
    }
}

fun printMain() {
    println(
        "\n" +
                """            
열람 할 정보를 선택해주세요. (ex, 1-3)
1.회사		2. 아이돌	3. 행사

종료를 원하시면 "exit"을 입력해주세요.
    """.trimIndent()
    )
}