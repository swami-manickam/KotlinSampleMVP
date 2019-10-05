package com.ayyanembed.myapplication.customview;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogue extends ProgressDialog {

  Context mContext;
  ProgressDialogue dialog;

  public ProgressDialogue(Context context) {
    super(context);
    this.mContext = context;
  }

  public ProgressDialogue showLoading(String message) {
    dialog = new ProgressDialogue(mContext);
    dialog.setMessage(message);
    dialog.setCancelable(false);
    dialog.show();
    return dialog;
  }

  public ProgressDialogue hideLoading() {
    if (dialog != null) {
      dialog.dismiss();
    }
    return dialog;
  }
}
