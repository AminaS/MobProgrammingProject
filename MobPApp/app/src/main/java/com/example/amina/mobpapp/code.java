package com.example.amina.mobpapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.UUID;



import java.util.Random;

/**
 * Created by Amina on 30.12.2016..
 */

public class code extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass);

        final TextView code= (TextView) findViewById(R.id.textView);

        final StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        boolean alphaType = true;
        int j;

        for(int i = 0; i <= 5; ++i)
        {
            j = (random.nextInt(25) + (alphaType == true ? 65 : 97));
            randomString.append((char)j);
            alphaType = !alphaType;
        }


        code.setText(randomString.toString());

        final EditText input =(EditText) findViewById(R.id.editText);


        Button button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(code.this, Results.class);
                Intent intent2= new Intent(code.this, HomeScreen.class);

                String u = code.getText().toString();
                String p = input.getText().toString();
                if(u.equals( p ))
                    startActivity(intent1);

                else
                    startActivity(intent2);
            }
        });





    }
}
