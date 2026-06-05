package androidx.core.view;

import androidx.view.ComponentActivity;
import androidx.view.Lifecycle;
import androidx.view.LifecycleController;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnBackPressedDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((MenuHostHelper) obj2).lambda$addMenuProvider$0((MenuProvider) obj, lifecycleOwner, event);
                break;
            case 1:
                ComponentActivity.addObserverForBackInvoker$lambda$0((OnBackPressedDispatcher) obj2, (ComponentActivity) obj, lifecycleOwner, event);
                break;
            default:
                LifecycleController.observer$lambda$0((LifecycleController) obj2, (Job) obj, lifecycleOwner, event);
                break;
        }
    }
}
