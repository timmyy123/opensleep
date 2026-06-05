package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* JADX INFO: loaded from: classes3.dex */
final class zzba extends zzby {
    final /* synthetic */ zzgh zza;
    final /* synthetic */ Status zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzba(zzbf zzbfVar, zzgh zzghVar, Status status) {
        super(null);
        this.zza = zzghVar;
        this.zzb = status;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((ConnectionLifecycleCallback) obj).onConnectionResult(this.zza.zzb(), new ConnectionResolution(this.zzb));
    }
}
