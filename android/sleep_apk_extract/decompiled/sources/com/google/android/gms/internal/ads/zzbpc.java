package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzbpc implements zzbpq {
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzckuVar.zzdk();
        } else if ("resume".equals(str)) {
            zzckuVar.zzdl();
        }
    }
}
