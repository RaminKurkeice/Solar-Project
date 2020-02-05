package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {//OBSOLETE CODE IGNORE THIS WHOLE JAVA FILE

    TextView countdownText;
    ImageButton imageButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 1800000 ; // equals to 30 mins
    private boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Readings");

        Calendar calendar = Calendar.getInstance();                                     // Matthews code
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText(currentDate);

        countdownText = findViewById(R.id.countdown_text);
        startStop();
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.imageButton3);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                openActivity();

            }

        });

    }


    public void startStop(){
        if (timerRunning){
            stopTimer();
        }
        else{
            startTimer();
        }
    }
    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timerRunning = true;
    }
    public void stopTimer(){
        startTimer();
    }

    public void updateTimer(){
        int min = (int) (timeLeftInMilliseconds / 60000) ;
        int sec = (int) (timeLeftInMilliseconds % 60000 / 1000);

        String timeLeftText;

        timeLeftText = "" + min;
        timeLeftText += ":";
        if (sec < 10) timeLeftText += "0";
        timeLeftText += sec;
        countdownText.setText(timeLeftText);
    }



    public void openActivity(){
     //   Intent intent = new Intent(this,PowerHistory.class);
       // startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }//OBSOLETE CODE IGNORE THIS WHOLE JAVA FILE

}