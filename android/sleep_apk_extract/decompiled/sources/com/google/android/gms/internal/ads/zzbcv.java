package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbcv extends zzbdf {
    private List zzh;
    private final Context zzi;

    public zzbcv(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, Context context) {
        super(zzbbsVar, "XXF2CX++qjQzFfJDmqd+84h356GlStFLqQSTRbbce/csPkd7M5mpQw1l7igXWffL", "FGCYjW2JaOcRH3mqSkgHIxbWzEwOVje6sx286yuA1xM=", zzaxmVar, i, 31);
        this.zzh = null;
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        zzaxm zzaxmVar = this.zzd;
        zzaxmVar.zzq(-1L);
        zzaxmVar.zzr(-1L);
        Context contextZzb = this.zzi;
        if (contextZzb == null) {
            contextZzb = this.zza.zzb();
        }
        if (this.zzh == null) {
            this.zzh = (List) this.zze.invoke(null, contextZzb);
        }
        List list = this.zzh;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (zzaxmVar) {
            zzaxmVar.zzq(((Long) this.zzh.get(0)).longValue());
            zzaxmVar.zzr(((Long) this.zzh.get(1)).longValue());
        }
    }
}
