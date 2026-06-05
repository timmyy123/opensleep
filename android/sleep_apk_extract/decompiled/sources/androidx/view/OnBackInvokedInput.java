package androidx.view;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0011\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Landroidx/navigationevent/OnBackInvokedInput;", "Landroidx/navigationevent/NavigationEventInput;", "Landroid/window/OnBackInvokedDispatcher;", "onBackInvokedDispatcher", "", "onBackInvokedCallbackPriority", "<init>", "(Landroid/window/OnBackInvokedDispatcher;I)V", "", "shouldBeRegistered", "", "updateBackInvokedCallbackState", "(Z)V", "Landroid/window/OnBackInvokedCallback;", "createOnBackAnimationCallback", "()Landroid/window/OnBackInvokedCallback;", "hasEnabledHandlers", "onHasEnabledHandlersChanged", "Landroid/window/OnBackInvokedDispatcher;", "I", "onBackInvokedCallback", "Landroid/window/OnBackInvokedCallback;", "backInvokedCallbackRegistered", "Z", "Landroidx/navigationevent/OnBackInvokedDefaultInput;", "Landroidx/navigationevent/OnBackInvokedOverlayInput;", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class OnBackInvokedInput extends NavigationEventInput {
    private boolean backInvokedCallbackRegistered;
    private final OnBackInvokedCallback onBackInvokedCallback;
    private final int onBackInvokedCallbackPriority;
    private final OnBackInvokedDispatcher onBackInvokedDispatcher;

    private OnBackInvokedInput(OnBackInvokedDispatcher onBackInvokedDispatcher, int i) {
        this.onBackInvokedDispatcher = onBackInvokedDispatcher;
        this.onBackInvokedCallbackPriority = i;
        this.onBackInvokedCallback = Build.VERSION.SDK_INT == 33 ? new OnBackInvokedInput$$ExternalSyntheticLambda0(this, 0) : createOnBackAnimationCallback();
    }

    private final OnBackInvokedCallback createOnBackAnimationCallback() {
        return new OnBackAnimationCallback() { // from class: androidx.navigationevent.OnBackInvokedInput.createOnBackAnimationCallback.1
            public void onBackCancelled() {
                OnBackInvokedInput.this.dispatchOnBackCancelled();
            }

            public void onBackInvoked() {
                OnBackInvokedInput.this.dispatchOnBackCompleted();
            }

            public void onBackProgressed(BackEvent backEvent) {
                backEvent.getClass();
                OnBackInvokedInput.this.dispatchOnBackProgressed(NavigationEvent_androidKt.NavigationEvent(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                backEvent.getClass();
                OnBackInvokedInput.this.dispatchOnBackStarted(NavigationEvent_androidKt.NavigationEvent(backEvent));
            }
        };
    }

    private final void updateBackInvokedCallbackState(boolean shouldBeRegistered) {
        if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
            this.onBackInvokedDispatcher.registerOnBackInvokedCallback(this.onBackInvokedCallbackPriority, this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = true;
        } else {
            if (shouldBeRegistered || !this.backInvokedCallbackRegistered) {
                return;
            }
            this.onBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.onBackInvokedCallback);
            this.backInvokedCallbackRegistered = false;
        }
    }

    @Override // androidx.view.NavigationEventInput
    public void onHasEnabledHandlersChanged(boolean hasEnabledHandlers) {
        updateBackInvokedCallbackState(hasEnabledHandlers);
    }

    public /* synthetic */ OnBackInvokedInput(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onBackInvokedDispatcher, i);
    }
}
