package com.z2wenfa.effectartist.effect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.z2wenfa.effectartist.R;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-12下午4:46
 * desc   :　"望远镜效果"
 */
@Route(path = "/effect/telescope")
public class TelescopeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telescope);
    }
}
