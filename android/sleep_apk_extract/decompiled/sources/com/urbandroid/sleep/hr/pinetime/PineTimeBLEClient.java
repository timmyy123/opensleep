package com.urbandroid.sleep.hr.pinetime;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.platform.traits.ValidationIssue;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEClient;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import com.urbandroid.sleep.bluetoothle.TimeoutGuard;
import com.urbandroid.sleep.hr.AccelBatch;
import com.urbandroid.sleep.hr.AccelCapability;
import com.urbandroid.sleep.hr.Capabilities;
import com.urbandroid.sleep.hr.Capability;
import com.urbandroid.sleep.hr.HRCapability;
import com.urbandroid.sleep.hr.ReceiverClient;
import com.urbandroid.sleep.hr.generic.BLEHRConstants;
import com.urbandroid.sleep.hr.generic.BLEHRParser;
import com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient;
import com.urbandroid.sleep.hr.pinetime.PineTimeConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011JG\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b&\u0010\u0011J\u0010\u0010'\u001a\u00020\fH\u0082@¢\u0006\u0004\b'\u0010\"J\u0010\u0010(\u001a\u00020\fH\u0082@¢\u0006\u0004\b(\u0010\"J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b+\u0010*J\u0018\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020,H\u0082@¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b0\u00101R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00102R\u001a\u00103\u001a\u00020,8\u0016X\u0096D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00101R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010:R\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010KR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010ORH\u0010T\u001a6\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0\u0014\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\f0\u0016j\b\u0012\u0004\u0012\u00020R`\u00180S0Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR(\u0010Z\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020R0\u00140Y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R$\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010j¨\u0006k"}, d2 = {"Lcom/urbandroid/sleep/hr/pinetime/PineTimeBLEClient;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "", "initialConnectionAttemptsCount", "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;I)V", "repeat", "", "alert", "(I)V", "alertGentle", "stopAlert", "()V", "stop", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "Lcom/urbandroid/sleep/hr/AccelBatch;", "parseAccelData", "(Landroid/bluetooth/BluetoothGattCharacteristic;)Lcom/urbandroid/sleep/hr/AccelBatch;", "getAlertCharacteristics", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SDKConstants.PARAM_VALUE, "writeAlertCharacteristics", "(Landroid/bluetooth/BluetoothGattCharacteristic;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "connect", "bleShutdownAndDisconnect", "handleHrData", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "handleAccData", "", "info", "handleNotificationsTimeout", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstanceId", "()Ljava/lang/String;", "I", "tag", "Ljava/lang/String;", "getTag", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "timeout", "J", "reconnectDelay", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "bleClient", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "missingDataTimeout", "Ljava/util/concurrent/atomic/AtomicLong;", "lastFullReconnectAttempt", "Ljava/util/concurrent/atomic/AtomicLong;", "lastPpiRestartAttempt", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "hrTimeoutGuard", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "accTimeoutGuard", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "subscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "capabilities", "Ljava/util/Set;", "getCapabilities", "()Ljava/util/Set;", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "hrParser", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "Lkotlinx/coroutines/Job;", "alertJob", "Lkotlinx/coroutines/Job;", "getAlertJob", "()Lkotlinx/coroutines/Job;", "setAlertJob", "(Lkotlinx/coroutines/Job;)V", "", "isStopped", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PineTimeBLEClient implements ReceiverClient, FeatureLogger {
    private final TimeoutGuard accTimeoutGuard;
    private Job alertJob;
    private final BLEClient bleClient;
    private final Set<Capability<? extends Object>> capabilities;
    private Handler h;
    private final BLEHRParser hrParser;
    private final TimeoutGuard hrTimeoutGuard;
    private final int initialConnectionAttemptsCount;
    private final AtomicLong lastFullReconnectAttempt;
    private final AtomicLong lastPpiRestartAttempt;
    private final long missingDataTimeout;
    private final Mutex mutex;
    private final long reconnectDelay;
    private final CoroutineScope scope;
    private final AtomicBoolean stopped;
    private final ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> subscribers;
    private final CompletableJob supervisorJob;
    private final String tag;
    private final long timeout;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$alert$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$alert$1", f = "PineTimeBLEClient.kt", l = {96, 100, 101}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeat;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$repeat = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PineTimeBLEClient.this.new AnonymousClass1(this.$repeat, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[Catch: Exception -> 0x0026, TryCatch #0 {Exception -> 0x0026, blocks: (B:8:0x0020, B:24:0x0074, B:28:0x0094, B:15:0x0040, B:16:0x0049, B:22:0x005b, B:19:0x0050), top: B:36:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ab  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ab -> B:9:0x0023). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            int i;
            PineTimeBLEClient pineTimeBLEClient;
            int i2;
            int i3;
            PineTimeBLEClient pineTimeBLEClient2;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2;
            int i4;
            int i5;
            int i6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            try {
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, PineTimeBLEClient.this.getTag(), e);
            }
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                PineTimeBLEClient pineTimeBLEClient3 = PineTimeBLEClient.this;
                this.label = 1;
                obj = pineTimeBLEClient3.getAlertCharacteristics(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i7 != 1) {
                    if (i7 == 2) {
                        int i8 = this.I$3;
                        int i9 = this.I$2;
                        int i10 = this.I$1;
                        int i11 = this.I$0;
                        pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic3 = (BluetoothGattCharacteristic) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i3 = i8;
                        i6 = i10;
                        i4 = i9;
                        i5 = i11;
                        bluetoothGattCharacteristic2 = bluetoothGattCharacteristic3;
                        this.L$0 = bluetoothGattCharacteristic2;
                        this.L$1 = pineTimeBLEClient2;
                        this.I$0 = i5;
                        this.I$1 = i6;
                        this.I$2 = i4;
                        this.I$3 = i3;
                        this.label = 3;
                        if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i7 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i6 = this.I$1;
                    i5 = this.I$0;
                    pineTimeBLEClient = (PineTimeBLEClient) this.L$1;
                    bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                    int i12 = i5;
                    i2 = i6 + 1;
                    i = i12;
                    if (i2 < i) {
                        Matchers.startsWith("Alert delay 1000");
                        this.L$0 = bluetoothGattCharacteristic;
                        this.L$1 = pineTimeBLEClient;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.I$2 = i2;
                        this.I$3 = 0;
                        this.label = 2;
                        if (pineTimeBLEClient.writeAlertCharacteristics(bluetoothGattCharacteristic, 1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bluetoothGattCharacteristic2 = bluetoothGattCharacteristic;
                        i3 = 0;
                        pineTimeBLEClient2 = pineTimeBLEClient;
                        i4 = i2;
                        i5 = i;
                        i6 = i4;
                        this.L$0 = bluetoothGattCharacteristic2;
                        this.L$1 = pineTimeBLEClient2;
                        this.I$0 = i5;
                        this.I$1 = i6;
                        this.I$2 = i4;
                        this.I$3 = i3;
                        this.label = 3;
                        if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                            pineTimeBLEClient = pineTimeBLEClient2;
                            bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                            int i122 = i5;
                            i2 = i6 + 1;
                            i = i122;
                            if (i2 < i) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            bluetoothGattCharacteristic = (BluetoothGattCharacteristic) obj;
            Matchers.startsWith("Alert characteritics " + bluetoothGattCharacteristic);
            i = this.$repeat;
            pineTimeBLEClient = PineTimeBLEClient.this;
            i2 = 0;
            if (i2 < i) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$alertGentle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$alertGentle$1", f = "PineTimeBLEClient.kt", l = {112, 116, 117}, m = "invokeSuspend", v = 2)
    public static final class C21121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeat;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21121(int i, Continuation<? super C21121> continuation) {
            super(2, continuation);
            this.$repeat = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PineTimeBLEClient.this.new C21121(this.$repeat, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:8:0x0022, B:24:0x0080, B:30:0x0090, B:34:0x00ab, B:15:0x0046, B:16:0x0051, B:22:0x0066, B:19:0x005a), top: B:42:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00cc -> B:38:0x00cf). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object alertCharacteristics;
            int i;
            PineTimeBLEClient pineTimeBLEClient;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            int i2;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2;
            PineTimeBLEClient pineTimeBLEClient2;
            int i3;
            int i4;
            int i5;
            int i6;
            long jCoerceAtLeast;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            try {
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, PineTimeBLEClient.this.getTag(), e);
            }
            if (i7 == 0) {
                ResultKt.throwOnFailure(obj);
                PineTimeBLEClient pineTimeBLEClient3 = PineTimeBLEClient.this;
                this.label = 1;
                alertCharacteristics = pineTimeBLEClient3.getAlertCharacteristics(this);
                if (alertCharacteristics == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i7 != 1) {
                    if (i7 == 2) {
                        int i8 = this.I$3;
                        int i9 = this.I$2;
                        int i10 = this.I$1;
                        i3 = this.I$0;
                        pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                        bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i5 = i8;
                        i6 = i10;
                        i4 = i9;
                        jCoerceAtLeast = RangesKt.coerceAtLeast(30000 / ((long) (i4 + 1)), 1000L);
                        this.L$0 = bluetoothGattCharacteristic2;
                        this.L$1 = pineTimeBLEClient2;
                        this.I$0 = i3;
                        this.I$1 = i6;
                        this.I$2 = i4;
                        this.I$3 = i5;
                        this.label = 3;
                        if (DelayKt.delay(jCoerceAtLeast, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i7 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i6 = this.I$1;
                    int i11 = this.I$0;
                    PineTimeBLEClient pineTimeBLEClient4 = (PineTimeBLEClient) this.L$1;
                    BluetoothGattCharacteristic bluetoothGattCharacteristic3 = (BluetoothGattCharacteristic) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pineTimeBLEClient = pineTimeBLEClient4;
                    bluetoothGattCharacteristic = bluetoothGattCharacteristic3;
                    int i12 = i11;
                    i2 = i6 + 1;
                    i = i12;
                    if (i2 < i) {
                        Matchers.startsWith("Alert delay 1000");
                        int i13 = i2 <= 20 ? i2 > 2 ? 1 : 0 : 2;
                        this.L$0 = bluetoothGattCharacteristic;
                        this.L$1 = pineTimeBLEClient;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.I$2 = i2;
                        this.I$3 = 0;
                        this.label = 2;
                        if (pineTimeBLEClient.writeAlertCharacteristics(bluetoothGattCharacteristic, i13, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        bluetoothGattCharacteristic2 = bluetoothGattCharacteristic;
                        pineTimeBLEClient2 = pineTimeBLEClient;
                        i3 = i;
                        i6 = i2;
                        i4 = i6;
                        i5 = 0;
                        jCoerceAtLeast = RangesKt.coerceAtLeast(30000 / ((long) (i4 + 1)), 1000L);
                        this.L$0 = bluetoothGattCharacteristic2;
                        this.L$1 = pineTimeBLEClient2;
                        this.I$0 = i3;
                        this.I$1 = i6;
                        this.I$2 = i4;
                        this.I$3 = i5;
                        this.label = 3;
                        if (DelayKt.delay(jCoerceAtLeast, this) != coroutine_suspended) {
                            i11 = i3;
                            pineTimeBLEClient = pineTimeBLEClient2;
                            bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                            int i122 = i11;
                            i2 = i6 + 1;
                            i = i122;
                            if (i2 < i) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                alertCharacteristics = obj;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic4 = (BluetoothGattCharacteristic) alertCharacteristics;
            Matchers.startsWith("Alert characteritics " + bluetoothGattCharacteristic4);
            i = this.$repeat;
            pineTimeBLEClient = PineTimeBLEClient.this;
            bluetoothGattCharacteristic = bluetoothGattCharacteristic4;
            i2 = 0;
            if (i2 < i) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$bleShutdownAndDisconnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient", f = "PineTimeBLEClient.kt", l = {ValidationIssue.INVALID_ENTITY_FIELD_NUMBER}, m = "bleShutdownAndDisconnect", v = 2)
    public static final class C21131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21131(Continuation<? super C21131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PineTimeBLEClient.this.bleShutdownAndDisconnect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$connect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient", f = "PineTimeBLEClient.kt", l = {171, 173, 175, 177, 178}, m = "connect", v = 2)
    public static final class C21141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C21141(Continuation<? super C21141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PineTimeBLEClient.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$getAlertCharacteristics$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient", f = "PineTimeBLEClient.kt", l = {302, 82}, m = "getAlertCharacteristics", v = 2)
    public static final class C21151 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21151(Continuation<? super C21151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PineTimeBLEClient.this.getAlertCharacteristics(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$handleNotificationsTimeout$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$handleNotificationsTimeout$2", f = "PineTimeBLEClient.kt", l = {302, 268, 270, 271}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $info;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$info = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PineTimeBLEClient.this.new AnonymousClass2(this.$info, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(1:(3:(5:(1:(6:8|61|9|54|55|56)(2:15|16))(5:17|67|18|19|45)|52|54|55|56)(8:24|63|25|26|59|42|(1:44)(1:45)|47)|57|58)(1:29))(3:30|(1:33)|47)|65|34|(3:38|(4:41|59|42|(0)(0))|47)|53|54|55|56) */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0137, code lost:
        
            if (r2.connect(r18) != r3) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x013a, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x013b, code lost:
        
            r3 = r4;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0129 A[Catch: all -> 0x013a, Exception -> 0x013d, PHI: r2 r4 r5 r9
          0x0129: PHI (r2v8 com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient) = (r2v6 com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient), (r2v15 com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r4v8 kotlinx.coroutines.sync.Mutex) = (r4v4 kotlinx.coroutines.sync.Mutex), (r4v16 kotlinx.coroutines.sync.Mutex) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r5v2 int) = (r5v1 int), (r5v7 int) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r9v5 int) = (r9v4 int), (r9v11 int) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x013d, blocks: (B:45:0x0129, B:42:0x0114), top: B:59:0x0114 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            PineTimeBLEClient pineTimeBLEClient;
            String str;
            int i;
            PineTimeBLEClient pineTimeBLEClient2;
            long j;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 0;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = PineTimeBLEClient.this.mutex;
                pineTimeBLEClient = PineTimeBLEClient.this;
                str = this.$info;
                this.L$0 = mutex;
                this.L$1 = pineTimeBLEClient;
                this.L$2 = str;
                this.I$0 = 0;
                this.label = 1;
                if (mutex.lock(null, this) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        int i4 = this.I$1;
                        int i5 = this.I$0;
                        PineTimeBLEClient pineTimeBLEClient3 = (PineTimeBLEClient) this.L$1;
                        Mutex mutex3 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = i4;
                            pineTimeBLEClient2 = pineTimeBLEClient3;
                            i = i5;
                            mutex = mutex3;
                            this.L$0 = mutex;
                            this.L$1 = pineTimeBLEClient2;
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.label = 4;
                        } catch (Exception e) {
                            e = e;
                            pineTimeBLEClient2 = pineTimeBLEClient3;
                            mutex2 = mutex3;
                            Logger.logWarning(Logger.defaultTag, pineTimeBLEClient2.getTag() + ": reconnect", e);
                        } catch (Throwable th) {
                            th = th;
                            mutex2 = mutex3;
                        }
                    } else {
                        if (i2 != 4) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception e2) {
                                e = e2;
                                Logger.logWarning(Logger.defaultTag, pineTimeBLEClient2.getTag() + ": reconnect", e);
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    Logger.logWarning(Logger.defaultTag, pineTimeBLEClient2.getTag() + ": reconnect", e);
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                i3 = this.I$1;
                int i6 = this.I$0;
                PineTimeBLEClient pineTimeBLEClient4 = (PineTimeBLEClient) this.L$1;
                Mutex mutex4 = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i6;
                    pineTimeBLEClient2 = pineTimeBLEClient4;
                    mutex = mutex4;
                    try {
                        j = pineTimeBLEClient2.reconnectDelay;
                        this.L$0 = mutex;
                        this.L$1 = pineTimeBLEClient2;
                        this.I$0 = i;
                        this.I$1 = i3;
                        this.label = 3;
                        if (DelayKt.delay(j, this) == coroutine_suspended) {
                            this.L$0 = mutex;
                            this.L$1 = pineTimeBLEClient2;
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.label = 4;
                        }
                        return coroutine_suspended;
                    } catch (Exception e3) {
                        e = e3;
                        mutex2 = mutex;
                        Logger.logWarning(Logger.defaultTag, pineTimeBLEClient2.getTag() + ": reconnect", e);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex4;
                }
                mutex2.unlock(null);
                throw th;
            }
            int i7 = this.I$0;
            String str2 = (String) this.L$2;
            pineTimeBLEClient = (PineTimeBLEClient) this.L$1;
            Mutex mutex5 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i7;
            mutex = mutex5;
            str = str2;
            if (!pineTimeBLEClient.isStopped() && System.currentTimeMillis() - pineTimeBLEClient.lastFullReconnectAttempt.get() >= pineTimeBLEClient.missingDataTimeout) {
                pineTimeBLEClient.lastFullReconnectAttempt.set(System.currentTimeMillis());
                String str3 = "Timeout - trying to reconnect. " + str + " " + pineTimeBLEClient.getInstanceId();
                Logger.logInfo(Logger.defaultTag, pineTimeBLEClient.getTag() + ": " + str3, null);
                this.L$0 = mutex;
                this.L$1 = pineTimeBLEClient;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (pineTimeBLEClient.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                    pineTimeBLEClient2 = pineTimeBLEClient;
                    j = pineTimeBLEClient2.reconnectDelay;
                    this.L$0 = mutex;
                    this.L$1 = pineTimeBLEClient2;
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.label = 3;
                    if (DelayKt.delay(j, this) == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Unit unit22 = Unit.INSTANCE;
            mutex2.unlock(null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$start$1", f = "PineTimeBLEClient.kt", l = {302, 145, 150, 151}, m = "invokeSuspend", v = 2)
    public static final class C21161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C21161(Continuation<? super C21161> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(PineTimeBLEClient pineTimeBLEClient, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            pineTimeBLEClient.handleHrData(bluetoothGattCharacteristic);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$1(PineTimeBLEClient pineTimeBLEClient, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            pineTimeBLEClient.handleAccData(bluetoothGattCharacteristic);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PineTimeBLEClient.this.new C21161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00da, code lost:
        
            if (r11.connect(r17) == r2) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0162, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r12, r17) != r2) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x016f, code lost:
        
            r10 = r3;
            r3 = r9;
            r9 = r0;
         */
        /* JADX WARN: Not initialized variable reg: 12, insn: 0x0057: MOVE (r11 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:88), block:B:19:0x0057 */
        /* JADX WARN: Removed duplicated region for block: B:51:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0177 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0184 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:47:0x0146, B:57:0x017e, B:59:0x0184, B:62:0x018a, B:30:0x00a5), top: B:67:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x018a A[Catch: all -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:9:0x002c, B:47:0x0146, B:57:0x017e, B:59:0x0184, B:62:0x018a, B:30:0x00a5), top: B:67:0x000e }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0162 -> B:50:0x0165). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            final PineTimeBLEClient pineTimeBLEClient;
            Mutex mutex2;
            int i;
            int i2;
            Mutex mutex3;
            PineTimeBLEClient pineTimeBLEClient2;
            int i3;
            Exception exc;
            int i4;
            int i5;
            int i6;
            PineTimeBLEClient pineTimeBLEClient3;
            Mutex mutex4;
            int i7;
            int i8;
            int i9;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            final int i11 = 0;
            int i12 = 2;
            final int i13 = 1;
            try {
                try {
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex5 = PineTimeBLEClient.this.mutex;
                        pineTimeBLEClient = PineTimeBLEClient.this;
                        this.L$0 = mutex5;
                        this.L$1 = pineTimeBLEClient;
                        this.I$0 = 0;
                        this.label = 1;
                        if (mutex5.lock(null, this) != coroutine_suspended) {
                            mutex2 = mutex5;
                            i = 0;
                        }
                        return coroutine_suspended;
                    }
                    if (i10 == 1) {
                        i = this.I$0;
                        pineTimeBLEClient = (PineTimeBLEClient) this.L$1;
                        Mutex mutex6 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex2 = mutex6;
                    } else if (i10 == 2) {
                        i8 = this.I$3;
                        i13 = this.I$2;
                        i7 = this.I$1;
                        int i14 = this.I$0;
                        pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                        mutex3 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e) {
                            exc = e;
                            i9 = i14;
                            String str = Logger.defaultTag;
                            Logger.logWarning(str, pineTimeBLEClient2.getTag() + ": " + ("start connect " + i13), exc);
                            if (pineTimeBLEClient2.isStopped()) {
                                i2 = i8;
                                i11 = i7;
                                i3 = i9;
                            }
                            if (!pineTimeBLEClient2.isStopped()) {
                            }
                        }
                        pineTimeBLEClient = pineTimeBLEClient2;
                        mutex2 = mutex3;
                        if (!pineTimeBLEClient.isStopped()) {
                        }
                    } else {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            i6 = this.I$3;
                            i5 = this.I$2;
                            i4 = this.I$1;
                            i3 = this.I$0;
                            pineTimeBLEClient3 = (PineTimeBLEClient) this.L$1;
                            mutex4 = (Mutex) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            int i15 = i4;
                            i13 = i5;
                            i11 = i15;
                            mutex3 = mutex4;
                            pineTimeBLEClient2 = pineTimeBLEClient3;
                            i2 = i6;
                            if (!pineTimeBLEClient2.isStopped() && i13 != i2) {
                                i13++;
                                i12 = 2;
                                try {
                                } catch (Exception e2) {
                                    int i16 = i2;
                                    exc = e2;
                                    i9 = i3;
                                    i7 = i11;
                                    i8 = i16;
                                    String str2 = Logger.defaultTag;
                                    Logger.logWarning(str2, pineTimeBLEClient2.getTag() + ": " + ("start connect " + i13), exc);
                                    if (pineTimeBLEClient2.isStopped() && i13 < pineTimeBLEClient2.initialConnectionAttemptsCount) {
                                        this.L$0 = mutex3;
                                        this.L$1 = pineTimeBLEClient2;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                                        this.I$0 = i9;
                                        this.I$1 = i7;
                                        this.I$2 = i13;
                                        this.I$3 = i8;
                                        this.label = 3;
                                        if (pineTimeBLEClient2.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                                            int i17 = i7;
                                            i3 = i9;
                                            i6 = i8;
                                            i5 = i13;
                                            i4 = i17;
                                            Exception exc2 = exc;
                                            pineTimeBLEClient3 = pineTimeBLEClient2;
                                            mutex4 = mutex3;
                                            long j = pineTimeBLEClient3.reconnectDelay;
                                            this.L$0 = mutex4;
                                            this.L$1 = pineTimeBLEClient3;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(exc2);
                                            this.I$0 = i3;
                                            this.I$1 = i4;
                                            this.I$2 = i5;
                                            this.I$3 = i6;
                                            this.label = 4;
                                        }
                                        return coroutine_suspended;
                                    }
                                    i2 = i8;
                                    i11 = i7;
                                    i3 = i9;
                                    if (!pineTimeBLEClient2.isStopped()) {
                                        i13++;
                                        i12 = 2;
                                        this.L$0 = mutex3;
                                        this.L$1 = pineTimeBLEClient2;
                                        this.L$2 = null;
                                        this.I$0 = i3;
                                        this.I$1 = i11;
                                        this.I$2 = i13;
                                        this.I$3 = i2;
                                        this.label = i12;
                                    }
                                    pineTimeBLEClient = pineTimeBLEClient2;
                                    mutex2 = mutex3;
                                    if (!pineTimeBLEClient.isStopped()) {
                                    }
                                }
                                this.L$0 = mutex3;
                                this.L$1 = pineTimeBLEClient2;
                                this.L$2 = null;
                                this.I$0 = i3;
                                this.I$1 = i11;
                                this.I$2 = i13;
                                this.I$3 = i2;
                                this.label = i12;
                            }
                            pineTimeBLEClient = pineTimeBLEClient2;
                            mutex2 = mutex3;
                            if (!pineTimeBLEClient.isStopped()) {
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return unit;
                            }
                            pineTimeBLEClient.hrTimeoutGuard.startAsyncCheck();
                            pineTimeBLEClient.accTimeoutGuard.startAsyncCheck();
                            Unit unit2 = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        }
                        i6 = this.I$3;
                        i5 = this.I$2;
                        i4 = this.I$1;
                        i3 = this.I$0;
                        exc = (Exception) this.L$2;
                        pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                        mutex3 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Exception exc22 = exc;
                        pineTimeBLEClient3 = pineTimeBLEClient2;
                        mutex4 = mutex3;
                        long j2 = pineTimeBLEClient3.reconnectDelay;
                        this.L$0 = mutex4;
                        this.L$1 = pineTimeBLEClient3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(exc22);
                        this.I$0 = i3;
                        this.I$1 = i4;
                        this.I$2 = i5;
                        this.I$3 = i6;
                        this.label = 4;
                    }
                    pineTimeBLEClient.bleClient.addCharacteristicChangeListener(new Function1() { // from class: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$start$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            int i18 = i11;
                            PineTimeBLEClient pineTimeBLEClient4 = pineTimeBLEClient;
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) obj2;
                            switch (i18) {
                                case 0:
                                    return PineTimeBLEClient.C21161.invokeSuspend$lambda$0$0(pineTimeBLEClient4, bluetoothGattCharacteristic);
                                default:
                                    return PineTimeBLEClient.C21161.invokeSuspend$lambda$0$1(pineTimeBLEClient4, bluetoothGattCharacteristic);
                            }
                        }
                    });
                    pineTimeBLEClient.bleClient.addCharacteristicChangeListener(new Function1() { // from class: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$start$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            int i18 = i13;
                            PineTimeBLEClient pineTimeBLEClient4 = pineTimeBLEClient;
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) obj2;
                            switch (i18) {
                                case 0:
                                    return PineTimeBLEClient.C21161.invokeSuspend$lambda$0$0(pineTimeBLEClient4, bluetoothGattCharacteristic);
                                default:
                                    return PineTimeBLEClient.C21161.invokeSuspend$lambda$0$1(pineTimeBLEClient4, bluetoothGattCharacteristic);
                            }
                        }
                    });
                    i2 = pineTimeBLEClient.initialConnectionAttemptsCount;
                    if (1 <= i2) {
                        mutex3 = mutex2;
                        pineTimeBLEClient2 = pineTimeBLEClient;
                        i3 = i;
                        this.L$0 = mutex3;
                        this.L$1 = pineTimeBLEClient2;
                        this.L$2 = null;
                        this.I$0 = i3;
                        this.I$1 = i11;
                        this.I$2 = i13;
                        this.I$3 = i2;
                        this.label = i12;
                    }
                    if (!pineTimeBLEClient.isStopped()) {
                    }
                } catch (Throwable th) {
                    th = th;
                    mutex.unlock(null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$stop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$stop$1", f = "PineTimeBLEClient.kt", l = {302, 194}, m = "invokeSuspend", v = 2)
    public static final class C21171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public C21171(Continuation<? super C21171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PineTimeBLEClient.this.new C21171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            PineTimeBLEClient pineTimeBLEClient;
            int i;
            Throwable th;
            Mutex mutex2;
            PineTimeBLEClient pineTimeBLEClient2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = PineTimeBLEClient.this.mutex;
                    pineTimeBLEClient = PineTimeBLEClient.this;
                    this.L$0 = mutex;
                    this.L$1 = pineTimeBLEClient;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    pineTimeBLEClient2 = (PineTimeBLEClient) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        JobKt__JobKt.cancelChildren$default(pineTimeBLEClient2.supervisorJob, null, 1, null);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i3 = this.I$0;
                PineTimeBLEClient pineTimeBLEClient3 = (PineTimeBLEClient) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i3;
                pineTimeBLEClient = pineTimeBLEClient3;
                mutex = mutex3;
                pineTimeBLEClient.subscribers.clear();
                pineTimeBLEClient.hrTimeoutGuard.stopAsyncCheck();
                pineTimeBLEClient.accTimeoutGuard.stopAsyncCheck();
                this.L$0 = mutex;
                this.L$1 = pineTimeBLEClient;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (pineTimeBLEClient.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    pineTimeBLEClient2 = pineTimeBLEClient;
                    JobKt__JobKt.cancelChildren$default(pineTimeBLEClient2.supervisorJob, null, 1, null);
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient$writeAlertCharacteristics$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient", f = "PineTimeBLEClient.kt", l = {302, 88}, m = "writeAlertCharacteristics", v = 2)
    public static final class C21181 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C21181(Continuation<? super C21181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PineTimeBLEClient.this.writeAlertCharacteristics(null, 0, this);
        }
    }

    public PineTimeBLEClient(Context context, BluetoothDevice bluetoothDevice, int i) {
        context.getClass();
        bluetoothDevice.getClass();
        this.initialConnectionAttemptsCount = i;
        this.tag = "PineTimeBLEClient";
        this.timeout = 10000L;
        this.reconnectDelay = 2000L;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.bleClient = new BLEClient(context, bluetoothDevice);
        long j = 60000;
        this.missingDataTimeout = 60000L;
        this.lastFullReconnectAttempt = new AtomicLong(System.currentTimeMillis());
        this.lastPpiRestartAttempt = new AtomicLong(System.currentTimeMillis());
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Function0 function0 = null;
        this.hrTimeoutGuard = new TimeoutGuard(j, function0, new PineTimeBLEClient$hrTimeoutGuard$1(this, null), i2, defaultConstructorMarker);
        this.accTimeoutGuard = new TimeoutGuard(j, function0, new PineTimeBLEClient$accTimeoutGuard$1(this, null), i2, defaultConstructorMarker);
        this.subscribers = new ConcurrentHashMap<>();
        this.stopped = new AtomicBoolean(false);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        this.capabilities = SetsKt.setOf((Object[]) new Capability[]{companion.getHR(), companion.getACCEL()});
        this.hrParser = new BLEHRParser();
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("HR DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(5, 1), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("ACC DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(5, 1), 0, 4, null));
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bleShutdownAndDisconnect(Continuation<? super Unit> continuation) {
        C21131 c21131;
        if (continuation instanceof C21131) {
            c21131 = (C21131) continuation;
            int i = c21131.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21131.label = i - Integer.MIN_VALUE;
            } else {
                c21131 = new C21131(continuation);
            }
        }
        Object obj = c21131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21131.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                BLEClient bLEClient = this.bleClient;
                long j = this.timeout;
                c21131.label = 1;
                if (bLEClient.disconnectSync(j, c21131) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(Continuation<? super Unit> continuation) {
        C21141 c21141;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BLEClient bLEClient;
        long j;
        BluetoothGattCharacteristic bluetoothGattCharacteristic2;
        Object characteristic;
        BluetoothGattCharacteristic bluetoothGattCharacteristic3;
        BluetoothGattCharacteristic bluetoothGattCharacteristic4;
        BLEClient bLEClient2;
        long j2;
        BluetoothGattCharacteristic bluetoothGattCharacteristic5;
        if (continuation instanceof C21141) {
            c21141 = (C21141) continuation;
            int i = c21141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21141.label = i - Integer.MIN_VALUE;
            } else {
                c21141 = new C21141(continuation);
            }
        }
        C21141 c211412 = c21141;
        Object characteristic2 = c211412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c211412.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(characteristic2);
            BLEClient bLEClient3 = this.bleClient;
            long j3 = this.timeout;
            c211412.label = 1;
            if (bLEClient3.connect(j3, c211412) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(characteristic2);
                bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristic2;
                String str = Logger.defaultTag;
                Logger.logInfo(str, getTag() + ": " + ("characteristics HR " + bluetoothGattCharacteristic), null);
                bLEClient = this.bleClient;
                j = this.timeout;
                c211412.L$0 = bluetoothGattCharacteristic;
                c211412.label = 3;
                if (bLEClient.setNotificationEnabled(bluetoothGattCharacteristic, true, j, c211412) != coroutine_suspended) {
                    bluetoothGattCharacteristic2 = bluetoothGattCharacteristic;
                    BLEClient bLEClient4 = this.bleClient;
                    PineTimeConstants.Companion companion = PineTimeConstants.INSTANCE;
                    UUID pine_time_accel_service_id = companion.getPINE_TIME_ACCEL_SERVICE_ID();
                    UUID pine_time_accel_characteristic_id = companion.getPINE_TIME_ACCEL_CHARACTERISTIC_ID();
                    long j4 = this.timeout;
                    c211412.L$0 = bluetoothGattCharacteristic2;
                    c211412.label = 4;
                    characteristic = bLEClient4.getCharacteristic(pine_time_accel_service_id, pine_time_accel_characteristic_id, j4, c211412);
                    if (characteristic != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic6 = (BluetoothGattCharacteristic) c211412.L$0;
                ResultKt.throwOnFailure(characteristic2);
                bluetoothGattCharacteristic2 = bluetoothGattCharacteristic6;
                BLEClient bLEClient42 = this.bleClient;
                PineTimeConstants.Companion companion2 = PineTimeConstants.INSTANCE;
                UUID pine_time_accel_service_id2 = companion2.getPINE_TIME_ACCEL_SERVICE_ID();
                UUID pine_time_accel_characteristic_id2 = companion2.getPINE_TIME_ACCEL_CHARACTERISTIC_ID();
                long j42 = this.timeout;
                c211412.L$0 = bluetoothGattCharacteristic2;
                c211412.label = 4;
                characteristic = bLEClient42.getCharacteristic(pine_time_accel_service_id2, pine_time_accel_characteristic_id2, j42, c211412);
                if (characteristic != coroutine_suspended) {
                    bluetoothGattCharacteristic3 = bluetoothGattCharacteristic2;
                    characteristic2 = characteristic;
                    bluetoothGattCharacteristic4 = (BluetoothGattCharacteristic) characteristic2;
                    bLEClient2 = this.bleClient;
                    j2 = this.timeout;
                    c211412.L$0 = bluetoothGattCharacteristic3;
                    c211412.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic4);
                    c211412.label = 5;
                    if (bLEClient2.setNotificationEnabled(bluetoothGattCharacteristic4, true, j2, c211412) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bluetoothGattCharacteristic5 = (BluetoothGattCharacteristic) c211412.L$0;
                ResultKt.throwOnFailure(characteristic2);
                String str2 = "characteristics ACCEL " + bluetoothGattCharacteristic5;
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                return Unit.INSTANCE;
            }
            BluetoothGattCharacteristic bluetoothGattCharacteristic7 = (BluetoothGattCharacteristic) c211412.L$0;
            ResultKt.throwOnFailure(characteristic2);
            bluetoothGattCharacteristic3 = bluetoothGattCharacteristic7;
            bluetoothGattCharacteristic4 = (BluetoothGattCharacteristic) characteristic2;
            bLEClient2 = this.bleClient;
            j2 = this.timeout;
            c211412.L$0 = bluetoothGattCharacteristic3;
            c211412.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic4);
            c211412.label = 5;
            if (bLEClient2.setNotificationEnabled(bluetoothGattCharacteristic4, true, j2, c211412) != coroutine_suspended) {
                bluetoothGattCharacteristic5 = bluetoothGattCharacteristic3;
                String str22 = "characteristics ACCEL " + bluetoothGattCharacteristic5;
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str22, null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        ResultKt.throwOnFailure(characteristic2);
        BLEClient bLEClient5 = this.bleClient;
        BLEHRConstants.Companion companion3 = BLEHRConstants.INSTANCE;
        UUID generic_hr_service_id = companion3.getGENERIC_HR_SERVICE_ID();
        UUID generic_hr_measurement_characteristic_id = companion3.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID();
        long j5 = this.timeout;
        c211412.label = 2;
        characteristic2 = bLEClient5.getCharacteristic(generic_hr_service_id, generic_hr_measurement_characteristic_id, j5, c211412);
        if (characteristic2 != coroutine_suspended) {
            bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristic2;
            String str3 = Logger.defaultTag;
            Logger.logInfo(str3, getTag() + ": " + ("characteristics HR " + bluetoothGattCharacteristic), null);
            bLEClient = this.bleClient;
            j = this.timeout;
            c211412.L$0 = bluetoothGattCharacteristic;
            c211412.label = 3;
            if (bLEClient.setNotificationEnabled(bluetoothGattCharacteristic, true, j, c211412) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAlertCharacteristics(Continuation<? super BluetoothGattCharacteristic> continuation) throws Throwable {
        C21151 c21151;
        Mutex mutex;
        int i;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof C21151) {
            c21151 = (C21151) continuation;
            int i2 = c21151.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c21151.label = i2 - Integer.MIN_VALUE;
            } else {
                c21151 = new C21151(continuation);
            }
        }
        C21151 c211512 = c21151;
        Object obj = c211512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c211512.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                c211512.L$0 = mutex;
                c211512.I$0 = 0;
                c211512.label = 1;
                if (mutex.lock(null, c211512) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = (Mutex) c211512.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c211512.I$0;
            Mutex mutex3 = (Mutex) c211512.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            BLEClient bLEClient = this.bleClient;
            PineTimeConstants.Companion companion = PineTimeConstants.INSTANCE;
            UUID pine_time_alert_service_id = companion.getPINE_TIME_ALERT_SERVICE_ID();
            UUID pine_time_alert_characteristic_id = companion.getPINE_TIME_ALERT_CHARACTERISTIC_ID();
            long j = this.timeout / 10;
            c211512.L$0 = mutex;
            c211512.I$0 = i;
            c211512.I$1 = 0;
            c211512.label = 2;
            Object characteristic = bLEClient.getCharacteristic(pine_time_alert_service_id, pine_time_alert_characteristic_id, j, c211512);
            if (characteristic != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = characteristic;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getInstanceId() {
        return String.valueOf(System.identityHashCode(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAccData(BluetoothGattCharacteristic characteristic) {
        if (isStopped()) {
            return;
        }
        this.accTimeoutGuard.refresh();
        AccelBatch accelData = parseAccelData(characteristic);
        if (accelData.getPoints().size() >= 3) {
            Logger.logInfo("ACC DATA " + getTag() + ": " + accelData.getPoints().subList(0, 3));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
        AccelCapability accel = Capabilities.INSTANCE.getACCEL();
        accel.getClass();
        List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(accel);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(accelData, Long.valueOf(jCurrentTimeMillis));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHrData(BluetoothGattCharacteristic characteristic) {
        if (isStopped() || !Intrinsics.areEqual(characteristic.getUuid(), BLEHRConstants.INSTANCE.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID())) {
            return;
        }
        this.hrTimeoutGuard.refresh();
        BLEHRParser.HRData hrData = this.hrParser.parseHrData(characteristic);
        Logger.logInfo("HR DATA " + getTag() + ": " + hrData);
        long jCurrentTimeMillis = System.currentTimeMillis();
        float hr = (float) hrData.getHr();
        Logger.logInfo("HR DATA " + getTag() + ": " + hr);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        if (companion.getHR().isValid(hr)) {
            ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
            HRCapability hr2 = companion.getHR();
            hr2.getClass();
            List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(hr2);
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(Float.valueOf(hr), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleNotificationsTimeout(String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void start() {
        String strM = FileInsert$$ExternalSyntheticOutline0.m("start ", getInstanceId());
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        this.h = new Handler();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21161(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeAlertCharacteristics(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, Continuation<? super Unit> continuation) throws Throwable {
        C21181 c21181;
        Mutex mutex;
        int i2;
        int i3;
        Throwable th;
        Mutex mutex2;
        BLEClient bLEClient;
        if (continuation instanceof C21181) {
            c21181 = (C21181) continuation;
            int i4 = c21181.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c21181.label = i4 - Integer.MIN_VALUE;
            } else {
                c21181 = new C21181(continuation);
            }
        }
        C21181 c211812 = c21181;
        Object obj = c211812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c211812.label;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.mutex;
                    c211812.L$0 = bluetoothGattCharacteristic;
                    c211812.L$1 = mutex;
                    c211812.I$0 = i;
                    c211812.I$1 = 0;
                    c211812.label = 1;
                    if (mutex.lock(null, c211812) != coroutine_suspended) {
                        i2 = i;
                        i3 = 0;
                    }
                    return coroutine_suspended;
                }
                if (i5 != 1) {
                    if (i5 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = (Mutex) c211812.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i6 = c211812.I$1;
                int i7 = c211812.I$0;
                Mutex mutex3 = (Mutex) c211812.L$1;
                BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) c211812.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                i2 = i7;
                i3 = i6;
                bluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                byte[] bArr = {(byte) i2};
                long j = this.timeout / 10;
                c211812.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                c211812.L$1 = mutex;
                c211812.I$0 = i2;
                c211812.I$1 = i3;
                c211812.I$2 = 0;
                c211812.label = 2;
                if (bLEClient.write(bluetoothGattCharacteristic, bArr, j, c211812) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                th = th3;
                mutex2 = mutex;
                mutex2.unlock(null);
                throw th;
            }
            bLEClient = this.bleClient;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void alert(int repeat) {
        Matchers.startsWith("Alert " + repeat);
        this.alertJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(repeat, null), 3, null);
    }

    public final void alertGentle(int repeat) {
        this.alertJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21121(repeat, null), 3, null);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public boolean isStopped() {
        return this.stopped.get();
    }

    public final AccelBatch parseAccelData(BluetoothGattCharacteristic characteristic) {
        characteristic.getClass();
        byte[] value = characteristic.getValue();
        if (value == null || value.length == 0) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": Empty data", null);
            return new AccelBatch(0, 0L, 0L, CollectionsKt.emptyList());
        }
        try {
            Integer intValue = characteristic.getIntValue(18, 0);
            int iIntValue = intValue != null ? intValue.intValue() : 0;
            Integer intValue2 = characteristic.getIntValue(18, 1);
            int iIntValue2 = intValue2 != null ? intValue2.intValue() : 0;
            Integer intValue3 = characteristic.getIntValue(18, 2);
            int iIntValue3 = intValue3 != null ? intValue3.intValue() : 0;
            String str = Logger.defaultTag;
            Logger.logInfo(str, getTag() + ": " + ("Accel: " + iIntValue + " " + iIntValue2 + " " + iIntValue3), null);
            return new AccelBatch(100, System.currentTimeMillis(), System.currentTimeMillis(), CollectionsKt.listOf(new AccelBatch.Point(iIntValue / 100.0f, iIntValue2 / 100.0f, iIntValue3 / 100.0f)));
        } catch (Exception e) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("Parsing error: ", BLEUtilKt.toHexString(value));
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, e);
            return new AccelBatch(0, 0L, 0L, CollectionsKt.emptyList());
        }
    }

    @Override // com.urbandroid.sleep.hr.ReceiverClient
    public void stop() {
        String strM = FileInsert$$ExternalSyntheticOutline0.m("stop ", getInstanceId());
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        this.stopped.set(true);
        JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21171(null), 3, null);
    }

    public final void stopAlert() {
        Job job = this.alertJob;
        if (job != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PineTimeBLEClient$stopAlert$1$1(job, null), 3, null);
        }
    }

    @Override // com.urbandroid.sleep.hr.ReceiverClient
    public <T> void subscribe(Capability<T> capability, Function2<? super T, ? super Long, Unit> subscriber) {
        List<Function2<Object, Long, Unit>> listPutIfAbsent;
        capability.getClass();
        subscriber.getClass();
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
        List<Function2<Object, Long, Unit>> arrayList = concurrentHashMap.get(capability);
        if (arrayList == null && (listPutIfAbsent = concurrentHashMap.putIfAbsent(capability, (arrayList = new ArrayList<>()))) != null) {
            arrayList = listPutIfAbsent;
        }
        arrayList.add((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(subscriber, 2));
    }

    public /* synthetic */ PineTimeBLEClient(Context context, BluetoothDevice bluetoothDevice, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bluetoothDevice, (i2 & 4) != 0 ? 2 : i);
    }
}
