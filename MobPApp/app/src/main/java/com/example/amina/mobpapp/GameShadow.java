package com.example.amina.mobpapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class GameShadow extends AppCompatActivity {


    public void onBackPressed() {
        Intent menu= new Intent(GameShadow.this, MainActivity.class );

        startActivity(menu);

        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ImageButton[] wrongButtons = new ImageButton[10];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shadow_layout1);
        wrongButtons[0]=(ImageButton) findViewById(R.id.imageButton9);
        wrongButtons[1]=(ImageButton) findViewById(R.id.shadow2correct);

        for (int i=0; i<2;i++) {

            wrongButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GameShadow.this, popupClass.class));

                }
            });
        }

        final ImageButton true1= (ImageButton) findViewById(R.id.shadow1correct);


        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setContentView(R.layout.shadow_layout2);
                wrongButtons[2]=(ImageButton) findViewById(R.id.imageButton9);
                wrongButtons[3]=(ImageButton) findViewById(R.id.food2correct);

                for (int i=2; i<4;i++)
                {
                    wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {

                            initiatePopupWindow();
                        }
                    });
                }
                final ImageButton true2 = (ImageButton) findViewById(R.id.shadow2correct);
                true2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.shadow_layout3);
                        wrongButtons[4]=(ImageButton) findViewById(R.id.shadow1correct);
                        wrongButtons[5]=(ImageButton) findViewById(R.id.shadow2correct);

                        for (int i=4; i<6;i++)
                        {
                            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View v) {

                                    initiatePopupWindow();
                                }
                            });
                        }
                        final ImageButton true3 = (ImageButton) findViewById(R.id.shadow3correct);
                        true3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                setContentView(R.layout.shadow_layout4);
                                wrongButtons[6]=(ImageButton) findViewById(R.id.imageButton9);
                                wrongButtons[7]=(ImageButton) findViewById(R.id.shadow1correct);
                                for (int i=6; i<8;i++)
                                {
                                    wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {

                                            initiatePopupWindow();
                                        }
                                    });
                                }
                                final ImageButton true4 = (ImageButton) findViewById(R.id.shadow4correct);
                                true4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setContentView(R.layout.shadow_layout5);

                                        wrongButtons[8]=(ImageButton) findViewById(R.id.imageButton9);
                                        wrongButtons[9]=(ImageButton) findViewById(R.id.shadow1correct);

                                        for (int i=8; i<10;i++)
                                        {
                                            wrongButtons[i].setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View v) {

                                                    initiatePopupWindow();
                                                }
                                            });
                                        }
                                        final ImageButton true5 = (ImageButton) findViewById(R.id.shadow5correct);

                                        true5.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v) {
                                                Intent menu= new Intent(GameShadow.this, MainActivity.class );


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
        startActivity(new Intent(GameShadow.this, popupClass.class));
    }

    private View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {
            pwindo.dismiss();

        }
    };


}