package androidx.view;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.view.NavigationEventTransitionState;
import androidx.view.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0003J\u001d\u0010\u0012\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0018\u0010\u0011J%\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010 J'\u0010$\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020)0,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002010(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010+R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002010,8\u0006¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R\u001e\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u001c\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b;\u0010<\u0012\u0004\b=\u0010\u0003R\u0018\u0010>\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00190@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00190@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00190@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010G¨\u0006J"}, d2 = {"Landroidx/navigationevent/NavigationEventProcessor;", "", "<init>", "()V", "", "direction", "Landroidx/navigationevent/NavigationEventHandler;", "resolveEnabledHandler", "(I)Landroidx/navigationevent/NavigationEventHandler;", "", "Landroidx/navigationevent/NavigationEventInfo;", "resolveCombinedBackInfo", "()Ljava/util/List;", "", "refreshEnabledHandlers", "handler", "updateEnabledHandlerInfo$navigationevent", "(Landroidx/navigationevent/NavigationEventHandler;)V", "updateEnabledHandlerInfo", "Landroidx/navigationevent/NavigationEventDispatcher;", "dispatcher", "priority", "addHandler", "(Landroidx/navigationevent/NavigationEventDispatcher;Landroidx/navigationevent/NavigationEventHandler;I)V", "removeHandler", "Landroidx/navigationevent/NavigationEventInput;", "input", "addInput", "(Landroidx/navigationevent/NavigationEventDispatcher;Landroidx/navigationevent/NavigationEventInput;I)V", "Landroidx/navigationevent/NavigationEvent;", "event", "dispatchOnStarted", "(Landroidx/navigationevent/NavigationEventInput;ILandroidx/navigationevent/NavigationEvent;)V", "dispatchOnProgressed", "Landroidx/navigationevent/OnBackCompletedFallback;", "onBackCompletedFallback", "dispatchOnCompleted", "(Landroidx/navigationevent/NavigationEventInput;ILandroidx/navigationevent/OnBackCompletedFallback;)V", "dispatchOnCancelled", "(Landroidx/navigationevent/NavigationEventInput;I)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/navigationevent/NavigationEventTransitionState;", "_transitionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "transitionState", "Lkotlinx/coroutines/flow/StateFlow;", "getTransitionState", "()Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/navigationevent/NavigationEventHistory;", "_history", "history", "getHistory", "Lkotlin/collections/ArrayDeque;", "overlayHandlers", "Lkotlin/collections/ArrayDeque;", "defaultHandlers", "inProgressHandler", "Landroidx/navigationevent/NavigationEventHandler;", "inProgressDirection", "I", "getInProgressDirection$annotations", "inProgressInput", "Landroidx/navigationevent/NavigationEventInput;", "", "unspecifiedInputs", "Ljava/util/Set;", "defaultInputs", "overlayInputs", "", "hasEnabledDefaultHandlers", "Z", "hasEnabledOverlayHandlers", "hasEnabledAnyHandlers", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationEventProcessor {
    private final MutableStateFlow<NavigationEventHistory> _history;
    private final MutableStateFlow<NavigationEventTransitionState> _transitionState;
    private final ArrayDeque<NavigationEventHandler<?>> defaultHandlers;
    private final Set<NavigationEventInput> defaultInputs;
    private boolean hasEnabledAnyHandlers;
    private boolean hasEnabledDefaultHandlers;
    private boolean hasEnabledOverlayHandlers;
    private final StateFlow<NavigationEventHistory> history;
    private int inProgressDirection;
    private NavigationEventHandler<?> inProgressHandler;
    private NavigationEventInput inProgressInput;
    private final ArrayDeque<NavigationEventHandler<?>> overlayHandlers;
    private final Set<NavigationEventInput> overlayInputs;
    private final StateFlow<NavigationEventTransitionState> transitionState;
    private final Set<NavigationEventInput> unspecifiedInputs;

    public NavigationEventProcessor() {
        MutableStateFlow<NavigationEventTransitionState> MutableStateFlow = StateFlowKt.MutableStateFlow(NavigationEventTransitionState.Idle.INSTANCE);
        this._transitionState = MutableStateFlow;
        this.transitionState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<NavigationEventHistory> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new NavigationEventHistory());
        this._history = MutableStateFlow2;
        this.history = FlowKt.asStateFlow(MutableStateFlow2);
        this.overlayHandlers = new ArrayDeque<>();
        this.defaultHandlers = new ArrayDeque<>();
        this.unspecifiedInputs = new LinkedHashSet();
        this.defaultInputs = new LinkedHashSet();
        this.overlayInputs = new LinkedHashSet();
    }

    private final List<NavigationEventInfo> resolveCombinedBackInfo() {
        ArrayList arrayList = new ArrayList();
        for (NavigationEventHandler<?> navigationEventHandler : this.overlayHandlers) {
            if (navigationEventHandler.isBackEnabled() && !navigationEventHandler.getBackInfo().isEmpty()) {
                arrayList.addAll(navigationEventHandler.getBackInfo());
            }
        }
        for (NavigationEventHandler<?> navigationEventHandler2 : this.defaultHandlers) {
            if (navigationEventHandler2.isBackEnabled() && !navigationEventHandler2.getBackInfo().isEmpty()) {
                arrayList.addAll(navigationEventHandler2.getBackInfo());
            }
        }
        return arrayList;
    }

    private final NavigationEventHandler<?> resolveEnabledHandler(int direction) {
        NavigationEventHandler<?> next;
        NavigationEventHandler<?> next2;
        NavigationEventHandler<?> next3;
        NavigationEventHandler<?> navigationEventHandler = null;
        if (direction == -1) {
            Iterator<NavigationEventHandler<?>> it = this.overlayHandlers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.isBackEnabled()) {
                    break;
                }
            }
            NavigationEventHandler<?> navigationEventHandler2 = next;
            if (navigationEventHandler2 != null) {
                return navigationEventHandler2;
            }
            Iterator<NavigationEventHandler<?>> it2 = this.defaultHandlers.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                NavigationEventHandler<?> next4 = it2.next();
                if (next4.isBackEnabled()) {
                    navigationEventHandler = next4;
                    break;
                }
            }
            return navigationEventHandler;
        }
        if (direction == 0) {
            Iterator<NavigationEventHandler<?>> it3 = this.overlayHandlers.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                NavigationEventHandler<?> navigationEventHandler3 = next2;
                if (navigationEventHandler3.isBackEnabled() || navigationEventHandler3.isForwardEnabled()) {
                    break;
                }
            }
            NavigationEventHandler<?> navigationEventHandler4 = next2;
            if (navigationEventHandler4 != null) {
                return navigationEventHandler4;
            }
            for (NavigationEventHandler<?> navigationEventHandler5 : this.defaultHandlers) {
                NavigationEventHandler<?> navigationEventHandler6 = navigationEventHandler5;
                if (navigationEventHandler6.isBackEnabled() || navigationEventHandler6.isForwardEnabled()) {
                    navigationEventHandler = navigationEventHandler5;
                    break;
                }
            }
            return navigationEventHandler;
        }
        if (direction != 1) {
            throw new IllegalStateException(("Unsupported direction: '" + direction + "'.").toString());
        }
        Iterator<NavigationEventHandler<?>> it4 = this.overlayHandlers.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it4.next();
            if (next3.isForwardEnabled()) {
                break;
            }
        }
        NavigationEventHandler<?> navigationEventHandler7 = next3;
        if (navigationEventHandler7 != null) {
            return navigationEventHandler7;
        }
        Iterator<NavigationEventHandler<?>> it5 = this.defaultHandlers.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            NavigationEventHandler<?> next5 = it5.next();
            if (next5.isForwardEnabled()) {
                navigationEventHandler = next5;
                break;
            }
        }
        return navigationEventHandler;
    }

    public static /* synthetic */ NavigationEventHandler resolveEnabledHandler$default(NavigationEventProcessor navigationEventProcessor, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return navigationEventProcessor.resolveEnabledHandler(i);
    }

    public final void addHandler(NavigationEventDispatcher dispatcher, NavigationEventHandler<?> handler, int priority) {
        dispatcher.getClass();
        handler.getClass();
        if (handler.getDispatcher() != null) {
            Home$$ExternalSyntheticBUOutline0.m("Handler '", handler, "' is already registered with a dispatcher");
            return;
        }
        if (priority == 0) {
            this.overlayHandlers.addFirst(handler);
        } else {
            if (priority != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(priority, "Unsupported priority value: "));
                return;
            }
            this.defaultHandlers.addFirst(handler);
        }
        handler.setDispatcher$navigationevent(dispatcher);
        refreshEnabledHandlers();
    }

    public final void addInput(NavigationEventDispatcher dispatcher, NavigationEventInput input, int priority) {
        dispatcher.getClass();
        input.getClass();
        if (input.getDispatcher() == null) {
            (priority != 0 ? priority != 1 ? this.unspecifiedInputs : this.defaultInputs : this.overlayInputs).add(input);
            input.setDispatcher$navigationevent(dispatcher);
            input.doOnAdded$navigationevent(dispatcher);
            input.doOnHistoryChanged$navigationevent(this.history.getValue());
            input.doOnHasEnabledHandlersChanged$navigationevent(priority != 0 ? priority != 1 ? this.hasEnabledAnyHandlers : this.hasEnabledDefaultHandlers : this.hasEnabledOverlayHandlers);
            return;
        }
        StringBuilder sb = new StringBuilder("Input '");
        sb.append(input);
        NavigationEventDispatcher dispatcher2 = input.getDispatcher();
        sb.append("' is already added to dispatcher ");
        sb.append(dispatcher2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final void dispatchOnCancelled(NavigationEventInput input, int direction) {
        input.getClass();
        if (Intrinsics.areEqual(input, this.inProgressInput) && direction == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler = this.inProgressHandler;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                navigationEventHandlerResolveEnabledHandler = resolveEnabledHandler(direction);
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
            if (direction != -1) {
                if (direction == 1 && navigationEventHandlerResolveEnabledHandler != null) {
                    navigationEventHandlerResolveEnabledHandler.doOnForwardCancelled$navigationevent();
                }
            } else if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.doOnBackCancelled$navigationevent();
            }
            this._transitionState.setValue(NavigationEventTransitionState.Idle.INSTANCE);
        }
    }

    public final void dispatchOnCompleted(NavigationEventInput input, int direction, OnBackCompletedFallback onBackCompletedFallback) {
        input.getClass();
        if (Intrinsics.areEqual(input, this.inProgressInput) && direction == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler = this.inProgressHandler;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                navigationEventHandlerResolveEnabledHandler = resolveEnabledHandler(direction);
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
            if (direction != -1) {
                if (direction == 1 && navigationEventHandlerResolveEnabledHandler != null) {
                    navigationEventHandlerResolveEnabledHandler.doOnForwardCompleted$navigationevent();
                }
            } else if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.doOnBackCompleted$navigationevent();
            } else if (onBackCompletedFallback != null) {
                ((OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) onBackCompletedFallback).onBackCompletedFallback();
            }
            this._transitionState.setValue(NavigationEventTransitionState.Idle.INSTANCE);
        }
    }

    public final void dispatchOnProgressed(NavigationEventInput input, int direction, NavigationEvent event) {
        input.getClass();
        event.getClass();
        if (Intrinsics.areEqual(input, this.inProgressInput) && direction == this.inProgressDirection) {
            NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler = this.inProgressHandler;
            if (navigationEventHandlerResolveEnabledHandler == null) {
                navigationEventHandlerResolveEnabledHandler = resolveEnabledHandler(direction);
            }
            if (direction != -1) {
                if (direction == 1 && navigationEventHandlerResolveEnabledHandler != null) {
                    navigationEventHandlerResolveEnabledHandler.doOnForwardProgressed$navigationevent(event);
                }
            } else if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.doOnBackProgressed$navigationevent(event);
            }
            this._transitionState.setValue(new NavigationEventTransitionState.InProgress(event, direction));
        }
    }

    public final void dispatchOnStarted(NavigationEventInput input, int direction, NavigationEvent event) {
        input.getClass();
        if (this.inProgressDirection != 0) {
            return;
        }
        NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler = resolveEnabledHandler(direction);
        this.inProgressHandler = navigationEventHandlerResolveEnabledHandler;
        this.inProgressDirection = direction;
        this.inProgressInput = input;
        if (event != null) {
            if (direction != -1) {
                if (direction == 1 && navigationEventHandlerResolveEnabledHandler != null) {
                    navigationEventHandlerResolveEnabledHandler.doOnForwardStarted$navigationevent(event);
                }
            } else if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.doOnBackStarted$navigationevent(event);
            }
            this._transitionState.setValue(new NavigationEventTransitionState.InProgress(event, direction));
        }
    }

    public final void refreshEnabledHandlers() {
        boolean z;
        boolean z2;
        ArrayDeque<NavigationEventHandler<?>> arrayDeque = this.overlayHandlers;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            for (NavigationEventHandler<?> navigationEventHandler : arrayDeque) {
                if (navigationEventHandler.isBackEnabled() || navigationEventHandler.isForwardEnabled()) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        ArrayDeque<NavigationEventHandler<?>> arrayDeque2 = this.defaultHandlers;
        if (arrayDeque2 == null || !arrayDeque2.isEmpty()) {
            for (NavigationEventHandler<?> navigationEventHandler2 : arrayDeque2) {
                if (navigationEventHandler2.isBackEnabled() || navigationEventHandler2.isForwardEnabled()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        boolean z3 = z || z2;
        boolean z4 = this.hasEnabledOverlayHandlers != z;
        boolean z5 = this.hasEnabledDefaultHandlers != z2;
        boolean z6 = this.hasEnabledAnyHandlers != z3;
        if (z4) {
            Iterator<NavigationEventInput> it = this.overlayInputs.iterator();
            while (it.hasNext()) {
                it.next().doOnHasEnabledHandlersChanged$navigationevent(z);
            }
        }
        if (z5) {
            Iterator<NavigationEventInput> it2 = this.defaultInputs.iterator();
            while (it2.hasNext()) {
                it2.next().doOnHasEnabledHandlersChanged$navigationevent(z2);
            }
        }
        if (z6) {
            Iterator<NavigationEventInput> it3 = this.unspecifiedInputs.iterator();
            while (it3.hasNext()) {
                it3.next().doOnHasEnabledHandlersChanged$navigationevent(z3);
            }
        }
        this.hasEnabledOverlayHandlers = z;
        this.hasEnabledDefaultHandlers = z2;
        this.hasEnabledAnyHandlers = z3;
        NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler$default = this.inProgressHandler;
        if (navigationEventHandlerResolveEnabledHandler$default == null) {
            navigationEventHandlerResolveEnabledHandler$default = resolveEnabledHandler$default(this, 0, 1, null);
        }
        updateEnabledHandlerInfo$navigationevent(navigationEventHandlerResolveEnabledHandler$default);
    }

    public final void removeHandler(NavigationEventHandler<?> handler) {
        handler.getClass();
        if (Intrinsics.areEqual(handler, this.inProgressHandler)) {
            int i = this.inProgressDirection;
            if (i == -1) {
                handler.doOnBackCancelled$navigationevent();
            } else if (i == 1) {
                handler.doOnForwardCancelled$navigationevent();
            }
            this.inProgressHandler = null;
            this.inProgressDirection = 0;
            this.inProgressInput = null;
        }
        this.overlayHandlers.remove(handler);
        this.defaultHandlers.remove(handler);
        handler.setDispatcher$navigationevent(null);
        refreshEnabledHandlers();
    }

    public final void updateEnabledHandlerInfo$navigationevent(NavigationEventHandler<?> handler) {
        NavigationEventHistory navigationEventHistory;
        NavigationEventHandler<?> navigationEventHandlerResolveEnabledHandler$default = this.inProgressHandler;
        if (navigationEventHandlerResolveEnabledHandler$default == null) {
            navigationEventHandlerResolveEnabledHandler$default = resolveEnabledHandler$default(this, 0, 1, null);
        }
        if (Intrinsics.areEqual(navigationEventHandlerResolveEnabledHandler$default, handler)) {
            if (navigationEventHandlerResolveEnabledHandler$default == null) {
                navigationEventHistory = new NavigationEventHistory();
            } else {
                navigationEventHistory = new NavigationEventHistory(navigationEventHandlerResolveEnabledHandler$default.getCurrentInfo(), resolveCombinedBackInfo(), navigationEventHandlerResolveEnabledHandler$default.getForwardInfo());
            }
            if (Intrinsics.areEqual(this._history.getValue(), navigationEventHistory)) {
                return;
            }
            this._history.setValue(navigationEventHistory);
            Iterator<NavigationEventInput> it = this.overlayInputs.iterator();
            while (it.hasNext()) {
                it.next().doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
            Iterator<NavigationEventInput> it2 = this.defaultInputs.iterator();
            while (it2.hasNext()) {
                it2.next().doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
            Iterator<NavigationEventInput> it3 = this.unspecifiedInputs.iterator();
            while (it3.hasNext()) {
                it3.next().doOnHistoryChanged$navigationevent(navigationEventHistory);
            }
        }
    }
}
