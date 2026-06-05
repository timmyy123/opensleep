package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzaw implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    public zzaw(zzax zzaxVar, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        Objects.requireNonNull(zzaxVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzc();
        Context context = this.zza;
        AlertDialog.Builder builderZzN = zzs.zzN(context);
        builderZzN.setMessage(this.zzb);
        if (this.zzc) {
            builderZzN.setTitle("Error");
        } else {
            builderZzN.setTitle("Info");
        }
        if (this.zzd) {
            builderZzN.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderZzN.setPositiveButton("Learn More", new zzav(this, context));
            builderZzN.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderZzN.create().show();
    }
}
