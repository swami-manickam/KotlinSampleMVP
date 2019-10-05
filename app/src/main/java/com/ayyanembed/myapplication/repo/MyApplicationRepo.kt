package com.ayyanembed.myapplication.repo

import com.ayyanembed.myapplication.data.GetNewsDetailResponse
import com.ayyanembed.myapplication.data.SignUpResponse
import com.ayyanembed.myapplication.utils.RxJavaUtils
import com.google.gson.JsonObject
import io.reactivex.Observable


class MyApplicationRepo(val myApplicationApi: MyApplicationApi) {


     fun getNewsInfo(consumerKey : String,consumerSecret : String): Observable<GetNewsDetailResponse> {
         return myApplicationApi.getNewsDetails(consumerKey,consumerSecret)
             .compose(RxJavaUtils.applyErrorTransformer())
     }

    fun updateWhomMayConcern(
        consumerKey: String,
        consumerSecret: String,
        whomConObject: JsonObject
    ): Observable<SignUpResponse> {
        return myApplicationApi.updateWhomMayConcern(consumerKey, consumerSecret, whomConObject)
            .flatMap {
                if (it.success.equals("true")) {
                    return@flatMap Observable.just(it)
                } else {
                    return@flatMap Observable.error<SignUpResponse>(Throwable(it.message))
                }
            }
    }

}