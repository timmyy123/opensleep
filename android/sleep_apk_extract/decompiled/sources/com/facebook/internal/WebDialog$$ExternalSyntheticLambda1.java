package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.Instructions.Instructions;
import com.urbandroid.sleep.achievement.AbstractAchievementItem;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker;
import com.urbandroid.sleep.captcha.list.CaptchaItem;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.fragment.dashboard.DashboardFragment;
import com.urbandroid.sleep.fragment.dashboard.card.LastCard;
import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import com.urbandroid.sleep.fragment.dashboard.card.NextAlarmCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailAdviceRdiCard;
import com.urbandroid.sleep.fragment.dashboard.card.UnlockCard;
import com.urbandroid.sleep.fragment.preview.AnalyticsConsentPreviewPage;
import com.urbandroid.sleep.fragment.preview.TermsPreviewPage;
import com.urbandroid.sleep.gui.ButtonPreference;
import com.urbandroid.sleep.gui.drawer.IMenuDrawerItem;
import com.urbandroid.sleep.gui.drawer.MenuDrawerHeader;
import com.urbandroid.sleep.gui.pref.HelpPreferenceCategory;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity;
import com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity;
import com.urbandroid.sleep.shortcut.AbstractShortcutItem;
import com.urbandroid.sleep.shortcut.ShortcutActivity;
import com.urbandroid.sleep.shortcut.ShortcutItem;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WebDialog$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ WebDialog$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                WebDialog.createCrossImage$lambda$5((WebDialog) obj, view);
                break;
            case 1:
                DeviceAuthDialog.initializeContentView$lambda$2((DeviceAuthDialog) obj, view);
                break;
            case 2:
                ToolTipPopup.show$lambda$3((ToolTipPopup) obj, view);
                break;
            case 3:
                ((MaterialButtonGroup) obj).lambda$initializeButtonOverflow$1(view);
                break;
            case 4:
                ((Instructions) obj).lambda$showDndWarning$0(view);
                break;
            case 5:
                ((AbstractAchievementItem) obj).onItemClicked();
                break;
            case 6:
                ((SimpleSettingsActivity) obj).lambda$onCreatePreference$0(view);
                break;
            case 7:
                ((MaterialTimePicker) obj).dismiss();
                break;
            case 8:
                ((RoundTimePicker) obj).dismiss();
                break;
            case 9:
                ((CaptchaItem) obj).onItemClicked();
                break;
            case 10:
                ((SleepGraphInitializer) obj).lambda$initHypnogram$0(view);
                break;
            case 11:
                DashboardFragment.initFab$lambda$0$0$0((View) obj, view);
                break;
            case 12:
                ((LastCard) obj).lambda$bindView$3(view);
                break;
            case 13:
                NativeAdCard.createAdBuilder$lambda$0$5((NativeAdCard) obj, view);
                break;
            case 14:
                NextAlarmCard.lambda$bindView$1((Context) obj, view);
                break;
            case 15:
                SleepDetailAdviceRdiCard.bindSleepRecordToView$lambda$0((SleepDetailAdviceRdiCard) obj, view);
                break;
            case 16:
                ((UnlockCard) obj).startUnlockFlow();
                break;
            case 17:
                AnalyticsConsentPreviewPage.adjustLayout$lambda$0((AnalyticsConsentPreviewPage) obj, view);
                break;
            case 18:
                ((Activity) obj).finish();
                break;
            case 19:
                TermsPreviewPage.adjustLayout$lambda$0((TermsPreviewPage) obj, view);
                break;
            case 20:
                ButtonPreference.onBindView$lambda$0((ButtonPreference) obj, view);
                break;
            case 21:
                ((IMenuDrawerItem) obj).onClick();
                break;
            case 22:
                MenuDrawerHeader.bindView$lambda$0$0((MenuDrawerHeader) obj, view);
                break;
            case 23:
                ((HelpPreferenceCategory) obj).lambda$onBindView$0(view);
                break;
            case 24:
                HealthConnectSyncActivity.onResume$lambda$0((HealthConnectSyncActivity) obj, view);
                break;
            case 25:
                ((GoogleHomeLightActivity) obj).finish();
                break;
            case 26:
                ((AbstractShortcutItem) obj).onItemClicked();
                break;
            case 27:
                ShortcutActivity.onCreate$lambda$1((ShortcutActivity) obj, view);
                break;
            default:
                ShortcutItem.bindView$lambda$0((ShortcutItem) obj, view);
                break;
        }
    }
}
