package com.challenge.simpledaggerapplication2.di.components;

import com.challenge.simpledaggerapplication2.di.modules.AppModule;
import com.challenge.simpledaggerapplication2.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity activity);

}
