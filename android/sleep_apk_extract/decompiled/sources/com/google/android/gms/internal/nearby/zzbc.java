package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;

/* JADX INFO: loaded from: classes3.dex */
final class zzbc extends zzby {
    final /* synthetic */ zzfz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbc(zzbf zzbfVar, zzfz zzfzVar) {
        super(null);
        this.zza = zzfzVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        String strZzc = this.zza.zzc();
        com.google.android.gms.nearby.connection.zze zzeVar = new com.google.android.gms.nearby.connection.zze();
        zzeVar.zzb(this.zza.zzb());
        zzeVar.zza(this.zza.zza());
        ((ConnectionLifecycleCallback) obj).onBandwidthChanged(strZzc, zzeVar.zzc());
    }
}
