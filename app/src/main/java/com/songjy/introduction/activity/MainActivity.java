package com.songjy.introduction.activity;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.songjy.introduction.R;
import com.songjy.introduction.ui.*;

import butterknife.BindView;
import io.reactivex.Observable;

import static com.songjy.introduction.R.id.flay_main_content;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.OnFragmentInteractionListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.flay_main_content)
    FrameLayout flayMainContent;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private Fragment displayFragment;
    private FragmentManager mFragmentMan;
    private HomeFragment homeFragment;
    private ContactFragment contactFragment;
    private PreferenceFragment settingFragment;

    @Override
    public void initParams(Bundle parms) {

    }

    @Override
    public boolean isInMultiWindowMode() {
        return super.isInMultiWindowMode();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        if (mFragmentMan == null) {
            mFragmentMan = getSupportFragmentManager();
        }
        homeFragment = HomeFragment.newInstance(null, null);
        FragmentTransaction transaction = mFragmentMan.beginTransaction();
        transaction.add(R.id.flay_main_content, homeFragment).commit();
        displayFragment = homeFragment;
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // 设置按钮
        if (id == R.id.action_settings) {
            startActivity(SettingsActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            if (null == homeFragment) {
                homeFragment = HomeFragment.newInstance(null, null);
            }
            switchContent(homeFragment);
        } else if (id == R.id.nav_gallery) {
            startActivity(MapActivity.class);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            if (null == contactFragment) {
                contactFragment = new ContactFragment();
            }
            switchContent(contactFragment);
        } else if (id == R.id.nav_send) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchContent(Fragment to) {
        Observable.just(to)
                .filter(fragment -> displayFragment != fragment)
                .doOnNext(fragment -> {
                    FragmentTransaction transaction = mFragmentMan.beginTransaction();
                    transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                    if (!to.isAdded()) {    // 先判断是否被add过
                        transaction.hide(displayFragment).add(flay_main_content, fragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
                    } else {
                        transaction.hide(displayFragment).show(fragment).commit(); // 隐藏当前的fragment，显示下一个
                    }
                    displayFragment = fragment;
                });
    }

    @Override
    public void onFragmentInteraction(String uri) {

    }
}
