package com.sunflower.luwe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.sunflower.luwe.R;

public class ForgotPassword extends AppCompatActivity {

    private MaterialButton send_verivfication_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initiateIDs();
        send_verivfication_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this, CreateNewPassword.class));
            }
        });
    }

    /**
     * Initiate IDs
     */
    public void initiateIDs() {
        send_verivfication_button = findViewById(R.id.send_verification_code);
    }
}
