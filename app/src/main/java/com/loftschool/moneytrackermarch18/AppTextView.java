package com.loftschool.moneytrackermarch18;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by melcore on 12/03/2018.
 */

public class AppTextView extends View {
    public AppTextView(Context context) {
        super(context);
    }

    public AppTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AppTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AppTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
