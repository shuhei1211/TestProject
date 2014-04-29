package jp.butterknifetest.app.controller.listener;

import android.view.View;
import android.widget.TextView;

import jp.butterknifetest.app.R;
import jp.butterknifetest.app.controller.core.CoreOnClickListener;
import jp.butterknifetest.app.model.builder.SampleDataBuilder;
import jp.butterknifetest.app.model.entity.SampleData;

public class SampleOnClickListener extends CoreOnClickListener {

    private View mView;

    public SampleOnClickListener(View view) {
        mView = view;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
//        ((TextView)mView).setText("test");
        if (mView.getId() == R.id.text) {
            new SampleDataBuilder().setTitle("aofieowajf").createSampleData();
            ((TextView)mView).setText(new SampleData().getTitle());
        }
    }
}
