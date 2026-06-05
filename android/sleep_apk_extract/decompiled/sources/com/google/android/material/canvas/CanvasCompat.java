package com.google.android.material.canvas;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CanvasCompat {

    public interface CanvasOperation {
    }

    public static int saveLayerAlpha(Canvas canvas, float f, float f2, float f3, float f4, int i) {
        return canvas.saveLayerAlpha(f, f2, f3, f4, i);
    }
}
