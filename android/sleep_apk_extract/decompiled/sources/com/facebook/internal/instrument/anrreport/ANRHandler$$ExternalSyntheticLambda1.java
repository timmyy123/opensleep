package com.facebook.internal.instrument.anrreport;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ANRHandler$$ExternalSyntheticLambda1 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ ANRHandler$$ExternalSyntheticLambda1(List list, int i) {
        this.$r8$classId = i;
        this.f$0 = list;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        List list = this.f$0;
        switch (i) {
            case 0:
                ANRHandler.sendANRReports$lambda$5(list, graphResponse);
                break;
            default:
                CrashHandler.Companion.sendExceptionReports$lambda$5(list, graphResponse);
                break;
        }
    }
}
