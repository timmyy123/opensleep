package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.ResultProcessor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContextChooseDialog$$ExternalSyntheticLambda0 implements CallbackManagerImpl.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FacebookDialogBase f$0;
    public final /* synthetic */ ResultProcessor f$1;

    public /* synthetic */ ContextChooseDialog$$ExternalSyntheticLambda0(FacebookDialogBase facebookDialogBase, ResultProcessor resultProcessor, int i) {
        this.$r8$classId = i;
        this.f$0 = facebookDialogBase;
        this.f$1 = resultProcessor;
    }

    @Override // com.facebook.internal.CallbackManagerImpl.Callback
    public final boolean onActivityResult(int i, Intent intent) {
        int i2 = this.$r8$classId;
        ResultProcessor resultProcessor = this.f$1;
        FacebookDialogBase facebookDialogBase = this.f$0;
        switch (i2) {
            case 0:
                return ContextChooseDialog.registerCallbackImpl$lambda$4((ContextChooseDialog) facebookDialogBase, (ContextChooseDialog$registerCallbackImpl$resultProcessor$1) resultProcessor, i, intent);
            case 1:
                return ContextCreateDialog.registerCallbackImpl$lambda$3((ContextCreateDialog) facebookDialogBase, (ContextCreateDialog$registerCallbackImpl$resultProcessor$1) resultProcessor, i, intent);
            case 2:
                return ContextSwitchDialog.registerCallbackImpl$lambda$3((ContextSwitchDialog) facebookDialogBase, (ContextSwitchDialog$registerCallbackImpl$resultProcessor$1) resultProcessor, i, intent);
            case 3:
                return TournamentJoinDialog.registerCallbackImpl$lambda$0((TournamentJoinDialog) facebookDialogBase, (TournamentJoinDialog$registerCallbackImpl$resultProcessor$1) resultProcessor, i, intent);
            default:
                return TournamentShareDialog.registerCallbackImpl$lambda$0((TournamentShareDialog) facebookDialogBase, (TournamentShareDialog$registerCallbackImpl$resultProcessor$1) resultProcessor, i, intent);
        }
    }
}
