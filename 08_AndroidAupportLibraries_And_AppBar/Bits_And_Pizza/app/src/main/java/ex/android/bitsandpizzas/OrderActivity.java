package ex.android.bitsandpizzas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar( toolbar );

        //  지원 라리브러리에서 제공하는 툴바를 이용하므로 getSupportActionBar()
        ActionBar actionBar = getSupportActionBar();
        //  Up 버튼을 활성화하는 코드. AppBar에 ToolBar를 추가했지만 Up 버튼을 활성화할 때는 ActionBar의 메소드를 사용함.
        actionBar.setDisplayHomeAsUpEnabled( true );

    }
}
