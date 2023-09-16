package util

import data.CompanyData
import data.IdolData

/*
* console로 employee를 받는 함수
*  */
<<<<<<< HEAD
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

=======
//fun addEmployee(): CompanyData? {
////    val id = Generator.generateEmpNum()
////    return try {
////        print("회사 이름 : ")
////        val name = readLine()!!
////        print("주소 : ")
////        val address = readLine()!!
////        print("대표 : ")
////        val ceo = readLine()!!
////        print("전화번호 : ")
////        val phone = readLine()!!
////
////        CompanyData(id, name, address, ceo, phone)
////    } catch (_: NullPointerException) {
////        println("잘못 입력")
////        null
////    }
//}
>>>>>>> 2793c25977163c3324e3c7f681e9f29751d58d02
