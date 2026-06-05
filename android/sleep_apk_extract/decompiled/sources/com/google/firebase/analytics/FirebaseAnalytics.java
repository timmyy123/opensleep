package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzez;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzez zzb;

    /* JADX INFO: loaded from: classes3.dex */
    public enum ConsentStatus {
        GRANTED,
        DENIED
    }

    /* JADX INFO: loaded from: classes3.dex */
    public enum ConsentType {
        AD_STORAGE,
        ANALYTICS_STORAGE,
        AD_USER_DATA,
        AD_PERSONALIZATION
    }

    public FirebaseAnalytics(zzez zzezVar) {
        Preconditions.checkNotNull(zzezVar);
        this.zzb = zzezVar;
    }

    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (zza == null) {
                        zza = new FirebaseAnalytics(zzez.zza(context, null));
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    public static zzlk getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzez zzezVarZza = zzez.zza(context, bundle);
        if (zzezVarZza == null) {
            return null;
        }
        return new zzd(zzezVarZza);
    }

    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.getInstance().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        } catch (ExecutionException e2) {
            Events$$ExternalSyntheticBUOutline0.m(e2.getCause());
            return null;
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public void logEvent(String str, Bundle bundle) {
        this.zzb.zzh(str, bundle);
    }

    public void setAnalyticsCollectionEnabled(boolean z) {
        this.zzb.zzq(Boolean.valueOf(z));
    }

    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzb.zzp(zzdd.zza(activity), str, str2);
    }
}
