package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzky implements Application.ActivityLifecycleCallbacks, zzkw {
    final /* synthetic */ zzlj zza;

    public zzky(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.zza = zzljVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        zza(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006a  */
    @Override // com.google.android.gms.measurement.internal.zzkw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar, Bundle bundle) throws Throwable {
        zzky zzkyVar;
        zzic zzicVar;
        zzlj zzljVar;
        zzic zzicVar2;
        Intent intent;
        Uri uri;
        try {
            try {
                zzljVar = this.zza;
                zzicVar2 = zzljVar.zzu;
                zzicVar2.zzaW().zzk().zza("onActivityCreated");
                intent = zzddVar.zzc;
            } catch (Throwable th) {
                th = th;
                zzkyVar.zza.zzu.zzs().zzn(zzddVar, bundle);
                throw th;
            }
        } catch (RuntimeException e) {
            e = e;
            zzkyVar = this;
        } catch (Throwable th2) {
            th = th2;
            zzkyVar = this;
            zzkyVar.zza.zzu.zzs().zzn(zzddVar, bundle);
            throw th;
        }
        if (intent != null) {
            Uri data2 = intent.getData();
            if (data2 == null || !data2.isHierarchical()) {
                Bundle extras = intent.getExtras();
                uri = null;
                if (extras != null) {
                    String string = extras.getString("com.android.vending.referral_url");
                    if (!TextUtils.isEmpty(string)) {
                        data2 = Uri.parse(string);
                        uri = data2;
                    }
                }
                if (uri != null && uri.isHierarchical()) {
                    String str = !zzicVar2.zzk().zzj(intent) ? "gs" : "auto";
                    String queryParameter = uri.getQueryParameter("referrer");
                    zzkyVar = this;
                    try {
                        zzicVar2.zzaX().zzj(new zzkx(zzkyVar, bundle != null, uri, str, queryParameter));
                    } catch (RuntimeException e2) {
                        e = e2;
                        zzkyVar.zza.zzu.zzaW().zzb().zzb("Throwable caught in onActivityCreated", e);
                    }
                    zzicVar = zzkyVar.zza.zzu;
                }
            } else {
                uri = data2;
                if (uri != null) {
                    String str2 = !zzicVar2.zzk().zzj(intent) ? "gs" : "auto";
                    String queryParameter2 = uri.getQueryParameter("referrer");
                    zzkyVar = this;
                    zzicVar2.zzaX().zzj(new zzkx(zzkyVar, bundle != null, uri, str2, queryParameter2));
                    zzicVar = zzkyVar.zza.zzu;
                }
            }
            zzicVar.zzs().zzn(zzddVar, bundle);
        }
        zzicVar = zzljVar.zzu;
        zzicVar.zzs().zzn(zzddVar, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzb(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza.zzu.zzs().zzt(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzc(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzicVar.zzs().zzq(zzddVar);
        zzoc zzocVarZzh = zzicVar.zzh();
        zzic zzicVar2 = zzocVarZzh.zzu;
        zzicVar2.zzaX().zzj(new zznv(zzocVarZzh, zzicVar2.zzba().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzd(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzoc zzocVarZzh = zzicVar.zzh();
        zzic zzicVar2 = zzocVarZzh.zzu;
        zzicVar2.zzaX().zzj(new zznu(zzocVarZzh, zzicVar2.zzba().elapsedRealtime()));
        zzicVar.zzs().zzp(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zze(com.google.android.gms.internal.measurement.zzdd zzddVar, Bundle bundle) {
        this.zza.zzu.zzs().zzs(zzddVar, bundle);
    }
}
