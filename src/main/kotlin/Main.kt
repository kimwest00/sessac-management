import method.file.loadFile
import method.file.saveFile

suspend fun start() {
    loadFile()
    printController()
    saveFile()
}

suspend fun main() {
    start()
}