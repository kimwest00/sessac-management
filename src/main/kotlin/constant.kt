const val COMP = "회사"
const val IDOL = "아이돌"
const val EVENT = "이벤트"

const val completeAdd = "추가 완료"
const val completeUpdate = "업데이트 완료"
const val completeDelete = "삭제 완료"

val menuInfo = { menu: String ->
    "1. ${menu} 생성\t2. ${menu} 수정\t3. 전체 ${menu} 출력\t4. 특정 ${menu} 정보 출력\t5. ${menu} 삭제\n"
}
val idolEventInfo =
    "6. 아이돌 행사 보내기\\t7. 아이돌 행사 출력\\t8. 아이돌 행사 삭제"
