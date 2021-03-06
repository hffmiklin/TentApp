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

                    String userName = String.valueOf(userNameField.getText());
                    Intent intent = new Intent(LogInWindow.this,MainMenu.class);
                    intent.putExtra("user_name",userName);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Du har angett felaktigt användarid eller lösenord, försök igen.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}

