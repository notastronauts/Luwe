package com.sunflower.fingerprnt.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sunflower.fingerprnt.R;

public class Signup extends AppCompatActivity {

    private MaterialButton sign_up;
    private TextInputEditText phone_number_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initiateIds();
        appBarConfig();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, Welcome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /**
     * AppBar Configuration
     */
    public void appBarConfig() {
        //Add back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register");
    }

    /**
     * Initiate IDs
     */
    public void initiateIds() {
        sign_up = findViewById(R.id.sign_up);
        phone_number_field = findViewById(R.id.phone_number);
    }
}
