package com.urbandroid.sleep.hr;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEClient;
import com.urbandroid.sleep.bluetoothle.GattServices;
import com.urbandroid.sleep.hr.berry.BerryConstants;
import com.urbandroid.sleep.hr.berry.BerryOximeterBLEClient;
import com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient;
import com.urbandroid.sleep.hr.generic.BLEHRClient;
import com.urbandroid.sleep.hr.generic.BLEHRConstants;
import com.urbandroid.sleep.hr.pinetime.PineTimeBLEClient;
import com.urbandroid.sleep.hr.pinetime.PineTimeConstants;
import com.urbandroid.sleep.hr.polar.PolarBLEClient;
import com.urbandroid.sleep.hr.polar.PolarConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/hr/DetectDevice;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "detectHrDevice", "(Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectAccelDevice", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DetectDevice {
    public static final DetectDevice INSTANCE = new DetectDevice();

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.DetectDevice$detectAccelDevice$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.DetectDevice", f = "SmartScan.kt", l = {118, 120, 152, 152, 152, 152, 152}, m = "detectAccelDevice", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DetectDevice.this.detectAccelDevice(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.DetectDevice$detectHrDevice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.DetectDevice", f = "SmartScan.kt", l = {54, 56, 81, 81, 81, 81, 81}, m = "detectHrDevice", v = 2)
    public static final class C21061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C21061(Continuation<? super C21061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DetectDevice.this.detectHrDevice(null, null, this);
        }
    }

    static {
        Logger.addFilter(Filters.filter$default(Matchers.startsWith("detectDevice:"), FrequencyGuards.maxCountPerInterval(60, 200), 0, 4, null));
    }

    private DetectDevice() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient detectAccelDevice$lambda$0(BluetoothDevice bluetoothDevice, Context context) {
        context.getClass();
        return new PolarBLEClient(context, bluetoothDevice, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient detectAccelDevice$lambda$1(BluetoothDevice bluetoothDevice, Context context) {
        context.getClass();
        return new PineTimeBLEClient(context, bluetoothDevice, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient detectHrDevice$lambda$0(BluetoothDevice bluetoothDevice, Context context) {
        context.getClass();
        return new BerryOximeterBLEClient(context, bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient detectHrDevice$lambda$1(BluetoothDevice bluetoothDevice, Context context) {
        context.getClass();
        return new BLEHRClient(context, bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiverClient detectHrDevice$lambda$2$0(BluetoothDevice bluetoothDevice, Context context) {
        context.getClass();
        return new BerryOximeterSocketClient(context, bluetoothDevice);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0253, code lost:
    
        if (r14.disconnectSync(10000, r0) == r15) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0257, code lost:
    
        r14 = r1;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02c1, code lost:
    
        if (r14.disconnectSync(10000, r0) == r15) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01de A[Catch: all -> 0x01c4, Exception -> 0x0232, TRY_LEAVE, TryCatch #0 {all -> 0x01c4, blocks: (B:36:0x012e, B:37:0x0144, B:39:0x0154, B:41:0x0162, B:43:0x0172, B:54:0x01ce, B:56:0x01de, B:66:0x0233, B:84:0x0279, B:53:0x01cb), top: B:98:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02e3  */
    /* JADX WARN: Type inference failed for: r12v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v19, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v41 */
    /* JADX WARN: Type inference failed for: r13v42 */
    /* JADX WARN: Type inference failed for: r13v43 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v16, types: [com.urbandroid.sleep.bluetoothle.BLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.urbandroid.sleep.bluetoothle.BLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v4, types: [com.urbandroid.sleep.bluetoothle.BLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.bluetooth.BluetoothDevice, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.bluetooth.BluetoothDevice] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectAccelDevice(Context context, BluetoothDevice bluetoothDevice, Continuation<? super DeviceDetectionResult> continuation) {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        Object obj;
        ?? r14;
        ?? r142;
        ?? r13;
        Context context2;
        ?? r1;
        ?? r132;
        ?? r12;
        ?? r133;
        ?? r15;
        BLEClient bLEClient;
        BluetoothDevice bluetoothDevice2;
        String str;
        Object objDiscoverServices;
        GattServices gattServices;
        PineTimeConstants.Companion companion;
        DeviceDetectionResult deviceDetectionResult;
        PolarConstants.Companion companion2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r16 = anonymousClass1.label;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
                obj = context;
                r1 = r16;
                r14 = bluetoothDevice;
            }
        } catch (Exception e) {
            e = e;
            r142 = context;
            r13 = bluetoothDevice;
        } catch (Throwable th3) {
            th = th3;
            obj = bluetoothDevice;
            r14 = context;
            r1 = r16;
        }
        switch (r16) {
            case 0:
                ResultKt.throwOnFailure(obj2);
                String str2 = "detectDevice: ACC:";
                Logger.logInfo("detectDevice: ACC: " + bluetoothDevice.getAddress() + " " + bluetoothDevice.getName(), null);
                BLEClient bLEClient2 = new BLEClient(context, bluetoothDevice);
                try {
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                    anonymousClass1.L$1 = bluetoothDevice;
                    anonymousClass1.L$2 = "detectDevice: ACC:";
                    anonymousClass1.L$3 = bLEClient2;
                    anonymousClass1.label = 1;
                    break;
                } catch (Exception e2) {
                    r16 = bluetoothDevice;
                    r142 = bLEClient2;
                    context2 = context;
                    r13 = "detectDevice: ACC:";
                    e = e2;
                    Logger.logInfo(r13 + " BLE: " + e.getClass().getName() + ": " + e.getMessage(), null);
                    r15 = r16;
                    r133 = r13;
                    if (r142.isConnected()) {
                    }
                    Logger.logInfo(r133 + " unrecognized", null);
                    return SmartScanKt.unrecognizedDevice(r15);
                } catch (Throwable th4) {
                    r1 = bluetoothDevice;
                    r14 = bLEClient2;
                    context2 = context;
                    th = th4;
                    obj = str2;
                    if (r14.isConnected()) {
                        throw th;
                    }
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(r1);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(r14);
                    anonymousClass1.L$4 = th;
                    anonymousClass1.label = 7;
                    if (r14.disconnectSync(10000L, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    throw th;
                }
                if (bLEClient2.connect(10000L, anonymousClass1) != coroutine_suspended) {
                    context2 = context;
                    bLEClient = bLEClient2;
                    str = str2;
                    bluetoothDevice2 = bluetoothDevice;
                    try {
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        anonymousClass1.L$1 = bluetoothDevice2;
                        anonymousClass1.L$2 = str;
                        anonymousClass1.L$3 = bLEClient;
                        anonymousClass1.label = 2;
                        objDiscoverServices = bLEClient.discoverServices(10000L, anonymousClass1);
                        break;
                    } catch (Exception e3) {
                        BLEClient bLEClient3 = bLEClient;
                        r13 = str;
                        e = e3;
                        r16 = bluetoothDevice2;
                        r142 = bLEClient3;
                        Logger.logInfo(r13 + " BLE: " + e.getClass().getName() + ": " + e.getMessage(), null);
                        r15 = r16;
                        r133 = r13;
                        if (r142.isConnected()) {
                        }
                        Logger.logInfo(r133 + " unrecognized", null);
                        return SmartScanKt.unrecognizedDevice(r15);
                    } catch (Throwable th5) {
                        BluetoothDevice bluetoothDevice3 = bluetoothDevice2;
                        r14 = bLEClient;
                        th = th5;
                        r1 = bluetoothDevice3;
                        obj = str;
                        if (r14.isConnected()) {
                        }
                    }
                    if (objDiscoverServices != coroutine_suspended) {
                        BLEClient bLEClient4 = bLEClient;
                        r13 = str;
                        obj2 = objDiscoverServices;
                        r16 = bluetoothDevice2;
                        r142 = bLEClient4;
                        try {
                            gattServices = (GattServices) obj2;
                            Logger.logInfo(r13 + " services discovered", null);
                            try {
                                companion2 = PolarConstants.INSTANCE;
                            } catch (Exception e4) {
                                Logger.logSevere(null, e4);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            Logger.logInfo(r13 + " BLE: " + e.getClass().getName() + ": " + e.getMessage(), null);
                            r15 = r16;
                            r133 = r13;
                            if (r142.isConnected()) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                anonymousClass1.L$1 = r16;
                                anonymousClass1.L$2 = r13;
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(r142);
                                anonymousClass1.label = 6;
                                r12 = r16;
                                r132 = r13;
                            }
                            break;
                        }
                        if (gattServices.contains(companion2.getPOLAR_PMD_SERVICE_ID(), companion2.getPOLAR_PMD_CONTROL_CHARACTERISTIC_ID()) || !gattServices.contains(companion2.getPOLAR_PMD_SERVICE_ID(), companion2.getPOLAR_PMD_DATA_MTU_CHARACTERISTIC_ID())) {
                            try {
                                companion = PineTimeConstants.INSTANCE;
                            } catch (Exception e6) {
                                Logger.logSevere(null, e6);
                            }
                            if (gattServices.contains(companion.getPINE_TIME_ACCEL_SERVICE_ID(), companion.getPINE_TIME_ACCEL_CHARACTERISTIC_ID())) {
                                r15 = r16;
                                r133 = r13;
                                if (r142.isConnected()) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    anonymousClass1.L$1 = r16;
                                    anonymousClass1.L$2 = r13;
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(r142);
                                    anonymousClass1.label = 5;
                                    r12 = r16;
                                    r132 = r13;
                                    break;
                                }
                                Logger.logInfo(r133 + " unrecognized", null);
                                return SmartScanKt.unrecognizedDevice(r15);
                            }
                            Logger.logInfo(r13 + " recognized PineTime", null);
                            DeviceDetectionResult deviceDetectionResult2 = new DeviceDetectionResult(r16, true, "PineTime InfiniTime 1.9.0+", new DetectDevice$$ExternalSyntheticLambda0(r16, 4));
                            if (!r142.isConnected()) {
                                return deviceDetectionResult2;
                            }
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(r16);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(r13);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(r142);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(gattServices);
                            anonymousClass1.L$5 = deviceDetectionResult2;
                            anonymousClass1.label = 4;
                            if (r142.disconnectSync(10000L, anonymousClass1) != coroutine_suspended) {
                                deviceDetectionResult = deviceDetectionResult2;
                                return deviceDetectionResult;
                            }
                            break;
                        } else {
                            BLEHRConstants.Companion companion3 = BLEHRConstants.INSTANCE;
                            if (gattServices.contains(companion3.getGENERIC_HR_SERVICE_ID(), companion3.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID())) {
                                Logger.logInfo(r13 + " recognized New Polar", null);
                                DeviceDetectionResult deviceDetectionResult3 = new DeviceDetectionResult(r16, true, "New Polar (H10, OH1)", new DetectDevice$$ExternalSyntheticLambda0(r16, 3));
                                if (r142.isConnected()) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(r16);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(r13);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(r142);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(gattServices);
                                    anonymousClass1.L$5 = deviceDetectionResult3;
                                    anonymousClass1.label = 3;
                                    if (r142.disconnectSync(10000L, anonymousClass1) == coroutine_suspended) {
                                    }
                                }
                                return deviceDetectionResult3;
                            }
                        }
                        r15 = ;
                        r133 = ;
                        Logger.logInfo(r133 + " unrecognized", null);
                        return SmartScanKt.unrecognizedDevice(r15);
                    }
                }
                return coroutine_suspended;
            case 1:
                bLEClient = (BLEClient) anonymousClass1.L$3;
                String str3 = (String) anonymousClass1.L$2;
                BluetoothDevice bluetoothDevice4 = (BluetoothDevice) anonymousClass1.L$1;
                context2 = (Context) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                str = str3;
                bluetoothDevice2 = bluetoothDevice4;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                anonymousClass1.L$1 = bluetoothDevice2;
                anonymousClass1.L$2 = str;
                anonymousClass1.L$3 = bLEClient;
                anonymousClass1.label = 2;
                objDiscoverServices = bLEClient.discoverServices(10000L, anonymousClass1);
                if (objDiscoverServices != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                BLEClient bLEClient5 = (BLEClient) anonymousClass1.L$3;
                String str4 = (String) anonymousClass1.L$2;
                BluetoothDevice bluetoothDevice5 = (BluetoothDevice) anonymousClass1.L$1;
                context2 = (Context) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                r142 = bLEClient5;
                r13 = str4;
                r16 = bluetoothDevice5;
                gattServices = (GattServices) obj2;
                Logger.logInfo(r13 + " services discovered", null);
                companion2 = PolarConstants.INSTANCE;
                if (gattServices.contains(companion2.getPOLAR_PMD_SERVICE_ID(), companion2.getPOLAR_PMD_CONTROL_CHARACTERISTIC_ID())) {
                    companion = PineTimeConstants.INSTANCE;
                    if (gattServices.contains(companion.getPINE_TIME_ACCEL_SERVICE_ID(), companion.getPINE_TIME_ACCEL_CHARACTERISTIC_ID())) {
                    }
                    return coroutine_suspended;
                }
                r15 = ;
                r133 = ;
                Logger.logInfo(r133 + " unrecognized", null);
                return SmartScanKt.unrecognizedDevice(r15);
            case 3:
                DeviceDetectionResult deviceDetectionResult4 = (DeviceDetectionResult) anonymousClass1.L$5;
                ResultKt.throwOnFailure(obj2);
                return deviceDetectionResult4;
            case 4:
                deviceDetectionResult = (DeviceDetectionResult) anonymousClass1.L$5;
                ResultKt.throwOnFailure(obj2);
                return deviceDetectionResult;
            case 5:
            case 6:
                String str5 = (String) anonymousClass1.L$2;
                BluetoothDevice bluetoothDevice6 = (BluetoothDevice) anonymousClass1.L$1;
                ResultKt.throwOnFailure(obj2);
                ?? r134 = str5;
                ?? r143 = bluetoothDevice6;
                r15 = r143;
                r133 = r134;
                Logger.logInfo(r133 + " unrecognized", null);
                return SmartScanKt.unrecognizedDevice(r15);
            case 7:
                Throwable th6 = (Throwable) anonymousClass1.L$4;
                ResultKt.throwOnFailure(obj2);
                throw th6;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a A[Catch: all -> 0x0097, Exception -> 0x00a0, PHI: r0 r1 r4 r12 r13
      0x011a: PHI (r0v52 java.lang.Object) = (r0v51 java.lang.Object), (r0v1 java.lang.Object) binds: [B:32:0x0116, B:17:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r1v14 com.urbandroid.sleep.bluetoothle.BLEClient) = (r1v11 com.urbandroid.sleep.bluetoothle.BLEClient), (r1v16 com.urbandroid.sleep.bluetoothle.BLEClient) binds: [B:32:0x0116, B:17:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r4v12 java.lang.String) = (r4v9 java.lang.String), (r4v20 java.lang.String) binds: [B:32:0x0116, B:17:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r12v12 android.bluetooth.BluetoothDevice) = (r12v9 android.bluetooth.BluetoothDevice), (r12v14 android.bluetooth.BluetoothDevice) binds: [B:32:0x0116, B:17:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r13v7 android.content.Context) = (r13v4 android.content.Context), (r13v9 android.content.Context) binds: [B:32:0x0116, B:17:0x0092] A[DONT_GENERATE, DONT_INLINE], TryCatch #8 {Exception -> 0x00a0, all -> 0x0097, blocks: (B:17:0x0092, B:34:0x011a, B:36:0x0140, B:43:0x0193, B:45:0x01a3, B:52:0x01f6, B:24:0x00b8, B:31:0x0104), top: B:123:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140 A[Catch: all -> 0x0097, Exception -> 0x00a0, TRY_LEAVE, TryCatch #8 {Exception -> 0x00a0, all -> 0x0097, blocks: (B:17:0x0092, B:34:0x011a, B:36:0x0140, B:43:0x0193, B:45:0x01a3, B:52:0x01f6, B:24:0x00b8, B:31:0x0104), top: B:123:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0193 A[Catch: all -> 0x0097, Exception -> 0x00a0, TRY_ENTER, TryCatch #8 {Exception -> 0x00a0, all -> 0x0097, blocks: (B:17:0x0092, B:34:0x011a, B:36:0x0140, B:43:0x0193, B:45:0x01a3, B:52:0x01f6, B:24:0x00b8, B:31:0x0104), top: B:123:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.urbandroid.sleep.bluetoothle.BLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.urbandroid.sleep.bluetoothle.BLEClient, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectHrDevice(Context context, BluetoothDevice bluetoothDevice, Continuation<? super DeviceDetectionResult> continuation) {
        C21061 c21061;
        Throwable th;
        ?? r0;
        ?? r4;
        ?? r42;
        ?? r1;
        BluetoothDevice bluetoothDevice2;
        BluetoothDevice bluetoothDevice3;
        ?? r12;
        String name;
        String lowerCase;
        Throwable th2;
        ?? r13;
        String str;
        Context context2;
        BluetoothDevice bluetoothDevice4;
        BLEClient bLEClient;
        GattServices gattServices;
        BerryConstants.Companion companion;
        if (continuation instanceof C21061) {
            c21061 = (C21061) continuation;
            int i = c21061.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21061.label = i - Integer.MIN_VALUE;
            } else {
                c21061 = new C21061(continuation);
            }
        }
        Object objDiscoverServices = c21061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r43 = c21061.label;
        int i2 = 1;
        try {
        } catch (Exception e) {
            e = e;
            r42 = bluetoothDevice;
            r1 = r43;
        } catch (Throwable th3) {
            th = th3;
            r0 = r43;
            r4 = bluetoothDevice;
        }
        switch (r43) {
            case 0:
                ResultKt.throwOnFailure(objDiscoverServices);
                str = "detectDevice: HR:";
                Logger.logInfo("detectDevice: HR: " + bluetoothDevice.getAddress() + " " + bluetoothDevice.getName(), null);
                context2 = context;
                BLEClient bLEClient2 = new BLEClient(context2, bluetoothDevice);
                try {
                    c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                    c21061.L$1 = bluetoothDevice;
                    c21061.L$2 = "detectDevice: HR:";
                    c21061.L$3 = bLEClient2;
                    c21061.label = 1;
                    if (bLEClient2.connect(10000L, c21061) != coroutine_suspended) {
                        bluetoothDevice4 = bluetoothDevice;
                        bLEClient = bLEClient2;
                        c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c21061.L$1 = bluetoothDevice4;
                        c21061.L$2 = str;
                        c21061.L$3 = bLEClient;
                        c21061.label = 2;
                        objDiscoverServices = bLEClient.discoverServices(10000L, c21061);
                        if (objDiscoverServices == coroutine_suspended) {
                            gattServices = (GattServices) objDiscoverServices;
                            Logger.logInfo(str + " services discovered", null);
                            companion = BerryConstants.INSTANCE;
                            if (!gattServices.contains(companion.getBERRY_SERVICE_ID(), companion.getBERRY_CHARACTERISTIC_ID())) {
                                Logger.logInfo(str + " recognized Berry BLE oximeter", null);
                                DeviceDetectionResult deviceDetectionResult = new DeviceDetectionResult(bluetoothDevice4, true, "Berry BLE oximeter", new DetectDevice$$ExternalSyntheticLambda0(bluetoothDevice4, 0));
                                if (bLEClient.isConnected()) {
                                    c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    c21061.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice4);
                                    c21061.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                    c21061.L$3 = SpillingKt.nullOutSpilledVariable(bLEClient);
                                    c21061.L$4 = SpillingKt.nullOutSpilledVariable(gattServices);
                                    c21061.L$5 = deviceDetectionResult;
                                    c21061.label = 3;
                                    if (bLEClient.disconnectSync(10000L, c21061) == coroutine_suspended) {
                                    }
                                }
                                return deviceDetectionResult;
                            }
                            BLEHRConstants.Companion companion2 = BLEHRConstants.INSTANCE;
                            if (gattServices.contains(companion2.getGENERIC_HR_SERVICE_ID(), companion2.getGENERIC_HR_MEASUREMENT_CHARACTERISTIC_ID())) {
                                Logger.logInfo(str + " recognized Generic BLE HR", null);
                                DeviceDetectionResult deviceDetectionResult2 = new DeviceDetectionResult(bluetoothDevice4, true, "Generic BLE HR", new DetectDevice$$ExternalSyntheticLambda0(bluetoothDevice4, i2));
                                if (bLEClient.isConnected()) {
                                    c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    c21061.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice4);
                                    c21061.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                    c21061.L$3 = SpillingKt.nullOutSpilledVariable(bLEClient);
                                    c21061.L$4 = SpillingKt.nullOutSpilledVariable(gattServices);
                                    c21061.L$5 = deviceDetectionResult2;
                                    c21061.label = 4;
                                    if (bLEClient.disconnectSync(10000L, c21061) == coroutine_suspended) {
                                    }
                                }
                                return deviceDetectionResult2;
                            }
                            Logger.logInfo(str + " unrecognized", null);
                            DeviceDetectionResult deviceDetectionResultUnrecognizedDevice = SmartScanKt.unrecognizedDevice(bluetoothDevice4);
                            if (bLEClient.isConnected()) {
                                c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                c21061.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice4);
                                c21061.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                c21061.L$3 = SpillingKt.nullOutSpilledVariable(bLEClient);
                                c21061.L$4 = SpillingKt.nullOutSpilledVariable(gattServices);
                                c21061.L$5 = deviceDetectionResultUnrecognizedDevice;
                                c21061.label = 5;
                                if (bLEClient.disconnectSync(10000L, c21061) == coroutine_suspended) {
                                }
                            }
                            return deviceDetectionResultUnrecognizedDevice;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bluetoothDevice2 = bluetoothDevice;
                    r1 = "detectDevice: HR:";
                    r42 = bLEClient2;
                    try {
                        Logger.logInfo(r1 + " BLE: " + e.getClass().getName() + ": " + e.getMessage(), null);
                        r12 = r1;
                        if (r42.isConnected()) {
                            c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                            c21061.L$1 = bluetoothDevice2;
                            c21061.L$2 = r1;
                            c21061.L$3 = SpillingKt.nullOutSpilledVariable(r42);
                            c21061.label = 6;
                            if (r42.disconnectSync(10000L, c21061) != coroutine_suspended) {
                                bluetoothDevice3 = bluetoothDevice2;
                                r13 = r1;
                                bluetoothDevice2 = bluetoothDevice3;
                                r12 = r13;
                            }
                        }
                        name = bluetoothDevice2.getName();
                        if (name == null) {
                        }
                        String address = bluetoothDevice2.getAddress();
                        if (lowerCase == null) {
                            th2 = null;
                        }
                        Logger.logInfo(r12 + " unrecognized", th2);
                        return SmartScanKt.unrecognizedDevice(bluetoothDevice2);
                    } catch (Throwable th4) {
                        ?? r16 = r1;
                        th = th4;
                        r0 = r16;
                        r4 = r42;
                        if (r4.isConnected()) {
                            throw th;
                        }
                        c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c21061.L$1 = SpillingKt.nullOutSpilledVariable(bluetoothDevice2);
                        c21061.L$2 = SpillingKt.nullOutSpilledVariable(r0);
                        c21061.L$3 = SpillingKt.nullOutSpilledVariable(r4);
                        c21061.L$4 = th;
                        c21061.label = 7;
                        if (r4.disconnectSync(10000L, c21061) != coroutine_suspended) {
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r0 = "detectDevice: HR:";
                    r4 = bLEClient2;
                    bluetoothDevice2 = bluetoothDevice;
                    if (r4.isConnected()) {
                    }
                }
                return coroutine_suspended;
            case 1:
                bLEClient = (BLEClient) c21061.L$3;
                str = (String) c21061.L$2;
                bluetoothDevice4 = (BluetoothDevice) c21061.L$1;
                context2 = (Context) c21061.L$0;
                ResultKt.throwOnFailure(objDiscoverServices);
                c21061.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                c21061.L$1 = bluetoothDevice4;
                c21061.L$2 = str;
                c21061.L$3 = bLEClient;
                c21061.label = 2;
                objDiscoverServices = bLEClient.discoverServices(10000L, c21061);
                if (objDiscoverServices == coroutine_suspended) {
                }
                return coroutine_suspended;
            case 2:
                bLEClient = (BLEClient) c21061.L$3;
                str = (String) c21061.L$2;
                bluetoothDevice4 = (BluetoothDevice) c21061.L$1;
                context2 = (Context) c21061.L$0;
                ResultKt.throwOnFailure(objDiscoverServices);
                gattServices = (GattServices) objDiscoverServices;
                Logger.logInfo(str + " services discovered", null);
                companion = BerryConstants.INSTANCE;
                if (!gattServices.contains(companion.getBERRY_SERVICE_ID(), companion.getBERRY_CHARACTERISTIC_ID())) {
                }
                return coroutine_suspended;
            case 3:
            case 4:
            case 5:
                DeviceDetectionResult deviceDetectionResult3 = (DeviceDetectionResult) c21061.L$5;
                ResultKt.throwOnFailure(objDiscoverServices);
                return deviceDetectionResult3;
            case 6:
                String str2 = (String) c21061.L$2;
                bluetoothDevice3 = (BluetoothDevice) c21061.L$1;
                ResultKt.throwOnFailure(objDiscoverServices);
                r13 = str2;
                bluetoothDevice2 = bluetoothDevice3;
                r12 = r13;
                name = bluetoothDevice2.getName();
                if (name == null) {
                    lowerCase = name.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = null;
                }
                String address2 = bluetoothDevice2.getAddress();
                if (lowerCase == null && (Intrinsics.areEqual(lowerCase, "stresslocator") || StringsKt.startsWith$default(lowerCase, "berrymed") || Intrinsics.areEqual(lowerCase, "pulse oximeter") || (Intrinsics.areEqual(lowerCase, "dual-spp") && Intrinsics.areEqual(address2, "34:81:F4:4B:CF:AE")))) {
                    try {
                        BluetoothSocket bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDevice2.createInsecureRfcommSocketToServiceRecord(BerryConstants.INSTANCE.getBERRY_RFCOMM_CHANNEL_ID());
                        try {
                            bluetoothSocketCreateInsecureRfcommSocketToServiceRecord.connect();
                            if (bluetoothSocketCreateInsecureRfcommSocketToServiceRecord.isConnected()) {
                                Logger.logInfo(r12 + " recognized Berry socket oximeter", null);
                                DeviceDetectionResult deviceDetectionResult4 = new DeviceDetectionResult(bluetoothDevice2, true, "Berry socket oximeter", new DetectDevice$$ExternalSyntheticLambda0(bluetoothDevice2, 2));
                                CloseableKt.closeFinally(bluetoothSocketCreateInsecureRfcommSocketToServiceRecord, null);
                                return deviceDetectionResult4;
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bluetoothSocketCreateInsecureRfcommSocketToServiceRecord, null);
                            th2 = null;
                        } finally {
                        }
                    } catch (Exception e3) {
                        th2 = null;
                        Logger.logInfo(Fragment$$ExternalSyntheticOutline1.m((String) r12, " socket: ", e3.getClass().getName(), ": ", e3.getMessage()), null);
                    }
                } else {
                    th2 = null;
                }
                Logger.logInfo(r12 + " unrecognized", th2);
                return SmartScanKt.unrecognizedDevice(bluetoothDevice2);
            case 7:
                Throwable th6 = (Throwable) c21061.L$4;
                ResultKt.throwOnFailure(objDiscoverServices);
                throw th6;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
