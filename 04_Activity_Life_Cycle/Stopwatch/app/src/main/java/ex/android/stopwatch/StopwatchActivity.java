package ex.android.stopwatch;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopwatchActivity extends Activity {

    //  지금 까지 흐른 시간
    private int seconds = 0;
    //  스톱워치의 실행 여부
    private boolean running;
    //  onStop()을 호출하기 전에 스톱워치가 실행중인지 알 수 있도록 하는 변수
    //  Activity가 다시 보였을 때 스톱워치 상태를 실행 상태로 설정할지 확인하는데 사용함
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //  액티비티가 종료되고 다시 생성 됬다면 기존으 시트보워치 상태를 가져옴
        if( savedInstanceState != null ) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    //  Start 버튼을 클릭하면 스툡워치 작동
    public void onClickStart( View view ) {
        running = true;
    }

    //  Stop 버튼을 클릭하면 스톱워치 정지
    public void onClickStop( View view ) {
        running = false;
    }

    //  스톱워치 재설정
    public void onClickReset( View view ) {
        running = false;
        seconds = 0;
    }

    /**
     * Handler에 1초의 지연을 이용해 주기적으로 모드를 실행하고 스톱워치를 갱신함.
     * 코드를 실행할 때마다 seconds의 변수를 증가시키고 textView를 갱신함.
     */
    private void runTimer() {
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post( new Runnable() {

            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format( Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs );
                timeView.setText( time );

                if( running ) {
                    seconds++;
                }
                handler.postDelayed( this, 1000 );
            }
        });
    }

    //  액티비티가 종료 되기 전에 스톱워치의 상태를 저장함
    @Override
    public void onSaveInstanceState( Bundle savedInstanceState ) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }

/*
    //  스톱워치가 실행중이었다면 스톱워치를 다시 실행하도록 함
    @Override
    protected void onStart() {
        super.onStart();
        if( wasRunning ) {
            running = true;
        }
    }
*/
    //  액티비티가 정지되면 스톱워치를 정지함
    @Override
    protected void onResume() {
        super.onResume();
        if( wasRunning ) {
            running = true;
        }
    }
/*
    //  화면이 보이지 않게될 떄 스톱워치가 실행중이였는지 저장
    @Override
    public void onStop() {
        super.onStop();
        wasRunning = running;
        running = false;
    }
*/
    //  액티비티가 재개될 때 기본에 스톱워치가 실행 중이었다면 스톱워치를 다시 시작함
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }
}
