package data

import com.sun.org.apache.xpath.internal.operations.Bool
import util.Generator

fun addIdol() {
    val id = Generator.generateEmpNum()
    //회사 이름이 검색이 안될경우도 있으므로 미리 초기화
    var companyName: String = ""
    try {
        print("이름 : ")
        val name = readLine()!!

        var isExist = false

        while (isExist) {
            print("회사 이름: ")
            companyName = readLine()!!
            searchCompany(companyName)?.let {
                isExist = true
                companyName = it.name
            } ?: run {
                println("해당 회사가 존재하지 않습니다. 다시 입력해주세요")
            }
        }

        print("성별 : ")
        val gender = readLine()!!

        print("대표 노래 : ")
        val song = readLine()!!

        if (companyName != "") {
            ObjectManagement.idolList.add(Idol(id, name, companyName, gender, song))
        }

    } catch (_: NullPointerException) {
        println("잘못 입력")
    }
}

fun searchIdol(name: String): Idol? {
    var idol: Idol? = null
    ObjectManagement.idolList.forEach {
        if (it.name == name) {
            idol = it
        }
    }
   if(idol != null){
       return idol
   }
    return null
}

fun readIdol(name: String) {
    val idol = searchIdol(name)
    if(idol != null){
        for (field in idol.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(idol)
            println("${field.name}: $value")
        }
    }else{
        println("해당하는 아이돌이 없습니다. 다시 검색해주세요")
    }
}

fun updateIdol(target: String, inputData: String, id: Int) {
    for (it in ObjectManagement.idolList) {
        if (it.id == id) {
            when (target) {
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

fun addIdolEvent(idolName: String,eventName: String):Boolean {
    var idolIdx:Int = -1
    var tmpEventId = searchEvent(eventName)?.let { it } ?: run {
        return false
    }
    searchIdol(idolName)?.let { idolIdx = ObjectManagement.idolList.indexOf(it)} ?: run {
        return false
    }
    ObjectManagement.idolList[idolIdx].eventIdList.add(tmpEventId.id)
    return true
}
