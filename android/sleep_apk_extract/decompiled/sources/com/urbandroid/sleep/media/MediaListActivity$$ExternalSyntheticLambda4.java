package com.urbandroid.sleep.media;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaListActivity$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda4(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((MediaListActivity) obj).lambda$onPostResumeAfterRecreate$6();
                break;
            default:
                ((File) obj).delete();
                break;
        }
    }
}
