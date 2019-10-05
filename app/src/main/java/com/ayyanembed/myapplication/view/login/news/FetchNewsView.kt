package com.ayyanembed.myapplication.view.login.news

import com.ayyanembed.myapplication.base.BaseView
import com.ayyanembed.myapplication.data.PayloadInfo

interface FetchNewsView :BaseView{

    fun showLoading(message: String)
    fun hideLoading()
    fun showMenuList(payLoadInfo: ArrayList<PayloadInfo>)
}