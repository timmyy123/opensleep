package com.urbandroid.sleep.service.google.calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ComponentUtil;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = "calendar:receiver";
    private static final AtomicBoolean registered = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarChangeReceiver$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setEnabled", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "enable", "", "register", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return GoogleCalendarChangeReceiver.tag;
        }

        public final void register(Context context) {
            context.getClass();
            if (Build.VERSION.SDK_INT >= 26 && !GoogleCalendarChangeReceiver.registered.get()) {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PROVIDER_CHANGED");
                    intentFilter.addDataScheme("content");
                    intentFilter.addDataAuthority("com.android.calendar", null);
                    ContextCompat.registerReceiver(context, new GoogleCalendarChangeReceiver(), intentFilter, 2);
                    Logger.logInfo(Logger.defaultTag, getTag() + ": receiver registered", null);
                } finally {
                    GoogleCalendarChangeReceiver.registered.set(true);
                }
            }
        }

        public final void setEnabled(Context context, boolean enable) {
            context.getClass();
            ComponentUtil.setEnabled(context, GoogleCalendarChangeReceiver.class, enable);
            if (enable) {
                register(context);
            }
        }

        private Companion() {
        }
    }

    public static final void setEnabled(Context context, boolean z) {
        INSTANCE.setEnabled(context, z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        GlobalInitializator.initializeIfRequired(context);
        Companion companion = INSTANCE;
        Logger.logInfo(Logger.defaultTag, companion.getTag() + ": calendar/event change received", null);
        GoogleCalendarSynchronizationService.INSTANCE.start(context);
    }
}
