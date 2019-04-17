package ex.android.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        //  OnItemClickListener 생성
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick( AdapterView<?> listView,   //  리스트 뷰
                                     // 사용자가 클릭한 아이템의 뷰, 리스트에서 위치, 관련 데이터의 id
                                     View itemView,
                                     int position,
                                     long id ) {
                if( position == 0) {
                    Intent intent = new Intent( TopLevelActivity.this, DrinkCategoryActivity.class );
                    startActivity( intent );
                }
            }
        };

        //  리스너를 리스트 뷰에 추가
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener( itemClickListener );
    }
}
