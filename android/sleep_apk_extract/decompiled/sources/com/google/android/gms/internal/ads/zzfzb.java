package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfzb {
    final /* synthetic */ zzfzc zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzfzb(zzfzc zzfzcVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzfzcVar);
        this.zza = zzfzcVar;
        this.zzb = bArr;
    }

    public final synchronized void zza() {
        try {
            zzfzc zzfzcVar = this.zza;
            if (zzfzcVar.zzb) {
                zzfzf zzfzfVar = zzfzcVar.zza;
                zzfzfVar.zzg(this.zzb);
                zzfzfVar.zzh(this.zzc);
                zzfzfVar.zzi(this.zzd);
                zzfzfVar.zzf(null);
                zzfzfVar.zze();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }

    public final zzfzb zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final zzfzb zzc(int i) {
        this.zzd = i;
        return this;
    }
}
