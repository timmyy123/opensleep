package com.urbandroid.sleep.media.spotify;

import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import java.util.ArrayList;
import kaaes.spotify.webapi.android.models.UserPrivate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SpotifyServiceExecutor.ResultListener f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2(SpotifyServiceExecutor.ResultListener resultListener, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = resultListener;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        SpotifyServiceExecutor.ResultListener resultListener = this.f$0;
        switch (i) {
            case 0:
                return SpotifyServiceExecutor.AnonymousClass1.invokeSuspend$lambda$3(resultListener, (ArrayList) obj2, (SpotifyServiceExecutor) obj);
            default:
                return SpotifyServiceExecutor.C21361.invokeSuspend$lambda$0(resultListener, (UserPrivate) obj2, (SpotifyServiceExecutor) obj);
        }
    }
}
