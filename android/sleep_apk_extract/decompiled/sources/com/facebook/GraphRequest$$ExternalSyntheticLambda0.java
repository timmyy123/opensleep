package com.facebook;

import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GraphRequest$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ GraphRequest$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                GraphRequest._set_callback_$lambda$0((GraphRequest.Callback) obj, graphResponse);
                break;
            case 1:
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$2((AccessTokenManager.RefreshResult) obj, graphResponse);
                break;
            case 2:
                GraphRequest.Companion.newPlacesSearchRequest$lambda$1((GraphRequest.GraphJSONArrayCallback) obj, graphResponse);
                break;
            default:
                GraphRequest.Companion.newMeRequest$lambda$0((GraphRequest.GraphJSONObjectCallback) obj, graphResponse);
                break;
        }
    }
}
