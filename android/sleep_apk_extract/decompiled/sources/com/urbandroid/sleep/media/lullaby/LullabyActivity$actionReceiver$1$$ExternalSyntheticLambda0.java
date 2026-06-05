package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabyActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyActivity$actionReceiver$1$$ExternalSyntheticLambda0 implements MediaListActivity.LoadAlbumListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LullabyActivity f$0;

    public /* synthetic */ LullabyActivity$actionReceiver$1$$ExternalSyntheticLambda0(LullabyActivity lullabyActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = lullabyActivity;
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.LoadAlbumListener
    public final void finished() {
        int i = this.$r8$classId;
        LullabyActivity lullabyActivity = this.f$0;
        switch (i) {
            case 0:
                LullabyActivity$actionReceiver$1.onReceive$lambda$0(lullabyActivity);
                break;
            default:
                LullabyActivity.AnonymousClass1.success$lambda$0(lullabyActivity);
                break;
        }
    }
}
