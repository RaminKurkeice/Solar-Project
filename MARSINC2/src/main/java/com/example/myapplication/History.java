package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class History extends Fragment {


    private ListView mListView;
    private FirebaseListAdapter adapter;
    private DatabaseReference Reference;
    private String SRNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.history,container,false);
        Objects.requireNonNull(getActivity()).setTitle("History");//MARS INC

        LinearLayoutCompat layout = root.findViewById(R.id.history);
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);


        Boolean dmode = pref.getBoolean("Dark",false);
        if(dmode == true){
            layout.setBackgroundColor(getResources().getColor(R.color.Darkmode));
        }else if(dmode == false){
            layout.setBackgroundColor(getResources().getColor(R.color.white));
        }


        int textSize = pref.getInt("font",1);
        if(textSize == 0){
            getActivity().setTheme(R.style.AppTheme12);
        }else if (textSize == 1){
            getActivity().setTheme(R.style.AppTheme13);
        }else if (textSize == 2){
            getActivity().setTheme(R.style.AppTheme14);
        }
        boolean isSwitched = pref.getBoolean("switch",false);
        if(isSwitched){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        }
//mListView = (ListView) root.findViewById(R.id.list_view);//MARS INC
        //  DatabaseReference Reference = FirebaseDatabase.getInstance().getReference()
        //      .child("123456789");

      /* mListView.setAdapter(new FirebaseListAdapter<SRN>(this, SRN.class,
              R.layout.datamap, Reference) {

            // Populate view as needed
            @Override
            protected void populateView(View view, SRN model ,int position) {//MARS INC
                TextView Pow = view.findViewById(R.id.power1);
                TextView LU = view.findViewById(R.id.lux1);
                TextView TI = view.findViewById(R.id.time1);

                SRN srn = (SRN) model;
                Pow.setText(srn.getPower().toString());
                LU.setText(srn.getLux().toString());
                TI.setText(srn.getTime().toString());
            }
       });
*/

        return root;
    }

   /* public class SRN {//MARS INC

        private String power;
        private String lux;
        private String time;

        public SRN() {
            // Constructor required for Firebase Database
        }

        public SRN(String lux, String power, String time){
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
    } */
}
