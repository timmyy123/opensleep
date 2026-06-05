package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzido {
    static final zzido zza = new zzido(true);
    private static volatile zzido zzd;
    private final Map zze = Collections.EMPTY_MAP;

    public zzido(boolean z) {
    }

    public static zzido zza() {
        int i = zzicn.$r8$clinit;
        return zza;
    }

    public static zzido zzb() {
        zzido zzidoVar = zzd;
        if (zzidoVar != null) {
            return zzidoVar;
        }
        synchronized (zzido.class) {
            try {
                zzido zzidoVar2 = zzd;
                if (zzidoVar2 != null) {
                    return zzidoVar2;
                }
                int i = zzicn.$r8$clinit;
                zzido zzidoVarZzb = zzidw.zzb(zzido.class);
                zzd = zzidoVarZzb;
                return zzidoVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zziec zzc(zzifp zzifpVar, int i) {
        if (this.zze.get(new zzidn(zzifpVar, i)) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
