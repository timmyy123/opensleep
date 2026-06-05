package com.facebook.login;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DeviceAuthDialog$$ExternalSyntheticLambda5 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ DeviceAuthDialog f$0;

    public /* synthetic */ DeviceAuthDialog$$ExternalSyntheticLambda5(DeviceAuthDialog deviceAuthDialog, int i) {
        this.$r8$classId = i;
        this.f$0 = deviceAuthDialog;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        DeviceAuthDialog deviceAuthDialog = this.f$0;
        switch (i) {
            case 0:
                DeviceAuthDialog._get_pollRequest_$lambda$5(deviceAuthDialog, graphResponse);
                break;
            default:
                DeviceAuthDialog.startLogin$lambda$1(deviceAuthDialog, graphResponse);
                break;
        }
    }
}
