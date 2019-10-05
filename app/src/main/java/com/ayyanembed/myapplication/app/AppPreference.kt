package com.ayyanembed.myapplication.app

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.Collections

class AppPreference {


  private val PREF_IS_LOGGED_IN = "IS_LOGGED_IN"
  private val PREF_SESSTOKEN = "SESS_TOKEN"

  private var mSharedPreferences: SharedPreferences? = null
  private val PREF_USER_SITE = "USER_SITE"
  private var context: Context? = null

  constructor(context: Context) {
    mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
  }

  fun getLoginStatus(): Boolean {
    return mSharedPreferences!!.getBoolean(PREF_IS_LOGGED_IN, false)
  }

  fun setLoginStatus(status: Boolean) {
    mSharedPreferences!!.edit().putBoolean(PREF_IS_LOGGED_IN, status).apply()
  }

  fun clearAll() {

    mSharedPreferences!!.edit().clear().apply()
  }

}