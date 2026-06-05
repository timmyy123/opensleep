package com.urbandroid.sleep.hr.berry;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import com.urbandroid.sleep.hr.Capabilities;
import com.urbandroid.sleep.hr.Capability;
import com.urbandroid.sleep.hr.HRCapability;
import com.urbandroid.sleep.hr.RRCapability;
import com.urbandroid.sleep.hr.ReceiverClient;
import com.urbandroid.sleep.hr.SPO2Capability;
import com.urbandroid.util.ScienceUtil;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u000bJG\u0010\u001e\u001a\u00020\t\"\u0004\b\u0000\u0010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\"\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001aj\b\u0012\u0004\u0012\u00028\u0000`\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101RH\u00105\u001a6\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u0018\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001aj\b\u0012\u0004\u0012\u000203`\u001c04028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R&\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180:8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010C\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/urbandroid/sleep/hr/berry/BerryOximeterSocketClient;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "", "start", "()V", "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/bluetooth/BluetoothSocket;", "socket", "(Landroid/bluetooth/BluetoothSocket;)V", "", "signalStrengthMin", "", "isWeakSignal", "(F)Z", "stop", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "Landroid/content/Context;", "Landroid/bluetooth/BluetoothDevice;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lkotlinx/coroutines/CompletableJob;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "btSocket", "Landroid/bluetooth/BluetoothSocket;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "subscribers", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "capabilities", "Ljava/util/Set;", "getCapabilities", "()Ljava/util/Set;", "", "packetNo", "I", "lastPulseBeep", "isStopped", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BerryOximeterSocketClient implements ReceiverClient, FeatureLogger {
    private BluetoothSocket btSocket;
    private final Set<Capability<Float>> capabilities;
    private final Context context;
    private final BluetoothDevice device;
    private int lastPulseBeep;
    private final Mutex mutex;
    private int packetNo;
    private final CoroutineScope scope;
    private final AtomicBoolean stopped;
    private final ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> subscribers;
    private final CompletableJob supervisorJob;
    private final String tag;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$readData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$readData$2", f = "BerryOximeterSocketClient.kt", l = {200}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BerryOximeterSocketClient.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BerryOximeterSocketClient berryOximeterSocketClient;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BerryOximeterSocketClient.this.mutex;
                BerryOximeterSocketClient berryOximeterSocketClient2 = BerryOximeterSocketClient.this;
                this.L$0 = mutex2;
                this.L$1 = berryOximeterSocketClient2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                berryOximeterSocketClient = berryOximeterSocketClient2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                berryOximeterSocketClient = (BerryOximeterSocketClient) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                if (berryOximeterSocketClient.btSocket == null) {
                    try {
                        berryOximeterSocketClient.btSocket = berryOximeterSocketClient.device.createInsecureRfcommSocketToServiceRecord(BerryConstants.INSTANCE.getBERRY_RFCOMM_CHANNEL_ID());
                    } catch (Exception e) {
                        Logger.logWarning(Logger.defaultTag, berryOximeterSocketClient.getTag() + ": BT socket creation failed.", e);
                    }
                }
                BluetoothSocket bluetoothSocket = berryOximeterSocketClient.btSocket;
                if (bluetoothSocket != null) {
                    try {
                        if (bluetoothSocket.isConnected()) {
                            berryOximeterSocketClient.readData(bluetoothSocket);
                        } else {
                            bluetoothSocket.connect();
                            Logger.logInfo(Logger.defaultTag, berryOximeterSocketClient.getTag() + ": BT socket connected", null);
                        }
                    } catch (Exception e2) {
                        Logger.logWarning(Logger.defaultTag, berryOximeterSocketClient.getTag() + ": BT socket failed.", e2);
                        try {
                            bluetoothSocket.close();
                        } catch (Exception unused) {
                        }
                        berryOximeterSocketClient.btSocket = null;
                    }
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$start$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$start$2", f = "BerryOximeterSocketClient.kt", l = {70}, m = "invokeSuspend", v = 2)
    public static final class C21092 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public C21092(Continuation<? super C21092> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BerryOximeterSocketClient.this.new C21092(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C21092) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!BerryOximeterSocketClient.this.isStopped()) {
                    BerryOximeterSocketClient berryOximeterSocketClient = BerryOximeterSocketClient.this;
                    this.label = 1;
                    if (berryOximeterSocketClient.readData(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$stop$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient$stop$1", f = "BerryOximeterSocketClient.kt", l = {200}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BerryOximeterSocketClient.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            BerryOximeterSocketClient berryOximeterSocketClient;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BerryOximeterSocketClient.this.mutex;
                BerryOximeterSocketClient berryOximeterSocketClient2 = BerryOximeterSocketClient.this;
                this.L$0 = mutex2;
                this.L$1 = berryOximeterSocketClient2;
                this.I$0 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                berryOximeterSocketClient = berryOximeterSocketClient2;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                berryOximeterSocketClient = (BerryOximeterSocketClient) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                berryOximeterSocketClient.stopped.set(true);
                berryOximeterSocketClient.subscribers.clear();
                try {
                    BluetoothSocket bluetoothSocket = berryOximeterSocketClient.btSocket;
                    if (bluetoothSocket != null) {
                        bluetoothSocket.close();
                    }
                } catch (Exception unused) {
                }
                JobKt__JobKt.cancelChildren$default(berryOximeterSocketClient.supervisorJob, null, 1, null);
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public BerryOximeterSocketClient(Context context, BluetoothDevice bluetoothDevice) {
        context.getClass();
        bluetoothDevice.getClass();
        this.context = context;
        this.device = bluetoothDevice;
        this.tag = "BerryOximeterSocketClient";
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJobSupervisorJob$default));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.subscribers = new ConcurrentHashMap<>();
        this.stopped = new AtomicBoolean(false);
        Capabilities.Companion companion = Capabilities.INSTANCE;
        this.capabilities = SetsKt.setOf((Object[]) new Capability[]{companion.getHR(), companion.getSPO2()});
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("HR DATA BerryOximeterSocketClient:"), FrequencyGuards.maxCountPerInterval(3, 1), 0, 4, null));
        start();
    }

    private final boolean isWeakSignal(float signalStrengthMin) {
        return signalStrengthMin < 3.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readData(BluetoothSocket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        byte[] bArr = new byte[2000];
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, Math.min(inputStream.read(bArr, 0, 2000), 2000)), 5);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                byte b = bArr[first];
                if ((b & 128) != 0) {
                    this.packetNo++;
                    float f = b & 15;
                    if (f > 7.0f) {
                        f = -1.0f;
                    }
                    arrayList3.add(Float.valueOf(f));
                    if ((b & 64) > 0) {
                        int i = this.lastPulseBeep;
                        if (i > 0) {
                            float f2 = (this.packetNo - i) * 10;
                            if (Capabilities.INSTANCE.getRR().isValid(f2)) {
                                arrayList4.add(Float.valueOf(f2));
                            }
                        }
                        this.lastPulseBeep = this.packetNo;
                    }
                    float f3 = ((bArr[first + 2] & 64) << 1) | bArr[first + 3];
                    Capabilities.Companion companion = Capabilities.INSTANCE;
                    if (companion.getHR().isValid(f3)) {
                        arrayList.add(Float.valueOf(f3));
                    }
                    float f4 = bArr[first + 4];
                    if (companion.getSPO2().isValid(f4)) {
                        arrayList2.add(Float.valueOf(f4));
                    }
                    if (first == last) {
                        break;
                    } else {
                        first += step;
                    }
                } else {
                    break;
                }
            }
        }
        float fAvg = ScienceUtil.avg(CollectionsKt.toFloatArray(arrayList));
        float fAvg2 = ScienceUtil.avg(CollectionsKt.toFloatArray(arrayList2));
        float fMin = ScienceUtil.min(CollectionsKt.toFloatArray(arrayList3));
        int size = arrayList2.size();
        StringBuilder sb = new StringBuilder("HR DATA BerryOximeterSocketClient: ");
        sb.append(fAvg);
        sb.append(" ");
        sb.append(fAvg2);
        sb.append(" ");
        sb.append(fMin);
        sb.append(" ");
        sb.append(arrayList4);
        sb.append(" ");
        zza$$ExternalSyntheticOutline0.m(sb, size);
        if (isWeakSignal(fMin)) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": weak signal, skipping", null);
            return;
        }
        float fRint = (float) Math.rint(fAvg);
        float fRint2 = (float) Math.rint(fAvg2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap = this.subscribers;
        HRCapability hr = Capabilities.INSTANCE.getHR();
        hr.getClass();
        List<Function2<Object, Long, Unit>> list = concurrentHashMap.get(hr);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(Float.valueOf(fRint), Long.valueOf(jCurrentTimeMillis));
            }
        }
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap2 = this.subscribers;
        SPO2Capability spo2 = Capabilities.INSTANCE.getSPO2();
        spo2.getClass();
        List<Function2<Object, Long, Unit>> list2 = concurrentHashMap2.get(spo2);
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                ((Function2) it2.next()).invoke(Float.valueOf(fRint2), Long.valueOf(jCurrentTimeMillis));
            }
        }
        ConcurrentHashMap<Capability<Object>, List<Function2<Object, Long, Unit>>> concurrentHashMap3 = this.subscribers;
        RRCapability rr = Capabilities.INSTANCE.getRR();
        rr.getClass();
        List<Function2<Object, Long, Unit>> list3 = concurrentHashMap3.get(rr);
        if (list3 != null) {
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                Function2 function2 = (Function2) it3.next();
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    function2.invoke(Float.valueOf(((Number) it4.next()).floatValue()), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
    }

    private final void start() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": start", null);
        BLEUtilKt.runWithFixedDelay(this.scope, 0L, 1000L, new HttpClientConfig$$ExternalSyntheticLambda4(6), new C21092(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean start$lambda$0() {
        return true;
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
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readData(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.scope.getCoroutineContext(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
