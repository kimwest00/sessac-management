package data

class IdolManagement {
    var idolList = ArrayList<IdolData>()

    fun addIdol(idol: IdolData) {
        idolList.add(idol)
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