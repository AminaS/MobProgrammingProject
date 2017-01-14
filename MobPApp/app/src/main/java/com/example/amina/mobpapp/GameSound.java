package com.example.amina.mobpapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;


public class GameSound extends AppCompatActivity {
    MediaPlayer sound;
    public static int soundCorrect=0;

    String mystring="";

    public void onBackPressed() {
        Intent menu= new Intent(GameSound.this, MainActivity.class );
        startActivity(menu);

        super.onBackPressed();
    }
    final Button[] wrongButtons = new Button[15];
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1_layout);
        mystring="0/5";
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("sound", mystring);
        editor.commit();
        wrongButtons[0]=(Button) findViewById(R.id.horseButton7);
        wrongButtons[1]=(Button) findViewById(R.id.birdButton7);
        wrongButtons[2]=(Button) findViewById(R.id.frogButton7);

        incorrect(0,3);

        sound(R.raw.cow);

        final Button true1= (Button) findViewById(R.id.cowButton7);
        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundCorrect++;

                setContentView(R.layout.sound_layout2);
                sound.stop();
                sound(R.raw.cardinal);
                wrongButtons[3]=(Button) findViewById(R.id.sound2incorrect1);
                wrongButtons[4]=(Button) findViewById(R.id.sound2incorrect2);
                wrongButtons[5]=(Button) findViewById(R.id.sound2incorrect3);
                incorrect(3,6);
                final Button true2 = (Button) findViewById(R.id.sound2correct);
                true2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        soundCorrect++;
                        sound.stop();
                        setContentView(R.layout.sound_layout3);
                        sound(R.raw.dolphins);
                        wrongButtons[6]=(Button) findViewById(R.id.sound3incorrect1);
                        wrongButtons[7]=(Button) findViewById(R.id.sound3incorrect2);
                        wrongButtons[8]=(Button) findViewById(R.id.sound3incorrect3);
                        incorrect(6,9);
                        final Button true3 = (Button) findViewById(R.id.sound3correct);
                        true3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                soundCorrect++;
                                sound.stop();
                                setContentView(R.layout.sound_layout4);
                                sound(R.raw.parrot);
                                wrongButtons[9]=(Button) findViewById(R.id.sound4incorrect1);
                                wrongButtons[10]=(Button) findViewById(R.id.sound4incorrect2);
                                wrongButtons[11]=(Button) findViewById(R.id.sound4incorrect3);
                                incorrect(9,12);
                                final Button true4 = (Button) findViewById(R.id.sound4correct);
                                true4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        soundCorrect++;
                                        sound.stop();
                                        setContentView(R.layout.sound_layout5);
                                        sound(R.raw.dachshundb);
                                        wrongButtons[12]=(Button) findViewById(R.id.sound5incorrect1);
                                        wrongButtons[13]=(Button) findViewById(R.id.sound5incorrect2);
                                        wrongButtons[14]=(Button) findViewById(R.id.sound5incorrect3);
                                        incorrect(12,15);
                                        final Button true5 = (Button) findViewById(R.id.sound5correct);

                                        true5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                soundCorrect++;
                                                getResult();
                                                if(soundCorrect==5){mystring="5/5";

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

                                                            .setContentText("Your kid did 5/5 correct in sound game!")
                                                            .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                                                            .setContentIntent(contentIntent);


                                                    NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                                    notificationManager.notify(1, b.build());

                                                }

                                                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                                editor.putString("sound", mystring);
                                                editor.commit();

                                               sound.stop();

                                                Intent menu= new Intent(GameSound.this, MainActivity.class );

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
int length;
    public void onPause() {
        super.onPause();
        //sound.stop();
        sound.pause();
        length = sound.getCurrentPosition();


    }

   public void onResume() {
        super.onResume();
        sound.seekTo(length);
        sound.start();

    }

    void sound(int source)
    {
        sound = MediaPlayer.create(GameSound.this, source);
        sound.start();
        sound.setLooping(true);
    }
    public void incorrect(int i, int imax)
    {
        for (i=i; i<imax;i++)
        {
            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    soundCorrect=soundCorrect-2;
                    initiatePopupWindow();
                }
            });
        }
    }
    void getResult()
    {
        if(soundCorrect==0){mystring="0/5";}
        if(soundCorrect==1){mystring="1/5";}
        if(soundCorrect==2){mystring="2/5";}
        if(soundCorrect==3){mystring="3/5";}
        if(soundCorrect==4){mystring="4/5";}
    }
}



