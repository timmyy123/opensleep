package androidx.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/navigationevent/DirectNavigationEventInput;", "Landroidx/navigationevent/NavigationEventInput;", "<init>", "()V", "", "backCompleted", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DirectNavigationEventInput extends NavigationEventInput {
    public final void backCompleted() {
        dispatchOnBackCompleted();
    }
}
