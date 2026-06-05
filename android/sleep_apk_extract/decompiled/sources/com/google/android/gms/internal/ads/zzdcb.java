package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdcb {
    private final Context zza;
    private final zzfky zzb;
    private final Bundle zzc;
    private final zzfkr zzd;
    private final zzdbu zze;
    private final zzelx zzf;

    public /* synthetic */ zzdcb(zzdca zzdcaVar, byte[] bArr) {
        this.zza = zzdcaVar.zzh();
        this.zzb = zzdcaVar.zzi();
        this.zzc = zzdcaVar.zzj();
        this.zzd = zzdcaVar.zzk();
        this.zze = zzdcaVar.zzl();
        this.zzf = zzdcaVar.zzm();
    }

    public final zzdca zza() {
        zzdca zzdcaVar = new zzdca();
        zzdcaVar.zza(this.zza);
        zzdcaVar.zzb(this.zzb);
        zzdcaVar.zzc(this.zzc);
        zzdcaVar.zzd(this.zze);
        zzdcaVar.zzg(this.zzf);
        return zzdcaVar;
    }

    public final zzfky zzb() {
        return this.zzb;
    }

    public final zzfkr zzc() {
        return this.zzd;
    }

    public final Bundle zzd() {
        return this.zzc;
    }

    public final zzdbu zze() {
        return this.zze;
    }

    public final Context zzf(Context context) {
        return this.zza;
    }

    public final zzelx zzg(String str) {
        zzelx zzelxVar = this.zzf;
        return zzelxVar != null ? zzelxVar : new zzelx(str);
    }
}
