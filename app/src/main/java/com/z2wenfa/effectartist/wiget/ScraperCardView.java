package com.z2wenfa.effectartist.wiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.z2wenfa.effectartist.R;

/**
 * author : z2wenfa
 * e-mail : z2wenfa@163.com
 * date   : 19-8-15下午6:47
 * desc   :
 */
public class ScraperCardView extends View {

    Paint paint;

    Path path;

    Bitmap bitmap;

    boolean firstShow = true;

    public ScraperCardView(Context context) {
        super(context);
        init();
    }

    public ScraperCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        paint.setAlpha(1);
        paint.setStrokeWidth(40);

        path = new Path();

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
        bitmap = ImageUtils.scale(bitmap, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (firstShow) {
            paint.setColor(Color.DKGRAY);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), paint);
        } else {
            canvas.drawBitmap(bitmap, getLeft(), getTop(), null);
        }

        int count = canvas.saveLayer(getLeft(), getTop(), getRight(), getBottom(), paint);

        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawPath(path, paint);

        paint.setXfermode(null);

        canvas.restoreToCount(count);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                firstShow = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
