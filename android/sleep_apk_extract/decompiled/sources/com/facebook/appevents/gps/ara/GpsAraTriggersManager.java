package com.facebook.appevents.gps.ara;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsDebugLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt;
import oauth.signpost.OAuth;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/gps/ara/GpsAraTriggersManager;", "", "()V", "GPS_PREFIX", "", "REPLACEMENT_STRING", "TAG", "enabled", "", "gpsDebugLogger", "Lcom/facebook/appevents/gps/GpsDebugLogger;", "serverUri", "canRegisterTrigger", "enable", "", "getEventParameters", "event", "Lcom/facebook/appevents/AppEvent;", "isValidEvent", "registerTrigger", "applicationId", "registerTriggerAsync", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GpsAraTriggersManager {
    private static final String GPS_PREFIX = "gps";
    public static final GpsAraTriggersManager INSTANCE = new GpsAraTriggersManager();
    private static final String REPLACEMENT_STRING = "_removed_";
    private static final String TAG;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static String serverUri;

    static {
        String string = GpsAraTriggersManager.class.toString();
        string.getClass();
        TAG = string;
    }

    private GpsAraTriggersManager() {
    }

    public static final /* synthetic */ GpsDebugLogger access$getGpsDebugLogger$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return null;
        }
        try {
            return gpsDebugLogger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
            return null;
        }
    }

    private final boolean canRegisterTrigger() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (!enabled || Build.VERSION.SDK_INT < 33) {
                return false;
            }
            GpsDebugLogger gpsDebugLogger2 = null;
            try {
                Class.forName("android.adservices.measurement.MeasurementManager");
                Class.forName("android.os.OutcomeReceiver");
                return true;
            } catch (Error e) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                if (gpsDebugLogger3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger3;
                }
                Bundle bundle = new Bundle();
                bundle.putString(Constants.GPS_ARA_FAILED_REASON, e.toString());
                Unit unit = Unit.INSTANCE;
                gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle);
                return false;
            } catch (Exception e2) {
                Log.i(TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                if (gpsDebugLogger4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                } else {
                    gpsDebugLogger2 = gpsDebugLogger4;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(Constants.GPS_ARA_FAILED_REASON, e2.toString());
                Unit unit2 = Unit.INSTANCE;
                gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle2);
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            enabled = true;
            gpsDebugLogger = new GpsDebugLogger(FacebookSdk.getApplicationContext());
            serverUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/mobile/register/trigger";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    private final String getEventParameters(AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final JSONObject jsonObject = event.getJsonObject();
            if (jsonObject != null && jsonObject.length() != 0) {
                Iterator<String> itKeys = jsonObject.keys();
                itKeys.getClass();
                this = SequencesKt___SequencesKt.joinToString$default(SequencesKt.mapNotNull(SequencesKt.asSequence(itKeys), new Function1<String, String>() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager.getEventParameters.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(String str) {
                        Object objOpt = jsonObject.opt(str);
                        if (objOpt == null) {
                            return null;
                        }
                        try {
                            return URLEncoder.encode(str, OAuth.ENCODING) + '=' + URLEncoder.encode(objOpt.toString(), OAuth.ENCODING);
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }), "&", null, null, 0, null, null, 62, null);
                return this;
            }
            return "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isValidEvent(AppEvent event) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String string = event.getJsonObject().getString(Constants.EVENT_NAME_EVENT_KEY);
                if (!Intrinsics.areEqual(string, REPLACEMENT_STRING)) {
                    string.getClass();
                    if (!StringsKt.contains$default(string, GPS_PREFIX)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerTriggerAsync$lambda$0(String str, AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            str.getClass();
            appEvent.getClass();
            INSTANCE.registerTrigger(str, appEvent);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    public final void registerTrigger(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            applicationId.getClass();
            event.getClass();
            if (isValidEvent(event) && canRegisterTrigger()) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                GpsDebugLogger gpsDebugLogger2 = null;
                try {
                    try {
                        MeasurementManager measurementManagerM = FacebookSdk$$ExternalSyntheticLambda1.m(applicationContext.getSystemService(FacebookSdk$$ExternalSyntheticLambda1.m$1()));
                        if (measurementManagerM == null) {
                            measurementManagerM = MeasurementManager.get(applicationContext.getApplicationContext());
                        }
                        if (measurementManagerM == null) {
                            Log.w(TAG, "FAILURE_GET_MEASUREMENT_MANAGER");
                            GpsDebugLogger gpsDebugLogger3 = gpsDebugLogger;
                            if (gpsDebugLogger3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                                gpsDebugLogger3 = null;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.GPS_ARA_FAILED_REASON, "Failed to get measurement manager");
                            Unit unit = Unit.INSTANCE;
                            gpsDebugLogger3.log(Constants.GPS_ARA_FAILED, bundle);
                            return;
                        }
                        String eventParameters = getEventParameters(event);
                        StringBuilder sb = new StringBuilder();
                        String str = serverUri;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("serverUri");
                            str = null;
                        }
                        sb.append(str);
                        sb.append("?app_id=");
                        sb.append(applicationId);
                        sb.append('&');
                        sb.append(eventParameters);
                        Uri uri = Uri.parse(sb.toString());
                        uri.getClass();
                        measurementManagerM.registerTrigger(uri, FacebookSdk.getExecutor(), new OutcomeReceiver() { // from class: com.facebook.appevents.gps.ara.GpsAraTriggersManager$registerTrigger$outcomeReceiver$1
                            public void onError(Exception error) {
                                error.getClass();
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_FAILURE");
                                GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                                if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                                    gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                                }
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(Constants.GPS_ARA_FAILED_REASON, error.toString());
                                Unit unit2 = Unit.INSTANCE;
                                gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_ARA_FAILED, bundle2);
                            }

                            public void onResult(Object result) {
                                result.getClass();
                                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_SUCCESS");
                                GpsDebugLogger gpsDebugLoggerAccess$getGpsDebugLogger$p = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                                if (gpsDebugLoggerAccess$getGpsDebugLogger$p == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                                    gpsDebugLoggerAccess$getGpsDebugLogger$p = null;
                                }
                                gpsDebugLoggerAccess$getGpsDebugLogger$p.log(Constants.GPS_ARA_SUCCEED, null);
                            }
                        });
                    } catch (Exception e) {
                        Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                        GpsDebugLogger gpsDebugLogger4 = gpsDebugLogger;
                        if (gpsDebugLogger4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                        } else {
                            gpsDebugLogger2 = gpsDebugLogger4;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(Constants.GPS_ARA_FAILED_REASON, e.toString());
                        Unit unit2 = Unit.INSTANCE;
                        gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle2);
                    }
                } catch (Error e2) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                    GpsDebugLogger gpsDebugLogger5 = gpsDebugLogger;
                    if (gpsDebugLogger5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gpsDebugLogger");
                    } else {
                        gpsDebugLogger2 = gpsDebugLogger5;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(Constants.GPS_ARA_FAILED_REASON, e2.toString());
                    Unit unit3 = Unit.INSTANCE;
                    gpsDebugLogger2.log(Constants.GPS_ARA_FAILED, bundle3);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void registerTriggerAsync(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            applicationId.getClass();
            event.getClass();
            FacebookSdk.getExecutor().execute(new GpsAraTriggersManager$$ExternalSyntheticLambda0(applicationId, event, 0));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
