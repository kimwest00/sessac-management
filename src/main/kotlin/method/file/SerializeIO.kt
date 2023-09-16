package method.file

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

suspend fun <T> multiSerializeObject(filePath: String, list: ArrayList<T>) {
    withContext(Dispatchers.IO) {
        ObjectOutputStream(FileOutputStream(filePath)).use {
            with(it) {
                list.forEach {
                    writeObject(it)
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
                add(it.readObject() as T)
                this
            }
        }
    }
    return objectList
}