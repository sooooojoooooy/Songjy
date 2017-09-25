package com.songjy.introduction.ui;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.songjy.introduction.R;
import com.songjy.introduction.common.C;
import com.songjy.introduction.common.Keys;
import com.songjy.introduction.common.utils.ContactManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactFragment extends BaseFragment {


    @Bind(R.id.btn_qq_contact)
    CardView btnQqContact;
    @Bind(R.id.btn_wechat_contact)
    CardView btnWechatContact;
    @Bind(R.id.btn_sms_contact)
    CardView btnSmsContact;
    @Bind(R.id.btn_phone_contact)
    CardView btnPhoneContact;
    @Bind(R.id.btn_email_contact)
    CardView btnEmailContact;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contact;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @OnClick({R.id.btn_qq_contact, R.id.btn_wechat_contact, R.id.btn_sms_contact, R.id.btn_phone_contact, R.id.btn_email_contact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_qq_contact:
                if (!ContactManager.sendQQMsg(getContext(), C.QQ))
                    showSnackbar(getView(), getString(R.string.warning_qq_not_installed));
                break;
            case R.id.btn_wechat_contact:
                break;
            case R.id.btn_sms_contact:
                ContactManager.sendSMS(getContext(), C.PHONE, "");
                break;
            case R.id.btn_phone_contact:
                // 检查是否获得了权限（Android6.0运行时权限）
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 没有获得授权，申请授权
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {
                        // 返回值：
                        //如果app之前请求过该权限,被用户拒绝, 这个方法就会返回true.
                        //如果用户之前拒绝权限的时候勾选了对话框中”Don’t ask again”的选项,那么这个方法会返回false.
                        //如果设备策略禁止应用拥有这条权限, 这个方法也返回false.
                        // 弹窗需要解释为何需要该权限，再次请求授权
                        Snackbar.make(getView(), getString(R.string.dont_have_call_permission), Snackbar.LENGTH_LONG)
                                .setAction(getString(R.string.confirm), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        // 帮跳转到该应用的设置界面，让用户手动授权
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getContext().getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                    }
                                }).show();
                    } else {
                        // 不需要解释为何需要该权限，直接请求授权
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, Keys.MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    }
                } else {
                    ContactManager.phoneCall(getContext(), C.PHONE);
                }
                break;
            case R.id.btn_email_contact:

                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)) {
            for (String permission : permissions) {
                if (Manifest.permission.CALL_PHONE.equals(permission)) {
                    ContactManager.phoneCall(getContext(), C.PHONE);
                }
            }
        }
    }
}
