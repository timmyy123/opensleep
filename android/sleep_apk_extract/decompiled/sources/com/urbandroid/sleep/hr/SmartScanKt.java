package com.urbandroid.sleep.hr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.bluetoothle.BLEScanKt;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0098\u0001\u0010\u0010\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlin/Function3;", "Landroid/bluetooth/BluetoothDevice;", "Lkotlin/coroutines/Continuation;", "Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "", "detectDevice", "Lkotlin/Function1;", "", "onDiscovered", "onRecognized", "onUnrecognized", "Lkotlin/Function0;", "onFinished", "smartScan2", "(Lkotlinx/coroutines/CoroutineScope;Landroid/content/Context;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "unrecognizedDevice", "(Landroid/bluetooth/BluetoothDevice;)Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SmartScanKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.SmartScanKt$smartScan2$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.SmartScanKt$smartScan2$6", f = "SmartScan.kt", l = {243, 249}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<BluetoothDevice> $channel;
        final /* synthetic */ ConcurrentHashMap<BluetoothDevice, AtomicInteger> $devicesToTest;
        final /* synthetic */ Function1<BluetoothDevice, Unit> $onDiscovered;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(ReceiveChannel<BluetoothDevice> receiveChannel, Function1<? super BluetoothDevice, Unit> function1, ConcurrentHashMap<BluetoothDevice, AtomicInteger> concurrentHashMap, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$channel = receiveChannel;
            this.$onDiscovered = function1;
            this.$devicesToTest = concurrentHashMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$channel, this.$onDiscovered, this.$devicesToTest, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
        
            if (kotlinx.coroutines.YieldKt.yield(r10) == r0) goto L29;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:18:0x0043, B:22:0x0055, B:24:0x005d, B:26:0x0069, B:27:0x007c, B:30:0x008f, B:14:0x0031, B:17:0x0038), top: B:35:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008f A[Catch: Exception -> 0x0020, TRY_LEAVE, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:18:0x0043, B:22:0x0055, B:24:0x005d, B:26:0x0069, B:27:0x007c, B:30:0x008f, B:14:0x0031, B:17:0x0038), top: B:35:0x0009 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008c -> B:8:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Set linkedHashSet;
            ChannelIterator<BluetoothDevice> it;
            Set set;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                Logger.logInfo("smartScan: scan error: " + e.getClass().getName() + ": " + e.getMessage(), null);
                ReceiveChannel.cancel$default(this.$channel, null, 1, null);
            }
            if (i != 0) {
                if (i == 1) {
                    it = (ChannelIterator) this.L$1;
                    set = (Set) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (ChannelIterator) this.L$1;
                set = (Set) this.L$0;
                ResultKt.throwOnFailure(obj);
                linkedHashSet = set;
                this.L$0 = linkedHashSet;
                this.L$1 = it;
                this.L$2 = null;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                set = linkedHashSet;
                obj = objHasNext;
                if (((Boolean) obj).booleanValue()) {
                    Logger.logInfo("smartScan: scan finished", null);
                } else {
                    BluetoothDevice next = it.next();
                    if (!set.contains(next)) {
                        this.$onDiscovered.invoke(next);
                        set.add(next);
                        this.$devicesToTest.put(next, new AtomicInteger(0));
                    }
                    this.L$0 = set;
                    this.L$1 = it;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 2;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            linkedHashSet = new LinkedHashSet();
            it = this.$channel.iterator();
            this.L$0 = linkedHashSet;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.SmartScanKt$smartScan2$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.SmartScanKt$smartScan2$7", f = "SmartScan.kt", l = {261, 267, 281}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<BluetoothDevice> $channel;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> $detectDevice;
        final /* synthetic */ ConcurrentHashMap<BluetoothDevice, AtomicInteger> $devicesToTest;
        final /* synthetic */ Function0<Unit> $onFinished;
        final /* synthetic */ Function1<DeviceDetectionResult, Unit> $onRecognized;
        final /* synthetic */ Function1<DeviceDetectionResult, Unit> $onUnrecognized;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(ReceiveChannel<BluetoothDevice> receiveChannel, ConcurrentHashMap<BluetoothDevice, AtomicInteger> concurrentHashMap, Function3<? super Context, ? super BluetoothDevice, ? super Continuation<? super DeviceDetectionResult>, ? extends Object> function3, Context context, Function1<? super DeviceDetectionResult, Unit> function1, Function1<? super DeviceDetectionResult, Unit> function12, Function0<Unit> function0, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$channel = receiveChannel;
            this.$devicesToTest = concurrentHashMap;
            this.$detectDevice = function3;
            this.$context = context;
            this.$onRecognized = function1;
            this.$onUnrecognized = function12;
            this.$onFinished = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$channel, this.$devicesToTest, this.$detectDevice, this.$context, this.$onRecognized, this.$onUnrecognized, this.$onFinished, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Path cross not found for [B:44:0x00a2, B:68:0x0121], limit reached: 80 */
        /* JADX WARN: Path cross not found for [B:68:0x0121, B:44:0x00a2], limit reached: 80 */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:17:0x002e, B:59:0x00f2, B:61:0x00fa, B:68:0x0121, B:23:0x0042, B:25:0x004a, B:28:0x0053, B:30:0x005f, B:42:0x009d, B:44:0x00a2, B:45:0x00af, B:47:0x00b5, B:51:0x00ce, B:53:0x00d2, B:56:0x00dd, B:33:0x0076, B:36:0x0081, B:37:0x0088, B:40:0x0097, B:62:0x0105, B:64:0x010f, B:67:0x0117, B:8:0x0016, B:20:0x0036), top: B:77:0x000a, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0076 A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:17:0x002e, B:59:0x00f2, B:61:0x00fa, B:68:0x0121, B:23:0x0042, B:25:0x004a, B:28:0x0053, B:30:0x005f, B:42:0x009d, B:44:0x00a2, B:45:0x00af, B:47:0x00b5, B:51:0x00ce, B:53:0x00d2, B:56:0x00dd, B:33:0x0076, B:36:0x0081, B:37:0x0088, B:40:0x0097, B:62:0x0105, B:64:0x010f, B:67:0x0117, B:8:0x0016, B:20:0x0036), top: B:77:0x000a, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:17:0x002e, B:59:0x00f2, B:61:0x00fa, B:68:0x0121, B:23:0x0042, B:25:0x004a, B:28:0x0053, B:30:0x005f, B:42:0x009d, B:44:0x00a2, B:45:0x00af, B:47:0x00b5, B:51:0x00ce, B:53:0x00d2, B:56:0x00dd, B:33:0x0076, B:36:0x0081, B:37:0x0088, B:40:0x0097, B:62:0x0105, B:64:0x010f, B:67:0x0117, B:8:0x0016, B:20:0x0036), top: B:77:0x000a, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00fa A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:17:0x002e, B:59:0x00f2, B:61:0x00fa, B:68:0x0121, B:23:0x0042, B:25:0x004a, B:28:0x0053, B:30:0x005f, B:42:0x009d, B:44:0x00a2, B:45:0x00af, B:47:0x00b5, B:51:0x00ce, B:53:0x00d2, B:56:0x00dd, B:33:0x0076, B:36:0x0081, B:37:0x0088, B:40:0x0097, B:62:0x0105, B:64:0x010f, B:67:0x0117, B:8:0x0016, B:20:0x0036), top: B:77:0x000a, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[Catch: all -> 0x001a, Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:17:0x002e, B:59:0x00f2, B:61:0x00fa, B:68:0x0121, B:23:0x0042, B:25:0x004a, B:28:0x0053, B:30:0x005f, B:42:0x009d, B:44:0x00a2, B:45:0x00af, B:47:0x00b5, B:51:0x00ce, B:53:0x00d2, B:56:0x00dd, B:33:0x0076, B:36:0x0081, B:37:0x0088, B:40:0x0097, B:62:0x0105, B:64:0x010f, B:67:0x0117, B:8:0x0016, B:20:0x0036), top: B:77:0x000a, outer: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0131 -> B:23:0x0042). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object next;
            AtomicInteger atomicInteger;
            Object next2;
            BluetoothDevice bluetoothDevice;
            DeviceDetectionResult deviceDetectionResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i == 2) {
                            bluetoothDevice = (BluetoothDevice) this.L$1;
                            atomicInteger = (AtomicInteger) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            deviceDetectionResult = (DeviceDetectionResult) obj;
                            if (deviceDetectionResult.getRecognized()) {
                                this.$onRecognized.invoke(deviceDetectionResult);
                                this.$devicesToTest.remove(bluetoothDevice);
                            } else {
                                AtomicInteger atomicInteger2 = this.$devicesToTest.get(bluetoothDevice);
                                if ((atomicInteger2 != null ? atomicInteger2.incrementAndGet() : 0) >= 3) {
                                    this.$onUnrecognized.invoke(deviceDetectionResult);
                                    this.$devicesToTest.remove(bluetoothDevice);
                                }
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                            this.L$1 = null;
                            this.label = 3;
                            if (DelayKt.delay(50L, this) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i != 3) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    Logger.logInfo("smartScan: detection error: " + e.getClass().getName() + ": " + e.getMessage(), null);
                    ReceiveChannel.cancel$default(this.$channel, null, 1, null);
                }
                if (this.$channel.isClosedForReceive() && this.$devicesToTest.isEmpty()) {
                    Logger.logInfo("smartScan: detection finished", null);
                    return Unit.INSTANCE;
                }
                Collection<AtomicInteger> collectionValues = this.$devicesToTest.values();
                collectionValues.getClass();
                Iterator<T> it = collectionValues.iterator();
                if (it.hasNext()) {
                    next = null;
                } else {
                    next = it.next();
                    if (it.hasNext()) {
                        int i2 = ((AtomicInteger) next).get();
                        do {
                            Object next3 = it.next();
                            int i3 = ((AtomicInteger) next3).get();
                            if (i2 > i3) {
                                next = next3;
                                i2 = i3;
                            }
                        } while (it.hasNext());
                    }
                }
                atomicInteger = (AtomicInteger) next;
                if (atomicInteger != null) {
                    Set<Map.Entry<BluetoothDevice, AtomicInteger>> setEntrySet = this.$devicesToTest.entrySet();
                    setEntrySet.getClass();
                    Iterator<T> it2 = setEntrySet.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (((AtomicInteger) ((Map.Entry) next2).getValue()).get() == atomicInteger.get()) {
                            break;
                        }
                    }
                    Map.Entry entry = (Map.Entry) next2;
                    bluetoothDevice = entry != null ? (BluetoothDevice) entry.getKey() : null;
                    if (bluetoothDevice != null) {
                        Function3<Context, BluetoothDevice, Continuation<? super DeviceDetectionResult>, Object> function3 = this.$detectDevice;
                        Context context = this.$context;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                        this.L$1 = bluetoothDevice;
                        this.label = 2;
                        obj = function3.invoke(context, bluetoothDevice, this);
                        if (obj == coroutine_suspended) {
                        }
                        deviceDetectionResult = (DeviceDetectionResult) obj;
                        if (deviceDetectionResult.getRecognized()) {
                        }
                    }
                    return coroutine_suspended;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                this.L$1 = null;
                this.label = 3;
                if (DelayKt.delay(50L, this) != coroutine_suspended) {
                    if (this.$channel.isClosedForReceive()) {
                        Logger.logInfo("smartScan: detection finished", null);
                        return Unit.INSTANCE;
                    }
                    Collection<AtomicInteger> collectionValues2 = this.$devicesToTest.values();
                    collectionValues2.getClass();
                    Iterator<T> it3 = collectionValues2.iterator();
                    if (it3.hasNext()) {
                    }
                    atomicInteger = (AtomicInteger) next;
                    if (atomicInteger != null) {
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(atomicInteger);
                    this.L$1 = null;
                    this.label = 3;
                    if (DelayKt.delay(50L, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } finally {
                this.$onFinished.invoke();
            }
        }
    }

    public static final Object smartScan2(CoroutineScope coroutineScope, Context context, Function3<? super Context, ? super BluetoothDevice, ? super Continuation<? super DeviceDetectionResult>, ? extends Object> function3, Function1<? super BluetoothDevice, Unit> function1, Function1<? super DeviceDetectionResult, Unit> function12, Function1<? super DeviceDetectionResult, Unit> function13, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ReceiveChannel receiveChannelBleScan$default = BLEScanKt.bleScan$default(coroutineScope, context, 0, 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass6(receiveChannelBleScan$default, function1, concurrentHashMap, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new AnonymousClass7(receiveChannelBleScan$default, concurrentHashMap, function3, context, function12, function13, function0, null), 2, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object smartScan2$default(CoroutineScope coroutineScope, Context context, Function3 function3, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new AiPrompt$$ExternalSyntheticLambda0(16);
        }
        Function1 function14 = function1;
        if ((i & 8) != 0) {
            function12 = new AiPrompt$$ExternalSyntheticLambda0(17);
        }
        Function1 function15 = function12;
        if ((i & 16) != 0) {
            function13 = new AiPrompt$$ExternalSyntheticLambda0(18);
        }
        return smartScan2(coroutineScope, context, function3, function14, function15, function13, (i & 32) != 0 ? new HttpClientConfig$$ExternalSyntheticLambda4(5) : function0, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smartScan2$lambda$0(BluetoothDevice bluetoothDevice) {
        bluetoothDevice.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smartScan2$lambda$1(DeviceDetectionResult deviceDetectionResult) {
        deviceDetectionResult.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smartScan2$lambda$2(DeviceDetectionResult deviceDetectionResult) {
        deviceDetectionResult.getClass();
        return Unit.INSTANCE;
    }

    public static final DeviceDetectionResult unrecognizedDevice(BluetoothDevice bluetoothDevice) {
        bluetoothDevice.getClass();
        return new DeviceDetectionResult(bluetoothDevice, false, "UNRECOGNIZED", new AiPrompt$$ExternalSyntheticLambda0(15));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient unrecognizedDevice$lambda$0(Context context) {
        context.getClass();
        throw new IllegalStateException("Unrecognized device");
    }
}
