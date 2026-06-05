package com.facebook.appevents;

import com.facebook.appevents.suggestedevents.ViewOnClickListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserDataStore$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ UserDataStore$$ExternalSyntheticLambda1(String str, String str2, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
        this.f$1 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        String str = this.f$1;
        String str2 = this.f$0;
        switch (i) {
            case 0:
                UserDataStore.writeDataIntoCache$lambda$0(str2, str);
                break;
            default:
                ViewOnClickListener.Companion.queryHistoryAndProcess$lambda$0(str2, str);
                break;
        }
    }
}
