package com.facebook;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FacebookSdk$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FacebookSdk$$ExternalSyntheticLambda2(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                return FacebookSdk.sdkInitialize$lambda$3();
            default:
                return AndroidSchedulers.MainHolder.DEFAULT;
        }
    }
}
