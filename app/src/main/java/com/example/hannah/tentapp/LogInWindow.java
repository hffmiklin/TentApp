package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.app.Activity;
import android.util.Log;



public class LogInWindow extends AppCompatActivity {
    EditText userNameField, passwordField;
    Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_window);


        userNameField = (EditText) findViewById(R.id.userNameTextField);
        passwordField = (EditText) findViewById(R.id.passwordTextField);
        logInButton = (Button) findViewById(R.id.logInButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameField.getText().toString().equals("admin") && passwordField.getText().toString().equals("admin")) {

                    Toast.makeText(getApplicationContext(), "Loggar in...",Toast.LENGTH_SHORT).show();

                    //This line should navigate the user to main window, getApplicationContext() was at login.this before
                    Intent nextScreen = new Intent(view.getContext(), MainMenu.class);

                   // nextScreen.putExtra("userNameTextField", userNameField.getText().toString());
                    //Log.e("n", userNameField.getText().toString());
                    //Should send data to the next screen
                    //nextScreen.putExtra("name", userNameField.getText().toString());
                    //Log.e("n", userNameField.getText());

                    startActivityForResult(nextScreen, 0);

                } else {
                    Toast.makeText(getApplicationContext(), "Du har angett felaktigt användarid eller lösenord, försök igen.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}

