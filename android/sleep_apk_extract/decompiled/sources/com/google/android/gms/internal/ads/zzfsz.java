package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzfsz extends com.google.android.gms.ads.internal.client.zzbj {
    private com.google.android.gms.ads.internal.client.zzbu zza;
    private zzfsp zzb;
    private String zzc;

    public zzfsz(com.google.android.gms.ads.internal.client.zzbu zzbuVar, zzfsp zzfspVar, String str) {
        this.zza = zzbuVar;
        this.zzb = zzfspVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() {
        zzfsp zzfspVar = this.zzb;
        com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zza;
        if (zzbuVar == null || zzfspVar == null) {
            return;
        }
        zzfspVar.zza(zzbuVar);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfsp zzfspVar = this.zzb;
        if (this.zza == null || zzfspVar == null) {
            return;
        }
        String string = zzeVar.zzb().toString();
        String str = this.zzc;
        StringBuilder sb = new StringBuilder(string.length() + 57 + String.valueOf(str).length());
        sb.append("Failed to load interstitial ad with error: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(sb.toString());
        ((zzfto) zzfspVar).zza.zzI(zzeVar);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }
}
