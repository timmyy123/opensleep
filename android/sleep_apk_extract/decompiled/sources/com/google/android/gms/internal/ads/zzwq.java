package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzwq implements zzxv, zzuj {
    final /* synthetic */ zzws zza;
    private final Object zzb;
    private zzxu zzc;
    private zzui zzd;

    public zzwq(zzws zzwsVar, Object obj) {
        Objects.requireNonNull(zzwsVar);
        this.zza = zzwsVar;
        this.zzc = zzwsVar.zzf(null);
        this.zzd = zzwsVar.zzh(null);
        this.zzb = obj;
    }

    private final boolean zzf(int i, zzxk zzxkVar) {
        zzxk zzxkVarZzx;
        if (zzxkVar != null) {
            zzxkVarZzx = this.zza.zzx(this.zzb, zzxkVar);
            if (zzxkVarZzx == null) {
                return false;
            }
        } else {
            zzxkVarZzx = null;
        }
        zzws zzwsVar = this.zza;
        zzwsVar.zzw(this.zzb, 0);
        zzxu zzxuVar = this.zzc;
        int i2 = zzxuVar.zza;
        if (!Objects.equals(zzxuVar.zzb, zzxkVarZzx)) {
            this.zzc = zzwsVar.zzg(0, zzxkVarZzx);
        }
        zzui zzuiVar = this.zzd;
        int i3 = zzuiVar.zza;
        if (Objects.equals(zzuiVar.zzb, zzxkVarZzx)) {
            return true;
        }
        this.zzd = zzwsVar.zzi(0, zzxkVarZzx);
        return true;
    }

    private final zzxg zzg(zzxg zzxgVar, zzxk zzxkVar) {
        zzws zzwsVar = this.zza;
        Object obj = this.zzb;
        zzwsVar.zzy(obj, zzxgVar.zzc, zzxkVar);
        zzwsVar.zzy(obj, zzxgVar.zzd, zzxkVar);
        return zzxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzai(int i, zzxk zzxkVar, zzxb zzxbVar, zzxg zzxgVar, int i2) {
        if (zzf(0, zzxkVar)) {
            zzxu zzxuVar = this.zzc;
            zzg(zzxgVar, zzxkVar);
            zzxuVar.zzd(zzxbVar, zzxgVar, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzaj(int i, zzxk zzxkVar, zzxb zzxbVar, zzxg zzxgVar) {
        if (zzf(0, zzxkVar)) {
            zzxu zzxuVar = this.zzc;
            zzg(zzxgVar, zzxkVar);
            zzxuVar.zze(zzxbVar, zzxgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzak(int i, zzxk zzxkVar, zzxb zzxbVar, zzxg zzxgVar) {
        if (zzf(0, zzxkVar)) {
            zzxu zzxuVar = this.zzc;
            zzg(zzxgVar, zzxkVar);
            zzxuVar.zzf(zzxbVar, zzxgVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzal(int i, zzxk zzxkVar, zzxb zzxbVar, zzxg zzxgVar, IOException iOException, boolean z) {
        if (zzf(0, zzxkVar)) {
            zzxu zzxuVar = this.zzc;
            zzg(zzxgVar, zzxkVar);
            zzxuVar.zzg(zzxbVar, zzxgVar, iOException, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzam(int i, zzxk zzxkVar, zzxg zzxgVar) {
        if (zzf(0, zzxkVar)) {
            zzxu zzxuVar = this.zzc;
            zzg(zzxgVar, zzxkVar);
            zzxuVar.zzh(zzxgVar);
        }
    }
}
