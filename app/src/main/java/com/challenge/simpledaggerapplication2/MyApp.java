package com.challenge.simpledaggerapplication2;

import android.app.Application;

import com.challenge.simpledaggerapplication2.di.components.AppComponent;
import com.challenge.simpledaggerapplication2.di.components.DaggerAppComponent;
import com.challenge.simpledaggerapplication2.di.modules.AppModule;
import com.challenge.simpledaggerapplication2.ui.MainActivity;

public class MyApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static void inject(MainActivity mainActivity) {
        appComponent.inject(mainActivity);
    }
}
