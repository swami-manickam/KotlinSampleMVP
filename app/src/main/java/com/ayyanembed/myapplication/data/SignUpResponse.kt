package com.ayyanembed.myapplication.data

import com.google.gson.JsonObject


data class SignUpResponse(
  val message: String,
  val success: String,
  val payload: JsonObject

)
