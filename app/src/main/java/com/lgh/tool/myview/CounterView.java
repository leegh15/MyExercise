package com.lgh.tool.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lgh on 2016/2/3.
 */
public class CounterView extends View implements View.OnClickListener {
    private Paint paint;
    private Rect bounds;
    private String text="呵呵呵呵";
    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        bounds=new Rect();
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(24);

        paint.getTextBounds(text,0,text.length(),bounds);
        float textWidth = bounds.width();
        float textHeight = bounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, paint);
    }

    @Override
    public void onClick(View v) {
        text="吼吼吼吼";
        invalidate();
    }
}
