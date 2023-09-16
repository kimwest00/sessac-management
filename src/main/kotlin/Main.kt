import data.Company
import data.CompanyManagement
import data.ObjectManagement
import java.io.ObjectOutputStream

val testCompManagement = CompanyManagement()
val tempComp = ObjectManagement.compList

fun companyTest() {
    addTest(testCompManagement)
    updateTest(testCompManagement)
    searchTest(testCompManagement)
    deleteTest(testCompManagement)
}

fun addTest(testCompManagement: CompanyManagement) {
    testCompManagement.addCompany()
    println("addTest : ")
    allPrint(testCompManagement)
}

fun updateTest(testCompManagement: CompanyManagement) {
    testCompManagement.updateCompany(
        "name", "LG", tempComp[0].id
    )
    println("updateTest : ")
    allPrint(testCompManagement)
}

fun searchTest(testCompManagement: CompanyManagement) {
    testCompManagement.searchCompany("LG")
    println("searchTest : ")
}

fun deleteTest(testCompManagement: CompanyManagement) {
    testCompManagement.addCompany()
    testCompManagement.deleteCompany(tempComp.get(0).id)
    println("deleteTest : ")
    allPrint(testCompManagement)
}

fun allPrint(testCompManagement: CompanyManagement) {
    tempComp.forEach {
        println(it)
    }
}


fun main(args: Array<String>) {
    companyTest()
}