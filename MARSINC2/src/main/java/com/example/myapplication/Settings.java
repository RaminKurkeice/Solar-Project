package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Settings extends Fragment implements View.OnClickListener {
    private Switch switchPort, switchDark;
    private  Spinner spinner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View Fragment
        View root=inflater.inflate(R.layout.settings,container,false);
        //Toolbar Title
        Objects.requireNonNull(getActivity()).setTitle("Settings");
        //Shared Preference connection
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        //Switch button for Dark Mode
        switchDark = (Switch) root.findViewById(R.id.darkS);// initiate Switch
        //Switch for portrait Mode
        switchPort = (Switch) root.findViewById(R.id.portS);// initiate Switch
        //Spinner for font
         spinner = (Spinner) root.findViewById(R.id.spinner);
        //Button to save settings
        Button buttonSet = (Button) root.findViewById(R.id.saveSet);
        //Button onClick function
        buttonSet.setOnClickListener(this);

        //Selects the prev selections for Dark Mode
        boolean isSwitchedDark = pref.getBoolean("Dark",false);
        if(isSwitchedDark){
            switchDark.setChecked(true);
            dark(1);

        }else {
            switchDark.setChecked(false);
            dark(0);
        }

        //Selects the prev selections for Port Mode
        boolean isSwitched = pref.getBoolean("switch",false);
        if(isSwitched){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            port(1);
            switchPort.setChecked(true);
        }else{
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            port(0);
            switchPort.setChecked(false);
        }

        int textSize = pref.getInt("font",1);
        if(textSize == 0){
            getActivity().setTheme(R.style.AppTheme12);
            set(0);
        }else if (textSize == 1){
            getActivity().setTheme(R.style.AppTheme13);
            set(1);
        }else if (textSize == 2){
            getActivity().setTheme(R.style.AppTheme14);
            set(2);
        }




        return root;
    }
    @Override
    public void onClick(View v) { //MARS INC
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //Dark Mode saving settings
        switchDark = getActivity().findViewById(R.id.darkS);
        editor.putBoolean("Dark",switchDark.isChecked());
        editor.apply();

        //Portrait Mode saving settings
        switchPort = getActivity().findViewById(R.id.portS);
        editor.putBoolean("switch",switchPort.isChecked());
        editor.apply();


        int selectedPosition = spinner.getSelectedItemPosition();
        editor.putInt("selec", selectedPosition);

        Toast.makeText(getContext(), R.string.settingsApplied,Toast.LENGTH_SHORT).show(); getActivity().recreate();
        //Toast Message
    }

   public  int set (int text){ //MARS INC

       if(text == 0){
            return 0;
       }else if (text == 1){

           return 1;
       }else if (text == 2){
           return 2;
       }
        return text;
   }
    public int dark(int d){ //MARS INC

        if (d == 1) {
            return 1;
        } else {
            return 0;
        }

    }
    public int port(int d){ //MARS INC

        if (d == 1) {
            return 1;
        } else {
            return 0;
        }

    }
}
