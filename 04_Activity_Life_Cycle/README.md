## Activity Life Cycle
Activity는 모든 안드로이드 앱의 기초임.  
Activity가 생성되고 파괴될 때 내부적으로 어떤 일이 일어나는지,  
Actitity가 보일 수 있는 상태가 되고,  
포그라운드에 나타나면 어떤 메소드가 호출되고,  
포커스를 읽거나 숨기면 어떤 메소드가 호출되는지,  
Activity의 상태를 어떻게 저장하고 복원할 수 있는지 살펴보자.

## Activity의 실제 작동
- Application은 Activity, Layout, Resource의 Collection임.
- 기본적으로 각 Application은 자신의 Process에서 실행 됨.
- startActivity()로 Intent를 전달해서 다른 Application의 Activity를 실행할 수도 있음.
- Activity를 시작해야 할 때 Android는 해당 Application의 process가 이미 존재하는지 확인함.
- Android가 Activity를 시작하면, Activity의 onCreate()를 호출함.

## Stopwatch Application
간단한 Stopwatch Application을 이용해 Life Cycle Method를 살펴볼것임.  

### Background Thread
메초 seconds변수의 값을 증가 시키고, textView를 갱신 할 수 있도록 코드를 반복 수행해야 함.  
이때, 메인 안드로디으 스레드를 블록시키지 않아야 함.  
안드로이드 이외의 일반 자바 프로그램에서는 백그라운드 스레드를 이용해 이를 달성할 수 있음.  
안드로이드에서는 이 방법을 사용할 수 없는데 메인 안드로이드 스데르만 사용자 인터페이스를 갱신할 수 있기 때문임.  
다른 스레드에서 사용자 인터페이스를 갱신하려 하면 CalledFromWrongThreadException이 발생함.  
이 문제는 Handler로 해결할 수 있음.  
  
안드로이드에서 제공하는 Handler 클래스를 사용하면 특정 코드를 미래의 특정 시점에 수행할 수 있음.  
메인 안드로이드 스레드가 아닌 다른 스레드에서 코드를 수행할 때도 이 클래스를 사용할 수 있음.  
이 앱에서눈 Handler로 스톱워치 코드가 매초 실행되도록 해야함.  
실행을 계획한 코드를 Runnable 객체로 감싼 다음,  
Handler의 post(), postDelayed()로 언제 코드를 실행할지 지정할 수 있음.
  
  
#### post()
post()는 가능한 한 빨리 코드를 실행할 때 사용함.  
이 메소드는 Runnable 유형의 객체 한 개를 인자로 받음.  
Runnable객체는 일반적인 자바의 Runnable과 같으며 우리가 실행하려는 작업임.  
Runnable의 run()에 우리가 실행할 코드를 추가하면 Handler가 가능한 빨리 메소드를 실행함.
```
final Handler handler = new Handler();
handler.post( Runnable );
```

#### postDelayed()
postDelayed()는 post()와 거의 비슷하게 작동하지만 미래에 코드를 실행함.  
postDelayed()는 Runnable과 long 두 개의 인자를 받음.  
Runnable은 실행하려는 코드를 run() 메소드에 포함하며, long은 코드가 얼마 뒤에 실행될 것인지 밀리초로 지정함.  
코드는 지정된 지연시간 이후에 실행 됨.
```
final Handler handler = new Handler();
handler.postDelayed( Runnable, long );
```

### 화면을 회전 시키면 디바이스 구성이 바뀜.
안드로이드가 앱을 실행하고 액티비티를 시작할 때 **디바이스 구성**을 이용함.  
화면의 크기와 방향, 키보드 연결 유무 등 물리 디바이스의 구성과 사용자가 지정한 로케일의 구성을 이용하는 것임.  
디바이스 구성이 바뀌면 사용자 인터페이스에 표시하는 모든 내용도 새로운 구성에 맞게 갱신됨.  
디바이스를 회전 시키면 안드로이드 화면 방향과 크기가 바뀌게 됨을 인식하고 이를 디바이스 구성 변경으로 취급,  
안드로이드는 현재 액티비티를 종료하고 바뀐 고성에 따라 적절한 리소스를 사용해 다시 액티비티를 생성함.

