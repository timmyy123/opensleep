package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbb implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzbe zza;
    private final Activity zzb;

    public zzbb(zzbe zzbeVar, Activity activity) {
        Objects.requireNonNull(zzbeVar);
        this.zza = zzbeVar;
        this.zzb = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        this.zza.zzc.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzbe zzbeVar = this.zza;
        if (zzbeVar.zzi == null || !zzbeVar.zza) {
            return;
        }
        zzbeVar.zzi.setOwnerActivity(activity);
        if (zzbeVar.zzd != null) {
            zzbeVar.zzd.zza(activity);
        }
        zzbb zzbbVar = (zzbb) zzbeVar.zzn.getAndSet(null);
        if (zzbbVar != null) {
            zzbbVar.zzb();
            zzbb zzbbVar2 = new zzbb(zzbeVar, activity);
            zzbeVar.zzc.registerActivityLifecycleCallbacks(zzbbVar2);
            zzbeVar.zzn.set(zzbbVar2);
        }
        if (zzbeVar.zzi != null) {
            zzbeVar.zzi.show();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (activity != this.zzb) {
            return;
        }
        if (activity.isChangingConfigurations()) {
            zzbe zzbeVar = this.zza;
            if (zzbeVar.zza && zzbeVar.zzi != null) {
                zzbeVar.zzi.dismiss();
                return;
            }
        }
        this.zza.zzh(new zzg(3, "Activity is destroyed."));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
