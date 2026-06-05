package androidx.view;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: renamed from: androidx.navigationevent.ViewTreeNavigationEventDispatcherOwner, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroid/view/View;", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "navigationEventDispatcherOwner", "", "set", "(Landroid/view/View;Landroidx/navigationevent/NavigationEventDispatcherOwner;)V", "setViewTreeNavigationEventDispatcherOwner", "navigationevent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractC0113ViewTreeNavigationEventDispatcherOwner {
    public static final void set(View view, NavigationEventDispatcherOwner navigationEventDispatcherOwner) {
        view.getClass();
        view.setTag(C0112R$id.view_tree_navigation_event_dispatcher_owner, navigationEventDispatcherOwner);
    }
}
