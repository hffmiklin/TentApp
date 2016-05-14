package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificationSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);

        Toast.makeText(getApplicationContext(), "Välj tillfällen du vill ha notiser om",Toast.LENGTH_SHORT).show();
    }
}
