package com.urbandroid.sleep.captcha;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CryptoUtil;
import com.urbandroid.sleep.NFCTagPreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.FixButtonColorOnShowDialogListener;

/* JADX INFO: loaded from: classes4.dex */
public class NFCCaptcha extends BaseScanningCaptcha<TagStringRepresentation> {
    private boolean lastExecutionInLearnMode;

    public static class TagStringRepresentation {
        public final String fallbackValue;
        public final String value;

        public TagStringRepresentation(String str, String str2) {
            this.value = str;
            this.fallbackValue = str2;
        }

        public String toString() {
            return "Value: " + this.value + " Fallback: " + this.fallbackValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface, int i) {
        if (this.lastExecutionInLearnMode) {
            return;
        }
        solved();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        if (this.lastExecutionInLearnMode) {
            return;
        }
        solved();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void addScannedValue(String str) {
        SharedApplicationContext.getSettings().addNFCCaptcha(str);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void forgetAllCaptchas() {
        SharedApplicationContext.getSettings().forgetAllNFCCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public String[] getStoredValues() {
        return SharedApplicationContext.getSettings().getNFCCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public int getTitleResource() {
        return R.string.captcha_nfc_tag_title;
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public Class getTutorialActivity() {
        return NFCTagPreviewActivity.class;
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isHomeMode() {
        return SharedApplicationContext.getSettings().isNFCCaptchaHomeOnly();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isMultiscanMode() {
        return SharedApplicationContext.getSettings().isNFCCaptchaMultiscan();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.lastExecutionInLearnMode = wasExecutedInLearnMode(i);
        if (i2 == -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 == 35422399) {
            Logger.logInfo("NFC captcha marked as solved as it is not supported.");
            showDialog(1);
        } else if (i2 == 35422400) {
            Logger.logInfo("NFC captcha marked as solved as it is disabled.");
            showDialog(2);
        }
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha, com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getResources().getBoolean(R.bool.tablet)) {
            setRequestedOrientation(0);
            setRequestedOrientation(14);
        } else {
            setRequestedOrientation(1);
            setRequestedOrientation(14);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        int i2 = 1;
        if (i == 1) {
            AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this).setTitle(R.string.nfc_not_supported_title).setMessage(R.string.nfc_not_supported_message).setPositiveButton(R.string.text_close, (DialogInterface.OnClickListener) new NFCCaptcha$$ExternalSyntheticLambda0(this, 0)).create();
            alertDialogCreate.setOnShowListener(new FixButtonColorOnShowDialogListener(R.color.white));
            return alertDialogCreate;
        }
        if (i != 2) {
            return null;
        }
        AlertDialog alertDialogCreate2 = new MaterialAlertDialogBuilder(this).setTitle(R.string.nfc_disabled_title).setMessage(R.string.nfc_disabled_message).setPositiveButton(R.string.text_close, (DialogInterface.OnClickListener) new NFCCaptcha$$ExternalSyntheticLambda0(this, i2)).create();
        alertDialogCreate2.setOnShowListener(new FixButtonColorOnShowDialogListener(R.color.white));
        return alertDialogCreate2;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        DialogUtil.fixDivider(dialog);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void setHomeMode(boolean z) {
        SharedApplicationContext.getSettings().setNFCCaptchaHomeOnly(z);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void setMultiscanMode(boolean z) {
        SharedApplicationContext.getSettings().setNFCCaptchaMultiscan(z);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean showTutorial() {
        return SharedApplicationContext.getSettings().isFirstUsageNFCCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void startScanner(boolean z) {
        startActivityForResult(new Intent(this, (Class<?>) NFCScanner.class), z ? 35324 : 35325);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean wasExecutedInLearnMode(int i) {
        return i == 35324;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public TagStringRepresentation parseScannedValue(int i, int i2, Intent intent) {
        return NFCScannerHelper.parseScannedValue(intent);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public String convertToMD5(TagStringRepresentation tagStringRepresentation) {
        return CryptoUtil.md5(tagStringRepresentation.value);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isValueEqual(TagStringRepresentation tagStringRepresentation, String str) {
        return NFCScannerHelper.isValueEqual(tagStringRepresentation, str);
    }
}
