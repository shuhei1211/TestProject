package jp.butterknifetest.app.controller;

import android.view.View;
import android.widget.TextView;

public class SampleOnClickListener extends CoreOnClickListener {

    private View mView;

    public SampleOnClickListener(View view) {
        mView = view;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        ((TextView)mView).setText("test");
    }
}
