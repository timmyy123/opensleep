package com.urbandroid.sleep.fragment;

import android.content.DialogInterface;
import com.urbandroid.sleep.achievement.AchievementShowcaseItem;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity;
import com.urbandroid.sleep.captcha.BaseMathCaptcha;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;
import com.urbandroid.sleep.gui.GraphListClickHandler;
import com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment;
import com.urbandroid.sleep.smartlight.DiscoveryActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class NoiseFragment$$ExternalSyntheticLambda6 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ NoiseFragment$$ExternalSyntheticLambda6(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                NoiseFragment.lambda$showHideTabDialog$6(dialogInterface, i);
                break;
            case 1:
                AchievementShowcaseItem.bindView$lambda$0$0$0(dialogInterface, i);
                break;
            case 2:
                CaptchaSettingsActivity.lambda$showCaptchaPreviewDialog$7(dialogInterface, i);
                break;
            case 3:
                PrivacySettingsActivity.lambda$refresh$3(dialogInterface, i);
                break;
            case 4:
                BaseMathCaptcha.lambda$answerProvided$0(dialogInterface, i);
                break;
            case 5:
                dialogInterface.dismiss();
                break;
            case 6:
                LastCard.lambda$bindView$1(dialogInterface, i);
                break;
            case 7:
                GraphListClickHandler.showItemOptionsDialog$lambda$1(dialogInterface, i);
                break;
            case 8:
                GoogleHomeAutomationListDialogFragment.onCreateDialog$lambda$1(dialogInterface, i);
                break;
            default:
                DiscoveryActivity.inputSecurityCode$lambda$0$0(dialogInterface, i);
                break;
        }
    }
}
