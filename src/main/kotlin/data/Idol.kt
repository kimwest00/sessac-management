package data

data class IdolData(
    var id: Int,
    var name: String,
    var companyName: String,
    var gender: String,
    var song: String,
    var eventIdList: ArrayList<Int> = arrayListOf()
)