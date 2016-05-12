package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.util.Log;

public class MainMenu extends AppCompatActivity {
    Button exam, logOut;
    EditText tentApp, userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tentApp = (EditText) findViewById(R.id.tentAppText);
        exam = (Button) findViewById(R.id.chooseExamButton);
        logOut = (Button) findViewById(R.id.logInButton);
        userName = (EditText) findViewById(R.id.userNameField);

        logOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //Intent i = getIntent();
        //Recieving the data
        //String name = i.getStringExtra("userNameTextField");

        //Log.e("Second/main Screen", name);

    }
}
