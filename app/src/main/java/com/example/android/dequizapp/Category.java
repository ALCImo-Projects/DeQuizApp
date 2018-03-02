package com.example.android.dequizapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {
    //declaring all variables static so other activities can have access to it
    public static int counter=60;
    public static int totalTime=60000;
    public static int TotalQuestion=0;
    public static CountDownTimer mcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        goScienece();
        goComputer();
        goGeneralKnowlege();
    }

    // method to go to Activity1 question Activity

    public void  goScienece(){

        Button bt =(Button) findViewById(R.id.science);
        bt.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){
               Intent intent =new Intent(Category.this,Activity1.class);
                startActivity(intent);

                 mcount =  new CountDownTimer(totalTime,1000){


                    @Override
                    public void onTick(long l) {
                        counter--;

                    }

                    @Override
                    public void onFinish() {


                        Intent intent = new Intent(Category.this, Submit.class);
                        startActivity(intent);
                        finish();


                    }
                };
                mcount.start();


            }

        });
    }



    // Method that starts up General knowledge quiz
    public void goGeneralKnowlege(){



    }


    // method that Starts up computer quiz
    public void goComputer(){



    }
}
