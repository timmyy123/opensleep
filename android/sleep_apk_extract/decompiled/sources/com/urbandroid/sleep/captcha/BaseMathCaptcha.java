package com.urbandroid.sleep.captcha;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import java.io.Serializable;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseMathCaptcha extends AbstractCaptchaActivity {
    protected static final Random random = new Random();
    protected CaptchaStatus status;

    public static class CaptchaStatus implements Serializable {
        int correctAnswer;
        Object customExtension;
        int r;
        int s;
        int tries = 0;
        boolean wrong = false;
        int x;
        int y;
        int z;
    }

    private void doSetup() {
        int difficulty = getDifficulty();
        CaptchaStatus captchaStatus = this.status;
        Random random2 = random;
        int i = (difficulty * 2) + 6;
        captchaStatus.x = random2.nextInt(i) + 2;
        this.status.y = random2.nextInt(i) + 2;
        this.status.z = random2.nextInt(i) + 2;
        this.status.r = difficulty > 2 ? random2.nextInt(i) + 2 : 0;
        this.status.s = difficulty > 4 ? random2.nextInt(6) + 2 : 1;
        if (difficulty > 4) {
            this.status.y *= 2;
        }
        CaptchaStatus captchaStatus2 = this.status;
        if (captchaStatus2.r == captchaStatus2.z) {
            captchaStatus2.z = random2.nextInt(i) + 2;
        }
        CaptchaStatus captchaStatus3 = this.status;
        int i2 = captchaStatus3.x;
        int i3 = captchaStatus3.y;
        int i4 = captchaStatus3.z;
        int i5 = captchaStatus3.r;
        int i6 = ((i2 * i3) + i4) - i5;
        captchaStatus3.correctAnswer = i6;
        int i7 = captchaStatus3.s;
        int i8 = (i7 - (i6 % i7)) + i4;
        captchaStatus3.z = i8;
        captchaStatus3.correctAnswer = (((i2 * i3) + i8) - i5) / i7;
        StringBuilder sb = new StringBuilder("Math ");
        sb.append(this.status.x);
        sb.append(" ");
        sb.append(this.status.y);
        sb.append(" ");
        sb.append(this.status.z);
        sb.append(" ");
        sb.append(this.status.r);
        sb.append(" ");
        zza$$ExternalSyntheticOutline0.m(sb, this.status.s);
        CaptchaStatus captchaStatus4 = this.status;
        captchaStatus4.customExtension = setupValuesExtension(captchaStatus4.x, captchaStatus4.y, captchaStatus4.z, captchaStatus4.r, captchaStatus4.s, captchaStatus4.correctAnswer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$answerProvided$0(DialogInterface dialogInterface, int i) {
    }

    private void refreshTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.status.tries + 1);
        sb.append(" / ");
        sb.append(getDifficulty());
        sb.append(" ");
        sb.append(getString(this instanceof SimpleMathCaptcha ? R.string.captcha_simple_math_title : R.string.captcha_typed_math_title));
        setTitle(sb.toString());
    }

    private void setupValues() {
        doSetup();
        while (this.status.correctAnswer < 1) {
            doSetup();
        }
    }

    public void answerProvided(int i) {
        CaptchaStatus captchaStatus = this.status;
        if (i == captchaStatus.correctAnswer) {
            if (!captchaStatus.wrong) {
                captchaStatus.tries++;
            }
            captchaStatus.wrong = false;
            if (captchaStatus.tries >= getDifficulty()) {
                setResult(2);
                solved();
                return;
            } else {
                setupValues();
                CaptchaStatus captchaStatus2 = this.status;
                showValues(captchaStatus2.x, captchaStatus2.y, captchaStatus2.z, captchaStatus2.r, captchaStatus2.s, captchaStatus2.correctAnswer, captchaStatus2.customExtension);
                refreshTitle();
                return;
            }
        }
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(this).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(4));
        positiveButton.setMessage(R.string.captcha_failed);
        AlertDialog alertDialogCreate = positiveButton.create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
        DialogUtil.fixButtonsAndDivider(alertDialogCreate, R.color.white);
        this.status.wrong = true;
        if (getDifficulty() <= 2 || getClass() != SimpleMathCaptcha.class || this.status.tries <= 0) {
            return;
        }
        Toast.makeText(this, R.string.captcha_oops, 0).show();
        this.status.tries--;
        refreshTitle();
    }

    public abstract void initializeLayoutOnCreate();

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initializeLayoutOnCreate();
        if (getLastCustomNonConfigurationInstance() == null) {
            this.status = new CaptchaStatus();
            setupValues();
        } else if (getLastCustomNonConfigurationInstance() instanceof CaptchaStatus) {
            this.status = (CaptchaStatus) getLastCustomNonConfigurationInstance();
        }
        CaptchaStatus captchaStatus = this.status;
        showValues(captchaStatus.x, captchaStatus.y, captchaStatus.z, captchaStatus.r, captchaStatus.s, captchaStatus.correctAnswer, captchaStatus.customExtension);
        refreshTitle();
        if (bundle != null) {
            this.status = (CaptchaStatus) bundle.get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        }
    }

    @Override // androidx.view.ComponentActivity
    public Object onRetainCustomNonConfigurationInstance() {
        return this.status;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.status);
    }

    public Object setupValuesExtension(int i, int i2, int i3, int i4, int i5, int i6) {
        return null;
    }

    public abstract void showValues(int i, int i2, int i3, int i4, int i5, int i6, Object obj);
}
