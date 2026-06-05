package com.urbandroid.sleep.captcha;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.urbandroid.sleep.R;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ShakeView extends View {
    private Paint p;
    private float status;

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new Paint();
        init(context);
    }

    private void init(Context context) {
        this.p.setColor(ColorUtil.i(context, R.color.tint));
        this.p.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(new Rect(0, getHeight() - Math.round(getHeight() * this.status), getWidth(), getHeight()), this.p);
    }

    public void setStatus(float f) {
        this.status = f;
    }
}
