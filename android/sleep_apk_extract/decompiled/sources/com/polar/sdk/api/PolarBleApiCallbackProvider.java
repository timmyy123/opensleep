package com.polar.sdk.api;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.androidcommunications.api.ble.model.gatt.client.ChargeState;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.polar.sdk.api.model.PolarHrData;
import java.util.UUID;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\rH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0016\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/polar/sdk/api/PolarBleApiCallbackProvider;", "", "", "powered", "", "blePowerStateChanged", "(Z)V", "Lcom/polar/sdk/api/model/PolarDeviceInfo;", "polarDeviceInfo", "deviceConnected", "(Lcom/polar/sdk/api/model/PolarDeviceInfo;)V", "deviceConnecting", "deviceDisconnected", "", "identifier", "Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;", "feature", "bleSdkFeatureReady", "(Ljava/lang/String;Lcom/polar/sdk/api/PolarBleApi$PolarBleSdkFeature;)V", "Ljava/util/UUID;", "uuid", SDKConstants.PARAM_VALUE, "disInformationReceived", "(Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;)V", "Lcom/polar/androidcommunications/api/ble/model/DisInfo;", "disInfo", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/DisInfo;)V", "", "level", "batteryLevelReceived", "(Ljava/lang/String;I)V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;", "chargingStatus", "batteryChargingStatusReceived", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;)V", "Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;", "data", "hrNotificationReceived", "(Ljava/lang/String;Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;)V", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PolarBleApiCallbackProvider {
    void batteryChargingStatusReceived(String identifier, ChargeState chargingStatus);

    void batteryLevelReceived(String identifier, int level);

    void blePowerStateChanged(boolean powered);

    void bleSdkFeatureReady(String identifier, PolarBleApi.PolarBleSdkFeature feature);

    void deviceConnected(PolarDeviceInfo polarDeviceInfo);

    void deviceConnecting(PolarDeviceInfo polarDeviceInfo);

    void deviceDisconnected(PolarDeviceInfo polarDeviceInfo);

    void disInformationReceived(String identifier, DisInfo disInfo);

    void disInformationReceived(String identifier, UUID uuid, String value);

    void hrNotificationReceived(String identifier, PolarHrData.PolarHrSample data2);
}
