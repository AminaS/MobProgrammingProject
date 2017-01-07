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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;


public class GameSound extends AppCompatActivity {
    MediaPlayer cowSound;
    MediaPlayer cardinalSound;
    MediaPlayer dolphinSound;
    MediaPlayer parrotSound;
    MediaPlayer dachshundSound;
    public static int soundCorrect=0;

    String amina="";

    public void onBackPressed() {
        Intent menu= new Intent(GameSound.this, MainActivity.class );
        /*if(cowSound.isPlaying())
        cowSound.stop();
        if(cardinalSound.isPlaying())
        cardinalSound.stop();
        if(dolphinSound.isPlaying())
        dolphinSound.stop();
        if(parrotSound.isPlaying())
            parrotSound.stop();
        if(dachshundSound.isPlaying())
            dachshundSound.stop();*/
        startActivity(menu);

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final ImageButton[] wrongButtons = new ImageButton[15];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1_layout);
        amina="0/5";
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("sound", amina);
        editor.commit();
        wrongButtons[0]=(ImageButton) findViewById(R.id.horseButton7);
        wrongButtons[1]=(ImageButton) findViewById(R.id.birdButton7);
        wrongButtons[2]=(ImageButton) findViewById(R.id.frogButton7);

        for (int i=0; i<3;i++) {

            wrongButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    soundCorrect=soundCorrect-2;
                    //startActivity(new Intent(GameSound.this, popupClass.class));
                    initiatePopupWindow();

                }
            });
        }

        cowSound = MediaPlayer.create(this, R.raw.cow);

        cowSound.start();
        cowSound.setLooping(true);

        final ImageButton true1= (ImageButton) findViewById(R.id.cowButton7);
        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundCorrect++;

                setContentView(R.layout.sound_layout2);
                cowSound.stop();
                cardinalSound = MediaPlayer.create(GameSound.this, R.raw.cardinal);
                cardinalSound.start();
                cardinalSound.setLooping(true);
                wrongButtons[3]=(ImageButton) findViewById(R.id.sound2incorrect1);
                wrongButtons[4]=(ImageButton) findViewById(R.id.sound2incorrect2);
                wrongButtons[5]=(ImageButton) findViewById(R.id.sound2incorrect3);
                for (int i=3; i<6;i++)
                {
                    wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            soundCorrect=soundCorrect-2;
                            initiatePopupWindow();
                        }
                    });
                }
                final ImageButton true2 = (ImageButton) findViewById(R.id.sound2correct);
                true2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        soundCorrect++;
                        cardinalSound.stop();
                        setContentView(R.layout.sound_layout3);
                        dolphinSound = MediaPlayer.create(GameSound.this, R.raw.dolphins);
                        dolphinSound.start();
                        dolphinSound.setLooping(true);
                        wrongButtons[6]=(ImageButton) findViewById(R.id.sound3incorrect1);
                        wrongButtons[7]=(ImageButton) findViewById(R.id.sound3incorrect2);
                        wrongButtons[8]=(ImageButton) findViewById(R.id.sound3incorrect3);
                        for (int i=6; i<9;i++)
                        {
                            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {
                                    soundCorrect=soundCorrect-2;
                                    initiatePopupWindow();
                                }
                            });
                        }
                        final ImageButton true3 = (ImageButton) findViewById(R.id.sound3correct);
                        true3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                soundCorrect++;
                                dolphinSound.stop();
                                setContentView(R.layout.sound_layout4);
                                parrotSound = MediaPlayer.create(GameSound.this, R.raw.parrot);
                                parrotSound.start();
                                parrotSound.setLooping(true);
                                wrongButtons[9]=(ImageButton) findViewById(R.id.sound4incorrect1);
                                wrongButtons[10]=(ImageButton) findViewById(R.id.sound4incorrect2);
                                wrongButtons[11]=(ImageButton) findViewById(R.id.sound4incorrect3);
                                for (int i=9; i<12;i++)
                                {
                                    wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {
                                            soundCorrect=soundCorrect-2;
                                            initiatePopupWindow();
                                        }
                                    });
                                }
                                final ImageButton true4 = (ImageButton) findViewById(R.id.sound4correct);
                                true4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        soundCorrect++;
                                        parrotSound.stop();
                                        setContentView(R.layout.sound_layout5);
                                        dachshundSound = MediaPlayer.create(GameSound.this, R.raw.dachshundb);
                                        dachshundSound.start();
                                        dachshundSound.setLooping(true);
                                        wrongButtons[12]=(ImageButton) findViewById(R.id.sound5incorrect1);
                                        wrongButtons[13]=(ImageButton) findViewById(R.id.sound5incorrect2);
                                        wrongButtons[14]=(ImageButton) findViewById(R.id.sound5incorrect3);

                                        for (int i=12; i<15;i++)
                                        {
                                            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View v) {
                                                    soundCorrect=soundCorrect-2;
                                                    initiatePopupWindow();
                                                }
                                            });
                                        }
                                        final ImageButton true5 = (ImageButton) findViewById(R.id.sound5correct);

                                        true5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                soundCorrect++;
                                                if(soundCorrect==0){amina="0/5";}
                                                if(soundCorrect==1){amina="1/5";}
                                                if(soundCorrect==2){amina="2/5";}
                                                if(soundCorrect==3){amina="3/5";}
                                                if(soundCorrect==4){amina="4/5";}
                                                if(soundCorrect==5){amina="5/5";

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

                                                            .setContentText("Your kid did 5/5 in sound game!")
                                                            .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                                                            .setContentIntent(contentIntent);


                                                    NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                                    notificationManager.notify(1, b.build());

                                                }

                                                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                                editor.putString("sound", amina);
                                                editor.commit();

                                                dachshundSound.stop();
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


}



