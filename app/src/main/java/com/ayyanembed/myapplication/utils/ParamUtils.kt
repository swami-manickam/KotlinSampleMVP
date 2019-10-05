package com.ayyanembed.myapplication.utils

import com.google.gson.JsonObject

class ParamUtils {

  companion object {

    fun whomMayConParams(eid : Int, name :String, idBar :Int, emailID: String, uniNo :Int,
                         mobileNo: String): JsonObject {
      val loginObject = JsonObject()
      loginObject.addProperty("eid", eid)
      loginObject.addProperty("name", name)
      loginObject.addProperty("idbarahno", idBar)
      loginObject.addProperty("emailaddress", emailID)
      loginObject.addProperty("unifiednumber", uniNo)
      loginObject.addProperty("mobileno", mobileNo)

      return loginObject
    }


  }


}