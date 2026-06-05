package com.urbandroid.sleep.media;

import android.view.View;
import com.urbandroid.sleep.media.MediaListAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaListActivity$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((MediaListActivity) obj).lambda$onCreate$0(view);
                break;
            case 1:
                ((MediaListAdapter.AnonymousClass2) obj).lambda$playbackStarted$0(view);
                break;
            default:
                ((MediaListAdapter.AnonymousClass2) obj).lambda$fail$1(view);
                break;
        }
    }
}
