package com.nao20010128nao.RC_ON;

import android.app.*;
import android.os.*;
import android.view.View;
import android.widget.EditText;
import java.security.SecureRandom;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat;
import android.content.Intent;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		findViewById(R.id.start).setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				EditText et=(EditText)findViewById(R.id.mes);
				NotificationCompat.Builder nb=new NotificationCompat.Builder(MainActivity.this)
					.setContentTitle("おしゃべりマルチ")
					.setContentText(et.getText().toString())
					.setContentIntent(PendingIntent.getActivity(MainActivity.this,0,new Intent(MainActivity.this,MainActivity.class),0))
					.setSmallIcon(R.drawable.app_icon);
				((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).notify(Math.abs(new SecureRandom().nextInt()),nb.build());
			}
		});
    }
}
