package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
final class zzenq implements zzdno {
    private final zzfkf zza;
    private final zzbxb zzb;
    private final AdFormat zzc;
    private zzddj zzd = null;

    public zzenq(zzfkf zzfkfVar, zzbxb zzbxbVar, AdFormat adFormat) {
        this.zza = zzfkfVar;
        this.zzb = zzbxbVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z, Context context, zzdde zzddeVar) throws zzdnn {
        boolean zZzk;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzk = this.zzb.zzk(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzk = this.zzb.zzt(ObjectWrapper.wrap(context));
                    }
                    throw new zzdnn("Adapter failed to show.");
                }
                zZzk = this.zzb.zzm(ObjectWrapper.wrap(context));
            }
            if (zZzk) {
                zzddj zzddjVar = this.zzd;
                if (zzddjVar == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzch)).booleanValue() || this.zza.zzY != 2) {
                    return;
                }
                zzddjVar.zza();
                return;
            }
            throw new zzdnn("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdnn(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zza;
    }

    public final void zzc(zzddj zzddjVar) {
        this.zzd = zzddjVar;
    }
}
