package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzckv implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcdn zza;
    final /* synthetic */ zzclf zzb;

    public zzckv(zzclf zzclfVar, zzcdn zzcdnVar) {
        this.zza = zzcdnVar;
        Objects.requireNonNull(zzclfVar);
        this.zzb = zzclfVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzZ(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
