package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.facebook.ads.AdError;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.async.AbstractProgressAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.nearby.core.MyLogger;
import com.urbandroid.sleep.nearby.core.ServiceNamesKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class PairSettingsActivity extends SimpleSettingsActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkGooglePlayServices(Activity activity) {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity);
        if (iIsGooglePlayServicesAvailable == 0) {
            return true;
        }
        GoogleApiAvailability.getInstance().getErrorDialog(activity, iIsGooglePlayServicesAvailable, AdError.AD_PRESENTATION_ERROR_CODE).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkLocationPermission(Activity activity) {
        return !SleepPermissionCompat.INSTANCE.requestLocationPermissionForBt(activity, 376, true);
    }

    private void configurePairTrackingEnabledPreference(PreferenceActivity preferenceActivity) {
        preferenceActivity.getPreferenceScreen().findPreference("pair_tracking_enabled").setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, preferenceActivity, 9));
    }

    private void configurePairTrackingTokenPreference(final PreferenceActivity preferenceActivity) {
        Preference preferenceFindPreference = preferenceActivity.getPreferenceScreen().findPreference("pair_tracking_token");
        final Settings settings = new Settings(preferenceActivity);
        updatePairTrackingTokenPreferenceText(preferenceActivity, preferenceFindPreference, settings.getPairTrackingToken());
        preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PairSettingsActivity.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(final Preference preference) {
                if (settings.getPairTrackingToken() == null && PairSettingsActivity.this.checkLocationPermission(preferenceActivity) && PairSettingsActivity.this.checkGooglePlayServices(preferenceActivity)) {
                    new AbstractProgressAsyncTask<Void, Void, String>(new ProgressContext(preferenceActivity, true), preferenceActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.PairSettingsActivity.2.1
                        private final AtomicLong timeoutMillis = new AtomicLong(120000);

                        @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                        public String getMessage() {
                            return preferenceActivity.getString(R.string.search_may_take_a_while);
                        }

                        @Override // android.os.AsyncTask
                        public void onCancelled() {
                            super.onCancelled();
                            this.timeoutMillis.set(0L);
                            Logger.logInfo("PairTracking: lookup cancelled");
                        }

                        @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
                        public void onPostExecute(String str) {
                            super.onPostExecute(str);
                            zza$$ExternalSyntheticOutline0.m("PairTracking: lookup ", str);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (str == null) {
                                Toast.makeText(preferenceActivity, R.string.general_unspecified_error, 0).show();
                                return;
                            }
                            settings.setPairTrackingToken(str);
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            PairSettingsActivity.this.updatePairTrackingTokenPreferenceText(preferenceActivity, preference, settings.getPairTrackingToken());
                        }

                        @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                        public String performInBackground() {
                            try {
                                String strRendezvous = ServiceNamesKt.rendezvous(preferenceActivity, new MyLogger(), this.timeoutMillis);
                                if (strRendezvous != null) {
                                    if (!strRendezvous.isEmpty()) {
                                        return strRendezvous;
                                    }
                                }
                                return null;
                            } catch (InterruptedException unused) {
                                Logger.logInfo("PairTracking: lookup interrupted");
                                return null;
                            } catch (RuntimeException e) {
                                Logger.logSevere("PairTracking: lookup failed", e);
                                return null;
                            }
                        }
                    }.execute(new Void[0]);
                    return true;
                }
                settings.setPairTrackingToken(null);
                PairSettingsActivity.this.updatePairTrackingTokenPreferenceText(preferenceActivity, preference, settings.getPairTrackingToken());
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$configurePairTrackingEnabledPreference$1(PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            return checkLocationPermission(preferenceActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/pair_tracking.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePairTrackingTokenPreferenceText(Context context, Preference preference, String str) {
        if (str == null) {
            preference.setTitle(context.getResources().getString(R.string.find_partner));
            preference.setSummary("");
        } else {
            preference.setTitle(context.getResources().getString(R.string.paired_successfully));
            preference.setSummary(str);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/pair_tracking.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_pair;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.pair_tracking;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 376) {
            return;
        }
        if (iArr[0] != 0) {
            ViewIntent.getPermissionDenyDialogBuilder(this, SleepPermissionCompat.INSTANCE.getRequiredLocationPermissionForBluetoothLe(), R.string.pair_tracking).show();
            return;
        }
        SharedApplicationContext.getSettings().setPairTracking(true);
        Preference preferenceFindPreference = findPreference("pair_tracking_enabled");
        if (preferenceFindPreference != null) {
            ((CheckBoxPreference) preferenceFindPreference).setChecked(true);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        new Settings(preferenceActivity);
        configurePairTrackingEnabledPreference(preferenceActivity);
        configurePairTrackingTokenPreference(preferenceActivity);
        Preference preferenceFindPreference = findPreference("pair_expl");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 5));
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("pair_tracking_read_more");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PairSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(PairSettingsActivity.this, "https://sleep.urbandroid.org/docs//sleep/pair_tracking.html");
                    return true;
                }
            });
        }
    }
}
