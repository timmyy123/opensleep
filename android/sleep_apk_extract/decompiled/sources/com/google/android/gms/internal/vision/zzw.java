package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzw {
    public static ByteBuffer zza(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((((height + 1) / 2) * ((width + 1) / 2)) << 1) + i);
        int i2 = i;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 % width;
            int i5 = i3 / width;
            int pixel = bitmap.getPixel(i4, i5);
            float fRed = Color.red(pixel);
            float fGreen = Color.green(pixel);
            float fBlue = Color.blue(pixel);
            byteBufferAllocateDirect.put(i3, (byte) ((0.114f * fBlue) + (0.587f * fGreen) + (0.299f * fRed)));
            if (i5 % 2 == 0 && i4 % 2 == 0) {
                float f = (fBlue * 0.5f) + ((-0.331f) * fGreen) + ((-0.169f) * fRed) + 128.0f;
                float f2 = fBlue * (-0.081f);
                int i6 = i2 + 1;
                byteBufferAllocateDirect.put(i2, (byte) f);
                i2 += 2;
                byteBufferAllocateDirect.put(i6, (byte) (f2 + (fGreen * (-0.419f)) + (fRed * 0.5f) + 128.0f));
            }
        }
        return byteBufferAllocateDirect;
    }
}
