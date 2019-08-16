package com.z2wenfa.effectartist.effect;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.z2wenfa.effectartist.R;
import com.z2wenfa.effectartist.wiget.WaterWaveView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.animation.ValueAnimator.REVERSE;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-16下午4:03
 * desc   :
 */
public class WaterWaveActivity extends AppCompatActivity {

    @BindView(R.id.waterWave)
    WaterWaveView waterWaveView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_wave);
        ButterKnife.bind(this);

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(waterWaveView, "changedRadius", 0, 100);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(REVERSE);
        objectAnimator.setDuration(3000).start();

    }
}
