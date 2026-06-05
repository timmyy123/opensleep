package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbyc implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbyd zza;

    public zzbyc(zzbyd zzbydVar) {
        Objects.requireNonNull(zzbydVar);
        this.zza = zzbydVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzg("User canceled the download.");
    }
}
