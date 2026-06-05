package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/DefaultRingtoneResolveService;", "Landroidx/core/app/FixedJobIntentService;", "<init>", "()V", "onHandleWork", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "DefaultRingtoneCallback", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultRingtoneResolveService extends FixedJobIntentService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/DefaultRingtoneResolveService$Companion;", "", "<init>", "()V", "ACTION_DEFAULT_RINGTONE_RESOLVE", "", "storeActualDefaultRingtoneUri", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "callback", "Lcom/urbandroid/sleep/alarmclock/DefaultRingtoneResolveService$DefaultRingtoneCallback;", "start", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            Settings settings = ContextExtKt.getSettings(context);
            if (settings.isTimeToRefreshActualDefaultRingtoneUri()) {
                Logger.logInfo("ActualDefaultRingtoneUri enqueue", null);
                settings.setActualDefaultRingtoneUriLastRefresh();
                JobIntentService.enqueueWork(context, (Class<?>) DefaultRingtoneResolveService.class, 671, new Intent("com.urbandroid.sleep.alarmclock.ACTION_DEFAULT_RINGTONE_RESOLVE"));
            }
        }

        public final void storeActualDefaultRingtoneUri(Context context) {
            context.getClass();
            Settings settings = ContextExtKt.getSettings(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(context, 4);
                    String string = actualDefaultRingtoneUri != null ? actualDefaultRingtoneUri.toString() : null;
                    settings.setActualDefaultRingtoneUri(string);
                    Logger.logInfo("ActualDefaultRingtoneUri found: " + string, null);
                    Logger.logDebug("ActualDefaultRingtoneUri uri resolved " + settings.getActualDefaultRingtoneUri() + " in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms", null);
                } catch (Exception e) {
                    Logger.logWarning("ActualDefaultRingtoneUri retrieve failure", e);
                    Logger.logDebug("ActualDefaultRingtoneUri uri resolved " + settings.getActualDefaultRingtoneUri() + " in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms", null);
                }
            } catch (Throwable th) {
                Logger.logDebug("ActualDefaultRingtoneUri uri resolved " + settings.getActualDefaultRingtoneUri() + " in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms", null);
                throw th;
            }
        }

        private Companion() {
        }

        public final void storeActualDefaultRingtoneUri(Context context, DefaultRingtoneCallback callback) {
            context.getClass();
            callback.getClass();
            Utils.doAsyncThrowOnUI(this, new DefaultRingtoneResolveService$Companion$storeActualDefaultRingtoneUri$1(context, callback, null));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/DefaultRingtoneResolveService$DefaultRingtoneCallback;", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface DefaultRingtoneCallback {
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    public static final void storeActualDefaultRingtoneUri(Context context, DefaultRingtoneCallback defaultRingtoneCallback) {
        INSTANCE.storeActualDefaultRingtoneUri(context, defaultRingtoneCallback);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        intent.getClass();
        GlobalInitializator.initializeIfRequired(this);
        Companion companion = INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        companion.storeActualDefaultRingtoneUri(applicationContext);
    }
}
