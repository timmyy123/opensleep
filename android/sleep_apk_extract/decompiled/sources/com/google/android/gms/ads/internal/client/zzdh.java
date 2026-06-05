package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdh {
    private final String zza;
    private final zzdg zzb;

    public zzdh(zzdg zzdgVar) {
        String strZze;
        this.zzb = zzdgVar;
        try {
            strZze = zzdgVar.zze();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
            strZze = null;
        }
        this.zza = strZze;
    }

    public final String toString() {
        return this.zza;
    }
}
