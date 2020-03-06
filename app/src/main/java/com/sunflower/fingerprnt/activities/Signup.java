package com.sunflower.fingerprnt.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.sunflower.fingerprnt.R;

public class Signup extends AppCompatActivity {

    private MaterialButton sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initiateIds();
        appBarConfig();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    /**
     * AppBar Configuration
     */
    public void appBarConfig() {
        //Add back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Initiate IDs
     */
    public void initiateIds() {
        sign_up = findViewById(R.id.sign_up);
    }
}
