package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;

/* JADX INFO: loaded from: classes3.dex */
final class zzbz extends zzby {
    final /* synthetic */ zzgr zza;
    final /* synthetic */ Payload zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbz(zzcd zzcdVar, zzgr zzgrVar, Payload payload) {
        super(null);
        this.zza = zzgrVar;
        this.zzb = payload;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((PayloadCallback) obj).onPayloadReceived(this.zza.zzb(), this.zzb);
    }
}
