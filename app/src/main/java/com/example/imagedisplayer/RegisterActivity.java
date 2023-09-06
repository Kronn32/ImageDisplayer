package com.example.imagedisplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        EditText eName = (EditText)findViewById(R.id.nameInputReg);
        EditText eEmail = (EditText)findViewById(R.id.emailInputReg);
        EditText ePass = (EditText)findViewById(R.id.passwordInputReg);
        EditText eCfmPass = (EditText)findViewById(R.id.cfmpasswrodInputReg);
        Button register = (Button)findViewById(R.id.registerBtn);
        TextView login = (TextView)findViewById(R.id.toLoginTxt);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = eName.getText().toString();
                String email = eEmail.getText().toString();
                String pass = ePass.getText().toString();
                String cfmPass = eCfmPass.getText().toString();
                User a = new User(name, email, pass);
                if(!a.validateRegistInfo(name, email, pass, cfmPass)){
                    Toast.makeText(RegisterActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent toMain = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(toMain);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(toLogin);
            }
        });
    }
}