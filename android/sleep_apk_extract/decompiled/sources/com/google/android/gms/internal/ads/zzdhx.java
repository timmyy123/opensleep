package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdhx implements zzdfx {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbS)).intValue();
    private int zzb = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzor)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final synchronized void zzdQ(zzfkq zzfkqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbT)).booleanValue()) {
            try {
                zzfki zzfkiVar = zzfkqVar.zzb.zzb;
                this.zza = zzfkiVar.zzc;
                this.zzb = zzfkiVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
