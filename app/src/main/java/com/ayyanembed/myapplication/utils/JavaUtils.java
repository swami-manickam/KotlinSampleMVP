package com.ayyanembed.myapplication.utils;

import android.net.Uri;
import androidx.collection.SparseArrayCompat;

import java.util.ArrayList;
import java.util.List;

public class JavaUtils {
  public static List<String> convertUrisToStrings(List<Uri> uris) {
    if (uris == null) {
      return null;
    }

    List<String> stringList = new ArrayList<>(uris.size());

    for (int i = 0, urisSize = uris.size(); i < urisSize; i++) {
      Uri uri = uris.get(i);
      stringList.add(convertUriToString(uri));
    }
    return stringList;
  }

  public static String convertUriToString(Uri uri) {
    if (uri == null) {
      return null;
    }
    return uri.toString();
  }

  public static Uri convertStringToUri(String stringUri) {
    if (stringUri == null) {
      return null;
    }
    return Uri.parse(stringUri);
  }

  public static boolean isNullOrEmpty(List list) {
    return list == null || list.isEmpty();
  }

  public static boolean mapStringIntToBoolean(String stringInt, boolean defaultValue) {
    return stringInt != null ? stringInt.trim().equals("1") : defaultValue;
  }

  public static <C> List<C> asList(SparseArrayCompat<C> sparseArray) {
    if (sparseArray == null) return null;
    List<C> arrayList = new ArrayList<>(sparseArray.size());
    for (int i = 0, size = sparseArray.size(); i < size; i++) {
      arrayList.add(sparseArray.valueAt(i));
    }
    return arrayList;
  }
}
