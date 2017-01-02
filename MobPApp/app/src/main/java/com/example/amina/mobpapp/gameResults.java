package com.example.amina.mobpapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.amina.mobpapp.foodGame;

/**
 * Created by Amina on 02.01.2017..
 */

public class gameResults extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.parentfirst);

        ImageButton foodButton =(ImageButton) findViewById(R.id.imageButton);

        ImageButton shadowButton =(ImageButton) findViewById(R.id.imageButton1);

        ImageButton soundButton =(ImageButton) findViewById(R.id.imageButton2);

        final TextView ft = (TextView) findViewById(R.id.ftext);
        final TextView st = (TextView) findViewById(R.id.shadowText);
        final TextView sst = (TextView) findViewById(R.id.soundText);

        foodButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String fC= sharedPreferences.getString("name", "0/5");
                ft.setText(fC);
                /*SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                int fC= sharedPreferences.getInt("food",0);
                proba
                food.setText(fC);*/
            }
        });

        soundButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               // sound.setVisibility(View.VISIBLE);
                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String fC= sharedPreferences.getString("sound", "0/5");
                sst.setText(fC);

            }
        });

        shadowButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //shadow.setVisibility(View.VISIBLE);
                SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String fC= sharedPreferences.getString("shadow", "0/5");
                st.setText(fC);


            }
        });
    }
}
