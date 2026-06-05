package com.urbandroid.sleep.smartwatch.polar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.PolarBleApiCallback;
import com.polar.sdk.api.PolarBleApiDefaultImpl;
import com.polar.sdk.api.model.LedConfig;
import com.polar.sdk.api.model.PolarAccelerometerData;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.polar.sdk.api.model.PolarHrData;
import com.polar.sdk.api.model.PolarPpiData;
import com.polar.sdk.api.model.PolarSensorSetting;
import com.polar.sdk.impl.BDBleApiImpl;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.sensor.extra.RRIntervalsDataProducer;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\u001aJ\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010\u001cJ\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0017H\u0016¢\u0006\u0004\b+\u0010\u001aJ\u0017\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\b¢\u0006\u0004\b/\u0010.J\u0017\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u0010\u001aJ\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u0014R\u001a\u0010G\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010ER\u001a\u0010I\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\bI\u0010C\u001a\u0004\bJ\u0010ER\u001a\u0010K\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\bK\u0010C\u001a\u0004\bL\u0010ER\u0017\u0010N\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR(\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010YR$\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010d\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010.R\u0017\u0010j\u001a\u00020i8\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\b3\u0010lR\u001b\u0010r\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0017\u0010t\u001a\u00020s8\u0006¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w¨\u0006x"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/polar/Polar;", "Lcom/urbandroid/sleep/smartwatch/SmartWatch;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "feature", "", "isReady", "(Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;)Z", "Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;", "callback", "", "timeoutMillis", "", "asyncConnectionCheck", "(Lcom/urbandroid/sleep/smartwatch/IConnectivityCallback;J)V", "timestamp", "updateAlarm", "(J)V", "ts", "updatePause", "", "delay", "startAlarm", "(I)V", "stopAlarm", "()V", "initiateAccel", "initiateHr", "retry", "startAccel", "startHr", "on", "startLed", "(ZI)V", "Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;", "listener", "startTracking", "(Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;)V", "stopTracking", "batchSize", "setBatchSize", "suspended", "setSuspended", "(Z)V", "led", "repeat", ViewHierarchyConstants.HINT_KEY, "Lcom/urbandroid/sleep/sensor/IAccelManager;", "getAccelManager", "()Lcom/urbandroid/sleep/sensor/IAccelManager;", "", "getPlatform", "()Ljava/lang/String;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "currentVector", "F", "getCurrentVector", "()F", "setCurrentVector", "(F)V", "currentVectorTs", "J", "getCurrentVectorTs", "()J", "setCurrentVectorTs", "vectorAggTime", "getVectorAggTime", "vectorAggMaxTime", "getVectorAggMaxTime", "hrAggTime", "getHrAggTime", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "", "Lcom/polar/sdk/api/model/PolarDeviceInfo;", "devices", "Ljava/util/Set;", "getDevices", "()Ljava/util/Set;", "setDevices", "(Ljava/util/Set;)V", "featuresReady", "getFeaturesReady", "setFeaturesReady", "Lorg/reactivestreams/Subscription;", "subscriber", "Lorg/reactivestreams/Subscription;", "getSubscriber", "()Lorg/reactivestreams/Subscription;", "setSubscriber", "(Lorg/reactivestreams/Subscription;)V", "trackingNeedsRestart", "Z", "getTrackingNeedsRestart", "()Z", "setTrackingNeedsRestart", "Lcom/urbandroid/sleep/smartwatch/polar/PolarAccelManager;", "accelManager", "Lcom/urbandroid/sleep/smartwatch/polar/PolarAccelManager;", "()Lcom/urbandroid/sleep/smartwatch/polar/PolarAccelManager;", "Lcom/polar/sdk/api/PolarBleApi;", "api$delegate", "Lkotlin/Lazy;", "getApi", "()Lcom/polar/sdk/api/PolarBleApi;", "api", "Ljava/lang/Runnable;", "accelDataRunnable", "Ljava/lang/Runnable;", "getAccelDataRunnable", "()Ljava/lang/Runnable;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Polar implements SmartWatch {
    private final Runnable accelDataRunnable;
    private final PolarAccelManager accelManager;

    /* JADX INFO: renamed from: api$delegate, reason: from kotlin metadata */
    private final Lazy api;
    private final Context context;
    private float currentVector;
    private long currentVectorTs;
    private Set<PolarDeviceInfo> devices;
    private Set<PolarBleApi.PolarBleSdkFeature> featuresReady;
    private final Handler h;
    private final long hrAggTime;
    private Subscription subscriber;
    private boolean trackingNeedsRestart;
    private final long vectorAggMaxTime;
    private final long vectorAggTime;

    public Polar(Context context) {
        context.getClass();
        this.context = context;
        this.vectorAggTime = 9000L;
        this.vectorAggMaxTime = 9500L;
        this.hrAggTime = 1000L;
        this.h = new Handler();
        this.devices = new LinkedHashSet();
        this.featuresReady = new LinkedHashSet();
        this.accelManager = new PolarAccelManager(context);
        this.api = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 16));
        this.accelDataRunnable = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$accelDataRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.getCurrentVectorTs() == 0) {
                    this.this$0.setCurrentVectorTs(System.currentTimeMillis());
                }
                if (this.this$0.getCurrentVector() != 0.0f && System.currentTimeMillis() - this.this$0.getCurrentVectorTs() >= this.this$0.getVectorAggTime()) {
                    Logger.logInfo("Polar: runnable ACC: " + this.this$0.getCurrentVector());
                    this.this$0.getAccelManager().pushNewData(this.this$0.getCurrentVector());
                    this.this$0.setCurrentVector(0.0f);
                    this.this$0.setCurrentVectorTs(System.currentTimeMillis());
                }
                this.this$0.getH().removeCallbacks(this);
                this.this$0.getH().postDelayed(this, this.this$0.getVectorAggMaxTime());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BDBleApiImpl api_delegate$lambda$0(Polar polar) {
        return PolarBleApiDefaultImpl.defaultImplementation(polar.context, SetsKt.setOf((Object[]) new PolarBleApi.PolarBleSdkFeature[]{PolarBleApi.PolarBleSdkFeature.FEATURE_HR, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_SDK_MODE, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_LED_ANIMATION, PolarBleApi.PolarBleSdkFeature.FEATURE_DEVICE_INFO}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit asyncConnectionCheck$lambda$0(PolarDeviceInfo polarDeviceInfo, Polar polar, PolarDeviceInfo polarDeviceInfo2) {
        polarDeviceInfo2.getClass();
        String deviceId = polarDeviceInfo2.getDeviceId();
        String address = polarDeviceInfo2.getAddress();
        int rssi = polarDeviceInfo2.getRssi();
        String name = polarDeviceInfo2.getName();
        boolean zIsConnectable = polarDeviceInfo2.getIsConnectable();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Polar: device found id: ", deviceId, " address: ", address, " rssi: ");
        sbM6m.append(rssi);
        sbM6m.append(" name: ");
        sbM6m.append(name);
        sbM6m.append(" isConnectable: ");
        sbM6m.append(zIsConnectable);
        Logger.logInfo(sbM6m.toString());
        if (polarDeviceInfo2.getIsConnectable()) {
            String deviceId2 = polarDeviceInfo2.getDeviceId();
            String address2 = polarDeviceInfo2.getAddress();
            int rssi2 = polarDeviceInfo2.getRssi();
            String name2 = polarDeviceInfo2.getName();
            boolean zIsConnectable2 = polarDeviceInfo2.getIsConnectable();
            String deviceId3 = polarDeviceInfo != null ? polarDeviceInfo.getDeviceId() : null;
            StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("Polar: connect() ", deviceId2, " address: ", address2, " rssi: ");
            sbM6m2.append(rssi2);
            sbM6m2.append(" name: ");
            sbM6m2.append(name2);
            sbM6m2.append(" isConnectable: ");
            sbM6m2.append(zIsConnectable2);
            sbM6m2.append(" stored ");
            sbM6m2.append(deviceId3);
            Logger.logInfo(sbM6m2.toString());
            if (polarDeviceInfo == null || Intrinsics.areEqual(polarDeviceInfo2.getDeviceId(), polarDeviceInfo.getDeviceId())) {
                Logger.logInfo("Polar: stored check ok " + polarDeviceInfo2.getDeviceId() + "=" + (polarDeviceInfo != null ? polarDeviceInfo.getDeviceId() : null));
                polar.getApi().connectToDevice(polarDeviceInfo2.getDeviceId());
                Subscription subscription = polar.subscriber;
                if (subscription != null) {
                    subscription.cancel();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PolarBleApi getApi() {
        return (PolarBleApi) this.api.getValue();
    }

    public static /* synthetic */ void startAccel$default(Polar polar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        polar.startAccel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAccel$lambda$0(Polar polar, int i) {
        polar.startAccel(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAccel$lambda$1(Polar polar, int i) {
        polar.startAccel(i + 1);
    }

    public static /* synthetic */ void startHr$default(Polar polar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        polar.startHr(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHr$lambda$0(Polar polar, int i) {
        polar.startHr(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startHr$lambda$1(Polar polar, int i) {
        polar.startHr(i + 1);
    }

    public static /* synthetic */ void startLed$default(Polar polar, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        polar.startLed(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLed$lambda$0(Polar polar, boolean z, int i) {
        polar.startLed(z, i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLed$lambda$1(Polar polar, boolean z, int i) {
        polar.startLed(z, i + 1);
    }

    public void asyncConnectionCheck(final IConnectivityCallback callback, long timeoutMillis) {
        this.devices.clear();
        PolarDeviceInfo polarSdkDevice = SharedApplicationContext.getSettings().getPolarSdkDevice();
        getApi().setApiCallback(new PolarBleApiCallback() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar.asyncConnectionCheck.1
            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void batteryLevelReceived(String identifier, int level) {
                identifier.getClass();
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void blePowerStateChanged(boolean powered) {
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void bleSdkFeatureReady(String identifier, PolarBleApi.PolarBleSdkFeature feature) {
                identifier.getClass();
                feature.getClass();
                Logger.logInfo("Polar: Feature ready " + feature);
                this.getFeaturesReady().add(feature);
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void deviceConnected(PolarDeviceInfo polarDeviceInfo) {
                polarDeviceInfo.getClass();
                IConnectivityCallback iConnectivityCallback = callback;
                if (iConnectivityCallback != null) {
                    iConnectivityCallback.status(this, true);
                }
                Logger.logInfo("Polar: Connected '" + polarDeviceInfo.getName() + "' '" + polarDeviceInfo.getAddress() + "' ");
                this.getDevices().add(polarDeviceInfo);
                if (this.getTrackingNeedsRestart()) {
                    Logger.logInfo("Polar: tracking needs restart");
                    this.startTracking(null);
                }
                this.setTrackingNeedsRestart(false);
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void deviceConnecting(PolarDeviceInfo polarDeviceInfo) {
                polarDeviceInfo.getClass();
                Logger.logInfo("Polar: Connecting '" + polarDeviceInfo.getName() + "' '" + polarDeviceInfo.getAddress() + "' ");
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void deviceDisconnected(PolarDeviceInfo polarDeviceInfo) {
                polarDeviceInfo.getClass();
                Logger.logInfo("Polar: Disconnected '" + polarDeviceInfo.getName() + "' '" + polarDeviceInfo.getAddress() + "' ");
                this.getDevices().remove(polarDeviceInfo);
                this.getFeaturesReady().clear();
                this.setTrackingNeedsRestart(true);
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void disInformationReceived(String identifier, UUID uuid, String value) {
                identifier.getClass();
                uuid.getClass();
                value.getClass();
            }

            @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
            public void disInformationReceived(String identifier, DisInfo disInfo) {
                identifier.getClass();
                disInfo.getClass();
            }
        });
        final FunSpec$$ExternalSyntheticLambda1 funSpec$$ExternalSyntheticLambda1 = new FunSpec$$ExternalSyntheticLambda1(polarSdkDevice, this, 16);
        getApi().searchForDevice().doOnSubscribe(new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar.asyncConnectionCheck.2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Subscription subscription) {
                subscription.getClass();
                Polar.this.setSubscriber(subscription);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(funSpec$$ExternalSyntheticLambda1) { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$sam$io_reactivex_rxjava3_functions_Consumer$0
            private final /* synthetic */ Function1 function;

            {
                funSpec$$ExternalSyntheticLambda1.getClass();
                this.function = funSpec$$ExternalSyntheticLambda1;
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final /* synthetic */ void accept(Object obj) {
                this.function.invoke(obj);
            }
        }, new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar.asyncConnectionCheck.3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Throwable th) {
                th.getClass();
                Logger.logSevere(th);
            }
        }, new Polar$$ExternalSyntheticLambda1(0));
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public final PolarAccelManager getAccelManager() {
        return this.accelManager;
    }

    public final Context getContext() {
        return this.context;
    }

    public final float getCurrentVector() {
        return this.currentVector;
    }

    public final long getCurrentVectorTs() {
        return this.currentVectorTs;
    }

    public final Set<PolarDeviceInfo> getDevices() {
        return this.devices;
    }

    public final Set<PolarBleApi.PolarBleSdkFeature> getFeaturesReady() {
        return this.featuresReady;
    }

    public final Handler getH() {
        return this.h;
    }

    public final long getHrAggTime() {
        return this.hrAggTime;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "Polar SDK";
    }

    public final boolean getTrackingNeedsRestart() {
        return this.trackingNeedsRestart;
    }

    public final long getVectorAggMaxTime() {
        return this.vectorAggMaxTime;
    }

    public final long getVectorAggTime() {
        return this.vectorAggTime;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int repeat) {
        startLed$default(this, true, 0, 2, null);
        this.h.postDelayed(new Polar$$ExternalSyntheticLambda2(this, 0), ((long) repeat) * 1000);
    }

    public final void initiateAccel() {
        for (final PolarDeviceInfo polarDeviceInfo : this.devices) {
            Logger.logInfo("Polar: ACC streaming start");
            getApi().requestStreamSettings(polarDeviceInfo.getDeviceId(), PolarBleApi.PolarDeviceDataType.ACC).toFlowable().flatMap(new Function() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateAccel$1$1
                @Override // io.reactivex.rxjava3.functions.Function
                public final Publisher<? extends PolarAccelerometerData> apply(PolarSensorSetting polarSensorSetting) {
                    polarSensorSetting.getClass();
                    return this.this$0.getApi().startAccStreaming(polarDeviceInfo.getDeviceId(), polarSensorSetting);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateAccel$1$2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(PolarAccelerometerData polarAccelerometerData) {
                    polarAccelerometerData.getClass();
                    for (PolarAccelerometerData.PolarAccelerometerDataSample polarAccelerometerDataSample : polarAccelerometerData.getSamples()) {
                        float fSqrt = (float) Math.sqrt((polarAccelerometerDataSample.getZ() * polarAccelerometerDataSample.getZ()) + (polarAccelerometerDataSample.getY() * polarAccelerometerDataSample.getY()) + (polarAccelerometerDataSample.getX() * polarAccelerometerDataSample.getX()));
                        if (fSqrt > this.this$0.getCurrentVector()) {
                            this.this$0.setCurrentVector(fSqrt);
                        }
                        if (this.this$0.getCurrentVectorTs() == 0) {
                            this.this$0.setCurrentVectorTs(System.currentTimeMillis());
                        }
                        if (this.this$0.getCurrentVector() != 0.0f && System.currentTimeMillis() - this.this$0.getCurrentVectorTs() >= this.this$0.getVectorAggTime()) {
                            Logger.logInfo("Polar: regular ACC: " + this.this$0.getCurrentVector());
                            this.this$0.getAccelManager().pushNewData(this.this$0.getCurrentVector());
                            this.this$0.setCurrentVector(0.0f);
                            this.this$0.setCurrentVectorTs(System.currentTimeMillis());
                        }
                    }
                }
            }, new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateAccel$1$3
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    th.getClass();
                    Logger.logSevere(th);
                }
            }, new Polar$$ExternalSyntheticLambda1(4));
        }
    }

    public final void initiateHr() {
        for (PolarDeviceInfo polarDeviceInfo : this.devices) {
            Logger.logInfo("Polar: PP streaming start");
            getApi().startPpiStreaming(polarDeviceInfo.getDeviceId()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateHr$1$1
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(PolarPpiData polarPpiData) {
                    polarPpiData.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis() - (this.this$0.getHrAggTime() * ((long) polarPpiData.getSamples().size()));
                    List<PolarPpiData.PolarPpiSample> samples = polarPpiData.getSamples();
                    Polar polar = this.this$0;
                    for (PolarPpiData.PolarPpiSample polarPpiSample : samples) {
                        if (polarPpiSample.getSkinContactStatus() || !polarPpiSample.getSkinContactSupported()) {
                            RRIntervalsDataProducer.INSTANCE.produce(polar.getContext(), polarPpiSample.getPpi(), jCurrentTimeMillis);
                        }
                    }
                }
            }, new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateHr$1$2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    th.getClass();
                    Logger.logSevere(th);
                }
            }, new Polar$$ExternalSyntheticLambda1(2));
            getApi().startHrStreaming(polarDeviceInfo.getDeviceId()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateHr$1$4
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(PolarHrData polarHrData) {
                    polarHrData.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis() - (this.this$0.getHrAggTime() * ((long) polarHrData.getSamples().size()));
                    List<PolarHrData.PolarHrSample> samples = polarHrData.getSamples();
                    Polar polar = this.this$0;
                    for (PolarHrData.PolarHrSample polarHrSample : samples) {
                        if (polarHrSample.getContactStatus() || !polarHrSample.getContactStatusSupported()) {
                            HrDataProducer.INSTANCE.produce(polar.getContext(), polarHrSample.getHr(), jCurrentTimeMillis);
                            Iterator<T> it = polarHrSample.getRrsMs().iterator();
                            while (it.hasNext()) {
                                RRIntervalsDataProducer.INSTANCE.produce(polar.getContext(), ((Number) it.next()).intValue(), jCurrentTimeMillis);
                            }
                        }
                    }
                }
            }, new Consumer() { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$initiateHr$1$5
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Throwable th) {
                    th.getClass();
                    Logger.logSevere(th);
                }
            }, new Polar$$ExternalSyntheticLambda1(3));
        }
    }

    public final boolean isReady(PolarBleApi.PolarBleSdkFeature feature) {
        feature.getClass();
        return this.featuresReady.contains(feature);
    }

    public final void led(boolean on) {
        for (PolarDeviceInfo polarDeviceInfo : this.devices) {
            zza$$ExternalSyntheticOutline0.m("Polar: LED ", on);
            getApi().setLedConfig(polarDeviceInfo.getDeviceId(), new LedConfig(on, false));
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int batchSize) {
    }

    public final void setCurrentVector(float f) {
        this.currentVector = f;
    }

    public final void setCurrentVectorTs(long j) {
        this.currentVectorTs = j;
    }

    public final void setSubscriber(Subscription subscription) {
        this.subscriber = subscription;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean suspended) {
    }

    public final void setTrackingNeedsRestart(boolean z) {
        this.trackingNeedsRestart = z;
    }

    public final void startAccel(int retry) {
        if (!isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING)) {
            if (retry < 60) {
                this.h.postDelayed(new Polar$$ExternalSyntheticLambda7(this, retry, 3), 1000L);
                return;
            }
            return;
        }
        try {
            initiateAccel();
        } catch (Exception e) {
            Logger.logSevere(e);
            if (retry < 60) {
                this.h.postDelayed(new Polar$$ExternalSyntheticLambda7(this, retry, 0), 1000L);
            }
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int delay) {
        led(true);
    }

    public final void startHr(int retry) {
        if (SharedApplicationContext.getSettings().isHrWear()) {
            if (!isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_HR) || !isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING)) {
                if (retry < 60) {
                    this.h.postDelayed(new Polar$$ExternalSyntheticLambda7(this, retry, 2), 1000L);
                    return;
                }
                return;
            }
            try {
                initiateHr();
            } catch (Exception e) {
                Logger.logSevere(e);
                if (retry < 60) {
                    this.h.postDelayed(new Polar$$ExternalSyntheticLambda7(this, retry, 1), 1000L);
                }
            }
        }
    }

    public final void startLed(final boolean on, final int retry) {
        if (!isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_LED_ANIMATION) || !isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING) || !isReady(PolarBleApi.PolarBleSdkFeature.FEATURE_HR)) {
            final int i = 1;
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$$ExternalSyntheticLambda9
                public final /* synthetic */ Polar f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    int i3 = retry;
                    boolean z = on;
                    Polar polar = this.f$0;
                    switch (i2) {
                        case 0:
                            Polar.startLed$lambda$0(polar, z, i3);
                            break;
                        default:
                            Polar.startLed$lambda$1(polar, z, i3);
                            break;
                    }
                }
            }, 1000L);
            return;
        }
        try {
            led(on);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            Logger.logSevere(e);
            final int i2 = 0;
            this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.smartwatch.polar.Polar$$ExternalSyntheticLambda9
                public final /* synthetic */ Polar f$0;

                {
                    this.f$0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    int i3 = retry;
                    boolean z = on;
                    Polar polar = this.f$0;
                    switch (i22) {
                        case 0:
                            Polar.startLed$lambda$0(polar, z, i3);
                            break;
                        default:
                            Polar.startLed$lambda$1(polar, z, i3);
                            break;
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener listener) {
        startAccel$default(this, 0, 1, null);
        startHr$default(this, 0, 1, null);
        this.h.postDelayed(new Polar$$ExternalSyntheticLambda2(this, 1), 5000L);
        this.h.postDelayed(new Polar$$ExternalSyntheticLambda2(this, 2), 10000L);
        this.h.postDelayed(new Polar$$ExternalSyntheticLambda2(this, 3), 20000L);
        this.h.postDelayed(this.accelDataRunnable, this.vectorAggTime);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        led(false);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        try {
            this.h.removeCallbacks(this.accelDataRunnable);
            getApi().shutDown();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long timestamp) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long ts) {
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        return this.accelManager;
    }
}
