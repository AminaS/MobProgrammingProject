package com.example.amina.mobpapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        for(int i = 0; i < 3; ++i)
        {
            j = (random.nextInt(10)+1);
            randomString.append(j);
            //alphaType = !alphaType;
        }


        code.setText(randomString.toString());

        final EditText input =(EditText) findViewById(R.id.editText);


        Button button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(code.this, gameResults.class);
                Context context = getApplicationContext();

                String u = code.getText().toString();
                String p = input.getText().toString();
                if(u.equals( p ))
                {
                    Toast t= Toast.makeText(context, "Correct code!", Toast.LENGTH_SHORT);
                    t.show();
                    startActivity(intent1);
                }

                else
                {
                    Toast t= Toast.makeText(context, "Incorrect code!", Toast.LENGTH_SHORT);

                    t.show();
                    finish();
                }

            }
        });





    }
}
