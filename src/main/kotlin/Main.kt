import method.console.mainStart
import method.file.loadFile
import method.file.saveFile

suspend fun start() {
    loadFile()
    mainStart()
    saveFile()
}

suspend fun main() {
    start()
}