package com.urbandroid.sleep.gui.dialog;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/CaptchaAvoidedDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/FixedDialogFragment;", "<init>", "()V", "createDialog", "Landroid/app/Dialog;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaAvoidedDialogFragment extends FixedDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$0(CaptchaAvoidedDialogFragment captchaAvoidedDialogFragment, DialogInterface dialogInterface, int i) {
        Context context = captchaAvoidedDialogFragment.getContext();
        if (context != null) {
            CaptchaCheatingSettingsActivity.INSTANCE.startDispute(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1(CaptchaAvoidedDialogFragment captchaAvoidedDialogFragment, DialogInterface dialogInterface, int i) {
        Context context = captchaAvoidedDialogFragment.getContext();
        if (context != null) {
            CaptchaCheatingSettingsActivity.INSTANCE.startPurchase(context);
        }
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        Settings settings = new Settings(getContext());
        Context context = getContext();
        context.getClass();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder((FragmentActivity) context);
        materialAlertDialogBuilder.setTitle(R.string.captcha_no_escape);
        materialAlertDialogBuilder.setMessage((CharSequence) (getString(R.string.alarm_avoid_protection_failed) + (settings.getCaptchaAvoidedText() != null ? FileInsert$$ExternalSyntheticOutline0.m(" (", settings.getCaptchaAvoidedText(), ")") : "")));
        final int i = 0;
        materialAlertDialogBuilder.setNeutralButton(R.string.dispute, new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.dialog.CaptchaAvoidedDialogFragment$$ExternalSyntheticLambda0
            public final /* synthetic */ CaptchaAvoidedDialogFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                int i3 = i;
                CaptchaAvoidedDialogFragment captchaAvoidedDialogFragment = this.f$0;
                switch (i3) {
                    case 0:
                        CaptchaAvoidedDialogFragment.createDialog$lambda$0(captchaAvoidedDialogFragment, dialogInterface, i2);
                        break;
                    default:
                        CaptchaAvoidedDialogFragment.createDialog$lambda$1(captchaAvoidedDialogFragment, dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        materialAlertDialogBuilder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.gui.dialog.CaptchaAvoidedDialogFragment$$ExternalSyntheticLambda0
            public final /* synthetic */ CaptchaAvoidedDialogFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                int i3 = i2;
                CaptchaAvoidedDialogFragment captchaAvoidedDialogFragment = this.f$0;
                switch (i3) {
                    case 0:
                        CaptchaAvoidedDialogFragment.createDialog$lambda$0(captchaAvoidedDialogFragment, dialogInterface, i22);
                        break;
                    default:
                        CaptchaAvoidedDialogFragment.createDialog$lambda$1(captchaAvoidedDialogFragment, dialogInterface, i22);
                        break;
                }
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        dialog.getClass();
        super.onDismiss(dialog);
        Logger.logDebug("onDismissed " + getActivity());
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof OnDismissedListener) {
            ((OnDismissedListener) activity).onDismiss(CaptchaAvoidedDialogFragment.class, 0);
        }
    }
}
