package com.google.firebase;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class FirebaseApp$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(Context context, String str) {
        this.f$1 = context;
        this.f$0 = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        Context context = this.f$1;
        switch (i) {
            case 0:
                return ((FirebaseApp) obj).lambda$new$0(context);
            default:
                return DefaultHeartBeatController.lambda$new$2(context, (String) obj);
        }
    }

    public /* synthetic */ FirebaseApp$$ExternalSyntheticLambda0(FirebaseApp firebaseApp, Context context) {
        this.f$0 = firebaseApp;
        this.f$1 = context;
    }
}
