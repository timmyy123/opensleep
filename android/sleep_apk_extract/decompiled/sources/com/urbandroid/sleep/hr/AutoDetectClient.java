package com.urbandroid.sleep.hr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u00011\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0080\u0001\u0010,\u001an\u00122\u00120\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\r\u0012 \u0012\u001e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020*`\u00110)0(j6\u00122\u00120\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\r\u0012 \u0012\u001e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020*`\u00110)`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/hr/AutoDetectClient;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "deviceAddress", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "stop", "()V", "Landroid/content/Context;", "Ljava/lang/String;", "tag", "getTag", "()Ljava/lang/String;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Ljava/util/concurrent/atomic/AtomicReference;", "client", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "pendingSubscriptions", "Ljava/util/ArrayList;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "com/urbandroid/sleep/hr/AutoDetectClient$retryConnectDelaysMillis$1", "retryConnectDelaysMillis", "Lcom/urbandroid/sleep/hr/AutoDetectClient$retryConnectDelaysMillis$1;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoDetectClient implements ReceiverClient, FeatureLogger {
    private AtomicReference<ReceiverClient> client;
    private final Context context;
    private final String deviceAddress;
    private final Mutex mutex;
    private final ArrayList<Pair<Capability<Object>, Function2<Object, Long, Unit>>> pendingSubscriptions;
    private final AutoDetectClient$retryConnectDelaysMillis$1 retryConnectDelaysMillis;
    private final CoroutineScope scope;
    private final AtomicBoolean stopped;
    private final CompletableJob supervisorJob;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.AutoDetectClient$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.AutoDetectClient$2", f = "AutoDetectClient.kt", l = {71}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AutoDetectClient.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutoDetectClient autoDetectClient = AutoDetectClient.this;
                this.label = 1;
                if (autoDetectClient.connect(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.AutoDetectClient$connect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.AutoDetectClient", f = "AutoDetectClient.kt", l = {134, 87}, m = "connect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoDetectClient.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.AutoDetectClient$subscribe$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.AutoDetectClient$subscribe$1", f = "AutoDetectClient.kt", l = {134}, m = "invokeSuspend", v = 2)
    public static final class C21051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Capability<T> $capability;
        final /* synthetic */ Function2<T, Long, Unit> $subscriber;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C21051(Capability<T> capability, Function2<? super T, ? super Long, Unit> function2, Continuation<? super C21051> continuation) {
            super(2, continuation);
            this.$capability = capability;
            this.$subscriber = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoDetectClient.this.new C21051(this.$capability, this.$subscriber, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            AutoDetectClient autoDetectClient;
            Capability capability;
            Function2 function2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = AutoDetectClient.this.mutex;
                AutoDetectClient autoDetectClient2 = AutoDetectClient.this;
                Capability capability2 = this.$capability;
                Function2 function22 = this.$subscriber;
                this.L$0 = mutex2;
                this.L$1 = autoDetectClient2;
                this.L$2 = capability2;
                this.L$3 = function22;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                autoDetectClient = autoDetectClient2;
                capability = capability2;
                function2 = function22;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                function2 = (Function2) this.L$3;
                capability = (Capability) this.L$2;
                autoDetectClient = (AutoDetectClient) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                ReceiverClient receiverClient = (ReceiverClient) autoDetectClient.client.get();
                if (receiverClient == null) {
                    ArrayList arrayList = autoDetectClient.pendingSubscriptions;
                    capability.getClass();
                    function2.getClass();
                    Boxing.boxBoolean(arrayList.add(new Pair(capability, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2))));
                } else {
                    receiverClient.subscribe(capability, function2);
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public AutoDetectClient(Context context, String str) {
        context.getClass();
        str.getClass();
        this.context = context;
        this.deviceAddress = str;
        this.tag = "AutoDetectClient";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(completableJobSupervisorJob$default));
        this.scope = CoroutineScope;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.client = new AtomicReference<>(null);
        this.pendingSubscriptions = new ArrayList<>();
        this.stopped = new AtomicBoolean(false);
        AutoDetectClient$retryConnectDelaysMillis$1 autoDetectClient$retryConnectDelaysMillis$1 = new AutoDetectClient$retryConnectDelaysMillis$1();
        this.retryConnectDelaysMillis = autoDetectClient$retryConnectDelaysMillis$1;
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 60), 0, 4, null));
        BLEUtilKt.runWithDynamicDelay(CoroutineScope, autoDetectClient$retryConnectDelaysMillis$1, new Url$$ExternalSyntheticLambda0(this, 13), new AnonymousClass2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(AutoDetectClient autoDetectClient) {
        return autoDetectClient.client.get() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:4|(1:6)(1:7))(0)|8|53|(1:(1:(8:12|52|13|37|(4:39|(2:42|40)|57|43)(1:44)|47|48|49)(2:19|20))(1:21))(3:22|(1:25)|35)|55|26|(1:28)|33|(6:36|37|(0)(0)|47|48|49)|35|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d2, code lost:
    
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d6, code lost:
    
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b6, code lost:
    
        r5.unlock(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01b9, code lost:
    
        throw r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010c A[Catch: all -> 0x0049, Exception -> 0x004c, TryCatch #1 {Exception -> 0x004c, blocks: (B:13:0x0044, B:37:0x0104, B:39:0x010c, B:40:0x014b, B:42:0x0151, B:43:0x0172, B:44:0x0178), top: B:52:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0178 A[Catch: all -> 0x0049, Exception -> 0x004c, TRY_LEAVE, TryCatch #1 {Exception -> 0x004c, blocks: (B:13:0x0044, B:37:0x0104, B:39:0x010c, B:40:0x014b, B:42:0x0151, B:43:0x0172, B:44:0x0178), top: B:52:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v16, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        int i;
        BluetoothDevice bluetoothDevice;
        Mutex mutex2;
        DeviceDetectionResult deviceDetectionResult;
        ?? r5 = "connect: ";
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex3 = this.mutex;
                anonymousClass1.L$0 = mutex3;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (mutex3.lock(null, anonymousClass1) != coroutine_suspended) {
                    mutex = mutex3;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bluetoothDevice = (BluetoothDevice) anonymousClass1.L$1;
                Mutex mutex4 = (Mutex) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2 = mutex4;
                    deviceDetectionResult = (DeviceDetectionResult) obj;
                    if (deviceDetectionResult.getRecognized()) {
                        Logger.logInfo(Logger.defaultTag, getTag() + ": connect: device unrecognized", null);
                        r5 = mutex2;
                    } else {
                        String str = Logger.defaultTag;
                        Logger.logInfo(str, getTag() + ": " + ("connect: device recognized, connecting: " + bluetoothDevice), null);
                        this.client.set(deviceDetectionResult.getCreateClient().invoke(this.context));
                        Iterator<Pair<Capability<Object>, Function2<Object, Long, Unit>>> it = this.pendingSubscriptions.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Pair<Capability<Object>, Function2<Object, Long, Unit>> next = it.next();
                            next.getClass();
                            Pair<Capability<Object>, Function2<Object, Long, Unit>> pair = next;
                            this.client.get().subscribe(pair.getFirst(), pair.getSecond());
                        }
                        this.pendingSubscriptions.clear();
                        r5 = mutex2;
                    }
                } catch (Exception e) {
                    e = e;
                    Logger.logWarning(Logger.defaultTag, getTag() + ": connect: failed", e);
                    r5 = mutex4;
                }
                Unit unit = Unit.INSTANCE;
                r5.unlock(null);
                return Unit.INSTANCE;
            }
            i = anonymousClass1.I$0;
            mutex = (Mutex) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            String str2 = "connect: " + this.deviceAddress;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
            BluetoothDevice bluetoothDevice2 = BLEUtilKt.getBluetoothDevice(this.context, this.deviceAddress);
            Logger.logInfo(Logger.defaultTag, getTag() + ": connect: detecting device", null);
            Intent intent = new Intent("com.urbandroid.sleep.ACTION_BT_UI_DEVICE");
            String name = bluetoothDevice2.getName();
            if (name == null) {
                name = bluetoothDevice2.getAddress();
            }
            intent.putExtra(DeviceRequestsHelper.DEVICE_INFO_DEVICE, name);
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
            DetectDevice detectDevice = DetectDevice.INSTANCE;
            Context context = this.context;
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = bluetoothDevice2;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(intent);
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            Object objDetectHrDevice = detectDevice.detectHrDevice(context, bluetoothDevice2, anonymousClass1);
            if (objDetectHrDevice != coroutine_suspended) {
                bluetoothDevice = bluetoothDevice2;
                obj = objDetectHrDevice;
                mutex2 = mutex;
                deviceDetectionResult = (DeviceDetectionResult) obj;
                if (deviceDetectionResult.getRecognized()) {
                }
                Unit unit2 = Unit.INSTANCE;
                r5.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            th = th;
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.hr.ReceiverClient
    public void stop() {
        this.stopped.set(true);
        ReceiverClient receiverClient = this.client.get();
        if (receiverClient != null) {
            receiverClient.stop();
        }
        JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
    }

    @Override // com.urbandroid.sleep.hr.ReceiverClient
    public <T> void subscribe(Capability<T> capability, Function2<? super T, ? super Long, Unit> subscriber) {
        capability.getClass();
        subscriber.getClass();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21051(capability, subscriber, null), 3, null);
    }
}
