package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHScene;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHSceneListener extends PHBridgeAPIListener {
    void onSceneReceived(PHScene pHScene);

    void onScenesReceived(List<PHScene> list);
}
