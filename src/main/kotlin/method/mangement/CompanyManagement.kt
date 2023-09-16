package method.mangement

import data.Company
import data.ObjectManagement
import util.Generator


// 1. 회사 이름을 입력 받는다
// 2. 회사 이름 기준 검색
// 3. 객체를 찾으면 접근하여 속성 변환
fun addCompany() {
    val id = Generator.generateEmpNum()
    try {
        print("회사 이름 : ")
        val name = readLine()!!
        print("주소 : ")
        val address = readLine()!!
        print("대표 : ")
        val ceo = readLine()!!
        print("전화번호 : ")
        val phone = readLine()!!

        ObjectManagement.compList.add(Company(id, name, address, ceo, phone))
    } catch (_: NullPointerException) {
        println("잘못 입력")
    }
}

// 반환값 : id
fun searchCompany(name: String): Company? {
    ObjectManagement.compList.forEach {
        if (it.name == name) {
            return it
        }
    }
    return null
}


fun updateCompany(target: String, inputData: String, id: Int) {
    for (it in ObjectManagement.compList) {
        if (it.id == id) {
            when (target) {
                "name" -> it.name = inputData
                "address" -> it.address = inputData
                "CEO" -> it.CEO = inputData
                "phone" -> it.phone = inputData
            }
            break
        }
    }
}

fun readCompany(name: String) {
    val company = searchCompany(name)
    if (company != null) {
        for (field in company.javaClass.declaredFields) {
            field.isAccessible = true
            val value = field.get(company)
            println("${field.name}: $value")
        }
    } else {
        println("해당하는 행사가 없습니다. 다시 검색해주세요")
    }

}

fun deleteCompany(id: Int) {
    var targetIdx = -1
    ObjectManagement.compList.forEachIndexed { idx, comp ->
        if (comp.id == id) targetIdx = idx
    }
    ObjectManagement.compList.removeAt(targetIdx)
}