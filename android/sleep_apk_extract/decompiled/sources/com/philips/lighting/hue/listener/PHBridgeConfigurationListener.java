package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHBridgeConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeConfigurationListener extends PHBridgeAPIListener {
    void onReceivingConfiguration(PHBridgeConfiguration pHBridgeConfiguration);
}
