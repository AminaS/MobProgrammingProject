package com.example.amina.mobpapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * Created by Amina on 15.12.2016..
 */

public class popupClass extends AppCompatActivity {
    @Override
    protected  void  onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwidow);
        DisplayMetrics dm= new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*0.70), (int)(height*0.40));
    }

}
