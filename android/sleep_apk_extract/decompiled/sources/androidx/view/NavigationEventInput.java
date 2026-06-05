package androidx.view;

import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0015¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0015¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0015¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0005¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0005¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0005¢\u0006\u0004\b\u001d\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\bR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/navigationevent/NavigationEventInput;", "", "<init>", "()V", "Landroidx/navigationevent/NavigationEventDispatcher;", "dispatcher", "", "doOnAdded$navigationevent", "(Landroidx/navigationevent/NavigationEventDispatcher;)V", "doOnAdded", "onAdded", "", "hasEnabledHandlers", "doOnHasEnabledHandlersChanged$navigationevent", "(Z)V", "doOnHasEnabledHandlersChanged", "onHasEnabledHandlersChanged", "Landroidx/navigationevent/NavigationEventHistory;", "history", "doOnHistoryChanged$navigationevent", "(Landroidx/navigationevent/NavigationEventHistory;)V", "doOnHistoryChanged", "onHistoryChanged", "Landroidx/navigationevent/NavigationEvent;", "event", "dispatchOnBackStarted", "(Landroidx/navigationevent/NavigationEvent;)V", "dispatchOnBackProgressed", "dispatchOnBackCancelled", "dispatchOnBackCompleted", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher$navigationevent", "()Landroidx/navigationevent/NavigationEventDispatcher;", "setDispatcher$navigationevent", "isPredictiveBackInProgress", "Z", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class NavigationEventInput {
    private NavigationEventDispatcher dispatcher;
    private boolean isPredictiveBackInProgress;

    public final void dispatchOnBackCancelled() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("This input is not added to any dispatcher.");
            return;
        }
        if (!this.isPredictiveBackInProgress) {
            navigationEventDispatcher.dispatchOnStarted$navigationevent(this, -1, null);
        }
        navigationEventDispatcher.dispatchOnCancelled$navigationevent(this, -1);
        this.isPredictiveBackInProgress = false;
    }

    public final void dispatchOnBackCompleted() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("This input is not added to any dispatcher.");
            return;
        }
        if (!this.isPredictiveBackInProgress) {
            navigationEventDispatcher.dispatchOnStarted$navigationevent(this, -1, null);
        }
        navigationEventDispatcher.dispatchOnCompleted$navigationevent(this, -1);
        this.isPredictiveBackInProgress = false;
    }

    public final void dispatchOnBackProgressed(NavigationEvent event) {
        event.getClass();
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("This input is not added to any dispatcher.");
        } else if (this.isPredictiveBackInProgress) {
            navigationEventDispatcher.dispatchOnProgressed$navigationevent(this, -1, event);
        }
    }

    public final void dispatchOnBackStarted(NavigationEvent event) {
        event.getClass();
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("This input is not added to any dispatcher.");
        } else {
            if (this.isPredictiveBackInProgress) {
                return;
            }
            navigationEventDispatcher.dispatchOnStarted$navigationevent(this, -1, event);
            this.isPredictiveBackInProgress = true;
        }
    }

    public final void doOnAdded$navigationevent(NavigationEventDispatcher dispatcher) {
        dispatcher.getClass();
        onAdded(dispatcher);
    }

    public final void doOnHasEnabledHandlersChanged$navigationevent(boolean hasEnabledHandlers) {
        onHasEnabledHandlersChanged(hasEnabledHandlers);
    }

    public final void doOnHistoryChanged$navigationevent(NavigationEventHistory history) {
        history.getClass();
        onHistoryChanged(history);
    }

    /* JADX INFO: renamed from: getDispatcher$navigationevent, reason: from getter */
    public final NavigationEventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public void onAdded(NavigationEventDispatcher dispatcher) {
        dispatcher.getClass();
    }

    public void onHasEnabledHandlersChanged(boolean hasEnabledHandlers) {
    }

    public void onHistoryChanged(NavigationEventHistory history) {
        history.getClass();
    }

    public final void setDispatcher$navigationevent(NavigationEventDispatcher navigationEventDispatcher) {
        this.dispatcher = navigationEventDispatcher;
    }
}
