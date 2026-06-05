package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;

/* JADX INFO: loaded from: classes3.dex */
final class zzbm extends zzby {
    final /* synthetic */ zzgn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(zzbp zzbpVar, zzgn zzgnVar) {
        super(null);
        this.zza = zzgnVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        EndpointDiscoveryCallback endpointDiscoveryCallback = (EndpointDiscoveryCallback) obj;
        if (zzbp.zzg(this.zza)) {
            com.google.android.gms.nearby.connection.zzs zzsVar = new com.google.android.gms.nearby.connection.zzs();
            zzsVar.zzd(this.zza.zzd());
            zzsVar.zza(this.zza.zza());
            endpointDiscoveryCallback.onEndpointFound("__UNRECOGNIZED_BLUETOOTH_DEVICE__", zzsVar.zze());
            return;
        }
        String strZzb = this.zza.zzb();
        com.google.android.gms.nearby.connection.zzs zzsVar2 = new com.google.android.gms.nearby.connection.zzs();
        zzsVar2.zzd(this.zza.zzd());
        zzsVar2.zzc(this.zza.zzc());
        zzsVar2.zzb(this.zza.zze());
        endpointDiscoveryCallback.onEndpointFound(strZzb, zzsVar2.zze());
    }
}
