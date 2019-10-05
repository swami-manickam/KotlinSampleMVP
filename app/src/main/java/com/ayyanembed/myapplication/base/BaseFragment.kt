package com.ayyanembed.myapplication.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast

abstract class BaseFragment<in V : BaseView, T : BasePresenter<V>> : Fragment(),
    BaseView {

  abstract var mPresenter: T

  override fun getContext(): Context {
    return activity!!.applicationContext
  }

  override fun showError(error: String) {
    Toast.makeText(context, error, Toast.LENGTH_LONG)
        .show()
  }

  override fun showError(stringResId: Int) {
    Toast.makeText(context, stringResId, Toast.LENGTH_LONG)
        .show()
  }

  override fun showMessage(srtResId: Int) {
    Toast.makeText(context, srtResId, Toast.LENGTH_LONG)
        .show()
  }

  override fun showMessage(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG)
        .show()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mPresenter.attachView(this as V)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    mPresenter.detachView()
  }

}