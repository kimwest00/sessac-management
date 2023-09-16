import data.Company
import data.CompanyManagement
import util.addEmployee
import java.io.ObjectOutputStream

fun main(args: Array<String>) {
    val tempCompany = addEmployee()

    val cmp = tempCompany?.let { Company(it) }
//    cmp?.readCompany()
//    cmp?.updateCompany("name", "시흥")
//    cmp?.readCompany()

    val mange = CompanyManagement()
    cmp?.compData?.let { mange.addCompany(it) }
    val list = mange.searchCompany("삼성")
    mange.updateCompany("name", "LG", list[0])
    println(mange.compList.get(0))

//    printController()
}