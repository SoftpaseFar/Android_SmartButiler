package com.goo1e.smartbutiler.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * SecondBezier详细展示
 * Created by SoftpaseFar on 2017/4/9.
 */

public class SecondBezier extends View {

    //起始坐标
    private float mStartPointX;
    private float mStartPointY;

    //终点坐标
    private float mEndPointX;
    private float mEndPointY;

    //控制点坐标
    private float mFlagPointX;
    private float mFlagPointY;

    private Path mPath;

    private Paint mPaintSecondBezier;
    private Paint mPaintPointAndLine;


    public SecondBezier(Context context) {
        super(context);
    }

    public SecondBezier(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaintSecondBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
        //mPaintSecondBezier.setColor();
        mPaintSecondBezier.setStrokeWidth(10);
        mPaintSecondBezier.setStyle(Paint.Style.STROKE);

        mPaintPointAndLine= new Paint(Paint.ANTI_ALIAS_FLAG);
        //mPaintSecondBezier.setColor();
        mPaintPointAndLine.setStrokeWidth(3);
        mPaintPointAndLine.setStyle(Paint.Style.STROKE);
    }

    public SecondBezier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SecondBezier(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mStartPointX = w / 4;
        mStartPointY = h / 2 - 200;

        mEndPointX = w * 3 / 4;
        mEndPointY = h / 2 - 200;

        mFlagPointX = w / 2;
        mFlagPointY = h / 2 - 300;

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPoint(mFlagPointX,mFlagPointY,mPaintPointAndLine);
        canvas.drawText("★",mFlagPointX,mFlagPointY,mPaintSecondBezier);
        canvas.drawLine(mStartPointX,mStartPointY,mFlagPointX,mFlagPointY,mPaintPointAndLine);
        canvas.drawLine(mEndPointX,mEndPointY,mFlagPointX,mFlagPointY,mPaintPointAndLine);

        mPath.reset();
        mPath.moveTo(mStartPointX,mStartPointY);
        mPath.quadTo(mFlagPointX,mFlagPointY,mEndPointX,mEndPointY);
        canvas.drawPath(mPath,mPaintSecondBezier);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mFlagPointX = event.getX();
                mFlagPointY = event.getY();
                invalidate();
                break;
        }
        return true;
    }
}
