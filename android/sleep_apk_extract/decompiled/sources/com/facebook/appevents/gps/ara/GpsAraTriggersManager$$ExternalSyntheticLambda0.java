package com.facebook.appevents.gps.ara;

import com.facebook.appevents.AppEvent;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GpsAraTriggersManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ AppEvent f$1;

    public /* synthetic */ GpsAraTriggersManager$$ExternalSyntheticLambda0(String str, AppEvent appEvent, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
        this.f$1 = appEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                GpsAraTriggersManager.registerTriggerAsync$lambda$0(this.f$0, this.f$1);
                break;
            default:
                OnDeviceProcessingManager.sendCustomEventAsync$lambda$1(this.f$0, this.f$1);
                break;
        }
    }
}
