data class CompanyData(
    var name: String,
    var address: String,
    var CEO: String,
    var phone: String,
)


/*
* console로 employee를 받는 함수
*  */
fun addEmployee(): CompanyData? {

    try {
        print("회사 이름 : ")
        val name = readLine()!!
        print("주소 : ")
        val address = readLine()!!
        print("대표 : ")
        val ceo = readLine()!!
        print("전화번호 : ")
        val phone = readLine()!!

        return CompanyData(name, address, ceo, phone)
    } catch (_: NullPointerException) {
        println("잘못 입력")
        return null
    }
}