package data

class CompanyManagement {
    var compList = ArrayList<CompanyData>()

    // 1. 회사 이름을 입력 받는다
    // 2. 회사 이름 기준 검색
    // 3. 객체를 찾으면 접근하여 속성 변환
    fun addCompany(comp: CompanyData) {
        compList.add(comp)
    }

    fun searchCompany(name: String): ArrayList<Int> {
        val idList = ArrayList<Int>()
        compList.forEach {
            if (it.name == name) {
                idList.add(it.id)
            }
        }
        return idList
    }


    fun updateCompany(target: String, inputData: String, id: Int) {
        for (it in compList) {
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
}