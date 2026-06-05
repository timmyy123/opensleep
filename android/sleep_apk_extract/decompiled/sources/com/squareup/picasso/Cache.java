package com.squareup.picasso;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface Cache {
    Bitmap get(String str);

    int maxSize();

    void set(String str, Bitmap bitmap);

    int size();
}
