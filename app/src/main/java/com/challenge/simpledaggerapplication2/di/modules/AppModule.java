package com.challenge.simpledaggerapplication2.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.challenge.simpledaggerapplication2.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    public static final String PREF_NAME = "MY_PREF";

    private MyApp myApp;

    public AppModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreference() {
        return myApp.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
}
