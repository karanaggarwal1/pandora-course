package com.example.karan.animations;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by Karan on 01-05-2017.
 */

public class CustomView extends View {
    private Paint paint;
    private int color;
    private float radius;
//    private Runnable animate = new Runnable() {
//        @Override
//        public void run() {
//            if (radius < 490) {
//                radius += 10;
//                invalidate();
//            }
//            postDelayed(this,10);
//        }
//    };

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        color = ta.getColor(R.styleable.CustomView_circleColor, Color.BLACK);
        radius=ta.getFloat(R.styleable.CustomView_circleSize,200f);
        ta.recycle();
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
//        Path path = new Path();
//        path.moveTo(200, 200);
//        path.lineTo(500, 500);
//        path.lineTo(500, 1000);
//        path.lineTo(200, 200);
//        canvas.drawPath(path, paint);
//        canvas.drawLine(200, 200, 500, 500, paint);
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(10f);
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(0.5f, 245f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 485f);
//        radius=0;-->not required in Java-initial value is zero only
//        Log.d("wkff", "init: "+radius);
//        post(animate);
        PropertyValuesHolder pvh = PropertyValuesHolder.ofKeyframe("radius", kf0, kf1, kf2);
        ValueAnimator anim = ObjectAnimator.ofPropertyValuesHolder(this, pvh);
        anim.setInterpolator(new BounceInterpolator());
//        ValueAnimator anim = ValueAnimator.ofFloat(0f, 400f);
//        anim.setDuration(200);
//        anim.start();
        anim.setDuration(2000);
        anim.start();

    }

    public void setRadius(float value) {
        this.radius = value;
        invalidate();
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }
}
