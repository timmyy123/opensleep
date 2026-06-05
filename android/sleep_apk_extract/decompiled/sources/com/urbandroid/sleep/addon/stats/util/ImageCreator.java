package com.urbandroid.sleep.addon.stats.util;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageCreator {
    public static byte[] convertBitmapIntoPNGBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 1, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
