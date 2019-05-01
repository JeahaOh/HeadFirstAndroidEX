# RecyclerView와 CardView 재활용 하기
리스트 뷰가 대단한 기능을 가지고 있지는 않지만 대부분의 앱에서 핵심 기능을 담당하고 있음.  
이번 장에서는 더 많은 유연성과 Material 정신에 맞는 진보된 형식의 리스트인 RecyclerView를 알아보도록 하자.  
데이터에 맞는 Adapter를 생성하는 방법과 단 2줄의 코드로 리스트의 모양을 바꾸는 방법도 알아보자.  
3D Material 디자인 형식으로 데이터를 제공하는 CardView를 사용하는 방법도 알아보자.

## 핵심 정리
- CardView와 RecyclerView는 각각 자신만의 지원 라이브러리를 갖고 있음.
- `<android:support.v7.widget.CardView>` 요소로 Layout에 CardView를 추가함.
- cardCornerRadius 속성으로 CardView의 모서리를 둥글게 만들 수 있음.  
  그러려면 namespace "http://schemas.android.com/apk/res-auto"를 추가해야 함.
- cardElevation 속성으로 그림자 효과를 줄 수 있음.  
  그러려면 namespace "http://schemas.android.com/apk/res-auto"를 추가해야 함.
- RecyclerView는 RecyclerView.Adapter를 상속받는 Adapter를 사용함.
- 직접 RecyclerView.Adapter를 구현할 때, 반드시 ViewHolder를 정의하고,  
  onCreateViewHolder(),  
  onBindViewHolder(),
  getItemCount()도 구현 해야 함.
- `<android.support.v7.widget.RecyclerView>` 요소로 Layout에 RecyclerView를 추가할 수 있음.  
  android:scrollbars 속성으로 ScrollBar를 추가 할 수 있음.
- LayoutManager로 RecyclerView에 항목을 어떻게 배치할지 지정할 수 있음.  
  LinearLayoutManager는 항목을 선형 리스트에 배치하고,  
  StaggeredGridLayoutmanager는 항목을 엇갈림 Grid에 배치함.