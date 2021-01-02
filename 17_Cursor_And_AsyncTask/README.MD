# Cursor와 AsynkTask
대부분의 APP은 자신의 DB를 갱신함.  
사용자의 입력에 응답해서 DB의 값을 갱신하는 방법을 알아보자.  
갱신된 데이터를 새로 표시하는 방법도 알아보자.  
앱의 성능이 떨어지지 않도록 AsynkTask를 이용해 효과적으로 MultiThread Code를 구현하는 방법을 알아보자.

## 핵심 정리
- CursorAdapter의 changeCursor()로 현재 커서 어댑터에서 사용하는 커서를 새로운 커서로 바꿀 수 있음.  
  이때, 이전 커서는 자동으로 닫힘.
- AsyncTask를 통해 DB Code를 Background에서 실행함.

## AsyncTask 실행 과정 요약
1. onPreExecute()
    - task를 설정함.
    - background task가 실행되기 전에 메인 이벤트 스레드로 호출됨.
2. doInBackground()
    - background Thread로 실행됨.
    - onPreExecute()가 호출된 바로 다음에 실행됨.
    - 인자형과 반환형을 지정할 수 있음.
3. onProgressUpdate()
    - 진행 상황을 표시할 수 있음.
    - onInBackground()에서 publishProgress()를 호출하면 onProgressUpdate()가 메인 이벤트 스레드로 호출됨.
4. onPostExecute()
    - doInBackground() 실행이 끝나면 그 결과를 onPostExecute()를 이용해 사용자에게 표시할 수 있음.
    - doInBackground()의 반환값을 인자로 받아 메인 이벤트 메소드에서 실행함.