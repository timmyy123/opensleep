package com.urbandroid.sleep.alarmclock.settings;

import android.view.View;
import android.widget.Button;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.IOnBindListener;
import com.urbandroid.sleep.gui.ListPreferenceWithButton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/urbandroid/sleep/alarmclock/settings/CaptchaCheatingSettingsActivity$refresh$3$1", "Lcom/urbandroid/sleep/gui/IOnBindListener;", "onBind", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaCheatingSettingsActivity$refresh$3$1 implements IOnBindListener {
    final /* synthetic */ ListPreferenceWithButton $phoneSwitchOffPref;
    final /* synthetic */ CaptchaCheatingSettingsActivity this$0;

    public CaptchaCheatingSettingsActivity$refresh$3$1(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, ListPreferenceWithButton listPreferenceWithButton) {
        this.this$0 = captchaCheatingSettingsActivity;
        this.$phoneSwitchOffPref = listPreferenceWithButton;
    }

    @Override // com.urbandroid.sleep.gui.IOnBindListener
    public void onBind() {
        CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity = this.this$0;
        View actionButton = this.$phoneSwitchOffPref.getActionButton();
        actionButton.getClass();
        captchaCheatingSettingsActivity.refundButton = (Button) actionButton;
        Button button = this.this$0.refundButton;
        if (button != null) {
            CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity2 = this.this$0;
            button.setOnClickListener(new CaptchaCheatingSettingsActivity$$ExternalSyntheticLambda5(captchaCheatingSettingsActivity2, 2));
            button.setText(R.string.refund);
            button.setVisibility(captchaCheatingSettingsActivity2.getSettings().isCaptchaAvoidedPurchased() ? 0 : 8);
        }
    }
}
