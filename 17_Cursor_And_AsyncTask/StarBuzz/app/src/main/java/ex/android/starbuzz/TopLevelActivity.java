package ex.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends Activity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        setupOptionsListView();
        setupFavoriteListView();
        };

    private void setupOptionsListView() {
        //  onItemClickListener 생성
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick( AdapterView<?> listView, View itemView, int position, long id ) {
                if( position == 0 ) {
                    Intent intent = new Intent( TopLevelActivity.this, DrinkCategoryActivity.class );
                    startActivity( intent );
                }
            }
        };

        //  리스너를 리스트 뷰에 추가
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener( itemClickListener );
    }

    private void setupFavoriteListView() {
        //  커서로 list_favorites 리스크 뷰 채우기
        ListView listFavorites = (ListView) findViewById(R.id.list_favorites);

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper( this );
            db = starbuzzDatabaseHelper.getReadableDatabase();
            favoritesCursor = db.query( "DRINK",
                    new String[] { "_id", "NAME" },
                    "FAVORITE = 1",
                    null, null, null, null );

            CursorAdapter favoritesAdapter =
                    new SimpleCursorAdapter( TopLevelActivity.this,
                            android.R.layout.simple_list_item_1,
                            favoritesCursor,
                            new String[] { "NAME" },
                            new int[] { android.R.id.text1 }, 0 );
            listFavorites.setAdapter( favoritesAdapter );
        }   catch( SQLiteException e ) {
            Toast toast = Toast.makeText( this, "Database unavailable", Toast.LENGTH_SHORT );
            toast.show();
        }

        //  음료를 클릭하면 DrinkActivity로 이동
        listFavorites.setOnItemClickListener( new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick( AdapterView<?> listView, View v, int position, long id ) {
               Intent intent = new Intent( TopLevelActivity.this, DrinkActivity.class );
               intent.putExtra( DrinkActivity.EXTRA_DRINKID, (int) id );
               startActivity( intent );
           }
        });
    }

    //  TopLevelActivity로 돌아오면 데이터 새로고침
    @Override
    public void onRestart() {
        super.onRestart();
        Cursor newCursor = db.query( "DRINK",
                new String[] { "_id", "NAME" },
                "FAVORITE = 1",
                null, null, null, null );

        ListView listFavorites = (ListView) findViewById(R.id.list_favorites);
        CursorAdapter adapter = (CursorAdapter) listFavorites.getAdapter();
        adapter.changeCursor( newCursor );
        favoritesCursor = newCursor;
    }

    //  onDestroy()에서 커서와 DB 닫기
    @Override
    public void onDestroy() {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }
}
