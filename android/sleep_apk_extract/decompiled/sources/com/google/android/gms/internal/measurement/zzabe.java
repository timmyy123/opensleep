package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabe {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final Comparator zzb = new zzaax();
    private static final zzabe zzc = new zzabe(new zzabc(Collections.EMPTY_LIST));
    private final zzabc zzd;

    private zzabe(zzabc zzabcVar) {
        this.zzd = zzabcVar;
    }

    public static zzabe zza() {
        return zzc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzabe) && ((zzabe) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return ~this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd.toString();
    }

    public final Map zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zzd.isEmpty();
    }

    public final zzabe zzd(zzabe zzabeVar) {
        zzabc zzabcVar = zzabeVar.zzd;
        if (zzabcVar.isEmpty()) {
            return this;
        }
        zzabc zzabcVar2 = this.zzd;
        return zzabcVar2.isEmpty() ? zzabeVar : new zzabe(new zzabc(zzabcVar2, zzabcVar));
    }
}
