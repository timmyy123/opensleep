package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeov extends zzeos {
    private final zzcnj zza;
    private final zzdca zzb;
    private final zzeri zzc;
    private final zzdir zzd;
    private final zzdnx zze;
    private final zzdfs zzf;
    private final ViewGroup zzg;
    private final zzdhx zzh;
    private final zzepd zzi;
    private final zzelx zzj;

    public zzeov(zzcnj zzcnjVar, zzdca zzdcaVar, zzeri zzeriVar, zzdir zzdirVar, zzdnx zzdnxVar, zzdfs zzdfsVar, ViewGroup viewGroup, zzdhx zzdhxVar, zzepd zzepdVar, zzelx zzelxVar) {
        this.zza = zzcnjVar;
        this.zzb = zzdcaVar;
        this.zzc = zzeriVar;
        this.zzd = zzdirVar;
        this.zze = zzdnxVar;
        this.zzf = zzdfsVar;
        this.zzg = viewGroup;
        this.zzh = zzdhxVar;
        this.zzi = zzepdVar;
        this.zzj = zzelxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeos
    public final ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        zzdca zzdcaVar = this.zzb;
        zzdcaVar.zzb(zzfkyVar);
        zzdcaVar.zzc(bundle);
        zzdcaVar.zzd(new zzdbu(zzfkqVar, zzfkfVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue()) {
            zzdcaVar.zzg(this.zzj);
        }
        zzcwp zzcwpVarZzi = this.zza.zzi();
        zzcwpVarZzi.zzl(zzdcaVar.zze());
        zzcwpVarZzi.zzm(this.zzd);
        zzcwpVarZzi.zzk(this.zzc);
        zzcwpVarZzi.zzd(this.zze);
        zzcwpVarZzi.zzg(new zzcxl(this.zzf, this.zzh));
        zzcwpVarZzi.zze(new zzcvi(this.zzg));
        zzcyx zzcyxVarZzc = zzcwpVarZzi.zza().zzc();
        return zzcyxVarZzc.zzc(zzcyxVarZzc.zzb());
    }
}
