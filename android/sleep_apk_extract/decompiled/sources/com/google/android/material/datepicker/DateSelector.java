package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.util.Pair;
import com.google.android.material.internal.ViewUtils;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda0;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public interface DateSelector<S> extends Parcelable {
    static boolean isTouchExplorationEnabled(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$showKeyboardWithAutoHideBehavior$0(EditText[] editTextArr, View view, boolean z) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }

    static void showKeyboardWithAutoHideBehavior(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        AddShortcutActivity$$ExternalSyntheticLambda0 addShortcutActivity$$ExternalSyntheticLambda0 = new AddShortcutActivity$$ExternalSyntheticLambda0(editTextArr, 1);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(addShortcutActivity$$ExternalSyntheticLambda0);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(editText2, 20), 100L);
    }

    int getDefaultThemeResId(Context context);

    int getDefaultTitleResId();

    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionContentDescription(Context context);

    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<S> onSelectionChangedListener);

    void select(long j);

    void setSelection(S s);
}
