package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdck extends com.google.android.gms.ads.internal.client.zzdw {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzelx zzh;
    private final Bundle zzi;
    private final double zzj;
    private final int zzk;

    public zzdck(zzfkf zzfkfVar, String str, zzelx zzelxVar, zzfki zzfkiVar, String str2) {
        String string = null;
        this.zzb = zzfkfVar == null ? null : zzfkfVar.zzab;
        this.zzc = str2;
        this.zzd = zzfkiVar == null ? null : zzfkiVar.zzb;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzfkfVar != null) {
            try {
                string = zzfkfVar.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzelxVar.zzh();
        this.zzh = zzelxVar;
        this.zzj = zzfkfVar == null ? 0.0d : zzfkfVar.zzaz;
        this.zzk = zzfkfVar == null ? 2 : zzfkfVar.zzaI;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() / 1000;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhK)).booleanValue() || zzfkiVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfkiVar.zzk;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhL)).booleanValue() && zzfkfVar != null) {
            Bundle bundle = zzfkfVar.zzaF;
            Bundle bundle2 = this.zzi;
            if (bundle2 != null) {
                bundle2.putAll(bundle);
            }
        }
        this.zzg = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkF)).booleanValue() || zzfkiVar == null || TextUtils.isEmpty(zzfkiVar.zzi)) ? "" : zzfkiVar.zzi;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final List zzg() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final com.google.android.gms.ads.internal.client.zzv zzh() {
        zzelx zzelxVar = this.zzh;
        if (zzelxVar != null) {
            return zzelxVar.zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final Bundle zzi() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdx
    public final String zzj() {
        return this.zzc;
    }

    public final String zzk() {
        return this.zzd;
    }

    public final double zzl() {
        return this.zzj;
    }

    public final int zzm() {
        return this.zzk;
    }
}
