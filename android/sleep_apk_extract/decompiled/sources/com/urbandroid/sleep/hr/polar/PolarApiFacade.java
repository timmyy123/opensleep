package com.urbandroid.sleep.hr.polar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothGattCharacteristic;
import com.facebook.internal.NativeProtocol;
import com.google.home.platform.traits.ValidationIssue;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEClient;
import com.urbandroid.sleep.bluetoothle.BluetoothException;
import com.urbandroid.sleep.bluetoothle.BoundedBuffer;
import com.urbandroid.sleep.hr.polar.PolarConstants;
import com.urbandroid.sleep.hr.polar.domain.AccData;
import com.urbandroid.sleep.hr.polar.domain.PmdControlPointCommand;
import com.urbandroid.sleep.hr.polar.domain.PmdControlPointResponse;
import com.urbandroid.sleep.hr.polar.domain.PmdDataParser;
import com.urbandroid.sleep.hr.polar.domain.PmdFeature;
import com.urbandroid.sleep.hr.polar.domain.PmdMeasurementType;
import com.urbandroid.sleep.hr.polar.domain.PmdSetting;
import com.urbandroid.sleep.hr.polar.domain.PpiData;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001e\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001f\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010 \u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001cJ\"\u0010!\u001a\u00020\u00162\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0086@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001cJ\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u001aJ\u0006\u0010/\u001a\u00020\u001aJ\"\u00100\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\u0014H\u0086@¢\u0006\u0002\u0010\"J\u000e\u00101\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/urbandroid/sleep/hr/polar/PolarApiFacade;", "Lcom/urbandroid/common/FeatureLogger;", "bleClient", "Lcom/urbandroid/sleep/bluetoothle/BLEClient;", "<init>", "(Lcom/urbandroid/sleep/bluetoothle/BLEClient;)V", "tag", "", "getTag", "()Ljava/lang/String;", "timeout", "", "ctrlCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "dataCharacteristic", "features", "Lcom/urbandroid/sleep/hr/polar/domain/PmdFeature;", "accConfig", "Lcom/urbandroid/sleep/hr/polar/domain/PmdSetting;", "accConsumer", "Lkotlin/Function1;", "Lcom/urbandroid/sleep/hr/polar/domain/AccData;", "", "ppiConsumer", "Lcom/urbandroid/sleep/hr/polar/domain/PpiData;", "dataListenerRegistered", "", "configure", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureMTU", "configureCharacteristics", "fetchSupportedFeatures", "fetchFeaturesConfig", "startAccStream", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectPreferredAccSettings", "getAccelSampleRate", "", "stopAccStream", "sendControlPointCommand", "Lcom/urbandroid/sleep/hr/polar/domain/PmdControlPointResponse;", "command", "Lcom/urbandroid/sleep/hr/polar/domain/PmdControlPointCommand;", NativeProtocol.WEB_DIALOG_PARAMS, "", "(Lcom/urbandroid/sleep/hr/polar/domain/PmdControlPointCommand;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAccSupported", "isPpiSupported", "startPpiStream", "stopPpiStream", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PolarApiFacade implements FeatureLogger {
    private PmdSetting accConfig;
    private Function1<? super AccData, Unit> accConsumer;
    private final BLEClient bleClient;
    private BluetoothGattCharacteristic ctrlCharacteristic;
    private BluetoothGattCharacteristic dataCharacteristic;
    private boolean dataListenerRegistered;
    private PmdFeature features;
    private Function1<? super PpiData, Unit> ppiConsumer;
    private final String tag;
    private final long timeout;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PmdMeasurementType.values().length];
            try {
                iArr[PmdMeasurementType.ACC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PmdMeasurementType.PPI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PmdMeasurementType.UNKNOWN_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$configure$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {50, 54, 55, 56, 57}, m = "configure", v = 2)
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
            return PolarApiFacade.this.configure(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$configureCharacteristics$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {69, 71, 73, 75}, m = "configureCharacteristics", v = 2)
    public static final class C21191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21191(Continuation<? super C21191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.configureCharacteristics(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$configureMTU$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {61}, m = "configureMTU", v = 2)
    public static final class C21201 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21201(Continuation<? super C21201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.configureMTU(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$fetchFeaturesConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {110}, m = "fetchFeaturesConfig", v = 2)
    public static final class C21211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21211(Continuation<? super C21211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.fetchFeaturesConfig(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$fetchSupportedFeatures$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {103}, m = "fetchSupportedFeatures", v = 2)
    public static final class C21221 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C21221(Continuation<? super C21221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.fetchSupportedFeatures(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$sendControlPointCommand$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {228}, m = "sendControlPointCommand", v = 2)
    public static final class C21231 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C21231(Continuation<? super C21231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.sendControlPointCommand(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$startAccStream$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {140}, m = "startAccStream", v = 2)
    public static final class C21241 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C21241(Continuation<? super C21241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.startAccStream(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$startPpiStream$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {241}, m = "startPpiStream", v = 2)
    public static final class C21251 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21251(Continuation<? super C21251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.startPpiStream(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$stopAccStream$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER}, m = "stopAccStream", v = 2)
    public static final class C21261 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21261(Continuation<? super C21261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.stopAccStream(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.PolarApiFacade$stopPpiStream$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.hr.polar.PolarApiFacade", f = "PolarApiFacade.kt", l = {259}, m = "stopPpiStream", v = 2)
    public static final class C21271 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21271(Continuation<? super C21271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PolarApiFacade.this.stopPpiStream(this);
        }
    }

    public PolarApiFacade(BLEClient bLEClient) {
        bLEClient.getClass();
        this.bleClient = bLEClient;
        this.tag = "PolarApiFacade";
        this.timeout = 10000L;
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 30), 0, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
    
        if (r1.setNotificationEnabled(r2, true, r4, r6) == r0) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object configureCharacteristics(Continuation<? super Unit> continuation) {
        C21191 c21191;
        PolarApiFacade polarApiFacade;
        PolarApiFacade polarApiFacade2;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BluetoothGattCharacteristic bluetoothGattCharacteristic2;
        BluetoothGattCharacteristic bluetoothGattCharacteristic3;
        if (continuation instanceof C21191) {
            c21191 = (C21191) continuation;
            int i = c21191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21191.label = i - Integer.MIN_VALUE;
            } else {
                c21191 = new C21191(continuation);
            }
        }
        C21191 c211912 = c21191;
        Object characteristic = c211912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c211912.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(characteristic);
            BLEClient bLEClient = this.bleClient;
            PolarConstants.Companion companion = PolarConstants.INSTANCE;
            UUID polar_pmd_service_id = companion.getPOLAR_PMD_SERVICE_ID();
            UUID polar_pmd_control_characteristic_id = companion.getPOLAR_PMD_CONTROL_CHARACTERISTIC_ID();
            long j = this.timeout;
            c211912.L$0 = this;
            c211912.label = 1;
            characteristic = bLEClient.getCharacteristic(polar_pmd_service_id, polar_pmd_control_characteristic_id, j, c211912);
            if (characteristic != coroutine_suspended) {
                polarApiFacade = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                polarApiFacade2 = (PolarApiFacade) c211912.L$0;
                ResultKt.throwOnFailure(characteristic);
                polarApiFacade2.dataCharacteristic = (BluetoothGattCharacteristic) characteristic;
                bluetoothGattCharacteristic = this.ctrlCharacteristic;
                if (bluetoothGattCharacteristic != null) {
                    BLEClient bLEClient2 = this.bleClient;
                    long j2 = this.timeout;
                    c211912.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                    c211912.I$0 = 0;
                    c211912.label = 3;
                    if (bLEClient2.setIndicationEnabled(bluetoothGattCharacteristic, true, j2, c211912) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                bluetoothGattCharacteristic2 = this.dataCharacteristic;
                if (bluetoothGattCharacteristic2 != null) {
                }
                bluetoothGattCharacteristic3 = this.dataCharacteristic;
                if (bluetoothGattCharacteristic3 != null) {
                }
                return Unit.INSTANCE;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(characteristic);
                bluetoothGattCharacteristic3 = this.dataCharacteristic;
                if (bluetoothGattCharacteristic3 != null && !this.dataListenerRegistered) {
                    this.bleClient.addCharacteristicChangeListener(new FunSpec$$ExternalSyntheticLambda1(bluetoothGattCharacteristic3, this, 15));
                    this.dataListenerRegistered = true;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(characteristic);
            bluetoothGattCharacteristic2 = this.dataCharacteristic;
            if (bluetoothGattCharacteristic2 != null) {
                BLEClient bLEClient3 = this.bleClient;
                long j3 = this.timeout;
                c211912.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic2);
                c211912.I$0 = 0;
                c211912.label = 4;
            }
            bluetoothGattCharacteristic3 = this.dataCharacteristic;
            if (bluetoothGattCharacteristic3 != null) {
                this.bleClient.addCharacteristicChangeListener(new FunSpec$$ExternalSyntheticLambda1(bluetoothGattCharacteristic3, this, 15));
                this.dataListenerRegistered = true;
            }
            return Unit.INSTANCE;
        }
        polarApiFacade = (PolarApiFacade) c211912.L$0;
        ResultKt.throwOnFailure(characteristic);
        polarApiFacade.ctrlCharacteristic = (BluetoothGattCharacteristic) characteristic;
        BLEClient bLEClient4 = this.bleClient;
        PolarConstants.Companion companion2 = PolarConstants.INSTANCE;
        UUID polar_pmd_service_id2 = companion2.getPOLAR_PMD_SERVICE_ID();
        UUID polar_pmd_data_mtu_characteristic_id = companion2.getPOLAR_PMD_DATA_MTU_CHARACTERISTIC_ID();
        long j4 = this.timeout;
        c211912.L$0 = this;
        c211912.label = 2;
        characteristic = bLEClient4.getCharacteristic(polar_pmd_service_id2, polar_pmd_data_mtu_characteristic_id, j4, c211912);
        if (characteristic != coroutine_suspended) {
            polarApiFacade2 = this;
            polarApiFacade2.dataCharacteristic = (BluetoothGattCharacteristic) characteristic;
            bluetoothGattCharacteristic = this.ctrlCharacteristic;
            if (bluetoothGattCharacteristic != null) {
            }
            bluetoothGattCharacteristic2 = this.dataCharacteristic;
            if (bluetoothGattCharacteristic2 != null) {
            }
            bluetoothGattCharacteristic3 = this.dataCharacteristic;
            if (bluetoothGattCharacteristic3 != null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit configureCharacteristics$lambda$2$0(BluetoothGattCharacteristic bluetoothGattCharacteristic, PolarApiFacade polarApiFacade, BluetoothGattCharacteristic bluetoothGattCharacteristic2) {
        bluetoothGattCharacteristic2.getClass();
        if (Intrinsics.areEqual(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic2.getUuid())) {
            PmdDataParser.PmdMeasurement<? extends Object> pmdMeasurement = PmdDataParser.parse(bluetoothGattCharacteristic2.getValue(), polarApiFacade.accConfig);
            PmdMeasurementType pmdMeasurementType = pmdMeasurement.type;
            int i = pmdMeasurementType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[pmdMeasurementType.ordinal()];
            if (i == 1) {
                Function1<? super AccData, Unit> function1 = polarApiFacade.accConsumer;
                if (function1 != null) {
                    T t = pmdMeasurement.f69data;
                    t.getClass();
                    function1.invoke((AccData) t);
                }
            } else if (i == 2) {
                Function1<? super PpiData, Unit> function12 = polarApiFacade.ppiConsumer;
                if (function12 != null) {
                    T t2 = pmdMeasurement.f69data;
                    t2.getClass();
                    function12.invoke((PpiData) t2);
                }
            } else if (i != 3) {
                String str = "ignoring " + pmdMeasurement.type;
                Logger.logDebug(Logger.defaultTag, polarApiFacade.getTag() + ": " + str, null);
            } else {
                String str2 = Logger.defaultTag;
                Logger.logWarning(str2, polarApiFacade.getTag() + ": " + ("Data error: " + pmdMeasurement), null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object configureMTU(Continuation<? super Unit> continuation) {
        C21201 c21201;
        if (continuation instanceof C21201) {
            c21201 = (C21201) continuation;
            int i = c21201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21201.label = i - Integer.MIN_VALUE;
            } else {
                c21201 = new C21201(continuation);
            }
        }
        Object objRequestMTU = c21201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21201.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRequestMTU);
            BLEClient bLEClient = this.bleClient;
            long j = this.timeout;
            c21201.label = 1;
            objRequestMTU = bLEClient.requestMTU(256, j, c21201);
            if (objRequestMTU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objRequestMTU);
        }
        int iIntValue = ((Number) objRequestMTU).intValue();
        if (iIntValue >= 232) {
            return Unit.INSTANCE;
        }
        Events$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(iIntValue, "MTU too small: "));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchFeaturesConfig(Continuation<? super Unit> continuation) {
        C21211 c21211;
        if (continuation instanceof C21211) {
            c21211 = (C21211) continuation;
            int i = c21211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21211.label = i - Integer.MIN_VALUE;
            } else {
                c21211 = new C21211(continuation);
            }
        }
        Object objSendControlPointCommand = c21211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21211.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendControlPointCommand);
            if (isAccSupported()) {
                PmdControlPointCommand pmdControlPointCommand = PmdControlPointCommand.GET_MEASUREMENT_SETTINGS;
                byte[] bArr = {(byte) PmdMeasurementType.ACC.getNumVal()};
                c21211.label = 1;
                objSendControlPointCommand = sendControlPointCommand(pmdControlPointCommand, bArr, c21211);
                if (objSendControlPointCommand == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(objSendControlPointCommand);
        PmdControlPointResponse pmdControlPointResponse = (PmdControlPointResponse) objSendControlPointCommand;
        if (pmdControlPointResponse.status != PmdControlPointResponse.PmdControlPointResponseCode.SUCCESS) {
            throw new BluetoothException("Get acc settings error: " + pmdControlPointResponse);
        }
        try {
            PmdSetting pmdSetting = new PmdSetting(pmdControlPointResponse.parameters.toByteArray());
            this.accConfig = pmdSetting;
            String strValueOf = String.valueOf(pmdSetting);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
            return Unit.INSTANCE;
        } catch (RuntimeException e) {
            throw new BluetoothException("Parse acc settings error: " + pmdControlPointResponse, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchSupportedFeatures(Continuation<? super Unit> continuation) {
        C21221 c21221;
        PolarApiFacade polarApiFacade;
        if (continuation instanceof C21221) {
            c21221 = (C21221) continuation;
            int i = c21221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21221.label = i - Integer.MIN_VALUE;
            } else {
                c21221 = new C21221(continuation);
            }
        }
        Object obj = c21221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21221.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.ctrlCharacteristic;
            if (bluetoothGattCharacteristic != null) {
                BLEClient bLEClient = this.bleClient;
                long j = this.timeout;
                c21221.L$0 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
                c21221.L$1 = this;
                c21221.I$0 = 0;
                c21221.label = 1;
                obj = bLEClient.read(bluetoothGattCharacteristic, j, c21221);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                polarApiFacade = this;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        polarApiFacade = (PolarApiFacade) c21221.L$1;
        ResultKt.throwOnFailure(obj);
        polarApiFacade.features = new PmdFeature((byte[]) obj);
        String strValueOf = String.valueOf(this.features);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
        return Unit.INSTANCE;
    }

    private final void selectPreferredAccSettings(PmdSetting accConfig) {
        TreeMap treeMap = new TreeMap();
        Map<PmdSetting.PmdSettingType, Set<Integer>> map = accConfig.settings;
        PmdSetting.PmdSettingType pmdSettingType = PmdSetting.PmdSettingType.SAMPLE_RATE;
        Set<Integer> set = map.get(pmdSettingType);
        if (set != null) {
            if (set.contains(50)) {
                treeMap.put(pmdSettingType, 50);
            } else {
                Integer num = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) set);
                treeMap.put(pmdSettingType, Integer.valueOf(num != null ? num.intValue() : 0));
            }
        }
        Map<PmdSetting.PmdSettingType, Set<Integer>> map2 = accConfig.settings;
        PmdSetting.PmdSettingType pmdSettingType2 = PmdSetting.PmdSettingType.RESOLUTION;
        Set<Integer> set2 = map2.get(pmdSettingType2);
        if (set2 != null) {
            if (set2.contains(16)) {
                treeMap.put(pmdSettingType2, 16);
            } else {
                Integer num2 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) set2);
                treeMap.put(pmdSettingType2, Integer.valueOf(num2 != null ? num2.intValue() : 0));
            }
        }
        Map<PmdSetting.PmdSettingType, Set<Integer>> map3 = accConfig.settings;
        PmdSetting.PmdSettingType pmdSettingType3 = PmdSetting.PmdSettingType.RANGE;
        Set<Integer> set3 = map3.get(pmdSettingType3);
        if (set3 != null) {
            if (set3.contains(8)) {
                treeMap.put(pmdSettingType3, 8);
            } else {
                Integer num3 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) set3);
                treeMap.put(pmdSettingType3, Integer.valueOf(num3 != null ? num3.intValue() : 0));
            }
        }
        Map<PmdSetting.PmdSettingType, Set<Integer>> map4 = accConfig.settings;
        PmdSetting.PmdSettingType pmdSettingType4 = PmdSetting.PmdSettingType.CHANNELS;
        Set<Integer> set4 = map4.get(pmdSettingType4);
        if (set4 != null) {
            if (set4.contains(3)) {
                treeMap.put(pmdSettingType4, 3);
            } else {
                Integer num4 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) set4);
                treeMap.put(pmdSettingType4, Integer.valueOf(num4 != null ? num4.intValue() : 0));
            }
        }
        accConfig.selected = treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendControlPointCommand(PmdControlPointCommand pmdControlPointCommand, byte[] bArr, Continuation<? super PmdControlPointResponse> continuation) {
        C21231 c21231;
        BoundedBuffer boundedBuffer;
        if (continuation instanceof C21231) {
            c21231 = (C21231) continuation;
            int i = c21231.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21231.label = i - Integer.MIN_VALUE;
            } else {
                c21231 = new C21231(continuation);
            }
        }
        C21231 c212312 = c21231;
        Object obj = c212312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c212312.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.ctrlCharacteristic;
            if (bluetoothGattCharacteristic == null) {
                Events$$ExternalSyntheticBUOutline0.m("Not initialized");
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 1);
            byteBufferAllocate.put(new byte[]{(byte) pmdControlPointCommand.getNumVal()});
            byteBufferAllocate.put(bArr);
            BoundedBuffer boundedBuffer2 = new BoundedBuffer() { // from class: com.urbandroid.sleep.hr.polar.PolarApiFacade$sendControlPointCommand$2$consumer$1
                @Override // com.urbandroid.sleep.bluetoothle.DataConsumer
                public boolean isDataComplete() {
                    return true;
                }
            };
            BLEClient bLEClient = this.bleClient;
            byte[] bArrArray = byteBufferAllocate.array();
            bArrArray.getClass();
            long j = this.timeout;
            c212312.L$0 = SpillingKt.nullOutSpilledVariable(pmdControlPointCommand);
            c212312.L$1 = SpillingKt.nullOutSpilledVariable(bArr);
            c212312.L$2 = SpillingKt.nullOutSpilledVariable(bluetoothGattCharacteristic);
            c212312.L$3 = SpillingKt.nullOutSpilledVariable(byteBufferAllocate);
            c212312.L$4 = boundedBuffer2;
            c212312.I$0 = 0;
            c212312.label = 1;
            if (bLEClient.writeAndCollectNotifications(bluetoothGattCharacteristic, bArrArray, boundedBuffer2, j, c212312) == coroutine_suspended) {
                return coroutine_suspended;
            }
            boundedBuffer = boundedBuffer2;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            boundedBuffer = (PolarApiFacade$sendControlPointCommand$2$consumer$1) c212312.L$4;
            ResultKt.throwOnFailure(obj);
        }
        return new PmdControlPointResponse(CollectionsKt.toByteArray(boundedBuffer.getBuffer()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r11.setPreferredPhy2M(r8, r0) == r1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (fetchFeaturesConfig(r0) != r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object configure(Continuation<? super Unit> continuation) {
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
        try {
        } catch (RuntimeException e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": bleClient.setPreferredPhy2M failed, but let's try to proceed anyway.", e);
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            BLEClient bLEClient = this.bleClient;
            long j = this.timeout;
            anonymousClass1.label = 1;
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                anonymousClass1.label = 3;
                if (configureCharacteristics(anonymousClass1) != coroutine_suspended) {
                    anonymousClass1.label = 4;
                    if (fetchSupportedFeatures(anonymousClass1) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                ResultKt.throwOnFailure(obj);
                anonymousClass1.label = 4;
                if (fetchSupportedFeatures(anonymousClass1) != coroutine_suspended) {
                    anonymousClass1.label = 5;
                }
                return coroutine_suspended;
            }
            if (i2 != 4) {
                if (i2 == 5) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 5;
        }
        anonymousClass1.label = 2;
        if (configureMTU(anonymousClass1) != coroutine_suspended) {
            anonymousClass1.label = 3;
            if (configureCharacteristics(anonymousClass1) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    public final int getAccelSampleRate() {
        PmdSetting pmdSetting = this.accConfig;
        if (pmdSetting == null) {
            Events$$ExternalSyntheticBUOutline0.m("Settings not available");
            return 0;
        }
        Integer num = pmdSetting.selected.get(PmdSetting.PmdSettingType.SAMPLE_RATE);
        if (num != null) {
            return num.intValue();
        }
        Events$$ExternalSyntheticBUOutline0.m("Sample rate not available");
        return 0;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final boolean isAccSupported() {
        PmdFeature pmdFeature = this.features;
        if (pmdFeature != null) {
            return pmdFeature.accSupported;
        }
        return false;
    }

    public final boolean isPpiSupported() {
        PmdFeature pmdFeature = this.features;
        if (pmdFeature != null) {
            return pmdFeature.ppiSupported;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startAccStream(Function1<? super AccData, Unit> function1, Continuation<? super Unit> continuation) {
        C21241 c21241;
        if (continuation instanceof C21241) {
            c21241 = (C21241) continuation;
            int i = c21241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21241.label = i - Integer.MIN_VALUE;
            } else {
                c21241 = new C21241(continuation);
            }
        }
        Object objSendControlPointCommand = c21241.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21241.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendControlPointCommand);
            if (!isAccSupported()) {
                Events$$ExternalSyntheticBUOutline0.m("Acc not supported");
                return null;
            }
            PmdSetting pmdSetting = this.accConfig;
            if (pmdSetting == null) {
                Events$$ExternalSyntheticBUOutline0.m("Settings not available");
                return null;
            }
            selectPreferredAccSettings(pmdSetting);
            String str = "Acc stream settings: " + pmdSetting.selected;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            byte[] bArrSerializeSelected = pmdSetting.serializeSelected();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrSerializeSelected.length + 1);
            byteBufferAllocate.put((byte) PmdMeasurementType.ACC.getNumVal());
            byteBufferAllocate.put(bArrSerializeSelected);
            PmdControlPointCommand pmdControlPointCommand = PmdControlPointCommand.REQUEST_MEASUREMENT_START;
            byte[] bArrArray = byteBufferAllocate.array();
            bArrArray.getClass();
            c21241.L$0 = function1;
            c21241.L$1 = SpillingKt.nullOutSpilledVariable(pmdSetting);
            c21241.L$2 = SpillingKt.nullOutSpilledVariable(bArrSerializeSelected);
            c21241.L$3 = SpillingKt.nullOutSpilledVariable(byteBufferAllocate);
            c21241.I$0 = 0;
            c21241.label = 1;
            objSendControlPointCommand = sendControlPointCommand(pmdControlPointCommand, bArrArray, c21241);
            if (objSendControlPointCommand == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function1 = (Function1) c21241.L$0;
            ResultKt.throwOnFailure(objSendControlPointCommand);
        }
        PmdControlPointResponse pmdControlPointResponse = (PmdControlPointResponse) objSendControlPointCommand;
        String strValueOf = String.valueOf(pmdControlPointResponse);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
        if (pmdControlPointResponse.status == PmdControlPointResponse.PmdControlPointResponseCode.SUCCESS) {
            this.accConsumer = function1;
            return Unit.INSTANCE;
        }
        throw new BluetoothException("Start acc stream error: " + pmdControlPointResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startPpiStream(Function1<? super PpiData, Unit> function1, Continuation<? super Unit> continuation) {
        C21251 c21251;
        if (continuation instanceof C21251) {
            c21251 = (C21251) continuation;
            int i = c21251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21251.label = i - Integer.MIN_VALUE;
            } else {
                c21251 = new C21251(continuation);
            }
        }
        Object objSendControlPointCommand = c21251.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21251.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendControlPointCommand);
            if (!isPpiSupported()) {
                Events$$ExternalSyntheticBUOutline0.m("Ppi not supported");
                return null;
            }
            PmdControlPointCommand pmdControlPointCommand = PmdControlPointCommand.REQUEST_MEASUREMENT_START;
            byte[] bArr = {(byte) PmdMeasurementType.PPI.getNumVal()};
            c21251.L$0 = function1;
            c21251.label = 1;
            objSendControlPointCommand = sendControlPointCommand(pmdControlPointCommand, bArr, c21251);
            if (objSendControlPointCommand == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            function1 = (Function1) c21251.L$0;
            ResultKt.throwOnFailure(objSendControlPointCommand);
        }
        PmdControlPointResponse pmdControlPointResponse = (PmdControlPointResponse) objSendControlPointCommand;
        String strValueOf = String.valueOf(pmdControlPointResponse);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
        if (pmdControlPointResponse.status == PmdControlPointResponse.PmdControlPointResponseCode.SUCCESS) {
            this.ppiConsumer = function1;
            return Unit.INSTANCE;
        }
        throw new BluetoothException("Start ppi stream error: " + pmdControlPointResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopAccStream(Continuation<? super Unit> continuation) {
        C21261 c21261;
        if (continuation instanceof C21261) {
            c21261 = (C21261) continuation;
            int i = c21261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21261.label = i - Integer.MIN_VALUE;
            } else {
                c21261 = new C21261(continuation);
            }
        }
        Object objSendControlPointCommand = c21261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21261.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendControlPointCommand);
            this.accConsumer = null;
            PmdControlPointCommand pmdControlPointCommand = PmdControlPointCommand.STOP_MEASUREMENT;
            byte[] bArr = {(byte) PmdMeasurementType.ACC.getNumVal()};
            c21261.label = 1;
            objSendControlPointCommand = sendControlPointCommand(pmdControlPointCommand, bArr, c21261);
            if (objSendControlPointCommand == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSendControlPointCommand);
        }
        String strValueOf = String.valueOf((PmdControlPointResponse) objSendControlPointCommand);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopPpiStream(Continuation<? super Unit> continuation) {
        C21271 c21271;
        if (continuation instanceof C21271) {
            c21271 = (C21271) continuation;
            int i = c21271.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21271.label = i - Integer.MIN_VALUE;
            } else {
                c21271 = new C21271(continuation);
            }
        }
        Object objSendControlPointCommand = c21271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21271.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSendControlPointCommand);
            this.ppiConsumer = null;
            PmdControlPointCommand pmdControlPointCommand = PmdControlPointCommand.STOP_MEASUREMENT;
            byte[] bArr = {(byte) PmdMeasurementType.PPI.getNumVal()};
            c21271.label = 1;
            objSendControlPointCommand = sendControlPointCommand(pmdControlPointCommand, bArr, c21271);
            if (objSendControlPointCommand == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objSendControlPointCommand);
        }
        String strValueOf = String.valueOf((PmdControlPointResponse) objSendControlPointCommand);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strValueOf, null);
        return Unit.INSTANCE;
    }
}
