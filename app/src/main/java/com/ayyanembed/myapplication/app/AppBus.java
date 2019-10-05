package com.ayyanembed.myapplication.app;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

public class AppBus extends Bus {

  private final Handler mainThreadHandler;

  public AppBus() {
    mainThreadHandler = new Handler(Looper.getMainLooper());
  }

  @Override public void post(Object event) {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      mainThreadHandler.post(() -> post(event));
    } else {
      super.post(event);
    }
  }
}
