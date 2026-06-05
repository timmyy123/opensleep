package com.google.android.gms.internal.clearcut;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzbg {
    private final byte[] buffer;
    private final zzbn zzfo;

    private zzbg(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzfo = zzbn.zzc(bArr);
    }

    public final zzbb zzad() {
        if (this.zzfo.zzag() == 0) {
            return new zzbi(this.buffer);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Did not write as much data as expected.");
        return null;
    }

    public final zzbn zzae() {
        return this.zzfo;
    }

    public /* synthetic */ zzbg(int i, zzbc zzbcVar) {
        this(i);
    }
}
