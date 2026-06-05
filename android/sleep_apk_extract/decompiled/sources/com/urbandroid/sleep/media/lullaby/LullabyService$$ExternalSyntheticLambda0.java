package com.urbandroid.sleep.media.lullaby;

import android.media.AudioManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyService$$ExternalSyntheticLambda0 implements AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ LullabyService$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        switch (this.$r8$classId) {
            case 0:
                LullabyService.lambda$onStartCommand$5(i);
                break;
            default:
                LullabyService.lambda$onDestroy$6(i);
                break;
        }
    }
}
