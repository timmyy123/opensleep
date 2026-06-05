package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfhj implements zzfhw {
    private final zzfmn zza;
    private final Executor zzb;
    private final zzhbt zzc = new zzfhg(this);

    public zzfhj(zzfmn zzfmnVar, Executor executor) {
        this.zza = zzfmnVar;
        this.zzb = executor;
    }

    public final ListenableFuture zza(zzfhx zzfhxVar, zzfhv zzfhvVar, final zzdbz zzdbzVar) {
        zzfmn zzfmnVar = this.zza;
        Executor executor = this.zzb;
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzj(zzhbo.zzw(new zzfhs(zzfmnVar, zzdbzVar, executor).zza()), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfhh
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzdbzVar, (zzfhq) obj);
            }
        }, executor), Exception.class, new zzfhf(this), executor);
    }

    public final /* synthetic */ ListenableFuture zzb(zzdbz zzdbzVar, zzfhq zzfhqVar) {
        zzfmn zzfmnVar = this.zza;
        zzfmx zzfmxVar = zzfhqVar.zzb;
        zzcbd zzcbdVar = zzfhqVar.zza;
        zzfmw zzfmwVarZza = zzfmnVar.zza(zzfmxVar);
        if (zzfmwVarZza != null && zzcbdVar != null) {
            zzhbw.zzr(zzdbzVar.zza().zzf(zzcbdVar), this.zzc, this.zzb);
        }
        return zzhbw.zza(new zzfhi(zzfmxVar, zzcbdVar, zzfmwVarZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfhx zzfhxVar, zzfhv zzfhvVar, Object obj) {
        return zza(zzfhxVar, zzfhvVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
