package com.google.android.gms.internal.nearby;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzf extends zzi {
    private String zza;
    private byte zzb;
    private int zzc;

    public final zzi zza(String str) {
        this.zza = "";
        return this;
    }

    public final zzi zzb(boolean z) {
        this.zzb = (byte) (this.zzb | 1);
        return this;
    }

    public final zzi zzc(boolean z) {
        this.zzb = (byte) (this.zzb | 2);
        return this;
    }

    public final zzj zzd() {
        if (this.zzb == 3 && this.zza != null && this.zzc != 0) {
            return new zzh(this.zza, false, false, null, null, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if ((this.zzb & 1) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if ((this.zzb & 2) == 0) {
            sb.append(" skipChecks");
        }
        if (this.zzc == 0) {
            sb.append(" filePurpose");
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Missing required properties:".concat(sb.toString()));
        return null;
    }

    public final zzi zze(int i) {
        this.zzc = 1;
        return this;
    }
}
