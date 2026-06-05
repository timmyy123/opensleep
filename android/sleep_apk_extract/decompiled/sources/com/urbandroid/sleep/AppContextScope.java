package com.urbandroid.sleep;

import android.content.Context;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u00020\u0006*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\u000f\u001a\u00020\f*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/AppContextScope;", "", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "appContext", "", "getDip", "(I)I", "dip", "getArgb", "argb", "", "getDimDip", "(I)F", "dimDip", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AppContextScope {
    Context getAppContext();

    default int getArgb(int i) {
        return ColorUtil.i(getAppContext(), i);
    }

    default float getDimDip(int i) {
        return getAppContext().getResources().getDimension(i);
    }

    default int getDip(int i) {
        return ActivityUtils.getDip(getAppContext(), i);
    }
}
