# 기능 구현 목록

---

## 흐름

1. 역 관리
   1. 역 등록
      - 잠실역 같이 역 등록
   2. 역 삭제
   3. 역 조회
   4. 돌아가기
2. 노선 관리
   1. 노선 등록
      - 새로운 노선 등록 (ex. 1호선)
      - 상행 종점역과 하행 종점역 입력
   2. 노선 삭제
      - 노선 통으로 삭제
   3. 노선 조회
   4. 돌아가기
3. 구간 관리
   1. 구간 등록
      - 노선 입력 받고, 역 입력 받고, 순서 입력 받고 저장하기
   2. 구간 삭제
      - 삭제 구간의 노선 입력하고, 역 입력 받아서 역 지우기
   3. 돌아가기
4. 지하철 노선도 출력
   - 지하철 호선(2호선)과 그에 해당하는 역 출력
5. 종료

---

## 기능 구현 방법

1. Repository
   - LineRepository
     - 노선을 관리
   - StationRepository
     - 역을 관리
2. Domain
   - Line
     - List<Station>과, 호선 이름 관리
   - Station
     - 역 이름을 관리
3. Controller
   - MainSystemController
     - 메인 입력 관리
   - StationController
     - 역 입력 관리
   - LineController
     - 노선 입력 관리
   - SectionController
     - 구간 입력 관리
4. View
   - InputView
     - 입력을 위한 뷰
   - OutputView
     - 출력을 위한 뷰

5. Exception
   - CommandInputException
     - 메인에서 입력 받을 때 예외처리
   - LineInputException
     - 노선 입력 받을 때 예외처리
   - StationRepository
     - 역 입력 받을 때 예외처리


---

## 흐름

1. MainController 에서 입력을 받고, 해당하는 입력으로 Controller를 작동시킨다.
2. 필요한 입력을 받고, 해당되는 도메인을 만들고 레포지토리에 저장시킨다.
3. 필요한 출력을 Repository를 이용해서 도메인을 가져오고, 도메인에 해당하는 메서드를 작동한다.
4. 반환한다.
5. MainController는 while로 작동되고, 종료 커맨드를 입력하면 종료한다.
