package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class LruCache implements Cache {
    private int evictionCount;
    private int hitCount;
    final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Max size must be positive.");
            throw null;
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size <= i || this.map.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, Bitmap> next = this.map.entrySet().iterator().next();
                    String key = next.getKey();
                    Bitmap value = next.getValue();
                    this.map.remove(key);
                    this.size -= Utils.getBitmapBytes(value);
                    this.evictionCount++;
                } finally {
                }
            }
        }
    }

    @Override // com.squareup.picasso.Cache
    public Bitmap get(String str) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("key == null");
            return null;
        }
        synchronized (this) {
            try {
                Bitmap bitmap = this.map.get(str);
                if (bitmap != null) {
                    this.hitCount++;
                    return bitmap;
                }
                this.missCount++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int maxSize() {
        return this.maxSize;
    }

    @Override // com.squareup.picasso.Cache
    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("key == null || bitmap == null");
            return;
        }
        synchronized (this) {
            try {
                this.putCount++;
                this.size += Utils.getBitmapBytes(bitmap);
                Bitmap bitmapPut = this.map.put(str, bitmap);
                if (bitmapPut != null) {
                    this.size -= Utils.getBitmapBytes(bitmapPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        trimToSize(this.maxSize);
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int size() {
        return this.size;
    }

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }
}
