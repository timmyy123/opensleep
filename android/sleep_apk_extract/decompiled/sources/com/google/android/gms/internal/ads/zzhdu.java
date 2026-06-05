package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdu {
    private boolean zza;

    @Nullable
    private final zzheh zzc;
    private final zzhds zzb = zzhds.zza;
    private zzhdv zzd = null;

    @Nullable
    private zzhdw zze = null;

    public /* synthetic */ zzhdu(zzheh zzhehVar, byte[] bArr) {
        this.zzc = zzhehVar;
    }

    public final zzhdu zza() {
        zzhdw zzhdwVar = this.zze;
        if (zzhdwVar != null) {
            zzhdwVar.zzc();
        }
        this.zza = true;
        return this;
    }

    public final zzhdu zzb() {
        this.zzd = zzhdv.zza;
        return this;
    }

    public final /* synthetic */ boolean zzc() {
        return this.zza;
    }

    public final /* synthetic */ void zzd(boolean z) {
        this.zza = false;
    }

    public final /* synthetic */ zzhds zze() {
        return this.zzb;
    }

    public final /* synthetic */ zzheh zzf() {
        return this.zzc;
    }

    public final /* synthetic */ zzhdv zzg() {
        return this.zzd;
    }

    public final /* synthetic */ zzhdw zzh() {
        return this.zze;
    }

    public final /* synthetic */ void zzi(zzhdw zzhdwVar) {
        this.zze = zzhdwVar;
    }
}
