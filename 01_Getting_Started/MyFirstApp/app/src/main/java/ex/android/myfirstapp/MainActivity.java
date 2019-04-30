package ex.android.myfirstapp;
//  패키지 이름

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//  MainActivity에서 사용하는 안드로이드 클래스

public class MainActivity extends AppCompatActivity {
//  android.app.Activity라는 안드로이드 클래스를 상속함.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  Activity 클래스의 onCreate() 메소드를 구현.
        //  액티미티가 처음 생성되면 호출하는 메소드.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  어떤 레이아웃을 사용할지 지정함.
    }
}
