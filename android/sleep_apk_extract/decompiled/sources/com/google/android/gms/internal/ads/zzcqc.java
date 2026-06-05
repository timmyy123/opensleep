package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcqc implements com.google.android.gms.ads.nonagon.signalgeneration.zzw {
    private final zzcox zza;
    private zzdcb zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzat zzc;

    public /* synthetic */ zzcqc(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzx zza() {
        zzinc.zzc(this.zzb, zzdcb.class);
        zzinc.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzat.class);
        return new zzcqd(this.zza, this.zzc, new zzcyz(), new zzdba(), new zzeaa(), this.zzb, null, null);
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzw zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzat zzatVar) {
        this.zzc = zzatVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzw
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzw zzc(zzdcb zzdcbVar) {
        this.zzb = zzdcbVar;
        return this;
    }
}
