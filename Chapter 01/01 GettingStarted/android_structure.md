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