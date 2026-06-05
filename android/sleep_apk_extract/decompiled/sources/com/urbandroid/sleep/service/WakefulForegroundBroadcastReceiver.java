package com.urbandroid.sleep.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepLockManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/urbandroid/sleep/service/WakefulForegroundBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class WakefulForegroundBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = new SparseArray<>();
    private static int mNextId = 1;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/service/WakefulForegroundBroadcastReceiver$Companion;", "", "<init>", "()V", "EXTRA_WAKE_LOCK_ID", "", "sActiveWakeLocks", "Landroid/util/SparseArray;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "mNextId", "", "startWakefulService", "Landroid/content/ComponentName;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "completeWakefulIntent", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean completeWakefulIntent(Intent intent) {
            intent.getClass();
            int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
            if (intExtra == 0) {
                return false;
            }
            synchronized (WakefulForegroundBroadcastReceiver.sActiveWakeLocks) {
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) WakefulForegroundBroadcastReceiver.sActiveWakeLocks.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    WakefulForegroundBroadcastReceiver.sActiveWakeLocks.remove(intExtra);
                    return true;
                }
                Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                return true;
            }
        }

        public final ComponentName startWakefulService(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            synchronized (WakefulForegroundBroadcastReceiver.sActiveWakeLocks) {
                try {
                    int i = WakefulForegroundBroadcastReceiver.mNextId;
                    WakefulForegroundBroadcastReceiver.mNextId++;
                    if (WakefulForegroundBroadcastReceiver.mNextId <= 0) {
                        WakefulForegroundBroadcastReceiver.mNextId = 1;
                    }
                    intent.putExtra("android.support.content.wakelockid", i);
                    ComponentName componentNameStartForegroundServiceWithLog = ContextExtKt.startForegroundServiceWithLog(context, intent);
                    if (componentNameStartForegroundServiceWithLog == null) {
                        return null;
                    }
                    Object systemService = context.getSystemService("power");
                    systemService.getClass();
                    PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, SleepLockManager.getWakeLockTag(context, "wake:" + componentNameStartForegroundServiceWithLog.flattenToShortString()));
                    wakeLockNewWakeLock.setReferenceCounted(false);
                    wakeLockNewWakeLock.acquire(60000L);
                    WakefulForegroundBroadcastReceiver.sActiveWakeLocks.put(i, wakeLockNewWakeLock);
                    return componentNameStartForegroundServiceWithLog;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }
    }
}
