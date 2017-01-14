package com.example.amina.mobpapp;

import android.app.Application;
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

public class foodGame extends AppCompatActivity {
    public  static int foodCorrect=0;
    String mystring="";

    public void onBackPressed() {
        this.finish();
        Intent menu= new Intent(foodGame.this, MainActivity.class );

        startActivity(menu);

        super.onBackPressed();
    }

    final Button[] wrongButtons = new Button[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout1);
        mystring="0/5";
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name", mystring);
        editor.commit();
        wrongButtons[0]=(Button) findViewById(R.id.imageButton9);
        wrongButtons[1]=(Button) findViewById(R.id.imageButton11);
        incorrect(0,2);
        final Button true1= (Button) findViewById(R.id.food1correct);


        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodCorrect++;
                setContentView(R.layout.food_layout2);
                wrongButtons[2]=(Button) findViewById(R.id.imageButton9);
                wrongButtons[3]=(Button) findViewById(R.id.buttonp);
                incorrect(2,4);
                final Button true2 = (Button) findViewById(R.id.food2correct);

                true2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        foodCorrect++;
                        setContentView(R.layout.food_layout3);
                        wrongButtons[4]=(Button) findViewById(R.id.imageButton9);
                        wrongButtons[5]=(Button) findViewById(R.id.button);
                        incorrect(4,6);
                        final Button true3 = (Button) findViewById(R.id.food3correct);

                        true3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                foodCorrect++;
                                setContentView(R.layout.food_layout4);
                                wrongButtons[6]=(Button) findViewById(R.id.imageButton9);
                                wrongButtons[7]=(Button) findViewById(R.id.button);
                                incorrect(6,8);
                                final Button true4 = (Button) findViewById(R.id.food4correct);

                                true4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setContentView(R.layout.food_layout5);
                                        foodCorrect++;
                                        wrongButtons[8]=(Button) findViewById(R.id.imageButton9);
                                        wrongButtons[9]=(Button) findViewById(R.id.apple);
                                        incorrect(8,10);
                                        final Button true5 = (Button) findViewById(R.id.food5correct);
                                        true5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                foodCorrect++;
                                                getResult();
                                                if(foodCorrect==5){mystring="5/5";
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

                                                            .setContentText("Your kid did 5/5 correct in food game!")
                                                            .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                                                            .setContentIntent(contentIntent);


                                                    NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                                                    notificationManager.notify(1, b.build());

                                                }

                                                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                                editor.putString("name", mystring);
                                                editor.commit();

                                                Intent menu= new Intent(foodGame.this, MainActivity.class );
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

    public void onPause() {
        super.onPause();



    }

    public void onResume() {
        super.onResume();


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
                    foodCorrect=foodCorrect-2;
                    initiatePopupWindow();
                }
            });
        }
    }


    void getResult()
    {
        if(foodCorrect==0){mystring="0/5";}
        if(foodCorrect==1){mystring="1/5";}
        if(foodCorrect==2){mystring="2/5";}
        if(foodCorrect==3){mystring="3/5";}
        if(foodCorrect==4){mystring="4/5";}
    }
};