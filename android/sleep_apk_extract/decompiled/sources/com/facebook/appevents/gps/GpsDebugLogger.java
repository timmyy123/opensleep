package com.facebook.appevents.gps;

import android.content.Context;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.InternalAppEventsLogger;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/gps/GpsDebugLogger;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "(Landroid/content/Context;)V", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "isGPSDebugEvent", "", "eventName", "", "log", "", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Landroid/os/Bundle;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GpsDebugLogger {
    private static final String GPS_PREFIX = "gps";
    private static final double LOGGING_SAMPLING_RATE = 1.0E-4d;
    private static final boolean shouldLog;
    private final InternalAppEventsLogger internalAppEventsLogger;

    static {
        shouldLog = Random.INSTANCE.nextDouble() <= LOGGING_SAMPLING_RATE;
    }

    public GpsDebugLogger(Context context) {
        context.getClass();
        this.internalAppEventsLogger = new InternalAppEventsLogger(context);
    }

    private final boolean isGPSDebugEvent(String eventName) {
        if (eventName != null) {
            return StringsKt.contains$default(eventName, GPS_PREFIX);
        }
        return false;
    }

    public final void log(String eventName, Bundle parameters) {
        if (shouldLog && isGPSDebugEvent(eventName)) {
            this.internalAppEventsLogger.logEventImplicitly(eventName, parameters);
        }
    }
}
