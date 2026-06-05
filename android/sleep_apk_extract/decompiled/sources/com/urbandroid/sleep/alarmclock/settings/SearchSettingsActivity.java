package com.urbandroid.sleep.alarmclock.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SearchSettingsActivity extends SimpleSettingsActivity {
    private int[] prefResources;
    private EditText searchText;
    private List<SimpleSettingsActivity> preferenceActivities = new ArrayList();
    private List<Preference> preferences = new ArrayList();
    private Map<Preference, Boolean> preferenceVisible = new HashMap();
    private Map<Preference, PreferenceGroup> preferenceParent = new HashMap();
    private boolean wasSearchQueried = false;
    private boolean searchFailedAtLeastOnce = false;
    int index = 0;

    private int addCategoryToTitle(String str, int i) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        int preferenceCount = preferenceScreen.getPreferenceCount();
        while (i < preferenceCount) {
            Preference preference = preferenceScreen.getPreference(i);
            if (preference.getTitle() == null) {
                preference.setTitle(str);
            } else {
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, ": ");
                sbM.append((Object) preference.getTitle());
                preference.setTitle(sbM.toString());
            }
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getVisible(Preference preference) {
        return this.preferenceVisible.get(preference).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnythingVisible() {
        Iterator<Boolean> it = this.preferenceVisible.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(Preference preference, boolean z) {
        this.preferenceVisible.put(preference, Boolean.valueOf(z));
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public void afterPrefAdded(int i) {
        if (i == R.xml.settings_alarm) {
            this.index = addCategoryToTitle(getString(R.string.default_label), this.index);
            return;
        }
        if (i == R.xml.settings_backup_alarm) {
            this.index = addCategoryToTitle(getString(R.string.siren_ringtone_title), this.index);
            return;
        }
        if (i == R.xml.settings_bedtime) {
            this.index = addCategoryToTitle(getString(R.string.target_sleep_time_notify_title), this.index);
            return;
        }
        if (i == R.xml.settings_captcha) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_captcha), this.index);
            return;
        }
        if (i == R.xml.settings_jetlag) {
            this.index = addCategoryToTitle(getString(R.string.jetlag), this.index);
            return;
        }
        if (i == R.xml.settings_lucid_without_sensitivity) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_lucid_title), this.index);
            return;
        }
        if (i == R.xml.settings_lullaby) {
            this.index = addCategoryToTitle(getString(R.string.lullaby), this.index);
            return;
        }
        if (i == R.xml.settings_misc) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_misc), this.index);
            return;
        }
        if (i == R.xml.settings_noise) {
            this.index = addCategoryToTitle(getString(R.string.sleep_recording_title), this.index);
            return;
        }
        if (i == R.xml.settings_service) {
            this.index = addCategoryToTitle(getString(R.string.category_services), this.index);
            return;
        }
        if (i == R.xml.settings_smartlight) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_smartlight), this.index);
            return;
        }
        if (i == R.xml.settings_smart) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_smart), this.index);
            return;
        }
        if (i == R.xml.settings_smartwatch) {
            this.index = addCategoryToTitle(getString(R.string.smartwatch), this.index);
            return;
        }
        if (i == R.xml.settings_snooze) {
            this.index = addCategoryToTitle(getString(R.string.alarm_alert_snooze_text), this.index);
            return;
        }
        if (i == R.xml.settings_social) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_social), this.index);
        } else if (i == R.xml.settings_track) {
            this.index = addCategoryToTitle(getString(R.string.settings_category_track), this.index);
        } else if (i == R.xml.settings_awake) {
            this.index = addCategoryToTitle(getString(R.string.awake_detection), this.index);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_search_settings;
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int[] getPreferenceResources() {
        return this.prefResources;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_alarm;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ToolbarUtil.apply(this);
        this.preferenceActivities.add(new AlarmSettingsActivity());
        this.preferenceActivities.add(new BackupAlarmSettingsActivity());
        this.preferenceActivities.add(new BedtimeSettingsActivity());
        this.preferenceActivities.add(new CaptchaSettingsActivity());
        this.preferenceActivities.add(new JetLagSettingsActivity());
        this.preferenceActivities.add(new LucidSettingsActivity());
        this.preferenceActivities.add(new LullabySettingsActivity());
        this.preferenceActivities.add(new MiscSettingsActivity());
        this.preferenceActivities.add(new NoiseSettingsActivity());
        this.preferenceActivities.add(new ServicesSettingsActivity());
        this.preferenceActivities.add(new SmartLightSettingsActivity());
        this.preferenceActivities.add(new SmartSettingsActivity());
        this.preferenceActivities.add(new SmartwatchSettingsActivity());
        this.preferenceActivities.add(new SnoozeSettingsActivity());
        this.preferenceActivities.add(new SocialSettingsActivity());
        this.preferenceActivities.add(new TrackSettingsActivity());
        this.preferenceActivities.add(new AwakeSettingsActivity());
        int i = 0;
        this.wasSearchQueried = false;
        this.prefResources = new int[this.preferenceActivities.size()];
        Iterator<SimpleSettingsActivity> it = this.preferenceActivities.iterator();
        while (it.hasNext()) {
            this.prefResources[i] = it.next().getPreferenceResource();
            i++;
        }
        this.searchText = (EditText) findViewById(R.id.search);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(false);
        }
        Iterator<SimpleSettingsActivity> it = this.preferenceActivities.iterator();
        while (it.hasNext()) {
            it.next().refresh(this, true);
        }
        int preferenceCount = getPreferenceScreen().getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            Preference preference = getPreferenceScreen().getPreference(i);
            boolean z = preference instanceof PreferenceCategory;
            List<Preference> list = this.preferences;
            if (z) {
                PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                list.add(preferenceGroup);
                preferenceGroup.setLayoutResource(R.layout.category);
                this.preferenceParent.put(preferenceGroup, getPreferenceScreen());
                setVisible(preferenceGroup, false);
                int preferenceCount2 = preferenceGroup.getPreferenceCount();
                for (int i2 = 0; i2 < preferenceCount2; i2++) {
                    Preference preference2 = preferenceGroup.getPreference(i2);
                    this.preferences.add(preference2);
                    setVisible(preference2, false);
                    this.preferenceParent.put(preference2, preferenceGroup);
                }
            } else {
                list.add(preference);
                setVisible(preference, false);
                this.preferenceParent.put(preference, getPreferenceScreen());
            }
        }
        for (Preference preference3 : this.preferences) {
            this.preferenceParent.get(preference3).removePreference(preference3);
        }
        this.searchText.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.sleep.alarmclock.settings.SearchSettingsActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                if (charSequence == null) {
                    return;
                }
                String lowerCase = charSequence.toString().trim().toLowerCase();
                if (!SearchSettingsActivity.this.wasSearchQueried) {
                    SearchSettingsActivity.this.wasSearchQueried = true;
                    SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSearchUsed();
                }
                for (Preference preference4 : SearchSettingsActivity.this.preferences) {
                    if (PreferenceExtKt.matches(preference4, lowerCase)) {
                        if (!SearchSettingsActivity.this.getVisible(preference4)) {
                            PreferenceGroup preferenceGroup2 = (PreferenceGroup) SearchSettingsActivity.this.preferenceParent.get(preference4);
                            if (!preferenceGroup2.equals(SearchSettingsActivity.this.getPreferenceScreen()) && !SearchSettingsActivity.this.getVisible(preferenceGroup2)) {
                                SearchSettingsActivity.this.getPreferenceScreen().addPreference(preferenceGroup2);
                                SearchSettingsActivity.this.setVisible(preferenceGroup2, true);
                            }
                            preferenceGroup2.addPreference(preference4);
                            SearchSettingsActivity.this.setVisible(preference4, true);
                        }
                        if ((preference4 instanceof PreferenceCategory) && ((PreferenceCategory) preference4).getPreferenceCount() == 0) {
                            SearchSettingsActivity.this.getPreferenceScreen().removePreference(preference4);
                            SearchSettingsActivity.this.setVisible(preference4, false);
                        }
                    } else if (!(preference4 instanceof PreferenceCategory) && ((Boolean) SearchSettingsActivity.this.preferenceVisible.get(preference4)).booleanValue()) {
                        PreferenceGroup preferenceGroup3 = (PreferenceGroup) SearchSettingsActivity.this.preferenceParent.get(preference4);
                        preferenceGroup3.removePreference(preference4);
                        SearchSettingsActivity.this.setVisible(preference4, false);
                        if (!SearchSettingsActivity.this.getPreferenceScreen().equals(preferenceGroup3) && preferenceGroup3.getPreferenceCount() == 0) {
                            SearchSettingsActivity.this.getPreferenceScreen().removePreference(preferenceGroup3);
                            SearchSettingsActivity.this.setVisible(preferenceGroup3, false);
                        }
                    }
                }
                boolean zIsAnythingVisible = SearchSettingsActivity.this.isAnythingVisible();
                SearchSettingsActivity searchSettingsActivity = SearchSettingsActivity.this;
                if (zIsAnythingVisible) {
                    searchSettingsActivity.findViewById(R.id.no_data).setVisibility(8);
                } else {
                    searchSettingsActivity.findViewById(R.id.no_data).setVisibility(0);
                }
                if (SearchSettingsActivity.this.isAnythingVisible() || !SearchSettingsActivity.this.wasSearchQueried || SearchSettingsActivity.this.searchFailedAtLeastOnce || lowerCase.isEmpty()) {
                    return;
                }
                SearchSettingsActivity.this.searchFailedAtLeastOnce = true;
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSearchFailed(lowerCase);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SearchSettingsActivity.2
            @Override // java.lang.Runnable
            public void run() {
                SearchSettingsActivity.this.searchText.setFocusableInTouchMode(true);
                SearchSettingsActivity.this.searchText.setFocusable(true);
                SearchSettingsActivity.this.searchText.requestFocus();
                ((InputMethodManager) SearchSettingsActivity.this.getSystemService("input_method")).showSoftInput(SearchSettingsActivity.this.searchText, 1);
            }
        }, 500L);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ActivityCompat.finishAfterTransition(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = 0;
        for (String str : strArr) {
            if (iArr[i2] != 0) {
                MaterialAlertDialogBuilder message = new MaterialAlertDialogBuilder(this).setTitle(R.string.no_permission).setMessage((CharSequence) ViewIntent.getNoPermissionText(this, str, -1));
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                    message.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SearchSettingsActivity.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            ViewIntent.showPermissionsSettings(SearchSettingsActivity.this);
                        }
                    }).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
                } else {
                    message.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null);
                }
                message.show();
            }
            i2++;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isAnythingVisible()) {
            findViewById(R.id.no_data).setVisibility(8);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
