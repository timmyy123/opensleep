package com.urbandroid.sleep.media;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayAudioActivity$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PlayAudioActivity f$0;

    public /* synthetic */ PlayAudioActivity$$ExternalSyntheticLambda11(PlayAudioActivity playAudioActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = playAudioActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        PlayAudioActivity playAudioActivity = this.f$0;
        switch (i) {
            case 0:
                playAudioActivity.lambda$onCreate$11();
                break;
            default:
                playAudioActivity.lambda$onCreate$0();
                break;
        }
    }
}
