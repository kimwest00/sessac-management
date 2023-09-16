package data

import util.Generator

class IdolManagement {
    var idolList = ArrayList<IdolData>()
    fun addIdol(cmp: CompanyManagement) {
        val id = Generator.generateEmpNum()
        //회사 이름이 검색이 안될경우도 있으므로 미리 초기화
        var companyName: String = ""
        try {
            print("이름 : ")
            val name = readLine()!!

            var isExist = false

            while (isExist) {
                print("회사 이름: ")
                companyName = readLine()!!
                cmp.searchCompany(companyName)?.let { isExist = true } ?: run { println("해당 회사가 존재하지 않습니다. 다시 입력해주세요") }
            }

            print("성별 : ")
            val gender = readLine()!!

            print("대표 노래 : ")
            val song = readLine()!!

            if (companyName != "") {
                idolList.add(IdolData(id, name, companyName, gender, song))
            }

        } catch (_: NullPointerException) {
            println("잘못 입력")
        }
    }

    fun searchIdol(name: String): ArrayList<Int> {
        val idList = ArrayList<Int>()
        idolList.forEach {
            if (it.name == name) {
                idList.add(it.id)
            }
        }
        return idList
    }


    fun updateIdol(target: String, inputData: String, id: Int) {
        for (it in idolList) {
            if (it.id == id) {
                when (target) {
                    "name" -> it.name = inputData
                    "companyName" -> it.companyName = inputData
                    "gender" -> it.gender = inputData
                    "song" -> it.song = inputData
                }
                break
            }
        }
    }
}