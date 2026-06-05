package com.urbandroid.sleep.activityrecognition;

import android.content.Context;
import android.os.SystemClock;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.location.ActivityTransitionEvent;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0013\u001a\u00020\u000b*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r\"\u0015\u0010\u0015\u001a\u00020\u000b*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r\"\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0002*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017\"\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\"\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017\"\u0015\u0010\u001e\u001a\u00020\u001b*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "isActivityRecognitionNeeded", "(Landroid/content/Context;)Z", "Lkotlin/Function0;", "", "block", "whenActivityRecognitionNeeded", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "Lcom/google/android/gms/location/ActivityTransitionEvent;", "", "pretty", "(Lcom/google/android/gms/location/ActivityTransitionEvent;)Ljava/lang/String;", "", "type", "resolveActivityType", "(I)Ljava/lang/String;", "getActivity", "activity", "getTransition", "transition", "isDerivedStillEnter", "(Lcom/google/android/gms/location/ActivityTransitionEvent;)Z", "isStillExit", "isExit", "isEnter", "", "getTimestamp", "(Lcom/google/android/gms/location/ActivityTransitionEvent;)J", "timestamp", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ActivitityrecognitionKt {
    public static final String getActivity(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return resolveActivityType(activityTransitionEvent.getActivityType());
    }

    public static final long getTimestamp(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return (activityTransitionEvent.getElapsedRealTimeNanos() / 1000000) + (System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    public static final String getTransition(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        int transitionType = activityTransitionEvent.getTransitionType();
        return transitionType != 0 ? transitionType != 1 ? "..." : "EXIT" : "ENTER";
    }

    public static final boolean isActivityRecognitionNeeded(Context context) {
        context.getClass();
        Settings settings = ContextExtKt.getSettings(context);
        return settings.getAutoStartMode() == 1 || settings.getSleepTimeSuggestionMode() != SleepTimeSuggestionManager.Mode.DISABLED;
    }

    public static final boolean isDerivedStillEnter(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return (activityTransitionEvent.getTransitionType() == 1 && activityTransitionEvent.getActivityType() != 3) || (activityTransitionEvent.getTransitionType() == 0 && activityTransitionEvent.getActivityType() == 3);
    }

    public static final boolean isEnter(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return activityTransitionEvent.getTransitionType() == 0;
    }

    public static final boolean isExit(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return activityTransitionEvent.getTransitionType() == 1;
    }

    public static final boolean isStillExit(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return (activityTransitionEvent.getTransitionType() == 1 && activityTransitionEvent.getActivityType() == 3) || (activityTransitionEvent.getTransitionType() == 0 && activityTransitionEvent.getActivityType() != 3);
    }

    public static final String pretty(ActivityTransitionEvent activityTransitionEvent) {
        activityTransitionEvent.getClass();
        return Fragment$$ExternalSyntheticOutline1.m(getActivity(activityTransitionEvent), ":", getTransition(activityTransitionEvent), " ", Utils.getPrettyDate(getTimestamp(activityTransitionEvent)));
    }

    public static final String resolveActivityType(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 6:
            default:
                return "...";
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
        }
    }

    public static final void whenActivityRecognitionNeeded(Context context, Function0<Unit> function0) {
        context.getClass();
        function0.getClass();
        if (isActivityRecognitionNeeded(context)) {
            function0.invoke();
            return;
        }
        Logger.logInfo("activity: autotracking and estimates not enabled -> disabling activity recognition", null);
        ActivityRecognitionInitializer.Companion companion = ActivityRecognitionInitializer.INSTANCE;
        companion.transitions(context).destroy();
        companion.updates(context).destroy();
    }
}
