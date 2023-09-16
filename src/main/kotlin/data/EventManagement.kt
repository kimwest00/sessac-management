package data

import util.Generator

class EventManagement {
    var eventList = ArrayList<Event>()

    fun addEvent(event: Event) {
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

            eventList.add(Event(id, name, address, content, date))
        } catch (_: NullPointerException) {
            println("잘못 입력")
        }    }

    fun searchEvent(name: String): ArrayList<Int> {
        val idList = ArrayList<Int>()
        eventList.forEach {
            if (it.name == name) {
                idList.add(it.id)
            }
        }
        return idList
    }


    fun updateEvent(target: String, inputData: String, id: Int) {
        for (it in eventList) {
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
}