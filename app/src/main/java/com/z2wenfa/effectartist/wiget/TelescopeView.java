package com.z2wenfa.effectartist.wiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.z2wenfa.effectartist.R;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-12下午5:30
 * desc   : 望远镜效果View (主要是使用BitmapShader)
 */
public class TelescopeView extends View {

    private Paint paint;
    private BitmapShader bitmapShader;

    private float circleCenterX = -1;
    private float circleCenterY = -1;

    public TelescopeView(Context context) {
        super(context);
        init();
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TelescopeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(bitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (circleCenterY != -1 || circleCenterX != -1)
            canvas.drawCircle(circleCenterX, circleCenterY, 300, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                circleCenterX = event.getX();
                circleCenterY = event.getY();
                postInvalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                circleCenterX = event.getX();
                circleCenterY = event.getY();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                circleCenterX = -1;
                circleCenterY = -1;
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
