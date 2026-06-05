package com.urbandroid.sleep.service.google.fit.api;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.IntentSender;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.GoalsClient;
import com.google.android.gms.fitness.HistoryClient;
import com.google.android.gms.fitness.SessionsClient;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.HealthDataTypes;
import com.google.android.gms.fitness.data.HealthFields;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.fitness.result.SessionReadResponse;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.google.fit.GoogleFitNotAvailableException;
import com.urbandroid.sleep.service.google.fit.GoogleFitResultStatus;
import com.urbandroid.sleep.service.google.fit.session.GoogleFitSession;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.AbstractHealthApi;
import com.urbandroid.sleep.service.health.api.HealthUserProfile;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import com.urbandroid.sleep.service.health.session.idresolver.MD5IdResolver;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.DateUtils;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001fB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0017¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\u001c\u001a\u00020\u001bH\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0017¢\u0006\u0004\b*\u0010+J%\u00100\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-H\u0017¢\u0006\u0004\b0\u00101J/\u00105\u001a\b\u0012\u0004\u0012\u0002040-2\b\u00103\u001a\u0004\u0018\u0001022\u0006\u0010\u0016\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020,H\u0017¢\u0006\u0004\b5\u00106J/\u00108\u001a\b\u0012\u0004\u0012\u0002070-2\b\u00103\u001a\u0004\u0018\u0001022\u0006\u0010\u0016\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020,H\u0017¢\u0006\u0004\b8\u00106J#\u0010>\u001a\u00020=*\u0002092\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020,H\u0003¢\u0006\u0004\b>\u0010?J#\u0010A\u001a\u00020\u000e*\u0002092\u0006\u0010;\u001a\u00020@2\u0006\u0010<\u001a\u00020,H\u0003¢\u0006\u0004\bA\u0010BJ#\u0010F\u001a\u00020E*\u00020C2\u0006\u0010;\u001a\u00020D2\u0006\u0010<\u001a\u00020,H\u0003¢\u0006\u0004\bF\u0010GJ#\u0010J\u001a\u00020\u000e*\u00020C2\u0006\u0010I\u001a\u00020H2\u0006\u0010<\u001a\u00020,H\u0003¢\u0006\u0004\bJ\u0010KJ#\u0010M\u001a\u00020\u001d*\u00020C2\u0006\u0010;\u001a\u00020L2\u0006\u0010<\u001a\u00020,H\u0003¢\u0006\u0004\bM\u0010NJ\u0013\u0010P\u001a\u00020O*\u00020.H\u0002¢\u0006\u0004\bP\u0010QJ!\u0010T\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020R2\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bT\u0010UR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010VR\u0014\u0010W\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020O8\u0016X\u0096D¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006g"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApi;", "Lcom/urbandroid/sleep/service/health/api/AbstractHealthApi;", "Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSession;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "account", "<init>", "(Landroid/content/Context;Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;)V", "", "connect", "()Z", "", "disconnect", "()V", "isConnected", "", "count", "()I", "Ljava/util/Date;", "from", "to", "", "find", "(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Collection;", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "session", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "insert", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lcom/urbandroid/sleep/service/health/api/HealthUserProfile;", "getUserProfile", "()Lcom/urbandroid/sleep/service/health/api/HealthUserProfile;", "Lcom/urbandroid/sleep/service/health/session/WalkingSensorSessionContainer;", "readStepsData", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Lcom/urbandroid/sleep/service/health/session/WalkingSensorSessionContainer;", "Lcom/urbandroid/sleep/service/health/session/idresolver/MD5IdResolver;", "getIdResolver", "()Lcom/urbandroid/sleep/service/health/session/idresolver/MD5IdResolver;", "fitSessions", "delete", "(Ljava/util/Collection;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "", "", "Lcom/urbandroid/sleep/domain/IEvent;", "hrEvents", "insertHeartRateData", "(JLjava/util/List;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Landroid/app/Activity;", "activity", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$HeartRate;", "readHeartRateData", "(Landroid/app/Activity;JJ)Ljava/util/List;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$SPO2;", "readSPO2Data", "Lcom/google/android/gms/fitness/SessionsClient;", "Lcom/google/android/gms/fitness/request/SessionReadRequest;", "request", "timeoutInMillis", "Lcom/google/android/gms/fitness/result/SessionReadResponse;", "readSession", "(Lcom/google/android/gms/fitness/SessionsClient;Lcom/google/android/gms/fitness/request/SessionReadRequest;J)Lcom/google/android/gms/fitness/result/SessionReadResponse;", "Lcom/google/android/gms/fitness/request/SessionInsertRequest;", "insertSession", "(Lcom/google/android/gms/fitness/SessionsClient;Lcom/google/android/gms/fitness/request/SessionInsertRequest;J)V", "Lcom/google/android/gms/fitness/HistoryClient;", "Lcom/google/android/gms/fitness/request/DataReadRequest;", "Lcom/google/android/gms/fitness/result/DataReadResponse;", "readData", "(Lcom/google/android/gms/fitness/HistoryClient;Lcom/google/android/gms/fitness/request/DataReadRequest;J)Lcom/google/android/gms/fitness/result/DataReadResponse;", "Lcom/google/android/gms/fitness/data/DataSet;", "dataSet", "insertData", "(Lcom/google/android/gms/fitness/HistoryClient;Lcom/google/android/gms/fitness/data/DataSet;J)V", "Lcom/google/android/gms/fitness/request/DataDeleteRequest;", "deleteData", "(Lcom/google/android/gms/fitness/HistoryClient;Lcom/google/android/gms/fitness/request/DataDeleteRequest;J)Lcom/urbandroid/sleep/service/health/ResultStatus;", "", "pretty", "(Lcom/urbandroid/sleep/domain/IEvent;)Ljava/lang/String;", "Lcom/google/android/gms/common/api/Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "checkStatus", "(Lcom/google/android/gms/common/api/Status;Landroid/app/Activity;)Z", "Landroid/content/Context;", "sessionsClient", "Lcom/google/android/gms/fitness/SessionsClient;", "historyClient", "Lcom/google/android/gms/fitness/HistoryClient;", "Lcom/google/android/gms/fitness/GoalsClient;", "goalClient", "Lcom/google/android/gms/fitness/GoalsClient;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitApi extends AbstractHealthApi<GoogleFitSession> implements CoroutineScope, FeatureLogger {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Context context;
    private final GoalsClient goalClient;
    private final HistoryClient historyClient;
    private final SessionsClient sessionsClient;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$deleteData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$deleteData$1", f = "GoogleFitApi.kt", l = {684}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ DataDeleteRequest $request;
        final /* synthetic */ HistoryClient $this_deleteData;
        final /* synthetic */ long $timeoutInMillis;
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ GoogleFitApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, HistoryClient historyClient, DataDeleteRequest dataDeleteRequest, GoogleFitApi googleFitApi, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$timeoutInMillis = j;
            this.$this_deleteData = historyClient;
            this.$request = dataDeleteRequest;
            this.this$0 = googleFitApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$timeoutInMillis, this.$this_deleteData, this.$request, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long j = this.$timeoutInMillis;
            GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 googleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GoogleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$this_deleteData, this.$request, this.this$0);
            this.J$0 = j;
            this.I$0 = 0;
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(j, googleFitApi$deleteData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$insertData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$insertData$1", f = "GoogleFitApi.kt", l = {684}, m = "invokeSuspend", v = 2)
    public static final class C21501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataSet $dataSet;
        final /* synthetic */ HistoryClient $this_insertData;
        final /* synthetic */ long $timeoutInMillis;
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ GoogleFitApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21501(long j, HistoryClient historyClient, DataSet dataSet, GoogleFitApi googleFitApi, Continuation<? super C21501> continuation) {
            super(2, continuation);
            this.$timeoutInMillis = j;
            this.$this_insertData = historyClient;
            this.$dataSet = dataSet;
            this.this$0 = googleFitApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21501(this.$timeoutInMillis, this.$this_insertData, this.$dataSet, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeoutInMillis;
                GoogleFitApi$insertData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 googleFitApi$insertData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GoogleFitApi$insertData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$this_insertData, this.$dataSet, this.this$0);
                this.J$0 = j;
                this.I$0 = 0;
                this.label = 1;
                if (TimeoutKt.withTimeout(j, googleFitApi$insertData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$insertSession$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$insertSession$1", f = "GoogleFitApi.kt", l = {684}, m = "invokeSuspend", v = 2)
    public static final class C21511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionInsertRequest $request;
        final /* synthetic */ SessionsClient $this_insertSession;
        final /* synthetic */ long $timeoutInMillis;
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ GoogleFitApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21511(long j, SessionsClient sessionsClient, SessionInsertRequest sessionInsertRequest, GoogleFitApi googleFitApi, Continuation<? super C21511> continuation) {
            super(2, continuation);
            this.$timeoutInMillis = j;
            this.$this_insertSession = sessionsClient;
            this.$request = sessionInsertRequest;
            this.this$0 = googleFitApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21511(this.$timeoutInMillis, this.$this_insertSession, this.$request, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeoutInMillis;
                GoogleFitApi$insertSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 googleFitApi$insertSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GoogleFitApi$insertSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$this_insertSession, this.$request, this.this$0);
                this.J$0 = j;
                this.I$0 = 0;
                this.label = 1;
                if (TimeoutKt.withTimeout(j, googleFitApi$insertSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$readData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/google/android/gms/fitness/result/DataReadResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$readData$1", f = "GoogleFitApi.kt", l = {684}, m = "invokeSuspend", v = 2)
    public static final class C21521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DataReadResponse>, Object> {
        final /* synthetic */ DataReadRequest $request;
        final /* synthetic */ HistoryClient $this_readData;
        final /* synthetic */ long $timeoutInMillis;
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ GoogleFitApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21521(long j, HistoryClient historyClient, DataReadRequest dataReadRequest, GoogleFitApi googleFitApi, Continuation<? super C21521> continuation) {
            super(2, continuation);
            this.$timeoutInMillis = j;
            this.$this_readData = historyClient;
            this.$request = dataReadRequest;
            this.this$0 = googleFitApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21521(this.$timeoutInMillis, this.$this_readData, this.$request, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DataReadResponse> continuation) {
            return ((C21521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long j = this.$timeoutInMillis;
            GoogleFitApi$readData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 googleFitApi$readData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GoogleFitApi$readData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$this_readData, this.$request, this.this$0);
            this.J$0 = j;
            this.I$0 = 0;
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(j, googleFitApi$readData$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$readSession$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/google/android/gms/fitness/result/SessionReadResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.fit.api.GoogleFitApi$readSession$1", f = "GoogleFitApi.kt", l = {684}, m = "invokeSuspend", v = 2)
    public static final class C21531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SessionReadResponse>, Object> {
        final /* synthetic */ SessionReadRequest $request;
        final /* synthetic */ SessionsClient $this_readSession;
        final /* synthetic */ long $timeoutInMillis;
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ GoogleFitApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21531(long j, SessionsClient sessionsClient, SessionReadRequest sessionReadRequest, GoogleFitApi googleFitApi, Continuation<? super C21531> continuation) {
            super(2, continuation);
            this.$timeoutInMillis = j;
            this.$this_readSession = sessionsClient;
            this.$request = sessionReadRequest;
            this.this$0 = googleFitApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21531(this.$timeoutInMillis, this.$this_readSession, this.$request, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SessionReadResponse> continuation) {
            return ((C21531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            long j = this.$timeoutInMillis;
            GoogleFitApi$readSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 googleFitApi$readSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1 = new GoogleFitApi$readSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1(null, this.$this_readSession, this.$request, this.this$0);
            this.J$0 = j;
            this.I$0 = 0;
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(j, googleFitApi$readSession$1$invokeSuspend$$inlined$suspendCoroutineWithTimeout$1, this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    public GoogleFitApi(Context context, GoogleSignInAccount googleSignInAccount) {
        context.getClass();
        googleSignInAccount.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        SessionsClient sessionsClient = Fitness.getSessionsClient(context, googleSignInAccount);
        sessionsClient.getClass();
        this.sessionsClient = sessionsClient;
        HistoryClient historyClient = Fitness.getHistoryClient(context, googleSignInAccount);
        historyClient.getClass();
        this.historyClient = historyClient;
        GoalsClient goalsClient = Fitness.getGoalsClient(context, googleSignInAccount);
        goalsClient.getClass();
        this.goalClient = goalsClient;
        this.tag = "fit-api";
    }

    private final boolean checkStatus(Status status, Activity activity) {
        if (status.isSuccess()) {
            return true;
        }
        if (status.isSuccess() || !status.hasResolution()) {
            return false;
        }
        if (activity == null) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": Starting notification for google fit - consent required", null);
            NotificationManagerCompat.from(this.context).getClass();
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.context, "servicesChannel").setContentIntent(status.getResolution()).setColor(ColorUtil.i(this.context, R.color.tint_notification)).setAutoCancel(true).setContentText(this.context.getString(R.string.share_disconnected, "Google Fit")).setSmallIcon(R.drawable.ic_cloud_upload_white).setContentTitle(this.context.getString(R.string.google_fit));
            contentTitle.getClass();
            Context context = this.context;
            Notification notificationBuild = contentTitle.build();
            notificationBuild.getClass();
            NotificationsKt.notify(context, -31415928, notificationBuild);
            return false;
        }
        try {
            Logger.logInfo(Logger.defaultTag, getTag() + ": Starting consent screen for google fit", null);
            status.startResolutionForResult(activity, 2);
            return false;
        } catch (IntentSender.SendIntentException e) {
            Logger.logSevere(Logger.defaultTag, getTag() + ": Fit Read: Exception while starting resolution activity", e);
            return false;
        }
    }

    private final ResultStatus deleteData(HistoryClient historyClient, DataDeleteRequest dataDeleteRequest, long j) {
        return (ResultStatus) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass1(j, historyClient, dataDeleteRequest, this, null), 1, null);
    }

    private final void insertData(HistoryClient historyClient, DataSet dataSet, long j) {
        BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21501(j, historyClient, dataSet, this, null), 1, null);
    }

    private final void insertSession(SessionsClient sessionsClient, SessionInsertRequest sessionInsertRequest, long j) {
        BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21511(j, sessionsClient, sessionInsertRequest, this, null), 1, null);
    }

    private final String pretty(IEvent iEvent) {
        return iEvent.getLabel() + " " + Utils.getPrettyDate(iEvent.getTimestamp()) + " " + iEvent.getValue();
    }

    private final DataReadResponse readData(HistoryClient historyClient, DataReadRequest dataReadRequest, long j) {
        return (DataReadResponse) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21521(j, historyClient, dataReadRequest, this, null), 1, null);
    }

    private final SessionReadResponse readSession(SessionsClient sessionsClient, SessionReadRequest sessionReadRequest, long j) {
        return (SessionReadResponse) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21531(j, sessionsClient, sessionReadRequest, this, null), 1, null);
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public boolean connect() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": connected", null);
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public int count() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis;
        long j2 = jCurrentTimeMillis - 31536000000L;
        int size = 0;
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            SessionReadRequest.Builder timeInterval = new SessionReadRequest.Builder().includeSleepSessions().setTimeInterval(j2, j, TimeUnit.MILLISECONDS);
            timeInterval.getClass();
            SessionReadRequest sessionReadRequestBuild = timeInterval.build();
            sessionReadRequestBuild.getClass();
            try {
                SessionReadResponse session = readSession(this.sessionsClient, sessionReadRequestBuild, Utils.getMinutesInMillis(2));
                if (session.getSessions().size() == 0) {
                    i++;
                }
                if (i == 2) {
                    break;
                }
                size += session.getSessions().size();
                j2 -= 31536000000L;
                j -= 31536000000L;
            } catch (Exception e) {
                Logger.logWarning(Logger.defaultTag, getTag() + ": count failure", e);
                return -1;
            }
        }
        return size;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<? extends GoogleFitSession> fitSessions) {
        fitSessions.getClass();
        if (fitSessions.isEmpty()) {
            ResultStatus resultStatus = ResultStatus.SUCCESS;
            resultStatus.getClass();
            return resultStatus;
        }
        DataDeleteRequest.Builder builderAddDataType = new DataDeleteRequest.Builder().addDataType(DataType.TYPE_SLEEP_SEGMENT).addDataType(DataType.TYPE_ACTIVITY_SEGMENT);
        builderAddDataType.getClass();
        long jMin = -1;
        long jMax = -1;
        for (GoogleFitSession googleFitSession : fitSessions) {
            Logger.logDebug(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Fit Session will be deleted: " + googleFitSession), null);
            Session session = googleFitSession.toSession();
            session.getClass();
            builderAddDataType.addSession(session);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            jMin = jMin != -1 ? Math.min(session.getStartTime(timeUnit), jMin) : session.getStartTime(timeUnit);
            jMax = jMax != -1 ? Math.max(session.getEndTime(timeUnit), jMax) : session.getEndTime(timeUnit);
        }
        DataDeleteRequest dataDeleteRequestBuild = builderAddDataType.setTimeInterval(jMin, jMax, TimeUnit.MILLISECONDS).build();
        dataDeleteRequestBuild.getClass();
        try {
            ResultStatus resultStatusDeleteData = deleteData(this.historyClient, dataDeleteRequestBuild, Utils.getSecondsInMillis(60));
            if (resultStatusDeleteData.isSuccess()) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": Successfully deleted sleep sessions", null);
            } else {
                Logger.logSevere(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Failed to delete sleep session: " + resultStatusDeleteData), null);
            }
            return new GoogleFitResultStatus(resultStatusDeleteData.isSuccess() ? Status.RESULT_SUCCESS : Status.RESULT_INTERNAL_ERROR);
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Failed to delete sleep session: " + e), null);
            return new GoogleFitResultStatus(Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public void disconnect() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        Logger.logInfo(Logger.defaultTag, getTag() + ": disconnected", null);
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public Collection<GoogleFitSession> find(Date from, Date to) {
        from.getClass();
        to.getClass();
        SessionReadRequest.Builder timeInterval = new SessionReadRequest.Builder().read(DataType.TYPE_SLEEP_SEGMENT).includeSleepSessions().enableServerQueries().setTimeInterval(from.getTime(), to.getTime(), TimeUnit.MILLISECONDS);
        timeInterval.getClass();
        SessionReadRequest sessionReadRequestBuild = timeInterval.build();
        sessionReadRequestBuild.getClass();
        try {
            SessionReadResponse session = readSession(this.sessionsClient, sessionReadRequestBuild, Utils.getMinutesInMillis(2));
            Status status = session.getStatus();
            status.getClass();
            ArrayList arrayList = new ArrayList();
            if (!status.isSuccess()) {
                Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Session read status: " + status), null);
            }
            if (status.getStatusCode() == 5008) {
                throw new GoogleFitNotAvailableException();
            }
            if (!checkStatus(status, null)) {
                Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "checkStatus failure: " + status + " " + status.getStatusCode()), null);
                return arrayList;
            }
            if (!status.isSuccess() && status.getStatusCode() == 5008) {
                throw new GoogleFitNotAvailableException();
            }
            for (Session session2 : session.getSessions()) {
                GoogleFitSession googleFitSession = new GoogleFitSession(session2, session.getDataSet(session2, DataType.TYPE_SLEEP_SEGMENT), null);
                if (googleFitSession.isSleepActivity() && googleFitSession.hasSegments() && HeathSyncKt.hasBrokenSegments(googleFitSession.getSegments())) {
                    Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "FIT Broken segments found in: " + googleFitSession), null);
                    googleFitSession.markAsBroken();
                }
                arrayList.add(googleFitSession);
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public MD5IdResolver getIdResolver() {
        return new MD5IdResolver();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public HealthUserProfile getUserProfile() {
        return null;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insert(HealthSession session) {
        DataSet fitSegmentDataSet;
        session.getClass();
        if (!HealthIntervalKt.isValid(session)) {
            Logger.logSevere(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Session insertion rejected - session is not valid: " + session), null);
            return null;
        }
        Logger.logDebug(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Inserting the session into Fit: " + SleeprecordExtKt.toAsciiHypnogram$default(session.getSleepRecord(), 15, null, 2, null) + "\n" + session), null);
        SessionInsertRequest.Builder session2 = new SessionInsertRequest.Builder().setSession(GoogleFitExtKt.toFitSession(session));
        session2.getClass();
        if (session.hasSegments() && (fitSegmentDataSet = GoogleFitExtKt.toFitSegmentDataSet(session, this.context)) != null) {
            session2.addDataSet(fitSegmentDataSet);
        }
        try {
            SessionsClient sessionsClient = this.sessionsClient;
            SessionInsertRequest sessionInsertRequestBuild = session2.build();
            sessionInsertRequestBuild.getClass();
            insertSession(sessionsClient, sessionInsertRequestBuild, Utils.getSecondsInMillis(30));
            return ResultStatus.SUCCESS;
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "FIT INSERT FAILURE: session: " + session + " " + e), null);
            return ResultStatus.FAILURE;
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insertHeartRateData(long from, List<? extends IEvent> hrEvents) {
        List<? extends IEvent> list;
        StringBuilder sb;
        hrEvents.getClass();
        if (hrEvents.isEmpty()) {
            ResultStatus resultStatus = ResultStatus.NO_RECORDS;
            resultStatus.getClass();
            return resultStatus;
        }
        DataSource dataSourceBuild = new DataSource.Builder().setAppPackageName(this.context).setDataType(DataType.TYPE_HEART_RATE_BPM).setStreamName("Sleep - heart rate").setType(0).build();
        dataSourceBuild.getClass();
        DataSet.Builder builder = DataSet.builder(dataSourceBuild);
        for (IEvent iEvent : hrEvents) {
            long timestamp = iEvent.getTimestamp();
            float value = iEvent.getValue();
            if (0.0f > value || value > 1000.0f) {
                Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("HR event ", pretty(iEvent), " - value out of range 0..1000")), null);
            } else {
                DataPoint dataPointBuild = DataPoint.builder(dataSourceBuild).setTimeInterval(timestamp, timestamp, TimeUnit.MILLISECONDS).setField(Field.FIELD_BPM, value).build();
                dataPointBuild.getClass();
                builder.add(dataPointBuild);
            }
        }
        DataSet dataSetBuild = builder.build();
        dataSetBuild.getClass();
        try {
            insertData(this.historyClient, dataSetBuild, Utils.getSecondsInMillis(60));
            String readableDate = DateUtils.toReadableDate(from);
            sb = new StringBuilder();
            sb.append(from);
            sb.append(" successfully Exported HR sleep record ");
            sb.append(readableDate);
            sb.append(" - HR entries: ");
            list = hrEvents;
        } catch (Exception unused) {
            list = hrEvents;
        }
        try {
            sb.append(list);
            String string = sb.toString();
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + string, null);
            return new GoogleFitResultStatus(Status.RESULT_SUCCESS);
        } catch (Exception unused2) {
            Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", from + " export failure for sleep record " + DateUtils.toReadableDate(from) + " - HR entries: " + list.size()), null);
            return new GoogleFitResultStatus(Status.RESULT_INTERNAL_ERROR);
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    /* JADX INFO: renamed from: isConnected */
    public boolean getConnected() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.HeartRate> readHeartRateData(Activity activity, long from, long to) {
        if (Environment.isMOrGreater() && !SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.BODY_SENSORS")) {
            return CollectionsKt.emptyList();
        }
        DataReadRequest dataReadRequestBuild = new DataReadRequest.Builder().read(DataType.TYPE_HEART_RATE_BPM).bucketByTime(60, TimeUnit.MINUTES).setTimeRange(from, to, TimeUnit.MILLISECONDS).enableServerQueries().build();
        dataReadRequestBuild.getClass();
        try {
            DataReadResponse data2 = readData(this.historyClient, dataReadRequestBuild, Utils.getSecondsInMillis(120));
            Status status = data2.getStatus();
            status.getClass();
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "FIT HR read result: " + status), null);
            if (!checkStatus(status, activity)) {
                return CollectionsKt.emptyList();
            }
            List<Bucket> buckets = data2.getBuckets();
            buckets.getClass();
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m(buckets.size(), "FIT HR buckets: ")), null);
            if (buckets.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = buckets.iterator();
            while (it.hasNext()) {
                List<DataSet> dataSets = ((Bucket) it.next()).getDataSets();
                dataSets.getClass();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, dataSets);
            }
            ArrayList<DataPoint> arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                List<DataPoint> dataPoints = ((DataSet) it2.next()).getDataPoints();
                dataPoints.getClass();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, dataPoints);
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (DataPoint dataPoint : arrayList2) {
                arrayList3.add(new SensorRecord.HeartRate(dataPoint.getTimestamp(TimeUnit.MILLISECONDS), dataPoint.getValue(Field.FIELD_BPM).asFloat()));
            }
            return arrayList3;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.SPO2> readSPO2Data(Activity activity, long from, long to) {
        if (Environment.isMOrGreater() && !SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.BODY_SENSORS")) {
            return CollectionsKt.emptyList();
        }
        DataReadRequest dataReadRequestBuild = new DataReadRequest.Builder().read(HealthDataTypes.TYPE_OXYGEN_SATURATION).setTimeRange(from, to, TimeUnit.MILLISECONDS).enableServerQueries().build();
        dataReadRequestBuild.getClass();
        try {
            DataReadResponse data2 = readData(this.historyClient, dataReadRequestBuild, Utils.getSecondsInMillis(120));
            Status status = data2.getStatus();
            status.getClass();
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "FIT SPO2 read result: " + data2 + " " + status), null);
            if (!checkStatus(status, activity)) {
                return CollectionsKt.emptyList();
            }
            List<Bucket> buckets = data2.getBuckets();
            buckets.getClass();
            Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m(buckets.size(), "FIT SPO2 buckets: ")), null);
            if (buckets.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = buckets.iterator();
            while (it.hasNext()) {
                List<DataSet> dataSets = ((Bucket) it.next()).getDataSets();
                dataSets.getClass();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, dataSets);
            }
            ArrayList<DataPoint> arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                List<DataPoint> dataPoints = ((DataSet) it2.next()).getDataPoints();
                dataPoints.getClass();
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, dataPoints);
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (DataPoint dataPoint : arrayList2) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                long timestamp = dataPoint.getTimestamp(timeUnit);
                float fAsFloat = dataPoint.getValue(HealthFields.FIELD_OXYGEN_SATURATION).asFloat();
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "FIT SPO2 DATAPOINT: " + dataPoint), null);
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("FIT SPO2 DATAPOINT Start: ", HeathSyncKt.getPrettyMillis(dataPoint.getStartTime(timeUnit)))), null);
                Logger.logInfo(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", FileInsert$$ExternalSyntheticOutline0.m("FIT SPO2 DATAPOINT END: ", HeathSyncKt.getPrettyMillis(dataPoint.getEndTime(timeUnit)))), null);
                arrayList3.add(new SensorRecord.SPO2(timestamp, fAsFloat));
            }
            return arrayList3;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public WalkingSensorSessionContainer<?> readStepsData(HealthSession session) {
        session.getClass();
        String id = session.getId();
        if (id != null) {
            SessionReadRequest.Builder timeInterval = new SessionReadRequest.Builder().setTimeInterval(session.getFromInMillis(), session.getToInMillis(), TimeUnit.MILLISECONDS);
            DataType dataType = DataType.TYPE_STEP_COUNT_DELTA;
            SessionReadRequest.Builder builderEnableServerQueries = timeInterval.read(dataType).setSessionId(id).enableServerQueries();
            builderEnableServerQueries.getClass();
            SessionReadRequest sessionReadRequestBuild = builderEnableServerQueries.build();
            sessionReadRequestBuild.getClass();
            try {
                SessionReadResponse session2 = readSession(this.sessionsClient, sessionReadRequestBuild, Utils.getSecondsInMillis(45));
                Status status = session2.getStatus();
                status.getClass();
                if (!status.isSuccess()) {
                    Logger.logWarning(Logger.defaultTag, zza$$ExternalSyntheticOutline0.m(this, new StringBuilder(), ": ", "Steps read status: " + status), null);
                    return null;
                }
                List<Session> sessions = session2.getSessions();
                if (sessions != null && !sessions.isEmpty()) {
                    Session session3 = session2.getSessions().get(0);
                    return new GoogleFitSession(session3, null, session2.getDataSet(session3, dataType));
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
