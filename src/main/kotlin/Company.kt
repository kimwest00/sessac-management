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
    fun updateCompany(target: String, inputData: String) {
        when (target) {
            "name" -> compData.name = inputData
            "address" -> compData.address = inputData
            "CEO" -> compData.CEO = inputData
            "phone" -> compData.phone = inputData
        }
    }

    fun readCompany() {
        for (field in compData.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(compData)
            println("${field.name}: $value")
        }
    }
}