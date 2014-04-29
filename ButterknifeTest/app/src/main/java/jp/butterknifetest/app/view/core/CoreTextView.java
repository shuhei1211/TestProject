package jp.butterknifetest.app.view.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CoreTextView extends TextView {
    private final CoreTextView self = this;

    public CoreTextView(Context context) {
        super(context);
    }

    public CoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CoreTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
