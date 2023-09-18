# sessac-management
청년취업사관학교 코틀린 과정을 수료하며 작성한 아이돌 관리 프로그램 

## 요구사항
1. Company, Idol, Event 데이터를 활용
  - Idol은 Company 속성을 가지고있다(소속사)
  - Idol은 Event를 나간다(여러개 가능, null 가능)
2. 위의 데이터들은 콘솔을 통해 CRUD가 가능해야한다.
3. 프로그램 재부팅시에도 데이터가 보존되어야한다(File IO 이용)

## 주요 로직

### 데이터 자료구조
![페어 프로그래밍#1 아이돌 에이전시 만들기](https://github.com/kimwest00/sessac-management/assets/71765938/4b9224e9-9743-4c3e-9b56-6463c647ad3c)

### CRUD
