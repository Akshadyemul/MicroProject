package com.akshadyemul.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginbt = findViewById(R.id.loginbt);
        TextView createAccountbt = findViewById(R.id.createaccountbt);
        EditText emailET = findViewById(R.id.email);
        EditText passwordET = findViewById(R.id.password);


        Intent home = new Intent(getApplicationContext(), MainActivity.class);

        Intent createAccount = new Intent(getApplicationContext(), CreateAccountActivity.class);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                startActivity(home);
            }
        });

        createAccountbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createAccount);
            }
        });
    }
}