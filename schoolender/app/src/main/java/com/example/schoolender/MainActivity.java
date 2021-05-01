package com.example.schoolender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button profilee=findViewById(R.id.loginb6);
        Bundle bundle=getIntent().getExtras();
        final String email=bundle.getString("email");

        profilee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(FirebaseAuth.getInstance().getCurrentUser()== null){
                    Intent intent=new Intent(MainActivity.this,login.class);
                    startActivity(intent);

                }else{
                    Intent intent=new Intent(MainActivity.this,profile.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }


            }
        });

    }
}