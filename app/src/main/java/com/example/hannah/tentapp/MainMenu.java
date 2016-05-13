package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.util.Log;

public class MainMenu extends AppCompatActivity {
    Button exam, logOut;
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

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Loggar ut",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainMenu.this, LogInWindow.class));
            }

        });

        //Intent i = getIntent();
        //Recieving the data
        //String name = i.getStringExtra("userNameTextField");

        //Log.e("Second/main Screen", name);

    }
}
