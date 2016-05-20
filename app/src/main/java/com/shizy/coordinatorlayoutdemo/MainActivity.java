package com.shizy.coordinatorlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_test_toolbar)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @AfterViews
    protected void afterViews() {
        setSupportActionBar(mToolbar);
    }

}
