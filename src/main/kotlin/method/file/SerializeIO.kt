package method.file

import data.Company
import data.Event
import data.Idol
import data.ObjectManagement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import util.compFile
import util.eventFile
import util.idolFile
import util.originFilePath
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception

suspend fun loadFile(){
    ObjectManagement.idolList =  multiDeserializeObject<Idol>(originFilePath + idolFile)
    ObjectManagement.compList =  multiDeserializeObject<Company>(originFilePath + compFile)
    ObjectManagement.eventList = multiDeserializeObject<Event>(originFilePath + eventFile)
}
suspend fun saveFile(){
    multiSerializeObject(originFilePath+ idolFile, ObjectManagement.idolList)
    multiSerializeObject(originFilePath+ compFile, ObjectManagement.compList)
    multiSerializeObject(originFilePath+ eventFile, ObjectManagement.eventList)
}
suspend fun <T> multiSerializeObject(filePath: String, list: ArrayList<T>) {
    withContext(Dispatchers.IO) {
        ObjectOutputStream(FileOutputStream(filePath)).use {
            with(it) {
                try {
                    list.forEach {
                        writeObject(it)
                    }
                    this.close()
                }catch (e:Exception){
//                    print(e.message)
                }
                flush()
            }
        }
    }
}

suspend fun <T> multiDeserializeObject(fp: String):ArrayList<T> {
    var objectList = withContext(Dispatchers.IO) {
        ObjectInputStream(FileInputStream(fp)).use {
            arrayListOf<T>().run {
                while(true){
                    try {
                        add(it.readObject() as T)
                    }catch (e:Exception){
//                        print(e.message)
                        break
                    }
                }
                this
            }
        }
    }
    println(objectList)
    return objectList
}