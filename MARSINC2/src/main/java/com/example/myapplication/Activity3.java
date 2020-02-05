package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.sql.*;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.lang.System.out;

public class Activity3 extends AppCompatActivity {//OBSOLETE CODE IGNORE THIS WHOLE JAVA FILE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("More");

        class MysqlCon {

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@apollo.humber.ca:1521:msit","n01227056", "v"); // connecting to apollo
            Statement stmt = conn.createStatement(); // connection statment if connects properly
            ResultSet rs = stmt.executeQuery("SELECT * FROM medri.people"); // resultset of the table when calling all from the medri.people as a test

            MysqlCon() throws SQLException {
            }
        }

        Button but = (Button)findViewById(R.id.butt);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Intent.ACTION_VIEW, Uri.parse("http://apollo.humber.ca/~n01227056/MARSINC.html"));
                startActivity(i2);
            }

        });

        Button but2 = (Button)findViewById(R.id.butt2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.theweathernetwork.com/ca/hourly-weather-forecast/ontario/toronto"));
                startActivity(i3);
            }
        });
    }
//OBSOLETE CODE IGNORE THIS WHOLE JAVA FILE
}
