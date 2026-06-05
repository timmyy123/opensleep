package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeqn implements zzelu {
    private final zzerr zza;
    private final zzdxc zzb;

    public zzeqn(zzerr zzerrVar, zzdxc zzdxcVar) {
        this.zza = zzerrVar;
        this.zzb = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) {
        zzbxb zzbxbVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcp)).booleanValue()) {
            try {
                zzbxbVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Coundn't create RTB adapter: ", e);
                zzbxbVarZzb = null;
            }
        } else {
            zzbxbVarZzb = this.zza.zzb(str);
        }
        if (zzbxbVarZzb == null) {
            return null;
        }
        return new zzelv(zzbxbVarZzb, new zzenh(), str);
    }
}
