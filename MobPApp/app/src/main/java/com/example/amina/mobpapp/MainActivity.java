package com.example.amina.mobpapp;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {





        HomeScreen home = new HomeScreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        final Button menu1= (Button) findViewById(R.id.button2);
        final Button menu3= (Button) findViewById(R.id.button3);
        final Button menu2= (Button) findViewById(R.id.button1);
        final Button menu4 = (Button) findViewById(R.id.button4);


        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent menu= new Intent(MainActivity.this, GameSound.class );

                startActivity(menu);
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent menu1= new Intent(MainActivity.this, GameShadow.class );

                startActivity(menu1);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent menu2= new Intent(MainActivity.this, foodGame.class );

                startActivity(menu2);
            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                finish();
                Intent menu4= new Intent(MainActivity.this, code.class );

                startActivity(menu4);



            }
        });

    }

}