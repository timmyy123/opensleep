package com.urbandroid.util;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.CheckBoxPreference;
import android.view.ViewGroup;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.garmin.android.connectiq.AutoUIDialogHostActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaWakeUpCheckSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity;
import com.urbandroid.sleep.captcha.list.CaptchaTileDialogFragment;
import com.urbandroid.sleep.fragment.dashboard.card.BedtimeCard;
import com.urbandroid.sleep.fragment.dashboard.morning.MorningActivity;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.dialog.ItemDialogFragment;
import com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment;
import com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$initSynchronizeButton$action$1;
import com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment;
import com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class VolumeUtil$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ VolumeUtil$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i2) {
            case 0:
                VolumeUtil.askStreamVolumePermission$lambda$0((Context) obj, dialogInterface, i);
                break;
            case 1:
                DeviceAuthDialog.presentConfirmation$lambda$8((DeviceAuthDialog) obj, dialogInterface, i);
                break;
            case 2:
                LoginButton.LoginClickListener.performLogout$lambda$2((LoginManager) obj, dialogInterface, i);
                break;
            case 3:
                ((AutoUIDialogHostActivity) obj).lambda$showTheAlertDialog$0(dialogInterface, i);
                break;
            case 4:
                CaptchaCheatingSettingsActivity.showNoEscapeDialog$lambda$0((CaptchaCheatingSettingsActivity) obj, dialogInterface, i);
                break;
            case 5:
                CaptchaWakeUpCheckSettingsActivity.checkNotification$lambda$0((CaptchaWakeUpCheckSettingsActivity) obj, dialogInterface, i);
                break;
            case 6:
                ((CheckBoxPreference) obj).setChecked(false);
                break;
            case 7:
                SmartwatchSettingsActivity.lambda$regularWearableSelected$0((ViewGroup) obj, dialogInterface, i);
                break;
            case 8:
                CaptchaTileDialogFragment.onCreateDialog$lambda$1$0((CaptchaTileDialogFragment) obj, dialogInterface, i);
                break;
            case 9:
                BedtimeCard.onCardClicked$lambda$0$0$0((MaterialAlertDialogBuilder) obj, dialogInterface, i);
                break;
            case 10:
                MorningActivity.onOptionsItemSelected$lambda$1((MorningActivity) obj, dialogInterface, i);
                break;
            case 11:
                MaterialDialogListPreference.showDialog$lambda$0((MaterialDialogListPreference) obj, dialogInterface, i);
                break;
            case 12:
                ItemDialogFragment.createDialog$lambda$1((ItemDialogFragment) obj, dialogInterface, i);
                break;
            case 13:
                ((BleDeviceLookupDialogFragment) obj).callbackFailure();
                break;
            case 14:
                BleDeviceLookupDialogFragment.createDialog$lambda$0$2((BleDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1) obj, dialogInterface, i);
                break;
            case 15:
                GoogleCalendarSettingActivity$initSynchronizeButton$action$1.postSynchronization$lambda$0$0((GoogleCalendarSettingActivity) obj, dialogInterface, i);
                break;
            case 16:
                ((PolarDeviceLookupDialogFragment) obj).callbackFailure();
                break;
            default:
                PolarDeviceLookupDialogFragment.createDialog$lambda$0$2((PolarDeviceLookupDialogFragment$createDialog$1$arrayAdapter$1) obj, dialogInterface, i);
                break;
        }
    }
}
