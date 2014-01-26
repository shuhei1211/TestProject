package com.example.app.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.example.app.controller.ApplicationController;
import com.nostra13.universalimageloader.core.ImageLoader;

public abstract class BaseActivity extends FragmentActivity {
    
    // *******************************************************************
    // Constants
    // *******************************************************************
    public static final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int MP = ViewGroup.LayoutParams.MATCH_PARENT;

    // *******************************************************************
    // Declaration
    // *******************************************************************
    protected ApplicationController app = new ApplicationController();
    protected AQuery aq = new AQuery(this);
    protected ImageLoader mImageLoader = ImageLoader.getInstance();
    protected static Intent sIntent = new Intent();
    protected Typeface mTypeface;

    // *******************************************************************
    // LifeCycle
    // *******************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/consola.ttf");
    }

    // *******************************************************************
    // Abstract Method
    // *******************************************************************
    /**
     * initialize
     * you must do callback in onCreate
     */
    protected abstract void $initialize();
}
