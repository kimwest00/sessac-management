package method

fun <T>checkExist(comment:String,searchFunction:(String)->T):String?{
    var isExist = false
    var tmpField:String? = null
    while (!isExist) {
        print("${comment}: ")
        tmpField = readln()
        searchFunction(tmpField)?.let {
            println("중복되는 ${comment}이 있습니다. 다시 입력해주세요 ")
        }?:run{
            isExist = true
        }
    }
    return tmpField

}


