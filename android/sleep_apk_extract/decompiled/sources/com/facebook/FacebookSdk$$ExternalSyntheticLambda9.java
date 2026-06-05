package com.facebook;

import android.app.job.JobParameters;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.health.platform.client.impl.ipc.internal.DefaultExecutionTracker;
import androidx.room.TransactionExecutor;
import androidx.view.ComponentActivity;
import androidx.view.DispatchQueue;
import androidx.view.OnBackPressedDispatcher;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.greedy.TimeLimiter;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.SessionEventsState;
import com.facebook.appevents.aam.MetadataViewObserver;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.login.widget.LoginButton;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.material.button.MaterialButton;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.ai.type.AudioThreadFactory;
import com.urbandroid.sleep.PreviewActivity;
import com.urbandroid.sleep.Sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda9(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                FacebookSdk.publishInstallAsync$lambda$15((Context) obj2, (String) obj);
                break;
            case 1:
                ((ComponentActivity) obj2).addObserverForBackInvoker((OnBackPressedDispatcher) obj);
                break;
            case 2:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                break;
            case 3:
                FragmentStrictMode.m69handlePolicyViolation$lambda1((String) obj, (Violation) obj2);
                break;
            case 4:
                ((DefaultExecutionTracker) obj2).lambda$track$0((SettableFuture) obj);
                break;
            case 5:
                ((DispatchQueue) obj2).enqueue((Runnable) obj);
                break;
            case 6:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) obj2, (TransactionExecutor) obj);
                break;
            case 7:
                TimeLimiter.track$lambda$0((TimeLimiter) obj2, (StartStopToken) obj);
                break;
            case 8:
                ConstraintTracker._set_state_$lambda$4$lambda$3((List) obj2, (ConstraintTracker) obj);
                break;
            case 9:
                CancelWorkRunnable.forId$lambda$1$lambda$0((WorkManagerImpl) obj2, (UUID) obj);
                break;
            case 10:
                AccessTokenManager.refreshCurrentAccessToken$lambda$0((AccessTokenManager) obj2, (AccessToken.AccessTokenRefreshCallback) obj);
                break;
            case 11:
                GraphRequest.Companion.runCallbacks$lambda$2((ArrayList) obj2, (GraphRequestBatch) obj);
                break;
            case 12:
                ProgressOutputStream.reportBatchProgress$lambda$0((GraphRequestBatch.OnProgressCallback) obj2, (ProgressOutputStream) obj);
                break;
            case 13:
                AppEventQueue.add$lambda$3((AccessTokenAppIdPair) obj2, (AppEvent) obj);
                break;
            case 14:
                AppEventQueue.handleResponse$lambda$5((AccessTokenAppIdPair) obj2, (SessionEventsState) obj);
                break;
            case 15:
                AppEventsLoggerImpl.Companion.initializeLib$lambda$4((Context) obj2, (AppEventsLoggerImpl) obj);
                break;
            case 16:
                MetadataViewObserver.process$lambda$0((View) obj2, (MetadataViewObserver) obj);
                break;
            case 17:
                CodelessLoggingEventListener.logEvent$lambda$0((String) obj, (Bundle) obj2);
                break;
            case 18:
                ViewIndexer.schedule$lambda$0((ViewIndexer) obj2, (ViewIndexer$schedule$indexingTask$1) obj);
                break;
            case 19:
                ViewIndexer.sendToServer$lambda$1((String) obj, (ViewIndexer) obj2);
                break;
            case 20:
                Task.Companion.delay$lambda$1((ScheduledFuture) obj2, (TaskCompletionSource) obj);
                break;
            case 21:
                LoginButton.checkToolTipSettings$lambda$3$lambda$2((LoginButton) obj2, (FetchedAppSettings) obj);
                break;
            case 22:
                LoginButton.checkToolTipSettings$lambda$3((String) obj, (LoginButton) obj2);
                break;
            case 23:
                ((JobInfoSchedulerService) obj2).lambda$onStartJob$0((JobParameters) obj);
                break;
            case 24:
                ((MaterialButton) obj2).lambda$maybeRunAfterWidthAnimation$0((Runnable) obj);
                break;
            case 25:
                AudioThreadFactory.newThread$lambda$0((AudioThreadFactory) obj2, (Runnable) obj);
                break;
            case 26:
                PreviewActivity.onCreate$lambda$2((PreviewActivity) obj2, (Bundle) obj);
                break;
            case 27:
                ((Sleep) obj2).lambda$showHint$9((View) obj);
                break;
            case 28:
                ((Sleep) obj2).lambda$onCreate$0((String) obj);
                break;
            default:
                Sleep.lambda$onCreate$3((TextView) obj2, (Animation) obj);
                break;
        }
    }

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda9(String str, Object obj, int i) {
        this.$r8$classId = i;
        this.f$1 = str;
        this.f$0 = obj;
    }
}
