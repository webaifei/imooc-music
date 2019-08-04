package com.example.imooc_music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.example.imooc_music.R;
import com.example.imooc_music.helper.RealmHelper;
import com.example.imooc_music.models.UserModel;
import com.example.imooc_music.views.InputView;

import java.util.logging.StreamHandler;

import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RegistActivity extends BaseActivity {

    private InputView phoneView;

    private InputView pwdView;

    private InputView surePwdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        initNavgationBar(true, "注册", false);
        phoneView = findViewById(R.id.phone);
        pwdView = findViewById(R.id.pwd);
        surePwdView = findViewById(R.id.sure_pwd);
    }

    /**
     * 注册逻辑
     * @param view
     */
    public void regist(View view) {
        // 数据校验
        String phoneNum = phoneView.getInputVal();
        String pwd = pwdView.getInputVal();
        String surePwdVal = surePwdView.getInputVal();

        Log.d("geinihua", phoneNum);
        Log.d("geinihua", pwd);
        if(!RegexUtils.isMobileSimple(phoneNum)) {
            Toast.makeText(this, "手机号无效", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(surePwdVal)) {
            Toast.makeText(this, "请确认密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!surePwdVal.equals(pwd)) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        // 接口请求
        // 保存到realm
        UserModel user = new UserModel();
        user.setPhone(phoneNum);
        user.setPassword(EncryptUtils.encryptMD5ToString(pwd));

        RealmHelper realmHelper = new RealmHelper();
        RealmQuery<UserModel> query = realmHelper.realm.where(UserModel.class);
        query.equalTo("phone", user.getPhone());
        RealmResults<UserModel> results = query.findAll();
        if(results.size() > 0) {
            Toast.makeText(this, "该号码已注册", Toast.LENGTH_LONG).show();
            return;
        }
        realmHelper.saveUser(user);
        // 路由跳转
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
