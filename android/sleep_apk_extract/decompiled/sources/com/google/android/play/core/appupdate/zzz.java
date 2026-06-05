package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzad;
import com.google.android.play.core.appupdate.internal.zzaf;

/* JADX INFO: loaded from: classes4.dex */
final class zzz implements zza {
    private final zzz zza = this;
    private final zzaf zzb;
    private final zzaf zzc;
    private final zzaf zzd;
    private final zzaf zze;
    private final zzaf zzf;
    private final zzaf zzg;

    public /* synthetic */ zzz(zzi zziVar, zzy zzyVar) {
        zzk zzkVar = new zzk(zziVar);
        this.zzb = zzkVar;
        zzaf zzafVarZzb = zzad.zzb(new zzu(zzkVar));
        this.zzc = zzafVarZzb;
        zzaf zzafVarZzb2 = zzad.zzb(new zzs(zzkVar, zzafVarZzb));
        this.zzd = zzafVarZzb2;
        zzaf zzafVarZzb3 = zzad.zzb(new zzd(zzkVar));
        this.zze = zzafVarZzb3;
        zzaf zzafVarZzb4 = zzad.zzb(new zzh(zzafVarZzb2, zzafVarZzb3, zzkVar));
        this.zzf = zzafVarZzb4;
        this.zzg = zzad.zzb(new zzj(zzafVarZzb4));
    }

    @Override // com.google.android.play.core.appupdate.zza
    public final AppUpdateManager zza() {
        return (AppUpdateManager) this.zzg.zza();
    }
}
