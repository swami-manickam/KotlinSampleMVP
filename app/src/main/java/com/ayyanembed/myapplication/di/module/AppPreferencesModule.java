package com.ayyanembed.myapplication.di.module;

import android.content.Context;

import com.ayyanembed.myapplication.app.AppPreference;

import dagger.Module;
import dagger.Provides;

@Module public class AppPreferencesModule {

  @Provides
  AppPreference providesAppPreferences(Context context) {
    return new AppPreference(context);
  }
}
