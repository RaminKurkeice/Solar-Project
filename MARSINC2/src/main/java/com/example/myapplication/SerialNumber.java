package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class SerialNumber extends Fragment {
    private EditText password;
    private Button updbtn;
    public String SRNnumber;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.serial_number,container,false);
        Objects.requireNonNull(getActivity()).setTitle("Serial Number"); //MARS INC


        LinearLayout layout = root.findViewById(R.id.serial_number);
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);

        password = (EditText) root.findViewById(R.id.SRN);
        updbtn = (Button) root.findViewById(R.id.update);
        updbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                SRNnumber = password.getText().toString();
                serial(password.getText().toString());
                if (SRNnumber.equals("123456789") || SRNnumber.equals("987654321")){

                    Toast.makeText(getActivity()," correct " + SRNnumber + " " ,Toast.LENGTH_SHORT).show();


                }
                else {

                    new AlertDialog.Builder(getActivity())
                            .setTitle("Incorrect Serial number?")
                            .setMessage("The serial umber you entered does not exist.")
                            .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create().show();
                }
            }
        });

        Boolean dmode = pref.getBoolean("Dark",false); //MARS INC
        if(dmode == true){
            layout.setBackgroundColor(getResources().getColor(R.color.Darkmode));
        }else if(dmode == false){
            layout.setBackgroundColor(getResources().getColor(R.color.white));
        }


        //Selects the prev selections for Port Mode
        boolean isSwitched = pref.getBoolean("switch",false);
        if(isSwitched){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }else{
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        }

        int textSize = pref.getInt("font",1);
        if(textSize == 0){
            getActivity().setTheme(R.style.AppTheme12);
        }else if (textSize == 1){
            getActivity().setTheme(R.style.AppTheme13);
        }else if (textSize == 2){
            getActivity().setTheme(R.style.AppTheme14);
        }

        return root;
    }


    public boolean serial(String s) { //MARS INC

        if (s.equals("123456789") || s.equals("987654321")) {
            return true;
        } else {
            return false;
        }
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
