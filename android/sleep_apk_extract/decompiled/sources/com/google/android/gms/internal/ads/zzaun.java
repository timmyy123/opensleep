package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaun extends zzimf implements Closeable {
    static {
        zzimm.zzb(zzaun.class);
    }

    public zzaun(zzimg zzimgVar, zzaum zzaumVar) {
        zzd(zzimgVar, zzimgVar.zzb(), zzaumVar);
    }

    @Override // com.google.android.gms.internal.ads.zzimf, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzimf
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(7, string));
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
