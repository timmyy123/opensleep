package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzbpd implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        if (map.containsKey("start")) {
            zzckuVar.zzP().zzr();
        } else if (map.containsKey("stop")) {
            zzckuVar.zzP().zzs();
        } else if (map.containsKey("cancel")) {
            zzckuVar.zzP().zzt();
        }
    }
}
