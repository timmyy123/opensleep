package com.urbandroid.sleep.hr.generic;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEClient;
import com.urbandroid.sleep.bluetoothle.TimeoutGuard;
import com.urbandroid.sleep.hr.Capabilities;
import com.urbandroid.sleep.hr.Capability;
import com.urbandroid.sleep.hr.HRCapability;
import com.urbandroid.sleep.hr.RRCapability;
import com.urbandroid.sleep.hr.RawHrDataPersister;
import com.urbandroid.sleep.hr.ReceiverClient;
import com.urbandroid.sleep.hr.generic.BLEHRClient;
import com.urbandroid.sleep.hr.generic.BLEHRConstants;
import com.urbandroid.sleep.hr.generic.BLEHRParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJG\u0010\u001b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u00028\u0000`\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105RH\u00109\u001a6\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u0015\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t0\u0017j\b\u0012\u0004\u0012\u000207`\u001908068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R&\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00150>8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lcom/urbandroid/sleep/hr/generic/BLEHRClient;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "", "start", "()V", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "handleDataChange", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "handleNotificationsTimeout", "stop", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "Landroid/content/Context;", "Landroid/bluetooth/BluetoothDevice;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "timeout", "J", "reconnectDelay", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "bleClient", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "timeoutGuard", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "subscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "", "capabilities", "Ljava/util/Set;", "getCapabilities", "()Ljava/util/Set;", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "hrParser", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "dataLog", "Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "", "isStopped", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEHRClient implements ReceiverClient, FeatureLogger {
    private final BLEClient bleClient;
    private final Set<Capability<Float>> capabilities;
    private final Context context;
    private final RawHrDataPersister dataLog;
    private final BluetoothDevice device;
    private final BLEHRParser hrParser;
    private final Mutex mutex;
    private final long reconnectDelay;
    private final CoroutineScope scope;
    private final AtomicBoolean stopped;
    private final ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> subscribers;
    private final CompletableJob supervisorJob;
    private final String tag;
    private final long timeout;
    private final TimeoutGuard timeoutGuard;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.generic.BLEHRClient$connect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.generic.BLEHRClient", f = "BLEHRClient.kt", l = {97, 98, 99}, m = "connect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BLEHRClient.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.generic.BLEHRClient$handleNotificationsTimeout$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.generic.BLEHRClient$handleNotificationsTimeout$2", f = "BLEHRClient.kt", l = {164, 148, 149, 150}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BLEHRClient.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
        
            if (r1.connect(r14) != r2) goto L56;
         */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ea A[Catch: all -> 0x00fb, Exception -> 0x0100, PHI: r1 r3 r4 r15
          0x00ea: PHI (r1v9 com.urbandroid.sleep.hr.generic.BLEHRClient) = (r1v7 com.urbandroid.sleep.hr.generic.BLEHRClient), (r1v17 com.urbandroid.sleep.hr.generic.BLEHRClient) binds: [B:44:0x00e7, B:19:0x0042] A[DONT_GENERATE, DONT_INLINE]
          0x00ea: PHI (r3v5 int) = (r3v4 int), (r3v12 int) binds: [B:44:0x00e7, B:19:0x0042] A[DONT_GENERATE, DONT_INLINE]
          0x00ea: PHI (r4v2 int) = (r4v1 int), (r4v6 int) binds: [B:44:0x00e7, B:19:0x0042] A[DONT_GENERATE, DONT_INLINE]
          0x00ea: PHI (r15v11 kotlinx.coroutines.sync.Mutex) = (r15v5 kotlinx.coroutines.sync.Mutex), (r15v25 kotlinx.coroutines.sync.Mutex) binds: [B:44:0x00e7, B:19:0x0042] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:46:0x00ea, B:43:0x00d5), top: B:62:0x00d5 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            BLEHRClient bLEHRClient;
            int i;
            Exception e;
            Mutex mutex2;
            BLEHRClient bLEHRClient2;
            int i2;
            long j;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            int i4 = 0;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = BLEHRClient.this.mutex;
                    bLEHRClient = BLEHRClient.this;
                    this.L$0 = mutex;
                    this.L$1 = bLEHRClient;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            int i5 = this.I$1;
                            i2 = this.I$0;
                            BLEHRClient bLEHRClient3 = (BLEHRClient) this.L$1;
                            Mutex mutex3 = (Mutex) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                i4 = i5;
                                bLEHRClient2 = bLEHRClient3;
                                mutex = mutex3;
                                this.L$0 = mutex;
                                this.L$1 = bLEHRClient2;
                                this.I$0 = i2;
                                this.I$1 = i4;
                                this.label = 4;
                            } catch (Exception e2) {
                                e = e2;
                                bLEHRClient2 = bLEHRClient3;
                                mutex2 = mutex3;
                                Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2 = mutex3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        } else {
                            if (i3 != 4) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            bLEHRClient2 = (BLEHRClient) this.L$1;
                            mutex2 = (Mutex) this.L$0;
                            try {
                                try {
                                    ResultKt.throwOnFailure(obj);
                                } catch (Exception e3) {
                                    e = e3;
                                    Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                    } else {
                        i4 = this.I$1;
                        int i6 = this.I$0;
                        BLEHRClient bLEHRClient4 = (BLEHRClient) this.L$1;
                        Mutex mutex4 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i2 = i6;
                            bLEHRClient2 = bLEHRClient4;
                            mutex = mutex4;
                            try {
                                j = bLEHRClient2.reconnectDelay;
                                this.L$0 = mutex;
                                this.L$1 = bLEHRClient2;
                                this.I$0 = i2;
                                this.I$1 = i4;
                                this.label = 3;
                                if (DelayKt.delay(j, this) == coroutine_suspended) {
                                    this.L$0 = mutex;
                                    this.L$1 = bLEHRClient2;
                                    this.I$0 = i2;
                                    this.I$1 = i4;
                                    this.label = 4;
                                }
                                return coroutine_suspended;
                            } catch (Exception e4) {
                                Mutex mutex5 = mutex;
                                e = e4;
                                mutex2 = mutex5;
                                Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            bLEHRClient2 = bLEHRClient4;
                            mutex2 = mutex4;
                            Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                        } catch (Throwable th4) {
                            th = th4;
                            mutex2 = mutex4;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                int i7 = this.I$0;
                BLEHRClient bLEHRClient5 = (BLEHRClient) this.L$1;
                Mutex mutex6 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i7;
                bLEHRClient = bLEHRClient5;
                mutex = mutex6;
                if (!bLEHRClient.isStopped()) {
                    Logger.logInfo(Logger.defaultTag, bLEHRClient.getTag() + ": Timeout - trying to reconnect.", null);
                    try {
                        BLEClient bLEClient = bLEHRClient.bleClient;
                        long j2 = bLEHRClient.timeout;
                        this.L$0 = mutex;
                        this.L$1 = bLEHRClient;
                        this.I$0 = i;
                        this.I$1 = 0;
                        this.label = 2;
                        if (bLEClient.disconnectSync(j2, this) != coroutine_suspended) {
                            bLEHRClient2 = bLEHRClient;
                            i2 = i;
                            j = bLEHRClient2.reconnectDelay;
                            this.L$0 = mutex;
                            this.L$1 = bLEHRClient2;
                            this.I$0 = i2;
                            this.I$1 = i4;
                            this.label = 3;
                            if (DelayKt.delay(j, this) == coroutine_suspended) {
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e6) {
                        Mutex mutex7 = mutex;
                        e = e6;
                        mutex2 = mutex7;
                        bLEHRClient2 = bLEHRClient;
                        Logger.logWarning(Logger.defaultTag, bLEHRClient2.getTag() + ": reconnect", e);
                    }
                }
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                Mutex mutex8 = mutex;
                th = th5;
                mutex2 = mutex8;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.generic.BLEHRClient$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.generic.BLEHRClient$start$1", f = "BLEHRClient.kt", l = {164, 85, 89}, m = "invokeSuspend", v = 2)
    public static final class C21101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C21101(Continuation<? super C21101> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(BLEHRClient bLEHRClient, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (!bLEHRClient.isStopped()) {
                bLEHRClient.timeoutGuard.refresh();
                bLEHRClient.handleDataChange(bluetoothGattCharacteristic);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BLEHRClient.this.new C21101(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x010c -> B:40:0x0110). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            final BLEHRClient bLEHRClient;
            int i;
            int i2;
            BLEHRClient bLEHRClient2;
            int i3;
            int i4;
            int i5;
            int i6;
            Exception e;
            long j;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            try {
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex3 = BLEHRClient.this.mutex;
                    bLEHRClient = BLEHRClient.this;
                    this.L$0 = mutex3;
                    this.L$1 = bLEHRClient;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex3.lock(null, this) != coroutine_suspended) {
                        mutex = mutex3;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i7 != 1) {
                    if (i7 == 2) {
                        int i8 = this.I$2;
                        int i9 = this.I$1;
                        int i10 = this.I$0;
                        BLEHRClient bLEHRClient3 = (BLEHRClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i8;
                            i6 = i9;
                            i5 = i10;
                            bLEHRClient2 = bLEHRClient3;
                            mutex = mutex2;
                            String str = Logger.defaultTag;
                            Logger.logWarning(str, bLEHRClient2.getTag() + ": " + ("start connect " + i2), e);
                            j = bLEHRClient2.reconnectDelay;
                            this.L$0 = mutex;
                            this.L$1 = bLEHRClient2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(e);
                            this.I$0 = i5;
                            this.I$1 = i6;
                            this.I$2 = i2;
                            this.label = 3;
                            if (DelayKt.delay(j, this) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            mutex = mutex2;
                            mutex.unlock(null);
                            throw th;
                        }
                        mutex = mutex2;
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    }
                    if (i7 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    int i11 = this.I$2;
                    int i12 = this.I$1;
                    int i13 = this.I$0;
                    bLEHRClient2 = (BLEHRClient) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i3 = i12;
                    i4 = i13;
                    i2 = i11 + 1;
                    if (i2 < 3) {
                        try {
                        } catch (Exception e3) {
                            e = e3;
                            int i14 = i3;
                            i5 = i4;
                            i6 = i14;
                            String str2 = Logger.defaultTag;
                            Logger.logWarning(str2, bLEHRClient2.getTag() + ": " + ("start connect " + i2), e);
                            j = bLEHRClient2.reconnectDelay;
                            this.L$0 = mutex;
                            this.L$1 = bLEHRClient2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(e);
                            this.I$0 = i5;
                            this.I$1 = i6;
                            this.I$2 = i2;
                            this.label = 3;
                            if (DelayKt.delay(j, this) != coroutine_suspended) {
                                int i15 = i5;
                                i3 = i6;
                                i4 = i15;
                                i11 = i2;
                                i2 = i11 + 1;
                                if (i2 < 3) {
                                }
                                Unit unit2 = Unit.INSTANCE;
                                mutex.unlock(null);
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        this.L$0 = mutex;
                        this.L$1 = bLEHRClient2;
                        this.L$2 = null;
                        this.I$0 = i4;
                        this.I$1 = i3;
                        this.I$2 = i2;
                        this.label = 2;
                        if (bLEHRClient2.connect(this) != coroutine_suspended) {
                            mutex2 = mutex;
                            mutex = mutex2;
                        }
                        return coroutine_suspended;
                    }
                    Unit unit22 = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
                i = this.I$0;
                bLEHRClient = (BLEHRClient) this.L$1;
                Mutex mutex4 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
                bLEHRClient.timeoutGuard.startAsyncCheck();
                bLEHRClient.bleClient.addCharacteristicChangeListener(new Function1() { // from class: com.urbandroid.sleep.hr.generic.BLEHRClient$start$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BLEHRClient.C21101.invokeSuspend$lambda$0$0(bLEHRClient, (BluetoothGattCharacteristic) obj2);
                    }
                });
                i2 = 1;
                bLEHRClient2 = bLEHRClient;
                i3 = 0;
                i4 = i;
                if (i2 < 3) {
                }
                Unit unit222 = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.generic.BLEHRClient$stop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.generic.BLEHRClient$stop$1", f = "BLEHRClient.kt", l = {164}, m = "invokeSuspend", v = 2)
    public static final class C21111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C21111(Continuation<? super C21111> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BLEHRClient.this.new C21111(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BLEHRClient bLEHRClient;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BLEHRClient.this.mutex;
                BLEHRClient bLEHRClient2 = BLEHRClient.this;
                this.L$0 = mutex2;
                this.L$1 = bLEHRClient2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                bLEHRClient = bLEHRClient2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bLEHRClient = (BLEHRClient) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                bLEHRClient.stopped.set(true);
                bLEHRClient.subscribers.clear();
                bLEHRClient.timeoutGuard.stopAsyncCheck();
                bLEHRClient.bleClient.disconnectAsync();
                JobKt__JobKt.cancelChildren$default(bLEHRClient.supervisorJob, null, 1, null);
                bLEHRClient.dataLog.stop();
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public BLEHRClient(Context context, BluetoothDevice bluetoothDevice) {
        context.getClass();
        bluetoothDevice.getClass();
        this.context = context;
        this.device = bluetoothDevice;
        this.tag = "BLEHRClient";
        this.timeout = 10000L;
        this.reconnectDelay = 1000L;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.bleClient = new BLEClient(context, bluetoothDevice);
        this.timeoutGuard = new TimeoutGuard(60000L, null, new BLEHRClient$timeoutGuard$1(this, null), 2, null);
        this.subscribers = new ConcurrentHashMap<>();
        this.stopped = new AtomicBoolean(false);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        this.capabilities = SetsKt.setOf((Object[]) new Capability[]{companion.getHR(), companion.getRR()});
        this.hrParser = new BLEHRParser();
        this.dataLog = new RawHrDataPersister(FileInsert$$ExternalSyntheticOutline0.m$1(bluetoothDevice.getName(), " ", bluetoothDevice.getAddress()));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("HR DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(3, 1), 0, 4, null));
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        if (r1.setNotificationEnabled(r2, true, r4, r6) != r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object characteristic = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass12.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(characteristic);
            BLEClient bLEClient = this.bleClient;
            long j = this.timeout;
            anonymousClass12.label = 1;
            if (bLEClient.connect(j, anonymousClass12) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(characteristic);
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(characteristic);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(characteristic);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristic;
            BLEClient bLEClient2 = this.bleClient;
            long j2 = this.timeout;
            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
            anonymousClass12.label = 3;
        }
        BLEClient bLEClient3 = this.bleClient;
        BLEHRConstants.Companion companion = BLEHRConstants.INSTANCE;
        UUID generic_hr_service_id = companion.getGENERIC_HR_SERVICE_ID();
        UUID generic_hr_measurement_characteristic_id = companion.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID();
        long j3 = this.timeout;
        anonymousClass12.label = 2;
        characteristic = bLEClient3.getCharacteristic(generic_hr_service_id, generic_hr_measurement_characteristic_id, j3, anonymousClass12);
        if (characteristic != coroutine_suspended) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) characteristic;
            BLEClient bLEClient22 = this.bleClient;
            long j22 = this.timeout;
            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic2);
            anonymousClass12.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDataChange(BluetoothGattCharacteristic characteristic) {
        BLEHRParser.HRData hrData = this.hrParser.parseHrData(characteristic);
        int hr = hrData.getHr();
        List<Integer> listComponent2 = hrData.component2();
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(hr, "HR DATA ", getTag(), ": ", " ");
        sbM.append(listComponent2);
        Logger.logInfo(sbM.toString());
        long jCurrentTimeMillis = System.currentTimeMillis();
        float f = hr;
        this.dataLog.addHR(jCurrentTimeMillis, f);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        if (companion.getHR().isValid(f)) {
            ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
            HRCapability hr2 = companion.getHR();
            hr2.getClass();
            List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(hr2);
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(Float.valueOf(f), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Iterator<T> it2 = listComponent2.iterator();
        while (it2.hasNext()) {
            float fIntValue = ((Number) it2.next()).intValue();
            this.dataLog.addRR(jCurrentTimeMillis, fIntValue);
            Capabilities.Companion companion2 = Capabilities.INSTANCE;
            if (companion2.getRR().isValid(fIntValue)) {
                ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap2 = this.subscribers;
                RRCapability rr = companion2.getRR();
                rr.getClass();
                List<Function2<Object, Long, Unit>> list2 = concurrentHashMap2.get(rr);
                if (list2 != null) {
                    Iterator<T> it3 = list2.iterator();
                    while (it3.hasNext()) {
                        ((Function2) it3.next()).invoke(Float.valueOf(fIntValue), Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleNotificationsTimeout(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void start() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": start", null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21101(null), 3, null);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public boolean isStopped() {
        return this.stopped.get();
    }

    @Override // com.urbandroid.sleep.hr.ReceiverClient
    public void stop() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": stop", null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21111(null), 3, null);
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
}
