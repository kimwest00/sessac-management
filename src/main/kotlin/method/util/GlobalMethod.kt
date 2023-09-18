package method.util

import util.*
import data.ObjectManagement
import method.console.ConsoleReader
import method.mangement.updateCompany
import method.mangement.updateEvent
import method.mangement.updateIdol

fun <T> checkExist(comment: String, searchFunction: (String) -> T): String? {
    var isExist = false
    var tmpField: String? = null
    while (!isExist) {
        print("${comment} 입력 : ")
        tmpField = ConsoleReader.consoleLineInput()
        searchFunction(tmpField)?.let {
            println("중복되는 ${comment}이 있습니다. 다시 입력해주세요 ")
        } ?: run {
            isExist = true
        }
    }
    return tmpField
}


fun <T> notNullInput(comment: String, searchFunction: (String) -> T): String? {
    var isExist = false
    var tmpField: String? = null
    while (!isExist) {
        print("${comment} 입력 : ")
        tmpField = ConsoleReader.consoleLineInput()
        searchFunction(tmpField)?.let {
            isExist = true
        } ?: run {
            println("${comment}가 없습니다. 다시 입력해주세요 ")
        }
    }
    return tmpField
}

fun <T> menuUpdate(comment: String, searchFunction: (String) -> T) {
    val target = notNullInput(comment, searchFunction = searchFunction)

    println("바꿀 $comment 정보를 숫자로 입력해 주세요.")
    println(FIELD(comment))
    val infoIdx = menuInput(FIELD_IDX[INFO_IDX(comment)]).toInt() - 1

    println("무엇으로 바꾸시겠습니까?")
    val goal = checkExist(comment, searchFunction)

    when (comment) {
        COMP -> updateCompany(target!!, goal!!, getDataList(comment)[infoIdx])
        IDOL -> updateIdol(target!!, goal!!, getDataList(comment)[infoIdx])
        EVENT -> updateEvent(target!!, goal!!, getDataList(comment)[infoIdx])
    }
    println("${comment} 정보 $UPDATE_MESSAGE")
}


fun menuInput(endNumber: Int): String {
    while (true) {
        val menu = readlnOrNull()
        if (menu == "exit") return menu
        if (menu.isNullOrEmpty() || menu.toIntOrNull() !in 1..endNumber) {
            println("올바른 메뉴 번호를 입력해주세요.")
            continue
        }
        return menu
    }
}


fun getDataList(type: String): List<String> {
    val objectIdx = when (type) {
        COMP -> listOf("name", "address", "CEO", "Phone")
        IDOL -> listOf("name", "companyName", "song")
        EVENT -> listOf("name", "address", "content", "date")
        else -> listOf()
    }
    return objectIdx
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

