package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface zzcp extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(zzcs zzcsVar);

    void getAppInstanceId(zzcs zzcsVar);

    void getCachedAppInstanceId(zzcs zzcsVar);

    void getConditionalUserProperties(String str, String str2, zzcs zzcsVar);

    void getCurrentScreenClass(zzcs zzcsVar);

    void getCurrentScreenName(zzcs zzcsVar);

    void getGmpAppId(zzcs zzcsVar);

    void getMaxUserProperties(String str, zzcs zzcsVar);

    void getSessionId(zzcs zzcsVar);

    void getTestFlag(zzcs zzcsVar, int i);

    void getUserProperties(String str, String str2, boolean z, zzcs zzcsVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j);

    void initializeWithElapsedTime(IObjectWrapper iObjectWrapper, zzdb zzdbVar, long j, long j2);

    void isDataCollectionEnabled(zzcs zzcsVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcs zzcsVar, long j);

    void logEventWithElapsedTime(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2);

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j);

    void onActivityCreatedByScionActivityInfo(zzdd zzddVar, Bundle bundle, long j);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j);

    void onActivityDestroyedByScionActivityInfo(zzdd zzddVar, long j);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j);

    void onActivityPausedByScionActivityInfo(zzdd zzddVar, long j);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j);

    void onActivityResumedByScionActivityInfo(zzdd zzddVar, long j);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcs zzcsVar, long j);

    void onActivitySaveInstanceStateByScionActivityInfo(zzdd zzddVar, zzcs zzcsVar, long j);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j);

    void onActivityStartedByScionActivityInfo(zzdd zzddVar, long j);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j);

    void onActivityStoppedByScionActivityInfo(zzdd zzddVar, long j);

    void performAction(Bundle bundle, zzcs zzcsVar, long j);

    void registerOnMeasurementEventListener(zzcy zzcyVar);

    void resetAnalyticsData(long j);

    void resetAnalyticsDataWithElapsedTime(long j, long j2);

    void retrieveAndUploadBatches(zzcv zzcvVar);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j);

    void setCurrentScreenByScionActivityInfo(zzdd zzddVar, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzcy zzcyVar);

    void setInstanceIdProvider(zzda zzdaVar);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j);

    void unregisterOnMeasurementEventListener(zzcy zzcyVar);
}
