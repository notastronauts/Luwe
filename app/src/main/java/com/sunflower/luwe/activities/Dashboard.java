package com.sunflower.luwe.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sunflower.luwe.R;
import com.sunflower.luwe.common.UserPreferences;
import com.sunflower.luwe.network.ServiceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("isLoggedIn", Boolean.toString(UserPreferences.isLogin(Dashboard.this)));
        setContentView(R.layout.activity_dashboard);
        InitiateIds();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
    }

    /**
     * Initiate IDs
     */
    public void InitiateIds() {
        logout = findViewById(R.id.logout);
    }

    /**
     * Logout
     */
    public void Logout() {
        ServiceClient
                .buildServiceClient()
                .logout("Bearer " + UserPreferences.getTokenUser(Dashboard.this))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            UserPreferences.logout(Dashboard.this);
                            startActivity(new Intent(getApplicationContext(), Signin.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
    }
}
