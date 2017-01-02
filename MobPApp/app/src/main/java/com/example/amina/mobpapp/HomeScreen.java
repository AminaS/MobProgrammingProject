package com.example.amina.mobpapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {

    MediaPlayer homeSong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        final ImageButton parent = (ImageButton) findViewById(R.id.parentButton);
        homeSong = MediaPlayer.create(this, R.raw.oldmacdonald);
        homeSong.setVolume(1f, 1f);
        homeSong.start();
        homeSong.setLooping(true);
        final ImageButton playbutton= (ImageButton) findViewById(R.id.playbutton);

        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(HomeScreen.this, MainActivity.class );

                homeSong.setVolume(0.5f, 0.5f);
                startActivity(menu);
            }
        });


        parent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent menu4= new Intent(HomeScreen.this, code.class );

                startActivity(menu4);

            }
        });

        RotateAnimation rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        rotate.setDuration(4000);
        rotate.setRepeatCount(Animation.INFINITE);
        playbutton.setAnimation(rotate);



    }
}

