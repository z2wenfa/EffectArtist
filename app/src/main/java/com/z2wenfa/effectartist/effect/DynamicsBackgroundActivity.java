package com.z2wenfa.effectartist.effect;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.z2wenfa.effectartist.R;
import com.z2wenfa.effectartist.wiget.DynamicBakckgroudView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-15上午10:43
 * desc   :　动态背景　(ObjectAnimator实现)
 */
public class DynamicsBackgroundActivity extends AppCompatActivity {

    @BindView(R.id.dynamicBackgroud)
    DynamicBakckgroudView dynamicBackgroudView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamicbackground);
        ButterKnife.bind(this);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(dynamicBackgroudView, "backgroudScale", 0.0f, 1f, 0.0f);
        objectAnimator.setDuration(10000).setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.start();
    }
}
