package com.wedapp.sud.myapp2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;



public class DisplayReceptionActivity extends AppCompatActivity {

    String parent = "reception";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_display_reception);
        Bundle args = new Bundle();
        args.putString("parent", parent);
        ContactFragment rFrag = new ContactFragment();
        if (args != null) {
            rFrag.setArguments(args);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_reception, rFrag);
        fragmentTransaction.commit();
    }
}