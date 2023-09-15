fun main(args: Array<String>) {
    val tempCompany = addEmployee()

    val cmp = tempCompany?.let { Company(it) }

    cmp?.readCompany()

}