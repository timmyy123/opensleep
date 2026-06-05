package com.facebook.internal;

import android.content.Context;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FetchedAppSettingsManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda0(Context context, String str, String str2) {
        this.$r8$classId = 2;
        this.f$1 = str;
        this.f$0 = context;
        this.f$2 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        String str = this.f$2;
        Context context = this.f$0;
        String str2 = this.f$1;
        switch (i) {
            case 0:
                FetchedAppSettingsManager.loadAppSettingsAsync$lambda$0(context, str2, str);
                break;
            case 1:
                OnDeviceProcessingManager.sendInstallEventAsync$lambda$0(context, str2, str);
                break;
            default:
                FetchedAppGateKeepersManager.loadAppGateKeepersAsync$lambda$0(str2, context, str);
                break;
        }
    }

    public /* synthetic */ FetchedAppSettingsManager$$ExternalSyntheticLambda0(Context context, int i, String str, String str2) {
        this.$r8$classId = i;
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = str2;
    }
}
