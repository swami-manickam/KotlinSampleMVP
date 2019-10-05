package com.ayyanembed.myapplication.app

import android.app.Application
import com.ayyanembed.myapplication.di.component.DaggerAppPreferencesComponent
import com.ayyanembed.myapplication.di.component.DaggerApplicationComponent
import com.ayyanembed.myapplication.di.component.DaggerRepositoryComponent
import com.ayyanembed.myapplication.di.component.RepositoryComponent
import com.ayyanembed.myapplication.di.module.AppPreferencesModule
import com.ayyanembed.myapplication.di.module.ApplicationModule


class AppController : Application() {

  val API_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
  var repositoryComponent: RepositoryComponent? = null

  override fun onCreate() {
    super.onCreate()

  }

  init {
    instance = this
    val applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

    val appPreferencesComponent = DaggerAppPreferencesComponent.builder()
        .applicationComponent(applicationComponent)
        .appPreferencesModule(AppPreferencesModule())
        .build()

    repositoryComponent = DaggerRepositoryComponent.builder()
        .applicationComponent(applicationComponent)
        .appPreferencesComponent(appPreferencesComponent)
        .build()
  }

  companion object {

    var instance: AppController? = null

    fun getAppController(): AppController {
      return instance!!
    }

  }

  fun getReposComponent(): RepositoryComponent {
    return repositoryComponent!!
  }

}