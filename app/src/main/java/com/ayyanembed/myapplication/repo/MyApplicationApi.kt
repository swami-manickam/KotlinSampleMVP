package com.ayyanembed.myapplication.repo

import com.ayyanembed.myapplication.data.GetNewsDetailResponse
import com.ayyanembed.myapplication.data.SignUpResponse
import com.google.gson.JsonObject

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MyApplicationApi {

  @POST("iskan/v1/certificates/towhomitmayconcern")
  fun updateWhomMayConcern(@Header("consumer-key") key: String,@Header("consumer-secret") secret: String,
                           @Body loginData: JsonObject): Observable<SignUpResponse>

  @GET("public/v1/news?local=en")
  fun getNewsDetails(
    @Header("consumer-key") key: String,@Header("consumer-secret") secret: String
  ): Observable<GetNewsDetailResponse>
}