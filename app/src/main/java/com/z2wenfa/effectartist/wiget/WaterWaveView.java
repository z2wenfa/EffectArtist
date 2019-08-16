package com.z2wenfa.effectartist.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-16下午12:48
 * desc   :　水波扩散(ObjectAnimator)
 */
public class WaterWaveView extends View {

    Paint paint;

    int radius;
    int centerX;
    int centerY;

    private int changedRadius = 0;

    public int getChangedRadius() {
        return changedRadius;
    }

    public void setChangedRadius(int changedRadius) {
        this.changedRadius = changedRadius;
        postInvalidate();
    }

    public WaterWaveView(Context context) {
        super(context);
        init();
    }

    public WaterWaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        paint = new Paint();
        radius = 60;
        centerX = ScreenUtils.getScreenWidth() / 2;
        centerY = ScreenUtils.getScreenHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 5; i++) {
            paint.setColor(Color.argb(255, 0, 0, 255 - 15 * i));
            canvas.drawCircle(centerX, centerY, 400 - radius * (i + 1) + changedRadius, paint);
        }
    }
}
