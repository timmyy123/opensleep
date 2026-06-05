package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeox extends zzeos {
    private final zzcnj zza;
    private final zzdca zzb;
    private final zzeri zzc;
    private final zzdir zzd;
    private final zzepd zze;
    private final zzelx zzf;

    public zzeox(zzcnj zzcnjVar, zzdca zzdcaVar, zzeri zzeriVar, zzdir zzdirVar, zzepd zzepdVar, zzelx zzelxVar) {
        this.zza = zzcnjVar;
        this.zzb = zzdcaVar;
        this.zzc = zzeriVar;
        this.zzd = zzdirVar;
        this.zze = zzepdVar;
        this.zzf = zzelxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeos
    public final ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        zzdca zzdcaVar = this.zzb;
        zzdcaVar.zzb(zzfkyVar);
        zzdcaVar.zzc(bundle);
        zzdcaVar.zzd(new zzdbu(zzfkqVar, zzfkfVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue()) {
            zzdcaVar.zzg(this.zzf);
        }
        zzdnf zzdnfVarZzm = this.zza.zzm();
        zzdnfVarZzm.zze(zzdcaVar.zze());
        zzdnfVarZzm.zzf(this.zzd);
        zzdnfVarZzm.zzd(this.zzc);
        zzcyx zzcyxVarZzb = zzdnfVarZzm.zza().zzb();
        return zzcyxVarZzb.zzc(zzcyxVarZzb.zzb());
    }
}
