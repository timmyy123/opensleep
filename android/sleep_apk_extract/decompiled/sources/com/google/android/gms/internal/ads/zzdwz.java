package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwz {
    private final Map zza = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zza(String str, @Nullable zzflw zzflwVar) {
        zzbxq zzbxqVarZzB;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbxq zzbxqVarZzC = null;
        if (zzflwVar != null) {
            try {
                zzbxqVarZzB = zzflwVar.zzB();
            } catch (zzflf unused) {
                zzbxqVarZzB = null;
            }
            if (zzflwVar != null) {
            }
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkL)).booleanValue()) {
            }
            this.zza.put(str, new zzdwy(str, zzbxqVarZzB, zzbxqVarZzC, z));
            return;
        }
        zzbxqVarZzB = null;
        if (zzflwVar != null) {
            try {
                zzbxqVarZzC = zzflwVar.zzC();
            } catch (zzflf unused2) {
            }
        }
        boolean z2 = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkL)).booleanValue()) {
            if (zzflwVar == null) {
                z2 = false;
            } else {
                try {
                    zzflwVar.zzn();
                } catch (zzflf unused3) {
                    z2 = false;
                }
            }
        }
        this.zza.put(str, new zzdwy(str, zzbxqVarZzB, zzbxqVarZzC, z2));
        return;
    }

    public final synchronized void zzb(String str, zzbxb zzbxbVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdwy(str, zzbxbVar.zzf(), zzbxbVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final synchronized zzdwy zzc(String str) {
        return (zzdwy) this.zza.get(str);
    }

    public final String zzd(String str) {
        zzbxq zzbxqVar;
        zzdwy zzdwyVarZzc = zzc(str);
        return (zzdwyVarZzc == null || (zzbxqVar = zzdwyVarZzc.zzb) == null) ? "" : zzbxqVar.toString();
    }
}
