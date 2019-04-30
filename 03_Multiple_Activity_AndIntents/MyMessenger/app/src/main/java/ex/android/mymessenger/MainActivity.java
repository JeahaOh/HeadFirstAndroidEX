package ex.android.mymessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSendMessage( View view ) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        //  명시적 인텐트를 사용
//        Intent intent = new Intent( this, RecieveMessageActivity.class);
//        intent.putExtra( RecieveMessageActivity.EXTRA_MESSAGE, messageText );

        //  암시적 인텐트를 사용
        //  어떤 종류의 액션은 수행할지 요청만 할 뿐 어떤 액티비티를 실행할 지는 안드로이드 운영체제에 맡김.
        //  ACTION_SEND 액션을 지정하고 MIME 유형을 text/plain으로 지정함.
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra( Intent.EXTRA_TEXT, messageText );
//        startActivity( intent );

        //  항상 특정한 액티비티를 사용하는 옵션은 제공하지 않기.
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity( chosenIntent );
    }
}
