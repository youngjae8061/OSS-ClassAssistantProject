# OSS-ClassAssistantProject
수강신청 대비 나만의 시간표를 미리 짜보는 애플리케이션

## 설치 방법 (Installation)
추후에 Google Play에 어플 등록하게되면 그 후부터 Google Play에서 다운로드 가능

## 사용 방법 (Usage)
회원가입을 하고 선문대학교에 문의하고 싶은 사항이 있으면 선문대학교 전화걸기 버튼을 누른다.
강의목록 버튼을 누르면해당 년도/학기/강의종류(전공/교양) 선택 후 원하는 강의를 찾아 +버튼으로 자신의 시간표에 강의를 담는다.
시간표 버튼을 누르면 신청한 전체 강의가 담긴 시간표를 볼 수 있다.
통계 버튼을 누르면 원하는 강의나 원하는 교수의 수업에 경쟁률이 얼마나되는지 확인할 수 있고,
돌아가기 버튼을 눌렀을때 일반 사용자의 경우 돌아가지고 관리자의 경우 돌아가기를 누르면 강의를 추가하는 창으로 넘어가게된다.
한줄평보러가기 버튼을 눌렀을때 원하는 강의를 찾아 한줄평을 입력하거나 해당 과목의 한줄평을 볼 수 있다.

### 기여 내용
## 윤수혁
경쟁률 기능 구현 및 경쟁률 데이터 입력 기능 구현, 그 외 진행사항 중 오류 발생 시 오류 수정
*구현한 클래스*
1. CompetSubSchActivity
파이어스토어 내 데이터를 검색, 일치하는 데이터 확인 및 출력하는 기능 구현
필드 값(과목명, 교수명, 수강인원, 신청희망 인원)을 과목 명 및 교수 명으로 검색, 일치하는 테이블로 가져와
수강인원 대비 신청희망인원을 계산하여 경쟁률을 출력

2. InsertCompetDataActivity
파이어스토어 내 경쟁률 테이블에 일치하는 형식의 데이터를 추가하는 클래스


## 박민석


## 윤동환
현존하는 강의목록 데이터 파이어스토어에 구축, 앱과 파이어스토어 간의 연동 작업

*구현한 클래스*
1. ClassActivity
리사이클러뷰를 가져오거나 강의목록검색, 장바구니 추가 등의 기능을 하는 클래스

2. CourseAdapter
리사이클러뷰에 표시될 아이템뷰를 생성하는 클래스

3. CourseViewHolder
각 강의들의 필드값(강의명, 학점, 개설학과 등)을 아이템뷰로 저장하여 화면에 뿌려주는 역할

4. InsertInfoActivity
앱에서 편하게 강의정보를 파이어스토어에 저장해주는 클래스

*데이터를 저장하는 방식*  
Firebase Firestore test-version을 이용
기본적인 강의들은 컬렉션:elective - 문서:강의명 의 위치로 저장   
장바구니에 담는 강의들은 컬렉션:장바구니 - 문서:사용자리스트 - 컬렉션:사용자이메일 - 강의명 위치로 저장

회원가입 시 컬렉션:users에 저장



## 이영재
           
