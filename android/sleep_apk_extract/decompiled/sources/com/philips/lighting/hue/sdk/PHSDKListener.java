package com.philips.lighting.hue.sdk;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHSDKListener {
    void onAccessPointsFound(List<PHAccessPoint> list);

    void onAuthenticationRequired(PHAccessPoint pHAccessPoint);

    void onBridgeConnected(PHBridge pHBridge, String str);

    void onCacheUpdated(List<Integer> list, PHBridge pHBridge);

    void onConnectionLost(PHAccessPoint pHAccessPoint);

    void onConnectionResumed(PHBridge pHBridge);

    void onError(int i, String str);

    void onParsingErrors(List<PHHueParsingError> list);
}
