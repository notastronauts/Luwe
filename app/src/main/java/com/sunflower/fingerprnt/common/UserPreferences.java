package com.sunflower.fingerprnt.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserPreferences {
    private static SharedPreferences preferences;

    public static boolean isLogin(Context context) {
        preferences = context.getSharedPreferences("UserPrefeerences", Context.MODE_PRIVATE);
        return preferences.getBoolean("login", false);
    }

    public static void hasLogin(Context context) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("login", true).apply();
    }

    public static void logout(Context context) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }

    public static String getTokeUser(Context context) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        return preferences.getString("token", "");
    }

    public static void setTokenUser(Context context, String token) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token).apply();
    }

    public static String getUserId(Context context) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        return preferences.getString("userId", "");
    }

    public static void setUserId(Context context, String userId) {
        preferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userId", userId).apply();
    }
}
