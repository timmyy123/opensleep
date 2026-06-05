package com.urbandroid.sleep.gui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"drawTopRoundRect", "", "Landroid/graphics/Canvas;", "rect", "Landroid/graphics/RectF;", "radius", "", "paint", "Landroid/graphics/Paint;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CanvasExKt {
    public static final void drawTopRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
        canvas.getClass();
        rectF.getClass();
        paint.getClass();
        canvas.drawRoundRect(rectF, f, f, paint);
        canvas.drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom + f, paint);
    }
}
