package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbhg extends PushbackInputStream {
    final /* synthetic */ zzbhj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbhg(zzbhj zzbhjVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbhjVar);
        this.zza = zzbhjVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.zza.zzc.zzb();
        super.close();
    }
}
