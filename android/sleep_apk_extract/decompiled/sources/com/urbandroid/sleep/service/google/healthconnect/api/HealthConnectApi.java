package com.urbandroid.sleep.service.google.healthconnect.api;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.response.ReadRecordsResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.connect.client.units.Percentage;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.service.google.healthconnect.session.HealthConnectSession;
import com.urbandroid.sleep.service.health.DataSourceProvider;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.ResultStatus;
import com.urbandroid.sleep.service.health.api.AbstractHealthApi;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.idresolver.FromToIdResolver;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.util.DateRetargetClass;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001TB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b!\u0010\"J/\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)J%\u0010,\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020%2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0&H\u0016¢\u0006\u0004\b,\u0010-J/\u0010/\u001a\b\u0012\u0004\u0012\u00020.0&2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020%H\u0016¢\u0006\u0004\b/\u0010)J%\u00101\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020*0&H\u0016¢\u0006\u0004\b1\u0010-J\u001d\u0010!\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016¢\u0006\u0004\b!\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u000eJ\r\u00108\u001a\u00020\f¢\u0006\u0004\b8\u0010\u000eJ\r\u00109\u001a\u00020\u000f¢\u0006\u0004\b9\u0010\u0011J\u001d\u0010=\u001a\u00020\f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002¢\u0006\u0004\b=\u0010>R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010?R\u001a\u0010@\u001a\u00020;8\u0016X\u0096D¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010K\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u000e\"\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020P8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/api/HealthConnectApi;", "Lcom/urbandroid/sleep/service/health/api/AbstractHealthApi;", "Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "getMaxRecordSyncCount", "()I", "", "connect", "()Z", "", "disconnect", "()V", "isConnected", "Ljava/util/Date;", "from", "to", "", "find", "(Ljava/util/Date;Ljava/util/Date;)Ljava/util/Collection;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "(Landroid/content/Context;)Landroidx/health/connect/client/records/metadata/Metadata;", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "session", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "insert", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "delete", "(Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Landroid/app/Activity;", "activity", "", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$HeartRate;", "readHeartRateData", "(Landroid/app/Activity;JJ)Ljava/util/List;", "Lcom/urbandroid/sleep/domain/IEvent;", "hrEvents", "insertHeartRateData", "(JLjava/util/List;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$SPO2;", "readSPO2Data", "spo2events", "insertSPO2Data", "sessions", "(Ljava/util/Collection;)Lcom/urbandroid/sleep/service/health/ResultStatus;", "Lcom/urbandroid/sleep/service/health/session/idresolver/FromToIdResolver;", "getIdResolver", "()Lcom/urbandroid/sleep/service/health/session/idresolver/FromToIdResolver;", "hasSpo2Permissions", "hasHrPermissions", "revokeAllPermissions", "", "", "permissions", "hasPermissions", "(Ljava/util/Set;)Z", "Landroid/content/Context;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Landroidx/health/connect/client/HealthConnectClient;", "healthConnectClient", "Landroidx/health/connect/client/HealthConnectClient;", "getHealthConnectClient", "()Landroidx/health/connect/client/HealthConnectClient;", "setHealthConnectClient", "(Landroidx/health/connect/client/HealthConnectClient;)V", "connected", "Z", "getConnected", "setConnected", "(Z)V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthConnectApi extends AbstractHealthApi<HealthConnectSession> implements CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> healthConnectAllPermissions;
    private static final Set<String> hrHealthConnectPermissions;
    private static final Set<String> readHealthConnectPermission;
    private static final Set<String> requiredHealthConnectPermission;
    private static final Set<String> spo2HealthConnectPermissions;
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private boolean connected;
    private final Context context;
    public HealthConnectClient healthConnectClient;
    private final String tag;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/api/HealthConnectApi$Companion;", "", "<init>", "()V", "Lcom/urbandroid/sleep/service/health/session/idresolver/FromToIdResolver;", "getIdResolver", "()Lcom/urbandroid/sleep/service/health/session/idresolver/FromToIdResolver;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "isAvailable", "(Landroid/content/Context;)Z", "Landroidx/health/connect/client/HealthConnectClient;", "healthConnectClient", "", "", "getHealthConnectPermissions", "(Landroidx/health/connect/client/HealthConnectClient;)Ljava/util/Set;", "requiredHealthConnectPermission", "Ljava/util/Set;", "getRequiredHealthConnectPermission", "()Ljava/util/Set;", "spo2HealthConnectPermissions", "getSpo2HealthConnectPermissions", "hrHealthConnectPermissions", "getHrHealthConnectPermissions", "healthConnectAllPermissions", "getHealthConnectAllPermissions", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<String> getHealthConnectAllPermissions() {
            return HealthConnectApi.healthConnectAllPermissions;
        }

        public final Set<String> getHealthConnectPermissions(HealthConnectClient healthConnectClient) {
            healthConnectClient.getClass();
            return (Set) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new HealthConnectApi$Companion$getHealthConnectPermissions$1(healthConnectClient, null), 1, null);
        }

        public final Set<String> getHrHealthConnectPermissions() {
            return HealthConnectApi.hrHealthConnectPermissions;
        }

        public final FromToIdResolver getIdResolver() {
            return new FromToIdResolver();
        }

        public final Set<String> getRequiredHealthConnectPermission() {
            return HealthConnectApi.requiredHealthConnectPermission;
        }

        public final Set<String> getSpo2HealthConnectPermissions() {
            return HealthConnectApi.spo2HealthConnectPermissions;
        }

        public final boolean isAvailable(Context context) {
            context.getClass();
            HealthConnectClient.Companion companion = HealthConnectClient.INSTANCE;
            HealthDataSourceProvider healthDataSourceProvider = HealthDataSourceProvider.HEALTH_CONNECT;
            String packageName = healthDataSourceProvider.getPackageName();
            packageName.getClass();
            int sdkStatus = companion.getSdkStatus(context, packageName);
            if (sdkStatus == 1) {
                return false;
            }
            if (sdkStatus != 2) {
                return true;
            }
            String strM = FileInsert$$ExternalSyntheticOutline0.m("market://details?id=", healthDataSourceProvider.getPackageName(), "&url=healthconnect%3A%2F%2Fonboarding");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.android.vending");
            intent.setData(Uri.parse(strM));
            intent.putExtra("overlay", true);
            intent.putExtra("callerId", context.getPackageName());
            context.startActivity(intent);
            return false;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$delete$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$delete$1", f = "HealthConnectApi.kt", l = {172}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ HealthConnectSession $session;
        Object L$0;
        int label;
        final /* synthetic */ HealthConnectApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HealthConnectSession healthConnectSession, HealthConnectApi healthConnectApi, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$session = healthConnectSession;
            this.this$0 = healthConnectApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$session, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                Instant instant = DateRetargetClass.toInstant(this.$session.getFrom());
                instant.getClass();
                Instant instant2 = DateRetargetClass.toInstant(this.$session.getTo());
                instant2.getClass();
                TimeRangeFilter timeRangeFilterBetween = companion.between(instant, instant2);
                HealthConnectClient healthConnectClient = this.this$0.getHealthConnectClient();
                KClass<? extends Record> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SleepSessionRecord.class);
                this.L$0 = SpillingKt.nullOutSpilledVariable(timeRangeFilterBetween);
                this.label = 1;
                if (healthConnectClient.deleteRecords(orCreateKotlinClass, timeRangeFilterBetween, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            HealthConnectApi healthConnectApi = this.this$0;
            String strM = FileInsert$$ExternalSyntheticOutline0.m(this.$session.getSegments().size(), "delete: segments count: ");
            Logger.logInfo(Logger.defaultTag, healthConnectApi.getTag() + ": " + strM, null);
            return ResultStatus.SUCCESS;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$find$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$find$1", f = "HealthConnectApi.kt", l = {107}, m = "invokeSuspend", v = 2)
    public static final class C21561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<HealthConnectSession>>, Object> {
        final /* synthetic */ Date $from;
        final /* synthetic */ List<HealthConnectSession> $sessions;
        final /* synthetic */ Ref$ObjectRef<ReadRecordsResponse<SleepSessionRecord>> $sleepSessionsResponse;
        final /* synthetic */ Date $to;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ HealthConnectApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21561(Date date, Date date2, Ref$ObjectRef<ReadRecordsResponse<SleepSessionRecord>> ref$ObjectRef, HealthConnectApi healthConnectApi, List<HealthConnectSession> list, Continuation<? super C21561> continuation) {
            super(2, continuation);
            this.$from = date;
            this.$to = date2;
            this.$sleepSessionsResponse = ref$ObjectRef;
            this.this$0 = healthConnectApi;
            this.$sessions = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21561(this.$from, this.$to, this.$sleepSessionsResponse, this.this$0, this.$sessions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<HealthConnectSession>> continuation) {
            return ((C21561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterable<SleepSessionRecord> records;
            Ref$ObjectRef<ReadRecordsResponse<SleepSessionRecord>> ref$ObjectRef;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SleepSessionRecord.class);
                    TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                    Instant instant = DateRetargetClass.toInstant(this.$from);
                    instant.getClass();
                    Instant instant2 = DateRetargetClass.toInstant(this.$to);
                    instant2.getClass();
                    ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(orCreateKotlinClass, companion.between(instant, instant2), null, false, 0, null, 60, null);
                    Ref$ObjectRef<ReadRecordsResponse<SleepSessionRecord>> ref$ObjectRef2 = this.$sleepSessionsResponse;
                    HealthConnectClient healthConnectClient = this.this$0.getHealthConnectClient();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(readRecordsRequest);
                    this.L$1 = ref$ObjectRef2;
                    this.label = 1;
                    Object records2 = healthConnectClient.readRecords(readRecordsRequest, this);
                    if (records2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                    t = records2;
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                ref$ObjectRef.element = t;
            } catch (Exception e) {
                HealthConnectApi healthConnectApi = this.this$0;
                String str = "Read records error " + this.$from + " - " + this.$to;
                Logger.logInfo(Logger.defaultTag, healthConnectApi.getTag() + ": " + str, e);
            }
            ReadRecordsResponse<SleepSessionRecord> readRecordsResponse = this.$sleepSessionsResponse.element;
            if (readRecordsResponse != null && (records = readRecordsResponse.getRecords()) != null) {
                List<HealthConnectSession> list = this.$sessions;
                HealthConnectApi healthConnectApi2 = this.this$0;
                for (SleepSessionRecord sleepSessionRecord : records) {
                    List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
                    try {
                        DataSourceProvider dataSourceProviderFind = HealthDataSourceProvider.find(sleepSessionRecord.getMetadata().getDataOrigin().getPackageName());
                        dataSourceProviderFind.getClass();
                        list.add(new HealthConnectSession(sleepSessionRecord, stages, dataSourceProviderFind));
                    } catch (Exception e2) {
                        String str2 = "Read stages error " + sleepSessionRecord.getStartTime();
                        Logger.logInfo(Logger.defaultTag, healthConnectApi2.getTag() + ": " + str2, e2);
                    }
                }
            }
            return this.$sessions;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insert$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insert$1", f = "HealthConnectApi.kt", l = {149}, m = "invokeSuspend", v = 2)
    public static final class C21571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ Ref$ObjectRef<InsertRecordsResponse> $response;
        final /* synthetic */ HealthSession $session;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21571(HealthSession healthSession, Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef, Continuation<? super C21571> continuation) {
            super(2, continuation);
            this.$session = healthSession;
            this.$response = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectApi.this.new C21571(this.$session, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((C21571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef;
            Instant endTime;
            Instant startTime;
            List<String> recordIdsList;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HealthConnectSession.Companion companion = HealthConnectSession.INSTANCE;
                    Context context = HealthConnectApi.this.context;
                    HealthSession healthSession = this.$session;
                    HealthConnectApi healthConnectApi = HealthConnectApi.this;
                    SleepSessionRecord healthConnectSleepSession = companion.toHealthConnectSleepSession(context, healthSession, healthConnectApi.getMetadata(healthConnectApi.context));
                    HealthConnectApi healthConnectApi2 = HealthConnectApi.this;
                    long epochMilli = 0;
                    Date date = new Date((healthConnectSleepSession == null || (startTime = healthConnectSleepSession.getStartTime()) == null) ? 0L : startTime.toEpochMilli());
                    if (healthConnectSleepSession != null && (endTime = healthConnectSleepSession.getEndTime()) != null) {
                        epochMilli = endTime.toEpochMilli();
                    }
                    String str = "Session insert: " + date + " - " + new Date(epochMilli);
                    Logger.logInfo(Logger.defaultTag, healthConnectApi2.getTag() + ": " + str, null);
                    if (healthConnectSleepSession != null && healthConnectSleepSession.getEndTime().toEpochMilli() > healthConnectSleepSession.getStartTime().toEpochMilli()) {
                        Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef2 = this.$response;
                        HealthConnectClient healthConnectClient = HealthConnectApi.this.getHealthConnectClient();
                        List<? extends Record> listListOf = CollectionsKt.listOf(healthConnectSleepSession);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(healthConnectSleepSession);
                        this.L$1 = ref$ObjectRef2;
                        this.label = 1;
                        Object objInsertRecords = healthConnectClient.insertRecords(listListOf, this);
                        if (objInsertRecords == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef = ref$ObjectRef2;
                        t = objInsertRecords;
                    }
                    InsertRecordsResponse insertRecordsResponse = this.$response.element;
                    return (insertRecordsResponse == null && (recordIdsList = insertRecordsResponse.getRecordIdsList()) != null && (recordIdsList.isEmpty() ^ true)) ? ResultStatus.SUCCESS : ResultStatus.FAILURE;
                }
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                t = obj;
                ref$ObjectRef.element = t;
                InsertRecordsResponse insertRecordsResponse2 = this.$response.element;
                if (insertRecordsResponse2 == null) {
                }
            } catch (Exception e) {
                HealthConnectApi healthConnectApi3 = HealthConnectApi.this;
                Logger.logInfo(Logger.defaultTag, healthConnectApi3.getTag() + ": Insert error", e);
                return ResultStatus.FAILURE;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insertHeartRateData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insertHeartRateData$1", f = "HealthConnectApi.kt", l = {262, 275}, m = "invokeSuspend", v = 2)
    public static final class C21581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ long $from;
        final /* synthetic */ List<IEvent> $hrEvents;
        final /* synthetic */ Ref$ObjectRef<InsertRecordsResponse> $response;
        final /* synthetic */ ZoneOffset $tzOffset;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ HealthConnectApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21581(List<IEvent> list, HealthConnectApi healthConnectApi, Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef, long j, ZoneOffset zoneOffset, Continuation<? super C21581> continuation) {
            super(2, continuation);
            this.$hrEvents = list;
            this.this$0 = healthConnectApi;
            this.$response = ref$ObjectRef;
            this.$from = j;
            this.$tzOffset = zoneOffset;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21581(this.$hrEvents, this.this$0, this.$response, this.$from, this.$tzOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((C21581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:42:0x014f A[LOOP:0: B:40:0x0149->B:42:0x014f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0196  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef;
            Object objInsertRecords;
            Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef2;
            T t;
            T t2;
            List<String> recordIdsList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Long lBoxLong = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Iterator<T> it = this.$hrEvents.iterator();
                        if (it.hasNext()) {
                            lBoxLong = Boxing.boxLong(((IEvent) it.next()).getTimestamp());
                            while (it.hasNext()) {
                                Long lBoxLong2 = Boxing.boxLong(((IEvent) it.next()).getTimestamp());
                                if (lBoxLong.compareTo(lBoxLong2) < 0) {
                                    lBoxLong = lBoxLong2;
                                }
                            }
                        }
                        if (lBoxLong != null) {
                            ref$ObjectRef = this.$response;
                            HealthConnectApi healthConnectApi = this.this$0;
                            long j = this.$from;
                            ZoneOffset zoneOffset = this.$tzOffset;
                            List<IEvent> list = this.$hrEvents;
                            long jLongValue = lBoxLong.longValue();
                            HealthConnectClient healthConnectClient = healthConnectApi.getHealthConnectClient();
                            Instant instantOfEpochMilli = Instant.ofEpochMilli(j);
                            instantOfEpochMilli.getClass();
                            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(jLongValue);
                            instantOfEpochMilli2.getClass();
                            List<IEvent> list2 = list;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            for (IEvent iEvent : list2) {
                                Instant instantOfEpochMilli3 = Instant.ofEpochMilli(iEvent.getTimestamp());
                                instantOfEpochMilli3.getClass();
                                arrayList.add(new HeartRateRecord.Sample(instantOfEpochMilli3, (long) iEvent.getValue()));
                                healthConnectApi = healthConnectApi;
                            }
                            HealthConnectApi healthConnectApi2 = healthConnectApi;
                            List<? extends Record> listListOf = CollectionsKt.listOf(new HeartRateRecord(instantOfEpochMilli, zoneOffset, instantOfEpochMilli2, zoneOffset, arrayList, healthConnectApi2.getMetadata(healthConnectApi2.context)));
                            this.L$0 = SpillingKt.nullOutSpilledVariable(lBoxLong);
                            this.L$1 = ref$ObjectRef;
                            this.J$0 = jLongValue;
                            this.I$0 = 0;
                            this.label = 1;
                            Object objInsertRecords2 = healthConnectClient.insertRecords(listListOf, this);
                            t = objInsertRecords2;
                            if (objInsertRecords2 == coroutine_suspended) {
                            }
                        } else {
                            List<IEvent> list3 = this.$hrEvents;
                            ZoneOffset zoneOffset2 = this.$tzOffset;
                            HealthConnectApi healthConnectApi3 = this.this$0;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                            for (IEvent iEvent2 : list3) {
                                Instant instantOfEpochMilli4 = Instant.ofEpochMilli(iEvent2.getTimestamp());
                                instantOfEpochMilli4.getClass();
                                arrayList2.add(new RestingHeartRateRecord(instantOfEpochMilli4, zoneOffset2, (long) iEvent2.getValue(), healthConnectApi3.getMetadata(healthConnectApi3.context)));
                            }
                            Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef3 = this.$response;
                            HealthConnectClient healthConnectClient2 = this.this$0.getHealthConnectClient();
                            this.L$0 = SpillingKt.nullOutSpilledVariable(lBoxLong);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            this.L$2 = ref$ObjectRef3;
                            this.label = 2;
                            objInsertRecords = healthConnectClient2.insertRecords(arrayList2, this);
                            if (objInsertRecords != coroutine_suspended) {
                                ref$ObjectRef2 = ref$ObjectRef3;
                                t2 = objInsertRecords;
                                ref$ObjectRef2.element = t2;
                                InsertRecordsResponse insertRecordsResponse = this.$response.element;
                                if (insertRecordsResponse == null) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$2;
                        ResultKt.throwOnFailure(obj);
                        t2 = obj;
                        ref$ObjectRef2.element = t2;
                        InsertRecordsResponse insertRecordsResponse2 = this.$response.element;
                        return (insertRecordsResponse2 == null && (recordIdsList = insertRecordsResponse2.getRecordIdsList()) != null && (recordIdsList.isEmpty() ^ true)) ? ResultStatus.SUCCESS : ResultStatus.FAILURE;
                    }
                    ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                    lBoxLong = (Long) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                    ref$ObjectRef.element = t;
                    List<IEvent> list32 = this.$hrEvents;
                    ZoneOffset zoneOffset22 = this.$tzOffset;
                    HealthConnectApi healthConnectApi32 = this.this$0;
                    ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list32, 10));
                    while (r2.hasNext()) {
                    }
                    Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef32 = this.$response;
                    HealthConnectClient healthConnectClient22 = this.this$0.getHealthConnectClient();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(lBoxLong);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList22);
                    this.L$2 = ref$ObjectRef32;
                    this.label = 2;
                    objInsertRecords = healthConnectClient22.insertRecords(arrayList22, this);
                    if (objInsertRecords != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                } catch (Exception e) {
                    HealthConnectApi healthConnectApi4 = this.this$0;
                    Logger.logInfo(Logger.defaultTag, healthConnectApi4.getTag() + ": insertHeartRateData error", e);
                    return ResultStatus.FAILURE;
                }
            } catch (Exception e2) {
                HealthConnectApi healthConnectApi5 = this.this$0;
                Logger.logInfo(Logger.defaultTag, healthConnectApi5.getTag() + ": insertRestHeartRateData error", e2);
                return ResultStatus.FAILURE;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insertSPO2Data$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/service/health/ResultStatus;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$insertSPO2Data$1", f = "HealthConnectApi.kt", l = {343}, m = "invokeSuspend", v = 2)
    public static final class C21591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResultStatus>, Object> {
        final /* synthetic */ Ref$ObjectRef<InsertRecordsResponse> $response;
        final /* synthetic */ List<IEvent> $spo2events;
        final /* synthetic */ ZoneOffset $tzOffset;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ HealthConnectApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21591(List<IEvent> list, Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef, HealthConnectApi healthConnectApi, ZoneOffset zoneOffset, Continuation<? super C21591> continuation) {
            super(2, continuation);
            this.$spo2events = list;
            this.$response = ref$ObjectRef;
            this.this$0 = healthConnectApi;
            this.$tzOffset = zoneOffset;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21591(this.$spo2events, this.$response, this.this$0, this.$tzOffset, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ResultStatus> continuation) {
            return ((C21591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef;
            T t;
            List<String> recordIdsList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<IEvent> list = this.$spo2events;
                    ZoneOffset zoneOffset = this.$tzOffset;
                    HealthConnectApi healthConnectApi = this.this$0;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Instant instantOfEpochMilli = Instant.ofEpochMilli(((IEvent) it.next()).getTimestamp());
                        instantOfEpochMilli.getClass();
                        arrayList.add(new OxygenSaturationRecord(instantOfEpochMilli, zoneOffset, new Percentage(r5.getValue()), healthConnectApi.getMetadata(healthConnectApi.context)));
                    }
                    Ref$ObjectRef<InsertRecordsResponse> ref$ObjectRef2 = this.$response;
                    HealthConnectClient healthConnectClient = this.this$0.getHealthConnectClient();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList);
                    this.L$1 = ref$ObjectRef2;
                    this.label = 1;
                    Object objInsertRecords = healthConnectClient.insertRecords(arrayList, this);
                    if (objInsertRecords == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                    t = objInsertRecords;
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                ref$ObjectRef.element = t;
                InsertRecordsResponse insertRecordsResponse = this.$response.element;
                return (insertRecordsResponse == null || (recordIdsList = insertRecordsResponse.getRecordIdsList()) == null || !(recordIdsList.isEmpty() ^ true)) ? ResultStatus.FAILURE : ResultStatus.SUCCESS;
            } catch (Exception e) {
                HealthConnectApi healthConnectApi2 = this.this$0;
                Logger.logInfo(Logger.defaultTag, healthConnectApi2.getTag() + ": insertSPO2Data error", e);
                return ResultStatus.FAILURE;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$readHeartRateData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$HeartRate;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$readHeartRateData$1", f = "HealthConnectApi.kt", l = {200, 222, 229}, m = "invokeSuspend", v = 2)
    public static final class C21601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<SensorRecord.HeartRate>>, Object> {
        final /* synthetic */ long $from;
        final /* synthetic */ List<SensorRecord.HeartRate> $hrData;
        final /* synthetic */ long $to;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21601(long j, long j2, List<SensorRecord.HeartRate> list, Continuation<? super C21601> continuation) {
            super(2, continuation);
            this.$from = j;
            this.$to = j2;
            this.$hrData = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectApi.this.new C21601(this.$from, this.$to, this.$hrData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SensorRecord.HeartRate>> continuation) {
            return ((C21601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0201, code lost:
        
            if (r6 == r0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x027a, code lost:
        
            if (r6.getPageToken() != null) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0196 A[Catch: Exception -> 0x002c, LOOP:1: B:34:0x0190->B:36:0x0196, LOOP_END, TryCatch #0 {Exception -> 0x002c, blocks: (B:8:0x0024, B:42:0x0204, B:44:0x0208, B:45:0x0253, B:47:0x0259, B:48:0x0276, B:37:0x01b3, B:39:0x01b9, B:15:0x0039, B:33:0x0144, B:34:0x0190, B:36:0x0196, B:16:0x0040, B:22:0x008a, B:23:0x0090, B:25:0x0096, B:27:0x00d8, B:28:0x00f4, B:30:0x00fc, B:19:0x0049), top: B:54:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01b9 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:8:0x0024, B:42:0x0204, B:44:0x0208, B:45:0x0253, B:47:0x0259, B:48:0x0276, B:37:0x01b3, B:39:0x01b9, B:15:0x0039, B:33:0x0144, B:34:0x0190, B:36:0x0196, B:16:0x0040, B:22:0x008a, B:23:0x0090, B:25:0x0096, B:27:0x00d8, B:28:0x00f4, B:30:0x00fc, B:19:0x0049), top: B:54:0x0014 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0259 A[Catch: Exception -> 0x002c, LOOP:0: B:45:0x0253->B:47:0x0259, LOOP_END, TryCatch #0 {Exception -> 0x002c, blocks: (B:8:0x0024, B:42:0x0204, B:44:0x0208, B:45:0x0253, B:47:0x0259, B:48:0x0276, B:37:0x01b3, B:39:0x01b9, B:15:0x0039, B:33:0x0144, B:34:0x0190, B:36:0x0196, B:16:0x0040, B:22:0x008a, B:23:0x0090, B:25:0x0096, B:27:0x00d8, B:28:0x00f4, B:30:0x00fc, B:19:0x0049), top: B:54:0x0014 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0201 -> B:42:0x0204). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0207 -> B:44:0x0208). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objAggregateGroupByDuration;
            List<AggregationResultGroupedByDuration> list;
            Object records;
            ReadRecordsResponse readRecordsResponse;
            Iterator it;
            Object records2;
            Iterator it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HealthConnectClient healthConnectClient = HealthConnectApi.this.getHealthConnectClient();
                    Set of = SetsKt.setOf(HeartRateRecord.BPM_AVG);
                    TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                    Instant instantOfEpochMilli = Instant.ofEpochMilli(this.$from);
                    instantOfEpochMilli.getClass();
                    Instant instantOfEpochMilli2 = Instant.ofEpochMilli(this.$to);
                    instantOfEpochMilli2.getClass();
                    TimeRangeFilter timeRangeFilterBetween = companion.between(instantOfEpochMilli, instantOfEpochMilli2);
                    Duration durationOfMinutes = Duration.ofMinutes(10L);
                    durationOfMinutes.getClass();
                    AggregateGroupByDurationRequest aggregateGroupByDurationRequest = new AggregateGroupByDurationRequest(of, timeRangeFilterBetween, durationOfMinutes, null, 8, null);
                    this.label = 1;
                    objAggregateGroupByDuration = healthConnectClient.aggregateGroupByDuration(aggregateGroupByDurationRequest, this);
                    if (objAggregateGroupByDuration == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objAggregateGroupByDuration = obj;
                } else if (i == 2) {
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    records = obj;
                    readRecordsResponse = (ReadRecordsResponse) records;
                    HealthConnectApi healthConnectApi = HealthConnectApi.this;
                    String str = "readHRData RHR records " + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                    Logger.logInfo(Logger.defaultTag, healthConnectApi.getTag() + ": " + str, null);
                    List records3 = readRecordsResponse.getRecords();
                    List<SensorRecord.HeartRate> list2 = this.$hrData;
                    it = records3.iterator();
                    while (it.hasNext()) {
                        list2.add(new SensorRecord.HeartRate(((RestingHeartRateRecord) it.next()).getTime().toEpochMilli(), r11.getBeatsPerMinute()));
                    }
                    if (readRecordsResponse.getPageToken() == null) {
                        HealthConnectClient healthConnectClient2 = HealthConnectApi.this.getHealthConnectClient();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class);
                        TimeRangeFilter.Companion companion2 = TimeRangeFilter.INSTANCE;
                        Instant instantOfEpochMilli3 = Instant.ofEpochMilli(this.$from);
                        instantOfEpochMilli3.getClass();
                        Instant instantOfEpochMilli4 = Instant.ofEpochMilli(this.$to);
                        instantOfEpochMilli4.getClass();
                        ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(orCreateKotlinClass, companion2.between(instantOfEpochMilli3, instantOfEpochMilli4), SetsKt.emptySet(), false, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, readRecordsResponse.getPageToken());
                        this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(readRecordsResponse);
                        this.label = 3;
                        records2 = healthConnectClient2.readRecords(readRecordsRequest, this);
                    } else {
                        HealthConnectApi healthConnectApi2 = HealthConnectApi.this;
                        String str2 = "readHRData RHR records " + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                        Logger.logInfo(Logger.defaultTag, healthConnectApi2.getTag() + ": " + str2, null);
                        List records4 = readRecordsResponse.getRecords();
                        List<SensorRecord.HeartRate> list3 = this.$hrData;
                        it2 = records4.iterator();
                        while (it2.hasNext()) {
                        }
                    }
                } else {
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    records2 = obj;
                    readRecordsResponse = (ReadRecordsResponse) records2;
                    HealthConnectApi healthConnectApi22 = HealthConnectApi.this;
                    String str22 = "readHRData RHR records " + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                    Logger.logInfo(Logger.defaultTag, healthConnectApi22.getTag() + ": " + str22, null);
                    List records42 = readRecordsResponse.getRecords();
                    List<SensorRecord.HeartRate> list32 = this.$hrData;
                    it2 = records42.iterator();
                    while (it2.hasNext()) {
                        list32.add(new SensorRecord.HeartRate(((RestingHeartRateRecord) it2.next()).getTime().toEpochMilli(), r11.getBeatsPerMinute()));
                    }
                }
                list = (List) objAggregateGroupByDuration;
                for (AggregationResultGroupedByDuration aggregationResultGroupedByDuration : list) {
                    Long l = (Long) aggregationResultGroupedByDuration.getResult().get(HeartRateRecord.BPM_AVG);
                    HealthConnectApi healthConnectApi3 = HealthConnectApi.this;
                    String str3 = Logger.defaultTag;
                    Logger.logInfo(str3, healthConnectApi3.getTag() + ": " + ("readHRData aggregate HR " + l), null);
                    if (l != null) {
                        Boxing.boxBoolean(this.$hrData.add(new SensorRecord.HeartRate(aggregationResultGroupedByDuration.getStartTime().toEpochMilli(), l.longValue())));
                    }
                }
                if (this.$hrData.isEmpty()) {
                    HealthConnectClient healthConnectClient3 = HealthConnectApi.this.getHealthConnectClient();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class);
                    TimeRangeFilter.Companion companion3 = TimeRangeFilter.INSTANCE;
                    Instant instantOfEpochMilli5 = Instant.ofEpochMilli(this.$from);
                    instantOfEpochMilli5.getClass();
                    Instant instantOfEpochMilli6 = Instant.ofEpochMilli(this.$to);
                    instantOfEpochMilli6.getClass();
                    ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(orCreateKotlinClass2, companion3.between(instantOfEpochMilli5, instantOfEpochMilli6), SetsKt.emptySet(), false, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, null, 32, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    this.label = 2;
                    records = healthConnectClient3.readRecords(readRecordsRequest2, this);
                    if (records == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    readRecordsResponse = (ReadRecordsResponse) records;
                    HealthConnectApi healthConnectApi4 = HealthConnectApi.this;
                    String str4 = "readHRData RHR records " + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                    Logger.logInfo(Logger.defaultTag, healthConnectApi4.getTag() + ": " + str4, null);
                    List records32 = readRecordsResponse.getRecords();
                    List<SensorRecord.HeartRate> list22 = this.$hrData;
                    it = records32.iterator();
                    while (it.hasNext()) {
                    }
                    if (readRecordsResponse.getPageToken() == null) {
                    }
                }
            } catch (Exception e) {
                HealthConnectApi healthConnectApi5 = HealthConnectApi.this;
                Logger.logInfo(Logger.defaultTag, healthConnectApi5.getTag() + ": readHeartRateData error", e);
            }
            return this.$hrData;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$readSPO2Data$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord$SPO2;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$readSPO2Data$1", f = "HealthConnectApi.kt", l = {302, 309}, m = "invokeSuspend", v = 2)
    public static final class C21611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<SensorRecord.SPO2>>, Object> {
        final /* synthetic */ long $from;
        final /* synthetic */ List<SensorRecord.SPO2> $spo2Data;
        final /* synthetic */ long $to;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21611(long j, long j2, List<SensorRecord.SPO2> list, Continuation<? super C21611> continuation) {
            super(2, continuation);
            this.$from = j;
            this.$to = j2;
            this.$spo2Data = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectApi.this.new C21611(this.$from, this.$to, this.$spo2Data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SensorRecord.SPO2>> continuation) {
            return ((C21611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x016a, code lost:
        
            if (r2 == r0) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x012c A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:7:0x001d, B:29:0x016d, B:30:0x016f, B:31:0x01ba, B:33:0x01c0, B:34:0x01e5, B:24:0x0126, B:26:0x012c, B:13:0x002e, B:19:0x00b3, B:20:0x00fc, B:22:0x0102, B:16:0x0038), top: B:41:0x0013 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01c0 A[Catch: Exception -> 0x0025, LOOP:0: B:31:0x01ba->B:33:0x01c0, LOOP_END, TryCatch #0 {Exception -> 0x0025, blocks: (B:7:0x001d, B:29:0x016d, B:30:0x016f, B:31:0x01ba, B:33:0x01c0, B:34:0x01e5, B:24:0x0126, B:26:0x012c, B:13:0x002e, B:19:0x00b3, B:20:0x00fc, B:22:0x0102, B:16:0x0038), top: B:41:0x0013 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01ec  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x012a -> B:30:0x016f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x016a -> B:29:0x016d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object records;
            ReadRecordsResponse readRecordsResponse;
            String str;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 2;
            String str2 = "readSPO2Data records ";
            try {
            } catch (Exception e) {
                HealthConnectApi healthConnectApi = HealthConnectApi.this;
                Logger.logInfo(Logger.defaultTag, healthConnectApi.getTag() + ": readSPO2Data error", e);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HealthConnectApi healthConnectApi2 = HealthConnectApi.this;
                String str3 = "readSPO2Data records " + Instant.ofEpochMilli(this.$from) + " - " + Instant.ofEpochMilli(this.$to);
                Logger.logInfo(Logger.defaultTag, healthConnectApi2.getTag() + ": " + str3, null);
                HealthConnectClient healthConnectClient = HealthConnectApi.this.getHealthConnectClient();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class);
                TimeRangeFilter.Companion companion = TimeRangeFilter.INSTANCE;
                Instant instantOfEpochMilli = Instant.ofEpochMilli(this.$from);
                instantOfEpochMilli.getClass();
                Instant instantOfEpochMilli2 = Instant.ofEpochMilli(this.$to);
                instantOfEpochMilli2.getClass();
                ReadRecordsRequest readRecordsRequest = new ReadRecordsRequest(orCreateKotlinClass, companion.between(instantOfEpochMilli, instantOfEpochMilli2), SetsKt.emptySet(), false, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, null, 32, null);
                this.label = 1;
                records = healthConnectClient.readRecords(readRecordsRequest, this);
                if (records == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object records2 = obj;
                    str = "readSPO2Data records ";
                    readRecordsResponse = (ReadRecordsResponse) records2;
                    HealthConnectApi healthConnectApi3 = HealthConnectApi.this;
                    String str4 = str + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                    Logger.logInfo(Logger.defaultTag, healthConnectApi3.getTag() + ": " + str4, null);
                    List records3 = readRecordsResponse.getRecords();
                    List<SensorRecord.SPO2> list = this.$spo2Data;
                    for (it = records3.iterator(); it.hasNext(); it = it) {
                        OxygenSaturationRecord oxygenSaturationRecord = (OxygenSaturationRecord) it.next();
                        list.add(new SensorRecord.SPO2(oxygenSaturationRecord.getTime().toEpochMilli(), (float) oxygenSaturationRecord.getPercentage().getValue()));
                    }
                    if (readRecordsResponse.getPageToken() != null) {
                        i2 = 2;
                        if (readRecordsResponse.getPageToken() != null) {
                            HealthConnectClient healthConnectClient2 = HealthConnectApi.this.getHealthConnectClient();
                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class);
                            TimeRangeFilter.Companion companion2 = TimeRangeFilter.INSTANCE;
                            Instant instantOfEpochMilli3 = Instant.ofEpochMilli(this.$from);
                            instantOfEpochMilli3.getClass();
                            Instant instantOfEpochMilli4 = Instant.ofEpochMilli(this.$to);
                            instantOfEpochMilli4.getClass();
                            ReadRecordsRequest readRecordsRequest2 = new ReadRecordsRequest(orCreateKotlinClass2, companion2.between(instantOfEpochMilli3, instantOfEpochMilli4), SetsKt.emptySet(), true, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, readRecordsResponse.getPageToken());
                            this.L$0 = SpillingKt.nullOutSpilledVariable(readRecordsResponse);
                            this.label = i2;
                            records2 = healthConnectClient2.readRecords(readRecordsRequest2, this);
                        }
                        HealthConnectApi healthConnectApi32 = HealthConnectApi.this;
                        String str42 = str + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
                        Logger.logInfo(Logger.defaultTag, healthConnectApi32.getTag() + ": " + str42, null);
                        List records32 = readRecordsResponse.getRecords();
                        List<SensorRecord.SPO2> list2 = this.$spo2Data;
                        while (it.hasNext()) {
                        }
                        if (readRecordsResponse.getPageToken() != null) {
                        }
                    }
                    return this.$spo2Data;
                }
                ResultKt.throwOnFailure(obj);
                records = obj;
            }
            readRecordsResponse = (ReadRecordsResponse) records;
            HealthConnectApi healthConnectApi4 = HealthConnectApi.this;
            String str5 = "readSPO2Data records " + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
            Logger.logInfo(Logger.defaultTag, healthConnectApi4.getTag() + ": " + str5, null);
            List<OxygenSaturationRecord> records4 = readRecordsResponse.getRecords();
            List<SensorRecord.SPO2> list3 = this.$spo2Data;
            for (OxygenSaturationRecord oxygenSaturationRecord2 : records4) {
                list3.add(new SensorRecord.SPO2(oxygenSaturationRecord2.getTime().toEpochMilli(), (float) oxygenSaturationRecord2.getPercentage().getValue()));
                str2 = str2;
            }
            str = str2;
            if (readRecordsResponse.getPageToken() != null) {
            }
            HealthConnectApi healthConnectApi322 = HealthConnectApi.this;
            String str422 = str + readRecordsResponse.getRecords().size() + " token " + readRecordsResponse.getPageToken();
            Logger.logInfo(Logger.defaultTag, healthConnectApi322.getTag() + ": " + str422, null);
            List records322 = readRecordsResponse.getRecords();
            List<SensorRecord.SPO2> list22 = this.$spo2Data;
            while (it.hasNext()) {
            }
            if (readRecordsResponse.getPageToken() != null) {
            }
            return this.$spo2Data;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$revokeAllPermissions$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi$revokeAllPermissions$1", f = "HealthConnectApi.kt", l = {383}, m = "invokeSuspend", v = 2)
    public static final class C21621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C21621(Continuation<? super C21621> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthConnectApi.this.new C21621(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PermissionController permissionController = HealthConnectClient.Companion.getOrCreate$default(HealthConnectClient.INSTANCE, HealthConnectApi.this.context, null, 2, null).getPermissionController();
                    this.label = 1;
                    Object objRevokeAllPermissions = permissionController.revokeAllPermissions(this);
                    this = objRevokeAllPermissions;
                    if (objRevokeAllPermissions == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, HealthConnectApi.this.getTag(), e);
            }
            return Unit.INSTANCE;
        }
    }

    static {
        HealthPermission.Companion companion = HealthPermission.INSTANCE;
        Set<String> of = SetsKt.setOf(companion.getWritePermission(Reflection.getOrCreateKotlinClass(SleepSessionRecord.class)));
        requiredHealthConnectPermission = of;
        Set<String> of2 = SetsKt.setOf(companion.getReadPermission(Reflection.getOrCreateKotlinClass(SleepSessionRecord.class)));
        readHealthConnectPermission = of2;
        Set<String> of3 = SetsKt.setOf((Object[]) new String[]{companion.getReadPermission(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class)), companion.getWritePermission(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class))});
        spo2HealthConnectPermissions = of3;
        Set<String> of4 = SetsKt.setOf((Object[]) new String[]{companion.getReadPermission(Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class)), companion.getWritePermission(Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class)), companion.getReadPermission(Reflection.getOrCreateKotlinClass(HeartRateRecord.class)), companion.getWritePermission(Reflection.getOrCreateKotlinClass(HeartRateRecord.class))});
        hrHealthConnectPermissions = of4;
        healthConnectAllPermissions = SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) of, (Iterable) of2), (Iterable) of3), (Iterable) of4), "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
    }

    public HealthConnectApi(Context context) {
        context.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        this.tag = "HealthConnect-api";
    }

    private final boolean hasPermissions(Set<String> permissions) {
        try {
            Companion companion = INSTANCE;
            if (companion.isAvailable(this.context)) {
                if (companion.getHealthConnectPermissions(getHealthConnectClient()).containsAll(permissions)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Logger.logSevere(null, e);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public boolean connect() {
        try {
            setHealthConnectClient(HealthConnectClient.Companion.getOrCreate$default(HealthConnectClient.INSTANCE, this.context, null, 2, null));
            boolean z = INSTANCE.isAvailable(this.context) && hasPermissions(requiredHealthConnectPermission);
            this.connected = z;
            return z;
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus delete(Collection<HealthConnectSession> sessions) {
        sessions.getClass();
        Collection<HealthConnectSession> collection = sessions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            ResultStatus resultStatusDelete = delete((HealthConnectSession) it.next());
            ResultStatus resultStatus = ResultStatus.FAILURE;
            if (Intrinsics.areEqual(resultStatusDelete, resultStatus)) {
                resultStatus.getClass();
                return resultStatus;
            }
            arrayList.add(Unit.INSTANCE);
        }
        ResultStatus resultStatus2 = ResultStatus.SUCCESS;
        resultStatus2.getClass();
        return resultStatus2;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public void disconnect() {
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public Collection<HealthConnectSession> find(Date from, Date to) {
        if (from != null && to != null) {
            return (Collection) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21561(from, to, new Ref$ObjectRef(), this, new ArrayList(), null), 1, null);
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": find: Missing interval boundary", null);
        return new ArrayList();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final HealthConnectClient getHealthConnectClient() {
        HealthConnectClient healthConnectClient = this.healthConnectClient;
        if (healthConnectClient != null) {
            return healthConnectClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("healthConnectClient");
        return null;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public FromToIdResolver getIdResolver() {
        return INSTANCE.getIdResolver();
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public int getMaxRecordSyncCount() {
        return 100;
    }

    public final androidx.health.connect.client.records.metadata.Metadata getMetadata(Context context) {
        context.getClass();
        return androidx.health.connect.client.records.metadata.Metadata.INSTANCE.activelyRecorded(new Device(2, Build.MANUFACTURER, Build.MODEL));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final boolean hasHrPermissions() {
        return hasPermissions(hrHealthConnectPermissions);
    }

    public final boolean hasSpo2Permissions() {
        return hasPermissions(spo2HealthConnectPermissions);
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insert(HealthSession session) {
        if (session != null) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("INSERT START ", session.getClass());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        }
        if (session == null) {
            return ResultStatus.FAILURE;
        }
        new CountDownLatch(1);
        return (ResultStatus) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21571(session, new Ref$ObjectRef(), null), 1, null);
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insertHeartRateData(long from, List<IEvent> hrEvents) {
        hrEvents.getClass();
        if (hrEvents.isEmpty()) {
            ResultStatus resultStatus = ResultStatus.FAILURE;
            resultStatus.getClass();
            return resultStatus;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": insertHeartRateData START", null);
        Object objRunBlockingK$default = BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21581(hrEvents, this, new Ref$ObjectRef(), from, ZoneOffset.ofTotalSeconds(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000), null), 1, null);
        objRunBlockingK$default.getClass();
        return (ResultStatus) objRunBlockingK$default;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public ResultStatus insertSPO2Data(long from, List<IEvent> spo2events) {
        spo2events.getClass();
        if (spo2events.isEmpty()) {
            ResultStatus resultStatus = ResultStatus.FAILURE;
            resultStatus.getClass();
            return resultStatus;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": insertSPO2Data START", null);
        Object objRunBlockingK$default = BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21591(spo2events, new Ref$ObjectRef(), this, ZoneOffset.ofTotalSeconds(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000), null), 1, null);
        objRunBlockingK$default.getClass();
        return (ResultStatus) objRunBlockingK$default;
    }

    @Override // com.urbandroid.sleep.service.health.api.HealthApi
    /* JADX INFO: renamed from: isConnected, reason: from getter */
    public boolean getIsConnected() {
        return this.connected;
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.HeartRate> readHeartRateData(Activity activity, long from, long to) {
        return (List) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21601(from, to, new ArrayList(), null), 1, null);
    }

    @Override // com.urbandroid.sleep.service.health.api.AbstractHealthApi, com.urbandroid.sleep.service.health.api.HealthApi
    public List<SensorRecord.SPO2> readSPO2Data(Activity activity, long from, long to) {
        return (List) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new C21611(from, to, new ArrayList(), null), 1, null);
    }

    public final void revokeAllPermissions() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21621(null), 3, null);
    }

    public final void setHealthConnectClient(HealthConnectClient healthConnectClient) {
        healthConnectClient.getClass();
        this.healthConnectClient = healthConnectClient;
    }

    public ResultStatus delete(HealthConnectSession session) {
        if (session != null) {
            Object objRunBlockingK$default = BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new AnonymousClass1(session, this, null), 1, null);
            objRunBlockingK$default.getClass();
            return (ResultStatus) objRunBlockingK$default;
        }
        ResultStatus resultStatus = ResultStatus.FAILURE;
        resultStatus.getClass();
        return resultStatus;
    }
}
