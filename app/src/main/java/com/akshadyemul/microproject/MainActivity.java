package com.akshadyemul.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent fromLogin = getIntent();
        String lname = fromLogin.getStringExtra("username");

        TextView name = findViewById(R.id.name);

        name.setText("Welcome Back \n"+lname);
    }
}