package com.google.firebase.ai.type;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LiveSession$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LiveSession f$0;

    public /* synthetic */ LiveSession$$ExternalSyntheticLambda1(LiveSession liveSession, int i) {
        this.$r8$classId = i;
        this.f$0 = liveSession;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        LiveSession liveSession = this.f$0;
        switch (i) {
            case 0:
                return LiveSession.stopAudioConversation$lambda$2(liveSession);
            case 1:
                return LiveSession.stopReceiving$lambda$4(liveSession);
            default:
                return LiveSession.receive$lambda$3(liveSession);
        }
    }
}
