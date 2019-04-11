package com.challenge.simpledaggerapplication2.common;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

public class PreferenceHelper {

   private final SharedPreferences sharedPreferences;

   @Inject
    public PreferenceHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    private static final String TAG = "TAG_1";

    public void log() {
        for (Map.Entry entry : sharedPreferences.getAll().entrySet()) {
            Log.v(TAG, entry.getKey() + " " + entry.getValue());
        }
    }

    public boolean add(String key, String value) {
        return sharedPreferences.edit().putString(key, value).commit();
    }

}
