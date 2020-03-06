package com.sunflower.fingerprnt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sunflower.fingerprnt.R;

public class Signin extends AppCompatActivity {
    private TextView forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initiateIDs();
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin.this, ForgotPassword.class));
            }
        });
    }

    /**
     * Initiate IDs
     */
    public void initiateIDs() {
        forgot_password = findViewById(R.id.forgot_password);
    }
}
