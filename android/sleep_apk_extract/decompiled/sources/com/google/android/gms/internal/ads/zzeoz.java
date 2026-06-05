package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeoz extends zzeos {
    private final zzcnj zza;
    private final zzdca zzb;
    private final zzdir zzc;
    private final zzepd zzd;

    @Nullable
    private final zzfkr zze;
    private final zzelx zzf;

    public zzeoz(zzcnj zzcnjVar, zzdca zzdcaVar, zzdir zzdirVar, @Nullable zzfkr zzfkrVar, zzepd zzepdVar, zzelx zzelxVar) {
        this.zza = zzcnjVar;
        this.zzb = zzdcaVar;
        this.zzc = zzdirVar;
        this.zze = zzfkrVar;
        this.zzd = zzepdVar;
        this.zzf = zzelxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeos
    public final ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        zzfkr zzfkrVar;
        zzdca zzdcaVar = this.zzb;
        zzdcaVar.zzb(zzfkyVar);
        zzdcaVar.zzc(bundle);
        zzdcaVar.zzd(new zzdbu(zzfkqVar, zzfkfVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzev)).booleanValue() && (zzfkrVar = this.zze) != null) {
            zzdcaVar.zzf(zzfkrVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue()) {
            zzdcaVar.zzg(this.zzf);
        }
        zzdvq zzdvqVarZzp = this.zza.zzp();
        zzdvqVarZzp.zzd(zzdcaVar.zze());
        zzdvqVarZzp.zze(this.zzc);
        zzcyx zzcyxVarZza = zzdvqVarZzp.zza().zza();
        return zzcyxVarZza.zzc(zzcyxVarZza.zzb());
    }
}
