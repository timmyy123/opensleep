package com.google.android.gms.internal.measurement;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsj implements Closeable {

    @Nullable
    private final Closeable zza;

    private zzsj(Closeable closeable) {
        this.zza = closeable;
    }

    public static zzsj zza(Closeable closeable) {
        return new zzsj(closeable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Closeable closeable = this.zza;
        if (closeable != null) {
            closeable.close();
        }
    }

    @Nullable
    public final Closeable zzb() {
        return this.zza;
    }
}
