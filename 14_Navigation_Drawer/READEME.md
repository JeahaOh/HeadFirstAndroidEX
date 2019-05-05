# RecyclerView와 CardView 재활용 하기
TAB의 숫자가 너무 많거나 TAB을 섹션으로 나누고 싶다면 Navigation Drawer를 이용할 수 있음.  
NavigationView를 이용해 Header를 제공하는 방법,  
사용자가 앱의 주요 메뉴를 쉽게 탐색하도록 구조화된 메뉴 항목 집합을 제공하는 방법을 알아보자.  
사용자의 가벼운 터치나 스와이프에 드로워가 응답하도록 Navigation View Listener를 설정하는 방법을 알아보자.

## 핵심 정리
- 제공할 숏컷의 숫자가 많으면 내비게이션 드로워를 사용하거나 숏컷을 섹션으로 그룹화 함.
- 액티비티의 레이아웃에 드러워 레이아웃을 추가해 내비게이션 드로워를 생성함.  
  드로워 레이아웃의 첫 번째 요소는 액티비티의 메인 콘텐트를 정의하는 뷰로,  
  보통 레이아웃을 Toolbar와 FrameLayout을 포함함.  
  드로워 레이아웃의 두 번째 요소는 드로워의 콘텐트를 정의하며 보통 NavigationView를 사용함.
- NavigationView는 디자인 지원 라이브러리에서 제공함.  
  대부분의 드로워 동작을 제어함.
- 레이아웃을 생성해 드로워에 헤더를 추가하고 내비게이션 뷰의 headerLayout 속성에 헤더의 리소스 ID를 추가할 수 있음.
- 드로워에 표시하려는 순서대로 메뉴 리소스에 항목을 추가함.
- 사용자가 선택한 항목을 드로워에서 강조하려면 메뉴 아이켐을 그룹으로 추가한 다름 그룹의 checkableBehavior 속성은 "single"로 설정함.
- ActionBarDrawerToggle을 이용해 액티비티의 툴바에 '버거' 아이콘을 표시할 수 있음.  
  이 아이콘은 액티비티가 내비게이션 드로워를 제공함을 보여줌.  
  아이콘을 클릭하면 드로워가 열림.
- 액티비티에 NavigationView.OnnavigationItemSelectedListener 인터페이스를 구현함으로써  
  드로워 항목 클릭에 응답할 수 있음.  
  액티비티를 내비게이션 뷰의 리스너로 등록한 다음 onNavigationItemSelected()를 구현함.
- DrawerLayout의 closeDrawer()를 이용해 NavigationDrawer를 닫음.