package androidx.view;

import androidx.view.NavigationEventInfo;
import androidx.view.NavigationEventTransitionState;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0015¢\u0006\u0004\b\u0019\u0010\rJ\u000f\u0010\u001b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001a\u0010\rJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0015¢\u0006\u0004\b\u001c\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001d\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u001f\u0010\u0011J\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b \u0010\u0011J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010$\u001a\u00020\u000bH\u0000¢\u0006\u0004\b#\u0010\rJ\u000f\u0010%\u001a\u00020\u000bH\u0015¢\u0006\u0004\b%\u0010\rJ\u000f\u0010'\u001a\u00020\u000bH\u0000¢\u0006\u0004\b&\u0010\rJ\u000f\u0010(\u001a\u00020\u000bH\u0015¢\u0006\u0004\b(\u0010\rR$\u0010*\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u00008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R0\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R0\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000.8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R$\u00106\u001a\u0002052\u0006\u0010)\u001a\u0002058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010:\u001a\u0004\b\u0006\u0010;\"\u0004\b<\u0010=R*\u0010\u0007\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010:\u001a\u0004\b\u0007\u0010;\"\u0004\b>\u0010=R$\u0010@\u001a\u0004\u0018\u00010?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Landroidx/navigationevent/NavigationEventHandler;", "Landroidx/navigationevent/NavigationEventInfo;", "T", "", "initialInfo", "", "isBackEnabled", "isForwardEnabled", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;ZZ)V", "(Landroidx/navigationevent/NavigationEventInfo;Z)V", "", "remove", "()V", "Landroidx/navigationevent/NavigationEvent;", "event", "doOnBackStarted$navigationevent", "(Landroidx/navigationevent/NavigationEvent;)V", "doOnBackStarted", "onBackStarted", "doOnBackProgressed$navigationevent", "doOnBackProgressed", "onBackProgressed", "doOnBackCompleted$navigationevent", "doOnBackCompleted", "onBackCompleted", "doOnBackCancelled$navigationevent", "doOnBackCancelled", "onBackCancelled", "doOnForwardStarted$navigationevent", "doOnForwardStarted", "onForwardStarted", "doOnForwardProgressed$navigationevent", "doOnForwardProgressed", "onForwardProgressed", "doOnForwardCompleted$navigationevent", "doOnForwardCompleted", "onForwardCompleted", "doOnForwardCancelled$navigationevent", "doOnForwardCancelled", "onForwardCancelled", SDKConstants.PARAM_VALUE, "currentInfo", "Landroidx/navigationevent/NavigationEventInfo;", "getCurrentInfo", "()Landroidx/navigationevent/NavigationEventInfo;", "", "backInfo", "Ljava/util/List;", "getBackInfo", "()Ljava/util/List;", "forwardInfo", "getForwardInfo", "Landroidx/navigationevent/NavigationEventTransitionState;", "transitionState", "Landroidx/navigationevent/NavigationEventTransitionState;", "getTransitionState", "()Landroidx/navigationevent/NavigationEventTransitionState;", "Z", "()Z", "setBackEnabled", "(Z)V", "setForwardEnabled", "Landroidx/navigationevent/NavigationEventDispatcher;", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher$navigationevent", "()Landroidx/navigationevent/NavigationEventDispatcher;", "setDispatcher$navigationevent", "(Landroidx/navigationevent/NavigationEventDispatcher;)V", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class NavigationEventHandler<T extends NavigationEventInfo> {
    private List<? extends T> backInfo;
    private T currentInfo;
    private NavigationEventDispatcher dispatcher;
    private List<? extends T> forwardInfo;
    private boolean isBackEnabled;
    private boolean isForwardEnabled;
    private NavigationEventTransitionState transitionState;

    public NavigationEventHandler(T t, boolean z, boolean z2) {
        t.getClass();
        this.currentInfo = t;
        this.backInfo = CollectionsKt.emptyList();
        this.forwardInfo = CollectionsKt.emptyList();
        this.transitionState = NavigationEventTransitionState.Idle.INSTANCE;
        this.isBackEnabled = z;
        this.isForwardEnabled = z2;
    }

    public final void doOnBackCancelled$navigationevent() {
        this.transitionState = NavigationEventTransitionState.Idle.INSTANCE;
        onBackCancelled();
    }

    public final void doOnBackCompleted$navigationevent() {
        this.transitionState = NavigationEventTransitionState.Idle.INSTANCE;
        onBackCompleted();
    }

    public final void doOnBackProgressed$navigationevent(NavigationEvent event) {
        event.getClass();
        this.transitionState = new NavigationEventTransitionState.InProgress(event, -1);
        onBackProgressed(event);
    }

    public final void doOnBackStarted$navigationevent(NavigationEvent event) {
        event.getClass();
        this.transitionState = new NavigationEventTransitionState.InProgress(event, -1);
        onBackStarted(event);
    }

    public final void doOnForwardCancelled$navigationevent() {
        this.transitionState = NavigationEventTransitionState.Idle.INSTANCE;
        onForwardCancelled();
    }

    public final void doOnForwardCompleted$navigationevent() {
        this.transitionState = NavigationEventTransitionState.Idle.INSTANCE;
        onForwardCompleted();
    }

    public final void doOnForwardProgressed$navigationevent(NavigationEvent event) {
        event.getClass();
        this.transitionState = new NavigationEventTransitionState.InProgress(event, 1);
        onForwardProgressed(event);
    }

    public final void doOnForwardStarted$navigationevent(NavigationEvent event) {
        event.getClass();
        this.transitionState = new NavigationEventTransitionState.InProgress(event, 1);
        onForwardStarted(event);
    }

    public final List<T> getBackInfo() {
        return this.backInfo;
    }

    public final T getCurrentInfo() {
        return this.currentInfo;
    }

    /* JADX INFO: renamed from: getDispatcher$navigationevent, reason: from getter */
    public final NavigationEventDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final List<T> getForwardInfo() {
        return this.forwardInfo;
    }

    public final boolean isBackEnabled() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null || navigationEventDispatcher.isEnabled()) {
            return this.isBackEnabled;
        }
        return false;
    }

    public final boolean isForwardEnabled() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null || navigationEventDispatcher.isEnabled()) {
            return this.isForwardEnabled;
        }
        return false;
    }

    public abstract void onBackCancelled();

    public abstract void onBackCompleted();

    public abstract void onBackProgressed(NavigationEvent event);

    public abstract void onBackStarted(NavigationEvent event);

    public void onForwardCancelled() {
    }

    public void onForwardCompleted() {
        throw new UnsupportedOperationException("A handler that receives a 'forwardCompleted' event must override 'onForwardCompleted()' to handle the callback.");
    }

    public void onForwardProgressed(NavigationEvent event) {
        event.getClass();
    }

    public void onForwardStarted(NavigationEvent event) {
        event.getClass();
    }

    public final void remove() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher != null) {
            navigationEventDispatcher.removeHandler$navigationevent(this);
        }
    }

    public final void setBackEnabled(boolean z) {
        NavigationEventProcessor sharedProcessor;
        if (this.isBackEnabled == z) {
            return;
        }
        this.isBackEnabled = z;
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null || (sharedProcessor = navigationEventDispatcher.getSharedProcessor()) == null) {
            return;
        }
        sharedProcessor.refreshEnabledHandlers();
    }

    public final void setDispatcher$navigationevent(NavigationEventDispatcher navigationEventDispatcher) {
        this.dispatcher = navigationEventDispatcher;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationEventHandler(T t, boolean z) {
        this(t, z, false);
        t.getClass();
    }
}
