import data.Company
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
            if (line == "exit") break
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

fun menuInput(endNumber: Int): String {
    while (true) {
        val menu = readlnOrNull()
        if (menu.isNullOrEmpty() || menu.toInt() !in 1..endNumber) continue
        return menu
    }
}

fun allPrint(choiceMenu: Int) {
    when (choiceMenu) {
        0 -> {
            println("회사 목록은 다음과 같습니다.")
            for (item in ObjectManagement.compList) print("${item.name}, ")
            println("")
        }
        1 -> {
            println("아이돌 목록은 다음과 같습니다.")
            for (item in ObjectManagement.idolList) print("${item.name}, ")
            println("")

        }
        2 -> {
            println("행사 목록은 다음과 같습니다.")
            for (item in ObjectManagement.eventList) print("${item.name}, ")
            println("")

        }
        else -> ObjectManagement.compList
    }
}

fun printMain() {
    println("\n" +
        """            
열람 할 정보를 선택해주세요. (ex, 1-3)
1.회사		2. 아이돌	3. 행사

종료를 원하시면 "exit"을 입력해주세요.
    """.trimIndent()
    )
}