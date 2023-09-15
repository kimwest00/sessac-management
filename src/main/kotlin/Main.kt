import data.Company
import util.addEmployee

fun main(args: Array<String>) {
    val tempCompany = addEmployee()

    val cmp = tempCompany?.let { Company(it) }

    cmp?.readCompany()
    cmp?.updateCompany("name", "시흥")

    cmp?.readCompany()

}