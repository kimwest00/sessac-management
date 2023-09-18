package method.mangement

import data.Idol
import data.ObjectManagement
import method.console.ConsoleReader
import method.util.checkExist
import method.util.notNullInput
import util.Generator

fun addIdol() {
    val id = Generator.generateEmpNum()
    val name: String?
    val companyName: String?
    try {
        name = checkExist("아이돌 이름", searchFunction = searchIdol)

        companyName = notNullInput("회사 이름", searchFunction = searchCompany)

        print("성별 : ")
        val gender = ConsoleReader.consoleLineInput()

        print("대표 노래 : ")
        val song = ConsoleReader.consoleLineInput()
        ObjectManagement.compList[searchCompanyIdx(companyName!!)].idolIdList.add(id)
        ObjectManagement.idolList.add(Idol(id, name!!, companyName!!, gender, song))

    } catch (_: NullPointerException) {
        println("잘못 입력")
    }
}

val searchIdol: (String) -> Idol? = { name ->
    var idol: Idol? = null
    ObjectManagement.idolList.forEach {
        if (it.name == name) {
            idol = it
        }
    }
    idol
}

fun readIdol(name: String) {
    val idol = searchIdol(name)
    for (field in idol!!.javaClass.declaredFields) {
        field.isAccessible = true
        val value = field.get(idol)
        println("${field.name}: $value")
    }
}

fun updateIdol(target: String, inputData: String, type: String) {
    for (it in ObjectManagement.idolList) {
        if (it.name == target) {
            when (type) {
                "name" -> it.name = inputData
                "companyName" -> it.companyName = inputData
                "gender" -> it.gender = inputData
                "song" -> it.song = inputData
            }
            break
        }
    }
}

fun deleteIdol(name: String) {
    for (it in ObjectManagement.idolList) {
        if (it.name == name) {
            ObjectManagement.idolList.remove(it)
            break
        }
    }
}

fun addIdolEvent(idolName: String, eventName: String): Boolean {
    var idolIdx: Int = -1
    val tmpEventId = searchEvent(eventName) ?: run {
        return false
    }
    searchIdol(idolName)?.let { idolIdx = ObjectManagement.idolList.indexOf(it) } ?: run {
        return false
    }
    ObjectManagement.idolList[idolIdx].eventIdList.add(tmpEventId.id)
    return true
}

fun deleteIdolEvent(idolName: String, eventName: String): Boolean {
    var idolIdx: Int = -1
    val tmpEventId = searchEvent(eventName) ?: run {
        return false
    }
    searchIdol(idolName)?.let { idolIdx = ObjectManagement.idolList.indexOf(it) } ?: run {
        return false
    }
    ObjectManagement.idolList[idolIdx].eventIdList.remove(tmpEventId.id)
    return true
}

fun readIdolEvent(idolName: String) {
    var tmpIdol: Idol? = null
    searchIdol(idolName)?.let { tmpIdol = it }
    if (tmpIdol != null) {
        if (tmpIdol!!.eventIdList.isEmpty()) {
            print("${idolName}은 현재 행사가 없습니다")
        } else {
            print("${idolName}은 아래와 같은 행사에 참여중입니다.\n")

            for (id in tmpIdol!!.eventIdList) {
                print("${searchEvent(id)} | ")
            }
        }

    } else {
        println("해당하는 아이돌이 없습니다.")
    }
}

