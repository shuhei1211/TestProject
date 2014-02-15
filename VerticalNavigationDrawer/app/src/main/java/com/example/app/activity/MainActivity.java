package com.example.app.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.flagment.BaseFragment;
import com.example.app.supportwidget.VerticalDrawerLayout;

public class MainActivity extends BaseActivity {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends BaseFragment {

        // Navigation drawer appear from bottom
        private int mGravityBottom = Gravity.BOTTOM;
        // Navigation drawer appear from top
        private int mGravityTop = Gravity.TOP;

        private VerticalDrawerLayout mDrawerLayout;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            mDrawerLayout = (VerticalDrawerLayout) rootView.findViewById(R.id.drawer_layout);

            return rootView;
        }


        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            // set a custom shadow that overlays the main content when the drawer opens
            mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.TOP);

            // set DrawerLockMode
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            aq.id(R.id.button).clicked(this, "onClickMainButton");
            aq.id(R.id.top).height(50).clicked(this, "onClickTop");
            aq.id(R.id.bottom).height(50).clicked(this, "onClickBottom");
        }


        // *******************************************************************
        // onClick
        // *******************************************************************

        /**
         * center main button
         */
        public void onClickMainButton() {
            if (mDrawerLayout.isDrawerVisible(mGravityTop)) {
                mDrawerLayout.closeDrawer(mGravityTop);
            } else {
                mDrawerLayout.openDrawer(mGravityTop);
            }

            if (mDrawerLayout.isDrawerVisible(mGravityBottom)) {
                mDrawerLayout.closeDrawer(mGravityBottom);
            } else {
                mDrawerLayout.openDrawer(mGravityBottom);
            }
        }

        /**
         * navigation drawer top button
         */
        public void onClickTop() {
            Toast.makeText(getActivity(), "top", Toast.LENGTH_LONG).show();
        }

        /**
         * navigation drawer bottom button
         */
        public void onClickBottom() {
            Toast.makeText(getActivity(), "bottom", Toast.LENGTH_LONG).show();
        }
    }
}
