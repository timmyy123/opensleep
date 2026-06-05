package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccw;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfm extends zzcch {
    private static void zzu(final zzccp zzccpVar) {
        com.google.android.gms.ads.internal.util.client.zzo.zzf("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzccp zzccpVar2 = zzccpVar;
                if (zzccpVar2 != null) {
                    try {
                        zzccpVar2.zzf(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzb(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzc(zzm zzmVar, zzccp zzccpVar) {
        zzu(zzccpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzd(zzm zzmVar, zzccp zzccpVar) {
        zzu(zzccpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zze(zzccl zzcclVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzf(zzdn zzdnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final Bundle zzg() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzh(zzccw zzccwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean zzi() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final String zzj() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzk(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final zzccf zzl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final zzdx zzm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final String zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzo(zzdq zzdqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzp(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final long zzq() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzr(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzs(zzccq zzccqVar) {
    }
}
