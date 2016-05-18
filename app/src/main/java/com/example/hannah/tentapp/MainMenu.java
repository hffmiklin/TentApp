package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.util.Log;

public class MainMenu extends AppCompatActivity {
    Button exam, logOut, kartVy, install;
    TextView userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        exam = (Button) findViewById(R.id.chooseExamButton);
        logOut = (Button) findViewById(R.id.logOutButton);
        userName = (TextView) findViewById(R.id.userNameField);
        Bundle extras = getIntent().getExtras();
        String userNameString = extras.getString("user_name");

        userName.setText(userNameString);

        //Knappar för kartvy och inställningar
        kartVy = (Button) findViewById(R.id.chooseKartvyButton);
        install = (Button) findViewById(R.id.chooseNotisButton);


        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainMenu.this, LogInWindow.class));
                Toast.makeText(getApplicationContext(), "Du är nu utloggad.",Toast.LENGTH_SHORT).show();
            }

        });
        //klickar på välj tenta-knappen, navigerar till lista med tentor
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Visar tentor",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainMenu.this, ExamList.class));
            }

        });



        //klickar på kartvy-knappen, navigerar till kartvy
        kartVy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Visar kartvyer",Toast.LENGTH_SHORT).show();
                //TO DO Kartvy är till tillfällig skärm, ska navigeras till riktiga maps
                startActivity(new Intent(MainMenu.this, MapsActivity.class));
            }

        });

        //klickar på inställning-knappen, navigerar till inställning
        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Visar inställningar",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainMenu.this, NotificationSettings.class));
            }

        });

        //Intent i = getIntent();
        //Recieving the data
        //String name = i.getStringExtra("userNameTextField");

        //Log.e("Second/main Screen", name);

    }
}
