package com.ayyanembed.myapplication.base

interface BasePresenter<in V : BaseView> {

  fun attachView(view: V)

  fun detachView()
}