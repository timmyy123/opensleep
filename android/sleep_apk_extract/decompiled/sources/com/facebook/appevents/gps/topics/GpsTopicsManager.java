package com.facebook.appevents.gps.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.os.Build;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0007J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\b\u0010\u0018\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/gps/topics/GpsTopicsManager;", "", "()V", "RECORD_OBSERVATION", "", "TAG", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor$delegate", "Lkotlin/Lazy;", "isTopicsObservationEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enableTopicsObservation", "", "getTopics", "Ljava/util/concurrent/CompletableFuture;", "", "Lcom/facebook/appevents/gps/topics/TopicData;", "processObservedTopics", "response", "Landroid/adservices/topics/GetTopicsResponse;", "shouldObserveTopics", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GpsTopicsManager {
    public static final GpsTopicsManager INSTANCE = new GpsTopicsManager();
    private static final boolean RECORD_OBSERVATION = true;
    private static final String TAG;

    /* JADX INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private static final Lazy executor;
    private static final AtomicBoolean isTopicsObservationEnabled;

    static {
        String string = GpsTopicsManager.class.toString();
        string.getClass();
        TAG = string;
        executor = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$executor$2
            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                return Executors.newCachedThreadPool();
            }
        });
        isTopicsObservationEnabled = new AtomicBoolean(false);
    }

    private GpsTopicsManager() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    public static final /* synthetic */ List access$processObservedTopics(GpsTopicsManager gpsTopicsManager, GetTopicsResponse getTopicsResponse) {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return gpsTopicsManager.processObservedTopics(getTopicsResponse);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    public static final void enableTopicsObservation() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return;
        }
        try {
            isTopicsObservationEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
        }
    }

    private final Executor getExecutor() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object value = executor.getValue();
            value.getClass();
            return (Executor) value;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final CompletableFuture<List<TopicData>> getTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            if (!shouldObserveTopics()) {
                CompletableFuture<List<TopicData>> completableFutureCompletedFuture = CompletableFuture.completedFuture(CollectionsKt.emptyList());
                completableFutureCompletedFuture.getClass();
                return completableFutureCompletedFuture;
            }
            final CompletableFuture<List<TopicData>> completableFuture = new CompletableFuture<>();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                new OutcomeReceiver() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$getTopics$callback$1
                    public void onError(Exception error) {
                        error.getClass();
                        Log.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_OBSERVATION_FAILURE", error);
                        completableFuture.completeExceptionally(error);
                    }

                    public /* synthetic */ void onResult(Object obj) {
                        if (obj == null) {
                            onResult((GetTopicsResponse) null);
                        } else {
                            Events$$ExternalSyntheticBUOutline0.m();
                        }
                    }

                    public void onResult(GetTopicsResponse response) {
                        throw null;
                    }
                };
                GetTopicsRequest.Builder builder = new GetTopicsRequest.Builder();
                builder.setShouldRecordObservation(true);
                builder.setAdsSdkName(applicationContext.getPackageName());
                if (applicationContext.getSystemService(TopicsManager.class) != null) {
                    throw new ClassCastException();
                }
            } catch (Throwable th) {
                Log.w(TAG, "GPS_TOPICS_OBSERVATION_FAILURE", th);
                completableFuture.completeExceptionally(th);
            }
            return completableFuture;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, GpsTopicsManager.class);
            return null;
        }
    }

    private final List<TopicData> processObservedTopics(GetTopicsResponse response) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final boolean shouldObserveTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return false;
        }
        try {
            if (isTopicsObservationEnabled.get()) {
                return Build.VERSION.SDK_INT >= 33;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return false;
        }
    }
}
