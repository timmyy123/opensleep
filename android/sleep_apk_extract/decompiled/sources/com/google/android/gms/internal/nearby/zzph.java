package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
final class zzph extends zzpl {
    static final zzph zza = new zzph();

    private zzph() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.nearby.zzpl
    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.nearby.zzpl
    public final boolean zzb() {
        return false;
    }
}
