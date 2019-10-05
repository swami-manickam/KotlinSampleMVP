package com.ayyanembed.myapplication.di.component;


import com.ayyanembed.myapplication.di.module.RepositoryModule;
import com.ayyanembed.myapplication.view.login.WhomConcernDetailsPresenter;
import com.ayyanembed.myapplication.view.login.news.FetchNewsPresenter;
import com.ayyanembed.myapplication.view.login.splash.SplashPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class, dependencies = {
        AppPreferencesComponent.class, ApplicationComponent.class
})
public interface RepositoryComponent {

    void inject(SplashPresenter splashPresenter);

    void inject(WhomConcernDetailsPresenter presenter);

    void inject(FetchNewsPresenter presenter);

}
