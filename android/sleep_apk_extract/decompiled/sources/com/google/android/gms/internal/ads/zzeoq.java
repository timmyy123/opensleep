package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeoq extends zzeos {
    private final zzcnj zza;
    private final zzdnx zzb;
    private final zzdca zzc;
    private final zzdir zzd;
    private final zzepd zze;
    private final zzelx zzf;

    public zzeoq(zzcnj zzcnjVar, zzdnx zzdnxVar, zzdca zzdcaVar, zzdir zzdirVar, zzepd zzepdVar, zzelx zzelxVar) {
        this.zza = zzcnjVar;
        this.zzb = zzdnxVar;
        this.zzc = zzdcaVar;
        this.zzd = zzdirVar;
        this.zze = zzepdVar;
        this.zzf = zzelxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeos
    public final ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        zzdca zzdcaVar = this.zzc;
        zzdcaVar.zzb(zzfkyVar);
        zzdcaVar.zzc(bundle);
        zzdcaVar.zzd(new zzdbu(zzfkqVar, zzfkfVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue()) {
            zzdcaVar.zzg(this.zzf);
        }
        zzdob zzdobVarZzo = this.zza.zzo();
        zzdobVarZzo.zzf(zzdcaVar.zze());
        zzdobVarZzo.zzg(this.zzd);
        zzdobVarZzo.zze(this.zzb);
        zzdobVarZzo.zzd(new zzcvi(null));
        zzcyx zzcyxVarZza = zzdobVarZzo.zza().zza();
        return zzcyxVarZza.zzc(zzcyxVarZza.zzb());
    }
}
