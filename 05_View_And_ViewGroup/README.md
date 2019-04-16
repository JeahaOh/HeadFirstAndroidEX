# View And ViewGroup
Linear Layout을 이용해 GUI Component를 배치하는 방법은 빙산의 일각임.  
FrameLayout과 주요 GUI Component들을 공부 해보자

## LinearLayout은 View를 한 행이나 한 열에 표시함.

### Layout에 반드시 너비와 높이를 정의 해야 함.
wrap_content와 match_parent 또는 8dp등의 값을 줄 수 있음. padding을 뺀 값임.  

### 수직 또는 수평방향
수직으로 배치
- android:orientation="vertical"
수평으로 배치
- android:orientation="horizontal"

### padding
layout 주변으로 공간을 추가 하고 싶으면 padding 속성을 추가함.  
레이아웃의 경계면과 부모 사이에 얼마의 공간을 추가할지 정하는 값임.  
  
모든 경계에 같은 값의 padding
- android:padding="16dp"
각 경계에 다른 값의 padding
- android:paddingTop=""
- android:paddingRight=""
- android:paddingBottom=""
- android:paddingLeft=""

### Dimention Resource file을 이용해 모든 Layout에 같은 padding 적용하기
디멘션 리소스 파일을 이용하면 application의 모든 layout에 적용하는 padding값을 쉽게 관리할 수 있음.  
app/src/main/res/values 경로에서 [File -> New -> Values resource File]로 dimens.xml을 만들어 줌.
```
<resource>
    <dimen name="activity_horizontal_margin">16dp</dimen>
    <dimen name="activity_vertical_margin">16dp</dimen>
</resource>
```
다음처럼 Dimention Resource의 이름을 Layout 파일의 패딩 속성에 설정해 미리 설정한 Dimention 값을 사용할 수 있음.
```
android:paddingLeft="@dimen/activity_vertical_margin"
```

### Linear Layout은 View를 Layout XML애 정의된 순서대로 표시함.

### margin으로 View 사이에 거리 추가하기
Linear Layout에 View를 배치할 때 기본적으로 View 사이에 간격이 거의 없음.  
View에 한 개 이상의 margin을 추가해 View 사이에 간격을 늘릴 수 있음.
  
모든 방향에 같은 크기의 margin
- android:layout_margin=""
각 방향에 다른 값의 margin
- layout_marginTop
- layout_marginBottom
- layout_marginLeft
- layout_marginStart
- layout_marginRight
- layout_marginEnd

### View에 무게 추가
- android:layout_weight="1"
gravity로 view의 contents위치 제어

#### android:gravity 속성에 사용할 수 있는 값
- top : 뷰의 콘텐트를 뷰의 위쪽에 넣음
- bottom : 뷰의 콘텐트를 뷰의 아래쪽에 넣음
- left : 
- right :
- start : 뷰의 시작부분에 넣음
- end :
- center_vertical
- center_horizontal
- center
- fill_vertical
- fill_horizontal
- fill

#### layout_gravity는 레이아웃 안에서 뷰의 위치를 제어
- android:gravity : 뷰의 콘텐트가 어디에 위치할지를 지정
- android:gravity_layout : 뷰 자체의 위치

#### android:grvity_layout 속성에 사용할 수 있는 값
- top, bottom, left, right
- start, end
- center_vertical, center_horizontal
- center
- fill_vertical, fill_horizontal
- fill


## FrameLayout
frame layout은 뷰를 겹치게 배치할 수 있는 레이아웃임.

### Laytout과 GUI Component
모든 layout과 GUI component는 Android View 클래스의 하위 클래스임.

### GUI Component는 View의 일종임
### Layout은 ViewGroup이라는 View의 일종임


