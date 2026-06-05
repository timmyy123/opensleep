package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzeq extends BroadcastReceiver {
    final /* synthetic */ zzer zza;

    public /* synthetic */ zzeq(zzer zzerVar, byte[] bArr) {
        Objects.requireNonNull(zzerVar);
        this.zza = zzerVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, Intent intent) {
        this.zza.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzep
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza.zzd(context);
            }
        });
    }
}
