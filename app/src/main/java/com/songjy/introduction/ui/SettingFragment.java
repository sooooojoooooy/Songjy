package com.songjy.introduction.ui;


import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.songjy.introduction.R;
import com.songjy.introduction.activity.MainActivity;
import com.songjy.introduction.activity.SettingsActivity;
import com.songjy.introduction.activity.SplashActivity;
import com.songjy.introduction.common.C;
import com.songjy.introduction.common.Keys;
import com.songjy.introduction.common.utils.BasePreference;
import com.songjy.introduction.common.utils.FileSizeUtil;
import com.songjy.introduction.common.utils.LanguageManager;
import com.songjy.introduction.common.utils.PreferenceUtils;

import java.util.Locale;

import static com.songjy.introduction.common.utils.LanguageManager.changeLanguage;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends PreferenceFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListPreference preLanguage;
    private Preference preClearCache;
    private Context mContext;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        addPreferencesFromResource(R.xml.setting);
        mContext = getContext();
        initView(mContext);
    }

    private void initView(final Context context) {
        preLanguage = (ListPreference) findPreference(Keys.LANGUAGE_PREFERENCE);
        preClearCache = findPreference(Keys.SETTING_PRE_CLEAR_CACHE);
        preClearCache.setSummary(FileSizeUtil.getAutoFileOrFilesSize(C.NET_CACHE));
        preLanguage.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    LanguageManager.changeLanguage(getActivity().getApplicationContext()
                            , o.toString());
                    PreferenceUtils.setLanguage(o.toString());
                    restartApplication();
                }
                return true;
            }
        });
        preClearCache.setOnPreferenceClickListener(preference -> {
            preClearCache.setSummary("0B");
            Snackbar.make(getView(), getString(R.string.clean_up_finished), Snackbar.LENGTH_SHORT).show();
            return true;
        });
    }
    private void restartApplication() {
        Intent intent = new Intent(getActivity(), SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getActivity().startActivity(intent);
        // 杀掉进程
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
