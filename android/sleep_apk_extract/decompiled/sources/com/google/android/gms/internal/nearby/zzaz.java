package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* JADX INFO: loaded from: classes3.dex */
final class zzaz extends zzby {
    final /* synthetic */ zzgb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzbf zzbfVar, zzgb zzgbVar) {
        super(null);
        this.zza = zzgbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0053 A[PHI: r3
      0x0053: PHI (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:5:0x004d, B:7:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ConnectionLifecycleCallback connectionLifecycleCallback = (ConnectionLifecycleCallback) obj;
        String strZzc = this.zza.zzc();
        com.google.android.gms.nearby.connection.zzk zzkVar = new com.google.android.gms.nearby.connection.zzk();
        zzkVar.zzd(this.zza.zzd());
        zzkVar.zzb(this.zza.zzb());
        zzkVar.zzg(this.zza.zzg());
        zzkVar.zzf(this.zza.zzf());
        zzkVar.zzc(this.zza.zzh());
        zzkVar.zze(this.zza.zze());
        int iZza = this.zza.zza();
        int i = 0;
        if (iZza != 0) {
            int i2 = 1;
            if (iZza != 1) {
                i2 = 2;
                if (iZza == 2) {
                    i = i2;
                }
            }
        }
        zzkVar.zza(i);
        connectionLifecycleCallback.onConnectionInitiated(strZzc, zzkVar.zzh());
    }
}
