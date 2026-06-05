package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzht zza;

    public zzhn(zzht zzhtVar) {
        Objects.requireNonNull(zzhtVar);
        this.zza = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzgs zzgsVarZzj;
        int i2 = i - 1;
        if (i2 == 0) {
            zzgsVarZzj = this.zza.zzu.zzaW().zzj();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzgsVarZzj = this.zza.zzu.zzaW().zzk();
            } else if (i2 != 4) {
                zzgsVarZzj = this.zza.zzu.zzaW().zzi();
            } else if (z) {
                zzgsVarZzj = this.zza.zzu.zzaW().zzf();
            } else {
                zzht zzhtVar = this.zza;
                zzgsVarZzj = !z2 ? zzhtVar.zzu.zzaW().zzh() : zzhtVar.zzu.zzaW().zze();
            }
        } else if (z) {
            zzgsVarZzj = this.zza.zzu.zzaW().zzc();
        } else {
            zzht zzhtVar2 = this.zza;
            zzgsVarZzj = !z2 ? zzhtVar2.zzu.zzaW().zzd() : zzhtVar2.zzu.zzaW().zzb();
        }
        int size = list.size();
        if (size == 1) {
            zzgsVarZzj.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgsVarZzj.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgsVarZzj.zza(str);
        } else {
            zzgsVarZzj.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
