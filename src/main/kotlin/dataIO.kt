import data.ObjectManagement
import kotlinx.coroutines.*
import java.io.*

const val filePath = "./src/main/kotlin/file/data.txt"

suspend fun multiSerializeObject() {
    val message = withContext(Dispatchers.IO) {
        ObjectOutputStream(FileOutputStream(filePath)).use {
            with(it) {
                ObjectManagement.idolList.forEach {
                    writeObject(it)
                }
                flush()
            }
        }
        "여러 객체직렬화"
    }
    println(message)
}

//suspend fun multiDeserializeObject() = runBlocking {
//    val songInfo = withContext(Dispatchers.IO) {
//        ObjectInputStream(FileInputStream("./serialization/k_pop.ser")).use {
//            arrayListOf<SongInfo>().run {
//                add(it.readObject() as SongInfo)
//                add(it.readObject() as SongInfo)
//                this
//            }
//        }
//    }
//    println(songInfo)
//}

// print 컨트롤러
fun printController() {
    var line: String?
    try {
        do {
            printMain()
            line = ConsoleReader.consoleScanner()
            if (line.equals("exit")) break
            fileController(line)

        } while (true)

    } catch (_: Exception) {
    }

}

// 파일 컨트롤러
fun fileController(inputMenu: String?) {
    val filePath = "./src/main/kotlin/example.txt"
    var idx = 0

    val fileIn = BufferedReader(FileReader(filePath))
    printCompany(fileIn)
    fileIn.close()

    fileUpdate("Test", filePath)
}

// text를 update 시켜주는 함수
fun fileUpdate(text: String, filePath: String) {
    val fileOut = BufferedWriter(FileWriter(filePath, true))

    fileOut.appendLine(text)
    fileOut.flush()
    fileOut.close()
}

// 모든 내역 출력
fun printCompany(file: BufferedReader) {
    file.forEachLine {
        println(it)
    }
}


fun printMain() {
    println(
        """
원하시는 메뉴를 선택해주세요. (ex, 1-3)

1-1 : 회사 생성 	1-2 : 회사 수정 		1-3 : 전체 회사 출력		1-4 : 회사 검색
2-1 : 아이돌 추가	2-2 : 아이돌 정보 수정	2-3 : 전체 아이돌 출력	2-4 : 아이돌 검색		2-5 : 아이돌 삭제
3-1 : 행사 생성	3-2 : 행사 정보 수정		3-3 : 전체 행사 출력		3-4 : 행사 검색	3-5 : 행사 삭제
종료를 원하시면 "exit"을 입력해주세요.
    """.trimIndent()
    )
}