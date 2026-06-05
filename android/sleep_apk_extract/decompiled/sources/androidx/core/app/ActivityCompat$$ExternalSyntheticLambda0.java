package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.view.ProcessLifecycleOwner;
import androidx.work.ListenableFutureKt;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushReason;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.suggestedevents.ViewObserver;
import com.facebook.bolts.CancellationTokenSource;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.FileLruCache;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.firebase.installations.FirebaseInstallations;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.settings.BedtimeNoAlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.GentleSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackAutoSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity;
import com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.gui.PreferenceActivity;
import java.io.File;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ActivityCompat.lambda$recreate$0((Activity) obj);
                break;
            case 1:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) obj);
                break;
            case 2:
                ListenableFutureKt.launchFuture$lambda$1$lambda$0((Job) obj);
                break;
            case 3:
                AppEventQueue.flush$lambda$2((FlushReason) obj);
                break;
            case 4:
                UserDataStore.setUserDataAndHash$lambda$1((Bundle) obj);
                break;
            case 5:
                AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint$lambda$0((GraphRequest) obj);
                break;
            case 6:
                CodelessMatcher.startTracking$lambda$1((CodelessMatcher) obj);
                break;
            case 7:
                ViewObserver.process$lambda$0((ViewObserver) obj);
                break;
            case 8:
                CancellationTokenSource.cancelAfter$lambda$6$lambda$5((CancellationTokenSource) obj);
                break;
            case 9:
                Task.Companion.delay$lambda$0((TaskCompletionSource) obj);
                break;
            case 10:
                FacebookWebFallbackDialog.cancel$lambda$0((FacebookWebFallbackDialog) obj);
                break;
            case 11:
                ((FetchedAppGateKeepersManager.Callback) obj).onCompleted();
                break;
            case 12:
                ((FetchedAppSettingsManager.FetchedAppSettingsCallback) obj).onError();
                break;
            case 13:
                FileLruCache.clearCache$lambda$1((File[]) obj);
                break;
            case 14:
                FileLruCache.postTrim$lambda$3$lambda$2((FileLruCache) obj);
                break;
            case 15:
                DeviceAuthDialog.schedulePoll$lambda$3((DeviceAuthDialog) obj);
                break;
            case 16:
                ToolTipPopup.show$lambda$2((ToolTipPopup) obj);
                break;
            case 17:
                ((WorkInitializer) obj).lambda$ensureContextsScheduled$1();
                break;
            case 18:
                ((MaterialButton) obj).lambda$setOpticalCenterEnabled$5();
                break;
            case 19:
                ((CarouselLayoutManager) obj).refreshKeylineState();
                break;
            case 20:
                ViewUtils.requestFocusAndShowKeyboard((View) obj, false);
                break;
            case 21:
                ((MaterialBackOrchestrator) obj).startListeningForBackCallbacksWithPriorityOverlay();
                break;
            case 22:
                ((FirebaseInstallations) obj).lambda$getId$1();
                break;
            case 23:
                Alarms.setNextAlert((BedtimeNoAlarmSettingsActivity) obj);
                break;
            case 24:
                BedtimeSettingsActivity.updateGoalRunnable$lambda$0((BedtimeSettingsActivity) obj);
                break;
            case 25:
                ((GentleSettingsActivity) obj).lambda$refresh$2();
                break;
            case 26:
                SmartwatchSettingsActivity.lambda$regularWearableSelected$1((PreferenceActivity) obj);
                break;
            case 27:
                ((TrackAutoSettingsActivity) obj).lambda$onRequestPermissionsResult$2();
                break;
            case 28:
                ((TrackSettingsActivity) obj).lambda$onRequestPermissionsResult$8();
                break;
            default:
                MaterialTimePicker.setState$lambda$1((com.google.android.material.timepicker.MaterialTimePicker) obj);
                break;
        }
    }
}
