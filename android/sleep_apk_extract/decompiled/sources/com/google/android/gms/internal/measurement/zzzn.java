package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzzn extends zzzq {
    private final Map zza;
    private final Map zzb;
    private final zzzp zzc;
    private final zzzo zzd;

    public /* synthetic */ zzzn(zzzm zzzmVar, byte[] bArr) {
        HashMap map = new HashMap();
        this.zza = map;
        HashMap map2 = new HashMap();
        this.zzb = map2;
        map.putAll(zzzmVar.zzd());
        map2.putAll(zzzmVar.zze());
        this.zzc = zzzmVar.zzf();
        this.zzd = zzzmVar.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzzq
    public final void zza(zzyl zzylVar, Object obj, Object obj2) {
        zzzp zzzpVar = (zzzp) this.zza.get(zzylVar);
        if (zzzpVar != null) {
            zzzpVar.zza(zzylVar, obj, obj2);
        } else {
            this.zzc.zza(zzylVar, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzzq
    public final void zzb(zzyl zzylVar, Iterator it, Object obj) {
        zzzo zzzoVar = (zzzo) this.zzb.get(zzylVar);
        if (zzzoVar != null) {
            zzzoVar.zza(zzylVar, it, obj);
            return;
        }
        zzzo zzzoVar2 = this.zzd;
        if (zzzoVar2 != null && !this.zza.containsKey(zzylVar)) {
            zzzoVar2.zza(zzylVar, it, obj);
        } else {
            while (it.hasNext()) {
                zza(zzylVar, it.next(), obj);
            }
        }
    }
}
