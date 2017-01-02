package com.example.amina.mobpapp;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HomeScreen home = new HomeScreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        final ImageButton menu1= (ImageButton) findViewById(R.id.button2);
        final ImageButton menu3= (ImageButton) findViewById(R.id.button3);
        final ImageButton menu2= (ImageButton) findViewById(R.id.button1);
        final ImageButton menu4 = (ImageButton) findViewById(R.id.button4);


        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(MainActivity.this, GameSound.class );

                startActivity(menu);
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu1= new Intent(MainActivity.this, GameShadow.class );

                startActivity(menu1);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu2= new Intent(MainActivity.this, foodGame.class );

                startActivity(menu2);
            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //finish();

            }
        });

    }

}
