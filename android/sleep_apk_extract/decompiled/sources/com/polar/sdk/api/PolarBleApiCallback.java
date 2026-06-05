package com.polar.sdk.api;

import com.polar.androidcommunications.api.ble.model.gatt.client.ChargeState;
import com.polar.sdk.api.model.PolarHrData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/polar/sdk/api/PolarBleApiCallback;", "Lcom/polar/sdk/api/PolarBleApiCallbackProvider;", "<init>", "()V", "", "identifier", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;", "chargingStatus", "", "batteryChargingStatusReceived", "(Ljava/lang/String;Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;)V", "Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;", "data", "hrNotificationReceived", "(Ljava/lang/String;Lcom/polar/sdk/api/model/PolarHrData$PolarHrSample;)V", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PolarBleApiCallback implements PolarBleApiCallbackProvider {
    @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
    public void batteryChargingStatusReceived(String identifier, ChargeState chargingStatus) {
        identifier.getClass();
        chargingStatus.getClass();
    }

    @Override // com.polar.sdk.api.PolarBleApiCallbackProvider
    public void hrNotificationReceived(String identifier, PolarHrData.PolarHrSample data2) {
        identifier.getClass();
        data2.getClass();
    }
}
