package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.ActivityCompat;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.appbar.AppBarLayout;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.StartTrackActivity$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AddonActivity;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.dialog.DocItemDialogFragment;
import com.urbandroid.sleep.gui.toolbar.OffsetListener;
import com.urbandroid.sleep.gui.toolbar.OffsetObserver;
import com.urbandroid.sleep.service.SettingKeys;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleSettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener, SettingKeys, IHasProgressContext, OffsetObserver {
    protected Handler handler;
    ProgressContext progressContextInstance = null;
    private boolean toolbarExpanded = true;
    private int listViewVisibleCount = 6;
    private Runnable updateShowCaseManagerRunnable = null;
    private int verticalOffset = -1;

    private void addPreferenceClickListener(String... strArr) {
        for (String str : strArr) {
            Preference preferenceFindPreference = findPreference(str);
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setOnPreferenceClickListener(this);
            }
        }
    }

    public static final Intent createHighlightIntent(Context context, Class cls, String str) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.putExtra("extra_highlight_key", str);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        return intent;
    }

    public static void fillSummaryWithValue(ListPreference listPreference, Object obj) {
        listPreference.setSummary(formatValue(listPreference.getEntries()[listPreference.findIndexOfValue((String) obj)]));
    }

    public static String formatValue(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().replaceAll("\\%", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$0(View view) {
        SearchActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$1(String str) {
        highlightPref(getPreferenceScreen(), str, getListView(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference) {
        DocItemDialogFragment.newInstance("settings", getString(getClass() == SimpleSettingsActivity.class ? R.string.app_name_long : getTitleResource()), null).show(getSupportFragmentManager(), "help");
        return true;
    }

    private void runExitTransition() {
    }

    public static final void startHighlight(Context context, Class cls, String str) {
        context.startActivity(createHighlightIntent(context, cls, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShowCaseManager(SettingsShowCaseManager settingsShowCaseManager, ListView listView) {
        View viewFindViewById;
        for (int i = 0; i < this.listViewVisibleCount; i++) {
            View childAt = listView.getChildAt(i);
            if (childAt != null && (viewFindViewById = childAt.findViewById(android.R.id.title)) != null && (viewFindViewById instanceof TextView)) {
                TextView textView = (TextView) viewFindViewById;
                if (textView.getText() != null) {
                    settingsShowCaseManager.update(childAt.findViewById(android.R.id.icon), textView.getText().toString());
                }
            }
        }
    }

    public void addSensitivitySummary(Preference preference) {
        if (preference != null) {
            getResources().getStringArray(R.array.non_deep_sleep_sensitivity_entries);
            ((SeekBarPreference) preference).setMajorInterval(0);
        }
    }

    public boolean dispatchCategory(Class cls, Preference preference) {
        startActivity(new Intent(this, (Class<?>) cls));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        r1 = r2.getContext().getResources().getStringArray(r6)[r5];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fillSummary(Preference preference, int i, int i2, int i3, int i4, String str) {
        String[] stringArray;
        String str2;
        if (preference == null || (stringArray = preference.getContext().getResources().getStringArray(i3)) == null) {
            return;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= stringArray.length) {
                break;
            }
            if (stringArray[i5].equals(str)) {
                try {
                    break;
                } catch (Exception e) {
                    Logger.logSevere(e);
                    str2 = null;
                }
            } else {
                i5++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (i2 > 0) {
                sb.append(preference.getContext().getString(i2));
                sb.append(": ");
            }
            sb.append(str2);
        }
        if (i > 0) {
            if (str2 != null) {
                sb.append("\n\n");
            }
            sb.append(preference.getContext().getString(i));
        }
        preference.setSummary(sb.toString());
    }

    public String getBaseDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs/";
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_settings;
    }

    public String getDocumentationUrl() {
        return getBaseDocumentationUrl();
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return getSettings();
    }

    /* JADX INFO: renamed from: getProgressContext */
    public ProgressContext getProgressContextInstance() {
        return this.progressContextInstance;
    }

    public int getSettings() {
        return SharedApplicationContext.getSettings().isAlarmOnly() ? R.xml.settings_simple_alarm_only : R.xml.settings_simple;
    }

    public int getTitleResource() {
        return R.string.settings;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public int getVerticalOffset() {
        return this.verticalOffset;
    }

    public void highlightPref(final PreferenceScreen preferenceScreen, final String str, final ListView listView, final int i) {
        Preference preferenceFindPreference;
        if (preferenceScreen == null || (preferenceFindPreference = preferenceScreen.findPreference(str)) == null || i >= 10) {
            return;
        }
        listView.invalidate();
        if (preferenceFindPreference.getTitle() != null) {
            String string = preferenceFindPreference.getTitle().toString();
            for (int i2 = 0; i2 < listView.getChildCount() - 2; i2++) {
                View childAt = listView.getChildAt(i2);
                if (childAt != null) {
                    View viewFindViewById = childAt.findViewById(android.R.id.title);
                    final ViewGroup viewGroup = (ViewGroup) childAt.findViewById(R.id.highlight_parent);
                    StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Highlight '", string, "' ? '");
                    sbM5m.append((Object) ((TextView) viewFindViewById).getText());
                    sbM5m.append("'");
                    Logger.logSevere(sbM5m.toString());
                    if (viewFindViewById != null && (viewFindViewById instanceof TextView) && !IntrospectionHelper.AppFunctionSchemaDefinitionAnnotation.PROPERTY_CATEGORY.equals(viewFindViewById.getTag())) {
                        TextView textView = (TextView) viewFindViewById;
                        if (textView.getText() != null && string.equals(textView.getText().toString())) {
                            Logger.logSevere("Highlight YES");
                            textView.setTextColor(getResources().getColor(R.color.tint));
                            if (viewGroup == null) {
                                try {
                                    viewGroup = (ViewGroup) viewFindViewById.getParent().getParent();
                                } catch (Exception unused) {
                                    return;
                                }
                            }
                            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(32, 0);
                            valueAnimatorOfInt.setDuration(300L);
                            valueAnimatorOfInt.setRepeatCount(14);
                            valueAnimatorOfInt.setRepeatMode(2);
                            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity.2
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                    int i3 = ColorUtil.i(SimpleSettingsActivity.this, R.color.pressed);
                                    viewGroup.setBackgroundColor(Color.argb(iIntValue, Color.red(i3), Color.green(i3), Color.blue(i3)));
                                    viewGroup.invalidate();
                                }
                            });
                            valueAnimatorOfInt.start();
                            viewFindViewById.startAnimation(AnimationUtils.loadAnimation(preferenceScreen.getContext(), R.anim.click_small));
                            return;
                        }
                    }
                }
            }
            int lastVisiblePosition = listView.getLastVisiblePosition();
            Logger.logSevere("Highlight scroll '" + listView.getFirstVisiblePosition() + " " + listView.getLastVisiblePosition() + "'");
            listView.smoothScrollByOffset(listView.getLastVisiblePosition() - 2);
            if (lastVisiblePosition > i) {
                this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SimpleSettingsActivity.this.highlightPref(preferenceScreen, str, listView, i + 1);
                    }
                }, 200L);
            }
        }
    }

    public boolean isHighlightMode() {
        return getIntent() != null && getIntent().hasExtra("extra_highlight_key");
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        runExitTransition();
        ActivityCompat.finishAfterTransition(this);
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new Handler();
        this.progressContextInstance = new ProgressContext(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        ToolbarUtil.apply(this);
        TintUtil.tintStatusBar(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getTitleResource());
            if (findViewById(R.id.search_button) != null) {
                findViewById(R.id.search_button).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 6));
            }
        }
        addPreferenceClickListener("settings_category_smartlight", "settings_category_smartwatch", "settings_category_addons", "settings_category_time_to_bed", "settings_category_lucid", "settings_category_lullaby", "settings_siren_category", "settings_category_snooze", "settings_category_alarm_avoid", "settings_category_alarm", "settings_category_track", "settings_category_social", "settings_category_noise", "settings_category_misc", "settings_category_captcha", "settings_category_jetlag", "settings_category_backup", "settings_category_services", "settings_category_privacy", "settings_category_stats", "settings_category_morning_screen");
        setupValues();
        if (getWindow() != null && getWindow().getSharedElementEnterTransition() != null && getContentLayout() != R.layout.activity_search_settings) {
            getWindow().getSharedElementEnterTransition().setDuration(150L);
            getWindow().setSharedElementReturnTransition(null);
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animationLoadAnimation.setStartOffset(230L);
        View viewFindViewById = findViewById(R.id.search_button);
        if (viewFindViewById != null) {
            viewFindViewById.startAnimation(animationLoadAnimation);
            viewFindViewById.setVisibility(0);
            viewFindViewById.startAnimation(animationLoadAnimation);
            viewFindViewById.setVisibility(0);
        }
        if (getIntent().hasExtra("extra_highlight_key")) {
            this.handler.postDelayed(new StartTrackActivity$$ExternalSyntheticLambda0(this, getIntent().getStringExtra("extra_highlight_key"), 2), 1000L);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            runExitTransition();
            ActivityCompat.finishAfterTransition(this);
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return true;
        }
        DocItemDialogFragment.newInstance("settings", getString(getClass() == SimpleSettingsActivity.class ? R.string.app_name_long : getTitleResource()), null).show(getSupportFragmentManager(), "help");
        return true;
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        Logger.logInfo("SettingsActivity: property " + preference.getKey() + " changed to " + obj);
        if (preference instanceof ListPreference) {
            fillSummaryWithValue((ListPreference) preference, obj);
        }
        if (!"target_sleep_time_notify_before".equals(preference.getKey())) {
            return true;
        }
        Logger.logDebug("Time to bed notify global setting has changed.");
        Alarms.setNextAlert(SharedApplicationContext.getInstance().getContext());
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        if (preference == null) {
            return false;
        }
        String key = preference.getKey();
        if (key.equals("settings_category_time_to_bed")) {
            return dispatchCategory(BedtimeSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_lucid")) {
            return dispatchCategory(LucidSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_lullaby")) {
            return dispatchCategory(LullabySettingsActivity.class, preference);
        }
        if (key.equals("settings_category_alarm")) {
            return dispatchCategory(AlarmSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_track")) {
            return dispatchCategory(TrackSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_social")) {
            return dispatchCategory(SocialSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_services")) {
            return dispatchCategory(ServicesSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_privacy")) {
            return dispatchCategory(PrivacySettingsActivity.class, preference);
        }
        if (key.equals("settings_category_stats")) {
            return dispatchCategory(StatsSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_morning_screen")) {
            return dispatchCategory(MorningScreenSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_noise")) {
            return dispatchCategory(NoiseSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_misc")) {
            return dispatchCategory(MiscSettingsActivity.class, preference);
        }
        if (key.equals("settings_siren_category")) {
            return dispatchCategory(BackupAlarmSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_snooze")) {
            return dispatchCategory(SnoozeSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_alarm_avoid")) {
            return dispatchCategory(CaptchaCheatingSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_wake_up_check")) {
            return dispatchCategory(CaptchaCheatingSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_captcha")) {
            return dispatchCategory(CaptchaSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_addons")) {
            return dispatchCategory(AddonActivity.class, preference);
        }
        if (key.equals("settings_category_smartlight")) {
            return dispatchCategory(SmartLightSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_smartwatch")) {
            return dispatchCategory(SmartwatchSettingsActivity.class, preference);
        }
        if (key.equals("settings_category_jetlag")) {
            return dispatchCategory(JetLagSettingsActivity.class, preference);
        }
        if (!key.equals("settings_category_backup")) {
            return false;
        }
        try {
            Intent launchIntentForPackage = preference.getContext().getPackageManager().getLaunchIntentForPackage("com.urbandroid.sleep.addon.port");
            if (launchIntentForPackage == null) {
                ViewIntent.market(this, "com.urbandroid.sleep.addon.port");
                return true;
            }
            launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
            launchIntentForPackage.putExtra("TS", TrialFilter.getCloudTimestamp(preference.getContext()));
            startActivity(launchIntentForPackage);
            return false;
        } catch (Exception unused) {
            ViewIntent.market(this, "com.urbandroid.sleep.addon.port");
            return false;
        }
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getWindow().setEnterTransition(null);
        refresh();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        final ListView listView = getListView();
        if (listView != null) {
            listView.setNestedScrollingEnabled(true);
            if (Experiments.getInstance().isShowCaseInSettingsExperiment()) {
                final SettingsShowCaseManager settingsShowCaseManager = new SettingsShowCaseManager(this);
                Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SimpleSettingsActivity.this.updateShowCaseManager(settingsShowCaseManager, listView);
                    }
                };
                this.updateShowCaseManagerRunnable = runnable;
                this.handler.postDelayed(runnable, 1000L);
            }
        }
        View viewFindViewById = findViewById(R.id.search_button);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        if (appBarLayout == null || viewFindViewById == null) {
            return;
        }
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new OffsetListener(this, this, viewFindViewById));
    }

    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        Preference preferenceFindPreference = findPreference("settings_expl");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 6));
        }
        SeekBarPreference seekBarPreference = (SeekBarPreference) preferenceScreen.findPreference("target_sleep_time_minutes");
        if (seekBarPreference != null) {
            seekBarPreference.setCurrentValue(settings.getIdealSleepMinutes());
            seekBarPreference.setMajorInterval(30);
            seekBarPreference.setFormatter(new SeekBarPreference.IFormatter() { // from class: com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity.4
                @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
                public String format(int i) {
                    return DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(i));
                }
            });
            seekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity.5
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    Logger.logDebug("Ideal time settings changed.");
                    Alarms.setNextAlert(preferenceActivity);
                    settings.setIdealSleepLegacy(((Integer) obj).intValue() / 60.0f);
                    return true;
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_category_social");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setSummary(SharedApplicationContext.getInstance().getShareService().getDesc(preferenceActivity));
        }
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setExpanded(boolean z) {
        this.toolbarExpanded = z;
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setVerticalOffset(int i) {
        this.verticalOffset = i;
    }

    public void setupValues() {
        if (getPreferenceScreen() == null) {
            return;
        }
        Iterator<Map.Entry<String, ?>> it = getPreferenceScreen().getSharedPreferences().getAll().entrySet().iterator();
        while (it.hasNext()) {
            Preference preferenceFindPreference = findPreference(it.next().getKey());
            if (preferenceFindPreference != null && (preferenceFindPreference instanceof ListPreference)) {
                ListPreference listPreference = (ListPreference) preferenceFindPreference;
                try {
                    if (listPreference.getSummary() == null || listPreference.getSummary().length() <= 0) {
                        preferenceFindPreference.setSummary(formatValue(listPreference.getEntry()));
                    } else {
                        preferenceFindPreference.setSummary(formatValue(listPreference.getEntry()) + "\n\n" + ((Object) listPreference.getSummary()));
                    }
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                preferenceFindPreference.setOnPreferenceChangeListener(this);
            }
        }
    }

    public void showDocumentation() {
        ViewIntent.urlCustomTab(this, getDocumentationUrl());
    }

    public void refresh() {
        refresh(this, isHighlightMode());
    }

    public void highlightPref(String str) {
        highlightPref(getPreferenceScreen(), str, getListView(), 0);
    }
}
