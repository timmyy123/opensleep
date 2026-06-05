package com.urbandroid.sleep.media;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaListAdapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MediaListAdapter f$0;

    public /* synthetic */ MediaListAdapter$$ExternalSyntheticLambda1(MediaListAdapter mediaListAdapter, int i) {
        this.$r8$classId = i;
        this.f$0 = mediaListAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        MediaListAdapter mediaListAdapter = this.f$0;
        switch (i) {
            case 0:
                mediaListAdapter.lambda$updateSelectedSong$2(view);
                break;
            case 1:
                mediaListAdapter.lambda$playPreview$13(view);
                break;
            case 2:
                mediaListAdapter.lambda$playPreview$11(view);
                break;
            case 3:
                mediaListAdapter.lambda$playPreview$7(view);
                break;
            case 4:
                mediaListAdapter.lambda$playPreview$9(view);
                break;
            case 5:
                mediaListAdapter.lambda$updateSelectedSong$3(view);
                break;
            case 6:
                mediaListAdapter.lambda$stopPlayer$14(view);
                break;
            case 7:
                mediaListAdapter.lambda$getView$1(view);
                break;
            default:
                mediaListAdapter.lambda$playPreview$6(view);
                break;
        }
    }
}
