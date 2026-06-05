package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfvr extends BroadcastReceiver {
    final /* synthetic */ zzfvs zza;

    public zzfvr(zzfvs zzfvsVar) {
        Objects.requireNonNull(zzfvsVar);
        this.zza = zzfvsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzfvs zzfvsVar = this.zza;
            zzfvsVar.zzd(true, zzfvsVar.zzf());
            zzfvsVar.zze(true);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfvs zzfvsVar2 = this.zza;
            zzfvsVar2.zzd(false, zzfvsVar2.zzf());
            zzfvsVar2.zze(false);
        }
    }
}
