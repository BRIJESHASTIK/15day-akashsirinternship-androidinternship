package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sharedpreference.MainActivity;

public class Login extends AppCompatActivity {
    EditText etEmail,etPassword;
    Button btnSignin, btnSignup;

    public static final String main_key="myPref";
    public static final String email_key="emailkey";
    public static final String password_key="passwordkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

        btnSignin=findViewById(R.id.btnSignin);
        btnSignup=findViewById(R.id.btnSignup);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useremail,userpassword;
                useremail=etEmail.getText().toString();
                userpassword=etPassword.getText().toString();

                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);
                String email = preferences.getString(email_key,"");
                String password = preferences.getString(password_key,"");

                if (useremail.equals(email) && userpassword.equals(password)){

                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this,"Wrong Details",Toast.LENGTH_SHORT).show();
                }


            }
        });



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
