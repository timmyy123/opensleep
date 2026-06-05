package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzedv {
    private final Context zza;
    private zzarx zzb;

    public zzedv(Context context) {
        this.zza = context;
    }

    public final void zza() {
        this.zzb = zzarw.zza(this.zza);
    }

    public final void zzb(zzasa zzasaVar) {
        this.zzb.zzb(zzasaVar);
    }

    public final void zzc() {
        this.zzb.zzc();
    }

    public final zzasb zzd() {
        try {
            zzarx zzarxVar = this.zzb;
            if (zzarxVar != null && zzarxVar.zza()) {
                return zzarxVar.zzd();
            }
        } catch (RemoteException unused) {
        }
        return null;
    }
}
