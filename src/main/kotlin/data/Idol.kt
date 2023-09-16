package data

data class IdolData(
    var id: Int,
    var name: String,
    var companyName: String,
    var gender: String,
    var song: String,
    var eventList: ArrayList<Event> = arrayListOf()
)
class Idol(
  val idol:IdolData
) {
    fun readEvent() {
        for (field in idol.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(idol)
            println("${field.name}: $value")
        }
    }
}
