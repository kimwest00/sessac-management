package method.mangement

import data.Company
import data.ObjectManagement
import method.checkExist
import util.Generator


// 1. 회사 이름을 입력 받는다
// 2. 회사 이름 기준 검색
// 3. 객체를 찾으면 접근하여 속성 변환
fun addCompany() {
    val id = Generator.generateEmpNum()
    val name: String?
    try {
        name = checkExist("회사 이름", searchCompany)
        print("주소 : ")
        val address = readLine()!!
        print("대표 : ")
        val ceo = readLine()!!
        print("전화번호 : ")
        val phone = readLine()!!
        if (name != null) {
            ObjectManagement.compList.add(Company(id, name, address, ceo, phone))
        } else {
            println("회사 등록에 실패했습니다. 다시 등록해주세요")
        }
    } catch (_: NullPointerException) {
        println("잘못 입력")
    }
}

// 반환값 : id
fun searchCompany(id: Int): Company? {
    ObjectManagement.compList.forEach {
        if (it.id == id) {
            return it
        }
    }
    return null
}

val searchCompany: (String) -> Company? = { name ->
    var tmpCompany: Company? = null
    ObjectManagement.compList.forEach {
        if (it.name == name) {
            tmpCompany = it
        }
    }
    tmpCompany
}

fun updateCompany(target: String, inputData: String, type: String) {
    for (it in ObjectManagement.compList) {
        if (it.name == target) {
            when (type) {
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
    for (field in company!!.javaClass.declaredFields) {
        field.isAccessible = true
        val value = field.get(company)
        println("${field.name}: $value")
    }
}

fun deleteCompany(name: String) {
    var targetIdx = -1
    ObjectManagement.compList.forEachIndexed { idx, comp ->
        if (comp.name == name) targetIdx = idx
    }
    ObjectManagement.compList.removeAt(targetIdx)
}