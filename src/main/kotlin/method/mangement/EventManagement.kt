package method.mangement

import data.Event
import data.ObjectManagement
import method.checkExist
import util.Generator

fun addEvent() {
    val id = Generator.generateEmpNum()
    val name:String?
    try {
        name = checkExist("행사 이름", searchEvent)
        print("장소 : ")
        val address = readLine()!!
        print("content : ")
        val content = readLine()!!
        print("날짜 : ")
        val date = readLine()!!
        if (name != null) {
            ObjectManagement.eventList.add(Event(id, name, address, content, date))
        }else {
            println("행사 등록에 실패했습니다. 다시 등록해주세요")
        }
    } catch (_: NullPointerException) {
        println("잘못 입력")
    }    }

val searchEvent:(String)-> Event? = {name->
    ObjectManagement.eventList.forEach {
        if (it.name == name) {
            it
        }
    }
   null
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