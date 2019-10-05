package com.ayyanembed.myapplication.view.login.splash

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import com.ayyanembed.myapplication.R
import com.ayyanembed.myapplication.app.AppConstants
import com.ayyanembed.myapplication.base.BaseActivity
import com.ayyanembed.myapplication.view.login.WhomConcernDetailsActivity
import com.ayyanembed.myapplication.view.login.news.FetchNewsActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {


    override var presenter: SplashPresenter = SplashPresenter()

    override fun getContext() =this

    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        val disposable = Observable.timer(AppConstants.SPLASH_TIME, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { aLong -> presenter.showUserScreen() }
        compositeDisposable.add(disposable)

    }

    override fun navigateToNews() {
        startActivity(Intent(this, FetchNewsActivity::class.java))
        finish()
    }

    override fun showLoginForm() {
        startActivity(Intent(this, WhomConcernDetailsActivity::class.java))
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        presenter.detachView()
    }


}
