package com.urbandroid.sleep;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"show", "", "Landroid/view/View;", "hide", "gone", "inflate", "Landroid/view/ViewGroup;", "layoutRes", "", "attachToRoot", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ViewExtKt {
    public static final void gone(View view) {
        view.getClass();
        view.setVisibility(8);
    }

    public static final void hide(View view) {
        view.getClass();
        view.setVisibility(4);
    }

    public static final View inflate(ViewGroup viewGroup, int i, boolean z) {
        viewGroup.getClass();
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        Context context = viewGroup.getContext();
        context.getClass();
        View viewInflate = companion.get(context).inflate(i, viewGroup, z);
        viewInflate.getClass();
        return viewInflate;
    }

    public static final void show(View view) {
        view.getClass();
        view.setVisibility(0);
    }
}
