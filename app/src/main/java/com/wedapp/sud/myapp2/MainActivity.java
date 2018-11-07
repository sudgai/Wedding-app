package com.wedapp.sud.myapp2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent objIntent = new Intent(this, PlayAudio.class);
        startService(objIntent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    protected void onDestroy() {
        Intent objIntent = new Intent(this, PlayAudio.class);
        stopService(objIntent);
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textHead =(TextView) findViewById(R.id.textHead);
        Typeface tf = Typeface.createFromAsset(getAssets(),"font.ttf");
        textView.setTypeface(tf);
        textHead.setTypeface(tf);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent rsvp = new Intent(this, RSVP.class);
        //noinspection SimplifiableIfStatement
        if (id == R.id.rsvp) {
            startActivity(rsvp);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent bride = new Intent(this,DisplayBrideActivity.class);
        Intent groom = new Intent(this,DisplayGroomActivity.class);
        Intent weddding = new Intent(this,DisplayWeddingActivity.class);
        Intent reception = new Intent(this,DisplayReceptionActivity.class);
        Intent invite = new Intent(this, SubmitInviteActivity.class);
        Intent share = new Intent(Intent.ACTION_SEND);
        if (id == R.id.nav_bride) {
            // Handle the camera action
            startActivity(bride);
        } else if (id == R.id.nav_groom) {
            startActivity(groom);
        } else if (id == R.id.nav_wedding) {
            startActivity(weddding);
        } else if (id == R.id.nav_reception) {
            startActivity(reception);
        } else if (id == R.id.nav_share) {
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, "App link");
            share.putExtra(Intent.EXTRA_TEXT, "Visit website: http://snhlwdsdhr.comeze.com App link: https://drive.google.com/open?id=0BxCevC4OGx5MT3Zjc0VyaE9sQ0k");
            startActivity(Intent.createChooser(share, "Sharing Option"));
        } else if (id == R.id.nav_send) {
            startActivity(invite);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}