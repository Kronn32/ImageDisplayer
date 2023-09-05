package com.example.imagedisplayer;

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

        Button login = (Button)findViewById(R.id.loginBtn);
        TextView register = (TextView) findViewById(R.id.toRegisterTxt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(toMain);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(toRegister);
            }
        });
    }
}