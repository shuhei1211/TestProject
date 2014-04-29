package jp.butterknifetest.app.view.layout;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.romainpiel.michelangelo.InflateLayout;
import com.romainpiel.michelangelo.InjectViews;

import butterknife.InjectView;
import butterknife.OnClick;
import jp.butterknifetest.app.R;

@InflateLayout(R.layout.fragment_main)
@InjectViews
public class SampleView extends LinearLayout {

    @InjectView(R.id.text)TextView mTextView;
    @InjectView(R.id.button)Button mButton;

    @OnClick(R.id.button)
    public void onClick() {
        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
    }

    public SampleView(Context context) {
        super(context);
    }

    public void bind() {
        mTextView.setText("test_mvc!!");
    }
}
