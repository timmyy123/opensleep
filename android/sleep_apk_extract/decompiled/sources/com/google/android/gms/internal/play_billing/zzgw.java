package com.google.android.gms.internal.play_billing;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgw {
    static final zzgw zza = new zzgw(true);
    private static volatile zzgw zzd;
    private final Map zze = Collections.EMPTY_MAP;

    public zzgw(boolean z) {
    }

    public static zzgw zza() {
        zzgw zzgwVar = zzd;
        if (zzgwVar != null) {
            return zzgwVar;
        }
        synchronized (zzgw.class) {
            try {
                zzgw zzgwVar2 = zzd;
                if (zzgwVar2 != null) {
                    return zzgwVar2;
                }
                int i = zziu.$r8$clinit;
                zzgw zzgwVarZzb = zzhe.zzb(zzgw.class);
                zzd = zzgwVarZzb;
                return zzgwVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzhj zzb(zzim zzimVar, int i) {
        if (this.zze.get(new zzgv(zzimVar, i)) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
