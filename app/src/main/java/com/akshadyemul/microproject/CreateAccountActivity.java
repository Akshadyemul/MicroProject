package com.akshadyemul.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        TextView loginbt = findViewById(R.id.loginbt);
        EditText nameET = findViewById(R.id.name);
        EditText emailET = findViewById(R.id.email);
        Button createAccountbt = findViewById(R.id.createaccountbt);

        String email = emailET.getText().toString();
        String name = nameET.getText().toString();

        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        Intent createAccount = new Intent(getApplicationContext(), MainActivity.class);

        createAccount.putExtra("name",name);
        createAccount.putExtra("name",email);

        createAccountbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createAccount);
            }
        });

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });
    }
}