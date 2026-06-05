package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbeo extends BroadcastReceiver {
    final /* synthetic */ zzbes zza;

    public zzbeo(zzbes zzbesVar) {
        Objects.requireNonNull(zzbesVar);
        this.zza = zzbesVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zza.zzg(3);
    }
}
