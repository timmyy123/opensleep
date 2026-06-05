package com.google.android.gms.internal.ads;

import java.util.Objects;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzigd extends zzict {
    final zzigf zza;
    zzicv zzb;
    final /* synthetic */ zzigg zzc;

    public zzigd(zzigg zziggVar) {
        Objects.requireNonNull(zziggVar);
        this.zzc = zziggVar;
        this.zza = new zzigf(zziggVar, null);
        this.zzb = zzb();
    }

    private final zzicv zzb() {
        zzigf zzigfVar = this.zza;
        if (zzigfVar.hasNext()) {
            return zzigfVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzicv
    public final byte zza() {
        zzicv zzicvVar = this.zzb;
        if (zzicvVar == null) {
            Types$$ExternalSyntheticBUOutline0.m();
            return (byte) 0;
        }
        byte bZza = zzicvVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
