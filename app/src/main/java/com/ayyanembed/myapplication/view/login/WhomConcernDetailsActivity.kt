package com.ayyanembed.myapplication.view.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.ayyanembed.myapplication.R
import com.ayyanembed.myapplication.base.BaseActivity
import com.ayyanembed.myapplication.customview.ProgressDialogue
import com.ayyanembed.myapplication.data.SignUpResponse
import com.ayyanembed.myapplication.utils.UiUtils
import com.ayyanembed.myapplication.view.login.news.FetchNewsActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*


class WhomConcernDetailsActivity :
    BaseActivity<WhomConcernDetailsView, WhomConcernDetailsPresenter>(), View.OnClickListener,
    WhomConcernDetailsView {


    override var presenter: WhomConcernDetailsPresenter = WhomConcernDetailsPresenter()

    var progressDialogue: ProgressDialogue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressDialogue = ProgressDialogue(this)
        presenter.attachView(this)


        btn_sign_in.setOnClickListener(this)


    }

    override fun showLoading(message: String) {
        progressDialogue?.showLoading(message)
    }

    override fun hideLoading() {
        progressDialogue?.hideLoading()
    }

    override fun getContext(): Context = this

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_sign_in -> validateLogin()
        }
    }

    private fun validateLogin() {
        val eid = et_eid.text.toString().trim()
        val name = et_name.text.toString().trim()
        val idBarNo = et_idbarahno.text.toString().trim()
        val emailId = et_email_id.text.toString().trim()
        val uniNo = et_unified_no.text.toString().trim()
        val mobileNo = et_mob_no.text.toString().trim()

        if (TextUtils.isEmpty(eid)) {
            UiUtils.showSnackBar(et_eid, getString(R.string.msg_empty_email_id),
                Snackbar.LENGTH_SHORT)
            return
        }
        if (TextUtils.isEmpty(name)) {
            UiUtils.showSnackBar(et_name, getString(R.string.msg_empty_name),
                Snackbar.LENGTH_SHORT)
            return
        }

        if (TextUtils.isEmpty(idBarNo)) {
            UiUtils.showSnackBar(et_idbarahno, getString(R.string.msg_empty_idbarahno),
                Snackbar.LENGTH_SHORT)
            return
        }

        if (TextUtils.isEmpty(emailId)) {
            UiUtils.showSnackBar(et_eid, getString(R.string.msg_empty_email_id),
                Snackbar.LENGTH_SHORT)
            return
        }

        if (TextUtils.isEmpty(uniNo)) {
            UiUtils.showSnackBar(et_eid, getString(R.string.msg_empty_uni_no),
                Snackbar.LENGTH_SHORT)
            return
        }

        if (TextUtils.isEmpty(mobileNo)) {
            UiUtils.showSnackBar(et_eid, getString(R.string.msg_empty_mob_no),
                Snackbar.LENGTH_SHORT)
            return
        }
        presenter.whomMayConcern(eid.toInt(), name,idBarNo.toInt(),emailId,uniNo.toInt(),mobileNo)
    }


    override fun navigateToHome(details: SignUpResponse) {
        startActivity(Intent(this, FetchNewsActivity::class.java))
        finish()
    }

}
