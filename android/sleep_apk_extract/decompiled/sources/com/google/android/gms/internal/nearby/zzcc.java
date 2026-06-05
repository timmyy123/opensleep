package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcc {
    private final String zza;
    private final long zzb;

    public zzcc(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcc) {
            zzcc zzccVar = (zzcc) obj;
            if (Objects.equal(this.zza, zzccVar.zza)) {
                if (Objects.equal(Long.valueOf(this.zzb), Long.valueOf(zzccVar.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb));
    }

    public final String zza() {
        return this.zza;
    }
}
