package data


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
    fun readEvent() {
        for (field in eventData.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(eventData)
            println("${field.name}: $value")
        }
    }
}