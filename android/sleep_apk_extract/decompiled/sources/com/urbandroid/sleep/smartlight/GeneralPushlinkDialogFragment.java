package com.urbandroid.sleep.smartlight;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;

/* JADX INFO: loaded from: classes5.dex */
public class GeneralPushlinkDialogFragment extends DialogFragment {
    private Activity context;
    private ProgressBar progressBar;
    private Dialog dialog = null;
    private ViewGroup rootView = null;
    private Handler h = new Handler();
    private Runnable update = new Runnable() { // from class: com.urbandroid.sleep.smartlight.GeneralPushlinkDialogFragment.1
        @Override // java.lang.Runnable
        public void run() {
            GeneralPushlinkDialogFragment.this.incrementProgress();
            GeneralPushlinkDialogFragment.this.h.removeCallbacks(this);
            GeneralPushlinkDialogFragment.this.h.postDelayed(this, 1000L);
        }
    };

    public void incrementProgress() {
        Logger.logInfo("Pushlink DIALOG progress +1");
        this.progressBar.incrementProgressBy(1);
        if (this.progressBar.getProgress() >= this.progressBar.getMax()) {
            try {
                this.h.removeCallbacks(this.update);
                dismiss();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.context = activity;
        this.rootView = (ViewGroup) InflatorUtil.get(activity).inflate(R.layout.pushlink_dialog, (ViewGroup) null);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle(R.string.txt_pushlink);
        materialAlertDialogBuilder.setNegativeButton(R.string.btn_cancel, (DialogInterface.OnClickListener) null);
        ProgressBar progressBar = (ProgressBar) this.rootView.findViewById(R.id.countdownPB);
        this.progressBar = progressBar;
        progressBar.setMax(30);
        materialAlertDialogBuilder.setView((View) this.rootView);
        this.dialog = materialAlertDialogBuilder.create();
        Logger.logInfo("Pushlink DIALOG Create");
        return this.dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Logger.logInfo("Pushlink DIALOG Dismiss");
        this.h.removeCallbacks(this.update);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        Logger.logInfo("Pushlink DIALOG show");
        this.h.postDelayed(this.update, 1000L);
    }
}
