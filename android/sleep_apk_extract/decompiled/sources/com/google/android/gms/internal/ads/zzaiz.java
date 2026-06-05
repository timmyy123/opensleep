package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaiz implements zzao {
    public final long zza;

    public zzaiz(long j) {
        this.zza = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzaiz.class == obj.getClass() && this.zza == ((zzaiz) obj).zza;
    }

    public final int hashCode() {
        return Long.hashCode(this.zza) + 527;
    }

    public final String toString() {
        long j = this.zza;
        return zzba$$ExternalSyntheticOutline0.m(j, "ThumbnailMetadata: presentationTimeUs=", new StringBuilder(String.valueOf(j).length() + 38));
    }
}
