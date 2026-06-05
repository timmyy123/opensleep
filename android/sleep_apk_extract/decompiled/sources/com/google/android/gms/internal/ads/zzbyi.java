package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbyi extends NativeAd.AdChoicesInfo {
    private final List zza = new ArrayList();
    private String zzb;

    public zzbyi(zzblx zzblxVar) {
        try {
            this.zzb = zzblxVar.zzb();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
            this.zzb = "";
        }
        try {
            for (Object obj : zzblxVar.zzc()) {
                zzbme zzbmeVarZzh = obj instanceof IBinder ? zzbmd.zzh((IBinder) obj) : null;
                if (zzbmeVarZzh != null) {
                    this.zza.add(new zzbyk(zzbmeVarZzh));
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e2);
        }
    }
}
