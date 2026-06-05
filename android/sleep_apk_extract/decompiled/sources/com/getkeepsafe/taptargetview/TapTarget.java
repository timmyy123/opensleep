package com.getkeepsafe.taptargetview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class TapTarget {
    Rect bounds;
    boolean cancelable;
    final CharSequence description;
    float descriptionTextAlpha;
    private Integer descriptionTextColor;
    private int descriptionTextColorRes;
    private int descriptionTextDimen;
    private int descriptionTextSize;
    Typeface descriptionTypeface;
    private Integer dimColor;
    private int dimColorRes;
    boolean drawBehindNavigationBar;
    boolean drawBehindStatusBar;
    boolean drawShadow;
    boolean forceCenteredTarget;
    Drawable icon;
    int id;
    float outerCircleAlpha;
    private Integer outerCircleColor;
    private int outerCircleColorRes;
    private Integer targetCircleColor;
    private int targetCircleColorRes;
    int targetRadius;
    boolean tintTarget;
    final CharSequence title;
    private Integer titleTextColor;
    private int titleTextColorRes;
    private int titleTextDimen;
    private int titleTextSize;
    Typeface titleTypeface;
    boolean transparentTarget;

    public TapTarget(CharSequence charSequence, CharSequence charSequence2) {
        this.outerCircleAlpha = 0.96f;
        this.targetRadius = 44;
        this.outerCircleColorRes = -1;
        this.targetCircleColorRes = -1;
        this.dimColorRes = -1;
        this.titleTextColorRes = -1;
        this.descriptionTextColorRes = -1;
        this.outerCircleColor = null;
        this.targetCircleColor = null;
        this.dimColor = null;
        this.titleTextColor = null;
        this.descriptionTextColor = null;
        this.titleTextDimen = -1;
        this.descriptionTextDimen = -1;
        this.titleTextSize = 20;
        this.descriptionTextSize = 18;
        this.id = -1;
        this.drawShadow = false;
        this.cancelable = true;
        this.tintTarget = true;
        this.transparentTarget = false;
        this.descriptionTextAlpha = 0.54f;
        this.drawBehindStatusBar = true;
        this.drawBehindNavigationBar = true;
        this.forceCenteredTarget = false;
        if (charSequence == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot pass null title");
            throw null;
        }
        this.title = charSequence;
        this.description = charSequence2;
    }

    private Integer colorResOrInt(Context context, Integer num, int i) {
        return i != -1 ? Integer.valueOf(ContextCompat.getColor(context, i)) : num;
    }

    private int dimenOrSize(Context context, int i, int i2) {
        return i2 != -1 ? context.getResources().getDimensionPixelSize(i2) : UiUtil.sp(context, i);
    }

    public static TapTarget forBounds(Rect rect, CharSequence charSequence, CharSequence charSequence2) {
        return new TapTarget(rect, charSequence, charSequence2);
    }

    public static TapTarget forView(View view, CharSequence charSequence, CharSequence charSequence2) {
        return new ViewTapTarget(view, charSequence, charSequence2);
    }

    public Rect bounds() {
        Rect rect = this.bounds;
        if (rect != null) {
            return rect;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Requesting bounds that are not set! Make sure your target is ready");
        return null;
    }

    public TapTarget cancelable(boolean z) {
        this.cancelable = z;
        return this;
    }

    public Integer descriptionTextColorInt(Context context) {
        return colorResOrInt(context, this.descriptionTextColor, this.descriptionTextColorRes);
    }

    public int descriptionTextSizePx(Context context) {
        return dimenOrSize(context, this.descriptionTextSize, this.descriptionTextDimen);
    }

    public TapTarget dimColor(int i) {
        this.dimColorRes = i;
        return this;
    }

    public Integer dimColorInt(Context context) {
        return colorResOrInt(context, this.dimColor, this.dimColorRes);
    }

    public TapTarget icon(Drawable drawable, boolean z) {
        if (drawable == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot use null drawable");
            return null;
        }
        this.icon = drawable;
        if (!z) {
            drawable.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
        }
        return this;
    }

    public TapTarget id(int i) {
        this.id = i;
        return this;
    }

    public void onReady(Runnable runnable) {
        runnable.run();
    }

    public TapTarget outerCircleColor(int i) {
        this.outerCircleColorRes = i;
        return this;
    }

    public Integer outerCircleColorInt(Context context) {
        return colorResOrInt(context, this.outerCircleColor, this.outerCircleColorRes);
    }

    public TapTarget targetCircleColor(int i) {
        this.targetCircleColorRes = i;
        return this;
    }

    public Integer targetCircleColorInt(Context context) {
        return colorResOrInt(context, this.targetCircleColor, this.targetCircleColorRes);
    }

    public TapTarget textColor(int i) {
        this.titleTextColorRes = i;
        this.descriptionTextColorRes = i;
        return this;
    }

    public TapTarget tintTarget(boolean z) {
        this.tintTarget = z;
        return this;
    }

    public Integer titleTextColorInt(Context context) {
        return colorResOrInt(context, this.titleTextColor, this.titleTextColorRes);
    }

    public int titleTextSizePx(Context context) {
        return dimenOrSize(context, this.titleTextSize, this.titleTextDimen);
    }

    public TapTarget icon(Drawable drawable) {
        return icon(drawable, false);
    }

    public TapTarget(Rect rect, CharSequence charSequence, CharSequence charSequence2) {
        this(charSequence, charSequence2);
        if (rect != null) {
            this.bounds = rect;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Cannot pass null bounds or title");
            throw null;
        }
    }
}
