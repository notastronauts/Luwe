package com.sunflower.luwe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;
import com.google.android.material.button.MaterialButton;
import com.sunflower.luwe.R;
import com.sunflower.luwe.model.Verify;
import com.sunflower.luwe.network.ServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyPhoneNumber extends AppCompatActivity {

    private TextView tphone_number;
    private Pinview pverification_code;
    private MaterialButton bverify;
    private LinearLayout progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);
        initiateIds();
        final String phone_number = getIntent().getStringExtra("extraPhoneNumber");
        tphone_number.setText(phone_number);

        bverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyPhoneNumber(phone_number, pverification_code.getValue());
            }
        });

    }

    /**
     * Initiate IDs
     */
    public void initiateIds() {
        tphone_number = findViewById(R.id.phone_number);
        pverification_code = findViewById(R.id.verification_code);
        bverify = findViewById(R.id.verify_button);
        progressBar = findViewById(R.id.llprogressbar);

    }

    public void verifyPhoneNumber(String phone_number, String code) {
        ServiceClient
                .buildServiceClient()
                .verifyPhoneNumber(new Verify(phone_number, code))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        progressBar.setVisibility(View.VISIBLE);
                        if (response.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            Log.d("Response", response.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }

}
