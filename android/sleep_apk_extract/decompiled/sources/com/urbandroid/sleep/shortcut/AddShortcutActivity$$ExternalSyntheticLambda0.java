package com.urbandroid.sleep.shortcut;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.DateSelector;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AddShortcutActivity$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AddShortcutActivity$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                AddShortcutActivity.onCreate$lambda$0((AddShortcutActivity) obj, view, z);
                break;
            default:
                DateSelector.lambda$showKeyboardWithAutoHideBehavior$0((EditText[]) obj, view, z);
                break;
        }
    }
}
