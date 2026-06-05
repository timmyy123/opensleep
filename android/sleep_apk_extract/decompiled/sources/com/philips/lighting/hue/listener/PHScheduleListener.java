package com.philips.lighting.hue.listener;

import com.philips.lighting.model.PHSchedule;

/* JADX INFO: loaded from: classes4.dex */
public interface PHScheduleListener extends PHBridgeAPIListener {
    void onCreated(PHSchedule pHSchedule);
}
