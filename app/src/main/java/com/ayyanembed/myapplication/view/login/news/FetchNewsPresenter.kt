package com.ayyanembed.myapplication.view.login.news

import com.ayyanembed.myapplication.app.ApiConstants
import com.ayyanembed.myapplication.base.AbstractBasePresenter
import com.ayyanembed.myapplication.di.component.RepositoryComponent
import com.ayyanembed.myapplication.repo.MyApplicationRepo
import com.ayyanembed.myapplication.utils.LoggerUtils
import com.ayyanembed.myapplication.utils.RxJavaUtils
import javax.inject.Inject

class FetchNewsPresenter :AbstractBasePresenter<FetchNewsView>(){


    override fun inject(component: RepositoryComponent) {
        component.inject(this)
    }

    fun getNewsList() {
        if (isViewAttached()) {
            view?.showLoading("Fetching news...")
        }

        val disposable = appRepo.getNewsInfo(ApiConstants.CONSUMEER_KEY, ApiConstants.CONSUMER_SECRET)
            .compose(RxJavaUtils.applyObserverSchedulers())
            .subscribe({
                view?.hideLoading()
                view?.showMenuList(it.payload!!)
            }, {
                view?.hideLoading()
                view?.showError(it.message!!)
                LoggerUtils.logUnExpectedException(it)
            })
        compositeSubscription.add(disposable)
    }

}