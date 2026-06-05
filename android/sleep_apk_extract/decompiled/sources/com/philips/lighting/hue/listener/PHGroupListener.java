package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHGroup;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHGroupListener extends PHBridgeAPIListener {
    void onCreated(PHGroup pHGroup);

    void onReceivingAllGroups(List<PHBridgeResource> list);

    void onReceivingGroupDetails(PHGroup pHGroup);
}
