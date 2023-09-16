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
    addCompany()
    addIdol()
    readIdol("민")
    addEvent()
    addEvent()
    readEvent("새싹")
    addIdolEvent("민","새싹")
    addIdolEvent("민","새싹2")
    deleteIdolEvent("민","새싹")
    readIdolEvent("민")
}