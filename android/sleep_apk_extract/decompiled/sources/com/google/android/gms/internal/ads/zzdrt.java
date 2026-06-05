package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdrt implements zzddl {
    private final zzdpt zza;
    private final zzdpy zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdrt(zzdpt zzdptVar, zzdpy zzdpyVar, Executor executor, Executor executor2) {
        this.zza = zzdptVar;
        this.zzb = zzdpyVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final void zza(final zzcku zzckuVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzckuVar.zze("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        if (this.zzb.zzd()) {
            zzdpt zzdptVar = this.zza;
            zzeln zzelnVarZzZ = zzdptVar.zzZ();
            if (zzelnVarZzZ == null && zzdptVar.zzX() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgr)).booleanValue()) {
                ListenableFuture listenableFutureZzX = zzdptVar.zzX();
                zzcfw zzcfwVarZzY = zzdptVar.zzY();
                if (listenableFutureZzX == null || zzcfwVarZzY == null) {
                    return;
                }
                zzhbw.zzr(zzhbw.zzq(listenableFutureZzX, zzcfwVarZzY), new zzdrr(this), this.zzd);
                return;
            }
            if (zzelnVarZzZ != null) {
                zzcku zzckuVarZzW = zzdptVar.zzW();
                zzcku zzckuVarZzT = zzdptVar.zzT();
                if (zzckuVarZzW == null) {
                    zzckuVarZzW = zzckuVarZzT == null ? null : zzckuVarZzT;
                }
                if (zzckuVarZzW != null) {
                    zza(zzckuVarZzW);
                }
            }
        }
    }
}
