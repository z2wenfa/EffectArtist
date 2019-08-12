package com.z2wenfa.effectartist;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-12下午5:25
 * desc   :
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
