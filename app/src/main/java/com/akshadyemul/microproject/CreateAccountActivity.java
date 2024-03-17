package com.akshadyemul.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    TextView btnLogin;
    EditText etUsername,etPassword,etRePassword;
    Button btnCreateAccount;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Intent login = new Intent(getApplicationContext(), LoginActivity.class);

        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        dbHelper = new DBHelper(this);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user, password, repassword;
                user = etUsername.getText().toString();
                password = etPassword.getText().toString();
                repassword = etRePassword.getText().toString();

                if (user.equals("") || password.equals("") || repassword.equals("")) {
                    Toast.makeText(CreateAccountActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(repassword)) {
                        if (dbHelper.checkUsername(user)) {
                            Toast.makeText(CreateAccountActivity.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        boolean registerSuccess = dbHelper.insertData(user, password);
                        if (registerSuccess)
                            Toast.makeText(CreateAccountActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(CreateAccountActivity.this, "User Registered Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CreateAccountActivity.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });
    }
}
