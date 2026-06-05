package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;

/* JADX INFO: loaded from: classes3.dex */
final class zzca extends zzby {
    final /* synthetic */ zzgt zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzca(zzcd zzcdVar, zzgt zzgtVar) {
        super(null);
        this.zza = zzgtVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzgt zzgtVar = this.zza;
        ((PayloadCallback) obj).onPayloadTransferUpdate(zzgtVar.zzb(), zzgtVar.zza());
    }
}
