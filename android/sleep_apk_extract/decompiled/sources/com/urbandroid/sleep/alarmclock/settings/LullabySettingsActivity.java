package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.connectivity.WaitForConnectivityService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.lullaby.LullabyDialogFragment;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.media.lullaby.MeditationDialogFragment;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class LullabySettingsActivity extends SimpleSettingsActivity implements ILullabySelect {
    private Preference addonPref = null;
    private Preference meditationSessionPref;
    private AlertDialog previewDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/lullaby.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$1(PreferenceActivity preferenceActivity, Preference preference) {
        LullabyDialogFragment lullabyDialogFragment = new LullabyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("preview", true);
        lullabyDialogFragment.setArguments(bundle);
        lullabyDialogFragment.show(preferenceActivity.getSupportFragmentManager(), "lullaby");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference, Preference preference2, Object obj) {
        int i;
        try {
            i = Integer.parseInt(obj.toString()) / 60000;
        } catch (NumberFormatException e) {
            Logger.logSevere(e);
            i = -1;
        }
        zza$$ExternalSyntheticOutline0.m(i, "Lullaby: Playlist pref ");
        if (i <= 0) {
            preference.setSummary(getResources().getString(R.string.playlist_loop_single));
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.next));
        sb.append(" ");
        sb.append(getResources().getString(R.string.after_time, i + " " + getString(R.string.bed_time_min)).toLowerCase());
        preference.setSummary(sb.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$3(Preference preference) {
        if (TrialFilter.getInstance().isTrial()) {
            startActivity(ViewIntent.getUrlIntent(this, "market://details?id=com.urbandroid.sleep.addon.lullaby"));
            return false;
        }
        startActivity(ViewIntent.getUrlIntent(this, "market://details?id=com.urbandroid.sleep.lullaby"));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(Preference preference) {
        ViewIntent.market(this, "com.urbandroid.lis10");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        preferenceActivity.startActivity(intent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$6(PreferenceActivity preferenceActivity, CheckBoxPreference checkBoxPreference, Preference preference, Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            checkBoxPreference.setSummary("");
            new Settings(preferenceActivity).setAutoplayLullaby("");
            return true;
        }
        LullabyDialogFragment lullabyDialogFragment = new LullabyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("select", true);
        lullabyDialogFragment.setArguments(bundle);
        lullabyDialogFragment.show(preferenceActivity.getSupportFragmentManager(), "lullaby");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$7(Preference preference, Object obj) {
        if (!((Boolean) obj).booleanValue() || TrialFilter.getInstance().isLis10()) {
            return true;
        }
        ViewIntent.market(this, "com.urbandroid.lis10");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$8(PreferenceActivity preferenceActivity, Preference preference) {
        showMeditations(preferenceActivity);
        return false;
    }

    private void showMeditations(AppCompatActivity appCompatActivity) {
        new MeditationDialogFragment().show(appCompatActivity.getSupportFragmentManager(), "meditation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRadios(AppCompatActivity appCompatActivity) {
        LullabyDialogFragment lullabyDialogFragment = new LullabyDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("radio", true);
        lullabyDialogFragment.setArguments(bundle);
        lullabyDialogFragment.show(appCompatActivity.getSupportFragmentManager(), "lullaby");
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/lullaby.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_lullaby;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.lullaby;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.ILullabySelect
    public void onLullabySelected(Activity activity, LullabyPlayer.Lullaby lullaby, String str) {
        if (activity instanceof PreferenceActivity) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) ((PreferenceActivity) activity).findPreference("key_auto_lullaby2");
            if (lullaby == LullabyPlayer.Lullaby.NONE) {
                Logger.logInfo("LullabySettingsActivity: autoplay NONE");
                if (checkBoxPreference != null) {
                    checkBoxPreference.setSummary("");
                    checkBoxPreference.setChecked(false);
                }
                new Settings(activity).setAutoplayLullaby("");
                return;
            }
            zza$$ExternalSyntheticOutline0.m("LullabySettingsActivity: autoplay ", str);
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(true);
                checkBoxPreference.setSummary(str);
            }
            new Settings(activity).setAutoplayLullaby(lullaby.name());
        }
    }

    public void onMeditationSelected(Activity activity, String str, Long l) {
        if (l.longValue() >= 0) {
            SharedApplicationContext.getSettings().setMeditationSessionName(str);
            SharedApplicationContext.getSettings().setMeditationSessionId(l);
            Preference preference = this.meditationSessionPref;
            if (preference != null) {
                preference.setSummary(str);
            }
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.previewDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0178  */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        Preference preferenceFindPreference;
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        PreferenceCategory preferenceCategory = (PreferenceCategory) preferenceScreen.findPreference("settings_category_lullaby");
        this.addonPref = preferenceCategory.findPreference("lullaby_addon");
        try {
            if (TrialFilter.getInstance().isAddonLullabyFree() || TrialFilter.getInstance().isAddonLullaby()) {
                Logger.logInfo("Lullaby: Playlist remove addon");
                preferenceCategory.removePreference(this.addonPref);
            } else {
                Logger.logInfo("Lullaby: Playlist add addon");
                preferenceCategory.addPreference(this.addonPref);
            }
        } catch (Exception unused) {
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("lullabies_expl");
        Object[] objArr = 0;
        if (preferenceFindPreference2 != null) {
            final Object[] objArr2 = objArr == true ? 1 : 0;
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ LullabySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i = objArr2;
                    LullabySettingsActivity lullabySettingsActivity = this.f$0;
                    switch (i) {
                        case 0:
                            return lullabySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return lullabySettingsActivity.lambda$refresh$3(preference);
                        default:
                            return lullabySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("lullaby_preview");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 13));
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("lullaby_auto_playlist");
        int lullabyAutoPlaylist = SharedApplicationContext.getSettings().getLullabyAutoPlaylist();
        zza$$ExternalSyntheticOutline0.m(lullabyAutoPlaylist, "Lullaby: Playlist pref ");
        if (preferenceFindPreference4 != null) {
            if (lullabyAutoPlaylist <= 0) {
                preferenceFindPreference4.setSummary(getResources().getString(R.string.playlist_loop_single));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(R.string.next));
                sb.append(" ");
                sb.append(getResources().getString(R.string.after_time, (lullabyAutoPlaylist / 60000) + " " + getString(R.string.bed_time_min)).toLowerCase());
                preferenceFindPreference4.setSummary(sb.toString());
            }
            preferenceFindPreference4.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, preferenceFindPreference4, 6));
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("lullaby_addon");
        final int i = 1;
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ LullabySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    LullabySettingsActivity lullabySettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return lullabySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return lullabySettingsActivity.lambda$refresh$3(preference);
                        default:
                            return lullabySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("lullaby_online_radio");
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (!WaitForConnectivityService.isRequiredNetworkAvailable(preference.getContext())) {
                        Toast.makeText(preferenceActivity, R.string.message_connectivity_wait, 0).show();
                    } else if (SharedApplicationContext.getSettings().getOnlineRadios("key_online_radios_featured").size() == 0) {
                        final ProgressDialog progressDialog = new ProgressDialog(preferenceActivity);
                        progressDialog.setIcon(R.drawable.ic_radio);
                        progressDialog.setTitle(preferenceActivity.getString(R.string.online_radio));
                        progressDialog.setMessage(preferenceActivity.getString(R.string.stats_caption_loading));
                        progressDialog.setIndeterminate(true);
                        progressDialog.show();
                        DialogUtil.fixDivider(progressDialog);
                        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity.1.1
                            @Override // android.os.AsyncTask
                            public Void doInBackground(Void... voidArr) {
                                if (SharedApplicationContext.getSettings().getOnlineRadios("key_online_radios_featured").size() != 0) {
                                    return null;
                                }
                                new OnlineRadioRingtones().getRadios();
                                return null;
                            }

                            @Override // android.os.AsyncTask
                            public void onPostExecute(Void r2) {
                                super.onPostExecute(r2);
                                if (!LullabySettingsActivity.this.isFinishing()) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    LullabySettingsActivity.this.showRadios(preferenceActivity);
                                }
                                ProgressDialog progressDialog2 = progressDialog;
                                if (progressDialog2 == null || !progressDialog2.isShowing()) {
                                    return;
                                }
                                try {
                                    progressDialog.cancel();
                                } catch (Exception e) {
                                    Logger.logSevere(e);
                                }
                            }
                        }.execute(new Void[0]);
                    } else {
                        LullabySettingsActivity.this.showRadios(preferenceActivity);
                    }
                    return true;
                }
            });
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("lullaby_online_radio_add");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
                    intent.putExtra("extra_allow_playlist", true);
                    intent.putExtra("extra_alert_radio", true);
                    intent.putExtra("extra_alert_radio_only", true);
                    intent.putExtra("extra_alert_radio_add", true);
                    preferenceActivity.startActivity(intent);
                    return true;
                }
            });
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("key_meditation_install_rate");
        if (preferenceFindPreference8 != null) {
            if (!TrialFilter.getInstance().isLis10()) {
                preferenceFindPreference8.setTitle(R.string.install_button);
                preferenceFindPreference8.setSummary((CharSequence) null);
            }
            final int i2 = 2;
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ LullabySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i2;
                    LullabySettingsActivity lullabySettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return lullabySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return lullabySettingsActivity.lambda$refresh$3(preference);
                        default:
                            return lullabySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("key_voice_setup");
        if (preferenceFindPreference9 != null) {
            preferenceFindPreference9.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 14));
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("key_auto_lullaby2");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(preferenceActivity, checkBoxPreference, 7));
            String autoplayLullabyName = new Settings(preferenceActivity).getAutoplayLullabyName();
            if (autoplayLullabyName != null) {
                try {
                } catch (Exception e) {
                    Logger.logWarning("Failed to parse lullaby auto play settings.", e);
                }
                LullabyPlayer.Lullaby lullabyValueOf = !autoplayLullabyName.isEmpty() ? LullabyPlayer.Lullaby.valueOf(autoplayLullabyName) : null;
                if (lullabyValueOf != null) {
                    checkBoxPreference.setSummary(lullabyValueOf.getDisplayName(preferenceActivity));
                } else {
                    checkBoxPreference.setSummary((CharSequence) null);
                }
            }
        }
        Preference preferenceFindPreference10 = preferenceScreen.findPreference("binaural_volume");
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setTitle(preferenceActivity.getString(R.string.binaural_title) + " " + preferenceActivity.getString(R.string.volume));
        }
        if (!SharedApplicationContext.getSettings().isGaplessFix() && (preferenceFindPreference = preferenceScreen.findPreference("settings_use_gapless_fix")) != null && ((PreferenceCategory) findPreference("settings_category_lullaby")) != null) {
            ((PreferenceCategory) findPreference("settings_category_lullaby")).removePreference(preferenceFindPreference);
        }
        Preference preferenceFindPreference11 = preferenceScreen.findPreference("key_meditation");
        int i3 = 5;
        if (preferenceFindPreference11 != null) {
            preferenceFindPreference11.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(this, i3));
        }
        Preference preferenceFindPreference12 = preferenceScreen.findPreference("key_meditation_session");
        this.meditationSessionPref = preferenceFindPreference12;
        if (preferenceFindPreference12 != null) {
            if (SharedApplicationContext.getSettings().getMeditationSessionId().longValue() >= 0) {
                this.meditationSessionPref.setSummary(SharedApplicationContext.getSettings().getMeditationSessionName());
            }
            this.meditationSessionPref.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i3));
        }
        Preference preferenceFindPreference13 = preferenceScreen.findPreference("mindroid");
        if (preferenceFindPreference13 != null) {
            preferenceFindPreference13.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.market(preferenceActivity, "com.urbandroid.mind");
                    return false;
                }
            });
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_lullaby", "settings_category_advanced", "settings_category_binaural", "settings_category_meditation");
    }
}
