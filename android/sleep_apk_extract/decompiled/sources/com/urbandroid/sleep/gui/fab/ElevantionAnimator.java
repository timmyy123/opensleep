package com.urbandroid.sleep.gui.fab;

import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.view.ViewCompat;
import com.urbandroid.common.util.ActivityUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/gui/fab/ElevantionAnimator;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/View;", "toolbar", "listView", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;)V", "", "scroll", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "getToolbar", "()Landroid/view/View;", "getListView", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ElevantionAnimator {
    private final Context context;
    private final View listView;
    private final View toolbar;

    public ElevantionAnimator(Context context, View view, View view2) {
        context.getClass();
        this.context = context;
        this.toolbar = view;
        this.listView = view2;
    }

    public final void scroll() {
        View view;
        if (this.toolbar == null || (view = this.listView) == null) {
            return;
        }
        boolean zCanScrollVertically = view.canScrollVertically(-1);
        View view2 = this.toolbar;
        if (zCanScrollVertically) {
            ViewCompat.setElevation(view2, ActivityUtils.getDip(this.context, 8));
        } else {
            ViewCompat.setElevation(view2, 0.0f);
        }
    }
}
