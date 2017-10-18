package com.songjy.introduction.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by songjiyuan on 17/9/19.
 */

public abstract class BaseFragment extends Fragment {
    public OnFragmentInteractionListener mListener;

    public BaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this,view);
        initView(view, savedInstanceState);
        return view;
    }

    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String uri);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mListener = null;
    }

    public void showSnackbar(View view,String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
