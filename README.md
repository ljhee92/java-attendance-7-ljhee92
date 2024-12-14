# java-attendance-precourse
## 코치가 사용하는 출석 시스템

## 💻 프로그램 진행 순서
1. ``attendances.csv`` 파일 조회
2. 오늘 날짜와 요일, 기능 선택 출력
3. 1: 출석 확인 입력 시
    * 닉네임을 입력 받는다.
    * 닉네임이 등록되지 않은 닉네임이면 예외처리한다.
    * 등교 시간을 입력 받는다.
    ~~* 오늘 날짜가 평일이 아니면 예외처리한다.~~ (크루는 주말, 공휴일에도 프로그램을 사용할 수 있다.)
    * 등교 시간이 캠퍼스 운영 시간 내가 아니면 예외처리한다.
    * 출석 기록이 있다면 예외처리한다.
    * 출석한 내용(``12월 13일 금요일 09:59 (출석)``)을 출력한다.
4. 2: 출석 수정 입력 시
    * 닉네임을 입력 받는다.
    * 닉네임이 등록되지 않은 닉네임이면 예외처리한다.
    * 수정하려는 날짜(일)을 입력 받는다.
    * 숫자가 아니면 예외처리한다.
    * 변경 시간을 입력 받는다.
    * 24시간 형식(예. 22:00)이 아니면 예외처리한다.
    * 출석 수정 내용(``12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!``)을 출력한다.
5. 3: 크루별 출석 기록 확인 입력 시
    * 닉네임을 입력 받는다.
    * 닉네임이 등록되지 않은 닉네임이면 예외처리한다.
    * 출석 기록, 출석/지각/결석 회수, 제적/면담/경고 대상자 여부를 출력한다.
    ```
    이번 달 빙티의 출석 기록입니다.

    12월 02일 월요일 13:00 (출석)
    12월 03일 화요일 09:58 (출석)
    12월 04일 수요일 10:02 (출석)
    12월 05일 목요일 10:06 (지각)
    12월 06일 금요일 10:01 (출석)
    12월 09일 월요일 --:-- (결석)
    12월 10일 화요일 10:08 (지각)
    12월 11일 수요일 --:-- (결석)
    12월 12일 목요일 --:-- (결석)
    
    출석: 4회
    지각: 2회
    결석: 3회
    
    면담 대상자입니다.
    ```
6. 4: 제적 위험자 확인 입력 시
    * 제적 위험자 조회 결과를 출력한다.
    ```
    제적 위험자 조회 결과
    - 빙티: 결석 3회, 지각 2회 (면담)
    - 이든: 결석 2회, 지각 4회 (면담)
    - 쿠키: 결석 2회, 지각 2회 (경고)
    - 빙봉: 결석 1회, 지각 5회 (경고)
    ```
7. Q: 종료 입력 시
    * 프로그램을 종료한다.

## 📋 기능 목록
### 입력
1. 파일 입력
- [x] 프로그램 시작 시 ``src/main/resources/attendances.csv``를 통해 구현에 필요한 정보 조회

2. 기능 선택 입력
- [x] 1: 출석 확인 / 2: 출석 수정 / 3: 크루별 출석 기록 확인 / 4: 제적 위험자 확인 / Q: 종료

3. 닉네임 입력
- [x] 등록된 닉네임인지 확인

4. 시간 입력
- [x] 24시간제 사용(예: 22:00)

5. 수정 날짜 입력
- [ ] 숫자인지 확인

6. 잘못된 값 입력 시
- [x] ``IllegalArgumentException`` 발생 후 어플리케이션 종료

### 출력
1. 예외 상황 시 오류 메시지 출력
- [x] 기능 선택 항목, 날짜 또는 시간을 잘못된 형식으로 입력 : ``[ERROR] 잘못된 형식을 입력하였습니다.``
- [x] 등록되지 않은 닉네임 입력 : ``[ERROR] 등록되지 않은 닉네임입니다.``
- [x] 주말 또는 공휴일에 출석을 확인하거나 수정 : ``[ERROR] 12월 14일 토요일은 등교일이 아닙니다.``
- [ ] TODO : 공휴일
- [ ] 미래 날짜로 출석 수정 : ``[ERROR] 아직 수정할 수 없습니다.``
- [x] 등교 시간이 캠퍼스 운영 시간이 아닌 경우 : ``[ERROR] 캠퍼스 운영 시간에만 출석이 가능합니다.``
- [ ] 이미 출석했는데 다시 출석 : ``[ERROR] 이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.``

2. 오늘 날짜와 기능 출력
- [x] 현재 날짜, 요일 출력
- [x] 1: 출석 확인 / 2: 출석 수정 / 3: 크루별 출석 기록 확인 / 4: 제적 위험자 확인 / Q: 종료

### 출석
- [x] 닉네임, 등교 시간 입력하여 출석
- [x] 출석 후 출석 기록 확인 가능 : ``12월 05일 화요일 09:59 (출석)``
- [ ] 이미 출석했다면 재출석 불가, 수정 기능 이용하도록 안내
- [x] 캠퍼스 운영 시간 : 매일 08:00 ~ 23:00
- [x] 교육 시간 : 월요일 13:00 ~ 18:00, 화~금요일 10:00 ~ 18:00
- [ ] 5분 초과 시 지각, 30분 초과 시 결석, 출석 기록이 없는 날은 결석

### 출석 수정
- [ ] 닉네임, 수정하려는 날짜, 등교 시간 입력하여 수정
- [ ] 수정 후 변경 전, 변경 후 출석 기록 확인 가능 : ``12월 03일 화요일 10:07 (지각) -> 09:58 (출석) 수정 완료!``

### 춣석 기록 확인
- [ ] 닉네임 입력 시 전날까지의 크루별 출석 기록 확인

### 제적 위험자 확인
- [ ] 전날까지의 크루 출석 기록을 바탕으로 제적 위험자 파악
- [ ] 제적 대상자(결석 5회 초과), 면담 대상자(결석 3회 이상), 경고 대상자(결석 2회 이상) 순으로 출력
- [ ] 지각 3회는 결석 1회로 간주하여 내림차순 출력
- [ ] 출석 상태가 같다면 닉네임으로 오름차순 정렬