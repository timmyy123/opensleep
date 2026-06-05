package com.urbandroid.sleep.gui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class FixedDialogFragment extends DialogFragment {
    public abstract Dialog createDialog();

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        final Dialog dialogCreateDialog = createDialog();
        dialogCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.urbandroid.sleep.gui.dialog.FixedDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogUtil.fixDivider(dialogCreateDialog);
            }
        });
        return dialogCreateDialog;
    }
}
