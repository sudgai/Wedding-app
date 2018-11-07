package com.wedapp.sud.myapp2;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class DisplayGroomActivity extends AppCompatActivity {
    private int[] sliderImg = new int[]{
            R.mipmap.groom, R.mipmap.groom1
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_display_groom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle args = new Bundle();
        InfoTabFragment bFrag = new InfoTabFragment();
        args.putString("info", getString(R.string.groom_text));
        args.putIntArray("slideImg", sliderImg);
        bFrag.setArguments(args);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.infogroom_container, bFrag);
        fragmentTransaction.commit();
    }
}