package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzb implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzc zzc;

    public zzb(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.zza = lifecycleCallback;
        this.zzb = str;
        Objects.requireNonNull(zzcVar);
        this.zzc = zzcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzc zzcVar = this.zzc;
        if (zzcVar.zzm() > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            if (zzcVar.zzn() != null) {
                bundle = zzcVar.zzn().getBundle(this.zzb);
            } else {
                bundle = null;
            }
            lifecycleCallback.onCreate(bundle);
        }
        if (zzcVar.zzm() >= 2) {
            this.zza.onStart();
        }
        if (zzcVar.zzm() >= 3) {
            this.zza.onResume();
        }
        if (zzcVar.zzm() >= 4) {
            this.zza.onStop();
        }
        if (zzcVar.zzm() >= 5) {
            this.zza.onDestroy();
        }
    }
}
