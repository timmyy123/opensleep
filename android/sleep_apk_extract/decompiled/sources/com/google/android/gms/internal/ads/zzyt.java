package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzyt implements zzxj {
    private final zzho zza;
    private final zzyc zzb;
    private int zzc;
    private final zzabu zzd;

    public zzyt(zzho zzhoVar, final zzage zzageVar) {
        zzyc zzycVar = new zzyc() { // from class: com.google.android.gms.internal.ads.zzys
            @Override // com.google.android.gms.internal.ads.zzyc
            public final /* synthetic */ zzyd zza(zzqf zzqfVar) {
                return new zzwm(zzageVar);
            }
        };
        zzabu zzabuVar = new zzabu(-1);
        this.zza = zzhoVar;
        this.zzb = zzycVar;
        this.zzd = zzabuVar;
        this.zzc = 1048576;
    }

    public final zzyt zza(int i) {
        this.zzc = i;
        return this;
    }

    public final zzyu zzb(zzak zzakVar) {
        zzakVar.zzb.getClass();
        return new zzyu(zzakVar, this.zza, this.zzb, zzun.zza, this.zzd, this.zzc, false, 0, null, null, null);
    }
}