### 액티비티 상태
안드로이드가 액티비티를 생성하고 종료할 때  
액티비티는  
시작 상태에서 실행 상태로,  
실행 상태에서 종료 상태로 바뀌게 됨.  
  
액티비티는 주로 실행 상태와 활성화 상태를 유지함.  
액티비티가 실행되어 화면에 나타난 상태에 포커스를 가지고 있으면  
사용자는 해당 액티비티와 상호작용할 수 있음.  
액티비티는 생명 주기에서 보통 실행 상태를 가장 오래 유지함.  
액티비티가 시작되고 실행 된 다음 할 일이 끝나 생명주기가 끝나면 액티비티가 종료됨.  
  
액티비티가 시장 상태에서 종료 상태로 바뀌면 각각 onCreate(), onDestroy()가 호출 됨.  
이들 생명주기 메소드들을 Activity 클래스에서 상속받은 것으로, 오버라이드 해서 사용할 수 있음.  
  
액티비티가 시작되면 onCreate()가 호출 되고,  
setContentView() 호출등 액티비티 설정 관련 작업을 onCreate()에서 수행함.  
따라서 onCreate()는 항상 오버라이드 함.  
액티비티가 종료되면 onDestroy()메소드를 호출함.

### 액티비티 생명주기 : 생성에서 종료
1. 액티비티가 시작됨.
2. 액티비티가 시작된 다음 곧바로 onCreate() 실행
    - 이 메소드에서 필요한 초기화 작업을 수행할 수 있음.
3. 액티비티가 화면에 나타나면 실행 상태가 되어 사용자가 상호작용을 할 수 있음.
4. 액티비티가 종료되기 전에 onDestroy()가 호출됨
5. onDestroy() 가 실행된 다음 액티비티가 종료됨.

### 모든 액티비티는 생명주기 메소드를 상속 받음.

### 현재 상태를 저장
화면을 회전시키면 액티비티가 종료되고 다시 생성되면서 지역변수가 초기화 되고 문제가 발생함.  
액티비티의 현재 상태를 저장하고 액티비티가 생성될때 이를 불러오면 해결이 됨.  
액티비티의 현재 상태를 저장하려면 onSaveInstanceState()를 구현 하면 됨.
이 메소드는 액티비티가 종료될때 호출 됨으로 이 메소드에서 필요한 정보를 저장 할 수 있음.  
onSaveInstanceState() 메소드는 여러 종류의 데이터를 한 객체에 저장하는 Bundle을 인자로 받음.  
running과 seconds변수를 Bundle에 저장하면 onCreate()에서 이 값을 다시 살릴 수 있음.  
Bundle은 key/value를 이용해 값을 저장함.  
  
### 액티비티 생명 주기 : 보이는 상태의 생명 주기
onStart(), onStop(), onRestart()
1. 액티비티가 실행되면서 onCreate()
2. 액티비티가 보이는 상태가 되려 할 때 onStart()
3. 액티비티가 보이지 않게 되면 onStop()
4. 액티비티가 다시 보이면 onRestart(), 이어서 onStart()
5. 액티비티 종료시 onStop() 이후에 onDestroy()

## 앱이 부분적으로 보이는 상태라면?
액티비티가 포커스를 가지고 있지 않다면?  
액티비티가 보이는 상태지만 포커스를 가지고 있지 않으면 액티비티는 정지됨.  
액티비티가 전체 화면이 아니거나 투명한 상태일 때 액티비티 위에 이런 일이 일어날 수 있음.  
가장 위에 있는 액티비티가 포커스를 갖게 되고 그 아래늬 액티비티는 보이지만 멈춘 상태로 존재하게 됨.  
액티비티가 정지할 때는 onPause(), 다시 활성화 될 때는 onResume()이라는 생명주기 메소드가 각각 호출됨.  

### 액티비티 생명주기 : 포그라운드 상태
onResume(), onPause()  
1. 액티비티가 시작되고 onCreate()와 onStart()
2. 액티비티가 포커스를 갖기 전에 onResume()
    - 액티비티가 포그라운드로 이동하기 직전에 이 메소드가 실행됨.
