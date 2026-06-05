package com.urbandroid.sleep.smartlight;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/ViewGroup;", "", "layoutRes", "", "attachToRoot", "Landroid/view/View;", "inflate", "(Landroid/view/ViewGroup;IZ)Landroid/view/View;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class DiscoveryActivityKt {
    public static final View inflate(ViewGroup viewGroup, int i, boolean z) {
        viewGroup.getClass();
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        Context context = viewGroup.getContext();
        context.getClass();
        View viewInflate = companion.get(context).inflate(i, viewGroup, z);
        viewInflate.getClass();
        return viewInflate;
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return inflate(viewGroup, i, z);
    }
}
