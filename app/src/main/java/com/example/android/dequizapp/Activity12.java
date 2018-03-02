package com.example.android.dequizapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.android.dequizapp.Activity1.gotIt;
import static com.example.android.dequizapp.Category.TotalQuestion;
import static com.example.android.dequizapp.Category.counter;
import static com.example.android.dequizapp.Category.mcount;
import static com.example.android.dequizapp.Category.totalTime;

public class Activity12 extends AppCompatActivity {
    int newCounter = counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity12);
        TotalQuestion++;

        //On loading Activity checks total question to cancel timer
        if(TotalQuestion>=10){
            Intent intent = new Intent(Activity12.this, Submit.class);
            startActivity(intent);
            finish();
            mcount.cancel();
        }
        showTimer();
        Submit();
    }

    public void Submit() {


        Button bt = (Button) findViewById(R.id.nextid);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random generator = new Random();
                int number = generator.nextInt(20);
                // The '20' is the number of activities
                Class activity = null;

                // Here, we are checking to see what the output of the random was
                switch(number) {
                    case 1:
                        // E.g., if the output is 1, the activity we will open is ActivityOne.class
                        activity = Activity1.class;
                        break;
                    case 2:
                        activity = Activity2.class;
                        break;
                    case 3:
                        activity = Activity3.class;
                        break;
                    case 4:
                        activity = Activity4.class;
                        break;
                    case 5:
                        activity = Activity5.class;
                        break;
                    case 6:
                        activity = Activity6.class;
                        break;
                    case 7:
                        activity = Activity7.class;
                        break;
                    case 8:
                        activity = Activity8.class;
                        break;
                    case 9:
                        activity = Activity9.class;
                        break;
                    case 10:
                        activity = Activity10.class;
                        break;
                    case 11:
                        activity = Activity11.class;
                        break;
                    case 13:
                        activity = Activity13.class;
                        break;
                    case 14:
                        activity = Activity14.class;
                        break;
                    case 15:
                        activity = Activity15.class;
                        break;
                    case 16:
                        activity = Activity16.class;
                        break;
                    case 17:
                        activity = Activity17.class;
                        break;
                    case 18:
                        activity = Activity18.class;
                        break;
                    case 20:
                        activity = Activity20.class;
                        break;

                    default:
                        activity = Activity19.class;
                        break;
                }
                isAnswer();
                // We use intents to start activities
                Intent intent = new Intent(getBaseContext(), activity);
                startActivity(intent);


            }
        });

    }

    public void isAnswer(){

        RadioButton rb = (RadioButton)findViewById(R.id.radio4);
        if(rb.isChecked()){
            gotIt=gotIt+1;
            Toast toast = new Toast(Activity12.this);
            View view1 =getLayoutInflater().inflate(R.layout.correct4,(ViewGroup)findViewById(R.id.toastView));
            toast.setView(view1);
            toast.show();
            toast.setDuration(Toast.LENGTH_SHORT);

        }else{
            gotIt = gotIt + 0;

            Toast toast = new Toast(Activity12.this);
            View view1 =getLayoutInflater().inflate(R.layout.fail2,(ViewGroup)findViewById(R.id.toastView));
            toast.setView(view1);
            toast.show();
            toast.setDuration(Toast.LENGTH_SHORT);
        }

    }

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Activity12.this,MainActivity.class);
        startActivity(intent);
        finish();
        gotIt =0;
        TotalQuestion=0;
        totalTime = 60000;
        counter=60;
        mcount.cancel();
    }

    //method controls timer
    public void showTimer(){

        new CountDownTimer(totalTime,1000){


            @Override
            public void onTick(long l) {
                TextView tv = (TextView)findViewById(R.id.timer12);
                tv.setText(String.valueOf(newCounter));
                newCounter--;


            }

            @Override
            public void onFinish() {

            }
        }.start();



    }
}
//ANSWER  RADIO 4 BUTTON
