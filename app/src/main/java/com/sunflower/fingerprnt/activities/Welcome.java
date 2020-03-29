package com.sunflower.fingerprnt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.sunflower.fingerprnt.R;
import com.sunflower.fingerprnt.common.UserPreferences;

public class Welcome extends AppCompatActivity {
    private MaterialButton sign_in, sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLoggedIn(UserPreferences.isLogin(Welcome.this));
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);

        initiateIDs();

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Signin.class));
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity((new Intent(Welcome.this, Signup.class)));
            }
        });
    }

    /**
     * Initiate IDs
     */
    public void initiateIDs () {
        sign_in = findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);
    }

    /**
     * Check login status
     * @param hasLogin
     */
    public void isLoggedIn (boolean hasLogin) {
        if (hasLogin) {
            startActivity(new Intent(Welcome.this, Dashboard.class));
            finish();
        }
    }
}
