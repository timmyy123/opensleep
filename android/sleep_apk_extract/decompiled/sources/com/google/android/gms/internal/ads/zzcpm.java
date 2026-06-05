package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpm implements zzebc {
    private final zzcox zza;
    private Context zzb;
    private zzbqq zzc;

    public /* synthetic */ zzcpm(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebc
    public final zzebd zza() {
        zzinc.zzc(this.zzb, Context.class);
        zzinc.zzc(this.zzc, zzbqq.class);
        return new zzcpn(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzebc
    public final /* bridge */ /* synthetic */ zzebc zzb(zzbqq zzbqqVar) {
        zzbqqVar.getClass();
        this.zzc = zzbqqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzebc
    public final /* bridge */ /* synthetic */ zzebc zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
