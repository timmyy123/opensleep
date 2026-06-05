package com.urbandroid.sleep.gui.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0017\u0010\u0002\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/android/material/slider/Slider;", "slider", "color", "(Lcom/google/android/material/slider/Slider;)Lcom/google/android/material/slider/Slider;", "Lcom/google/android/material/slider/RangeSlider;", "rangeSlider", "(Lcom/google/android/material/slider/RangeSlider;)Lcom/google/android/material/slider/RangeSlider;", "Landroid/view/View;", "button", "", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ComponentColorUtilKt {
    public static final Slider color(Slider slider) {
        if (slider == null) {
            return null;
        }
        Context context = slider.getContext();
        context.getClass();
        ContextExtKt$contextScope$scope$1 contextExtKt$contextScope$scope$1 = new ContextExtKt$contextScope$scope$1(context);
        int[][] iArr = {new int[]{R.attr.state_enabled}, new int[]{-16842910}};
        int[] iArr2 = {contextExtKt$contextScope$scope$1.getArgb(com.urbandroid.sleep.R.color.tint), contextExtKt$contextScope$scope$1.getArgb(com.urbandroid.sleep.R.color.disabled)};
        slider.setTickActiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.white));
        slider.setTickInactiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.white));
        slider.setTrackActiveTintList(new ColorStateList(iArr, iArr2));
        slider.setTrackInactiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.shade));
        slider.setThumbTintList(new ColorStateList(iArr, iArr2));
        return slider;
    }

    public static final RangeSlider color(RangeSlider rangeSlider) {
        if (rangeSlider == null) {
            return null;
        }
        Context context = rangeSlider.getContext();
        context.getClass();
        ContextExtKt$contextScope$scope$1 contextExtKt$contextScope$scope$1 = new ContextExtKt$contextScope$scope$1(context);
        rangeSlider.setTickActiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.tint));
        rangeSlider.setTickInactiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.secondary_html));
        rangeSlider.setTrackActiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.tint));
        rangeSlider.setTrackInactiveTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.shade));
        rangeSlider.setThumbTintList(contextExtKt$contextScope$scope$1.getAsColorStateList(com.urbandroid.sleep.R.color.tint));
        return rangeSlider;
    }

    public static final void color(View view) {
        if (view != null) {
            Context context = view.getContext();
            context.getClass();
            view.setBackgroundTintList(new ContextExtKt$contextScope$scope$1(context).getAsColorStateList(com.urbandroid.sleep.R.color.fab));
        }
    }
}
