package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.sleep.media.lullaby.LullabyPlayer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyPlayer$PlayRunnable$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LullabyPlayer.PlayRunnable f$0;

    public /* synthetic */ LullabyPlayer$PlayRunnable$$ExternalSyntheticLambda0(LullabyPlayer.PlayRunnable playRunnable, int i) {
        this.$r8$classId = i;
        this.f$0 = playRunnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        LullabyPlayer.PlayRunnable playRunnable = this.f$0;
        switch (i) {
            case 0:
                playRunnable.lambda$stop$0();
                break;
            default:
                playRunnable.lambda$run$1();
                break;
        }
    }
}
