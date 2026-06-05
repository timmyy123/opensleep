package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes4.dex */
public class DontPressWithParentLayout extends LinearLayout {
    public DontPressWithParentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z && ((View) getParent()).isPressed()) {
            return;
        }
        super.setPressed(z);
    }
}
