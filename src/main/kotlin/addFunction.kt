/*
* console로 employee를 받는 함수
*  */
fun addEmployee(): CompanyData? {
    val id = Generator.generateEmpNum()
    return try {
        print("회사 이름 : ")
        val name = readLine()!!
        print("주소 : ")
        val address = readLine()!!
        print("대표 : ")
        val ceo = readLine()!!
        print("전화번호 : ")
        val phone = readLine()!!

        CompanyData(id, name, address, ceo, phone)
    } catch (_: NullPointerException) {
        println("잘못 입력")
        null
    }
}
