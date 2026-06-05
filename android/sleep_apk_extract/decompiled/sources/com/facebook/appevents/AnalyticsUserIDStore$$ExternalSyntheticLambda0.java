package com.facebook.appevents;

import com.facebook.appevents.codeless.CodelessManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnalyticsUserIDStore$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ AnalyticsUserIDStore$$ExternalSyntheticLambda0(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        String str = this.f$0;
        switch (i) {
            case 0:
                AnalyticsUserIDStore.setUserID$lambda$1(str);
                break;
            default:
                CodelessManager.checkCodelessSession$lambda$1(str);
                break;
        }
    }
}
