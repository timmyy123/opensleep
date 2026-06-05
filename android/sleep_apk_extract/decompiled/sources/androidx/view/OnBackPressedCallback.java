package androidx.view;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.view.NavigationEvent;
import androidx.view.NavigationEventHandler;
import androidx.view.NavigationEventInfo;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u000f\u0010\bJ\u001b\u0010\u0015\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010\u0005R\u001e\u0010%\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/activity/OnBackPressedCallback;", "", "", "enabled", "<init>", "(Z)V", "", "remove", "()V", "Landroidx/activity/BackEventCompat;", "backEvent", "handleOnBackStarted", "(Landroidx/activity/BackEventCompat;)V", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "closeable", "addCloseable$activity", "(Ljava/lang/AutoCloseable;)V", "addCloseable", "Landroidx/navigationevent/NavigationEventInfo;", "info", "Landroidx/activity/OnBackPressedCallback$OnBackPressedEventHandler;", "createNavigationEventHandler$activity", "(Landroidx/navigationevent/NavigationEventInfo;)Landroidx/activity/OnBackPressedCallback$OnBackPressedEventHandler;", "createNavigationEventHandler", "", "eventHandlers", "Ljava/util/List;", SDKConstants.PARAM_VALUE, IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "Z", "()Z", "setEnabled", "Ljava/util/concurrent/CopyOnWriteArrayList;", "closeables", "Ljava/util/concurrent/CopyOnWriteArrayList;", "OnBackPressedEventHandler", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OnBackPressedCallback {
    private boolean isEnabled;
    private final List<OnBackPressedEventHandler> eventHandlers = new ArrayList();
    private final CopyOnWriteArrayList<AutoCloseable> closeables = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/activity/OnBackPressedCallback$OnBackPressedEventHandler;", "Landroidx/navigationevent/NavigationEventHandler;", "Landroidx/navigationevent/NavigationEventInfo;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "info", "<init>", "(Landroidx/activity/OnBackPressedCallback;Landroidx/navigationevent/NavigationEventInfo;)V", SDKConstants.PARAM_VALUE, "", "isLifecycleActive", "()Z", "setLifecycleActive", "(Z)V", "onBackStarted", "", "event", "Landroidx/navigationevent/NavigationEvent;", "onBackProgressed", "onBackCompleted", "onBackCancelled", "activity"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OnBackPressedEventHandler extends NavigationEventHandler<NavigationEventInfo> {
        private boolean isLifecycleActive;
        private final OnBackPressedCallback onBackPressedCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnBackPressedEventHandler(OnBackPressedCallback onBackPressedCallback, NavigationEventInfo navigationEventInfo) {
            super(navigationEventInfo, onBackPressedCallback.getIsEnabled());
            onBackPressedCallback.getClass();
            navigationEventInfo.getClass();
            this.onBackPressedCallback = onBackPressedCallback;
            this.isLifecycleActive = true;
        }

        /* JADX INFO: renamed from: isLifecycleActive, reason: from getter */
        public final boolean getIsLifecycleActive() {
            return this.isLifecycleActive;
        }

        @Override // androidx.view.NavigationEventHandler
        public void onBackCancelled() {
            this.onBackPressedCallback.handleOnBackCancelled();
        }

        @Override // androidx.view.NavigationEventHandler
        public void onBackCompleted() {
            this.onBackPressedCallback.handleOnBackPressed();
        }

        @Override // androidx.view.NavigationEventHandler
        public void onBackProgressed(NavigationEvent event) {
            event.getClass();
            this.onBackPressedCallback.handleOnBackProgressed(new BackEventCompat(event));
        }

        @Override // androidx.view.NavigationEventHandler
        public void onBackStarted(NavigationEvent event) {
            event.getClass();
            this.onBackPressedCallback.handleOnBackStarted(new BackEventCompat(event));
        }

        public final void setLifecycleActive(boolean z) {
            this.isLifecycleActive = z;
            setBackEnabled(z && this.onBackPressedCallback.getIsEnabled());
        }
    }

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    public final void addCloseable$activity(AutoCloseable closeable) {
        closeable.getClass();
        this.closeables.add(closeable);
    }

    public final OnBackPressedEventHandler createNavigationEventHandler$activity(NavigationEventInfo info) {
        info.getClass();
        OnBackPressedEventHandler onBackPressedEventHandler = new OnBackPressedEventHandler(this, info);
        this.eventHandlers.add(onBackPressedEventHandler);
        return onBackPressedEventHandler;
    }

    public void handleOnBackCancelled() {
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(BackEventCompat backEvent) {
        backEvent.getClass();
    }

    public void handleOnBackStarted(BackEventCompat backEvent) {
        backEvent.getClass();
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void remove() throws Exception {
        boolean zIsTerminated;
        Iterator<AutoCloseable> it = this.closeables.iterator();
        it.getClass();
        while (it.hasNext()) {
            AutoCloseable next = it.next();
            if (next instanceof AutoCloseable) {
                next.close();
            } else if (next instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) next;
                if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated = executorService.isTerminated())) {
                    executorService.shutdown();
                    boolean z = false;
                    while (!zIsTerminated) {
                        try {
                            zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused) {
                            if (!z) {
                                executorService.shutdownNow();
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (next instanceof TypedArray) {
                ((TypedArray) next).recycle();
            } else if (next instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) next).release();
            } else {
                if (!(next instanceof MediaDrm)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3();
                    return;
                }
                ((MediaDrm) next).release();
            }
        }
        this.closeables.clear();
        Iterator<OnBackPressedEventHandler> it2 = this.eventHandlers.iterator();
        while (it2.hasNext()) {
            it2.next().remove();
        }
        this.eventHandlers.clear();
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        for (OnBackPressedEventHandler onBackPressedEventHandler : this.eventHandlers) {
            onBackPressedEventHandler.setBackEnabled(onBackPressedEventHandler.getIsLifecycleActive() && z);
        }
    }
}
