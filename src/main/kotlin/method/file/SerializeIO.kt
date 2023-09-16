package method.file

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception

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