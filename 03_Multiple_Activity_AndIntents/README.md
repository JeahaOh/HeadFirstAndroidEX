## 대부분의 앱은 한 개 이상의 액티비티를 사용함
여러 Activity를 갖는 Application을 만드는 방법과 Intent로 Activity의 소통하는 방법.  
그리고 Application의 영역을 벗어나 Intent으로 디바이스에 설치된 다른 Application의 Activity가 동작하도록 만드는 방법을 살펴 봄.  
  
## 핵심 정리
- 한 개 이상의 Activity를 연결해 Task를 만듦.
- <EditText> 요소는 편집할 수 있는 텍스트 필드를 정의하여 텍스트를 입력할 수 있도록 함.
- Android Studio의 [File -> New... -> Activity]를 선택하여 새 Activity를 추가할 수 있음.
- 생성한 모든 Activity 항목은 AndroidManifest.xml에 정의 되어야 함.
- Intent는 Android Component끼리 통신할 때 사용하는 일종의 메세지임.
- 명시적 Intent는 대상 컴포넌트를 지정함. 다음과 같이 생성함.
    ```
    Intent intent = new Intent(this, Target.class);
    ```
- startActivity(intent)로 Activity를 시작할 수 있음. Activity를 찾지 못하면 ActivityNotFoundException이 발생함.
- putExtra() 메소드로 Intent에 추가 정보를 덧붙일 수 있음.
- getIntent() 메소드로 Activity가 시작된 Intent를 얻을 수 있음.
- get*Extra() 메소드로 Intent에 포함된 추가 정보를 얻을 수 있음
- Activity Action은 Activity가 수행할 수 있는 표준 동작을 기술해야 함. (ex: Intent.ACTION_SEND)
- Intent intent = new Intent( action ); 처럼 Action을 이용하면 암묵적인 Intent를 생성할 수 있음.
- setType() 메소드로 Intent의 Data Type을 지정할 수 있음.
- 안드로이드는 Intent에 정의된 컴포넌트 이름, 액션, 데이터 유형, 카테고리 등을 이용해 인텐트를 해석함.
  각 앱의 AndroidManifest.xml에 정의된 Intent Filter를 Intent의 내용과 비교함.
  Activity는 DEFAULT 카테고리를 정의해야 암묵적 인텐트를 수신할 수 있음.
- createChooser() 메소드를 이용해 android Activity 선택자 다이얼로그를 오버라이드할 수 있음.
  다이얼로그의 제목을 지정할 수 있으며 기본 액티비티를 선택할 수 있는 옵션을 제거할 수 있음.
  전달한 Intent를 수신할 수 있는 Activity가 없으면 메세지를 출력함.
  createChooser() 메소드는 Intent를 반환함.
- getString(R.string.stringname);을 이용해 문자열 리소스의 값을 반환받을 수 있음.
