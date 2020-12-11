package com.looke.looke.userinterface.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.looke.looke.R;


public class WsqLoading extends ProgressBar {

    public WsqLoading(Context context) {
        super(context);

        this.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.color1), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public WsqLoading(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.color1), android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public WsqLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.color1), android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
