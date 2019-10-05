package com.ayyanembed.myapplication.view.login.splash

import com.ayyanembed.myapplication.base.AbstractBasePresenter
import com.ayyanembed.myapplication.di.component.RepositoryComponent

class SplashPresenter :AbstractBasePresenter<SplashView>() {


    var splashView: SplashView? = null

    override fun inject(component: RepositoryComponent) {
        component.inject(this)
    }

    override fun attachView(view: SplashView) {
        super.attachView(view)
        this.splashView = view

    }

    fun showUserScreen() {
        if (appPreference!!.getLoginStatus()) {
            view!!.navigateToNews()
        } else {
            view!!.showLoginForm()
        }
    }

}