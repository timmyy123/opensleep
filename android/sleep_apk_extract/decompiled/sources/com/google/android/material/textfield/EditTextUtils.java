package com.google.android.material.textfield;

import android.widget.EditText;

/* JADX INFO: loaded from: classes4.dex */
abstract class EditTextUtils {
    public static boolean isEditable(EditText editText) {
        return editText.getInputType() != 0;
    }
}
