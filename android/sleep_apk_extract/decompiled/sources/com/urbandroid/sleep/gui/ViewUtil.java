package com.urbandroid.sleep.gui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewUtil {
    public static void setCompoundDrawablesCompat(TextView textView, int i, int i2, int i3, int i4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static void setMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(ActivityUtils.getDip(view.getContext(), i), ActivityUtils.getDip(view.getContext(), i2), ActivityUtils.getDip(view.getContext(), i3), ActivityUtils.getDip(view.getContext(), i4));
        view.setLayoutParams(marginLayoutParams);
    }

    public static void setOverflowButtonColor(final int i, final Activity activity) {
        final String string = activity.getResources().getString(R.string.abc_action_menu_overflow_description);
        final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.urbandroid.sleep.gui.ViewUtil.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ArrayList<View> arrayList = new ArrayList<>(1);
                viewGroup.findViewsWithText(arrayList, string, 2);
                if (arrayList.isEmpty() || !(arrayList.get(0) instanceof AppCompatImageView)) {
                    return;
                }
                ((AppCompatImageView) arrayList.get(0)).setColorFilter(ContextCompat.getColor(activity, i));
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
}
