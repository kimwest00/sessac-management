package data

class CompanyManagement {
    var compList = ArrayList<CompanyData>()

    // 1. 회사 이름을 입력 받는다
    // 2. 회사 이름 기준 검색
    // 3. 객체를 찾으면 접근하여 속성 변환

    fun searchCompany(name: String): ArrayList<Int> {
        val idList = ArrayList<Int>()
        compList.forEach {
            if (it.name == name) {
                idList.add(it.id)
            }
        }
        return idList
    }

    fun updateCompany(target: String, inputData: String) {
        when (target) {
            "name" -> compData.name = inputData
            "address" -> compData.address = inputData
            "CEO" -> compData.CEO = inputData
            "phone" -> compData.phone = inputData
        }
    }
}