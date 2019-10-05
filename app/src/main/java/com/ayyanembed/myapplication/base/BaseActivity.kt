package com.ayyanembed.myapplication.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>> : AppCompatActivity(),
    BaseView {

  protected abstract var presenter: T

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(view = this as V)
  }

  override fun showError(error: String) {
    Toast.makeText(this, error, Toast.LENGTH_LONG).show();
  }

  override fun showError(stringResId: Int) {

  }

  override fun showMessage(srtResId: Int) {

  }

  override fun showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}