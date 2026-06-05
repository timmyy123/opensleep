package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHHueError;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeAPIListener {
    void onError(int i, String str);

    void onStateUpdate(Map<String, String> map, List<PHHueError> list);

    void onSuccess();
}
