package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbih {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    public /* synthetic */ zzbih(int i, String str, Object obj, Object obj2, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzba.zzb().zza(this);
    }

    public static zzbih zzh(int i, String str, int i2, int i3) {
        return new zzbid(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbih zzi(int i, String str, long j, long j2) {
        return new zzbie(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbih zzj(int i, String str, float f, float f2) {
        return new zzbif(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbih zzk(int i, String str) {
        zzbig zzbigVar = new zzbig(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzba.zzb().zzb(zzbigVar);
        return zzbigVar;
    }

    public static zzbih zzl(int i, String str) {
        zzbig zzbigVar = new zzbig(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzba.zzb().zzc(zzbigVar);
        return zzbigVar;
    }

    public abstract Object zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, Object obj);

    public abstract Object zzc(JSONObject jSONObject);

    public abstract Object zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final Object zzf() {
        return com.google.android.gms.ads.internal.client.zzba.zzc().zzb() ? this.zzd : this.zzc;
    }

    public final Object zzg() {
        return com.google.android.gms.ads.internal.client.zzba.zzc().zzd(this);
    }

    public final int zzm() {
        return this.zza;
    }
}
