# 풍부하고 멋진 UI를 가진 Application을 만드는 방법
안드로이드 지원 라이브러리에서 제공하는 기능을 하용해 보도록 함.  
앱에 TAB을 추가하는 방법을 알아봄.  
툴바를 접거나 스크롤 되도록 애니메이션으로 만드는 방법을 알아봄.  
플로팅 액션 버튼으로 가용자 액션을 추가하는 방법을 알아봄.  
스낵바를 사용해 봄.

## 핵심 정리
- ViewPager로 Swap 탐색을 활성화할 수 있음.
- FragmentPagerAdapter를 구현해 ViewPager에 Page 정보를 전달할 수 있음.
- FragmentPagerAdapter의 getcount()는 얼마나 많은 페이지가 있는지 ViewPager에게 알려줌.  
  getItem()로 각 페이지가 어떤 Fragment가 표시되어야 하는지 지정함.
- TabLayout을 구현해 Tab Navigation을 추가함.  
  Toolbar와 TabLayout을 Layout 코드의 AppBarLayout안에 추가한 다음 Tab Layout을 Activity 코드의 ViewPager로 연결함.
- TabLayout을 Android Design Support Library에서 제공함.  
  이 Library는 App에서 Material Design Guide Line을 구현하는데 도움을 줌.
- CoordinationLayout으로 View 간의 Animation을 조정함.
- CoordinationLayout이 조정할 수 있는 Scroll 가능한 Content를 NestedScrollView를 사용하여 추가함.
- 사용자의 ScrollAction에 응답해 접거나 펴는 ToolbarLayout을 사용하는게 좋음.
- FAB(Floating Action Button)을 이용하면 사용자가 공통 액션이나 중요한 사용자 액션을 쉽게 이용할 수 있도록 제공할 수 있음.
- Snackbar로 사용자가 상호작용할 수 있는 짧은 메세지를 표시할 수 있음.