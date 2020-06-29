# 볼링 게임 점수판
## 진행 방법
* 볼링 게임 점수판 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항 - 질문 삭제하기 기능 리팩토링
### Question
- [X] 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.
    - [X] 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.
    - [X] 답변이 없는 경우 삭제가 가능하다. (Answer에게 삭제 가능한지 확인한다.)
    
### Answer
- [X] 답변 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.
    - [X] 로그인 사용자와 답변한 사람이 같은 경우 삭제 가능하다.
    
### DeleteHistory
- [X] 질문 삭제 이력에 대한 정보를 남긴다.
- [X] 답변 삭제 이력에 대한 정보를  남긴다.

## 기능 요구사항 - 볼링 점수판
### Name : 이름
- [X] 이름은 세글자의 영어로 구성된다.
- [X] 이름은 빈 문자열이거나 null일 수 없다.

### Player
- [X] `Player` 는 `Name` 객체를 가진다.

### Frame : 프레임 공통 객체 (추상 클래스)
- [ ] `FrameNumber` 와 `FrameScore` 를 인스턴스 변수로 가지는 추상 클래스
- [ ] 다음 Frame 을 반환하기 위한 메소드를 가진다.
- [ ] 파라미터 Null 유효성 검증

### NormalFrame : 1 ~ 9 프레임
- [ ] 생성 후 다음 `Frame` 객체를 반환한다.
    - 스트라이크인 경우 or 2번의 투구를 마친 경우, 다음 Frame 객체를 반환한다.
    - 1번째의 투구를 마친 경우, 현재의 Frame 객체를 반환한다.
    - 9번 째의 프레임이 종료된 경우, `FinalFrame`을 반환한다.
    
### FinalFrame : 10 프레임
- [ ] `Score`(보너스 점수) 를 인스턴스 변수로 가진다.
- [ ] 파라미터 Null 유효성 검증

### FrameNumber : 프레임 번호
- [X] 프레임 번호는 1 ~ 10까지의 숫자만 가능하다.
- [X] 프레임 번호 출력 시 1의 단위인 경우 앞에 '0'을 붙여서 출력한다.

### Pins : 핀의 갯수
- [X] 핀의 갯수는 0 ~ 10 사이의 int 형 변수이다.
- [X] 핀의 갯수가 0개인 경우 '-', 10점인 경우 'X' 를 출력한다.

### FramePins : 프레임 당 핀의 갯수
- [X] 프레임 당 핀의 갯수 객체는 `Pins` 객체 2 개를 가진다.
    - 1번 투구
    - 2번 투구
- [X] 두 Pins 의 합은 10 개를 초과할 수 없다.
- [X] FramePins 생성은 스트라이크인 경우와 그 외의 경우로 나누어진다.
    - 그 외의 경우, 두 점수 모두 파라미터로 받는다.
- [X] 파라미터 Null 유효성 검증

### Strike : 스트라이크
- [X] FramePins 를 상속받는다.
- [X] 스트라이크는 한 번의 투구만 한다.

### Spare : 스페어
- [X] FramePins 를 상속받는다.
- [X] 두 번째 투구에서 10개의 핀을 모두 쓰러트린 상태이다. (두 개의 투구의 합이 10이다.) 

### InputView
- [X] 플레이어를 입력받아 그대로 리턴한다.
- [X] 각 프레임의 점수를 입력 받아 리턴한다.

### ResultView
- [ ] 점수판을 출력한다.