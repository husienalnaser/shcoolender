package com.example.schoolender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button loginb = findViewById(R.id.loginb);
        Button signout =findViewById(R.id.loginb2);
        final TextView accounty=findViewById(R.id.daaccount);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(profile.this,login.class);
                startActivity(intent);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(profile.this, "signed out", Toast.LENGTH_SHORT).show();
                accounty.setText("not signed in");
                Intent intent=new Intent(profile.this,login.class);
                startActivity(intent);


            }
        });
        Bundle bundle=getIntent().getExtras();
        String email=bundle.getString("email");
        accounty.setText("account: "+email);


    }
}