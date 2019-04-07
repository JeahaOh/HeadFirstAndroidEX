## 앱을 실행하려면
Run 명령을 내려도 바로 앱이 실행되는 것은 아님.  
  
1. 자바 소스파일은 바이트 코드로 컴파일
2. APK 파일(Android Application Package) 생성
3. AVD를 활성화 함.
4. AVD가 활성화 되면 APK파일이 AVD로 업로드 되고 설치됨.
5. AVD가 APP과 관련된 MainActivity를 시작함.

- - -

## 앱을 실행하면?  
  
1. Android Studio가 Emulator를 실행하고 AVD를 로드한 다음에 앱을 설치함.
2. 앱이 실행되면 MainActivity java로 정의한 액티비티 객체가 생성됨.
3. MainActivity가 activity_main.xml을 Layout으로 사용한다고 지정함.
4. activity는 layout을 화면에 표시하라고 안드로이드에 지시함.  
  
activity는 app의 동작을 지시함.  
layout은 app의 모양을 제어함.

- - -


