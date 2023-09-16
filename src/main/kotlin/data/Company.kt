package data

data class CompanyData(
    val id: Int,
    var name: String,
    var address: String,
    var CEO: String,
    var phone: String,
    var idolList: ArrayList<Idol> = arrayListOf()
)

class Company(
    val compData: CompanyData
) {

    fun readCompany() {
        for (field in compData.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(compData)
            println("${field.name}: $value")
        }
    }
}