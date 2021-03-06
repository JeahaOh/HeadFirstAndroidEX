package ex.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DrinkCategoryActivity extends Activity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        //  ListView의 setAdapter메소드로 배열 어댑터를 리스트 뷰에 연결함
        ListView listDrinks = findViewById(R.id.list_drinks);

        SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper( this );

        try{
            db = starbuzzDatabaseHelper.getReadableDatabase();
            cursor = db.query( "DRINK",
                    new String[] { "_id", "NAME" },
                    null, null, null, null, null);

            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                    this, android.R.layout.simple_list_item_1, cursor,
                    new String[] { "NAME" },
                    new int[] { android.R.id.text1 },
                    0 );

            listDrinks.setAdapter( listAdapter );

        }   catch( SQLiteException e ) {
            Toast toast = Toast.makeText( this, "Database unavailable", Toast.LENGTH_SHORT );
            toast.show();
        }

        //  리스너 생성
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener () {
                    public void onItemClick( AdapterView<?> listDrinks,
                                             View itemView,
                                             int position,
                                             long id ) {
                        //  사용자가 클릭한 음료를 DrinkActivity로 전달
                        //  사용자가 음료를 클릭하면 해당 항목의 ID를 DrinkActivity로 넘겨주면서 Activity를 시작
                        Intent intent = new Intent( DrinkCategoryActivity.this,
                                                    DrinkActivity.class );
                        intent.putExtra( DrinkActivity.EXTRA_DRINKID, (int) id );
                        startActivity( intent );
                    }
                };
        //  리스너를 리스트 뷰에 할당
        listDrinks.setOnItemClickListener( itemClickListener );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }
}




