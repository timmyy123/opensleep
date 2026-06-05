package com.polar.sdk.impl;

import android.util.Pair;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.ChargeState;
import com.polar.androidcommunications.api.ble.model.gatt.client.HealthThermometer;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdMeasurementType;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpUtils;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.PolarBleApiCallbackProvider;
import com.polar.sdk.api.model.PolarHrData;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/util/UUID;", "uuid", "Lorg/reactivestreams/Publisher;", "", "apply", "(Ljava/util/UUID;)Lorg/reactivestreams/Publisher;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
public final class BDBleApiImpl$setupDevice$disposable$2<T, R> implements Function {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ BleDeviceSession $session;
    final /* synthetic */ BDBleApiImpl this$0;

    public BDBleApiImpl$setupDevice$disposable$2(BleDeviceSession bleDeviceSession, BDBleApiImpl bDBleApiImpl, String str) {
        this.$session = bleDeviceSession;
        this.this$0 = bDBleApiImpl;
        this.$deviceId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$0(BDBleApiImpl bDBleApiImpl, String str) {
        bDBleApiImpl.getClass();
        PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl.callback;
        if (polarBleApiCallbackProvider != null) {
            str.getClass();
            polarBleApiCallbackProvider.bleSdkFeatureReady(str, PolarBleApi.PolarBleSdkFeature.FEATURE_HR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void apply$lambda$3(BDBleApiImpl bDBleApiImpl, String str) {
        bDBleApiImpl.getClass();
        PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl.callback;
        if (polarBleApiCallbackProvider != null) {
            str.getClass();
            polarBleApiCallbackProvider.bleSdkFeatureReady(str, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_FILE_TRANSFER);
        }
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public final Publisher<? extends Object> apply(UUID uuid) {
        Flowable<ChargeState> flowableMonitorChargingStatus;
        Flowable<ChargeState> flowableObserveOn;
        Flowable<Integer> flowableMonitorBatteryStatus;
        Flowable<Integer> flowableObserveOn2;
        Flowable<BleHrClient.HrNotificationData> flowableObserveHrNotifications;
        Flowable<BleHrClient.HrNotificationData> flowableObserveOn3;
        uuid.getClass();
        if (this.$session.fetchClient(uuid) != null) {
            BleHrClient.Companion companion = BleHrClient.INSTANCE;
            int i = 1;
            if (Intrinsics.areEqual(uuid, companion.getHR_SERVICE())) {
                Completable.fromAction(new BDBleApiImpl$$ExternalSyntheticLambda3(this.this$0, this.$deviceId, i)).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
                BleHrClient bleHrClient = (BleHrClient) this.$session.fetchClient(companion.getHR_SERVICE());
                if (bleHrClient != null && (flowableObserveHrNotifications = bleHrClient.observeHrNotifications(true)) != null && (flowableObserveOn3 = flowableObserveHrNotifications.observeOn(AndroidSchedulers.mainThread())) != null) {
                    final BDBleApiImpl bDBleApiImpl = this.this$0;
                    final String str = this.$deviceId;
                    Consumer<? super BleHrClient.HrNotificationData> consumer = new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.2
                        @Override // io.reactivex.rxjava3.functions.Consumer
                        public final void accept(BleHrClient.HrNotificationData hrNotificationData) {
                            hrNotificationData.getClass();
                            PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl.callback;
                            if (polarBleApiCallbackProvider != null) {
                                String str2 = str;
                                str2.getClass();
                                polarBleApiCallbackProvider.hrNotificationReceived(str2, new PolarHrData.PolarHrSample(hrNotificationData.getHrValue(), 0, 0, hrNotificationData.getRrsMs(), hrNotificationData.getRrPresent(), hrNotificationData.getSensorContact(), hrNotificationData.getSensorContactSupported()));
                            }
                        }
                    };
                    final BDBleApiImpl bDBleApiImpl2 = this.this$0;
                    flowableObserveOn3.subscribe(consumer, new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.3
                        @Override // io.reactivex.rxjava3.functions.Consumer
                        public final void accept(Throwable th) {
                            th.getClass();
                            String message = th.getMessage();
                            if (message != null) {
                                bDBleApiImpl2.logError(message);
                            }
                        }
                    }, new BDBleApiImpl$$ExternalSyntheticLambda1(i));
                }
            } else {
                UUID uuid2 = BleBattClient.BATTERY_SERVICE;
                int i2 = 2;
                if (Intrinsics.areEqual(uuid, uuid2)) {
                    BleBattClient bleBattClient = (BleBattClient) this.$session.fetchClient(uuid2);
                    if (bleBattClient != null && (flowableMonitorBatteryStatus = bleBattClient.monitorBatteryStatus(true)) != null && (flowableObserveOn2 = flowableMonitorBatteryStatus.observeOn(AndroidSchedulers.mainThread())) != null) {
                        final BDBleApiImpl bDBleApiImpl3 = this.this$0;
                        final String str2 = this.$deviceId;
                        Consumer<? super Integer> consumer2 = new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.5
                            @Override // io.reactivex.rxjava3.functions.Consumer
                            public final void accept(Integer num) {
                                PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl3.callback;
                                if (polarBleApiCallbackProvider != null) {
                                    String str3 = str2;
                                    str3.getClass();
                                    num.getClass();
                                    polarBleApiCallbackProvider.batteryLevelReceived(str3, num.intValue());
                                }
                            }
                        };
                        final BDBleApiImpl bDBleApiImpl4 = this.this$0;
                        flowableObserveOn2.subscribe(consumer2, new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.6
                            @Override // io.reactivex.rxjava3.functions.Consumer
                            public final void accept(Throwable th) {
                                th.getClass();
                                String message = th.getMessage();
                                if (message != null) {
                                    bDBleApiImpl4.logError(message);
                                }
                            }
                        }, new BDBleApiImpl$$ExternalSyntheticLambda1(i2));
                    }
                    if (bleBattClient != null && (flowableMonitorChargingStatus = bleBattClient.monitorChargingStatus(true)) != null && (flowableObserveOn = flowableMonitorChargingStatus.observeOn(AndroidSchedulers.mainThread())) != null) {
                        final BDBleApiImpl bDBleApiImpl5 = this.this$0;
                        final String str3 = this.$deviceId;
                        Consumer<? super ChargeState> consumer3 = new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.8
                            @Override // io.reactivex.rxjava3.functions.Consumer
                            public final void accept(ChargeState chargeState) {
                                PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl5.callback;
                                if (polarBleApiCallbackProvider != null) {
                                    String str4 = str3;
                                    str4.getClass();
                                    chargeState.getClass();
                                    polarBleApiCallbackProvider.batteryChargingStatusReceived(str4, chargeState);
                                }
                            }
                        };
                        final BDBleApiImpl bDBleApiImpl6 = this.this$0;
                        flowableObserveOn.subscribe(consumer3, new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.9
                            @Override // io.reactivex.rxjava3.functions.Consumer
                            public final void accept(Throwable th) {
                                th.getClass();
                                String message = th.getMessage();
                                if (message != null) {
                                    bDBleApiImpl6.logError(message);
                                }
                            }
                        });
                    }
                } else {
                    UUID uuid3 = BlePMDClient.PMD_SERVICE;
                    if (Intrinsics.areEqual(uuid, uuid3)) {
                        BlePMDClient blePMDClient = (BlePMDClient) this.$session.fetchClient(uuid3);
                        if (blePMDClient != null) {
                            Completable completableClientReady = blePMDClient.clientReady(true);
                            Single<Set<PmdMeasurementType>> singleObserveOn = blePMDClient.readFeature(true).observeOn(AndroidSchedulers.mainThread());
                            final BDBleApiImpl bDBleApiImpl7 = this.this$0;
                            final String str4 = this.$deviceId;
                            return completableClientReady.andThen(singleObserveOn.doOnSuccess(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.10
                                @Override // io.reactivex.rxjava3.functions.Consumer
                                public final void accept(Set<? extends PmdMeasurementType> set) {
                                    PolarBleApiCallbackProvider polarBleApiCallbackProvider;
                                    set.getClass();
                                    PolarBleApiCallbackProvider polarBleApiCallbackProvider2 = bDBleApiImpl7.callback;
                                    if (polarBleApiCallbackProvider2 != null) {
                                        String str5 = str4;
                                        str5.getClass();
                                        polarBleApiCallbackProvider2.bleSdkFeatureReady(str5, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_ONLINE_STREAMING);
                                    }
                                    if (!set.contains(PmdMeasurementType.SDK_MODE) || (polarBleApiCallbackProvider = bDBleApiImpl7.callback) == null) {
                                        return;
                                    }
                                    String str6 = str4;
                                    str6.getClass();
                                    polarBleApiCallbackProvider.bleSdkFeatureReady(str6, PolarBleApi.PolarBleSdkFeature.FEATURE_POLAR_SDK_MODE);
                                }
                            })).toFlowable();
                        }
                    } else {
                        UUID uuid4 = BleDisClient.DIS_SERVICE;
                        if (Intrinsics.areEqual(uuid, uuid4)) {
                            BleDisClient bleDisClient = (BleDisClient) this.$session.fetchClient(uuid4);
                            if (bleDisClient != null) {
                                Flowable<Pair<UUID, String>> flowableObserveOn4 = bleDisClient.observeDisInfo(true).observeOn(AndroidSchedulers.mainThread());
                                final BDBleApiImpl bDBleApiImpl8 = this.this$0;
                                final String str5 = this.$deviceId;
                                Flowable<Pair<UUID, String>> flowableDoOnNext = flowableObserveOn4.doOnNext(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.11
                                    @Override // io.reactivex.rxjava3.functions.Consumer
                                    public final void accept(Pair<UUID, String> pair) {
                                        pair.getClass();
                                        PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl8.callback;
                                        if (polarBleApiCallbackProvider != null) {
                                            String str6 = str5;
                                            str6.getClass();
                                            Object obj = pair.first;
                                            obj.getClass();
                                            Object obj2 = pair.second;
                                            obj2.getClass();
                                            polarBleApiCallbackProvider.disInformationReceived(str6, (UUID) obj, (String) obj2);
                                        }
                                    }
                                });
                                Flowable<DisInfo> flowableObserveOn5 = bleDisClient.observeDisInfoWithKeysAsStrings(true).observeOn(AndroidSchedulers.mainThread());
                                final BDBleApiImpl bDBleApiImpl9 = this.this$0;
                                final String str6 = this.$deviceId;
                                return Flowable.merge(flowableDoOnNext, flowableObserveOn5.doOnNext(new Consumer() { // from class: com.polar.sdk.impl.BDBleApiImpl$setupDevice$disposable$2.12
                                    @Override // io.reactivex.rxjava3.functions.Consumer
                                    public final void accept(DisInfo disInfo) {
                                        disInfo.getClass();
                                        PolarBleApiCallbackProvider polarBleApiCallbackProvider = bDBleApiImpl9.callback;
                                        if (polarBleApiCallbackProvider != null) {
                                            String str7 = str6;
                                            str7.getClass();
                                            polarBleApiCallbackProvider.disInformationReceived(str7, disInfo);
                                        }
                                    }
                                }));
                            }
                        } else {
                            UUID uuid5 = BlePsFtpUtils.RFC77_PFTP_SERVICE;
                            if (Intrinsics.areEqual(uuid, uuid5)) {
                                BlePsFtpClient blePsFtpClient = (BlePsFtpClient) this.$session.fetchClient(uuid5);
                                if (blePsFtpClient != null) {
                                    return blePsFtpClient.clientReady(true).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new BDBleApiImpl$$ExternalSyntheticLambda3(this.this$0, this.$deviceId, i2)).toFlowable();
                                }
                            } else {
                                HealthThermometer.Companion companion2 = HealthThermometer.INSTANCE;
                                if (Intrinsics.areEqual(uuid, companion2.getHTS_SERVICE()) && this.$session.fetchClient(companion2.getHTS_SERVICE()) != null) {
                                    Events$$ExternalSyntheticBUOutline0.m();
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
        }
        return Flowable.empty();
    }
}
