package com.shizy.coordinatorlayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

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
    @ViewById(R.id.tab_layout)
    TabLayout mTabLayout;
    @ViewById(R.id.viewpager)
    ViewPager mViewPager;

    private TabLayoutAdapter mTabLayoutAdapter;

    @AfterViews
    protected void afterViews() {
        // setTitle必须放到setSupportActionBar前面，放后面无效
        initToolBar();
        initViewPager();
        initTabLayout();
    }

    private void initToolBar() {
        mToolbar.setTitle(R.string.main_title);
        setSupportActionBar(mToolbar);

        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setSubtitle(R.string.main_sub_title);
        mToolbar.setNavigationIcon(R.drawable.menu);

        mToolbar.setNavigationOnClickListener(mOnClickListener);
        mToolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
    }

    private void initViewPager() {
        mTabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabLayoutAdapter);
    }

    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
