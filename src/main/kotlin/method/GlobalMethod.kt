package method

import COMP
import IDOL
import EVENT
import completeUpdate
import fieldList
import fieldListIdx
import infofIdx
import menuInput
import method.mangement.updateCompany
import method.mangement.updateEvent
import method.mangement.updateIdol

fun <T> checkExist(comment: String, searchFunction: (String) -> T): String? {
    var isExist = false
    var tmpField: String? = null
    while (!isExist) {
        print("${comment} 입력 : ")
        tmpField = readln()
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
        tmpField = readln()
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
    println(fieldList(comment))
    val infoIdx = menuInput(fieldListIdx[infofIdx(comment)]).toInt() - 1

    println("무엇으로 바꾸시겠습니까?")
    val goal = checkExist(comment, searchFunction)

    when (comment) {
        COMP -> updateCompany(target!!, goal!!, getDataList(comment)[infoIdx])
        IDOL -> updateIdol(target!!, goal!!, getDataList(comment)[infoIdx])
        EVENT -> updateEvent(target!!, goal!!, getDataList(comment)[infoIdx])
    }
    println("${comment} 정보 $completeUpdate")
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

