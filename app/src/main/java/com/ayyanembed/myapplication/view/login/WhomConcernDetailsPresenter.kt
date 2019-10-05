package com.ayyanembed.myapplication.view.login

import com.ayyanembed.myapplication.app.ApiConstants
import com.ayyanembed.myapplication.base.AbstractBasePresenter
import com.ayyanembed.myapplication.di.component.RepositoryComponent
import com.ayyanembed.myapplication.repo.MyApplicationRepo
import com.ayyanembed.myapplication.utils.LoggerUtils
import com.ayyanembed.myapplication.utils.ParamUtils
import com.ayyanembed.myapplication.utils.RxJavaUtils
import javax.inject.Inject

class WhomConcernDetailsPresenter : AbstractBasePresenter<WhomConcernDetailsView>() {

    override fun inject(component: RepositoryComponent) {
        component.inject(this)
    }

    fun whomMayConcern(eid: Int, name: String, idBarNo : Int,emailId :String,
                       uniqueNo : Int, mobileNo : String) {

        val params = ParamUtils.whomMayConParams(eid, name, idBarNo, emailId, uniqueNo,
            mobileNo)
        if (isViewAttached()) {
            view?.showLoading("Signing In")
        }
        val concernDisposable = appRepo.updateWhomMayConcern(ApiConstants.CONSUMEER_KEY,
            ApiConstants.CONSUMER_SECRET, params)
            .compose(RxJavaUtils.applyObserverSchedulers())
            .subscribe({
                view?.hideLoading()
                appPreference.setLoginStatus(true)
                view?.showMessage("Login Successful")
                view?.navigateToHome(it)
            }, {
                view?.hideLoading()
                view?.showError(it.message!!)
                LoggerUtils.logUnExpectedException(it)
            })
        compositeSubscription.add(concernDisposable)
    }

}