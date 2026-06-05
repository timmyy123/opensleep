package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import androidx.core.content.ContextCompat;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService;
import com.urbandroid.sleep.captcha.CaptchaDrawableUtil;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.media.MultipleMediaUriUtil;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.HashSet;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmSettingsActivity extends SimpleSettingsActivity {
    private final ActivityResultLauncher<String> requestFullscreenPermissionLauncher;
    private final ActivityResultLauncher<String> requestFullscreenPermissionLauncherWhenSwitched;

    public AlarmSettingsActivity() {
        final int i = 0;
        this.requestFullscreenPermissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback(this) { // from class: com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity$$ExternalSyntheticLambda2
            public final /* synthetic */ AlarmSettingsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i2 = i;
                AlarmSettingsActivity alarmSettingsActivity = this.f$0;
                Boolean bool = (Boolean) obj;
                switch (i2) {
                    case 0:
                        alarmSettingsActivity.lambda$new$0(bool);
                        break;
                    default:
                        alarmSettingsActivity.lambda$new$1(bool);
                        break;
                }
            }
        });
        final int i2 = 1;
        this.requestFullscreenPermissionLauncherWhenSwitched = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback(this) { // from class: com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity$$ExternalSyntheticLambda2
            public final /* synthetic */ AlarmSettingsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i22 = i2;
                AlarmSettingsActivity alarmSettingsActivity = this.f$0;
                Boolean bool = (Boolean) obj;
                switch (i22) {
                    case 0:
                        alarmSettingsActivity.lambda$new$0(bool);
                        break;
                    default:
                        alarmSettingsActivity.lambda$new$1(bool);
                        break;
                }
            }
        });
    }

    public static void askOverlay(Activity activity, int i, int i2, int i3, String str, Class cls) {
        Settings settings = new Settings(activity);
        if (Build.VERSION.SDK_INT < i || android.provider.Settings.canDrawOverlays(activity)) {
            return;
        }
        if (str == null || !settings.isShowCaseShown("Overlay_".concat(str))) {
            MaterialAlertDialogBuilder message = new MaterialAlertDialogBuilder(activity).setTitle(i2).setMessage(i3);
            int i4 = 1;
            MaterialAlertDialogBuilder negativeButton = message.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new TrackSettingsActivity$$ExternalSyntheticLambda8(activity, i4)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
            if (cls != null) {
                negativeButton.setNeutralButton(R.string.turn_off, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(activity, cls, settings));
            } else if (str != null) {
                negativeButton.setNeutralButton(R.string.never_rate, (DialogInterface.OnClickListener) new AlarmSettingsActivity$$ExternalSyntheticLambda1(settings, str, i4));
            }
            negativeButton.show();
        }
    }

    private String getOrderedPlayListSuffix(Uri uri) {
        if (uri == null || !SharedApplicationContext.getSettings().isAlarmPlaylistOrdered() || SharedApplicationContext.getSettings().getPlaylistPosition() < 0) {
            return "";
        }
        int size = MultipleMediaUriUtil.size(uri);
        long playlistPosition = SharedApplicationContext.getSettings().getPlaylistPosition();
        if (size <= 1) {
            return "";
        }
        return "\n" + getString(R.string.next) + ": " + ((playlistPosition % ((long) size)) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$askOverlay$10(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$askOverlay$11(Activity activity, Class cls, Settings settings, DialogInterface dialogInterface, int i) {
        if (activity.getClass().isAssignableFrom(cls)) {
            if (settings.isAlarmFullscreenEnabled()) {
                ((SimpleSettingsActivity) activity).highlightPref("alarm_fullscreen");
                return;
            } else {
                if (settings.isFlipToSnooze()) {
                    ((SimpleSettingsActivity) activity).highlightPref("flip_to_snooze");
                    return;
                }
                return;
            }
        }
        if (settings.isAlarmFullscreenEnabled()) {
            SimpleSettingsActivity.startHighlight(activity, cls, "alarm_fullscreen");
        } else if (settings.isFlipToSnooze()) {
            SimpleSettingsActivity.startHighlight(activity, cls, "flip_to_snooze");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$askOverlay$12(Settings settings, String str, DialogInterface dialogInterface, int i) {
        settings.addShowCaseShown("Overlay_" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Boolean bool) {
        askOverlay(this, AlarmSettingsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Boolean bool) {
        askOverlay(this, R.string.no_permission);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onboardFullscreen$13(Activity activity, Settings settings, String str, DialogInterface dialogInterface, int i) {
        if (activity instanceof AlarmSettingsActivity) {
            ((AlarmSettingsActivity) activity).highlightPref("alarm_fullscreen");
        } else {
            SimpleSettingsActivity.startHighlight(activity, AlarmSettingsActivity.class, "alarm_fullscreen");
        }
        settings.addShowCaseShown(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference, Preference preference2) {
        dispatchCategory(CaptchaSettingsActivity.class, preference);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$3(Preference preference) {
        return dispatchCategory(BedtimeSettingsActivity.class, preference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(PreferenceActivity preferenceActivity, Preference preference) {
        if (Build.VERSION.SDK_INT >= 33 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO")) {
            PermissionCompat.requestPermission(preferenceActivity, "android.permission.READ_MEDIA_AUDIO", 736);
            return true;
        }
        if (PermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.READ_EXTERNAL_STORAGE")) {
            startRingtoneChooser(preferenceActivity);
            return true;
        }
        PermissionCompat.requestPermission(preferenceActivity, "android.permission.READ_EXTERNAL_STORAGE", 736);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.url(preferenceActivity, "https://sleep.urbandroid.org/docs//alarms/alarm_settings.html#per-alarm");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$6(PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.USE_FULL_SCREEN_INTENT") != 0) {
            this.requestFullscreenPermissionLauncherWhenSwitched.launch("android.permission.USE_FULL_SCREEN_INTENT");
            return true;
        }
        askOverlay(preferenceActivity, R.string.no_permission);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$7(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) SmartSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$8(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) SnoozeSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$9(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) GentleSettingsActivity.class));
        return true;
    }

    public static void onboardFullscreen(Activity activity, String str) {
        Settings settings = new Settings(activity);
        if (Build.VERSION.SDK_INT < 30 || android.provider.Settings.canDrawOverlays(activity) || settings.isShowCaseShown(str)) {
            return;
        }
        new MaterialAlertDialogBuilder(activity).setTitle(R.string.alarm_fullscreen).setMessage(R.string.overlay_permission).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(activity, settings, str, 1)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) new AlarmSettingsActivity$$ExternalSyntheticLambda1(settings, str, 0)).show();
    }

    private void startRingtoneChooser(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_integration", true);
        intent.putExtra("extra_alert_title", SharedApplicationContext.getSettings().getDefaultRingtoneName(null));
        intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getDefaultRingtone());
        if (Environment.getAPILevel() >= 11) {
            intent.putExtra("extra_playlists", new ArrayList(SharedApplicationContext.getSettings().getDefaultPlaylists()));
        }
        activity.startActivityForResult(intent, 123);
    }

    private void updateRingtonePrefIcon(Preference preference) {
        String defaultRingtone = new Settings(this).getDefaultRingtone();
        if ("silent".equals(defaultRingtone)) {
            preference.setIcon(R.drawable.ic_sound_silent);
            return;
        }
        if ("android.resource://com.urbandroid.sleep/raw/phone".equals(defaultRingtone)) {
            preference.setIcon(R.drawable.ic_sound_all);
            return;
        }
        if (MultipleMediaUriUtil.isMultipleUri(defaultRingtone)) {
            preference.setSummary(getString(R.string.alert_playlist_size, Integer.valueOf(MultipleMediaUriUtil.size(defaultRingtone))));
            preference.setIcon(R.drawable.ic_sound_playlist);
            return;
        }
        preference.setIcon(InternalRingtones.getRingtoneIcon(defaultRingtone));
        InternalRingtones.InternalRingtone internalRingtone = InternalRingtones.getInternalRingtone(defaultRingtone);
        if (internalRingtone != null) {
            preference.setIcon(internalRingtone.getDrawableRes());
            return;
        }
        if (defaultRingtone != null && (defaultRingtone.startsWith("http://") || defaultRingtone.startsWith("https://"))) {
            preference.setIcon(R.drawable.ic_lullaby_radio);
        } else if (ISpotifyPlayer.INSTANCE.isSpotifyUri(defaultRingtone)) {
            preference.setIcon(R.drawable.ic_lullaby_spotify_color);
        } else {
            preference.setIcon(R.drawable.ic_sound_tone_color);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/alarm_settings.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_alarm;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_alarm;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            Settings settings = SharedApplicationContext.getSettings();
            String stringExtra = intent.getStringExtra("extra_alert_title");
            settings.setDefaultRingtoneName(stringExtra);
            String stringExtra2 = intent.getStringExtra("extra_alert_uri");
            if (stringExtra2 != null && !stringExtra2.equals(settings.getDefaultRingtone()) && settings.isAlarmPlaylistOrdered()) {
                settings.setPlaylistPosition(0L);
            }
            settings.setDefaultRingtone(stringExtra2);
            Preference preferenceFindPreference = findPreference("ringtone_pref_single");
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(stringExtra);
            sbM.append(getOrderedPlayListSuffix(SharedApplicationContext.getSettings().getDefaultRingtoneUri()));
            preferenceFindPreference.setSummary(sbM.toString());
            updateRingtonePrefIcon(preferenceFindPreference);
            if (Environment.getAPILevel() >= 11) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_playlists");
                settings.setDefaultPlaylists(stringArrayListExtra != null ? new HashSet(stringArrayListExtra) : new HashSet());
            }
        }
        if (i == 123 && i2 == 0) {
            refresh();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Settings settings = new Settings(this);
        if (!getIntent().hasExtra("extra_highlight_key")) {
            if (!settings.isAlarmFullscreen()) {
                onboardFullscreen(this, "setting_fullscreen_onboard");
            } else if (ContextCompat.checkSelfPermission(this, "android.permission.USE_FULL_SCREEN_INTENT") != 0) {
                this.requestFullscreenPermissionLauncher.launch("android.permission.USE_FULL_SCREEN_INTENT");
            } else {
                askOverlay(this, AlarmSettingsActivity.class);
            }
        }
        DefaultRingtoneResolveService.start(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 736) {
            return;
        }
        startRingtoneChooser(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        String string;
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        ListPreference listPreference = (ListPreference) preferenceScreen.findPreference("alarm_kill_time");
        if (listPreference != null) {
            try {
                SimpleSettingsActivity.fillSummaryWithValue(listPreference, String.valueOf(SharedApplicationContext.getSettings().getAlarmTimeout()));
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        Preference preferenceFindPreference = preferenceScreen.findPreference("settings_category_captcha");
        Object[] objArr = 0;
        if (preferenceFindPreference != null) {
            int defaultCaptchaId = SharedApplicationContext.getSettings().getDefaultCaptchaId();
            preferenceFindPreference.setSummary(CaptchaPreferenceUtil.getSummary(this, defaultCaptchaId, R.string.captcha_preference_summary));
            preferenceFindPreference.setIcon(CaptchaDrawableUtil.getDrawable(this, defaultCaptchaId));
            preferenceFindPreference.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceFindPreference, objArr == true ? 1 : 0));
        }
        Settings settings = new Settings(this);
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_category_time_to_bed");
        int i = 1;
        if (preferenceFindPreference2 != null) {
            if (SharedApplicationContext.getSettings().getTimeToBed(null) == -1) {
                string = getString(R.string.disabled);
            } else {
                string = DateUtil.formatHoursMinutes(this, SharedApplicationContext.getSettings().getTimeToBed(null)) + " " + getString(R.string.before).toLowerCase();
            }
            preferenceFindPreference2.setSummary(string);
            preferenceFindPreference2.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, i));
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("ringtone_pref_single");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i));
            String defaultRingtoneName = SharedApplicationContext.getSettings().getDefaultRingtoneName(null);
            if (defaultRingtoneName == null || defaultRingtoneName.trim().isEmpty()) {
                defaultRingtoneName = getString(R.string.device_default);
            }
            if (defaultRingtoneName != null) {
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(defaultRingtoneName);
                sbM.append(getOrderedPlayListSuffix(SharedApplicationContext.getSettings().getDefaultRingtoneUri()));
                preferenceFindPreference3.setSummary(sbM.toString());
            }
            updateRingtonePrefIcon(preferenceFindPreference3);
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("alarm_default_settings_expl");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 3));
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("alarm_fullscreen");
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i));
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("settings_category_smart");
        if (preferenceFindPreference6 != null) {
            fillSummary(preferenceFindPreference6, R.string.settings_category_smart_summary, -1, R.array.non_deep_sleep_window_values, R.array.non_deep_sleep_window_entries, "" + settings.getSmartWakeupMinutes());
            preferenceFindPreference6.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 4));
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("settings_category_snooze");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, i));
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("settings_category_gentle");
        if (preferenceFindPreference8 != null) {
            fillSummary(preferenceFindPreference8, R.string.alarm_increasing_volume_duration_summary, R.string.alarm_increasing_volume_title, R.array.alarm_increasing_volume_duration_values, R.array.alarm_increasing_volume_duration_entries, "" + settings.getGradualVolumeIncreaseDuration());
            preferenceFindPreference8.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 2));
        }
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("settings_category_snooze");
        if (preferenceFindPreference9 != null) {
            fillSummary(preferenceFindPreference9, -1, -1, R.array.snooze_duration_values, R.array.snooze_duration_entries, "" + new Settings(preferenceActivity).getSnoozeDurationValue());
        }
        Preference preferenceFindPreference10 = preferenceScreen.findPreference("screenlight");
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setSummary(preferenceActivity.getString(R.string.use, preferenceActivity.getString(R.string.screenlight).toLowerCase()));
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_alarm_screen", "settings_category_dangerous");
    }

    public static void askOverlay(Activity activity, Class cls) {
        askOverlay(activity, 29, R.string.alarm_fullscreen, R.string.overlay_permission, null, cls);
    }

    public static void askOverlay(Activity activity, int i) {
        askOverlay(activity, 29, i, R.string.overlay_permission);
    }

    public static void askOverlay(Activity activity, int i, int i2, int i3) {
        askOverlay(activity, i, i2, i3, null, null);
    }

    public static void askOverlay(Activity activity, int i, int i2, int i3, String str) {
        askOverlay(activity, i, i2, i3, str, null);
    }

    public static void askOverlay(Activity activity) {
        askOverlay(activity, 29, R.string.alarm_fullscreen, R.string.overlay_permission);
    }
}
