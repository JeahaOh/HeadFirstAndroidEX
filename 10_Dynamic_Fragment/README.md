# 큰 인터페이스용 프래그먼트
## 다양한 크기, 다양한 인터페이스
앱이 실행되는 디바이스에 따라 모습과 동작이 달라지도록 유연한 사용자 인터페이스를 생성하는 방법을 알아보자.  
백 스택과 프래그먼트 트랜잭션을 이용해 Back 버튼을 클릭했을 때 앱을 제어하는 방법을 알아보자.  
프래그먼트의 상태를 저장 했다가 복원하는 방법도 알아보자.

## 핵심 정리
- 디바이스의 알맞은 폴더에 별도의 레이아웃을 추가함으로써 다양한 디바이스에 다양한 앱의 모습을 제공할 수 있음.
- 안드로아디는 사용자가 방문한 장소를 백 스택에 별도의 트랜잭션으로 저장함. Back 버튼을 클릭하면 가장 최근의 트랜잭션이 백 스택에서 팝됨.
- 프래그먼트 트랜잭션을 이용해 프로그램으로 프래그먼트를 추가, 교체, 삭제하려면 프레임 레이아웃을 사용함.
- FragmentManager의 beginTransaction() 으로 트랜잭션을 시작하고, FragmentTransaction 객체가 생성됨.
- FragmentTransaction의 add(), replace(), remove()로 프래그먼트를 추가, 교체, 삭제할 수 있음.
- FragmentTransaction의 addToBackStack()으로 트랜잭션을 백 스택에 추가함.
- FragmentTransaction의 commit()로 트랜잭션을 커밋하고, 트랜잭션의 모든 변경사항을 적용함.
- 프래그먼트 변수의 상태를 Feragment의 onSaveInstanceState()에 저장할 수 있음.
- Fragment의 onCreate()로 프래그먼트의 변수의 상태를 복원함.