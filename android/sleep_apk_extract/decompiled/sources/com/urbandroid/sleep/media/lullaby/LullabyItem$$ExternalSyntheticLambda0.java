package com.urbandroid.sleep.media.lullaby;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyItem$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LullabyItem$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((LullabyItem) obj).onItemClicked();
                break;
            case 1:
                LullabyActivity.updatePlaying$lambda$1((LullabyActivity) obj, view);
                break;
            case 2:
                LullabyRadioItem.bindView$lambda$0((LullabyRadioItem) obj, view);
                break;
            default:
                LullabySpotifyConnectItem.bindView$lambda$0((LullabySpotifyConnectItem) obj, view);
                break;
        }
    }
}
