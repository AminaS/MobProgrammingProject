package com.example.amina.mobpapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Toast;

public class GameShadow extends AppCompatActivity {
    public static int shadowCorrect=0;
    String mystring="";

    public void onBackPressed() {
        Intent menu= new Intent(GameShadow.this, MainActivity.class );

        startActivity(menu);

        super.onBackPressed();
    }
    final Button[] wrongButtons = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shadow_layout1);
        mystring="0/5";
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("shadow", mystring);
        editor.commit();
        wrongButtons[0]=(Button) findViewById(R.id.imageButton9);
        wrongButtons[1]=(Button) findViewById(R.id.shadow2correct);
        incorrect(0,2);

        final Button true1= (Button) findViewById(R.id.shadow1correct);


        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shadowCorrect++;

                setContentView(R.layout.shadow_layout2);
                wrongButtons[2]=(Button) findViewById(R.id.imageButton9);
                wrongButtons[3]=(Button) findViewById(R.id.food2correct);
                incorrect(2,4);
                final Button true2 = (Button) findViewById(R.id.shadow2correct);
                true2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        shadowCorrect++;
                        setContentView(R.layout.shadow_layout3);
                        wrongButtons[4]=(Button) findViewById(R.id.shadow1correct);
                        wrongButtons[5]=(Button) findViewById(R.id.shadow2correct);
                        incorrect(4,6);
                        final Button true3 = (Button) findViewById(R.id.shadow3correct);
                        true3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                shadowCorrect=shadowCorrect-2;

                                setContentView(R.layout.shadow_layout4);
                                wrongButtons[6]=(Button) findViewById(R.id.imageButton9);
                                wrongButtons[7]=(Button) findViewById(R.id.shadow1correct);
                                incorrect(6,8);
                                final Button true4 = (Button) findViewById(R.id.shadow4correct);
                                true4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        shadowCorrect++;
                                        setContentView(R.layout.shadow_layout5);

                                        wrongButtons[8]=(Button) findViewById(R.id.imageButton9);
                                        wrongButtons[9]=(Button) findViewById(R.id.shadow1correct);
                                        incorrect(8,10);
                                        final Button true5 = (Button) findViewById(R.id.shadow5correct);

                                        true5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                shadowCorrect++;
                                                getResult();
                                                if(shadowCorrect==5){mystring="5/5";

                                                    Context ctx = getApplicationContext();
                                                    Intent intent = new Intent(ctx, foodGame.class);
                                                    PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                                                    NotificationCompat.Builder b = new NotificationCompat.Builder(ctx);

                                                    b.setAutoCancel(true)
                                                            .setDefaults(Notification.DEFAULT_ALL)
                                                            .setWhen(System.currentTimeMillis())
                                                            .setSmallIcon(R.drawable.kliklogo)
                                                            .setTicker("Klik Entertainment")
                                                            .setContentTitle("Klik Entertainment")

                                                            .setContentText("Your kid did 5/5 correct in shadow game!")
                                                            .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                                                            .setContentIntent(contentIntent);


                                                    NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                                    notificationManager.notify(1, b.build());
                                                }

                                                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                                editor.putString("shadow", mystring);
                                                editor.commit();
                                                Intent menu= new Intent(GameShadow.this, MainActivity.class );

                                                startActivity(menu);
                                            }
                                        });
                                    }
                                });//true4
                            }
                        });//true3
                    }
                });//true2
            }
        });//true1
    }

    private PopupWindow pwindo;

    private void initiatePopupWindow() {
        final LayoutInflater inflater = getLayoutInflater();

        final View layout = inflater.inflate(R.layout.customtoast,
                (ViewGroup) findViewById(R.id.custom_toast_layout_id));
        final Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        //toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);

    }

    public void incorrect(int i, int imax)
    {
        for (i=i; i<imax;i++)
        {
            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    shadowCorrect=shadowCorrect-2;
                    initiatePopupWindow();
                }
            });
        }
    }
    public void onPause() {
        super.onPause();
        //homeSong.pause();
        //length = homeSong.getCurrentPosition();


    }

    public void onResume() {
        super.onResume();
        //homeSong.seekTo(length);
        //homeSong.start();
    }
    void getResult()
    {
        if(shadowCorrect==0){mystring="0/5";}
        if(shadowCorrect==1){mystring="1/5";}
        if(shadowCorrect==2){mystring="2/5";}
        if(shadowCorrect==3){mystring="3/5";}
        if(shadowCorrect==4){mystring="4/5";}
    }
}