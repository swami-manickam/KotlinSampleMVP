package com.ayyanembed.myapplication.utils;

import android.graphics.Bitmap;
import android.text.InputFilter;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class CommonUtils {

  public static final String BASE64PREFIX = "data:image/jpeg;base64,";

  public static String encodeimage(Bitmap bitmap) {
    String encodedImage = null;
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
      byte[] b = baos.toByteArray();
      encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return BASE64PREFIX + encodedImage.replaceAll("\n", "");
  }

  public static final InputFilter EMOJI_FILTER = (source, start, end, dest, dstart, dend) -> {
    for (int index = start; index < end; index++) {

      int type = Character.getType(source.charAt(index));

      if (type == Character.SURROGATE) {
        return "";
      }
    }
    return null;
  };
}
