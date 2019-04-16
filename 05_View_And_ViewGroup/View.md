# View
화면에서의 공간
## 속성을 얻거나 설정
### 크기와 위치
### 포커스 처리
### 이벤트 처리와 리스너
### Layout은 사실 View의 계층도임.
- - -
## TextView
텍스트를 표시할 때 사용.

## EditText
텍스트 뷰와 같지만 편집할 수 있음.
- 값
    - phone : 번호 키패드를 제공
    - textPassword : 입력값을 표시하지 않음
    - textCapSentence : 단어나 문장의 첫 번째 문자를 대문자로 표시함
    - textAutoCorrent : 입력하는 텍스트를 자동으로 고침

## Button
사용자가 클릭했을 때 어떤 동작을 수행함

## ToggleButton
버튼을 클릭할 때마다 두 가지 상태 중 한 가지 상태로 바꿈.

## Switch
토글 버튼과 비슷하게 작동하는 슬라이더 컨트롤

## CheckBox
선택할 수 있는 다양한 옵션을 제공

## RadioButton
여러 옵션중 한 가지만 선택하도록 함  
RadioGruop을 이용해 사용 가능함

## Spinner
드롭다운

## ImageView
이미지를 표시

## ImageButton
버튼에 텍스트 없이 이미지만 포함

## ScrollView
기본적으로 많은 레이아웃이 스크롤을 제공하지 않아서 있는것

## Toast
간단한 팝업 메세지

# 핵심 정리
- GUI Component는 모두 View의 일종임.(View 클래스 상속)
- Layout은 모두 ViewGroup 클래스를 상속받음.
- Layout XML 파일은 View의 계층 트리를 포함하는 ViewGroup으로 변환됨.
- LinearLayout은 View를 수평 또는 수직으로 배치함
    - android:orientation 속성으로 배치 방향을 결정함
- FrameLayout은 View를 겹쳐 쌓음
- android:padding* 속성으로 View 주변의 padding을 줄 수 있음
- LinearLayout에서는 android:layout_weight를 이용해 특정 view에 추가 공간을 할당할 수 있음
- android:layout_gravity로 사용할 수 있는 공간에서 View가 어디에 위치할지 지정할 수 있음
- android:gravity로 View의 콘텐트가 View의 어디에 위치할지 결정할 수 있음.
- `<ToggleButton>`은 버튼을 클릭해 두 가지 상태로 번갈아 이동할 수 있는 토글버튼을 정의함
- `<Switch>`는 토글버튼처럼 동작하는 스위치 컨트롤을 정의함
- `<CheckBox>`는 체크박스를 정의
- 여러 Radiobutton을 그룹으로 만드려면 `<RadioGroup>`으로 라디오 그룹을 먼저 정의 하면 됨
    - 그리고 그룹 안에서 `<RadioButton>`으로 각각의 라디오 버튼을 만듦.
- 이미지를 표시할 때는 `<ImageView>`를 이용함
- `<ImageButton>`은 텍스트 없이 이미지로 이루어진 버튼을 정의함
- `<ScrollView>`나 `<HorizontalScrollView>`를 이용해 스크롤 바를 추가할 수 있음.
- Toast는 팝업 메세지임
