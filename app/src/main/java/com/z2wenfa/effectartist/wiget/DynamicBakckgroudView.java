package com.z2wenfa.effectartist.wiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.z2wenfa.effectartist.R;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-15上午11:08
 * desc   :
 */
public class DynamicBakckgroudView extends View {

    Paint paint = new Paint();

    Bitmap bitmap;

    Matrix matrix;

    int centerX;

    int centerY;

    /**
     * 背景图片的缩放比例
     */
    private float backgroudScale = 0.1f;

    public DynamicBakckgroudView(Context context) {
        super(context);
        init();
    }

    public DynamicBakckgroudView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
        bitmap = ImageUtils.scale(bitmap, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
        centerX = ScreenUtils.getScreenWidth() / 2;
        centerY = ScreenUtils.getScreenHeight() / 2;
    }


    public float getBackgroudScale() {
        return backgroudScale;
    }

    public void setBackgroudScale(float backgroudScale) {
        this.backgroudScale = backgroudScale + 1;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.scale(backgroudScale, backgroudScale, centerX, centerY);
        canvas.drawBitmap(bitmap, matrix, paint);
    }
}
