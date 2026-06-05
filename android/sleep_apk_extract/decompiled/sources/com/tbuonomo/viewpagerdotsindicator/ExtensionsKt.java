package com.tbuonomo.viewpagerdotsindicator;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a1\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\t*\u0012\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u0015\u001a\u00020\r*\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/view/View;", "", "padding", "", "setPaddingHorizontal", "(Landroid/view/View;I)V", "setPaddingVertical", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setWidth", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "", "isInBounds", "(Ljava/util/ArrayList;I)Z", "Landroid/graphics/drawable/Drawable;", "background", "setBackgroundCompat", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "Landroidx/viewpager/widget/ViewPager;", "isNotEmpty", "(Landroidx/viewpager/widget/ViewPager;)Z", "viewpagerdotsindicator_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class ExtensionsKt {
    public static final <T> boolean isInBounds(ArrayList<T> arrayList, int i) {
        arrayList.getClass();
        return i >= 0 && i < arrayList.size();
    }

    public static final boolean isNotEmpty(ViewPager viewPager) {
        viewPager.getClass();
        PagerAdapter adapter = viewPager.getAdapter();
        return (adapter != null ? adapter.getCount() : 0) > 0;
    }

    public static final void setBackgroundCompat(View view, Drawable drawable) {
        view.getClass();
        view.setBackground(drawable);
    }

    public static final void setPaddingHorizontal(View view, int i) {
        view.getClass();
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final void setPaddingVertical(View view, int i) {
        view.getClass();
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    public static final void setWidth(View view, int i) {
        view.getClass();
        view.getLayoutParams().width = i;
        view.requestLayout();
    }
}
