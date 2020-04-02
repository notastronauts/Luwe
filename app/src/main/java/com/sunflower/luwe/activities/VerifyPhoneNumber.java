package com.sunflower.luwe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;
import com.google.android.material.button.MaterialButton;
import com.sunflower.luwe.R;

public class VerifyPhoneNumber extends AppCompatActivity {

    private TextView tphone_number;
    private Pinview pverification_code;
    private MaterialButton bverify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);
        initiateIds();
        tphone_number.setText(getIntent().getStringExtra("extraPhoneNumber"));

    }

    /**
     * Initiate IDs
     */
    public void initiateIds() {
        tphone_number = findViewById(R.id.phone_number);
        pverification_code = findViewById(R.id.verification_code);
        bverify = findViewById(R.id.send_verification_code);

    }

}
