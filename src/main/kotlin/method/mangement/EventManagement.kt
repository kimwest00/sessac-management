package method.mangement

import data.Event
import data.ObjectManagement
import util.Generator

fun addEvent() {
    val id = Generator.generateEmpNum()
    try {
        print("행사 이름 : ")
        val name = readLine()!!
        print("장소 : ")
        val address = readLine()!!
        print("content : ")
        val content = readLine()!!
        print("날짜 : ")
        val date = readLine()!!
        ObjectManagement.eventList.add(Event(id, name, address, content, date))
    } catch (_: NullPointerException) {
        println("잘못 입력")
    }    }

fun searchEvent(name: String): Event? {
    ObjectManagement.eventList.forEach {
        if (it.name == name) {
            return it
        }
    }
    return null
}
fun searchEvent(id: Int): String? {
    ObjectManagement.eventList.forEach {
        if (it.id == id) {
            return it.name
        }
    }
    return null
}

fun updateEvent(target: String, inputData: String, id: Int) {
    for (it in ObjectManagement.eventList) {
        if (it.id == id) {
            when (target) {
                "name" -> it.name = inputData
                "address" -> it.address = inputData
                "content" -> it.content = inputData
                "date" -> it.date = inputData
            }
            break
        }
    }
}

fun readEvent(name: String) {
    val event = searchEvent(name)
    if(event != null){
        for (field in event.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(event)
            println("${field.name}: $value")
        }
    }else{
        println("해당하는 행사가 없습니다. 다시 검색해주세요")
    }
}

fun deleteEvent(id: Int) {
    var targetIdx = -1
    ObjectManagement.eventList.forEachIndexed { idx, event ->
        if (event.id == id) targetIdx = idx
    }
    ObjectManagement.eventList.removeAt(targetIdx)
}