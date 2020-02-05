package com.example.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Weather extends Fragment implements LocationListener {
    TextView temperature, cit, des, count;
    private String latitudeField;
    private String longitudeField;
    int l;
    int lon;
    int TestL;
    View root;
    double temp_int;
    double centi;
    LocationManager locationManager;
    String provider;
    Location location;
    Criteria criteria;
    String Str, Str2;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 300;
    private static final int REQUEST_LOCATION = 2;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.weather, container, false);
        TestLocationChange();
        temperature = (TextView) root.findViewById(R.id.weather);
        cit = (TextView) root.findViewById(R.id.city);
        des = (TextView) root.findViewById(R.id.des);
        count = (TextView) root.findViewById(R.id.country);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        RelativeLayout layout = root.findViewById(R.id.weather1);
        SharedPreferences pref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);

        Boolean dmode = pref.getBoolean("Dark", false);
        if (dmode == true) {
            layout.setBackgroundColor(getResources().getColor(R.color.Darkmode));
        } else if (dmode == false) {
            layout.setBackgroundColor(getResources().getColor(R.color.white));
        }
        int textSize = pref.getInt("font", 1);
        if (textSize == 0) {
            getActivity().setTheme(R.style.AppTheme12);
        } else if (textSize == 1) {
            getActivity().setTheme(R.style.AppTheme13);
        } else if (textSize == 2) {
            getActivity().setTheme(R.style.AppTheme14);
        }

        boolean isSwitched = pref.getBoolean("switch", false);
        if (isSwitched) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        }

// Creating an empty criteria object
        criteria = new Criteria();

// Get the location from the given provider
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            onResume();
        } else {

// request permission from the user
            // Check Permissions Now

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
// Show our own UI to explain to the user why we need to access location
                // before actually requesting the permission and showing the default UI
            }

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);

        }

        if (location != null) {
            onLocationChanged(location);
        } else {
            Toast.makeText(getContext(), "Location can't be retrieved", Toast.LENGTH_SHORT).show();
        }
        TestLocationChange();
        find_weather();


        return root;
    }

    public void find_weather() {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitudeField + "&lon=" + longitudeField + "&appid=342f1f415fd1011299c94c50091fd54f&units=metric";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_Object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    JSONObject Obj = response.getJSONObject("sys");
                    String temp = String.valueOf(main_Object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");
                    String country = Obj.getString("country");
                    cit.setText(city);
                    des.setText(description);
                    count.setText(country);
                    temp_int = Double.parseDouble(temp);
                    centi = temp_int;

                    centi = Math.round(centi);
                    int i = (int) centi;
                    temperature.setText(String.valueOf(i));
                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(jor);
        int tru;
        if (temp_int != 0) {
            tru = 1;
            getTemp(tru);
        }
    }

    // Called when the user is performing an action which requires the app to get location
    public void getPermissionToAccessLocation() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// Permission Granted
                    onResume();
                } else {
// Permission Denied
                    Toast.makeText(getActivity(), "Access Location Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /* Remove the locationlistener updates when Activity is paused */

    @Override
    public void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
// Getting the name of the provider that meets the criteria
            provider = locationManager.getBestProvider(criteria, true);

            if (provider != null) {
                location = locationManager.getLastKnownLocation(provider);
                locationManager.requestLocationUpdates(provider, 20000, 1, this);
                onLocationChanged(location);
            }
        }


    }


    public void onLocationChanged(Location location) {
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        l = (int) lat;
        lon = (int) lng;
        latitudeField = String.valueOf(l);
        longitudeField = String.valueOf(lon);

    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
// TODO Auto-generated method stub

    }


    public void onProviderEnabled(String provider) {
        Str = "Enabled new provider";
        Toast.makeText(getActivity(), Str + provider,
                Toast.LENGTH_SHORT).show();

    }

    public void onProviderDisabled(String provider) {
        Str2 = "Disabled provider ";
        Toast.makeText(getActivity(), Str2 + provider,
                Toast.LENGTH_SHORT).show();
    }

    public int getTemp(int i) {


        return i;


    }

    public boolean TestLocationChange() {
        if (l == 0) {
            return true;

        }
        return false;
    }

    public boolean testOnresume() {

        if (provider == null) {
            return true;

        }
        return false;
    }

    public boolean TestonProviderEnabled(String str) {
        str="Enabled new provider";
        if (str =="Enabled new provider" ) {
            return true;

        }
        return false;
    }
    public boolean TestonProviderDisabled(String str) {
        str="Disabled provider";
        if (str =="Disabled provider" ) {
            return true;

        }
        return false;
    }
    public boolean TestStatus(String str) {
        str="null";
        if (str =="null" ) {
            return true;

        }
        return false;
    }
}