package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.IShareService;

/* JADX INFO: loaded from: classes5.dex */
public class SocialSettingsActivity extends SimpleSettingsActivity {
    private void initSharePreference(Preference preference, IShareService iShareService) {
        if (preference == null) {
            return;
        }
        if (iShareService.isConnected(preference.getContext())) {
            preference.setTitle(preference.getContext().getString(R.string.share_connected, iShareService.getName(this)));
        } else {
            preference.setTitle(preference.getContext().getString(R.string.share_disconnected, iShareService.getName(this)));
        }
        preference.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(iShareService, preference, 10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initSharePreference$0(IShareService iShareService, Preference preference, Preference preference2) {
        String name = iShareService.getName(preference.getContext());
        if (!iShareService.isConnected(preference.getContext())) {
            iShareService.initiateLoginActivity(preference.getContext(), null);
            return true;
        }
        iShareService.disconnect(preference.getContext());
        preference2.setTitle(preference.getContext().getString(R.string.share_disconnected, name));
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//services/0parent.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_social;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_social;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Logger.logInfo("start");
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        initSharePreference(preferenceActivity.getPreferenceScreen().findPreference("share_twitter"), SharedApplicationContext.getInstance().getShareService().getTwitterAPI());
    }
}
