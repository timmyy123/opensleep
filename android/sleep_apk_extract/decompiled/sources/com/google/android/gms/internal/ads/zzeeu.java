package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeeu implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;

    private zzeeu(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
    }

    public static zzeeu zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzeeu(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0077  */
    @Override // com.google.android.gms.internal.ads.zzinj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object zzb() {
        ListenableFuture listenableFutureZzc;
        final zzbap zzbapVar = (zzbap) this.zza.zzb();
        final Context contextZza = ((zzcns) this.zzb).zza();
        zzfky zzfkyVarZza = ((zzdci) this.zzc).zza();
        long jLongValue = ((Long) this.zzd.zzb()).longValue();
        zzhcg zzhcgVarZzc = zzfoa.zzc();
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdA)).intValue();
        if (iIntValue != -1) {
            if (Integer.toString(iIntValue).equals(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzc(zzfkyVarZza.zzd)))) {
                listenableFutureZzc = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - jLongValue < ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdC)).intValue()) ? zzhcgVarZzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeep
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return zzbapVar.zzb().zzk(contextZza);
                    }
                }) : zzhcgVarZzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeeo
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return zzbapVar.zzb().zzl(contextZza);
                    }
                });
            }
        }
        zzinc.zzb(listenableFutureZzc);
        return listenableFutureZzc;
    }
}
