package com.ayyanembed.myapplication.di.component;


import com.ayyanembed.myapplication.app.AppPreference;
import com.ayyanembed.myapplication.di.module.AppPreferencesModule;

import dagger.Component;


@Component(modules = AppPreferencesModule.class, dependencies = ApplicationComponent.class)
public interface AppPreferencesComponent {

  AppPreference getAppPreference();
}
