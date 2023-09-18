package util

const val originFilePath = "./src/main/kotlin/output/"
const val compFile = "comp.txt"
const val idolFile = "idol.txt"
const val eventFile = "event.txt"

const val COMP = "회사"
const val IDOL = "아이돌"
const val EVENT = "이벤트"

const val ADD_MESSAGE = "추가 완료"
const val UPDATE_MESSAGE = "업데이트 완료"
const val DELETE_MESSAGE = "삭제 완료"

const val COMPANY_FIELD = "1. 이름\t2. 주소\t3. 대표\t4. 연락처"
const val IDOL_FIELD = "1. 이름\t2. 회사\t3. 대표곡"
const val EVENT_FIELD = "1. 이름\t2. 주소\t3. content\t4. 날짜"


val READ_COMMENT = { comment: String -> "어느 ${comment}를 보시겠습니까?"}
val DELETE_COMMENT = { comment: String -> "어느 ${comment}를 삭제하겠습니까?"}
const val MEET_IDOL = "어느 아이돌을 보내겠습니까?"
const val MEET_EVENT = "어느 행사에 보내겠습니까?"
const val CANCEL_MEET = "어느 아이돌의 행사를 취소하겠습니까?"

val FIELD = { comment:String ->
    when (comment) {
        COMP -> COMPANY_FIELD
        IDOL -> IDOL_FIELD
        EVENT -> EVENT_FIELD
        else -> "?"
    }
}

val INFO_IDX = { info:String -> listOf(COMP, IDOL, EVENT).indexOf(info) }
val FIELD_IDX = listOf(4, 3, 4)

val CHOICE_MENU = { menu: String ->
    "1. ${menu} 생성\t2. ${menu} 수정\t3. 전체 ${menu} 출력\t4. 특정 ${menu} 정보 출력\t5. ${menu} 삭제\n"
}
val IDOL_EVENT_MENU =
    "6. 아이돌 행사 보내기\t7. 아이돌 행사 출력\t8. 아이돌 행사 삭제"
