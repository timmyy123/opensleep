package com.google.android.gms.internal.nearby;

/* JADX INFO: loaded from: classes3.dex */
final class zzbl extends zzby {
    final /* synthetic */ zzgl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbl(zzbp zzbpVar, zzgl zzglVar) {
        super(null);
        this.zza = zzglVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.zza.zzc();
        this.zza.zza();
        this.zza.zzb();
    }
}
