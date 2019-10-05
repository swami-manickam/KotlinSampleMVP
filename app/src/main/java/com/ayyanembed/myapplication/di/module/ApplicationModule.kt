package com.ayyanembed.myapplication.di.module

import android.app.Application
import android.content.Context
import com.ayyanembed.myapplication.app.AppBus
import com.ayyanembed.myapplication.app.AppPreference
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

  private val application: Application
  private val appBus: AppBus

  constructor(application: Application) {
    this.application = application
    this.appBus = AppBus()
  }

  @Provides
  fun providesApplication(): Application {
    return application
  }

  @Provides
  fun providesContext(): Context {
    return application
  }

  @Provides
  fun providesAppPreferences(context: Context): AppPreference {
    return AppPreference(context)
  }

  @Provides internal fun providesBus(): AppBus {
    return appBus
  }

}