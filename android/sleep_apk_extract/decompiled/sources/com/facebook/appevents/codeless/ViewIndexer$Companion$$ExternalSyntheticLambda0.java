package com.facebook.appevents.codeless;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.codeless.ViewIndexer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewIndexer$Companion$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ViewIndexer$Companion$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        switch (this.$r8$classId) {
            case 0:
                ViewIndexer.Companion.buildAppIndexingRequest$lambda$0(graphResponse);
                break;
            default:
                AppEventsCAPIManager.enable$lambda$0(graphResponse);
                break;
        }
    }
}
