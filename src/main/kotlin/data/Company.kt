package data

data class Company(
    val id: Int,
    var name: String,
    var address: String,
    var CEO: String,
    var phone: String,
    var idolIdList: ArrayList<Int> = arrayListOf()
)