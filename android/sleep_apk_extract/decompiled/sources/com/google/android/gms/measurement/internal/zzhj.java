package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhj implements ServiceConnection {
    final /* synthetic */ zzhk zza;
    private final String zzb;

    public zzhj(zzhk zzhkVar, String str) {
        Objects.requireNonNull(zzhkVar);
        this.zza = zzhkVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzaW().zze().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzbs zzbsVarZzb = com.google.android.gms.internal.measurement.zzbr.zzb(iBinder);
            zzhk zzhkVar = this.zza;
            if (zzbsVarZzb == null) {
                zzhkVar.zza.zzaW().zze().zza("Install Referrer Service implementation was not found");
                return;
            }
            zzic zzicVar = zzhkVar.zza;
            zzicVar.zzaW().zzk().zza("Install Referrer Service connected");
            zzicVar.zzaX().zzj(new zzhi(this, zzbsVarZzb, this));
        } catch (RuntimeException e) {
            this.zza.zza.zzaW().zze().zzb("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzaW().zzk().zza("Install Referrer Service disconnected");
    }

    public final /* synthetic */ String zza() {
        return this.zzb;
    }
}
