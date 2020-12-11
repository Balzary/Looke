package com.looke.looke.userinterface.common;

import android.content.Context;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.looke.looke.R;

public class WsqRefresh extends SwipeRefreshLayout {

    Context oContexto = null;

    public WsqRefresh(Context context) {
        super(context);
        oContexto = context;
        this.atualizarCor();
    }

    public WsqRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
        oContexto = context;
        this.atualizarCor();
    }

    private void atualizarCor()
    {
        this.setColorSchemeColors(oContexto.getResources().getColor(R.color.color1));
    }
}
