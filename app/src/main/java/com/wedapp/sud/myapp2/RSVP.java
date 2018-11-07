package com.wedapp.sud.myapp2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RSVP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
        Button rsvp1 = (Button) findViewById(R.id.rsvp1);
        Button rsvp2 = (Button) findViewById(R.id.rsvp2);
        Button rsvp3 = (Button) findViewById(R.id.rsvp3);
        Button rsvp4 = (Button) findViewById(R.id.rsvp4);
        final String t_rsvp1 = getString(R.string.rsvp1);
        final String t_rsvp2 = getString(R.string.rsvp2);
        final String t_rsvp3 = getString(R.string.rsvp3);
        final String t_rsvp4 = getString(R.string.rsvp4);
        rsvp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                callIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                callIntent.setData(Uri.parse(t_rsvp1));

                if (ActivityCompat.checkSelfPermission(RSVP.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        rsvp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(t_rsvp2));

                if (ActivityCompat.checkSelfPermission(RSVP.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        rsvp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(t_rsvp3));

                if (ActivityCompat.checkSelfPermission(RSVP.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        rsvp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(t_rsvp4));

                if (ActivityCompat.checkSelfPermission(RSVP.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }
}
