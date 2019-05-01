package ex.android.bitsandpizzas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

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

    public void onClickDone( View view ) {
        //  FAB을 클릭하면 실행 되는 코드
        CharSequence text = "Your order has been updated";
        int duration = Snackbar.LENGTH_SHORT;
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration);

        snackbar.setAction("Undo", new View.OnClickListener() {
           @Override
           public void onClick( View view ) {
               //   사용자가 Undo 액션을 클릭하면 실행할 코드
               Toast toast = Toast.makeText(OrderActivity.this, "Undone!", Toast.LENGTH_SHORT);
               toast.show();
           }
        });
        snackbar.show();
    }
}
