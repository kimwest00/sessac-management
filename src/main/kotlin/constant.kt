const val COMP = "회사"
const val IDOL = "아이돌"
const val EVENT = "이벤트"

const val completeAdd = "추가 완료"
const val completeUpdate = "업데이트 완료"
const val completeDelete = "삭제 완료"

const val compField = "1. 이름\t2. 주소\t3. 대표\t4. 연락처"
const val idolField = "1. 이름\t2. 회사\t3. 대표곡"
const val eventField = "1. 이름\t2. 주소\t3. content\t4. 날짜"

val fieldList = { comment:String ->
    when (comment) {
        COMP -> compField
        IDOL -> idolField
        EVENT -> eventField
        else -> "?"
    }
}

val infofIdx = {info:String -> listOf(COMP, IDOL, EVENT).indexOf(info) }
val fieldListIdx = listOf(4, 3, 4)

val menuInfo = { menu: String ->
    "1. ${menu} 생성\t2. ${menu} 수정\t3. 전체 ${menu} 출력\t4. 특정 ${menu} 정보 출력\t5. ${menu} 삭제\n"
}
val idolEventInfo =
    "6. 아이돌 행사 보내기\\t7. 아이돌 행사 출력\\t8. 아이돌 행사 삭제"

