package com.ayyanembed.myapplication.view.login.news

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ayyanembed.myapplication.R
import com.ayyanembed.myapplication.adapter.NewsAdapter
import com.ayyanembed.myapplication.base.BaseActivity
import com.ayyanembed.myapplication.customview.ProgressDialogue
import com.ayyanembed.myapplication.data.PayloadInfo
import kotlinx.android.synthetic.main.activity_news_list.*

class FetchNewsActivity : BaseActivity<FetchNewsView, FetchNewsPresenter>(),
    NewsAdapter.ClickListener, FetchNewsView {

    var payloadInfoList = ArrayList<PayloadInfo>()
    var newsAdapter: NewsAdapter? = null

    var progressDialogue: ProgressDialogue? = null

    override var presenter: FetchNewsPresenter = FetchNewsPresenter()

    override fun getContext() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        progressDialogue = ProgressDialogue(this)

        newsAdapter = NewsAdapter(this,payloadInfoList, this)
        rv_news_list.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_news_list.adapter = newsAdapter

        presenter.getNewsList()

    }


    override fun showMenuList(payLoadInfo: ArrayList<PayloadInfo>) {
        newsAdapter?.setNewsData(payLoadInfo)
    }

    override fun showLoading(message: String) {
        progressDialogue?.showLoading(message)
    }

    override fun hideLoading() {
        progressDialogue?.hideLoading()
    }


    override fun onItemClick(model: PayloadInfo) {

    }

}