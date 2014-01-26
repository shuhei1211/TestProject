package com.example.app.test;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class CustomIntent<T extends CustomIntent<T>> implements IntentInterface<CustomIntent<T>> {
    private final CustomIntent self = this;

    private Context mContext;
    private FragmentActivity mActivity;
    private Class<?> mClassName;

    public CustomIntent(Context context) {
        mContext = context;
    }

    public CustomIntent(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public CustomIntent<T> move(Class<?> className) {
        mClassName = className;
        return self;
    }

    @Override
    public CustomIntent<T> finish() {
        mActivity.finish();
        return self;
    }

    @Override
    public CustomIntent<T> moveActivity() {
        if (mClassName != null) {
            Intent intent = new Intent(mActivity, mClassName);
            mActivity.startActivity(intent);
        }
        return self;
    }
}
