package com.ayyanembed.myapplication.di.component;

import android.app.Application;
import android.content.Context;

import com.ayyanembed.myapplication.app.AppBus;
import com.ayyanembed.myapplication.di.module.ApplicationModule;


import dagger.Component;

@Component(modules = ApplicationModule.class) public interface ApplicationComponent {
  Application getApplication();

  Context getContext();


  AppBus getBus();
}
