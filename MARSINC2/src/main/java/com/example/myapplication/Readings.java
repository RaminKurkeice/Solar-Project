package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Readings extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.readings,container,false);
        Objects.requireNonNull(getActivity()).setTitle("Readings"); //MARS INC

        LinearLayout layout = root.findViewById(R.id.readings);
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);

        Boolean dmode = pref.getBoolean("Dark",false);
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
//MARS INC
   /* public static class SRN {  // problems with backend calling causes crashes

        public String lux;
        public String power;
        public String time;

        public SRN(String lux, String power, String time) {
            this.lux = lux;
            this.power = power;
            this.time = time;
        }
        public String getLux() {
            return lux;
        }
        public void setLux(String lux){
            this.lux = lux;
        }
        public String getPower() {
            return power;
        }
        public void setPower(String power){
            this.power = power;
        }
        public String getTime() {
            return time;
        }
        public void setTime(String time){
            this.time = time;
        }
    }


    final FirebaseDatabase database = FirebaseDatabase.getInstance(); //MARS INC
    DatabaseReference ref = database.getReference("https://console.firebase.google.com/u/0/project/marsinc-2019/overview");

      /*  ref.addValueEventListener(new ValueEventListener() { //MARS INC
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            SRN srn = dataSnapshot.getValue(SRN.class);
            System.out.println(srn);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("The read failed: " + databaseError.getCode());
        }
    });*/
}
