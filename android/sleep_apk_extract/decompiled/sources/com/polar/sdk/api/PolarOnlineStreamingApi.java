package com.polar.sdk.api;

import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.model.PolarAccelerometerData;
import com.polar.sdk.api.model.PolarHrData;
import com.polar.sdk.api.model.PolarPpiData;
import com.polar.sdk.api.model.PolarSensorSetting;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/polar/sdk/api/PolarOnlineStreamingApi;", "", "", "identifier", "Lcom/polar/sdk/api/PolarBleApi$PolarDeviceDataType;", "feature", "Lio/reactivex/rxjava3/core/Single;", "Lcom/polar/sdk/api/model/PolarSensorSetting;", "requestStreamSettings", "(Ljava/lang/String;Lcom/polar/sdk/api/PolarBleApi$PolarDeviceDataType;)Lio/reactivex/rxjava3/core/Single;", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/PolarHrData;", "startHrStreaming", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Flowable;", "sensorSetting", "Lcom/polar/sdk/api/model/PolarAccelerometerData;", "startAccStreaming", "(Ljava/lang/String;Lcom/polar/sdk/api/model/PolarSensorSetting;)Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/sdk/api/model/PolarPpiData;", "startPpiStreaming", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PolarOnlineStreamingApi {
    Single<PolarSensorSetting> requestStreamSettings(String identifier, PolarBleApi.PolarDeviceDataType feature);

    Flowable<PolarAccelerometerData> startAccStreaming(String identifier, PolarSensorSetting sensorSetting);

    Flowable<PolarHrData> startHrStreaming(String identifier);

    Flowable<PolarPpiData> startPpiStreaming(String identifier);
}
