package data

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

fun readCompany(event: Event) {
    for (field in event.javaClass.declaredFields) {
        field.isAccessible = true
        val value = field.get(event)
        println("${field.name}: $value")
    }
}