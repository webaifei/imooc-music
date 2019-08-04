package com.example.imooc_music.helper;

import android.widget.Toast;

import com.example.imooc_music.models.UserModel;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmHelper {
    public Realm realm;

    public RealmHelper() {
        realm = Realm.getDefaultInstance();
    }

    /**
     * 关闭引用
     */
    public void close() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }

    /**
     * 保存用户到数据库
     *
     * @param user
     */
    public void saveUser(UserModel user) {
        realm.beginTransaction();
        realm.insert(user);
        realm.commitTransaction();
        realm.close();
    }

    /**
     * 登录
     */
    public boolean login(UserModel user) {
        RealmQuery<UserModel> query = realm.where(UserModel.class);
        query = query.equalTo("phone", user.getPhone())
                .equalTo("password", user.getPassword());
        UserModel _user = query.findFirst();
        return _user != null;
    }
}
