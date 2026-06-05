package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzql extends BroadcastReceiver {
    final /* synthetic */ zzqn zza;

    public /* synthetic */ zzql(zzqn zzqnVar, byte[] bArr) {
        Objects.requireNonNull(zzqnVar);
        this.zza = zzqnVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzqn zzqnVar = this.zza;
        zzqnVar.zzh(zzqh.zzb(context, intent, zzqnVar.zzl(), zzqnVar.zzj(), zzqnVar.zzg()));
    }
}
