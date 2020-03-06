package com.sunflower.fingerprnt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sunflower.fingerprnt.R;
import com.sunflower.fingerprnt.common.UserPreferences;
import com.sunflower.fingerprnt.common.Utils;
import com.sunflower.fingerprnt.model.AuthorizationResponse;
import com.sunflower.fingerprnt.model.Credentials;
import com.sunflower.fingerprnt.network.ServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signin extends AppCompatActivity {
    private TextView forgot_password;
    private TextInputLayout email_container, password_container;
    private TextInputEditText email, passsword;
    private MaterialButton sign_in;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initiateIDs();

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = passsword.getText().toString();

                if (user_email.isEmpty()) {
                    email_container.setErrorEnabled(true);
                    email_container.setError("Email cannot be empty");
                    return;
                }

                if (user_password.isEmpty()) {
                    password_container.setErrorEnabled(true);
                    password_container.setError("Password cannot be empty");
                    return;
                }

                Utils.hideSoftKey(email);
                processLogin(user_email, user_password);
            }
        });

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
        email_container = findViewById(R.id.email_container);
        password_container = findViewById(R.id.password_container);
        email = findViewById(R.id.email);
        passsword = findViewById(R.id.password);
        sign_in = findViewById(R.id.sign_in);
        loading = findViewById(R.id.loading);
    }

    public void processLogin(final String user_email, String user_password) {
        loading.setVisibility(View.VISIBLE);

        email.setEnabled(false);
        passsword.setEnabled(false);
        sign_in.setEnabled(false);

        Credentials credential = new Credentials(user_email, user_password, false);

        ServiceClient
                .buildServiceClient()
                .login(credential)
                .enqueue(new Callback<AuthorizationResponse>() {
                    @Override
                    public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {
                        if (response.isSuccessful()) {
                            AuthorizationResponse authorizationResponse = response.body();

                            UserPreferences.setTokenUser(Signin.this, authorizationResponse.getSuccess().getToken());
                            UserPreferences.hasLogin(Signin.this);
                            loading.setVisibility(View.GONE);
                            Log.d("Auth", UserPreferences.getTokeUser(Signin.this));
                        }
                        else {
                            password_container.setError("Wrong username or password");
                            Log.d("OnResponse", "OnResponse " + response.message());

                            loading.setVisibility(View.GONE);
                            email.setEnabled(true);
                            passsword.setEnabled(true);
                            sign_in.setEnabled(true);
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                        Toast.makeText(Signin.this, "Something Wrong!", Toast.LENGTH_SHORT).show();
                        Log.d("onFailure", "onFailure " + t.getMessage());

                        loading.setVisibility(View.GONE);
                        email.setEnabled(true);
                        passsword.setEnabled(true);
                        sign_in.setEnabled(true);
                    }
                });
    }
}
