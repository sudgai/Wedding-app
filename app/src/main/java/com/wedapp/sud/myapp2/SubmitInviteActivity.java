package com.wedapp.sud.myapp2;

import android.content.pm.ActivityInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;

public class SubmitInviteActivity extends AppCompatActivity {
    int guest_count;
    String guest, contact, guestPlace, mail_line1_1, mail_line1_2, mail_line2, message;
    Button submit;
    EditText submitName, submitNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_invite);
        NumberPicker inviteCount = (NumberPicker) findViewById(R.id.invite_count);
        inviteCount.setMinValue(1);
        inviteCount.setMaxValue(10);
        inviteCount.setValue(1);
        inviteCount.setWrapSelectorWheel(true);
        guest_count = inviteCount.getValue();
        inviteCount.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Do something..
                guest_count = newVal;
            }
        });
        submitName = (EditText) findViewById(R.id.Submit_name);
        submitNumber = (EditText) findViewById(R.id.Submit_number);
        final CheckBox wedding = (CheckBox) findViewById(R.id.wedding);
        final CheckBox reception = (CheckBox) findViewById(R.id.reception);
        wedding.setChecked(true);
        reception.setChecked(true);
        mail_line1_1 = getString(R.string.mail_line1_1);
        mail_line1_2 = getString(R.string.mail_line1_2);
        mail_line2 = getString(R.string.mail_line2);
        submit = (Button) findViewById(R.id.invite_submit);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (wedding.isChecked() && reception.isChecked()){
                        guestPlace = "wedding and reception";
                    }else if (reception.isChecked()){
                        guestPlace = "reception";
                    }else if (wedding.isChecked()){
                        guestPlace = "wedding";
                    }else {
                        guestPlace = "";
                        message = "Please, Select at least single ceremony";
                    }
                    guest = submitName.getText().toString().trim();
                    contact = submitNumber.getText().toString().trim();
                    final String Subject = guest + guestPlace;
                    final String mail_body = mail_line1_1 + guest + "("+ contact +")" + mail_line1_2 + guestPlace + mail_line2 + guest_count;
                    if (guest.length() == 0 || guest.isEmpty() || guest.equals("") || guest == null) {
                        message = "Please, Fill your name in Name.";
                    } else if (contact.length()==0 || contact.isEmpty() || contact.equals("") || contact== null){
                        message = "Please, Fill your contact in Contact";
                    }
                    else if (contact.length() !=10){
                        message = "Please, Fill valid contact in Contact.";
                    }else if (guestPlace.length() == 0 || guestPlace.equals("") || guestPlace.isEmpty()){
                        message = "Please, Select at least single ceremony";
                    }
                    else {
                        message = "Invite has been sent to organisers.";
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    GmailSender sender = new GmailSender(
                                            "snhlwdsdhr@gmail.com",
                                            "savethedate");
                                    sender.sendMail(Subject, mail_body,
                                            "sudgaikwad@gmail.com",
                                            "sudgaikwad@gmail.com");
                                } catch (Exception e) {
                                    message = "Error";
                                }
                            }
                        }).start();
                    }
                    if ( message.length() != 0 || message != null) {
                        Snackbar.make(v, message, Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        if (message.equals("Invite has been sent to organisers.")){
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3500);
                                        finish();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();
                        }
                    }
                }
            });
    }
}
