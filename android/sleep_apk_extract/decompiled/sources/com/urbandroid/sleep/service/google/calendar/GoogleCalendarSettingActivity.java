package com.urbandroid.sleep.service.google.calendar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepUtils;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity$$ExternalSyntheticLambda7;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.google.calendar.alarm.ProcessedCalendarEventMap;
import com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.health.HealthManualSynchronizationAction;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u0003:\u00012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0012\u0010.\u001a\u00020/X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarSettingActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "calendarSynchronization", "Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarSynchronization;", "accountName", "alarmAdvancePreference", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", "getPreferenceResource", "", "getContentLayout", "onCreatePreference", "", "paramBundle", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onDestroy", "calendarProvider", "Lcom/urbandroid/sleep/service/google/calendar/api/provider/CachedCalendarProviderApi;", "refresh", "disableAdvanceAlarm", "enableAdvanceAlarm", "showCaseSync", "setTitle", "setEnableOptions", "enable", "", "synchronizationFromDate", "Ljava/util/Calendar;", "getSynchronizationFromDate", "()Ljava/util/Calendar;", "prepareCalendarSynchronization", "initSynchronizeButton", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarSettingActivity extends SimpleSettingsActivity implements CoroutineScope, FeatureLogger {
    private String accountName;
    private SeekBarPreference alarmAdvancePreference;
    private CachedCalendarProviderApi calendarProvider;
    private GoogleCalendarSynchronization calendarSynchronization;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "calendar:setting-screen";
    private final AtomicBoolean isRunning = new AtomicBoolean(false);

    private final void disableAdvanceAlarm() {
        SeekBarPreference seekBarPreference = this.alarmAdvancePreference;
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(false);
        }
    }

    private final void enableAdvanceAlarm() {
        SeekBarPreference seekBarPreference = this.alarmAdvancePreference;
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(true);
        }
    }

    private final Calendar getSynchronizationFromDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -1);
        return calendar;
    }

    private final void initSynchronizeButton(String accountName) {
        HealthManualSynchronizationAction isRunningHolder;
        HealthManualSynchronizationAction healthManualSynchronizationActionSynchronizationFromDate;
        HealthManualSynchronizationAction healthManualSynchronizationActionInit = new GoogleCalendarSettingActivity$initSynchronizeButton$action$1(this, accountName, HealthServiceProvider.GoogleCalendar.INSTANCE).init();
        if (healthManualSynchronizationActionInit == null || (isRunningHolder = healthManualSynchronizationActionInit.setIsRunningHolder(this.isRunning)) == null || (healthManualSynchronizationActionSynchronizationFromDate = isRunningHolder.synchronizationFromDate(getSynchronizationFromDate())) == null) {
            return;
        }
        healthManualSynchronizationActionSynchronizationFromDate.show(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleCalendarSynchronization prepareCalendarSynchronization(String accountName) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        GoogleCalendarApi googleCalendarApi = new GoogleCalendarApi(applicationContext2, accountName);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        sleepRecordRepository.getClass();
        GoogleCalendarSynchronization googleCalendarSynchronization = new GoogleCalendarSynchronization(applicationContext, googleCalendarApi, sleepRecordRepository);
        this.calendarSynchronization = googleCalendarSynchronization;
        return googleCalendarSynchronization;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1$0(GoogleCalendarSettingActivity googleCalendarSettingActivity, CheckBoxPreference checkBoxPreference, Preference preference, Object obj) {
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(googleCalendarSettingActivity, null, null, new GoogleCalendarSettingActivity$refresh$2$1$1(googleCalendarSettingActivity, checkBoxPreference, BuildersKt__Builders_commonKt.launch$default(googleCalendarSettingActivity, null, null, new GoogleCalendarSettingActivity$refresh$2$1$progressJob$1(new Ref$IntRef(), checkBoxPreference, googleCalendarSettingActivity, null), 3, null), null), 3, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(GoogleCalendarSettingActivity googleCalendarSettingActivity, CheckBoxPreference checkBoxPreference, Preference preference, Object obj) {
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(googleCalendarSettingActivity, null, null, new GoogleCalendarSettingActivity$refresh$3$1(googleCalendarSettingActivity, checkBoxPreference, null), 3, null);
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(googleCalendarSettingActivity, null, null, new GoogleCalendarSettingActivity$refresh$3$2(googleCalendarSettingActivity, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$3$1(Preference preference, Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$4(GoogleCalendarSettingActivity googleCalendarSettingActivity, String str, CheckBoxPreference checkBoxPreference, Preference preference, Object obj) {
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            googleCalendarSettingActivity.enableAdvanceAlarm();
            BuildersKt__Builders_commonKt.launch$default(googleCalendarSettingActivity, null, null, new GoogleCalendarSettingActivity$refresh$5$1(googleCalendarSettingActivity, str, checkBoxPreference, null), 3, null);
            return true;
        }
        googleCalendarSettingActivity.disableAdvanceAlarm();
        ProcessedCalendarEventMap.reset(googleCalendarSettingActivity.getApplicationContext(), ProcessedCalendarEventMap.Type.EVENT, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnableOptions(boolean enable) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("google_calendar_backup");
        if (checkBoxPreference != null) {
            checkBoxPreference.setEnabled(enable);
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("google_calendar_event");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setEnabled(enable);
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("google_calendar_holiday");
        if (checkBoxPreference3 != null) {
            checkBoxPreference3.setEnabled(enable);
        }
        SeekBarPreference seekBarPreference = this.alarmAdvancePreference;
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(enable);
        }
    }

    private final void setTitle() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        boolean z = getResources().getConfiguration().orientation == 2;
        supportActionBar.setTitle(getResources().getString(R.string.google_calendar) + (z ? FileInsert$$ExternalSyntheticOutline0.m(" - ", this.accountName) : ""));
    }

    private final void showCaseSync() {
        new SyncShowcaseViewAsyncTask(this, SyncShowcaseViewAsyncTask.IntegrationApp.Google_Calendar, getSynchronizationFromDate().getTimeInMillis()).execute(new Void[0]);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_google_calendar_settings;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return R.xml.settings_google_calendar;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle paramBundle) {
        ToolbarUtil.apply(this);
        ToolbarUtil.fixTitle(this, 20);
        setTitle();
        if (paramBundle != null && this.accountName == null) {
            this.accountName = paramBundle.getString("google_calendar_account");
        }
        if (this.accountName == null) {
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            this.accountName = ContextExtKt.getSettings(applicationContext).getGoogleCalendarAccount();
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return false;
        }
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//services/google_calendar.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        outState.putString("google_calendar_account", this.accountName);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh() {
        Settings settings = SharedApplicationContext.getSettings();
        String googleCalendarAccount = settings.getGoogleCalendarAccount();
        if (googleCalendarAccount == null) {
            return;
        }
        this.accountName = googleCalendarAccount;
        String strM = FileInsert$$ExternalSyntheticOutline0.m("Google Calendar: account name: ", SleepUtils.md5(googleCalendarAccount));
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        setTitle();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        this.calendarProvider = new CachedCalendarProviderApi(applicationContext, new CalendarProviderApi(this, googleCalendarAccount));
        Preference preferenceFindPreference = findPreference("google_calendar_account");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setTitle(googleCalendarAccount);
        }
        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("google_calendar_backup");
        if (checkBoxPreference != null) {
            final int i = 0;
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ GoogleCalendarSettingActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i2 = i;
                    CheckBoxPreference checkBoxPreference2 = checkBoxPreference;
                    GoogleCalendarSettingActivity googleCalendarSettingActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return GoogleCalendarSettingActivity.refresh$lambda$1$0(googleCalendarSettingActivity, checkBoxPreference2, preference, obj);
                        default:
                            return GoogleCalendarSettingActivity.refresh$lambda$2(googleCalendarSettingActivity, checkBoxPreference2, preference, obj);
                    }
                }
            });
        }
        final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("google_calendar_holiday");
        if (checkBoxPreference2 != null) {
            final int i2 = 1;
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ GoogleCalendarSettingActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i22 = i2;
                    CheckBoxPreference checkBoxPreference22 = checkBoxPreference2;
                    GoogleCalendarSettingActivity googleCalendarSettingActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return GoogleCalendarSettingActivity.refresh$lambda$1$0(googleCalendarSettingActivity, checkBoxPreference22, preference, obj);
                        default:
                            return GoogleCalendarSettingActivity.refresh$lambda$2(googleCalendarSettingActivity, checkBoxPreference22, preference, obj);
                    }
                }
            });
        }
        if (this.alarmAdvancePreference == null) {
            this.alarmAdvancePreference = (SeekBarPreference) findPreference("google_calendar_alarm_advance");
        }
        SeekBarPreference seekBarPreference = this.alarmAdvancePreference;
        if (seekBarPreference != null) {
            seekBarPreference.setCurrentValue(settings.getGoogleCalendarAlarmAdvanceInMinutes());
            seekBarPreference.setMajorInterval(10);
            seekBarPreference.setFormatter(new GoogleCalendarSettingActivity$$ExternalSyntheticLambda2());
            seekBarPreference.setOnPreferenceChangeListener(new GoogleCalendarSettingActivity$$ExternalSyntheticLambda3());
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("google_calendar_event");
        if (checkBoxPreference3 != null) {
            if (!checkBoxPreference3.isChecked()) {
                disableAdvanceAlarm();
            }
            checkBoxPreference3.setOnPreferenceChangeListener(new TrackSettingsActivity$$ExternalSyntheticLambda7(this, googleCalendarAccount, checkBoxPreference3, 4));
        }
        initSynchronizeButton(googleCalendarAccount);
        showCaseSync();
    }
}
