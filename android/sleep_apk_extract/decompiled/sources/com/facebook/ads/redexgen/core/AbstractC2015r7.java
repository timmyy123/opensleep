package com.facebook.ads.redexgen.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.r7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2015r7 {
    public static final Point A00 = new Point();

    public static boolean A00(View view, Rect rect, Rect rect2, Rect rect3) {
        if (!view.isShown()) {
            rect.setEmpty();
            rect2.setEmpty();
            return false;
        }
        if (!view.getGlobalVisibleRect(rect, A00)) {
            rect2.setEmpty();
            rect.setEmpty();
            return false;
        }
        if (!rect.intersect(rect3)) {
            rect2.setEmpty();
            rect.setEmpty();
            return false;
        }
        rect2.set(A00.x, A00.y, A00.x + view.getWidth(), A00.y + view.getHeight());
        return true;
    }
}
