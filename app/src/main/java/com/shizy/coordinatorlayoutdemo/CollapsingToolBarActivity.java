package com.shizy.coordinatorlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_collapsing_toolbar)
public class CollapsingToolBarActivity extends AppCompatActivity {

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "OnClick NavigationButton", Toast.LENGTH_SHORT).show();
        }
    };

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @AfterViews
    protected void afterViews() {
        // setTitle必须放到setSupportActionBar前面，放后面无效
        initToolBar();
    }

    private void initToolBar() {
        mToolbar.setTitle(R.string.hobbit);
        setSupportActionBar(mToolbar);

        mToolbar.setSubtitle(R.string.main_sub_title);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_36dp);

        mToolbar.setNavigationOnClickListener(mOnClickListener);
        mToolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_collapsing_toolbar, menu);
        return true;
    }
}
