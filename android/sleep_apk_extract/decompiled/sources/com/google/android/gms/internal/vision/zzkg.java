package com.google.android.gms.internal.vision;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class zzkg implements zzkh {
    @Override // com.google.android.gms.internal.vision.zzkh
    public final int zza(int i, Object obj, Object obj2) {
        zzke zzkeVar = (zzke) obj;
        if (obj2 != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return 0;
        }
        if (!zzkeVar.isEmpty()) {
            Iterator it = zzkeVar.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw new NoSuchMethodError();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final zzkf<?, ?> zzb(Object obj) {
        if (obj == null) {
            throw new NoSuchMethodError();
        }
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zzc(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final boolean zzd(Object obj) {
        return !((zzke) obj).zzd();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zze(Object obj) {
        ((zzke) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zzf(Object obj) {
        return zzke.zza().zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zza(Object obj, Object obj2) {
        zzke zzkeVarZzb = (zzke) obj;
        zzke zzkeVar = (zzke) obj2;
        if (!zzkeVar.isEmpty()) {
            if (!zzkeVarZzb.zzd()) {
                zzkeVarZzb = zzkeVarZzb.zzb();
            }
            zzkeVarZzb.zza(zzkeVar);
        }
        return zzkeVarZzb;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zza(Object obj) {
        return (zzke) obj;
    }
}
