package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
final class zac implements Runnable {
    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        throw null;
    }
}
