package com.urbandroid.sleep.media;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaListAdapter$$ExternalSyntheticLambda5 implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MediaListAdapter$$ExternalSyntheticLambda5(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((MediaListAdapter) obj).lambda$stopPlayer$15(mediaPlayer);
                break;
            default:
                ((PlayAudioActivity) obj).lambda$onCreate$12(mediaPlayer);
                break;
        }
    }
}
