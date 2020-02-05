package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.location.LocationListener;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;

import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private Button button;
    private Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {//MARS INC
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState==null) {//MARS INC
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SerialNumber()).commit();
            navigationView.setCheckedItem(R.id.nav_serial);
        }


        SharedPreferences pref = Objects.requireNonNull(MainActivity.this).getPreferences(Context.MODE_PRIVATE);
        int textSize = pref.getInt("font",1);
        if(textSize == 0){
          setTheme(R.style.AppTheme12);
        }else if (textSize == 1){
            setTheme(R.style.AppTheme13);
        }else if (textSize == 2){
            setTheme(R.style.AppTheme14);

        }
        boolean isSwitched = pref.getBoolean("switch",false);
        if(isSwitched){
           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        }


    }








    public boolean onCreateOptionsMenu(Menu menu) {//MARS INC
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//MARS INC
        boolean b = true;
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://raminkurkeice.github.io/Software-Project/"));
                startActivity(intent);
                return b;
            case R.id.item2:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://raminkurkeice.github.io/Software-Project/CODE_OF_CONDUCT"));
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {//MARS INC
        switch(menuItem.getItemId()){
            case R.id.nav_serial:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new SerialNumber()).commit();
                break;
            case R.id.nav_Weather:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Weather()).commit();
                break;
            case R.id.nav_readings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Readings()).commit();
                break;
            case R.id.nav_Graph:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Graph()).commit();
                break;
            case R.id.nav_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new History()).commit();
                break;
            case R.id.nav_blog:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://raminkurkeice.github.io/Software-Project/"));
                startActivity(intent);
                return true;
            case R.id.nav_code:
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://raminkurkeice.github.io/Software-Project/CODE_OF_CONDUCT"));
                startActivity(intent2);
                return true;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onBackPressed() {//MARS INC
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {//MARS INC
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {//MARS INC
        final int a =1;
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setTitle(getString(R.string.User))
                .setMessage(getString(R.string.exitMsg))
                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                })
                .show();

    }public boolean men (String m){//MARS INC

        return true;

    }

}