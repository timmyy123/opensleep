package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfxq {
    private final Context zza;
    private final Looper zzb;

    public zzfxq(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfya zzfyaVarZza = zzfyc.zza();
        Context context = this.zza;
        zzfyaVarZza.zza(context.getPackageName());
        zzfyaVarZza.zzc(2);
        zzfxy zzfxyVarZza = zzfxz.zza();
        zzfxyVarZza.zza(str);
        zzfxyVarZza.zzb(2);
        zzfyaVarZza.zzb(zzfxyVarZza);
        new zzfxr(context, this.zzb, (zzfyc) zzfyaVarZza.zzbm()).zza();
    }
}
