package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.home.AutomationSelected;
import com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment;
import com.urbandroid.sleep.service.google.home.GoogleHomeClient;
import com.urbandroid.sleep.service.google.home.GoogleHomePermission;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0014¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/GoogleHomeAutomationSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/sleep/service/google/home/GoogleHomePermission;", "Lcom/urbandroid/sleep/service/google/home/AutomationSelected;", "<init>", "()V", "getSettings", "", "selected", "", "refreshSummaries", "getTitleResource", "hasPermission", "has", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "getDocumentationUrl", "", "onPause", "onResume", "refresh", "preferenceActivity", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "searchMode", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleHomeAutomationSettingsActivity extends SimpleSettingsActivity implements GoogleHomePermission, AutomationSelected {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(Context context, GoogleHomeAutomationSettingsActivity googleHomeAutomationSettingsActivity, Preference preference, Object obj) {
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 27) {
            GoogleHomeClient.INSTANCE.getInstance(context).requestPermissionsIfNeeded(googleHomeAutomationSettingsActivity);
            return true;
        }
        Toast.makeText(context, googleHomeAutomationSettingsActivity.getString(R.string.not_supported, googleHomeAutomationSettingsActivity.getString(R.string.service_google_home)), 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$0(String str, GoogleHomeAutomationSettingsActivity googleHomeAutomationSettingsActivity, Preference preference) {
        Logger.logInfo("Home: click on pref " + str);
        GoogleHomeAutomationListDialogFragment googleHomeAutomationListDialogFragment = new GoogleHomeAutomationListDialogFragment(googleHomeAutomationSettingsActivity);
        Bundle bundle = new Bundle();
        bundle.putString(GoogleHomeAutomationListDialogFragment.INSTANCE.getPREF(), str);
        googleHomeAutomationListDialogFragment.setArguments(bundle);
        googleHomeAutomationListDialogFragment.show(googleHomeAutomationSettingsActivity.getSupportFragmentManager(), str);
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//automation/";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_service_google_home;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.service_google_home;
    }

    @Override // com.urbandroid.sleep.service.google.home.GoogleHomePermission
    public void hasPermission(boolean has) {
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 27) {
            GoogleHomeClient.INSTANCE.getInstance(this).getClient().registerActivityResultCallerForPermissions(this);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        preferenceActivity.getClass();
        preferenceActivity.getPreferenceScreen();
        new Settings(preferenceActivity);
        refreshSummaries();
        Preference preferenceFindPreference = findPreference("settings_google_home_automation");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(preferenceActivity, this, 5));
        }
        String[] strArr = {"settings_google_home_automation_bedtime", "settings_google_home_automation_alarm", "settings_google_home_automation_wake_up"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            Preference preferenceFindPreference2 = findPreference(str);
            if (preferenceFindPreference2 != null) {
                preferenceFindPreference2.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(str, this, 4));
            }
        }
    }

    public final void refreshSummaries() {
        String[] strArr = {"settings_google_home_automation_bedtime", "settings_google_home_automation_alarm", "settings_google_home_automation_wake_up"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            Preference preferenceFindPreference = findPreference(str);
            if (preferenceFindPreference != null) {
                String googleHomeAutomationName = SharedApplicationContext.getSettings().getGoogleHomeAutomationName(str);
                if (googleHomeAutomationName == null) {
                    googleHomeAutomationName = "";
                }
                preferenceFindPreference.setSummary(googleHomeAutomationName);
            }
        }
    }

    @Override // com.urbandroid.sleep.service.google.home.AutomationSelected
    public void selected() {
        refreshSummaries();
    }
}
