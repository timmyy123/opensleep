package com.facebook;

import com.facebook.GraphRequest;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushStatistics;
import com.facebook.appevents.SessionEventsState;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessTokenManager$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AccessTokenManager$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1((AtomicBoolean) obj4, (HashSet) obj3, (HashSet) obj2, (HashSet) obj, graphResponse);
                break;
            case 1:
                AppEventQueue.buildRequestForSession$lambda$4((AccessTokenAppIdPair) obj4, (GraphRequest) obj3, (SessionEventsState) obj2, (FlushStatistics) obj, graphResponse);
                break;
            default:
                DeviceAuthDialog.onSuccess$lambda$10((DeviceAuthDialog) obj4, (String) obj3, (Date) obj2, (Date) obj, graphResponse);
                break;
        }
    }
}
