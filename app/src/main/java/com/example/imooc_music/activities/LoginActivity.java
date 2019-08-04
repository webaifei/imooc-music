package com.example.imooc_music.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.example.imooc_music.R;
import com.example.imooc_music.helper.RealmHelper;
import com.example.imooc_music.models.UserModel;
import com.example.imooc_music.views.InputView;

public class LoginActivity extends BaseActivity {

    private InputView phoneView;

    private InputView pwdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        initNavgationBar(false, "登录", false);
        phoneView = findViewById(R.id.phone);
        pwdView = findViewById(R.id.pwd);
    }

    /**
     * 跳转到注册页
     * @param view
     */
    public void routerRegist(View view) {
        Intent intent = new Intent(this, RegistActivity.class);
        startActivity(intent);
//        finish();
    }

    /**
     * 登录逻辑
     * @param view
     */
    public void login(View view) {
        // 数据校验
        String phoneNum = phoneView.getInputVal();
        String pwd = pwdView.getInputVal();
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
        // 接口请求
        // 数据库查询
        UserModel user = new UserModel();
        user.setPhone(phoneNum);
        user.setPassword(EncryptUtils.encryptMD5ToString(pwd));

        RealmHelper realmHelper = new RealmHelper();
        boolean isLogin = realmHelper.login(user);
        if(!isLogin) {
            Toast.makeText(this, "用户或者密码不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        // 路由跳转
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
