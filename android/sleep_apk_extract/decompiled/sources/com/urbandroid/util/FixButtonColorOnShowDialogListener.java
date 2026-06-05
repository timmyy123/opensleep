package com.urbandroid.util;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes4.dex */
public class FixButtonColorOnShowDialogListener implements DialogInterface.OnShowListener {
    private int color;

    public FixButtonColorOnShowDialogListener(int i) {
        this.color = i;
    }

    public void fixButton(AlertDialog alertDialog, int i) {
        if (alertDialog.getButton(i) != null) {
            alertDialog.getButton(i).setTextColor(ColorUtil.i(alertDialog.getContext(), this.color));
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        if (dialogInterface instanceof androidx.appcompat.app.AlertDialog) {
            androidx.appcompat.app.AlertDialog alertDialog = (androidx.appcompat.app.AlertDialog) dialogInterface;
            fixButton(alertDialog, -1);
            fixButton(alertDialog, -3);
            fixButton(alertDialog, -2);
            return;
        }
        if (dialogInterface instanceof AlertDialog) {
            AlertDialog alertDialog2 = (AlertDialog) dialogInterface;
            fixButton(alertDialog2, -1);
            fixButton(alertDialog2, -3);
            fixButton(alertDialog2, -2);
        }
    }

    public void fixButton(androidx.appcompat.app.AlertDialog alertDialog, int i) {
        if (alertDialog.getButton(i) != null) {
            alertDialog.getButton(i).setTextColor(ColorUtil.i(alertDialog.getContext(), this.color));
        }
    }
}
