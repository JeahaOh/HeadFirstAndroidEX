## 대화형 앱 만들기

대부분의 앱은 사용자와 상호 작용을 함.  

## R?
R.java는 우리가 앱을 만들거나 빌드할 때마다 안드로이드 스튜디오가 자동으로 생성하는 특별한 자바 파일임.  
R.java는 앱의 패키지와 같은 이름으로  
```
app/build/generated/source/r/debug
```
폴더에 생성됨  
  
안드로이드는 R.java로 앱에서 사용하는 리소스를 추적하고, 액티비티 코드에서 GUI 컴포넌트 레퍼런스를 얻을 때도 R을 사용함.  
R.java를 열어보면 각각의 리소스 유형을 나타내는 여러 내부 클래스가 있다는 사실을 알 수 있음.  
그런 유형의 각 리소스는 내부 클래스 내에서 참조됨.  
예를 들어 R.java는 id라는 내부 클래스를 포함하며 그 안에는 ststic final brands 값이 정의되 있음.  
우리가 레이아웃에 @+id/brands 라는 코드를 사용했을 때 안드로이드가 R.java에 추가한 코드임.

## 핵심 정리
- 버튼을 추가할 때는 <Button>요소를 사용
- 드롭다운 값 목록을 제공하는 스피너를 추가할 때는 <Spinner>를 사용함.
- 모든 GUI 컴포넌트는 뷰의 일종임. 이들은 안드로이드 View 클래스를 상속받음.
- strings.xml은 문자열 리소스 파일임. 텍스트 값을 레이아웃과 액티비티에서 분리하고 지역화를 지원하는 역할을 함.
- 다음과 같은 방법으로 string.xml에 문자열 배열을 추가함.
    ```
    <string-array name="array">
        <item>string1</item>
        . . .
    </string-array>
    ```
- 레이아웃에서는 다음과 같은 방법으로 string-array를 참조함
    ```
    "@array/array_name"
    ```
- 레이아웃에서는 다음과 같은 방법으로 버튼을 클릭했을 때 실행될 메소드를 지정함
    ```
    android:onClick="clickMethod"
    ```
- 액티비티에 대응하는 메소드를 정의해야 함.
    ```
    public void clickMethod( View view ) {  }
    ```
- R.java는 자동으로 생성됨. R.java를 이용해 레이아웃, GUI 컴포넌트, 문자열, 자바코드의 기타 리소스등 레퍼런스를 얻을 수 있음.
- findViewById()를 이용해 뷰 레퍼런스를 얻음.
- setText()로 뷰의 텍스트를 설정함
- getSelectedItem()으로 스피너에서 선택된 항목을 얻음.
