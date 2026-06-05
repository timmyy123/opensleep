package com.urbandroid.sleep.gui.toolbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/gui/toolbar/OffsetListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;", "observer", "Landroid/view/View;", "searchView", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;Landroid/view/View;)V", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;", "getObserver", "()Lcom/urbandroid/sleep/gui/toolbar/OffsetObserver;", "Landroid/view/View;", "getSearchView", "()Landroid/view/View;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OffsetListener implements AppBarLayout.OnOffsetChangedListener {
    private final Context context;
    private final OffsetObserver observer;
    private final View searchView;

    public OffsetListener(Context context, OffsetObserver offsetObserver, View view) {
        context.getClass();
        offsetObserver.getClass();
        view.getClass();
        this.context = context;
        this.observer = offsetObserver;
        this.searchView = view;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset != this.observer.getVerticalOffset()) {
            View view = this.searchView;
            if (verticalOffset == 0) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.getClass();
                layoutParams.width = -1;
                this.searchView.setLayoutParams(layoutParams);
                this.observer.setExpanded(true);
                this.searchView.getBackground().setAlpha(PHIpAddressSearchManager.END_IP_SCAN);
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.getClass();
                int iMin = (int) Math.min(Math.max(255.0d - (((double) Math.abs(verticalOffset)) * 3.0d), 0.0d), 255.0d);
                layoutParams2.width = ActivityUtils.getDip(this.context, (int) Math.max(verticalOffset + 220, 72.0d));
                this.searchView.setLayoutParams(layoutParams2);
                this.searchView.getBackground().setAlpha(iMin);
                Logger.logInfo("Alpha " + iMin);
                this.observer.setExpanded(false);
            }
            this.observer.setVerticalOffset(verticalOffset);
        }
    }
}
