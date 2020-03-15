package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_login extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button BtnLogin = findViewById(R.id.btnLogin);
        BtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent activityHomeScreen = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activityHomeScreen);
            }
        });

        TextView SignUpTxt = findViewById(R.id.SignUpText);
        SignUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitySignUp = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(activitySignUp);

            }
        });
    }
}

