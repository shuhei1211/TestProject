package jp.butterknifetest.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.romainpiel.michelangelo.InflateLayout;
import com.romainpiel.michelangelo.InjectViews;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    @InflateLayout(R.layout.fragment_main)
    @InjectViews
    public static class PlaceholderFragment extends Fragment {

        @InjectView(R.id.text)
        TextView mTextView;

        @InjectView(R.id.button)
        Button mButton;

        @OnClick(R.id.button)
        public void onClick() {
            mTextView.setText("butter knife test");
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // initiarize ButterKnife
            ButterKnife.inject(this, rootView);
            return rootView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ButterKnife.reset(this);
        }
    }
}
