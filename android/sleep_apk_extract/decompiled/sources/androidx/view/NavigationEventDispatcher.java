package androidx.view;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u001d\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0016\u0010\u0018J)\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u001f\u0010\"\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\rH\u0000¢\u0006\u0004\b!\u0010\u0018J\u001f\u0010$\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\rH\u0000¢\u0006\u0004\b#\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010%R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u001c\u0010(\u001a\u00020'8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b(\u0010*R*\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020'8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010)\u001a\u0004\b,\u0010*\"\u0004\b-\u0010.R\u001a\u00100\u001a\u00020/8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R \u00105\u001a\b\u0012\u0004\u0012\u00020\u0000048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001e\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0014048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00106¨\u0006<"}, d2 = {"Landroidx/navigationevent/NavigationEventDispatcher;", "", "parent", "Landroidx/navigationevent/OnBackCompletedFallback;", "onBackCompletedFallback", "<init>", "(Landroidx/navigationevent/NavigationEventDispatcher;Landroidx/navigationevent/OnBackCompletedFallback;)V", "(Landroidx/navigationevent/OnBackCompletedFallback;)V", "", "checkInvariants", "()V", "Landroidx/navigationevent/NavigationEventHandler;", "handler", "", "priority", "addHandler", "(Landroidx/navigationevent/NavigationEventHandler;I)V", "removeHandler$navigationevent", "(Landroidx/navigationevent/NavigationEventHandler;)V", "removeHandler", "Landroidx/navigationevent/NavigationEventInput;", "input", "addInput", "(Landroidx/navigationevent/NavigationEventInput;)V", "(Landroidx/navigationevent/NavigationEventInput;I)V", "direction", "Landroidx/navigationevent/NavigationEvent;", "event", "dispatchOnStarted$navigationevent", "(Landroidx/navigationevent/NavigationEventInput;ILandroidx/navigationevent/NavigationEvent;)V", "dispatchOnStarted", "dispatchOnProgressed$navigationevent", "dispatchOnProgressed", "dispatchOnCompleted$navigationevent", "dispatchOnCompleted", "dispatchOnCancelled$navigationevent", "dispatchOnCancelled", "Landroidx/navigationevent/NavigationEventDispatcher;", "Landroidx/navigationevent/OnBackCompletedFallback;", "", "isDisposed", "Z", "()Z", SDKConstants.PARAM_VALUE, IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "setEnabled", "(Z)V", "Landroidx/navigationevent/NavigationEventProcessor;", "sharedProcessor", "Landroidx/navigationevent/NavigationEventProcessor;", "getSharedProcessor$navigationevent", "()Landroidx/navigationevent/NavigationEventProcessor;", "", "childDispatchers", "Ljava/util/Set;", "getChildDispatchers$navigationevent", "()Ljava/util/Set;", "handlers", "inputs", "Companion", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationEventDispatcher {
    private final Set<NavigationEventDispatcher> childDispatchers;
    private final Set<NavigationEventHandler<?>> handlers;
    private final Set<NavigationEventInput> inputs;
    private boolean isDisposed;
    private boolean isEnabled;
    private final OnBackCompletedFallback onBackCompletedFallback;
    private NavigationEventDispatcher parent;
    private final NavigationEventProcessor sharedProcessor;

    private NavigationEventDispatcher(NavigationEventDispatcher navigationEventDispatcher, OnBackCompletedFallback onBackCompletedFallback) {
        NavigationEventProcessor navigationEventProcessor;
        this.parent = navigationEventDispatcher;
        this.onBackCompletedFallback = onBackCompletedFallback;
        this.isEnabled = true;
        this.sharedProcessor = (navigationEventDispatcher == null || (navigationEventProcessor = navigationEventDispatcher.sharedProcessor) == null) ? new NavigationEventProcessor() : navigationEventProcessor;
        this.childDispatchers = new LinkedHashSet();
        this.handlers = new LinkedHashSet();
        this.inputs = new LinkedHashSet();
        NavigationEventDispatcher navigationEventDispatcher2 = this.parent;
        if (navigationEventDispatcher2 != null) {
            navigationEventDispatcher2.childDispatchers.add(this);
        }
    }

    public static /* synthetic */ void addHandler$default(NavigationEventDispatcher navigationEventDispatcher, NavigationEventHandler navigationEventHandler, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        navigationEventDispatcher.addHandler(navigationEventHandler, i);
    }

    private final void checkInvariants() {
        if (isDisposed()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("This NavigationEventDispatcher has already been disposed and cannot be used.");
        }
    }

    private final boolean isDisposed() {
        NavigationEventDispatcher navigationEventDispatcher = this.parent;
        if (navigationEventDispatcher == null || !navigationEventDispatcher.isDisposed()) {
            return this.isDisposed;
        }
        return true;
    }

    public final void addHandler(NavigationEventHandler<?> handler, int priority) {
        handler.getClass();
        checkInvariants();
        if (this.handlers.add(handler)) {
            this.sharedProcessor.addHandler(this, handler, priority);
        }
    }

    public final void addInput(NavigationEventInput input, int priority) {
        input.getClass();
        checkInvariants();
        if (priority != 1 && priority != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(priority, "Unsupported priority value: "));
        } else if (this.inputs.add(input)) {
            this.sharedProcessor.addInput(this, input, priority);
        }
    }

    public final void dispatchOnCancelled$navigationevent(NavigationEventInput input, int direction) {
        input.getClass();
        checkInvariants();
        if (isEnabled()) {
            this.sharedProcessor.dispatchOnCancelled(input, direction);
        }
    }

    public final void dispatchOnCompleted$navigationevent(NavigationEventInput input, int direction) {
        input.getClass();
        checkInvariants();
        if (isEnabled()) {
            this.sharedProcessor.dispatchOnCompleted(input, direction, this.onBackCompletedFallback);
        }
    }

    public final void dispatchOnProgressed$navigationevent(NavigationEventInput input, int direction, NavigationEvent event) {
        input.getClass();
        event.getClass();
        checkInvariants();
        if (isEnabled()) {
            this.sharedProcessor.dispatchOnProgressed(input, direction, event);
        }
    }

    public final void dispatchOnStarted$navigationevent(NavigationEventInput input, int direction, NavigationEvent event) {
        input.getClass();
        checkInvariants();
        if (isEnabled()) {
            this.sharedProcessor.dispatchOnStarted(input, direction, event);
        }
    }

    /* JADX INFO: renamed from: getSharedProcessor$navigationevent, reason: from getter */
    public final NavigationEventProcessor getSharedProcessor() {
        return this.sharedProcessor;
    }

    public final boolean isEnabled() {
        NavigationEventDispatcher navigationEventDispatcher = this.parent;
        if (navigationEventDispatcher == null || navigationEventDispatcher.isEnabled()) {
            return this.isEnabled;
        }
        return false;
    }

    public final void removeHandler$navigationevent(NavigationEventHandler<?> handler) {
        handler.getClass();
        if (this.handlers.remove(handler)) {
            this.sharedProcessor.removeHandler(handler);
        }
    }

    public final void addInput(NavigationEventInput input) {
        input.getClass();
        checkInvariants();
        if (this.inputs.add(input)) {
            this.sharedProcessor.addInput(this, input, -1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationEventDispatcher(OnBackCompletedFallback onBackCompletedFallback) {
        this(null, onBackCompletedFallback);
        onBackCompletedFallback.getClass();
    }
}
