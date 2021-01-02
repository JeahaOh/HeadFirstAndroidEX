# Basic Cursor
Activity에서 DB에 접근하는 방법을 알아보자.  
Cursor를 이용해 DB에서 data를 가져오는 방법을 알아보자.  
Cursor를 이동하는 방법과 Cursor로 data에 접근하는 방법,  
Cursor Adapter를 이용해 Cursor와 ListView를 연결하는 방법을 알아보자.

## 핵심 정리
- Cursor를 이용해 DB의 data를 읽거나 기록할 수 있음.
- SQLiteDatabase의 query()로 Cursor를 생성함.  
  내부적으로 query()를 SELECT문으로 만듦.
- getWriteableDatabase()는 DB로 읽기, 쓰기 작업을 할 수 있는 SQLiteDatabase 객체를 반환함.
- getReadableDatabase()는 읽기 전용으로 접근할 수 있는 SQLiteDatabase 객체를 반환함.  
  DB에 기록할 수도 있지만 항상 기능이 보장되진 않음.
- moveTo*()로 Cursor를 이동할 수 있음.
- get*()로 Cursor에서 값을 가져옴. 작업을 완료하면 Cursor와 DB의 열결을 닫음.
- CursorAdapter는 Cursor와 작동하는 Adapter임.  
  Cursor가 반환한 값을 List View에 채울때는 SimpleCursorAdapter를 이용함.