3. 액티비티가 포그라운드에서 사라지기 직전에 onPause()
    - onPause()가 실행되면 액티비티는 보이더라도 포커스를 가지지 않음.
4. 액티비티가 다시 포그라운드에 나타나면 onResume()
    - 액티비티가 포커스를 잃었다 얻었다를 반복하면 이 단계가 여러번 일어남.
5. 액티비티가 보이지 않으면 onStop()
6. 액티비티가 다시 사용자에게 보이면 onRestart(), onStart(), onResume()이 차례로 호출
7. 액티비티 종료

## 핵심 정리
- 각각의 Application은 기본적으로 고유의 Process에서 실행됨.
- Main Thread만 사용자의 인터페이스를 갱신할 수 있음.
- Handler를 이용해서 코드의 실행을 계획하거나 다른 Thread로 코드를 전달할 수 있음.
- Device 구성이 바뀌면 Activity는 종료되고 새로 생성됨
- 모든 Activity는 android.app.Activity 클래스를 상속받음.
    - Activity 클래스의 메소드를 Override하는 모든 메소드는 상위 클래스의 케소드를 호출해야 함.
    ```
    @Override
    protected void onPause() {
        super.onPause();
    }
    ```
- onSaveInstanceState( Bundle )를 이용하면 Activity가 종료되기 전에 필요한 상태 정보를 저장할 수 있음.
    - onCreate()에서 Bundle을 이용해 저장된 상태를 복원할 수 있음.
- bundle.put*( "KEY", VALUE )를 이용해 Bundle에 값을 저장할 수 있음.
    - 불러올 때는 bundle.get*( "KEY" )를 이용함.
- onCreate()와 onDestroy()는 액티비티의 생성과 종료를 처리함.
- onRestart(), onStart(), onStop()은 액티비티가 보이는지 여부와 관련된 작업을 처리함.
- onResume()과 onPause()는 Activity가 포커스를 받거나 잃었을 때의 상황을 처리함.

### Activity Life Cycle 
```
            Acitivity 시작
                |
            onCreate()
                |
    +------ onStart() <--------+
    |           |              |
    |   +-> onResume()         |
    |   |       |              |
    |   |   Activity 실행   onRestart()
    |   |       |              |
    |   +-- onPause()          |
    |           |              |
    +-----> onStop() ----------+
                |
            onDestroy()
                |
            Activity 종료
```
|Method|호출되는 상황|다음 Method|
|:--------|:--------:|--------:|
|**onCreate()**|처음 액티비티가 생성되면 호출됨.뷰 생성하기 등 일반적인 정적 설정을 진행함.  액티비티의 이전 상태를 저장한 Bundle이 인자로 전달됨.|**onStart()**|
|**onRestart()**|액티비티가 중지되었다가 다시 시작하기 직전에 호출|**onStart()**|
|**onStart()**|액티비티가 보이는 상태가 되었을 때 호출 됨.  액티비티가 포그라운드로 이동하면 onResume()이 호출되고, 액티비티가 보이지 않는 상태가 되면 onStop()이 호출됨.|**onResume() 또는 onStop()**|
|**onResume**|액티비티가 포그라운드로 이동했을 때 호출.|**onPause()**|
|**onPause()**|다른 실행 중인 액티비티 때문에 현재 액티비티가 더이상 포그라운드에 있지 않는 순간 호출됨.  이 메소드의 실행이 끝날 때까지 다음 액티비티는 재개되지 않으므로 이 메소드는 동작을 빨리 실행하고 반환 해야 함. 액티비티가 포그라운드로 돌아오면 onResume()이 이어서 호출되고 액티비티가 보이지 않는 상태가 되면 onStop()이 이어서 호출.|**onResume() 또는 onStop()**|
|**onStop()**|액티비티가 더 이상 보이지 않는 상태에서 호출됨. 다른 액티비티가 현재 액티비티를 가렸거나 액티비티가 종료 되었을 때 이런 상황이 발생할 수 있음. 액티비티가 다시 보이는 상태가 되면 onRestart()가, 종료되면 onDestroy()가 호출됨.|**onRestart() 또는 onDestroy()**|
|**onDestroy()**|액티비티가 종료되려는 순간 또는 액티비티가 종료를 시작했을 때 호출.|**-**|

