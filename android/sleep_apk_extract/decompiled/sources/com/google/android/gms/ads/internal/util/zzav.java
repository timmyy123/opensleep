package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzav implements DialogInterface.OnClickListener {
    final /* synthetic */ Context zza;

    public zzav(zzaw zzawVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzawVar);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzt.zzc();
        zzs.zzZ(this.zza, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
