package androidx.view;

import android.window.OnBackInvokedDispatcher;
import androidx.core.util.Consumer;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.NavigationEventDispatcher;
import androidx.view.NavigationEventInput;
import androidx.view.OnBackInvokedDefaultInput;
import androidx.view.OnBackInvokedOverlayInput;
import androidx.view.OnBackPressedCallback;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001%B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001f\u0010 \u001a\u00060\u001bR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "Ljava/lang/Runnable;", "fallbackOnBackPressed", "Landroidx/core/util/Consumer;", "", "onHasEnabledCallbacksChanged", "<init>", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "(Ljava/lang/Runnable;)V", "Landroid/window/OnBackInvokedDispatcher;", "invoker", "", "setOnBackInvokedDispatcher", "(Landroid/window/OnBackInvokedDispatcher;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "addCallback", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V", "onBackPressed", "()V", "Ljava/lang/Runnable;", "Landroidx/core/util/Consumer;", "hasEnabledCallbacks", "Z", "Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "eventInput$delegate", "Lkotlin/Lazy;", "getEventInput", "()Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "eventInput", "Landroidx/navigationevent/NavigationEventDispatcher;", "getEventDispatcher$activity", "()Landroidx/navigationevent/NavigationEventDispatcher;", "eventDispatcher", "OnBackPressedEventInput", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: eventInput$delegate, reason: from kotlin metadata */
    private final Lazy eventInput;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedEventInput;", "Landroidx/navigationevent/NavigationEventInput;", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;)V", "", "hasEnabledHandlers", "", "onHasEnabledHandlersChanged", "(Z)V", "backCompleted", "()V", "Landroidx/navigationevent/NavigationEventDispatcher;", "dispatcher", "Landroidx/navigationevent/NavigationEventDispatcher;", "getDispatcher", "()Landroidx/navigationevent/NavigationEventDispatcher;", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OnBackPressedEventInput extends NavigationEventInput {
        private final NavigationEventDispatcher dispatcher;

        public OnBackPressedEventInput() {
            NavigationEventDispatcher navigationEventDispatcher = new NavigationEventDispatcher(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(OnBackPressedDispatcher.this));
            navigationEventDispatcher.addInput(this);
            this.dispatcher = navigationEventDispatcher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void dispatcher$lambda$0(OnBackPressedDispatcher onBackPressedDispatcher) {
            Runnable runnable = onBackPressedDispatcher.fallbackOnBackPressed;
            if (runnable != null) {
                runnable.run();
            }
        }

        public final void backCompleted() {
            dispatchOnBackCompleted();
        }

        public final NavigationEventDispatcher getDispatcher() {
            return this.dispatcher;
        }

        @Override // androidx.view.NavigationEventInput
        public void onHasEnabledHandlersChanged(boolean hasEnabledHandlers) {
            OnBackPressedDispatcher.this.hasEnabledCallbacks = hasEnabledHandlers;
            Consumer consumer = OnBackPressedDispatcher.this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(hasEnabledHandlers));
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        this.fallbackOnBackPressed = runnable;
        this.onHasEnabledCallbacksChanged = consumer;
        this.eventInput = LazyKt.lazy(new ComponentDialog$$ExternalSyntheticLambda0(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBackPressedEventInput eventInput_delegate$lambda$0(OnBackPressedDispatcher onBackPressedDispatcher) {
        return onBackPressedDispatcher.new OnBackPressedEventInput();
    }

    private final OnBackPressedEventInput getEventInput() {
        return (OnBackPressedEventInput) this.eventInput.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.activity.OnBackPressedDispatcher$addCallback$observer$1, androidx.lifecycle.LifecycleObserver] */
    public final void addCallback(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        owner.getClass();
        onBackPressedCallback.getClass();
        final Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            return;
        }
        final OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandlerCreateNavigationEventHandler$activity = onBackPressedCallback.createNavigationEventHandler$activity(new OnBackPressedCallbackInfo(onBackPressedCallback, owner));
        if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
            onBackPressedEventHandlerCreateNavigationEventHandler$activity.setLifecycleActive(false);
            NavigationEventDispatcher.addHandler$default(getEventDispatcher$activity(), onBackPressedEventHandlerCreateNavigationEventHandler$activity, 0, 2, null);
        }
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.activity.OnBackPressedDispatcher$addCallback$observer$1

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.view.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                source.getClass();
                event.getClass();
                int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1) {
                    if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                        onBackPressedEventHandlerCreateNavigationEventHandler$activity.setLifecycleActive(true);
                        return;
                    } else {
                        NavigationEventDispatcher.addHandler$default(this.getEventDispatcher$activity(), onBackPressedEventHandlerCreateNavigationEventHandler$activity, 0, 2, null);
                        return;
                    }
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    onBackPressedEventHandlerCreateNavigationEventHandler$activity.remove();
                    lifecycle.removeObserver(this);
                    return;
                }
                boolean z = ActivityFlags.isOnBackPressedLifecycleOrderMaintained;
                OnBackPressedCallback.OnBackPressedEventHandler onBackPressedEventHandler = onBackPressedEventHandlerCreateNavigationEventHandler$activity;
                if (z) {
                    onBackPressedEventHandler.setLifecycleActive(false);
                } else {
                    onBackPressedEventHandler.remove();
                }
            }
        };
        lifecycle.addObserver(r1);
        onBackPressedCallback.addCloseable$activity(new AutoCloseable() { // from class: androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda1
            @Override // java.lang.AutoCloseable
            public final void close() {
                lifecycle.removeObserver(r1);
            }
        });
    }

    public final NavigationEventDispatcher getEventDispatcher$activity() {
        return getEventInput().getDispatcher();
    }

    public final void onBackPressed() {
        getEventInput().backCompleted();
    }

    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher invoker) {
        invoker.getClass();
        getEventDispatcher$activity().addInput(new OnBackInvokedDefaultInput(invoker), 1);
        getEventDispatcher$activity().addInput(new OnBackInvokedOverlayInput(invoker), 0);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
