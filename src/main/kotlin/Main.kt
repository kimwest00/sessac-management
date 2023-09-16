import data.*
import method.file.multiDeserializeObject
import method.file.multiSerializeObject
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
//    companyTest()
    ObjectManagement.idolList =  multiDeserializeObject<Idol>(originFilePath+ idolFile)
    ObjectManagement.compList =  multiDeserializeObject<Company>(originFilePath+ compFile)
    ObjectManagement.eventList = multiDeserializeObject<Event>(originFilePath+ eventFile)
    addCompany()
    addIdol()
    readIdol("민")
    addEvent()
    println(ObjectManagement.idolList)

    multiSerializeObject(originFilePath+ idolFile, ObjectManagement.idolList)
    multiSerializeObject(originFilePath+ compFile, ObjectManagement.compList)
    multiSerializeObject(originFilePath+ eventFile, ObjectManagement.eventList)


//    addEvent()
//    addEvent()
//    readEvent("새싹")
//    addIdolEvent("민","새싹")
//    addIdolEvent("민","새싹2")
//    deleteIdolEvent("민","새싹")
//    readIdolEvent("민")
}