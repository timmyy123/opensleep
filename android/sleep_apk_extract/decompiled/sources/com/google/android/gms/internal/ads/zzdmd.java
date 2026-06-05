package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class zzdmd {
    private final zzdno zza;
    private final zzcku zzb;

    public zzdmd(zzdno zzdnoVar, zzcku zzckuVar) {
        this.zza = zzdnoVar;
        this.zzb = zzckuVar;
    }

    public final zzdno zza() {
        return this.zza;
    }

    public final zzcku zzb() {
        return this.zzb;
    }

    public final View zzc() {
        zzcku zzckuVar = this.zzb;
        if (zzckuVar != null) {
            return zzckuVar.zzD();
        }
        return null;
    }

    public final View zzd() {
        zzcku zzckuVar = this.zzb;
        if (zzckuVar == null) {
            return null;
        }
        return zzckuVar.zzD();
    }

    public Set zze(zzdbk zzdbkVar) {
        return Collections.singleton(new zzdkq(zzdbkVar, zzcfr.zzh));
    }

    public Set zzf(zzdbk zzdbkVar) {
        return Collections.singleton(new zzdkq(zzdbkVar, zzcfr.zzh));
    }

    public final zzdkq zzg(Executor executor) {
        final zzcku zzckuVar = this.zzb;
        return new zzdkq(new zzdho() { // from class: com.google.android.gms.internal.ads.zzdmb
            @Override // com.google.android.gms.internal.ads.zzdho
            public final /* synthetic */ void zza() {
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL;
                zzcku zzckuVar2 = zzckuVar;
                if (zzckuVar2 == null || (zzmVarZzL = zzckuVar2.zzL()) == null) {
                    return;
                }
                zzmVarZzL.zzb();
            }
        }, executor);
    }
}
