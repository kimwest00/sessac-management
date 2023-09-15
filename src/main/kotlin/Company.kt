class Company(
    val compData: CompanyData
) {
    fun updateCompany() {

    }

    fun readCompany() {
        for (field in compData.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(compData)
            println("${field.name}: $value")
        }

    }
}