package com.songjy.introduction.activity;

import android.content.Context;
import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.songjy.introduction.R;
import com.songjy.introduction.ui.BaseFragment;
import com.songjy.introduction.ui.SettingFragment;

public class SettingsActivity extends BaseActivity {

    @Override
    public void initParams(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getFragmentManager().beginTransaction().replace(R.id.flay_setting_content, new SettingFragment()).commit();
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
