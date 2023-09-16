import data.Company
import data.CompanyManagement
import java.io.ObjectOutputStream

val testCompManagement = CompanyManagement()

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
        "name", "LG", testCompManagement.compList[0].id
    )
    println("updateTest : ")
    allPrint(testCompManagement)
}

fun searchTest(testCompManagement: CompanyManagement) {
    testCompManagement.searchCompany("LG")
    println("searchTest : ")
    allPrint(testCompManagement)
}

fun deleteTest(testCompManagement: CompanyManagement) {
    testCompManagement.addCompany()
    testCompManagement.deleteCompany(testCompManagement.compList.get(0).id)
    println("deleteTest : ")
    allPrint(testCompManagement)
}

fun allPrint(testCompManagement: CompanyManagement) {
    testCompManagement.compList.forEach {
        println(it)
    }
}


fun main(args: Array<String>) {
    companyTest()
}