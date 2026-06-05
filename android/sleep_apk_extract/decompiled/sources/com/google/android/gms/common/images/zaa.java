package com.google.android.gms.common.images;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
final class zaa implements Runnable {
    private final Uri zab;
    private final AssetFileDescriptor zac;

    public zaa(ImageManager imageManager, Uri uri, AssetFileDescriptor assetFileDescriptor) {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmapDecodeStream;
        boolean z;
        Bitmap bitmap;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        AssetFileDescriptor assetFileDescriptor = this.zac;
        boolean z2 = false;
        if (assetFileDescriptor != null) {
            try {
                FileInputStream fileInputStreamCreateInputStream = assetFileDescriptor.createInputStream();
                if (fileInputStreamCreateInputStream != null) {
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamCreateInputStream);
                    } catch (Throwable th) {
                        try {
                            fileInputStreamCreateInputStream.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } else {
                    bitmapDecodeStream = null;
                }
                if (fileInputStreamCreateInputStream != null) {
                    try {
                        fileInputStreamCreateInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        Log.e("ImageManager", "Error loading bitmap for uri: ".concat(String.valueOf(this.zab)), e);
                        z2 = e instanceof OutOfMemoryError;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        Log.e("ImageManager", "Error loading bitmap for uri: ".concat(String.valueOf(this.zab)), e);
                        z2 = e instanceof OutOfMemoryError;
                    }
                }
            } catch (IOException | OutOfMemoryError e3) {
                e = e3;
                bitmapDecodeStream = null;
            }
            z = z2;
            bitmap = bitmapDecodeStream;
        } else {
            z = false;
            bitmap = null;
        }
        new zac(null, this.zab, bitmap, z, new CountDownLatch(1));
        throw null;
    }
}
