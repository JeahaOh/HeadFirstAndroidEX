package ex.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DrinkActivity extends Activity {

    public static String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //  인텐트에서 음료 정보 얻기
        int drinkId = (Integer) getIntent().getExtras().get( EXTRA_DRINKID );

        //  커서 생성
        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper( this );

        try{
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[] { "NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID" },
                    "_id = ?",
                    new String[] { Integer.toString(drinkId)},
                    null, null, null );
            //  커서의 첫 번째 레코드로 이동
            if( cursor.moveToFirst() ) {
                //  커서에 레코드가 하나뿐이지만, 첫 번때 레코드로 이동해야 함.

                //  커서에서 음료 정보 얻기
                String nameText = cursor.getString( 0 );
                String descriptionText = cursor.getString( 1 );
                int photoId = cursor.getInt( 2 );

                //  음료 이름 설정
                TextView name = findViewById(R.id.name);
                name.setText( nameText );

                //  음료 설명 설정
                TextView description = findViewById(R.id.description);
                description.setText( descriptionText );

                //  음료 이미지 설정
                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource( photoId );
                photo.setContentDescription( nameText );
            }
            cursor.close();
            db.close();
        }   catch( SQLiteException e ) {
            Toast toast = Toast.makeText( this, "Database unavailable", Toast.LENGTH_SHORT );
            toast.show();
        }
    }
}
