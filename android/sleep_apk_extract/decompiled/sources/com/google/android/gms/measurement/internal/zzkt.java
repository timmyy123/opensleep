package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzkt implements Runnable {
    final /* synthetic */ zzba zza;
    final /* synthetic */ zzlj zzb;

    public zzkt(zzlj zzljVar, zzba zzbaVar) {
        this.zza = zzbaVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzic zzicVar = zzljVar.zzu;
        zzhh zzhhVarZzd = zzicVar.zzd();
        zzic zzicVar2 = zzhhVarZzd.zzu;
        zzhhVarZzd.zzg();
        zzba zzbaVarZzj = zzhhVarZzd.zzj();
        zzba zzbaVar = this.zza;
        if (!zzjl.zzu(zzbaVar.zzb(), zzbaVarZzj.zzb())) {
            zzicVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzbaVar.zzb()));
            return;
        }
        SharedPreferences.Editor editorEdit = zzhhVarZzd.zzd().edit();
        editorEdit.putString("dma_consent_settings", zzbaVar.zze());
        editorEdit.apply();
        zzicVar.zzaW().zzk().zzb("Setting DMA consent(FE)", zzbaVar);
        zzic zzicVar3 = zzljVar.zzu;
        if (zzicVar3.zzt().zzP()) {
            zzicVar3.zzt().zzl();
        } else {
            zzicVar3.zzt().zzj(false);
        }
    }
}
