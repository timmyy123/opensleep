package com.urbandroid.sleep.media;

import android.media.MediaPlayer;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OneTimePlayer$$ExternalSyntheticLambda1 implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ OneTimePlayer$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i3) {
            case 0:
                return OneTimePlayer.lambda$play$1((Uri) obj, mediaPlayer, i, i2);
            default:
                return ((PlayAudioActivity) obj).lambda$onCreate$2(mediaPlayer, i, i2);
        }
    }
}
