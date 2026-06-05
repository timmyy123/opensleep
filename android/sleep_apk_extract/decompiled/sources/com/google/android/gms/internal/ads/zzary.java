package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzary implements ServiceConnection {
    final /* synthetic */ zzarz zza;
    private final zzasa zzb;

    public /* synthetic */ zzary(zzarz zzarzVar, zzasa zzasaVar, byte[] bArr) {
        Objects.requireNonNull(zzarzVar);
        this.zza = zzarzVar;
        this.zzb = zzasaVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzasc.zza("InstallReferrerClient", "Install Referrer service connected.");
        zzarz zzarzVar = this.zza;
        zzarzVar.zzf(zzbei.zzb(iBinder));
        zzarzVar.zze(2);
        this.zzb.zza(0);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzasc.zzb("InstallReferrerClient", "Install Referrer service disconnected.");
        zzarz zzarzVar = this.zza;
        zzarzVar.zzf(null);
        zzarzVar.zze(0);
    }
}
