package com.ayyanembed.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayyanembed.myapplication.R
import com.ayyanembed.myapplication.data.PayloadInfo
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_news_list.view.*

class NewsAdapter (
   var context: Context, val payLoadList: ArrayList<PayloadInfo>, var clickListener: ClickListener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return payLoadList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val payloadInfo: PayloadInfo = payLoadList.get(position)

        holder.itemView.iv_news_pic
        holder.itemView.txt_news_title.setText("Title: "+payloadInfo.title)
        holder.itemView.txt_news_date.setText("Date: "+payloadInfo.date)
        holder.itemView.txt_news_desc.setText("Description: "+payloadInfo.description)

        Glide.with(context)
            .load(payloadInfo.image)
            .apply(RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background))
            .into(holder.itemView.iv_news_pic)

    }


    fun setNewsData(newsList: ArrayList<PayloadInfo>) {
        payLoadList.clear()
        payLoadList.addAll(newsList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(
        itemView) {
        fun bindItems(add: PayloadInfo) {

        }
    }

    interface ClickListener {
        fun onItemClick(model: PayloadInfo)
    }

}