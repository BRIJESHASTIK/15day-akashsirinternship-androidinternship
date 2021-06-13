package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    Button btnLogout;
    TextView tvName,tvEmail,tvContact;

    public static final String main_key="myPref";

    public static final String name_key="namekey";
    public static final String email_key="emailkey";
    public static final String password_key="passwordkey";
    public static final String contact_key="contactkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout=findViewById(R.id.btnLogout);
        tvName=findViewById(R.id.tvName);
        tvEmail=findViewById(R.id.tvEmail);
        tvContact=findViewById(R.id.tvContact);

        String name,email,contact;

        SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);
        name = preferences.getString(name_key,"");
        tvName.setText("Name = "+name);

        email = preferences.getString(email_key,"");
        tvEmail.setText("Email = "+email);

        contact = preferences.getString(contact_key,"");
        tvContact.setText("Contact No. = "+contact);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.clear();
                editor.commit();
                finish();
                moveTaskToBack(true);


            }
        });
    }
}
