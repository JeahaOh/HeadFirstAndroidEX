package ex.android.joke;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.app.NotificationManager;

public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "MSG";
    public static final int NOTIFICATION_ID = 1020;

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent( Intent intent ) {
        synchronized ( this ) {
            try{
                wait(5000 );
            }   catch( InterruptedException e ) {
                e.printStackTrace();;
            }
        }
        String text = intent.getStringExtra( EXTRA_MESSAGE );
        showText( text );
    }

    private void showText( final String text ) {
        Log.v("DelayedMessageService", "The Message Is : " + text );


        //  일림 보내기
        NotificationManager notificationManager =
                (NotificationManager) getSystemService( NOTIFICATION_SERVICE );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder( this );

        //  Android Version 8.0 오레오 이상이라면 NotificationChannel 을 잡아줘야함.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannelGroup group =
                    new NotificationChannelGroup("channel_group_id", "channel_group_name");
            notificationManager.createNotificationChannelGroup( group );

            NotificationChannel notificationChannel =
                    new NotificationChannel( "channel_id", "channel_name",
                                            NotificationManager.IMPORTANCE_DEFAULT );

            notificationChannel.setDescription( "channel description" );
            notificationChannel.setGroup( "channel_group_id" );
            notificationChannel.enableLights( true );
            notificationChannel.setLightColor( Color.GREEN );
            notificationChannel.enableVibration( true );
            notificationChannel.setVibrationPattern( new long[] {100, 200, 100, 200} );
            notificationChannel.setLockscreenVisibility( Notification.VISIBILITY_PRIVATE );
            notificationManager.createNotificationChannel( notificationChannel );

            builder.setChannelId( notificationChannel.getId() );
        }

        builder.setSmallIcon( android.R.drawable.sym_def_app_icon )
            .setContentTitle( getString( R.string.question ) )
            .setContentText( text )
            .setPriority( NotificationCompat.PRIORITY_HIGH )
            .setVibrate( new long[] { 0, 10000 } )
            .setAutoCancel( true );

        //  액션 설정
        Intent actionIntent = new Intent( this, MainActivity.class );
        PendingIntent actionPendingIntent = PendingIntent.getActivity( this, 0,
                                            actionIntent, PendingIntent.FLAG_UPDATE_CURRENT );

        builder.setContentIntent( actionPendingIntent );

        notificationManager.notify( NOTIFICATION_ID, builder.build() );
    }
}
