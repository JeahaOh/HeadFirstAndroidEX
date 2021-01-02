# SQLite Data Base
안드로이드의 내장 DB인 SQLite를 공부해 보자

## 핵심 정리
- Android는 SQLite를 DB로 사용해 저장함.
- SQLiteDatabase 클래스로 SQLite DB에 접근할 수 있음.
- SQLite Helper를 이용해 SQLite DB를 생성, 관리할 수 있음.  
  SQLiteOpenHelper 클래스를 상속받아 SQLiteHelper를 생성할 수 있음.
- SQLiteOpenHelper의 onCreate()와 onUpgrade()를 구현해야 함.
- DB는 처음 접근할 때 생성됨.  
  이때 DB의 이름과 버전 숫자를 제공해야 함.  
  DB의 이름을 제공하지 않으면 DB가 메모리 상에서만 생성됨.
- DB가 처음 생성되면 onCreate()가 호출됨.
- DB를 upgrade할 때 onUpgrade()가 호출됨.
- SQLiteDatabase의 execSQL(String)으로 SQL을 실행함.
- ALTER TABLE 문으로 기존 테이블을 바꿀 수 있음.  
  RENAME TO를 이용해 테이블의 이름을 바꾸거나 ADD COLUMN으로 테이블에 열을 추가할 수 있음.
- DROP TABLE 문으로 테이블 삭제 가능.
- insert()로 테이블에 레코드를 삽입함.
- update()로 레코드를 갱신한.
- delete()로 테이블에서 레코드를 삭제함.
