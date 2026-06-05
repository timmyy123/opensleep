package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbct extends zzbdf {
    public zzbct(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2) {
        super(zzbbsVar, "IIcYtgV+jKyhXEWTRGryYoN4Hb3AaxkKFvJa61B8IsfExxFOrLfbygLFTq7UIHav", "0Td4x6cMqS7UG7AA2zcqm+bK2AW+gIwIgEtwqP1CguA=", zzaxmVar, i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza() {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdN);
        bool.booleanValue();
        zzbay zzbayVar = new zzbay((String) this.zze.invoke(null, this.zza.zzb(), bool));
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzc(zzbayVar.zza);
            zzaxmVar.zzP(zzbayVar.zzb);
        }
    }
}
