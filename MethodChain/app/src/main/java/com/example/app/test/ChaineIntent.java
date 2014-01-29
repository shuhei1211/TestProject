package com.example.app.test;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class ChaineIntent<T extends ChaineIntent<T>> implements ChaineIntentInterface<ChaineIntent<T>> {
    private final ChaineIntent self = this;

    private Context mContext;
    private FragmentActivity mActivity;
    private Class<?> mClassName;

    public ChaineIntent(Context context) {
        mContext = context;
    }

    public ChaineIntent(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public ChaineIntent<T> move(Class<?> className) {
        mClassName = className;
        return self;
    }

    @Override
    public ChaineIntent<T> finish() {
        mActivity.finish();
        return self;
    }

    @Override
    public ChaineIntent<T> moveActivity() {
        if (mClassName != null) {
            Intent intent = new Intent(mActivity, mClassName);
            mActivity.startActivity(intent);
        }
        return self;
    }
}
