package method.mangement

import data.Event
import data.ObjectManagement
import method.console.ConsoleReader
import method.util.checkExist
import util.Generator

fun addEvent() {
    val id = Generator.generateEmpNum()
    val name: String?
    try {
        name = checkExist("행사 이름", searchEvent)
        print("장소 : ")
        val address = ConsoleReader.consoleLineInput()
        print("content : ")
        val content = ConsoleReader.consoleLineInput()
        print("날짜 : ")
        val date = ConsoleReader.consoleLineInput()
        if (name != null) {
            ObjectManagement.eventList.add(Event(id, name, address, content, date))
        } else {
            println("행사 등록에 실패했습니다. 다시 등록해주세요")
        }
    } catch (_: NullPointerException) {
        println("잘못 입력")
    }
}

val searchEvent: (String) -> Event? = { name ->
    var event: Event? = null
    ObjectManagement.eventList.forEach {
        if (it.name == name) {
            event = it
        }
    }
    event
}

fun searchEvent(id: Int): String? {
    ObjectManagement.eventList.forEach {
        if (it.id == id) {
            return it.name
        }
    }
    return null
}

fun updateEvent(target: String, inputData: String, type: String) {
    for (it in ObjectManagement.eventList) {
        if (it.name == target) {
            when (type) {
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
    for (field in event!!.javaClass.declaredFields) {
        field.isAccessible = true
        val value = field.get(event)
        println("${field.name}: $value")
    }
}

fun deleteEvent(name: String) {
    var targetIdx = -1
    ObjectManagement.eventList.forEachIndexed { idx, event ->
        if (event.name == name) targetIdx = idx
    }
    ObjectManagement.eventList.removeAt(targetIdx)
}