package com.facebook.gamingservices;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TournamentFetcher$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TaskCompletionSource f$0;

    public /* synthetic */ TournamentFetcher$$ExternalSyntheticLambda0(TaskCompletionSource taskCompletionSource, int i) {
        this.$r8$classId = i;
        this.f$0 = taskCompletionSource;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        TaskCompletionSource taskCompletionSource = this.f$0;
        switch (i) {
            case 0:
                TournamentFetcher.fetchTournaments$lambda$1(taskCompletionSource, graphResponse);
                break;
            default:
                TournamentUpdater.update$lambda$0(taskCompletionSource, graphResponse);
                break;
        }
    }
}
