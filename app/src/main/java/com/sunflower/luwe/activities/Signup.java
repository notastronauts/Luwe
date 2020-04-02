package com.sunflower.luwe.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sunflower.luwe.R;
import com.sunflower.luwe.model.PhoneNumber;
import com.sunflower.luwe.model.ResponsePhoneNumberVerification;
import com.sunflower.luwe.network.ServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity{

    private MaterialButton sign_up;
    private TextInputLayout phone_number_container;
    private TextInputEditText phone_number_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        appBarConfig();
        initiateIds();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_number = phone_number_field.getText().toString();
                validatePhoneNumber(phone_number);
                if (phone_number.substring(0, 0).equalsIgnoreCase("0")) {
                    phone_number = phone_number.substring(0,0) + "+62" + phone_number.substring(0+1);
                    sendCode(phone_number);
                } else if(phone_number.substring(0, 0).equalsIgnoreCase("6")) {
                    phone_number = phone_number.substring(0,0) + "+" + phone_number.substring(0+1);
                    sendCode(phone_number);
                }
                else {
                    sendCode(phone_number);
                }

            }
        });
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
        phone_number_container = findViewById(R.id.phone_number_container);
        phone_number_field = findViewById(R.id.phone_number);
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            phone_number_container.setError("Nomor telpon tidak boleh kosong");
        }
    }

    public void sendCode(String phone_number) {
        ServiceClient
                .buildServiceClient()
                .sendVerificationCode(new PhoneNumber(phone_number))
                .enqueue(new Callback<ResponsePhoneNumberVerification>() {
                    @Override
                    public void onResponse(Call<ResponsePhoneNumberVerification> call, Response<ResponsePhoneNumberVerification> response) {
                        if (response.isSuccessful()) {
                            ResponsePhoneNumberVerification responsePhoneNumberVerification = response.body();
                            Intent intent = new Intent(getApplicationContext(), VerifyPhoneNumber.class);
                            String extraPhoneNumber = responsePhoneNumberVerification.getPhoneNumber();
                            intent.putExtra("extraPhoneNumber", extraPhoneNumber);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsePhoneNumberVerification> call, Throwable t) {

                    }
                });
    }
}
