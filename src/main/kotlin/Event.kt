
data class EventData(
    var id: Int,
    var name: String,
    var content: String,
    var address: String,
    var date: String
) {
}
class Event(
    val eventData: EventData
) {
    init {
        eventObject = Event(this.eventData)
    }

    companion object {
        var eventObject:Event? = null
    }
    fun updateEvent(target: String, inputData: String) {
        when (target) {
            "name" -> eventData.name = inputData
            "address" -> eventData.address = inputData
            "content" -> eventData.content = inputData
            "date" -> eventData.date = inputData
        }
    }

    fun readEvent() {
        for (field in eventData.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(eventData)
            println("${field.name}: $value")
        }
    }

    fun deleteEvent() {
        eventObject = null
    }

}