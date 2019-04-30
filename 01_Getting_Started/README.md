## Android Structure
```
Root    : 루트 폴더틑 프로젝트 이름과 같음. 포로젝트의 모든 파일은 루트 아래 있음.
    |- App  : 프로젝트의 모듈
    |    |- build   : 안드로이드 스튜디오가 생성한 파일이 들어있음. 이 폴더는 편집할 필요가 없음.
    |        |- gernerated/source
    |            |- r/debug
    |                |- ex/android/studies
    |                    |- R.java  : 모든 안드로이드 프로젝트는 generated/source 폴더에 자동 생성된 R.java파일을 포함.
    |                                 안드로이드는 이 파일로 앱의 리소스를 관리함.
    |- src  :  구현하고 편집한 소스 코드를 갖고 있음.
        |- main
            |- java : 구현한 모든 자바 코드를 갖고 있음.
            |    |    모든 activity가 여기에 위치함.
            |    |- ex/android/studies
            |        |- MainActivity.java : 액티비티를 정의함.
            |                               앱이 사용자와 어떻게 상호작용할지 안드로이드에 지시함.
            |- res  : 모든 종루의 리소스를 갖고 있음.
            |   |- layout
            |   |    |- activity_main.xml    : 레이아웃을 정의. 앱의 모양을 안드로이드에 지시함.
            |   |- value
            |        |- string.xml  : 문자열 리소스 파일.
            |                         앱의 이름과 기본 텍스트 값 등의 문자열을 포함함.
            |                         레이아웃과 액티비티 등 다른 파일에서 문자열 리소스 파일의 값을 참조할 수 있음.
            |- AndroidManifest.xml  : 모든 안드로이드 앱은 반드시 AndroidManifest.xml 파일을 루트에 포함하고 있어야 함.
                                      Manifest 파일은 앱이 포함하는 컴포넌트, 앱에 필요한 라이브러리, 기타 정의 등 앱에 필요한 필수 정보를 포함.
```
- - -

## Compile, Package, Distribute, Run

### 앱을 실행하려면
Run 명령을 내려도 바로 앱이 실행되는 것은 아님.  
  
1. 자바 소스파일은 바이트 코드로 컴파일
2. APK 파일(Android Application Package) 생성
3. AVD를 활성화 함.
4. AVD가 활성화 되면 APK파일이 AVD로 업로드 되고 설치됨.
5. AVD가 APP과 관련된 MainActivity를 시작함.

- - -

### 앱을 실행하면?  
  
1. Android Studio가 Emulator를 실행하고 AVD를 로드한 다음에 앱을 설치함.
2. 앱이 실행되면 MainActivity java로 정의한 액티비티 객체가 생성됨.
3. MainActivity가 activity_main.xml을 Layout으로 사용한다고 지정함.
4. activity는 layout을 화면에 표시하라고 안드로이드에 지시함.  
  
activity는 app의 동작을 지시함.  
layout은 app의 모양을 제어함.

- - -

## Chapter 핵심 정리

- 각 안드로이드 버젼은 버젼 번호, API 수준, 코드명을 포함함.
- 안드로이드 스튜디오는 안드로이드 소프트웨어 개발 킷(SDK)과 Gradle Build System을 포함하는 Inteli J IDEA의 특별 버전임.
- 보통 안드로이드 앱은 Activity, Layout, Resource 파일을 포함함.
- Layout은 앱의 모양을 표현함.
    - app/src/main/res/layout
- Activity는 앱의 동작, 사용자와의 상호 작용을 기술함.
    - app/src/main/res/layout
- AndroidManifest.xml은 앱 자체의 정보를 포함.
    - app/src/main
- AVD (Android Virtual Device)
    : 안드로이드 에뮬레이터에서 실행되며 물리적 안드로이드 디바이스를 흉내냄.
- APK (Android Application Package)
    : 안드로이드 앱의 JAR 파일 역할을 하고, 앱의 바이트코드, 라이브러리, 리소스등을 포함함.
      APK로 앱을 안드로이드 디바이스에 설치할 수 있음.
- Android Runtime (ART)를 이용해 별도의 프로세스에서 실행 됨.
