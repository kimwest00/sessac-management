import data.*
import method.file.loadFile
import method.file.multiDeserializeObject
import method.file.multiSerializeObject
import method.file.saveFile
import method.mangement.*
import util.compFile
import util.eventFile
import util.idolFile
import util.originFilePath
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


suspend fun main() {

    loadFile()

    addCompany()
    addIdol()
    readIdol("민")
    addEvent()
    println(ObjectManagement.idolList)

    saveFile()

}