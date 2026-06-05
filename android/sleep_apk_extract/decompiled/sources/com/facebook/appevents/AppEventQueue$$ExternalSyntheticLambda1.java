package com.facebook.appevents;

import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.urbandroid.sleep.smartwatch.garmin.GarminProviderService;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppEventQueue$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AppEventQueue$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                AppEventQueue.persistToDisk$lambda$1();
                break;
            case 1:
                AnalyticsUserIDStore.initStore$lambda$0();
                break;
            case 2:
                AppEventQueue.flushRunnable$lambda$0();
                break;
            case 3:
                AppEventsLoggerImpl.Companion.initializeTimersIfNeeded$lambda$6();
                break;
            case 4:
                UserDataStore.clear$lambda$2();
                break;
            case 5:
                MetadataIndexer.enable$lambda$0();
                break;
            case 6:
                InAppPurchaseActivityLifecycleTracker.AnonymousClass2.onActivityStopped$lambda$1();
                break;
            case 7:
                InAppPurchaseActivityLifecycleTracker.AnonymousClass2.onActivityResumed$lambda$0();
                break;
            case 8:
                InAppPurchaseManager.startTracking();
                break;
            case 9:
                ActivityLifecycleTracker.onActivityCreated$lambda$1();
                break;
            case 10:
                ModelManager.enableMTML$lambda$1();
                break;
            case 11:
                ModelManager.enableMTML$lambda$2();
                break;
            case 12:
                ModelManager.enable$lambda$0();
                break;
            case 13:
                SuggestedEventsManager.enable$lambda$0();
                break;
            case 14:
                ANRDetector.anrDetectorRunnable$lambda$0();
                break;
            case 15:
                AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
                break;
            default:
                GarminProviderService.lambda$new$0();
                break;
        }
    }
}
