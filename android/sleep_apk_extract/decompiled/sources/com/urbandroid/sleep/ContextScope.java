package com.urbandroid.sleep;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\n\u001a\u00020\u0007*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u00020\u0006*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u00020\u0007*\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\u0006*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/ContextScope;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "", "getValue", "(I)Ljava/lang/String;", SDKConstants.PARAM_VALUE, "getDip", "(I)I", "dip", "", "getTimeNoAmPm", "(J)Ljava/lang/String;", "timeNoAmPm", "getArgb", "argb", "Landroid/content/res/ColorStateList;", "getAsColorStateList", "(I)Landroid/content/res/ColorStateList;", "asColorStateList", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ContextScope {
    default int getArgb(int i) {
        return ColorUtil.i(getContext(), i);
    }

    default ColorStateList getAsColorStateList(int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(getArgb(i));
        colorStateListValueOf.getClass();
        return colorStateListValueOf;
    }

    Context getContext();

    default int getDip(int i) {
        return ActivityUtils.getDip(getContext(), i);
    }

    default String getTimeNoAmPm(long j) {
        String timeNoAmPm = DateUtil.formatTimeNoAmPm(getContext(), j);
        timeNoAmPm.getClass();
        return timeNoAmPm;
    }

    default String getValue(int i) {
        String string = getContext().getString(i);
        string.getClass();
        return string;
    }
}
