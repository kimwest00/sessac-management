import data.*
import java.io.ObjectOutputStream
import kotlin.io.println

val tempComp = ObjectManagement.compList

fun companyTest() {
    addTest()
    updateTest()
    searchTest()
    deleteTest()
}

fun addTest() {
    addCompany()
    println("addTest : ")
    allPrint()
}

fun updateTest() {
    updateCompany(
        "name", "LG", tempComp[0].id
    )
    println("updateTest : ")
    allPrint()
}

fun searchTest() {
    searchCompany("LG")
    println("searchTest : ")
}

fun deleteTest() {
    addCompany()
    deleteCompany(tempComp.get(0).id)
    println("deleteTest : ")
    allPrint()
}

fun allPrint() {
    tempComp.forEach {
        println(it)
    }
}


fun main(args: Array<String>) {
//    companyTest()
    addIdol()
    readIdol("민")
    addEvent()
    readEvent("새싹")

}