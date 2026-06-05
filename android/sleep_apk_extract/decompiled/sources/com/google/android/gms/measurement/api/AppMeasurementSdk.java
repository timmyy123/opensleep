package com.google.android.gms.measurement.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzez;

/* JADX INFO: loaded from: classes3.dex */
public class AppMeasurementSdk {
    private final zzez zza;

    public AppMeasurementSdk(zzez zzezVar) {
        this.zza = zzezVar;
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzez.zza(context, null).zzb();
    }

    public void beginAdUnitExposure(String str) {
        this.zza.zzu(str);
    }

    public void endAdUnitExposure(String str) {
        this.zza.zzv(str);
    }

    public long generateEventId() {
        return this.zza.zzz();
    }

    public String getAppInstanceId() {
        return this.zza.zzy();
    }

    public String getGmpAppId() {
        return this.zza.zzx();
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzi(str, str2, bundle);
    }
}
