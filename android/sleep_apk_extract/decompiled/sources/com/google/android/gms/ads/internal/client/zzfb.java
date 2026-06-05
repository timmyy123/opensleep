package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmv;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfb implements MediaContent {
    private final zzbmb zza;
    private final VideoController zzb = new VideoController();
    private final zzbmv zzc;

    public zzfb(zzbmb zzbmbVar, zzbmv zzbmvVar) {
        this.zza = zzbmbVar;
        this.zzc = zzbmvVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean zza() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final zzbmv zzb() {
        return this.zzc;
    }

    public final zzbmb zzc() {
        return this.zza;
    }
}
