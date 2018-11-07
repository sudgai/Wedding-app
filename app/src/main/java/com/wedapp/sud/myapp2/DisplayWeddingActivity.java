package com.wedapp.sud.myapp2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class DisplayWeddingActivity extends AppCompatActivity {
    String parent = "wedding";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_display_wedding);
        Bundle args = new Bundle();
        args.putString("parent", parent);
        ContactFragment wFrag = new ContactFragment();
        if (args != null) {
            wFrag.setArguments(args);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_wrapper, wFrag);
        fragmentTransaction.commit();
    }
}