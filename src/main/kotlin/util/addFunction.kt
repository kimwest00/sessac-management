package util

import data.CompanyData
import data.IdolData

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

fun addIdol(): IdolData? {
    val id = Generator.generateEmpNum()
    return try {
        print("이름 : ")
        val name = readLine()!!

        print("회사 이름: ")
        val companyName = readLine()!!

        print("성별 : ")
        val gender = readLine()!!

        print("대표 노래 : ")
        val song = readLine()!!

        IdolData(id, name, companyName, gender, song)
    } catch (_: NullPointerException) {
        println("잘못 입력")
        null
    }
}