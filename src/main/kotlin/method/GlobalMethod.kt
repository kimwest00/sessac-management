package method

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
    // 상수화
    println("1. 이름\t2. 주소\t3. 대표\t4. 연락처")
    val infoIdx = readLine()!!.toInt() - 1

    println("무엇으로 바꾸시겠습니까?")
    val goal = readLine()!!

    when (comment) {
        "회사" -> updateCompany(target!!, goal, getDataList(comment)[infoIdx])
        "아이돌" -> updateIdol(target!!, goal, getDataList(comment)[infoIdx])
        "행사" -> updateEvent(target!!, goal, getDataList(comment)[infoIdx])
    }
    println("${comment} 정보 업데이트 완료!")
}

fun getDataList(type: String): List<String> {
    val objectIdx = when (type) {
        "회사" -> listOf("name", "address", "CEO", "Phone")
        "아이돌" -> listOf("name", "companyName", "song")
        "행사" -> listOf("name", "address", "content", "data")
        else -> listOf()
    }
    return objectIdx
}