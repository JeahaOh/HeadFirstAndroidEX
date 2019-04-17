# List View And Adapter
기본 기능들을 배웠으니 이들을 잘 정리하는 방법을 익혀 보자.  
Application design의 햇심에 List Data를 적용하는 방법과,  
이들을 서로 연결해 사용하기 쉬운 강력한 Application을 만드는 방법을 배워 보자.  
그리고 EventListener와 Adapter를 사용해서 동적인 Application을 만들어 보자.

## 핵심 정리
- Activity의 IDEA를 최상위 Activity, Category Activity, Detail / Edit Activity로 분류한뒤,  
  Category Activity를 통해 최상위 Activity에서 Detail / Edit Activity로 탑색할 수 있음.
- List View는 항목을 List로 표시함.  
  `<ListView>`요소로 Layout에서 ListView를 추가함
- Layout 코드에서 android:entries를 통해 string.xml에 정의된 배열의 데이터를 List View에 채움
- Adapter는 AdapterView와 Data Source를 연결하는 다리 역할을 함.  
  ListView와 Spinner는 모두 AdapterView의 일종임
- ArrayAdapter는 배열에 특화된 Adapter임
- Button의 클릭 이벤트는 Layout 코드에서 android:onClick속성으로 처리할 수 있으나,  
  그 밖의 View에서는 Listener를 생성하고 클릭 이벤트를 구현해서 처리해야함.