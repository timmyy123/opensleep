package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
final class zzegk implements zzdfx {
    private final Context zza;
    private final zzcdz zzb;

    public zzegk(Context context, zzcdz zzcdzVar) {
        this.zza = context;
        this.zzb = zzcdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
        String str = zzfkqVar.zzb.zzb.zze;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzcdz zzcdzVar = this.zzb;
        Context context = this.zza;
        zzcdzVar.zzc(context, zzfkqVar.zza.zza.zzd);
        zzcdzVar.zzm(context, str);
    }
}
