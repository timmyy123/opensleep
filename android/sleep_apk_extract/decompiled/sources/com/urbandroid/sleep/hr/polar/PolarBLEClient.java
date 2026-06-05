package com.urbandroid.sleep.hr.polar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Minutes;
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
import com.urbandroid.sleep.hr.RRCapability;
import com.urbandroid.sleep.hr.RawHrDataPersister;
import com.urbandroid.sleep.hr.ReceiverClient;
import com.urbandroid.sleep.hr.generic.BLEHRConstants;
import com.urbandroid.sleep.hr.generic.BLEHRParser;
import com.urbandroid.sleep.hr.polar.domain.AccData;
import com.urbandroid.sleep.hr.polar.domain.PpiData;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
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
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJG\u0010\u0015\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'H\u0082@¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020'H\u0002¢\u0006\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010-R\u001a\u0010.\u001a\u00020'8\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010,R\u0014\u00101\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00102R\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010JR\u0014\u0010L\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010JRH\u0010P\u001a6\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u000f\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020N`\u00130O0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR(\u0010V\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020N0\u000f0U8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006c"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/PolarBLEClient;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "", "initialConnectionAttemptsCount", "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;I)V", "", "stop", "()V", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "start", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "schedulePpiStreamRestart", "bleShutdownAndDisconnect", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "handleHrData", "(Landroid/bluetooth/BluetoothGattCharacteristic;)V", "Lcom/urbandroid/sleep/hr/polar/domain/AccData;", "data", "handleAccData", "(Lcom/urbandroid/sleep/hr/polar/domain/AccData;)V", "Lcom/urbandroid/sleep/hr/polar/domain/PpiData;", "handlePpiData", "(Lcom/urbandroid/sleep/hr/polar/domain/PpiData;)V", "", "info", "handleNotificationsTimeout", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInstanceId", "()Ljava/lang/String;", "I", "tag", "Ljava/lang/String;", "getTag", "timeout", "J", "reconnectDelay", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "bleClient", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "Lcom/urbandroid/sleep/hr/polar/PolarApiFacade;", "polarApi", "Lcom/urbandroid/sleep/hr/polar/PolarApiFacade;", "missingDataTimeout", "Ljava/util/concurrent/atomic/AtomicLong;", "lastFullReconnectAttempt", "Ljava/util/concurrent/atomic/AtomicLong;", "lastPpiRestartAttempt", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "hrTimeoutGuard", "Lcom/urbandroid/sleep/bluetoothle/TimeoutGuard;", "accTimeoutGuard", "ppiTimeoutGuard", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "subscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "capabilities", "Ljava/util/Set;", "getCapabilities", "()Ljava/util/Set;", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "hrParser", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "dataLog", "Lcom/urbandroid/sleep/hr/RawHrDataPersister;", "", "isStopped", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PolarBLEClient implements ReceiverClient, FeatureLogger {
    private final TimeoutGuard accTimeoutGuard;
    private final BLEClient bleClient;
    private final Set<Capability<? extends Object>> capabilities;
    private final RawHrDataPersister dataLog;
    private final BLEHRParser hrParser;
    private final TimeoutGuard hrTimeoutGuard;
    private final int initialConnectionAttemptsCount;
    private final AtomicLong lastFullReconnectAttempt;
    private final AtomicLong lastPpiRestartAttempt;
    private final long missingDataTimeout;
    private final Mutex mutex;
    private final PolarApiFacade polarApi;
    private final TimeoutGuard ppiTimeoutGuard;
    private final long reconnectDelay;
    private final CoroutineScope scope;
    private final AtomicBoolean stopped;
    private final ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> subscribers;
    private final CompletableJob supervisorJob;
    private final String tag;
    private final long timeout;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$bleShutdownAndDisconnect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient", f = "PolarBLEClient.kt", l = {186, 187, 188}, m = "bleShutdownAndDisconnect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarBLEClient.this.bleShutdownAndDisconnect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$connect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient", f = "PolarBLEClient.kt", l = {126, 128, 130, 133, 136, 137}, m = "connect", v = 2)
    public static final class C21281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21281(Continuation<? super C21281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarBLEClient.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$handleNotificationsTimeout$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient$handleNotificationsTimeout$2", f = "PolarBLEClient.kt", l = {294, 260, 262, 263}, m = "invokeSuspend", v = 2)
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
            return PolarBLEClient.this.new AnonymousClass2(this.$info, continuation);
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
          0x0129: PHI (r2v8 com.urbandroid.sleep.hr.polar.PolarBLEClient) = (r2v6 com.urbandroid.sleep.hr.polar.PolarBLEClient), (r2v15 com.urbandroid.sleep.hr.polar.PolarBLEClient) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r4v8 kotlinx.coroutines.sync.Mutex) = (r4v4 kotlinx.coroutines.sync.Mutex), (r4v16 kotlinx.coroutines.sync.Mutex) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r5v2 int) = (r5v1 int), (r5v7 int) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE]
          0x0129: PHI (r9v5 int) = (r9v4 int), (r9v11 int) binds: [B:43:0x0126, B:19:0x0045] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {Exception -> 0x013d, blocks: (B:45:0x0129, B:42:0x0114), top: B:59:0x0114 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            PolarBLEClient polarBLEClient;
            String str;
            int i;
            PolarBLEClient polarBLEClient2;
            long j;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = 0;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = PolarBLEClient.this.mutex;
                polarBLEClient = PolarBLEClient.this;
                str = this.$info;
                this.L$0 = mutex;
                this.L$1 = polarBLEClient;
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
                        PolarBLEClient polarBLEClient3 = (PolarBLEClient) this.L$1;
                        Mutex mutex3 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = i4;
                            polarBLEClient2 = polarBLEClient3;
                            i = i5;
                            mutex = mutex3;
                            this.L$0 = mutex;
                            this.L$1 = polarBLEClient2;
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.label = 4;
                        } catch (Exception e) {
                            e = e;
                            polarBLEClient2 = polarBLEClient3;
                            mutex2 = mutex3;
                            Logger.logWarning(Logger.defaultTag, polarBLEClient2.getTag() + ": reconnect", e);
                        } catch (Throwable th) {
                            th = th;
                            mutex2 = mutex3;
                        }
                    } else {
                        if (i2 != 4) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        polarBLEClient2 = (PolarBLEClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception e2) {
                                e = e2;
                                Logger.logWarning(Logger.defaultTag, polarBLEClient2.getTag() + ": reconnect", e);
                            }
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    Logger.logWarning(Logger.defaultTag, polarBLEClient2.getTag() + ": reconnect", e);
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                i3 = this.I$1;
                int i6 = this.I$0;
                PolarBLEClient polarBLEClient4 = (PolarBLEClient) this.L$1;
                Mutex mutex4 = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i = i6;
                    polarBLEClient2 = polarBLEClient4;
                    mutex = mutex4;
                    try {
                        j = polarBLEClient2.reconnectDelay;
                        this.L$0 = mutex;
                        this.L$1 = polarBLEClient2;
                        this.I$0 = i;
                        this.I$1 = i3;
                        this.label = 3;
                        if (DelayKt.delay(j, this) == coroutine_suspended) {
                            this.L$0 = mutex;
                            this.L$1 = polarBLEClient2;
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.label = 4;
                        }
                        return coroutine_suspended;
                    } catch (Exception e3) {
                        e = e3;
                        mutex2 = mutex;
                        Logger.logWarning(Logger.defaultTag, polarBLEClient2.getTag() + ": reconnect", e);
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
            polarBLEClient = (PolarBLEClient) this.L$1;
            Mutex mutex5 = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
            i = i7;
            mutex = mutex5;
            str = str2;
            if (!polarBLEClient.isStopped() && System.currentTimeMillis() - polarBLEClient.lastFullReconnectAttempt.get() >= polarBLEClient.missingDataTimeout) {
                polarBLEClient.lastFullReconnectAttempt.set(System.currentTimeMillis());
                String str3 = "Timeout - trying to reconnect. " + str + " " + polarBLEClient.getInstanceId();
                Logger.logInfo(Logger.defaultTag, polarBLEClient.getTag() + ": " + str3, null);
                this.L$0 = mutex;
                this.L$1 = polarBLEClient;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (polarBLEClient.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                    polarBLEClient2 = polarBLEClient;
                    j = polarBLEClient2.reconnectDelay;
                    this.L$0 = mutex;
                    this.L$1 = polarBLEClient2;
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$schedulePpiStreamRestart$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient$schedulePpiStreamRestart$2", f = "PolarBLEClient.kt", l = {294, 158, 159, 160}, m = "invokeSuspend", v = 2)
    public static final class C21292 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $ppiRestartInterval;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21292(long j, Continuation<? super C21292> continuation) {
            super(1, continuation);
            this.$ppiRestartInterval = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(PolarBLEClient polarBLEClient, PpiData ppiData) {
            polarBLEClient.handlePpiData(ppiData);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PolarBLEClient.this.new C21292(this.$ppiRestartInterval, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21292) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0109, code lost:
        
            if (r1.stopPpiStream(r18) == r2) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x014d, code lost:
        
            if (r7.startPpiStream(r8, r18) != r2) goto L51;
         */
        /* JADX WARN: Removed duplicated region for block: B:47:0x012e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            long j;
            PolarBLEClient polarBLEClient;
            int i;
            Mutex mutex2;
            long jMax;
            Mutex mutex3;
            int i2;
            long j2;
            int i3;
            PolarBLEClient polarBLEClient2;
            int i4;
            long j3;
            long j4;
            int i5;
            PolarBLEClient polarBLEClient3;
            Mutex mutex4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            try {
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = PolarBLEClient.this.mutex;
                    PolarBLEClient polarBLEClient4 = PolarBLEClient.this;
                    long j5 = this.$ppiRestartInterval;
                    this.L$0 = mutex;
                    this.L$1 = polarBLEClient4;
                    this.J$0 = j5;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        j = j5;
                        polarBLEClient = polarBLEClient4;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i6 == 1) {
                    int i7 = this.I$0;
                    long j6 = this.J$0;
                    polarBLEClient = (PolarBLEClient) this.L$1;
                    Mutex mutex5 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i7;
                    mutex = mutex5;
                    j = j6;
                } else {
                    if (i6 == 2) {
                        j2 = this.J$0;
                        i2 = this.I$1;
                        i3 = this.I$0;
                        polarBLEClient2 = (PolarBLEClient) this.L$1;
                        mutex3 = (Mutex) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Throwable th) {
                                th = th;
                                mutex2 = mutex3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        } catch (Exception unused) {
                        }
                        i4 = i3;
                        j3 = polarBLEClient2.reconnectDelay;
                        this.L$0 = mutex3;
                        this.L$1 = polarBLEClient2;
                        this.I$0 = i4;
                        this.I$1 = i2;
                        this.J$0 = j2;
                        this.label = 3;
                        if (DelayKt.delay(j3, this) != coroutine_suspended) {
                            j4 = j2;
                            i5 = i2;
                            polarBLEClient3 = polarBLEClient2;
                            mutex4 = mutex3;
                            PolarApiFacade polarApiFacade = polarBLEClient3.polarApi;
                            PolarBLEClient$$ExternalSyntheticLambda0 polarBLEClient$$ExternalSyntheticLambda0 = new PolarBLEClient$$ExternalSyntheticLambda0(polarBLEClient3, 1);
                            this.L$0 = mutex4;
                            this.L$1 = polarBLEClient3;
                            this.I$0 = i4;
                            this.I$1 = i5;
                            this.J$0 = j4;
                            this.label = 4;
                        }
                        return coroutine_suspended;
                    }
                    if (i6 != 3) {
                        if (i6 != 4) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        polarBLEClient3 = (PolarBLEClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Throwable th2) {
                                th = th2;
                                mutex2.unlock(null);
                                throw th;
                            }
                        } catch (Exception unused2) {
                        }
                        polarBLEClient3.lastPpiRestartAttempt.set(System.currentTimeMillis());
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    long j7 = this.J$0;
                    int i8 = this.I$1;
                    i4 = this.I$0;
                    PolarBLEClient polarBLEClient5 = (PolarBLEClient) this.L$1;
                    mutex4 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        j4 = j7;
                        i5 = i8;
                        polarBLEClient3 = polarBLEClient5;
                        try {
                            PolarApiFacade polarApiFacade2 = polarBLEClient3.polarApi;
                            PolarBLEClient$$ExternalSyntheticLambda0 polarBLEClient$$ExternalSyntheticLambda02 = new PolarBLEClient$$ExternalSyntheticLambda0(polarBLEClient3, 1);
                            this.L$0 = mutex4;
                            this.L$1 = polarBLEClient3;
                            this.I$0 = i4;
                            this.I$1 = i5;
                            this.J$0 = j4;
                            this.label = 4;
                        } catch (Exception unused3) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        mutex2 = mutex4;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                if (!polarBLEClient.isStopped() && polarBLEClient.polarApi.isPpiSupported()) {
                    jMax = Math.max(polarBLEClient.lastFullReconnectAttempt.get(), polarBLEClient.lastPpiRestartAttempt.get());
                    if (System.currentTimeMillis() - jMax >= j) {
                        String str = "PPI stream restart " + polarBLEClient.getInstanceId();
                        Logger.logInfo(Logger.defaultTag, polarBLEClient.getTag() + ": " + str, null);
                        try {
                            PolarApiFacade polarApiFacade3 = polarBLEClient.polarApi;
                            this.L$0 = mutex;
                            this.L$1 = polarBLEClient;
                            this.I$0 = i;
                            this.I$1 = 0;
                            this.J$0 = jMax;
                            this.label = 2;
                        } catch (Exception unused4) {
                        }
                    }
                }
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
                mutex2 = mutex4;
                polarBLEClient3.lastPpiRestartAttempt.set(System.currentTimeMillis());
                Unit unit22 = Unit.INSTANCE;
                mutex2.unlock(null);
                return Unit.INSTANCE;
                mutex3 = mutex;
                i2 = 0;
                j2 = jMax;
                i3 = i;
                polarBLEClient2 = polarBLEClient;
                i4 = i3;
                j3 = polarBLEClient2.reconnectDelay;
                this.L$0 = mutex3;
                this.L$1 = polarBLEClient2;
                this.I$0 = i4;
                this.I$1 = i2;
                this.J$0 = j2;
                this.label = 3;
                if (DelayKt.delay(j3, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                mutex2 = mutex;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient$start$1", f = "PolarBLEClient.kt", l = {294, 95, 100, 101}, m = "invokeSuspend", v = 2)
    public static final class C21301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public C21301(Continuation<? super C21301> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(PolarBLEClient polarBLEClient, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            polarBLEClient.handleHrData(bluetoothGattCharacteristic);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PolarBLEClient.this.new C21301(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
        
            if (r11.connect(r17) == r2) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0155, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r12, r17) != r2) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0162, code lost:
        
            r10 = r3;
            r3 = r9;
            r9 = r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:51:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x016a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0177 A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #1 {all -> 0x0031, blocks: (B:9:0x002c, B:47:0x0139, B:57:0x0171, B:59:0x0177, B:62:0x017d, B:64:0x0195, B:65:0x019c, B:30:0x00a4), top: B:72:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x017d A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #1 {all -> 0x0031, blocks: (B:9:0x002c, B:47:0x0139, B:57:0x0171, B:59:0x0177, B:62:0x017d, B:64:0x0195, B:65:0x019c, B:30:0x00a4), top: B:72:0x000e }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0155 -> B:50:0x0158). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            PolarBLEClient polarBLEClient;
            Mutex mutex;
            int i;
            int i2;
            Mutex mutex2;
            PolarBLEClient polarBLEClient2;
            int i3;
            Exception exc;
            int i4;
            int i5;
            int i6;
            PolarBLEClient polarBLEClient3;
            Mutex mutex3;
            int i7;
            int i8;
            int i9;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            int i11 = 0;
            int i12 = 2;
            int i13 = 1;
            try {
                try {
                    if (i10 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Mutex mutex4 = PolarBLEClient.this.mutex;
                        polarBLEClient = PolarBLEClient.this;
                        this.L$0 = mutex4;
                        this.L$1 = polarBLEClient;
                        this.I$0 = 0;
                        this.label = 1;
                        if (mutex4.lock(null, this) != coroutine_suspended) {
                            mutex = mutex4;
                            i = 0;
                        }
                        return coroutine_suspended;
                    }
                    if (i10 == 1) {
                        i = this.I$0;
                        polarBLEClient = (PolarBLEClient) this.L$1;
                        Mutex mutex5 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex5;
                    } else if (i10 == 2) {
                        i8 = this.I$3;
                        i13 = this.I$2;
                        i7 = this.I$1;
                        int i14 = this.I$0;
                        polarBLEClient2 = (PolarBLEClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e) {
                            exc = e;
                            i9 = i14;
                            String str = Logger.defaultTag;
                            Logger.logWarning(str, polarBLEClient2.getTag() + ": " + ("start connect " + i13), exc);
                            if (polarBLEClient2.isStopped() && i13 < polarBLEClient2.initialConnectionAttemptsCount) {
                                this.L$0 = mutex2;
                                this.L$1 = polarBLEClient2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(exc);
                                this.I$0 = i9;
                                this.I$1 = i7;
                                this.I$2 = i13;
                                this.I$3 = i8;
                                this.label = 3;
                                if (polarBLEClient2.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                                    int i15 = i7;
                                    i3 = i9;
                                    i6 = i8;
                                    i5 = i13;
                                    i4 = i15;
                                    Exception exc2 = exc;
                                    polarBLEClient3 = polarBLEClient2;
                                    mutex3 = mutex2;
                                    long j = polarBLEClient3.reconnectDelay;
                                    this.L$0 = mutex3;
                                    this.L$1 = polarBLEClient3;
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
                            if (!polarBLEClient2.isStopped()) {
                                i13++;
                                i12 = 2;
                                this.L$0 = mutex2;
                                this.L$1 = polarBLEClient2;
                                this.L$2 = null;
                                this.I$0 = i3;
                                this.I$1 = i11;
                                this.I$2 = i13;
                                this.I$3 = i2;
                                this.label = i12;
                            }
                        }
                        polarBLEClient = polarBLEClient2;
                        mutex = mutex2;
                        if (!polarBLEClient.isStopped()) {
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
                            polarBLEClient3 = (PolarBLEClient) this.L$1;
                            mutex3 = (Mutex) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            int i16 = i4;
                            i13 = i5;
                            i11 = i16;
                            mutex2 = mutex3;
                            polarBLEClient2 = polarBLEClient3;
                            i2 = i6;
                            if (!polarBLEClient2.isStopped() && i13 != i2) {
                                i13++;
                                i12 = 2;
                                try {
                                } catch (Exception e2) {
                                    int i17 = i2;
                                    exc = e2;
                                    i9 = i3;
                                    i7 = i11;
                                    i8 = i17;
                                    String str2 = Logger.defaultTag;
                                    Logger.logWarning(str2, polarBLEClient2.getTag() + ": " + ("start connect " + i13), exc);
                                    if (polarBLEClient2.isStopped()) {
                                        i2 = i8;
                                        i11 = i7;
                                        i3 = i9;
                                    }
                                    if (!polarBLEClient2.isStopped()) {
                                    }
                                    polarBLEClient = polarBLEClient2;
                                    mutex = mutex2;
                                    if (!polarBLEClient.isStopped()) {
                                    }
                                }
                                this.L$0 = mutex2;
                                this.L$1 = polarBLEClient2;
                                this.L$2 = null;
                                this.I$0 = i3;
                                this.I$1 = i11;
                                this.I$2 = i13;
                                this.I$3 = i2;
                                this.label = i12;
                            }
                            polarBLEClient = polarBLEClient2;
                            mutex = mutex2;
                            if (!polarBLEClient.isStopped()) {
                                Unit unit = Unit.INSTANCE;
                                mutex.unlock(null);
                                return unit;
                            }
                            polarBLEClient.hrTimeoutGuard.startAsyncCheck();
                            polarBLEClient.accTimeoutGuard.startAsyncCheck();
                            if (polarBLEClient.polarApi.isPpiSupported()) {
                                polarBLEClient.ppiTimeoutGuard.startAsyncCheck();
                            }
                            polarBLEClient.schedulePpiStreamRestart();
                            Unit unit2 = Unit.INSTANCE;
                            mutex.unlock(null);
                            return Unit.INSTANCE;
                        }
                        i6 = this.I$3;
                        i5 = this.I$2;
                        i4 = this.I$1;
                        i3 = this.I$0;
                        exc = (Exception) this.L$2;
                        polarBLEClient2 = (PolarBLEClient) this.L$1;
                        mutex2 = (Mutex) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Exception exc22 = exc;
                        polarBLEClient3 = polarBLEClient2;
                        mutex3 = mutex2;
                        long j2 = polarBLEClient3.reconnectDelay;
                        this.L$0 = mutex3;
                        this.L$1 = polarBLEClient3;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(exc22);
                        this.I$0 = i3;
                        this.I$1 = i4;
                        this.I$2 = i5;
                        this.I$3 = i6;
                        this.label = 4;
                    }
                    polarBLEClient.bleClient.addCharacteristicChangeListener(new PolarBLEClient$$ExternalSyntheticLambda0(polarBLEClient, i12));
                    i2 = polarBLEClient.initialConnectionAttemptsCount;
                    if (1 <= i2) {
                        mutex2 = mutex;
                        polarBLEClient2 = polarBLEClient;
                        i3 = i;
                        this.L$0 = mutex2;
                        this.L$1 = polarBLEClient2;
                        this.L$2 = null;
                        this.I$0 = i3;
                        this.I$1 = i11;
                        this.I$2 = i13;
                        this.I$3 = i2;
                        this.label = i12;
                    }
                    if (!polarBLEClient.isStopped()) {
                    }
                } catch (Throwable th) {
                    th = th;
                    mutex.unlock(null);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Mutex mutex6 = mutex2;
                mutex6.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarBLEClient$stop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarBLEClient$stop$1", f = "PolarBLEClient.kt", l = {294, 178}, m = "invokeSuspend", v = 2)
    public static final class C21311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public C21311(Continuation<? super C21311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PolarBLEClient.this.new C21311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            PolarBLEClient polarBLEClient;
            int i;
            Throwable th;
            Mutex mutex2;
            PolarBLEClient polarBLEClient2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = PolarBLEClient.this.mutex;
                    polarBLEClient = PolarBLEClient.this;
                    this.L$0 = mutex;
                    this.L$1 = polarBLEClient;
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
                    polarBLEClient2 = (PolarBLEClient) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        JobKt__JobKt.cancelChildren$default(polarBLEClient2.supervisorJob, null, 1, null);
                        polarBLEClient2.dataLog.stop();
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
                PolarBLEClient polarBLEClient3 = (PolarBLEClient) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i3;
                polarBLEClient = polarBLEClient3;
                mutex = mutex3;
                polarBLEClient.subscribers.clear();
                polarBLEClient.hrTimeoutGuard.stopAsyncCheck();
                polarBLEClient.accTimeoutGuard.stopAsyncCheck();
                polarBLEClient.ppiTimeoutGuard.stopAsyncCheck();
                this.L$0 = mutex;
                this.L$1 = polarBLEClient;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (polarBLEClient.bleShutdownAndDisconnect(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    polarBLEClient2 = polarBLEClient;
                    JobKt__JobKt.cancelChildren$default(polarBLEClient2.supervisorJob, null, 1, null);
                    polarBLEClient2.dataLog.stop();
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

    public PolarBLEClient(Context context, BluetoothDevice bluetoothDevice, int i) {
        context.getClass();
        bluetoothDevice.getClass();
        this.initialConnectionAttemptsCount = i;
        this.tag = "PolarBLEClient";
        this.timeout = 10000L;
        this.reconnectDelay = 2000L;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        BLEClient bLEClient = new BLEClient(context, bluetoothDevice);
        this.bleClient = bLEClient;
        this.polarApi = new PolarApiFacade(bLEClient);
        long j = 60000;
        this.missingDataTimeout = 60000L;
        this.lastFullReconnectAttempt = new AtomicLong(System.currentTimeMillis());
        this.lastPpiRestartAttempt = new AtomicLong(System.currentTimeMillis());
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Function0 function0 = null;
        this.hrTimeoutGuard = new TimeoutGuard(j, function0, new PolarBLEClient$hrTimeoutGuard$1(this, null), i2, defaultConstructorMarker);
        this.accTimeoutGuard = new TimeoutGuard(j, function0, new PolarBLEClient$accTimeoutGuard$1(this, null), i2, defaultConstructorMarker);
        this.ppiTimeoutGuard = new TimeoutGuard(j, function0, new PolarBLEClient$ppiTimeoutGuard$1(this, null), i2, defaultConstructorMarker);
        this.subscribers = new ConcurrentHashMap<>();
        this.stopped = new AtomicBoolean(false);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        this.capabilities = SetsKt.setOf((Object[]) new Capability[]{companion.getHR(), companion.getRR(), companion.getACCEL()});
        this.hrParser = new BLEHRParser();
        this.dataLog = new RawHrDataPersister(FileInsert$$ExternalSyntheticOutline0.m$1(bluetoothDevice.getName(), " ", bluetoothDevice.getAddress()));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("HR DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(5, 1), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("RR DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(5, 1), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("ACC DATA " + getTag() + ":"), FrequencyGuards.maxCountPerInterval(5, 1), 0, 4, null));
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r7.stopAccStream(r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if (r7.stopPpiStream(r0) == r1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        if (r7.disconnectSync(r4, r0) != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bleShutdownAndDisconnect(Continuation<? super Unit> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            PolarApiFacade polarApiFacade = this.polarApi;
            anonymousClass1.label = 1;
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            BLEClient bLEClient = this.bleClient;
            long j = this.timeout;
            anonymousClass1.label = 3;
        }
        if (this.polarApi.isPpiSupported()) {
            PolarApiFacade polarApiFacade2 = this.polarApi;
            anonymousClass1.label = 2;
        }
        BLEClient bLEClient2 = this.bleClient;
        long j2 = this.timeout;
        anonymousClass1.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
    
        if (r1.setNotificationEnabled(r2, true, r4, r6) != r0) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[PHI: r8
      0x00aa: PHI (r8v15 java.lang.Object) = (r8v14 java.lang.Object), (r8v1 java.lang.Object) binds: [B:34:0x00a7, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(Continuation<? super Unit> continuation) {
        C21281 c21281;
        PolarApiFacade polarApiFacade;
        PolarApiFacade polarApiFacade2;
        PolarBLEClient$$ExternalSyntheticLambda0 polarBLEClient$$ExternalSyntheticLambda0;
        if (continuation instanceof C21281) {
            c21281 = (C21281) continuation;
            int i = c21281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21281.label = i - Integer.MIN_VALUE;
            } else {
                c21281 = new C21281(continuation);
            }
        }
        C21281 c212812 = c21281;
        Object characteristic = c212812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 3;
        switch (c212812.label) {
            case 0:
                ResultKt.throwOnFailure(characteristic);
                BLEClient bLEClient = this.bleClient;
                long j = this.timeout;
                c212812.label = 1;
                if (bLEClient.connect(j, c212812) != coroutine_suspended) {
                    polarApiFacade = this.polarApi;
                    c212812.label = 2;
                    if (polarApiFacade.configure(c212812) != coroutine_suspended) {
                        polarApiFacade2 = this.polarApi;
                        polarBLEClient$$ExternalSyntheticLambda0 = new PolarBLEClient$$ExternalSyntheticLambda0(this, 0);
                        c212812.label = 3;
                        if (polarApiFacade2.startAccStream(polarBLEClient$$ExternalSyntheticLambda0, c212812) != coroutine_suspended) {
                            if (this.polarApi.isPpiSupported()) {
                                PolarApiFacade polarApiFacade3 = this.polarApi;
                                PolarBLEClient$$ExternalSyntheticLambda0 polarBLEClient$$ExternalSyntheticLambda02 = new PolarBLEClient$$ExternalSyntheticLambda0(this, i2);
                                c212812.label = 4;
                                if (polarApiFacade3.startPpiStream(polarBLEClient$$ExternalSyntheticLambda02, c212812) != coroutine_suspended) {
                                }
                            }
                            BLEClient bLEClient2 = this.bleClient;
                            BLEHRConstants.Companion companion = BLEHRConstants.INSTANCE;
                            UUID generic_hr_service_id = companion.getGENERIC_HR_SERVICE_ID();
                            UUID generic_hr_measurement_characteristic_id = companion.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID();
                            long j2 = this.timeout;
                            c212812.label = 5;
                            characteristic = bLEClient2.getCharacteristic(generic_hr_service_id, generic_hr_measurement_characteristic_id, j2, c212812);
                            if (characteristic != coroutine_suspended) {
                                BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristic;
                                BLEClient bLEClient3 = this.bleClient;
                                long j3 = this.timeout;
                                c212812.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                                c212812.label = 6;
                            }
                        }
                    }
                    break;
                }
                return coroutine_suspended;
            case 1:
                ResultKt.throwOnFailure(characteristic);
                polarApiFacade = this.polarApi;
                c212812.label = 2;
                if (polarApiFacade.configure(c212812) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                ResultKt.throwOnFailure(characteristic);
                polarApiFacade2 = this.polarApi;
                polarBLEClient$$ExternalSyntheticLambda0 = new PolarBLEClient$$ExternalSyntheticLambda0(this, 0);
                c212812.label = 3;
                if (polarApiFacade2.startAccStream(polarBLEClient$$ExternalSyntheticLambda0, c212812) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 3:
                ResultKt.throwOnFailure(characteristic);
                if (this.polarApi.isPpiSupported()) {
                }
                BLEClient bLEClient22 = this.bleClient;
                BLEHRConstants.Companion companion2 = BLEHRConstants.INSTANCE;
                UUID generic_hr_service_id2 = companion2.getGENERIC_HR_SERVICE_ID();
                UUID generic_hr_measurement_characteristic_id2 = companion2.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID();
                long j22 = this.timeout;
                c212812.label = 5;
                characteristic = bLEClient22.getCharacteristic(generic_hr_service_id2, generic_hr_measurement_characteristic_id2, j22, c212812);
                if (characteristic != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 4:
                ResultKt.throwOnFailure(characteristic);
                BLEClient bLEClient222 = this.bleClient;
                BLEHRConstants.Companion companion22 = BLEHRConstants.INSTANCE;
                UUID generic_hr_service_id22 = companion22.getGENERIC_HR_SERVICE_ID();
                UUID generic_hr_measurement_characteristic_id22 = companion22.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID();
                long j222 = this.timeout;
                c212812.label = 5;
                characteristic = bLEClient222.getCharacteristic(generic_hr_service_id22, generic_hr_measurement_characteristic_id22, j222, c212812);
                if (characteristic != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 5:
                ResultKt.throwOnFailure(characteristic);
                BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) characteristic;
                BLEClient bLEClient32 = this.bleClient;
                long j32 = this.timeout;
                c212812.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic2);
                c212812.label = 6;
                break;
            case 6:
                ResultKt.throwOnFailure(characteristic);
                return Unit.INSTANCE;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$0(PolarBLEClient polarBLEClient, AccData accData) {
        accData.getClass();
        polarBLEClient.handleAccData(accData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$1(PolarBLEClient polarBLEClient, PpiData ppiData) {
        ppiData.getClass();
        polarBLEClient.handlePpiData(ppiData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getInstanceId() {
        return String.valueOf(System.identityHashCode(this));
    }

    private final void handleAccData(AccData data2) {
        if (isStopped()) {
            return;
        }
        this.accTimeoutGuard.refresh();
        AccelBatch accelBatchMapAccelData = PolarBLEClientKt.mapAccelData(data2, this.polarApi.getAccelSampleRate());
        if (accelBatchMapAccelData.getPoints().size() >= 3) {
            Logger.logInfo("ACC DATA " + getTag() + ": " + accelBatchMapAccelData.getPoints().subList(0, 3));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
        AccelCapability accel = Capabilities.INSTANCE.getACCEL();
        accel.getClass();
        List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(accel);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(accelBatchMapAccelData, Long.valueOf(jCurrentTimeMillis));
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
        int iComponent1 = hrData.getHr();
        List<Integer> listComponent2 = hrData.component2();
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(iComponent1, "HR DATA ", getTag(), ": ", " ");
        sbM.append(listComponent2);
        Logger.logInfo(sbM.toString());
        long jCurrentTimeMillis = System.currentTimeMillis();
        float f = iComponent1;
        this.dataLog.addHR(jCurrentTimeMillis, f);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        if (companion.getHR().isValid(f)) {
            ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
            HRCapability hr = companion.getHR();
            hr.getClass();
            List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(hr);
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(Float.valueOf(f), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        if (this.polarApi.isPpiSupported()) {
            return;
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
    public final Object handleNotificationsTimeout(String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePpiData(PpiData data2) {
        if (isStopped()) {
            return;
        }
        this.ppiTimeoutGuard.refresh();
        if (data2.ppSamples.size() >= 3) {
            Logger.logInfo("RR DATA " + getTag() + ": " + data2.ppSamples.subList(0, 3));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<PpiData.PPSample> list = data2.ppSamples;
        list.getClass();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            float f = ((PpiData.PPSample) it.next()).ppInMs;
            this.dataLog.addRR(jCurrentTimeMillis, f);
            Capabilities.Companion companion = Capabilities.INSTANCE;
            if (companion.getRR().isValid(f)) {
                ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
                RRCapability rr = companion.getRR();
                rr.getClass();
                List<Function2<Object, Long, Unit>> list2 = concurrentHashMap.get(rr);
                if (list2 != null) {
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((Function2) it2.next()).invoke(Float.valueOf(f), Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void schedulePpiStreamRestart() {
        long jM984getMillisimpl = Minutes.m984getMillisimpl(Minutes.m982constructorimpl(18L));
        BLEUtilKt.runWithFixedDelay(this.scope, jM984getMillisimpl, Minutes.m984getMillisimpl(Minutes.m982constructorimpl(1L)), new HttpClientConfig$$ExternalSyntheticLambda4(8), new C21292(jM984getMillisimpl, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean schedulePpiStreamRestart$lambda$0() {
        return true;
    }

    private final void start() {
        String strM = FileInsert$$ExternalSyntheticOutline0.m("start ", getInstanceId());
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21301(null), 3, null);
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
        String strM = FileInsert$$ExternalSyntheticOutline0.m("stop ", getInstanceId());
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        this.stopped.set(true);
        JobKt__JobKt.cancelChildren$default(this.supervisorJob, null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C21311(null), 3, null);
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

    public /* synthetic */ PolarBLEClient(Context context, BluetoothDevice bluetoothDevice, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bluetoothDevice, (i2 & 4) != 0 ? 2 : i);
    }
}
