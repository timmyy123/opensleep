package com.facebook.internal;

import android.util.Pair;
import androidx.view.result.ActivityResultCallback;
import com.facebook.CallbackManager;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogPresenter$$ExternalSyntheticLambda0 implements ActivityResultCallback, SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ DialogPresenter$$ExternalSyntheticLambda0(CallbackManager callbackManager, int i, Ref$ObjectRef ref$ObjectRef) {
        this.f$0 = callbackManager;
        this.f$1 = i;
        this.f$2 = ref$ObjectRef;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((Uploader) this.f$0).lambda$upload$0((TransportContext) this.f$2, this.f$1);
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        DialogPresenter.startActivityForResultWithAndroidX$lambda$2((CallbackManager) this.f$0, this.f$1, (Ref$ObjectRef) this.f$2, (Pair) obj);
    }

    public /* synthetic */ DialogPresenter$$ExternalSyntheticLambda0(Uploader uploader, TransportContext transportContext, int i) {
        this.f$0 = uploader;
        this.f$2 = transportContext;
        this.f$1 = i;
    }
}
