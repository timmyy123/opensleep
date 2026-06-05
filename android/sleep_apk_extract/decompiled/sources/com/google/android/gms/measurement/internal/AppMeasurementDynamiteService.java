package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzco {
    zzic zza = null;
    private final Map zzb = new ArrayMap();

    private final void zzb() {
        if (this.zza != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Attempting to perform action before initialize.");
    }

    private final void zzc(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str) {
        zzb();
        this.zza.zzk().zzao(zzcsVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void beginAdUnitExposure(String str, long j) {
        zzb();
        this.zza.zzw().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzb();
        this.zza.zzj().zzaa(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void clearMeasurementEnabled(long j) {
        zzb();
        this.zza.zzj().zzn(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void endAdUnitExposure(String str, long j) {
        zzb();
        this.zza.zzw().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void generateEventId(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        long jZzd = this.zza.zzk().zzd();
        zzb();
        this.zza.zzk().zzap(zzcsVar, jZzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        this.zza.zzaX().zzj(new zzi(this, zzcsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        zzc(zzcsVar, this.zza.zzj().zzP());
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        this.zza.zzaX().zzj(new zzm(this, zzcsVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        zzc(zzcsVar, this.zza.zzj().zzad());
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        zzc(zzcsVar, this.zza.zzj().zzac());
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        zzc(zzcsVar, this.zza.zzj().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        this.zza.zzj().zzX(str);
        zzb();
        this.zza.zzk().zzaq(zzcsVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getSessionId(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzu.zzaX().zzj(new zzkm(zzljVarZzj, zzcsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getTestFlag(com.google.android.gms.internal.measurement.zzcs zzcsVar, int i) {
        zzb();
        if (i == 0) {
            this.zza.zzk().zzao(zzcsVar, this.zza.zzj().zzj());
            return;
        }
        if (i == 1) {
            this.zza.zzk().zzap(zzcsVar, this.zza.zzj().zzk().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzk().zzaq(zzcsVar, this.zza.zzj().zzl().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzk().zzas(zzcsVar, this.zza.zzj().zzi().booleanValue());
                return;
            }
        }
        zzpp zzppVarZzk = this.zza.zzk();
        double dDoubleValue = this.zza.zzj().zzm().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            zzppVarZzk.zzu.zzaW().zze().zzb("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        this.zza.zzaX().zzj(new zzk(this, zzcsVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void initForTests(Map map) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdb zzdbVar, long j) {
        zzic zzicVar = this.zza;
        if (zzicVar == null) {
            this.zza = zzic.zzy((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdbVar, Long.valueOf(j), null);
        } else {
            zzicVar.zzaW().zze().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void initializeWithElapsedTime(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdb zzdbVar, long j, long j2) {
        zzic zzicVar = this.zza;
        if (zzicVar == null) {
            this.zza = zzic.zzy((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdbVar, Long.valueOf(j), Long.valueOf(j2));
        } else {
            zzicVar.zzaW().zze().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzb();
        this.zza.zzaX().zzj(new zzn(this, zzcsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        this.zza.zzj().zzB(str, str2, bundle, z, z2, j, 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        zzb();
        Preconditions.checkNotEmpty(str2);
        String str3 = true != this.zza.zzc().zzp(null, zzfy.zzbf) ? "app" : "auto";
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", str3);
        this.zza.zzaX().zzj(new zzj(this, zzcsVar, new zzbh(str2, new zzbf(bundle), str3, j, 0L), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void logEventWithElapsedTime(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) {
        zzb();
        this.zza.zzj().zzB(str, str2, bundle, z, z2, j, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zzb();
        this.zza.zzaW().zzm(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        zzb();
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, Bundle bundle, long j) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zza(zzddVar, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, long j) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzb(zzddVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, long j) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzc(zzddVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, long j) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zzd(zzddVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        zzb();
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), zzcsVar, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        zzb();
        zzky zzkyVar = this.zza.zzj().zza;
        Bundle bundle = new Bundle();
        if (zzkyVar != null) {
            this.zza.zzj().zzh();
            zzkyVar.zze(zzddVar, bundle);
        }
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzaW().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, long j) {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        zzb();
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, long j) {
        zzb();
        if (this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        zzb();
        zzcsVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        zzjq zzqVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            try {
                zzqVar = (zzjq) map.get(Integer.valueOf(zzcyVar.zzf()));
                if (zzqVar == null) {
                    zzqVar = new zzq(this, zzcyVar);
                    map.put(Integer.valueOf(zzcyVar.zzf()), zzqVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zza.zzj().zzV(zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    @Deprecated
    public void resetAnalyticsData(long j) {
        zzb();
        this.zza.zzj().zzS(j, 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void resetAnalyticsDataWithElapsedTime(long j, long j2) {
        zzb();
        this.zza.zzj().zzS(j, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void retrieveAndUploadBatches(final com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        zzb();
        this.zza.zzj().zzt(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzcvVar.zze();
                } catch (RemoteException e) {
                    ((zzic) Preconditions.checkNotNull(this.zza.zza)).zzaW().zze().zzb("Failed to call IDynamiteUploadBatchesCallback", e);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setConditionalUserProperty(Bundle bundle, long j) {
        zzb();
        zzic zzicVar = this.zza;
        if (bundle == null) {
            zza$$ExternalSyntheticOutline0.m(zzicVar, "Conditional user property must not be null");
        } else {
            zzicVar.zzj().zzZ(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setConsent(Bundle bundle, long j) {
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setConsentThirdParty(Bundle bundle, long j) {
        zzb();
        this.zza.zzj().zzp(bundle, -20, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        zzb();
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd.zza((Activity) Preconditions.checkNotNull((Activity) ObjectWrapper.unwrap(iObjectWrapper))), str, str2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.zzdd zzddVar, String str, String str2, long j) {
        zzb();
        this.zza.zzs().zzk(zzddVar, str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setDataCollectionEnabled(boolean z) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzb();
        zzljVarZzj.zzu.zzaX().zzj(new zzjy(zzljVarZzj, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setDefaultEventParameters(Bundle bundle) {
        zzb();
        final zzlj zzljVarZzj = this.zza.zzj();
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzljVarZzj.zzu.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzljVarZzj.zzag(bundle2);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        zzb();
        zzp zzpVar = new zzp(this, zzcyVar);
        boolean zZze = this.zza.zzaX().zze();
        zzic zzicVar = this.zza;
        if (zZze) {
            zzicVar.zzj().zzU(zzpVar);
        } else {
            zzicVar.zzaX().zzj(new zzl(this, zzpVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzda zzdaVar) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setMeasurementEnabled(boolean z, long j) {
        zzb();
        this.zza.zzj().zzn(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setMinimumSessionDuration(long j) {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setSessionTimeoutDuration(long j) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        zzljVarZzj.zzu.zzaX().zzj(new zzka(zzljVarZzj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setSgtmDebugInfo(Intent intent) {
        zzb();
        zzlj zzljVarZzj = this.zza.zzj();
        Uri data2 = intent.getData();
        if (data2 == null) {
            zzljVarZzj.zzu.zzaW().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data2.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            zzic zzicVar = zzljVarZzj.zzu;
            zzicVar.zzaW().zzi().zza("[sgtm] Preview Mode was not enabled.");
            zzicVar.zzc().zzy(null);
        } else {
            String queryParameter2 = data2.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzic zzicVar2 = zzljVarZzj.zzu;
            zzicVar2.zzaW().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zzicVar2.zzc().zzy(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setUserId(final String str, long j) {
        zzb();
        final zzlj zzljVarZzj = this.zza.zzj();
        if (str != null && TextUtils.isEmpty(str)) {
            zzljVarZzj.zzu.zzaW().zze().zza("User ID must be non-empty or null");
        } else {
            zzljVarZzj.zzu.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzic zzicVar = zzljVarZzj.zzu;
                    if (zzicVar.zzv().zzq(str)) {
                        zzicVar.zzv().zzi();
                    }
                }
            });
            zzljVarZzj.zzK(null, "_id", str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        zzb();
        this.zza.zzj().zzK(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcp
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzcy zzcyVar) {
        zzjq zzqVar;
        zzb();
        Map map = this.zzb;
        synchronized (map) {
            zzqVar = (zzjq) map.remove(Integer.valueOf(zzcyVar.zzf()));
        }
        if (zzqVar == null) {
            zzqVar = new zzq(this, zzcyVar);
        }
        this.zza.zzj().zzW(zzqVar);
    }
}
