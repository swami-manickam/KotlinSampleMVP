package com.ayyanembed.myapplication.base


import com.ayyanembed.myapplication.app.AppBus
import com.ayyanembed.myapplication.app.AppController
import com.ayyanembed.myapplication.app.AppPreference
import com.ayyanembed.myapplication.di.component.RepositoryComponent
import com.ayyanembed.myapplication.repo.MyApplicationRepo
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class AbstractBasePresenter<V : BaseView> : BasePresenterImp<V>() {

    @Inject
    lateinit var appPreference: AppPreference
    @Inject
    lateinit var appBus: AppBus

    @Inject
    lateinit var appRepo: MyApplicationRepo

    var compositeSubscription: CompositeDisposable = CompositeDisposable()

    init {
        inject(AppController.getAppController().getReposComponent())
    }

    abstract fun inject(component: RepositoryComponent)

}