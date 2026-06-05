package com.urbandroid.sleep.activityrecognition;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda1;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransition;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.tasks.Task;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.service.Settings;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0003\u001a\u001b\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "enabled", "", "setNewApi", "(Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/google/android/gms/location/ActivityRecognitionClient;", "client$delegate", "Lkotlin/Lazy;", "getClient", "()Lcom/google/android/gms/location/ActivityRecognitionClient;", "client", "Companion", "Transition", "Update", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActivityRecognitionInitializer implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client;
    private final Context context;
    private final String tag;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0014\u0010\t\u001a\u00060\nR\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer$Companion;", "", "<init>", "()V", "transitions", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer$Transition;", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "updates", "Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer$Update;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Transition transitions(Context context) {
            context.getClass();
            return new ActivityRecognitionInitializer(context).new Transition();
        }

        public final Update updates(Context context) {
            context.getClass();
            return new ActivityRecognitionInitializer(context).new Update();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer$Transition;", "", "<init>", "(Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer;)V", "transition", "Lcom/google/android/gms/location/ActivityTransition;", "type", "", "transitionType", "initializeOld", "", "initialize", "destroy", "getActivityTransitionPendingIntent", "Landroid/app/PendingIntent;", "getSleepSegmentUpdatePendingIntent", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class Transition {
        public Transition() {
        }

        private final PendingIntent getActivityTransitionPendingIntent() {
            PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
            Context context = ActivityRecognitionInitializer.this.getContext();
            Intent intent = new Intent(ActivityRecognitionInitializer.this.getContext(), (Class<?>) ActivityTransitionReceiver.class);
            intent.setAction(AlarmClock.ACTIVITY_RECOGNITION_INTENT_ACTION);
            Unit unit = Unit.INSTANCE;
            return companion.get(context, 0, intent, 167772160).getExplicitBroadcast();
        }

        private final PendingIntent getSleepSegmentUpdatePendingIntent() {
            PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
            Context context = ActivityRecognitionInitializer.this.getContext();
            Intent intent = new Intent(ActivityRecognitionInitializer.this.getContext(), (Class<?>) SleepSegmentsUpdateReceiver.class);
            intent.setAction(AlarmClock.ACTIVITY_RECOGNITION_INTENT_ACTION);
            Unit unit = Unit.INSTANCE;
            return companion.get(context, 0, intent, 167772160).getExplicitBroadcast();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit initialize$lambda$0$0(ActivityRecognitionInitializer activityRecognitionInitializer, Void r3) {
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": SUCCESS Activity recognition using new Sleep API", null);
            activityRecognitionInitializer.setNewApi(true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$0$2(ActivityRecognitionInitializer activityRecognitionInitializer, Exception exc) {
            exc.getClass();
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": FAILED Activity recognition using new Sleep API", null);
            activityRecognitionInitializer.setNewApi(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit initializeOld$lambda$0$0$0(ActivityRecognitionInitializer activityRecognitionInitializer, int i, Void r3) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m(i, "transitions successfully enabled batchingQueueSize=");
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": " + strM, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initializeOld$lambda$0$0$2(ActivityRecognitionInitializer activityRecognitionInitializer, Exception exc) {
            exc.getClass();
            Logger.logSevere(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": activity_transition_updates_not_enabled", exc);
        }

        private static final ActivityTransition initializeOld$lambda$0$transitionEnter(Transition transition, int i) {
            return transition.transition(i, 0);
        }

        private static final ActivityTransition initializeOld$lambda$0$transitionExit(Transition transition, int i) {
            return transition.transition(i, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void destroy() {
            ActivityRecognitionClient client = ActivityRecognition.getClient(ActivityRecognitionInitializer.this.getContext());
            client.getClass();
            PendingIntent sleepSegmentUpdatePendingIntent = getSleepSegmentUpdatePendingIntent();
            if (sleepSegmentUpdatePendingIntent != null) {
                client.removeSleepSegmentUpdates(sleepSegmentUpdatePendingIntent);
            }
            PendingIntent activityTransitionPendingIntent = getActivityTransitionPendingIntent();
            if (activityTransitionPendingIntent != null) {
                client.removeActivityTransitionUpdates(activityTransitionPendingIntent);
            }
            new SleepTimeSuggestionManager(ActivityRecognitionInitializer.this.getContext(), null, 2, 0 == true ? 1 : 0).cancelAlarm();
            ActivityRecognitionInitializer activityRecognitionInitializer = ActivityRecognitionInitializer.this;
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": transition events unregistered", null);
        }

        public final void initialize() {
            PendingIntent sleepSegmentUpdatePendingIntent;
            if (new Settings(ActivityRecognitionInitializer.this.getContext()).isGoogleSleepApiEnabledByUser() && (sleepSegmentUpdatePendingIntent = getSleepSegmentUpdatePendingIntent()) != null) {
                ActivityRecognitionInitializer activityRecognitionInitializer = ActivityRecognitionInitializer.this;
                ActivityRecognition.getClient(activityRecognitionInitializer.getContext()).requestSleepSegmentUpdates(sleepSegmentUpdatePendingIntent, SleepSegmentRequest.getDefaultSleepSegmentRequest()).addOnSuccessListener(new LoginFragment$$ExternalSyntheticLambda0(new CodecsKt$$ExternalSyntheticLambda2(activityRecognitionInitializer, 9), 22)).addOnFailureListener(new ActivityRecognitionInitializer$Update$$ExternalSyntheticLambda2(activityRecognitionInitializer, 1));
            }
            initializeOld();
        }

        public final void initializeOld() {
            ActivityRecognitionInitializer activityRecognitionInitializer = ActivityRecognitionInitializer.this;
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": Activity recognition using old transition API", null);
            ActivityRecognitionInitializer activityRecognitionInitializer2 = ActivityRecognitionInitializer.this;
            int iAccelSensorBatchingQueueSize = ContextExtKt.accelSensorBatchingQueueSize(activityRecognitionInitializer2.getContext());
            if (!ContextExtKt.isActivitySensorBatchingSupported(activityRecognitionInitializer2.getContext())) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m(iAccelSensorBatchingQueueSize, "ActivityRecognition disabled - too small or no sensor batching: ");
                Logger.logWarning(Logger.defaultTag, activityRecognitionInitializer2.getTag() + ": " + strM, null);
                ContextExtKt.getSettings(activityRecognitionInitializer2.getContext()).setSleepTimeSuggestionMode(SleepTimeSuggestionManager.Mode.DISABLED);
                return;
            }
            int i = 1;
            int i2 = 2;
            ActivityTransition[] activityTransitionArr = {initializeOld$lambda$0$transitionExit(this, 3), initializeOld$lambda$0$transitionEnter(this, 3), initializeOld$lambda$0$transitionEnter(this, 7), initializeOld$lambda$0$transitionExit(this, 7), initializeOld$lambda$0$transitionEnter(this, 8), initializeOld$lambda$0$transitionExit(this, 8), initializeOld$lambda$0$transitionEnter(this, 0), initializeOld$lambda$0$transitionExit(this, 0), initializeOld$lambda$0$transitionEnter(this, 1), initializeOld$lambda$0$transitionExit(this, 1), initializeOld$lambda$0$transitionEnter(this, 2), initializeOld$lambda$0$transitionExit(this, 2)};
            PendingIntent activityTransitionPendingIntent = getActivityTransitionPendingIntent();
            if (activityTransitionPendingIntent != null) {
                activityRecognitionInitializer2.getClient().requestActivityTransitionUpdates(new ActivityTransitionRequest(ArraysKt.toMutableList(activityTransitionArr)), activityTransitionPendingIntent).addOnSuccessListener(new LoginFragment$$ExternalSyntheticLambda0(new SnapshotStateList$$ExternalSyntheticLambda1(activityRecognitionInitializer2, iAccelSensorBatchingQueueSize, i), 23)).addOnFailureListener(new ActivityRecognitionInitializer$Update$$ExternalSyntheticLambda2(activityRecognitionInitializer2, i2));
            }
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer2.getTag() + ": transitions registration called", null);
        }

        public final ActivityTransition transition(int type, int transitionType) {
            ActivityTransition.Builder builder = new ActivityTransition.Builder();
            builder.setActivityTransition(transitionType);
            builder.setActivityType(type);
            ActivityTransition activityTransitionBuild = builder.build();
            activityTransitionBuild.getClass();
            return activityTransitionBuild;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer$Update;", "", "<init>", "(Lcom/urbandroid/sleep/activityrecognition/ActivityRecognitionInitializer;)V", "reinitialize", "", "intervalInMinutes", "", "initialize", "destroy", "getActivityDetectionPendingIntent", "Landroid/app/PendingIntent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class Update {
        public Update() {
        }

        private final PendingIntent getActivityDetectionPendingIntent() {
            return PendingIntentBuilder.INSTANCE.get(ActivityRecognitionInitializer.this.getContext(), 0, new Intent(ActivityRecognitionInitializer.this.getContext(), (Class<?>) ActivityReceiver.class), 167772160).getExplicitBroadcast();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit initialize$lambda$0$0$1(ActivityRecognitionInitializer activityRecognitionInitializer, int i, Object obj) {
            String strM = Fragment$$ExternalSyntheticOutline1.m(i, "updates successfully enabled batchingQueueSize=", ")");
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": " + strM, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initialize$lambda$0$0$3(ActivityRecognitionInitializer activityRecognitionInitializer, Exception exc) {
            exc.getClass();
            Logger.logSevere(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": activity_detection_not_enabled", exc);
        }

        public static /* synthetic */ void reinitialize$default(Update update, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 10;
            }
            update.reinitialize(i);
        }

        public final void destroy() {
            try {
                ActivityRecognitionClient client = ActivityRecognition.getClient(ActivityRecognitionInitializer.this.getContext());
                PendingIntent activityDetectionPendingIntent = getActivityDetectionPendingIntent();
                if (activityDetectionPendingIntent != null) {
                    client.removeActivityUpdates(activityDetectionPendingIntent);
                }
                ActivityRecognitionInitializer activityRecognitionInitializer = ActivityRecognitionInitializer.this;
                Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": updates unregistered", null);
            } catch (Exception e) {
                ActivityRecognitionInitializer activityRecognitionInitializer2 = ActivityRecognitionInitializer.this;
                Logger.logSevere(Logger.defaultTag, activityRecognitionInitializer2.getTag() + ": updates unregister failure", e);
            }
        }

        public final void initialize(int intervalInMinutes) {
            Task<Void> taskAddOnSuccessListener;
            PendingIntent activityDetectionPendingIntent = getActivityDetectionPendingIntent();
            if (activityDetectionPendingIntent != null) {
                ActivityRecognitionInitializer activityRecognitionInitializer = ActivityRecognitionInitializer.this;
                int iAccelSensorBatchingQueueSize = ContextExtKt.accelSensorBatchingQueueSize(activityRecognitionInitializer.getContext());
                if (ContextExtKt.isActivitySensorBatchingSupported(activityRecognitionInitializer.getContext())) {
                    Task<Void> taskRequestActivityUpdates = activityRecognitionInitializer.getClient().requestActivityUpdates(Utils.getMinutesInMillis(intervalInMinutes), activityDetectionPendingIntent);
                    if (taskRequestActivityUpdates == null) {
                        Logger.logSevere(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": initialize activity_detection failure - update task not created", null);
                    }
                    if (taskRequestActivityUpdates != null && (taskAddOnSuccessListener = taskRequestActivityUpdates.addOnSuccessListener(new LoginFragment$$ExternalSyntheticLambda0(new SnapshotStateList$$ExternalSyntheticLambda1(activityRecognitionInitializer, iAccelSensorBatchingQueueSize, 2), 24))) != null) {
                        taskAddOnSuccessListener.addOnFailureListener(new ActivityRecognitionInitializer$Update$$ExternalSyntheticLambda2(activityRecognitionInitializer, 0));
                    }
                } else {
                    String strM = FileInsert$$ExternalSyntheticOutline0.m(iAccelSensorBatchingQueueSize, "ActivityRecognition disabled - too small or no sensor batching: ");
                    Logger.logWarning(Logger.defaultTag, activityRecognitionInitializer.getTag() + ": " + strM, null);
                    ContextExtKt.getSettings(activityRecognitionInitializer.getContext()).setSleepTimeSuggestionMode(SleepTimeSuggestionManager.Mode.DISABLED);
                }
            }
            ActivityRecognitionInitializer activityRecognitionInitializer2 = ActivityRecognitionInitializer.this;
            Logger.logInfo(Logger.defaultTag, activityRecognitionInitializer2.getTag() + ": updates registration called", null);
        }

        public final void reinitialize(int intervalInMinutes) {
            destroy();
            initialize(intervalInMinutes);
        }
    }

    public ActivityRecognitionInitializer(Context context) {
        context.getClass();
        this.context = context;
        this.tag = "activity";
        this.client = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityRecognitionClient client_delegate$lambda$0(ActivityRecognitionInitializer activityRecognitionInitializer) {
        return ActivityRecognition.getClient(activityRecognitionInitializer.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityRecognitionClient getClient() {
        return (ActivityRecognitionClient) this.client.getValue();
    }

    public static final Transition transitions(Context context) {
        return INSTANCE.transitions(context);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void setNewApi(boolean enabled) {
        new Settings(this.context).setActivityRecognitionNewSleepApi(enabled);
    }
}
