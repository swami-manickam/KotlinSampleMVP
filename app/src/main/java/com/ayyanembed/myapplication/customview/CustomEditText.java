package com.ayyanembed.myapplication.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

import com.ayyanembed.myapplication.utils.CommonUtils;


public class CustomEditText extends AppCompatEditText {

  ActionMode.Callback callback = new ActionMode.Callback() {
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
      mode.setTitle("");
      return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
      return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
      return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
  };
  private Context context;
  private Drawable backgroundDrawable;

  public CustomEditText(Context context, AttributeSet attributeSet) {
    this(context, attributeSet, 0);
    this.context = context;
    init(attributeSet);
  }

  public CustomEditText(Context context) {
    this(context, null);
    this.context = context;
  }

  public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    this.context = context;
    this.setCustomSelectionActionModeCallback(callback);
    init(attrs);
  }

  public void init(AttributeSet attrs) {
    TypedArray attributes =
        context.obtainStyledAttributes(attrs, new int[] {android.R.attr.background});
    this.backgroundDrawable = attributes.getDrawable(0);
    attributes.recycle();
  }

  public void setMaxLength(int maxLength) {
    this.setFilters(
        new InputFilter[] {CommonUtils.EMOJI_FILTER, new InputFilter.LengthFilter(maxLength)});
  }

  @Override
  public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
    super.setCustomSelectionActionModeCallback(actionModeCallback);
  }

  @Override
  public void setBackgroundResource(@DrawableRes int resId) {
    this.backgroundDrawable = ContextCompat.getDrawable(context, resId);
    super.setBackgroundResource(resId);
  }

  @Override
  public Drawable getBackground() {
    if (backgroundDrawable != null) {
      return backgroundDrawable;
    } else {
      return super.getBackground();
    }
  }
}
