package com.ernestoyaquello.dragdropswiperecyclerview.util;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001aI\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r¨\u0006\u0011"}, d2 = {"drawHorizontalDividers", "", "itemLayout", "Landroid/view/View;", "canvas", "Landroid/graphics/Canvas;", "divider", "Landroid/graphics/drawable/Drawable;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "", "right", "alpha", "", "(Landroid/view/View;Landroid/graphics/Canvas;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "drawVerticalDividers", ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", "drag-drop-swipe-recyclerview_release"}, k = 2, mv = {1, 1, 16})
public abstract class DividerDrawingHelperKt {
    public static final void drawHorizontalDividers(View view, Canvas canvas, Drawable drawable, Integer num, Integer num2, Float f) {
        view.getClass();
        canvas.getClass();
        drawable.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int iIntValue = (num != null ? num.intValue() : view.getLeft() + ((int) view.getTranslationX())) - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
        int iIntValue2 = (num2 != null ? num2.intValue() : view.getRight() + ((int) view.getTranslationX())) + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
        drawable.setAlpha(PHIpAddressSearchManager.END_IP_SCAN);
        if (f != null) {
            drawable.setAlpha((int) (f.floatValue() * 255.0f));
        }
        int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + ((int) view.getTranslationY());
        drawable.setBounds(iIntValue, bottom, iIntValue2, drawable.getIntrinsicHeight() + bottom);
        drawable.draw(canvas);
        int top = (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin) + ((int) view.getTranslationY());
        drawable.setBounds(iIntValue, top - drawable.getIntrinsicHeight(), iIntValue2, top);
        drawable.draw(canvas);
    }

    public static /* synthetic */ void drawHorizontalDividers$default(View view, Canvas canvas, Drawable drawable, Integer num, Integer num2, Float f, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        if ((i & 32) != 0) {
            f = null;
        }
        drawHorizontalDividers(view, canvas, drawable, num, num2, f);
    }

    public static final void drawVerticalDividers(View view, Canvas canvas, Drawable drawable, Integer num, Integer num2, Float f) {
        view.getClass();
        canvas.getClass();
        drawable.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int iIntValue = (num != null ? num.intValue() : view.getTop() + ((int) view.getTranslationY())) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
        int iIntValue2 = (num2 != null ? num2.intValue() : view.getBottom() + ((int) view.getTranslationY())) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        drawable.setAlpha(PHIpAddressSearchManager.END_IP_SCAN);
        if (f != null) {
            drawable.setAlpha((int) (f.floatValue() * 255.0f));
        }
        int right = view.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + ((int) view.getTranslationX());
        drawable.setBounds(right, iIntValue, drawable.getIntrinsicWidth() + right, iIntValue2);
        drawable.draw(canvas);
        int left = (view.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin) + ((int) view.getTranslationX());
        drawable.setBounds(left - drawable.getIntrinsicWidth(), iIntValue, left, iIntValue2);
        drawable.draw(canvas);
    }

    public static /* synthetic */ void drawVerticalDividers$default(View view, Canvas canvas, Drawable drawable, Integer num, Integer num2, Float f, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        if ((i & 32) != 0) {
            f = null;
        }
        drawVerticalDividers(view, canvas, drawable, num, num2, f);
    }
}
