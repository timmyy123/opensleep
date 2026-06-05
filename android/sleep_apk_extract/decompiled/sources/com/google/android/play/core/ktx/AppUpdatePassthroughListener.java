package com.google.android.play.core.ktx;

import com.facebook.internal.ServerProtocol;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdatePassthroughListener;", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "listener", "Lkotlin/Function1;", "", "disposeAction", "<init>", "(Lcom/google/android/play/core/install/InstallStateUpdatedListener;Lkotlin/jvm/functions/Function1;)V", "Lcom/google/android/play/core/install/InstallState;", ServerProtocol.DIALOG_PARAM_STATE, "onStateUpdate", "(Lcom/google/android/play/core/install/InstallState;)V", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "getListener", "()Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "Lkotlin/jvm/functions/Function1;", "getDisposeAction", "()Lkotlin/jvm/functions/Function1;", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AppUpdatePassthroughListener implements InstallStateUpdatedListener {
    private final Function1<AppUpdatePassthroughListener, Unit> disposeAction;
    private final InstallStateUpdatedListener listener;

    /* JADX WARN: Multi-variable type inference failed */
    public AppUpdatePassthroughListener(InstallStateUpdatedListener installStateUpdatedListener, Function1<? super AppUpdatePassthroughListener, Unit> function1) {
        installStateUpdatedListener.getClass();
        function1.getClass();
        this.listener = installStateUpdatedListener;
        this.disposeAction = function1;
    }

    public final Function1<AppUpdatePassthroughListener, Unit> getDisposeAction() {
        return this.disposeAction;
    }

    public final InstallStateUpdatedListener getListener() {
        return this.listener;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(InstallState state) {
        state.getClass();
        this.listener.onStateUpdate(state);
        int iInstallStatus = state.installStatus();
        if (iInstallStatus == 0 || iInstallStatus == 11 || iInstallStatus == 5 || iInstallStatus == 6) {
            this.disposeAction.invoke(this);
        }
    }
}
