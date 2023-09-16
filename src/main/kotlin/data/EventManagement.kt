package data

class EventManagement {
    var eventList = ArrayList<EventData>()

    fun addEvent(event: EventData) {
        eventList.add(event)
    }

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