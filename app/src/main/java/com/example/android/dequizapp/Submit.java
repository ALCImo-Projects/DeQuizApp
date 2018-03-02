package com.example.android.dequizapp;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.dequizapp.Category.TotalQuestion;
import static com.example.android.dequizapp.Category.counter;
import static com.example.android.dequizapp.Category.totalTime;
import static com.example.android.dequizapp.MainActivity.User_name;
import static com.example.android.dequizapp.Activity1.gotIt;
import static com.example.android.dequizapp.MainActivity.selectedImage;

public class Submit extends AppCompatActivity {
    String score;
    public static  final String FACEBOOK_MESSENGER_PACKAGE = "com.facebook.orca";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        //Sets user image from mainActivity
        ImageView im = (ImageView)findViewById(R.id.imageSubmit);
        im.setImageBitmap(selectedImage);

        displayUserScore();
        Send_to_Email();
        Send_to_EmailS();
        Replay();
       // Share_on_Facebook();
    }

    //Method Displays User Score
    public void displayUserScore(){
        TextView textView = (TextView)findViewById(R.id.userScore);
         score =  User_name + "," + " You Scored " + gotIt + " out of " + 10 + " Questions";
        textView.setText(score);

    }

//Method to send Result to email
    public void Send_to_Email(){
        Button bt =(Button) findViewById(R.id.emailBt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT," Quiz Score for " + User_name);
                intent.putExtra(Intent.EXTRA_TEXT,score);
                if(intent.resolveActivity(getPackageManager()) !=null){

                    startActivity(intent);

                }
               /*Log.v("Submit.this","yes am seeinn");*/

            }



        });


    }

    //Method to send Result to email where share image is clicked
    public void Send_to_EmailS(){
        ImageView im =(ImageView) findViewById(R.id.share);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT," Quiz Score for " + User_name);
                intent.putExtra(Intent.EXTRA_TEXT,score);
                if(intent.resolveActivity(getPackageManager()) !=null){

                    startActivity(intent);

                }
               /*Log.v("Submit.this","yes am seeinn");*/

            }



        });


    }

    //Method to share result on facebook
/*
    public void Share_on_Facebook(){

        Button bt = (Button)findViewById(R.id.facebookId);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hi friends check out my score on DeQuizApp" + score);


                try {
                    intent.setComponent(new ComponentName("com.facebook.katana",
                        "com.facebook.composer.shareintent.ImplicitShareIntentHandler"));

                    startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(),"Please install facebook messenger.",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
*/

      public void Replay(){

          Button bt = (Button)findViewById(R.id.replay);
          bt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(Submit.this,MainActivity.class);
                  startActivity(intent);
                  finish();
                  gotIt =0;
                  TotalQuestion=0;
                  totalTime = 60000;
                  counter=60;
              }
          });
      }


    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Submit.this,MainActivity.class);
        startActivity(intent);
       finish();
        gotIt =0;
        TotalQuestion=0;
        totalTime = 60000;
        counter=60;
    }
}
