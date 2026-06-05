package com.urbandroid.util;

import android.app.Dialog;
import android.content.DialogInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.FixedDialogFragment;

/* JADX INFO: loaded from: classes5.dex */
public class BetaDialogFragment extends FixedDialogFragment {
    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        return new MaterialAlertDialogBuilder(getActivity()).setTitle(R.string.beta_only).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.urbandroid.util.BetaDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ViewIntent.url(BetaDialogFragment.this.getActivity(), "https://goo.gl/mnF3Cg");
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.urbandroid.util.BetaDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setMessage(R.string.beta_only_explanation).create();
    }
}
