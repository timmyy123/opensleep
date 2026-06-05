package com.urbandroid.sleep.hr.polar;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Minutes;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import com.urbandroid.sleep.hr.AccelBatch;
import com.urbandroid.sleep.hr.Capabilities;
import com.urbandroid.sleep.hr.ReceiverClient;
import com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient;
import com.urbandroid.sleep.hr.polar.BreathDataBuffer;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.sensor.extra.RRIntervalsDataProducer;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetectorFactoryKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001aB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J!\u0010\u001d\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001bH\u0016¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\fJ\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\rJ\u0019\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\rJ\u0017\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\fJ\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\fJ\u000f\u00103\u001a\u00020\u0001H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u0010\rJ\u0017\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b=\u0010<J\u0017\u0010>\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b>\u0010<J\u0017\u0010?\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b?\u0010<R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@R\u001a\u0010A\u001a\u0002058\u0016X\u0096D¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u00107R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082D¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010LR\u0016\u0010S\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0016\u0010T\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006b"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/BleSmartWatch;", "Lcom/urbandroid/sleep/sensor/IAccelManager;", "Lcom/urbandroid/sleep/smartwatch/SmartWatch;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "", "sensorDelay", "", "start", "(I)V", "()V", "stop", "", "forceFlush", "", "resetChanges", "(Z)[F", "getMaxBatchSize", "()I", "getMaxDelayedPoints", "resetZerosCount", "getCountOfZeroValuesInRow", "Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;", "callback", "", "timeoutMillis", "asyncConnectionCheck", "(Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;J)V", "timestamp", "updateAlarm", "(J)V", "ts", "updatePause", "delay", "startAlarm", "stopAlarm", "Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;", "listener", "startTracking", "(Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;)V", "stopTracking", "batchSize", "setBatchSize", "suspended", "setSuspended", "(Z)V", "repeat", ViewHierarchyConstants.HINT_KEY, "getAccelManager", "()Lcom/urbandroid/sleep/sensor/IAccelManager;", "", "getPlatform", "()Ljava/lang/String;", "scheduleInstanceAliveCheck", "Lcom/urbandroid/sleep/hr/AccelBatch;", "data", "update", "(Lcom/urbandroid/sleep/hr/AccelBatch;)V", "updateAggregatedActivity", "detectRespiratoryRate", "persistActivityDetails", "Landroid/content/Context;", "tag", "Ljava/lang/String;", "getTag", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "", "NO_VALUE", "F", "tracking", "Z", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "bleClient", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "maxAcc", "gotHrData", "lastCalledResetChanges", "J", "Lcom/urbandroid/util/StringBufferPersister;", "rawActigraphyPersister", "Lcom/urbandroid/util/StringBufferPersister;", "breathDetectorSampleRate", "I", "Lcom/urbandroid/sleep/hr/polar/BreathDataBuffer;", "breathDataBuffer", "Lcom/urbandroid/sleep/hr/polar/BreathDataBuffer;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "breathDetector", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BleSmartWatch implements IAccelManager, SmartWatch, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BleSmartWatch instance;
    private final float NO_VALUE;
    private ReceiverClient bleClient;
    private final BreathDataBuffer breathDataBuffer;
    private RespiratoryDetector breathDetector;
    private final int breathDetectorSampleRate;
    private final Context context;
    private boolean gotHrData;
    private long lastCalledResetChanges;
    private float maxAcc;
    private StringBufferPersister rawActigraphyPersister;
    private final CoroutineScope scope;
    private final CompletableJob supervisorJob;
    private final String tag;
    private boolean tracking;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/BleSmartWatch$Companion;", "", "<init>", "()V", "instance", "Lcom/urbandroid/sleep/hr/polar/BleSmartWatch;", "getInstance", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized BleSmartWatch getInstance(Context context) {
            BleSmartWatch bleSmartWatch;
            try {
                context.getClass();
                if (BleSmartWatch.instance == null) {
                    Context applicationContext = context.getApplicationContext();
                    applicationContext.getClass();
                    BleSmartWatch.instance = new BleSmartWatch(applicationContext, null);
                }
                bleSmartWatch = BleSmartWatch.instance;
                bleSmartWatch.getClass();
            } catch (Throwable th) {
                throw th;
            }
            return bleSmartWatch;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.BleSmartWatch$asyncConnectionCheck$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.BleSmartWatch$asyncConnectionCheck$1", f = "BleSmartWatch.kt", l = {238}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IConnectivityCallback $callback;
        final /* synthetic */ long $timeoutMillis;
        long J$0;
        int label;
        final /* synthetic */ BleSmartWatch this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, BleSmartWatch bleSmartWatch, IConnectivityCallback iConnectivityCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$timeoutMillis = j;
            this.this$0 = bleSmartWatch;
            this.$callback = iConnectivityCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$timeoutMillis, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long jCurrentTimeMillis;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                jCurrentTimeMillis = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            do {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                long j = this.$timeoutMillis;
                BleSmartWatch bleSmartWatch = this.this$0;
                if (jCurrentTimeMillis2 >= j) {
                    Logger.logInfo(Logger.defaultTag, bleSmartWatch.getTag() + ": asyncConnectionCheck: timed out", null);
                    this.this$0.stop();
                    this.$callback.status(this.this$0, false);
                    return Unit.INSTANCE;
                }
                IConnectivityCallback iConnectivityCallback = this.$callback;
                synchronized (bleSmartWatch) {
                    if (!bleSmartWatch.tracking) {
                        Logger.logInfo(Logger.defaultTag, bleSmartWatch.getTag() + ": asyncConnectionCheck: !tracking", null);
                        iConnectivityCallback.status(bleSmartWatch, false);
                        return Unit.INSTANCE;
                    }
                    if (!bleSmartWatch.gotHrData && bleSmartWatch.maxAcc <= 0.0f) {
                        if (iConnectivityCallback.isCancelled()) {
                            Logger.logInfo(Logger.defaultTag, bleSmartWatch.getTag() + ": asyncConnectionCheck: isCancelled", null);
                            bleSmartWatch.stop();
                            iConnectivityCallback.status(bleSmartWatch, false);
                            return Unit.INSTANCE;
                        }
                        Unit unit = Unit.INSTANCE;
                        this.J$0 = jCurrentTimeMillis;
                        this.label = 1;
                    }
                    Logger.logInfo(Logger.defaultTag, bleSmartWatch.getTag() + ": asyncConnectionCheck: maxAcc > 0", null);
                    iConnectivityCallback.status(bleSmartWatch, true);
                    return Unit.INSTANCE;
                }
            } while (DelayKt.delay(1000L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.BleSmartWatch$scheduleInstanceAliveCheck$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.BleSmartWatch$scheduleInstanceAliveCheck$2", f = "BleSmartWatch.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BleSmartWatch.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            BleSmartWatch bleSmartWatch = BleSmartWatch.this;
            synchronized (bleSmartWatch) {
                if (bleSmartWatch.bleClient != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - bleSmartWatch.lastCalledResetChanges;
                    if (jCurrentTimeMillis > Minutes.m984getMillisimpl(Minutes.m982constructorimpl(15L))) {
                        String str = Logger.defaultTag;
                        Logger.logWarning(str, bleSmartWatch.getTag() + ": " + ("This instance does not seem to be used by the app. resetChanges() has not been called for " + jCurrentTimeMillis + " millis. Stopping the instance."), null);
                        bleSmartWatch.stop();
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    private BleSmartWatch(Context context) {
        this.context = context;
        this.tag = "BleSmartWatch";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(completableJobSupervisorJob$default));
        this.NO_VALUE = -1.0f;
        this.maxAcc = -1.0f;
        this.lastCalledResetChanges = System.currentTimeMillis();
        this.breathDetectorSampleRate = 5;
        this.breathDataBuffer = new BreathDataBuffer(5, 5 * 60, 60000L);
        if (Experiments.getInstance().isRawActigraphyPersistentExperiment()) {
            this.rawActigraphyPersister = new StringBufferPersister("Activity_raw", 10000, true);
        }
    }

    private final void detectRespiratoryRate(AccelBatch data2) {
        boolean z;
        RespiratoryDetector respiratoryDetector = this.breathDetector;
        if (respiratoryDetector != null) {
            do {
                BreathDataBuffer.Result resultAggregate = this.breathDataBuffer.aggregate(data2);
                boolean zComponent1 = resultAggregate.getDataOutage();
                float[] fArrComponent2 = resultAggregate.getData();
                z = false;
                if (zComponent1) {
                    respiratoryDetector.dataBroken();
                } else {
                    if (!(fArrComponent2.length == 0)) {
                        respiratoryDetector.detect(fArrComponent2, 1);
                    }
                }
                if (zComponent1) {
                    return;
                }
                if (fArrComponent2.length == 0) {
                    z = true;
                }
            } while (!z);
        }
    }

    private final void persistActivityDetails(AccelBatch data2) {
        StringBufferPersister stringBufferPersister = this.rawActigraphyPersister;
        if (stringBufferPersister != null) {
            for (AccelBatch.Point point : data2.getPoints()) {
                stringBufferPersister.update(point.getX() + "," + point.getY() + "," + point.getZ() + "\n");
            }
        }
    }

    private final void scheduleInstanceAliveCheck() {
        BLEUtilKt.runWithFixedDelay(this.scope, 0L, 60000L, new HttpClientConfig$$ExternalSyntheticLambda4(7), new AnonymousClass2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean scheduleInstanceAliveCheck$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$0$0(BleSmartWatch bleSmartWatch, AccelBatch accelBatch, long j) {
        accelBatch.getClass();
        bleSmartWatch.update(accelBatch);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$0$1(BleSmartWatch bleSmartWatch, float f, long j) {
        HrDataProducer.INSTANCE.produce(bleSmartWatch.context, f, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$1$0(BleSmartWatch bleSmartWatch, float f, long j) {
        HrDataProducer.INSTANCE.produce(bleSmartWatch.context, f, j);
        bleSmartWatch.gotHrData = true;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$1$1(BleSmartWatch bleSmartWatch, float f, long j) {
        RRIntervalsDataProducer.INSTANCE.produce(bleSmartWatch.context, f, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$1$2(BleSmartWatch bleSmartWatch, AccelBatch accelBatch, long j) {
        accelBatch.getClass();
        bleSmartWatch.update(accelBatch);
        bleSmartWatch.gotHrData = true;
        return Unit.INSTANCE;
    }

    private final synchronized void update(AccelBatch data2) {
        updateAggregatedActivity(data2);
        detectRespiratoryRate(data2);
        persistActivityDetails(data2);
    }

    private final void updateAggregatedActivity(AccelBatch data2) {
        List<AccelBatch.Point> points = data2.getPoints();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(points, 10));
        for (AccelBatch.Point point : points) {
            arrayList.add(Float.valueOf((float) Math.sqrt((point.getZ() * point.getZ()) + (point.getY() * point.getY()) + (point.getX() * point.getX()))));
        }
        Float fM2457maxOrNull = CollectionsKt___CollectionsKt.m2457maxOrNull((Iterable<Float>) arrayList);
        if (fM2457maxOrNull != null) {
            this.maxAcc = Math.max(this.maxAcc, fM2457maxOrNull.floatValue());
        }
    }

    public void asyncConnectionCheck(IConnectivityCallback callback, long timeoutMillis) {
        String str = "asyncConnectionCheck: callback==null: " + (callback == null) + ", timeout: " + timeoutMillis;
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        if (callback == null) {
            return;
        }
        start();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt__JobKt.Job$default(null, 1, null))), null, null, new AnonymousClass1(timeoutMillis, this, callback, null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        return this;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getCountOfZeroValuesInRow() {
        return 0;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return 1;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 0;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        ReceiverClient receiverClient = this.bleClient;
        return ((receiverClient instanceof PolarBLEClient) || (receiverClient instanceof PineTimeBLEClient)) ? "Polar H10/OH1" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int repeat) {
        ReceiverClient receiverClient = this.bleClient;
        if (receiverClient instanceof PineTimeBLEClient) {
            receiverClient.getClass();
            ((PineTimeBLEClient) receiverClient).alert(repeat);
        }
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public synchronized float[] resetChanges(boolean forceFlush) {
        float f;
        float f2;
        try {
            this.lastCalledResetChanges = System.currentTimeMillis();
            f = this.maxAcc;
            f2 = this.NO_VALUE;
            this.maxAcc = f2;
        } catch (Throwable th) {
            throw th;
        }
        return f == f2 ? new float[0] : new float[]{f};
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

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public synchronized void start() {
        try {
            try {
                Logger.logInfo(Logger.defaultTag, getTag() + ": start", null);
                if (!this.tracking) {
                    final int i = 1;
                    this.tracking = true;
                    final int i2 = 0;
                    this.gotHrData = false;
                    String bleTrackingDeviceAddress = new Settings(this.context).getBleTrackingDeviceAddress();
                    String bleTrackingDeviceName = new Settings(this.context).getBleTrackingDeviceName();
                    String str = Logger.defaultTag;
                    Logger.logInfo(str, getTag() + ": " + ("device prefs: '" + bleTrackingDeviceAddress + "' '" + bleTrackingDeviceName + "'"), null);
                    Context context = this.context;
                    bleTrackingDeviceAddress.getClass();
                    BluetoothDevice bluetoothDevice = BLEUtilKt.getBluetoothDevice(context, bleTrackingDeviceAddress);
                    String str2 = "device BT: '" + bleTrackingDeviceAddress + "' '" + bleTrackingDeviceName + "'";
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                    if (bleTrackingDeviceName == null || !"InfiniTime".equals(bleTrackingDeviceName)) {
                        Logger.logInfo(Logger.defaultTag, getTag() + ": connect Polar", null);
                        PolarBLEClient polarBLEClient = new PolarBLEClient(this.context, bluetoothDevice, 5);
                        bleTrackingDeviceName.getClass();
                        if (StringsKt.contains$default(bleTrackingDeviceName, "Polar H10")) {
                            this.breathDetector = RespiratoryDetectorFactoryKt.createRespiratoryDetector(this.breathDetectorSampleRate);
                        }
                        Capabilities.Companion companion = Capabilities.INSTANCE;
                        final int i3 = 2;
                        polarBLEClient.subscribe(companion.getHR(), new Function2(this) { // from class: com.urbandroid.sleep.hr.polar.BleSmartWatch$$ExternalSyntheticLambda0
                            public final /* synthetic */ BleSmartWatch f$0;

                            {
                                this.f$0 = this;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i4 = i3;
                                BleSmartWatch bleSmartWatch = this.f$0;
                                switch (i4) {
                                    case 0:
                                        return BleSmartWatch.start$lambda$0$0(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                    case 1:
                                        return BleSmartWatch.start$lambda$0$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 2:
                                        return BleSmartWatch.start$lambda$1$0(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 3:
                                        return BleSmartWatch.start$lambda$1$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    default:
                                        return BleSmartWatch.start$lambda$1$2(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                }
                            }
                        });
                        final int i4 = 3;
                        polarBLEClient.subscribe(companion.getRR(), new Function2(this) { // from class: com.urbandroid.sleep.hr.polar.BleSmartWatch$$ExternalSyntheticLambda0
                            public final /* synthetic */ BleSmartWatch f$0;

                            {
                                this.f$0 = this;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i42 = i4;
                                BleSmartWatch bleSmartWatch = this.f$0;
                                switch (i42) {
                                    case 0:
                                        return BleSmartWatch.start$lambda$0$0(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                    case 1:
                                        return BleSmartWatch.start$lambda$0$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 2:
                                        return BleSmartWatch.start$lambda$1$0(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 3:
                                        return BleSmartWatch.start$lambda$1$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    default:
                                        return BleSmartWatch.start$lambda$1$2(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                }
                            }
                        });
                        final int i5 = 4;
                        polarBLEClient.subscribe(companion.getACCEL(), new Function2(this) { // from class: com.urbandroid.sleep.hr.polar.BleSmartWatch$$ExternalSyntheticLambda0
                            public final /* synthetic */ BleSmartWatch f$0;

                            {
                                this.f$0 = this;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i42 = i5;
                                BleSmartWatch bleSmartWatch = this.f$0;
                                switch (i42) {
                                    case 0:
                                        return BleSmartWatch.start$lambda$0$0(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                    case 1:
                                        return BleSmartWatch.start$lambda$0$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 2:
                                        return BleSmartWatch.start$lambda$1$0(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 3:
                                        return BleSmartWatch.start$lambda$1$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    default:
                                        return BleSmartWatch.start$lambda$1$2(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                }
                            }
                        });
                        this.bleClient = polarBLEClient;
                    } else {
                        Logger.logInfo(Logger.defaultTag, getTag() + ": connect PineTime", null);
                        PineTimeBLEClient pineTimeBLEClient = new PineTimeBLEClient(this.context, bluetoothDevice, 5);
                        Capabilities.Companion companion2 = Capabilities.INSTANCE;
                        pineTimeBLEClient.subscribe(companion2.getACCEL(), new Function2(this) { // from class: com.urbandroid.sleep.hr.polar.BleSmartWatch$$ExternalSyntheticLambda0
                            public final /* synthetic */ BleSmartWatch f$0;

                            {
                                this.f$0 = this;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i42 = i2;
                                BleSmartWatch bleSmartWatch = this.f$0;
                                switch (i42) {
                                    case 0:
                                        return BleSmartWatch.start$lambda$0$0(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                    case 1:
                                        return BleSmartWatch.start$lambda$0$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 2:
                                        return BleSmartWatch.start$lambda$1$0(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 3:
                                        return BleSmartWatch.start$lambda$1$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    default:
                                        return BleSmartWatch.start$lambda$1$2(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                }
                            }
                        });
                        pineTimeBLEClient.subscribe(companion2.getHR(), new Function2(this) { // from class: com.urbandroid.sleep.hr.polar.BleSmartWatch$$ExternalSyntheticLambda0
                            public final /* synthetic */ BleSmartWatch f$0;

                            {
                                this.f$0 = this;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i42 = i;
                                BleSmartWatch bleSmartWatch = this.f$0;
                                switch (i42) {
                                    case 0:
                                        return BleSmartWatch.start$lambda$0$0(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                    case 1:
                                        return BleSmartWatch.start$lambda$0$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 2:
                                        return BleSmartWatch.start$lambda$1$0(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    case 3:
                                        return BleSmartWatch.start$lambda$1$1(bleSmartWatch, ((Float) obj).floatValue(), ((Long) obj2).longValue());
                                    default:
                                        return BleSmartWatch.start$lambda$1$2(bleSmartWatch, (AccelBatch) obj, ((Long) obj2).longValue());
                                }
                            }
                        });
                        this.bleClient = pineTimeBLEClient;
                    }
                    this.lastCalledResetChanges = System.currentTimeMillis();
                    scheduleInstanceAliveCheck();
                }
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, getTag() + ": start failed", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int delay) {
        ReceiverClient receiverClient = this.bleClient;
        if (receiverClient instanceof PineTimeBLEClient) {
            receiverClient.getClass();
            ((PineTimeBLEClient) receiverClient).alertGentle(120);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener listener) {
        start();
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public synchronized void stop() {
        try {
            Logger.logInfo(Logger.defaultTag, getTag() + ": stop", null);
            if (this.tracking) {
                this.tracking = false;
                ReceiverClient receiverClient = this.bleClient;
                if (receiverClient != null) {
                    receiverClient.stop();
                }
                this.bleClient = null;
                this.maxAcc = this.NO_VALUE;
                JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
                StringBufferPersister stringBufferPersister = this.rawActigraphyPersister;
                if (stringBufferPersister != null) {
                    stringBufferPersister.flush();
                }
                RespiratoryDetector respiratoryDetector = this.breathDetector;
                if (respiratoryDetector != null) {
                    respiratoryDetector.trackingFinished();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        ReceiverClient receiverClient = this.bleClient;
        if (receiverClient instanceof PineTimeBLEClient) {
            receiverClient.getClass();
            ((PineTimeBLEClient) receiverClient).stopAlert();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        stop();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long timestamp) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long ts) {
    }

    public /* synthetic */ BleSmartWatch(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start(int sensorDelay) {
        start();
    }
}
