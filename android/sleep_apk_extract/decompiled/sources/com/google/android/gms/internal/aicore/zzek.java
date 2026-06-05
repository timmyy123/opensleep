package com.google.android.gms.internal.aicore;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzek {
    static final zzek zza = new zzek(true);
    private static volatile zzek zzd;
    private final Map zze = Collections.EMPTY_MAP;

    public zzek(boolean z) {
    }

    public static zzek zza() {
        zzek zzekVar = zzd;
        if (zzekVar != null) {
            return zzekVar;
        }
        synchronized (zzek.class) {
            try {
                zzek zzekVar2 = zzd;
                if (zzekVar2 != null) {
                    return zzekVar2;
                }
                int i = zzgh.$r8$clinit;
                zzek zzekVarZzb = zzer.zzb(zzek.class);
                zzd = zzekVarZzb;
                return zzekVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzew zzb(zzga zzgaVar, int i) {
        if (this.zze.get(new zzej(zzgaVar, i)) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
