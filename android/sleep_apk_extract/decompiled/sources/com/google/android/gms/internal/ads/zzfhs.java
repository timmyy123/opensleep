package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzfhs {
    private final zzfmn zza;
    private final zzdbz zzb;
    private final Executor zzc;
    private zzfhq zzd;

    public zzfhs(zzfmn zzfmnVar, zzdbz zzdbzVar, Executor executor) {
        this.zza = zzfmnVar;
        this.zzb = zzdbzVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzfmx zzb() {
        zzfky zzfkyVarZzb = this.zzb.zzb();
        return this.zza.zzd(zzfkyVarZzb.zzd, zzfkyVarZzb.zzg, zzfkyVarZzb.zzk);
    }

    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza;
        zzfhq zzfhqVar = this.zzd;
        if (zzfhqVar != null) {
            return zzhbw.zza(zzfhqVar);
        }
        if (((Boolean) zzbkx.zza.zze()).booleanValue()) {
            zzhbo zzhboVarZzw = zzhbo.zzw(this.zzb.zza().zze(this.zza.zze()));
            zzfhp zzfhpVar = new zzfhp(this);
            Executor executor = this.zzc;
            listenableFutureZza = (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzk(zzhboVarZzw, zzfhpVar, executor), zzegr.class, new zzfho(this), executor);
        } else {
            zzfhq zzfhqVar2 = new zzfhq(null, zzb(), null);
            this.zzd = zzfhqVar2;
            listenableFutureZza = zzhbw.zza(zzfhqVar2);
        }
        return zzhbw.zzk(listenableFutureZza, zzfhr.zza, this.zzc);
    }

    public final /* synthetic */ zzfhq zzc() {
        return this.zzd;
    }

    public final /* synthetic */ void zzd(zzfhq zzfhqVar) {
        this.zzd = zzfhqVar;
    }
}
