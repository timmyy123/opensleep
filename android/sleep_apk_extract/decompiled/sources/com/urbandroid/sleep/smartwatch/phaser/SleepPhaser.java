package com.urbandroid.sleep.smartwatch.phaser;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.bluetoothle.BluetoothException;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetectorFactoryKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBufferVX;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient;
import com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserInfo;
import com.urbandroid.sleep.smartwatch.phaser.protocol.Status;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0019J\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\"J\u0017\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010\u0019J\u000f\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u0019J\u000f\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010\u0019J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010\u0019J\u0015\u00100\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\f¢\u0006\u0004\b0\u0010\u0013J\u0017\u0010.\u001a\u00020\u000e2\u0006\u00101\u001a\u00020#H\u0016¢\u0006\u0004\b.\u0010&J\u000f\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b2\u0010\u0019J\r\u00104\u001a\u000203¢\u0006\u0004\b4\u00105J\u0017\u00102\u001a\u00020\u000e2\u0006\u00106\u001a\u00020#H\u0016¢\u0006\u0004\b2\u0010&J\u000f\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u0019J\u0017\u00109\u001a\u0002032\u0006\u00108\u001a\u00020\u001cH\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020#H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020#H\u0016¢\u0006\u0004\b=\u0010<J\u000f\u0010>\u001a\u00020\u000eH\u0016¢\u0006\u0004\b>\u0010\u0019J\u000f\u0010?\u001a\u00020#H\u0016¢\u0006\u0004\b?\u0010<J\u0017\u0010A\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020#H\u0016¢\u0006\u0004\bA\u0010&J\u0017\u0010C\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\fH\u0016¢\u0006\u0004\bC\u0010\u0013J\u000f\u0010D\u001a\u00020\u000eH\u0016¢\u0006\u0004\bD\u0010\u0019J\u0017\u0010F\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020#H\u0016¢\u0006\u0004\bF\u0010&J\u0017\u0010H\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u001cH\u0016¢\u0006\u0004\bH\u0010\"J\r\u0010I\u001a\u00020\u000e¢\u0006\u0004\bI\u0010\u0019J\r\u0010K\u001a\u00020J¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010Q\u001a\u00020#2\u0006\u0010P\u001a\u00020#H\u0002¢\u0006\u0004\bQ\u0010RJ'\u0010U\u001a\u00020#2\u0006\u0010S\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010T\u001a\u00020#H\u0002¢\u0006\u0004\bU\u0010VJ\u0018\u0010W\u001a\u00020\u000e2\u0006\u00101\u001a\u00020#H\u0082@¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u000eH\u0082@¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u000eH\u0002¢\u0006\u0004\b[\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010oR\u0016\u0010z\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010o¨\u0006{"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/SleepPhaser;", "Lcom/urbandroid/sleep/smartwatch/SmartWatch;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "Lcom/urbandroid/sleep/sensor/IAccelManager;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;", "callback", "", "timeoutMillis", "", "asyncConnectionCheck", "(Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;J)V", "ts", "updatePause", "(J)V", "Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;", "listener", "startTracking", "(Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;)V", "stopTracking", "()V", "getAccelManager", "()Lcom/urbandroid/sleep/sensor/IAccelManager;", "", "isConnected", "()Z", "close", "off", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", "shortHint", ViewHierarchyConstants.HINT_KEY, "timeout", "synchronousHint", "repeat", "start", "", "getBufferedRawData", "()[F", "sensorDelay", "stop", "forceFlush", "resetChanges", "(Z)[F", "getMaxBatchSize", "()I", "getMaxDelayedPoints", "resetZerosCount", "getCountOfZeroValuesInRow", "delay", "startAlarm", "timestamp", "updateAlarm", "stopAlarm", "batchSize", "setBatchSize", "suspended", "setSuspended", "shutdown", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserInfo;", "getInfo", "()Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserInfo;", "", "getPlatform", "()Ljava/lang/String;", "c", "colorRange", "(I)I", "min", "x", "minMax", "(III)I", "hintWithRetry", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRawData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectBreath", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/bluetooth/BluetoothDevice;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;", "phaser", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;", "Lcom/urbandroid/sleep/smartwatch/phaser/CoroutineRunner;", "runner", "Lcom/urbandroid/sleep/smartwatch/phaser/CoroutineRunner;", "Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBufferVX;", "activityData", "Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBufferVX;", "", "maxIntensity", "F", "awakeDetection", "Z", "Lcom/urbandroid/util/StringBufferPersister;", "rawDataLog", "Lcom/urbandroid/util/StringBufferPersister;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "breathDetector", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/Status;", "tracking", "lightTurnedOnByOurApp", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepPhaser implements SmartWatch, SmartLight, IAccelManager {
    private final ActivityDataBufferVX activityData;
    private final boolean awakeDetection;
    private volatile RespiratoryDetector breathDetector;
    private final Context context;
    private final BluetoothDevice device;
    private volatile boolean lightTurnedOnByOurApp;
    private final float maxIntensity;
    private final SleepPhaserBLEClient phaser;
    private volatile StringBufferPersister rawDataLog;
    private final CoroutineRunner runner;
    private volatile Status status;
    private volatile boolean tracking;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$asyncConnectionCheck$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$asyncConnectionCheck$1", f = "SleepPhaser.kt", l = {55}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IConnectivityCallback $callback;
        final /* synthetic */ long $timeoutMillis;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$asyncConnectionCheck$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$asyncConnectionCheck$1$1", f = "SleepPhaser.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class C00581 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ IConnectivityCallback $callback;
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00581(IConnectivityCallback iConnectivityCallback, SleepPhaser sleepPhaser, Continuation<? super C00581> continuation) {
                super(1, continuation);
                this.$callback = iConnectivityCallback;
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00581(this.$callback, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00581) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.status(this.this$0, true);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, IConnectivityCallback iConnectivityCallback, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$timeoutMillis = j;
            this.$callback = iConnectivityCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new AnonymousClass1(this.$timeoutMillis, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                    int i2 = (int) (this.$timeoutMillis / 10000);
                    C00581 c00581 = new C00581(this.$callback, SleepPhaser.this, null);
                    this.label = 1;
                    Object objRetryWithReconnect = CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, i2, c00581, this);
                    this = objRetryWithReconnect;
                    if (objRetryWithReconnect == coroutine_suspended) {
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
            } catch (Exception unused) {
                this.$callback.status(null, false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$fetchRawData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser", f = "SleepPhaser.kt", l = {241, 260, 264}, m = "fetchRawData", v = 2)
    public static final class C21951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21951(Continuation<? super C21951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SleepPhaser.this.fetchRawData(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$hint$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$hint$1", f = "SleepPhaser.kt", l = {189}, m = "invokeSuspend", v = 2)
    public static final class C21961 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21961(int i, Continuation<? super C21961> continuation) {
            super(1, continuation);
            this.$repeat = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C21961(this.$repeat, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21961) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaser sleepPhaser = SleepPhaser.this;
                int i2 = this.$repeat;
                this.label = 1;
                if (sleepPhaser.hintWithRetry(i2, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$hintWithRetry$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$hintWithRetry$2", f = "SleepPhaser.kt", l = {194, 195, 196}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$repeat = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new AnonymousClass2(this.$repeat, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        
            if (r6.blinks(r1, 1000, r5) != r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                this.label = 1;
                if (sleepPhaserBLEClient.setIntensity(0, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient2 = SleepPhaser.this.phaser;
                int i2 = this.$repeat;
                this.label = 3;
            }
            SleepPhaserBLEClient sleepPhaserBLEClient3 = SleepPhaser.this.phaser;
            this.label = 2;
            if (sleepPhaserBLEClient3.setRGB(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, this) != coroutine_suspended) {
                SleepPhaserBLEClient sleepPhaserBLEClient22 = SleepPhaser.this.phaser;
                int i22 = this.$repeat;
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$nightLight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$nightLight$1", f = "SleepPhaser.kt", l = {107}, m = "invokeSuspend", v = 2)
    public static final class C21971 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$nightLight$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$nightLight$1$1", f = "SleepPhaser.kt", l = {109, 110, 111}, m = "invokeSuspend", v = 2)
        public static final class C00591 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00591(SleepPhaser sleepPhaser, Continuation<? super C00591> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00591(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00591) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
            
                if (r7.lampOn(r6) != r0) goto L21;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.lightTurnedOnByOurApp = true;
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.setIntensity(0, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient2 = this.this$0.phaser;
                    this.label = 3;
                }
                SleepPhaserBLEClient sleepPhaserBLEClient3 = this.this$0.phaser;
                this.label = 2;
                if (sleepPhaserBLEClient3.setRGB(75, 1, 0, this) != coroutine_suspended) {
                    SleepPhaserBLEClient sleepPhaserBLEClient22 = this.this$0.phaser;
                    this.label = 3;
                }
                return coroutine_suspended;
            }
        }

        public C21971(Continuation<? super C21971> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C21971(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21971) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00591 c00591 = new C00591(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 1, c00591, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$off$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$off$1", f = "SleepPhaser.kt", l = {91}, m = "invokeSuspend", v = 2)
    public static final class C21981 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$off$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$off$1$1", f = "SleepPhaser.kt", l = {92}, m = "invokeSuspend", v = 2)
        public static final class C00601 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00601(SleepPhaser sleepPhaser, Continuation<? super C00601> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00601(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00601) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.lampOff(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.lightTurnedOnByOurApp = false;
                return Unit.INSTANCE;
            }
        }

        public C21981(Continuation<? super C21981> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C21981(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21981) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00601 c00601 = new C00601(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 3, c00601, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$shortHint$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$shortHint$1", f = "SleepPhaser.kt", l = {168}, m = "invokeSuspend", v = 2)
    public static final class C21991 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$shortHint$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$shortHint$1$1", f = "SleepPhaser.kt", l = {169}, m = "invokeSuspend", v = 2)
        public static final class C00611 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00611(SleepPhaser sleepPhaser, Continuation<? super C00611> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00611(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00611) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.shortBlink(this) == coroutine_suspended) {
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

        public C21991(Continuation<? super C21991> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C21991(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21991) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00611 c00611 = new C00611(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 3, c00611, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$1", f = "SleepPhaser.kt", l = {210}, m = "invokeSuspend", v = 2)
    public static final class C22001 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C22001(Continuation<? super C22001> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22001(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22001) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                this.label = 1;
                if (sleepPhaserBLEClient.startLog(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$2", f = "SleepPhaser.kt", l = {219}, m = "invokeSuspend", v = 2)
    public static final class C22012 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$2$1", f = "SleepPhaser.kt", l = {220, 221}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SleepPhaser sleepPhaser, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
            
                if (r5.actigraphyOn(r4) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.actigraphyReset(this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient2 = this.this$0.phaser;
                this.label = 2;
            }
        }

        public C22012(Continuation<? super C22012> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22012(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22012) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 3, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$3", f = "SleepPhaser.kt", l = {228}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$3$1", f = "SleepPhaser.kt", l = {228}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SleepPhaser sleepPhaser, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaser sleepPhaser = this.this$0;
                    this.label = 1;
                    if (sleepPhaser.fetchRawData(this) == coroutine_suspended) {
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

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.reconnectBefore(sleepPhaserBLEClient, anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$start$4", f = "SleepPhaser.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            SleepPhaser.this.detectBreath();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$stop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$stop$1", f = "SleepPhaser.kt", l = {299}, m = "invokeSuspend", v = 2)
    public static final class C22021 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C22021(Continuation<? super C22021> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22021(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22021) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.actigraphyOff(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (BluetoothException e) {
                Logger.logInfo("SleepPhaser: stop() 2", e);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$stop$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$stop$2", f = "SleepPhaser.kt", l = {315}, m = "invokeSuspend", v = 2)
    public static final class C22032 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C22032(Continuation<? super C22032> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22032(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22032) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                this.label = 1;
                if (sleepPhaserBLEClient.endLog(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunrise$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunrise$1", f = "SleepPhaser.kt", l = {126}, m = "invokeSuspend", v = 2)
    public static final class C22041 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $b;
        final /* synthetic */ int $g;
        final /* synthetic */ int $r;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunrise$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunrise$1$1", f = "SleepPhaser.kt", l = {127}, m = "invokeSuspend", v = 2)
        public static final class C00621 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ int $b;
            final /* synthetic */ int $g;
            final /* synthetic */ int $r;
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00621(SleepPhaser sleepPhaser, int i, int i2, int i3, Continuation<? super C00621> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
                this.$r = i;
                this.$g = i2;
                this.$b = i3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00621(this.this$0, this.$r, this.$g, this.$b, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00621) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    int i2 = this.$r;
                    int i3 = this.$g;
                    int i4 = this.$b;
                    this.label = 1;
                    if (sleepPhaserBLEClient.setRGB(i2, i3, i4, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22041(int i, int i2, int i3, Continuation<? super C22041> continuation) {
            super(1, continuation);
            this.$r = i;
            this.$g = i2;
            this.$b = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22041(this.$r, this.$g, this.$b, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22041) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00621 c00621 = new C00621(SleepPhaser.this, this.$r, this.$g, this.$b, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 1, c00621, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseFull$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseFull$1", f = "SleepPhaser.kt", l = {155}, m = "invokeSuspend", v = 2)
    public static final class C22051 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseFull$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseFull$1$1", f = "SleepPhaser.kt", l = {156}, m = "invokeSuspend", v = 2)
        public static final class C00631 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00631(SleepPhaser sleepPhaser, Continuation<? super C00631> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00631(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00631) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    int i2 = (int) (this.this$0.maxIntensity * 255.0f);
                    int i3 = (int) (this.this$0.maxIntensity * 150.0f);
                    int i4 = (int) (this.this$0.maxIntensity * 100.0f);
                    this.label = 1;
                    if (sleepPhaserBLEClient.setRGB(i2, i3, i4, this) == coroutine_suspended) {
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

        public C22051(Continuation<? super C22051> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22051(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22051) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00631 c00631 = new C00631(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 1, c00631, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseStart$1", f = "SleepPhaser.kt", l = {143}, m = "invokeSuspend", v = 2)
    public static final class C22061 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseStart$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$sunriseStart$1$1", f = "SleepPhaser.kt", l = {145, 146, 147}, m = "invokeSuspend", v = 2)
        public static final class C00641 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SleepPhaser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00641(SleepPhaser sleepPhaser, Continuation<? super C00641> continuation) {
                super(1, continuation);
                this.this$0 = sleepPhaser;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00641(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00641) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
            
                if (r7.lampOn(r6) != r0) goto L21;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.lightTurnedOnByOurApp = true;
                    SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
                    this.label = 1;
                    if (sleepPhaserBLEClient.setIntensity(0, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    SleepPhaserBLEClient sleepPhaserBLEClient2 = this.this$0.phaser;
                    this.label = 3;
                }
                SleepPhaserBLEClient sleepPhaserBLEClient3 = this.this$0.phaser;
                this.label = 2;
                if (sleepPhaserBLEClient3.setRGB(10, 0, 0, this) != coroutine_suspended) {
                    SleepPhaserBLEClient sleepPhaserBLEClient22 = this.this$0.phaser;
                    this.label = 3;
                }
                return coroutine_suspended;
            }
        }

        public C22061(Continuation<? super C22061> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22061(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22061) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaserBLEClient sleepPhaserBLEClient = SleepPhaser.this.phaser;
                C00641 c00641 = new C00641(SleepPhaser.this, null);
                this.label = 1;
                if (CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 3, c00641, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$synchronousHint$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.SleepPhaser$synchronousHint$1", f = "SleepPhaser.kt", l = {181}, m = "invokeSuspend", v = 2)
    public static final class C22071 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C22071(Continuation<? super C22071> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SleepPhaser.this.new C22071(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C22071) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SleepPhaser sleepPhaser = SleepPhaser.this;
                this.label = 1;
                if (sleepPhaser.hintWithRetry(1, this) == coroutine_suspended) {
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

    public SleepPhaser(Context context, BluetoothDevice bluetoothDevice) {
        context.getClass();
        bluetoothDevice.getClass();
        this.context = context;
        this.device = bluetoothDevice;
        SleepPhaserBLEClient sleepPhaserBLEClient = new SleepPhaserBLEClient(context, bluetoothDevice);
        this.phaser = sleepPhaserBLEClient;
        this.runner = new CoroutineRunner();
        this.activityData = new ActivityDataBufferVX(sleepPhaserBLEClient);
        this.maxIntensity = new Settings(context).getSmartlightMaxIntensity();
        this.awakeDetection = new Settings(context).isSleepPhaserSmartLight();
        this.status = new Status(0);
        zza$$ExternalSyntheticOutline0.m("SleepPhaser: constructor(", bluetoothDevice.getAddress());
    }

    private final int colorRange(int c) {
        return minMax(0, PHIpAddressSearchManager.END_IP_SCAN, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detectBreath() {
        if (this.breathDetector != null) {
            float[] bufferedRawData = getBufferedRawData();
            if (bufferedRawData.length == 300) {
                RespiratoryDetector respiratoryDetector = this.breathDetector;
                respiratoryDetector.getClass();
                respiratoryDetector.detect(bufferedRawData, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        if (r7.actigraphyOn(r0) == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
    
        if (r7.actigraphyOff(r0) == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchRawData(Continuation<? super Unit> continuation) {
        C21951 c21951;
        if (continuation instanceof C21951) {
            c21951 = (C21951) continuation;
            int i = c21951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21951.label = i - Integer.MIN_VALUE;
            } else {
                c21951 = new C21951(continuation);
            }
        }
        Object objFetchRawData = c21951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21951.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFetchRawData);
            SleepPhaserBLEClient sleepPhaserBLEClient = this.phaser;
            c21951.label = 1;
            objFetchRawData = sleepPhaserBLEClient.fetchRawData(c21951);
            if (objFetchRawData != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objFetchRawData);
                return Unit.INSTANCE;
            }
            if (i2 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objFetchRawData);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(objFetchRawData);
        ActigraphyResult actigraphyResult = (ActigraphyResult) objFetchRawData;
        Status status = actigraphyResult.status;
        status.getClass();
        this.status = status;
        if (!this.tracking) {
            if (actigraphyResult.status.isActigraphyOn()) {
                SleepPhaserBLEClient sleepPhaserBLEClient2 = this.phaser;
                c21951.L$0 = SpillingKt.nullOutSpilledVariable(actigraphyResult);
                c21951.label = 3;
            }
            return Unit.INSTANCE;
        }
        if (!this.status.isLightOn()) {
            this.lightTurnedOnByOurApp = false;
        }
        if (this.status.isLightOn() && !this.lightTurnedOnByOurApp && this.awakeDetection) {
            Logger.logInfo("Light is on, pausing.");
            ContextExtKt.sendExplicitBroadcast$default(this.context, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING_CAP"), null, 2, null);
        }
        if (actigraphyResult.status.isActigraphyOn()) {
            if (!this.activityData.process(actigraphyResult, this.rawDataLog) && this.breathDetector != null) {
                RespiratoryDetector respiratoryDetector = this.breathDetector;
                respiratoryDetector.getClass();
                respiratoryDetector.dataBroken();
            }
            return Unit.INSTANCE;
        }
        SleepPhaserBLEClient sleepPhaserBLEClient3 = this.phaser;
        c21951.L$0 = SpillingKt.nullOutSpilledVariable(actigraphyResult);
        c21951.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object hintWithRetry(int i, Continuation<? super Unit> continuation) {
        Object objRetryWithReconnect = CoroutineRunnerKt.retryWithReconnect(this.phaser, 3, new AnonymousClass2(i, null), continuation);
        return objRetryWithReconnect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRetryWithReconnect : Unit.INSTANCE;
    }

    private final int minMax(int min, int max, int x) {
        return Math.max(min, Math.min(max, x));
    }

    public void asyncConnectionCheck(IConnectivityCallback callback, long timeoutMillis) {
        callback.getClass();
        Logger.logInfo("SleepPhaser: asyncConnectionCheck()");
        this.runner.launch(new AnonymousClass1(timeoutMillis, callback, null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        return this;
    }

    public final float[] getBufferedRawData() {
        return this.activityData.getRawData();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getCountOfZeroValuesInRow() {
        return 0;
    }

    public final SleepPhaserInfo getInfo() {
        return this.phaser.getInfo();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return this.activityData.getMaxBackfillSize() + 1;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return this.activityData.getMaxBackfillSize();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "SLEEPPHASER";
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int repeat) {
        Logger.logInfo("SleepPhaser: hint(" + repeat + ")");
        this.runner.launch(new C21961(repeat, null));
    }

    public boolean isConnected() {
        return this.phaser.isConnected();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
        Logger.logInfo("SleepPhaser: nightLight()");
        if (this.status.isLightOn()) {
            return;
        }
        this.runner.launch(new C21971(null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
        Logger.logInfo("SleepPhaser: off()");
        this.runner.launch(new C21981(null));
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public float[] resetChanges(boolean forceFlush) {
        return this.activityData.getAndResetAggregatedData();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void resetZerosCount() {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int batchSize) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean suspended) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        Logger.logInfo("SleepPhaser: shortHint()");
        this.runner.launch(new C21991(null));
    }

    public final void shutdown() {
        Logger.logInfo("SleepPhaser: shutdown()");
        try {
            this.phaser.disconnectAsync();
        } finally {
            this.runner.cancelAllTasks();
        }
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start() {
        Logger.logInfo("SleepPhaser: start()");
        if (this.tracking) {
            return;
        }
        this.tracking = true;
        this.lightTurnedOnByOurApp = false;
        this.status = new Status(1);
        this.activityData.reset();
        this.runner.launch(new C22001(null));
        this.rawDataLog = Experiments.getInstance().isRawActigraphyPersistentExperiment() ? new StringBufferPersister("Activity_raw", 10000, true) : null;
        this.runner.launch(new C22012(null));
        this.runner.scheduleWithFixedDelay(23000L, 17000L, new AnonymousClass3(null));
        this.breathDetector = RespiratoryDetectorFactoryKt.createRespiratoryDetector(5.0f);
        this.runner.scheduleWithFixedDelay(32000L, 30000L, new AnonymousClass4(null));
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int delay) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener listener) {
        listener.getClass();
        start();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void stop() {
        Logger.logInfo("SleepPhaser: stop() 1");
        try {
            try {
                if (this.tracking) {
                    this.tracking = false;
                    this.lightTurnedOnByOurApp = false;
                    this.activityData.reset();
                    this.status = new Status(0);
                    if (isConnected()) {
                        this.runner.launch(new C22021(null));
                    }
                    if (this.rawDataLog != null) {
                        StringBufferPersister stringBufferPersister = this.rawDataLog;
                        stringBufferPersister.getClass();
                        stringBufferPersister.flush();
                        this.rawDataLog = null;
                    }
                    if (this.breathDetector != null) {
                        RespiratoryDetector respiratoryDetector = this.breathDetector;
                        respiratoryDetector.getClass();
                        respiratoryDetector.trackingFinished();
                    }
                    this.runner.launch(new C22032(null));
                }
            } catch (RuntimeException e) {
                Logger.logSevere("SleepPhaser: stop() 3", e);
            }
            this.runner.cancelAllTasks();
        } catch (Throwable th) {
            this.runner.cancelAllTasks();
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        stop();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        Logger.logInfo("SleepPhaser: sunrise(" + progress + ", " + max + ")");
        double d = ((double) progress) / ((double) max);
        int iColorRange = colorRange((int) ((245.0d * d * ((double) this.maxIntensity)) + 10.0d));
        double d2 = d * d;
        int iColorRange2 = colorRange((int) ((150.0d * d2 * ((double) this.maxIntensity)) + 0.0d));
        int iColorRange3 = colorRange((int) ((d2 * d * d * 100.0d * ((double) this.maxIntensity)) + 0.0d));
        float f = this.maxIntensity;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(iColorRange, iColorRange2, "SleepPhaser: rgb(", ", ", ", ");
        sbM.append(iColorRange3);
        sbM.append(") ");
        sbM.append(f);
        Logger.logInfo(sbM.toString());
        this.runner.launch(new C22041(iColorRange, iColorRange2, iColorRange3, null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        Logger.logInfo("SleepPhaser: sunriseFull()");
        this.runner.launch(new C22051(null));
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        Logger.logInfo("SleepPhaser: sunriseStart()");
        this.runner.launch(new C22061(null));
    }

    public final void synchronousHint(long timeout) {
        Logger.logInfo("SleepPhaser: synchronousHint(" + timeout + ")");
        try {
            this.runner.runBlocking(timeout, new C22071(null));
        } catch (InterruptedException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long timestamp) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long ts) {
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
        off();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
        hint(1);
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start(int sensorDelay) {
        start();
    }
}
