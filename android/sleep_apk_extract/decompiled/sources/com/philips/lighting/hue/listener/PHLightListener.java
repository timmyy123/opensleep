package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHLight;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHLightListener extends PHBridgeAPIListener {
    void onReceivingLightDetails(PHLight pHLight);

    void onReceivingLights(List<PHBridgeResource> list);

    void onSearchComplete();
}
