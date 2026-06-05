package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcub {
    private final String zza;
    private final zzbur zzb;
    private final Executor zzc;
    private zzcug zzd;
    private final zzbpq zze = new zzcty(this);
    private final zzbpq zzf = new zzcua(this);

    public zzcub(String str, zzbur zzburVar, Executor executor) {
        this.zza = str;
        this.zzb = zzburVar;
        this.zzc = executor;
    }

    public final void zza(zzcug zzcugVar) {
        zzbur zzburVar = this.zzb;
        zzburVar.zzb("/updateActiveView", this.zze);
        zzburVar.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcugVar;
    }

    public final void zzb(zzcku zzckuVar) {
        zzckuVar.zzab("/updateActiveView", this.zze);
        zzckuVar.zzab("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzc(zzcku zzckuVar) {
        zzckuVar.zzac("/updateActiveView", this.zze);
        zzckuVar.zzac("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzd() {
        zzbur zzburVar = this.zzb;
        zzburVar.zzc("/updateActiveView", this.zze);
        zzburVar.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final /* synthetic */ boolean zze(Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zza);
    }

    public final /* synthetic */ Executor zzf() {
        return this.zzc;
    }

    public final /* synthetic */ zzcug zzg() {
        return this.zzd;
    }
}
