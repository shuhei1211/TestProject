package com.example.app.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;

import com.androidquery.AQuery;
import com.example.app.ApplicationController;
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/consola.ttf");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
