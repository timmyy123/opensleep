package com.google.android.gms.internal.nearby;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
final class zzpn extends zzpl {
    private final Object zza;

    public zzpn(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzpn) {
            return this.zza.equals(((zzpn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m("Optional.of(", this.zza.toString(), ")");
    }

    @Override // com.google.android.gms.internal.nearby.zzpl
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzpl
    public final boolean zzb() {
        return true;
    }
}
