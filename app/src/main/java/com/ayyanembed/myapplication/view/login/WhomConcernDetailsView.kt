package com.ayyanembed.myapplication.view.login

import com.ayyanembed.myapplication.base.BaseView
import com.ayyanembed.myapplication.data.SignUpResponse


interface WhomConcernDetailsView : BaseView {

  fun showLoading(message: String)
  fun hideLoading()
  fun navigateToHome(details : SignUpResponse)

}