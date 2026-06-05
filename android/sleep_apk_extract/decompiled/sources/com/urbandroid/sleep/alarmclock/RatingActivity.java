package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.fragment.dashboard.morning.MorningActivity;
import com.urbandroid.sleep.graph.GraphDetailsActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.SleepGraphImageGenerator;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.location.weather.NorwegianWeatherService;
import com.urbandroid.sleep.location.weather.OpenWeatherMapWeatherService;
import com.urbandroid.sleep.location.weather.Weather;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.ShareAfterDismissService;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.util.AirplaneModeUtil;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.TtsService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class RatingActivity extends BaseActivity {
    private MenuItem airplaneMenu;
    private EditText comment;
    private BroadcastReceiver connectivityReceiver;
    private SleepRecord originalRecord;
    private RatingBar ratingBar;
    private SleepRecord record;
    private MenuItem shareMenu;
    private boolean morningStatsHidden = false;
    private boolean largeScreen = true;
    private boolean didTurnOnWifi = false;
    private boolean loadWeatherAutomatically = false;
    private Weather weather = null;
    private Runnable showNextAlarmRunnable = new AlarmActivity$$ExternalSyntheticLambda0(this, 2);

    private static void afterRatingDone(Context context, SleepRecord sleepRecord) {
        if (sleepRecord != null && SharedApplicationContext.getSettings().isAutoSharingEnabled() && SharedApplicationContext.getInstance().getShareService().isConnected(context)) {
            ShareAfterDismissService.share(context, sleepRecord);
        }
    }

    private void buildActivityFromIntent(Intent intent, Bundle bundle, Boolean bool) {
        if (intent == null) {
            Logger.logSevere("RATING No intent cannot determine sleep record");
            finish();
            return;
        }
        findViewById(R.id.done).setOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 0));
        int i = getResources().getConfiguration().orientation;
        if (bundle != null && bundle.getParcelable("SleepRecord") != null) {
            log("RatingActivity: recovering record from savedInstance");
            this.originalRecord = (SleepRecord) bundle.getParcelable("SleepRecord");
        }
        if (this.originalRecord == null) {
            log("RatingActivity: recovering record from intent");
            this.originalRecord = (SleepRecord) intent.getParcelableExtra("SleepRecord");
        }
        int i2 = 1;
        if (this.originalRecord == null) {
            log("RatingActivity: recovering record from db");
            SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
            this.originalRecord = lastSleepRecord;
            if (lastSleepRecord != null && !lastSleepRecord.isFinished()) {
                this.originalRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord(1);
            }
        }
        if (this.originalRecord == null) {
            Logger.logSevere("RatingActivity: Record null finishing");
            finish();
            return;
        }
        SleepRecord sleepRecord = new SleepRecord(this.originalRecord, false);
        this.record = sleepRecord;
        if (!sleepRecord.isFinished()) {
            this.record.finish(new Date());
        }
        this.record.computeAll();
        this.record.computeNoiseLevel();
        log("RATING build from intent, record: " + this.record.getFrom());
        this.ratingBar = (RatingBar) findViewById(R.id.sleep_rating_bar);
        GraphView graphView = (GraphView) findViewById(R.id.graph);
        GraphView graphView2 = (GraphView) findViewById(R.id.hypnogram);
        GraphView graphView3 = (GraphView) findViewById(R.id.sensor_graph);
        findViewById(R.id.graph_detail).setVisibility(0);
        new SleepGraphInitializer(this).setDoGraphIntervals(false).init(graphView, !this.record.hasHypnogram() ? null : graphView, graphView2, graphView3, this.record);
        graphView.setEquidistantValues(this.record.getFilteredHistoryForCharting(), false);
        graphView.setVisibility(0);
        graphView2.setVisibility(this.record.hasNoiseData() ? 0 : 8);
        graphView3.setVisibility(this.record.hasSensorData() ? 0 : 8);
        graphView.setDrawYAxis(false);
        graphView.setDrawXAxis(true);
        fixSmallGraphView(graphView2);
        fixSmallGraphView(graphView3);
        RatingActivity$$ExternalSyntheticLambda0 ratingActivity$$ExternalSyntheticLambda0 = new RatingActivity$$ExternalSyntheticLambda0(this, i2);
        findViewById(R.id.graph_detail).setOnClickListener(ratingActivity$$ExternalSyntheticLambda0);
        findViewById(R.id.graph).setOnClickListener(ratingActivity$$ExternalSyntheticLambda0);
        final boolean z = SharedApplicationContext.getSettings().isHideMorningStats() && (bool == null || !bool.booleanValue());
        if (z) {
            this.morningStatsHidden = true;
            View viewFindViewById = findViewById(R.id.reveal);
            if (findViewById(R.id.major_measures) != null) {
                findViewById(R.id.major_measures).setVisibility(8);
            }
            if (findViewById(R.id.graph) != null) {
                findViewById(R.id.graph).setVisibility(8);
            }
            if (findViewById(R.id.hypnogram) != null) {
                findViewById(R.id.hypnogram).setVisibility(8);
            }
            if (findViewById(R.id.sensor_graph) != null) {
                findViewById(R.id.sensor_graph).setVisibility(8);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
                viewFindViewById.setOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 2));
            }
            if (findViewById(R.id.graph_detail) != null) {
                findViewById(R.id.graph_detail).setVisibility(8);
            }
        }
        this.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity$$ExternalSyntheticLambda3
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z2) {
                this.f$0.lambda$buildActivityFromIntent$3(z, ratingBar, f, z2);
            }
        });
        GraphDetailsActivity.loadPieForSameDayRecord(this, this.record, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) findViewById(R.id.major_measures));
        FrequentGeoService.start(getApplicationContext());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        ((TextInputLayout) findViewById(R.id.sleep_rating_comment_layout)).setEndIconOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 3));
        this.comment.setText(this.record.getComment());
        this.ratingBar.setRating(this.record.getRating());
        viewGroup.removeAllViews();
        EditActivity.createTags(this, viewGroup, this.comment);
        findViewById(R.id.weather).setVisibility(SharedApplicationContext.getSettings().isWeather() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cannotGetLocation(View view) {
        if (view.findViewById(R.id.weather_condition) != null) {
            ((TextView) view.findViewById(R.id.weather_condition)).setText(R.string.no_location);
            ((ImageView) view.findViewById(R.id.weather_icon)).setImageResource(R.drawable.ic_feature_offline);
        }
        if (findViewById(R.id.weather) != null) {
            findViewById(R.id.weather).setOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 5));
        }
    }

    private void fixSmallGraphView(GraphView graphView) {
        graphView.setCardColor(ContextCompat.getColor(this, R.color.bg_main));
        graphView.setDrawIntervals(false);
        graphView.setDoGradient(false);
        graphView.setDrawGradientBackground(false);
        graphView.setDrawXAxis(false);
        graphView.setDrawXAxisBars(false);
        graphView.setForceXAxisOffset(false);
    }

    private boolean hasWifi() {
        return ((WifiManager) getApplicationContext().getSystemService("wifi")).isWifiEnabled();
    }

    public static void initNextAlarmDismiss(final Activity activity, ViewGroup viewGroup) {
        final View viewFindViewById = viewGroup.findViewById(R.id.card_alarm);
        final View viewFindViewById2 = viewGroup.findViewById(R.id.alarm);
        DigitalClock digitalClock = (DigitalClock) viewGroup.findViewById(R.id.digitalClock);
        if (viewFindViewById == null || viewFindViewById2 == null || digitalClock == null) {
            Logger.logSevere("RatingActivity: Cannot show alarm card");
            return;
        }
        final Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(activity);
        final boolean z = Alarms.isSnoozing(activity) && Alarms.getSnoozeTime(activity) > System.currentTimeMillis();
        if (!z && (alarmCalculateNextAlert == null || !alarmCalculateNextAlert.enabled || alarmCalculateNextAlert.time >= System.currentTimeMillis() + 14400000)) {
            viewFindViewById.setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder("AlarmDismiss:Showing dismiss option for next alarm. Snoozed: ");
        sb.append(z);
        sb.append(" Alarm: ");
        sb.append(alarmCalculateNextAlert != null ? Alarm.toDebugString(alarmCalculateNextAlert) : "NULL");
        Logger.logInfo(sb.toString());
        viewFindViewById.setVisibility(0);
        long snoozeTime = z ? Alarms.getSnoozeTime(activity) : alarmCalculateNextAlert.time;
        digitalClock.setLive(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(snoozeTime);
        digitalClock.updateTime(calendar);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(activity, R.anim.fly_in);
        final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(activity, R.anim.scale_min);
        viewFindViewById.startAnimation(animationLoadAnimation);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RatingActivity.lambda$initNextAlarmDismiss$5(activity, z, viewFindViewById2, animationLoadAnimation2, alarmCalculateNextAlert, viewFindViewById, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$0(View view) {
        save();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$1(View view) {
        save();
        log("Opening GDA from RatingActivity");
        SleepDetailActivity.start(this, this.record, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$2(View view) {
        reveal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$3(boolean z, RatingBar ratingBar, float f, boolean z2) {
        if (z) {
            reveal();
        }
        Settings.setGoodTimeToRate(f >= 4.0f);
        save();
        GraphDetailsActivity.loadPieForSameDayRecord(this, this.record, SharedApplicationContext.getSettings().getDayCutOffHour(), (ViewGroup) findViewById(R.id.major_measures));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildActivityFromIntent$4(View view) {
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PROMPT", R.string.rating_comment_label);
            startActivityForResult(intent, 1234);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, getResources().getString(R.string.speech_recognizer_not_present), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cannotGetLocation$7(View view) {
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        if (!sleepPermissionCompat.isPermissionGranted(this, "android.permission.ACCESS_COARSE_LOCATION") && !sleepPermissionCompat.isPermissionGranted(this, "android.permission.ACCESS_FINE_LOCATION")) {
            Logger.logInfo("RatingActivity: Enabling WiFi no permission");
            sleepPermissionCompat.requestPermission(this, "android.permission.ACCESS_COARSE_LOCATION", 73319);
        } else if (Build.VERSION.SDK_INT >= 30) {
            try {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception unused) {
                Toast.makeText(this, R.string.general_unspecified_error, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initNextAlarmDismiss$5(Activity activity, boolean z, View view, Animation animation, Alarm alarm, View view2, View view3) {
        Alarm alarm2;
        Logger.logInfo("AlarmDismiss: called skipping next ");
        if (activity instanceof RatingActivity) {
            ((RatingActivity) activity).save();
        }
        if (z) {
            int snoozeAlarmId = Alarms.getSnoozeAlarmId(activity);
            if (snoozeAlarmId != -1 && (alarm2 = Alarms.getAlarm(activity.getContentResolver(), snoozeAlarmId)) != null) {
                Intent intent = new Intent(activity, (Class<?>) AlarmReceiver.class);
                intent.setAction("com.urbandroid.sleep.alarmclock.cancel_snooze");
                intent.putExtra("alarm_id", snoozeAlarmId);
                intent.putExtra("intent.extra.alarm_raw", alarm2.serializeToArray());
                ContextExtKt.sendExplicitBroadcast(activity, intent);
                view.startAnimation(animation);
                view.setVisibility(8);
            }
        } else {
            Alarms.skipAlarmOrShowCaptcha(activity, alarm);
        }
        view2.startAnimation(animation);
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWeather$6(View view) {
        Logger.logInfo("RatingActivity:Enabling WiFi");
        if (Build.VERSION.SDK_INT < 30) {
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (!sleepPermissionCompat.isPermissionGranted(this, "android.permission.CHANGE_WIFI_STATE")) {
                Logger.logInfo("RatingActivity: Enabling WiFi no permission");
                sleepPermissionCompat.requestPermission(this, "android.permission.CHANGE_WIFI_STATE", 73309);
                return;
            }
        }
        turnOnWifi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9() {
        initNextAlarmDismiss(this, (ViewGroup) findViewById(R.id.root));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$renderWeather$8(View view) {
        ViewIntent.url(this, "https://www.google.com/search?q=weather");
    }

    private void loadWeather(Context context, final View view) {
        log("Loading weather");
        Weather weather = this.weather;
        if (weather != null) {
            renderWeather(view, weather, null);
            return;
        }
        if (hasConnectivity(context)) {
            log("Has connectivity to load weather");
            requestWeather(context, view);
            return;
        }
        log("No connectivity to load weather");
        if (view.findViewById(R.id.weather_condition) != null) {
            ((TextView) view.findViewById(R.id.weather_condition)).setText(getString(R.string.message_connectivity_wait));
            ((ImageView) view.findViewById(R.id.weather_icon)).setImageResource(R.drawable.ic_feature_offline);
        }
        view.findViewById(R.id.weather).setVisibility(0);
        view.findViewById(R.id.weather).setTag(Boolean.FALSE);
        if (findViewById(R.id.weather) != null) {
            findViewById(R.id.weather).setOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 4));
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (RatingActivity.this.hasConnectivity(context2)) {
                    RatingActivity.this.requestWeather(context2, view);
                }
            }
        };
        this.connectivityReceiver = broadcastReceiver;
        ContextCompat.registerReceiver(this, broadcastReceiver, intentFilter, 2);
        if (this.loadWeatherAutomatically && !hasWifi() && SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.CHANGE_WIFI_STATE")) {
            this.didTurnOnWifi = true;
            turnOnWifi();
        }
    }

    private boolean maybeAskForAddonRating() {
        final Settings settings = ContextExtKt.getSettings(this);
        final Wearable selectedWearable = settings.getSelectedWearable();
        if (!settings.shouldAskForWearableAddonRating() || !this.record.hasTag(Tag.WATCH) || !this.record.isNiceRecord()) {
            return false;
        }
        if ((selectedWearable != Wearable.ADDON_URBANDROID_GARMIN && selectedWearable != Wearable.ADDON_URBANDROID_SAMSUNG_NEW && selectedWearable != Wearable.ADDON_URBANDROID_SAMSUNG_NEW2) || !TrialFilter.getInstance().isPackageInstalled(getPackageManager(), selectedWearable.addonPackageName)) {
            return false;
        }
        View viewFindViewById = findViewById(R.id.graph);
        final Snackbar.Callback callback = new Snackbar.Callback() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar snackbar, int i) {
                super.onDismissed(snackbar, i);
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Rate_wearable_addon_never");
                settings.setRateWearableNever();
            }
        };
        final Snackbar snackbarAddCallback = Snackbar.make(viewFindViewById, getString(R.string.wearable_compliment, selectedWearable.getName(this)) + "!", -2).addCallback(callback);
        snackbarAddCallback.setAction(R.string.rate_addon, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewIntent.market(RatingActivity.this, selectedWearable.addonPackageName);
                settings.setRateWearableDone();
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Rate_wearable_addon_done");
                snackbarAddCallback.removeCallback(callback);
            }
        });
        snackbarAddCallback.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderWeather(View view, Weather weather, Location location) {
        RatingActivity ratingActivity;
        TextView textView;
        Logger.logInfo("RatingActivity: rendering Weather " + weather);
        if (weather == null) {
            return;
        }
        if (weather.getSource() != null) {
            findViewById(R.id.weather_affiliation).setVisibility(0);
            ((TextView) findViewById(R.id.weather_affiliation)).setText(weather.getSource());
        }
        if (findViewById(R.id.weather) != null) {
            findViewById(R.id.weather).setOnClickListener(new RatingActivity$$ExternalSyntheticLambda0(this, 6));
        }
        boolean z = view.findViewById(R.id.weather1) == null;
        ((ViewGroup) view.findViewById(R.id.weather)).setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.tags);
        if (z) {
            if (weather.getTemperatureCelesius() < 5) {
                ratingActivity = this;
                Tag.handleTag(ratingActivity, Tag.COLD.getTagName(), "" + Weather.getTemperatureDegrees(this, weather), this.comment, viewGroup, true, 1, true, false);
            } else {
                ratingActivity = this;
                if (weather.getTemperatureCelesius() > 28) {
                    Tag.handleTag(ratingActivity, Tag.HOT.getTagName(), "" + Weather.getTemperatureDegrees(ratingActivity, weather), ratingActivity.comment, viewGroup, true, 1, true, false);
                }
            }
            Weather.Condition condition = weather.getCondition();
            Weather.Condition condition2 = Weather.Condition.STORM;
            if (condition == condition2) {
                Tag.handleTag(ratingActivity, Tag.STORM.getTagName(), null, ratingActivity.comment, viewGroup, true, 1, true, false);
            }
            if (weather.getCondition() == Weather.Condition.RAIN || weather.getCondition() == condition2 || weather.getCondition() == Weather.Condition.SNOW) {
                Tag.handleTag(ratingActivity, Tag.RAIN.getTagName(), null, ratingActivity.comment, viewGroup, true, 1, true, false);
            }
            if (weather.getCloudCoverage() > 60 || weather.getCondition() == Weather.Condition.CLOUD || weather.getCondition() == Weather.Condition.FOG) {
                Tag.handleTag(ratingActivity, Tag.CLOUDY.getTagName(), null, ratingActivity.comment, viewGroup, true, 1, true, false);
            }
        } else {
            ratingActivity = this;
        }
        TextView textView2 = (TextView) ratingActivity.findViewById(R.id.weather_temp);
        ImageView imageView = (ImageView) ratingActivity.findViewById(R.id.weather_icon);
        if (textView2 != null) {
            textView2.setText(Weather.getTemperatureString(ratingActivity, weather));
            textView2.setVisibility(0);
        }
        if (imageView != null) {
            if (weather.getCloudCoverage() > 50) {
                imageView.setImageResource(R.drawable.ic_weather_clouds);
            } else {
                imageView.setImageResource(R.drawable.ic_weather_cloudy);
            }
            Weather.Condition condition3 = weather.condition;
            if (condition3 != null) {
                imageView.setImageResource(condition3.getResource());
            }
        }
        TextView textView3 = (TextView) ratingActivity.findViewById(R.id.weather_cc);
        if (textView3 != null) {
            if (weather.getCloudCoverage() > 20) {
                textView3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(ratingActivity, R.drawable.ic_cloud), (Drawable) null, (Drawable) null, (Drawable) null);
                textView3.setText(weather.getCloudCoverage() + "%");
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) ratingActivity.findViewById(R.id.weather_ws);
        if (textView4 != null) {
            if (weather.getWindSpeed() > 9.0f) {
                textView4.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(ratingActivity, R.drawable.ic_action_wind), (Drawable) null, (Drawable) null, (Drawable) null);
                textView4.setText(Html.fromHtml(Math.round(weather.getWindSpeed()) + "<small>mps</small>"));
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
        if (location != null && (textView = (TextView) ratingActivity.findViewById(R.id.weather_sun)) != null) {
            try {
                Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunriseCalendarForDate(Calendar.getInstance());
                if (new Date().before(officialSunriseCalendarForDate.getTime())) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(ratingActivity, R.drawable.ic_action_sunrise), (Drawable) null, (Drawable) null, (Drawable) null);
                    textView.setText(DateUtil.formatTimeShort(ratingActivity.getApplicationContext(), officialSunriseCalendarForDate.getTime().getTime()));
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            } catch (Exception e) {
                textView.setVisibility(0);
                Logger.logSevere(e);
            }
        }
        TextView textView5 = (TextView) ratingActivity.findViewById(R.id.weather_condition);
        if (textView5 != null) {
            if (weather.getCondition() != null) {
                ratingActivity.log("RatingActivity: weather background " + weather.getCondition());
                textView5.setText(weather.getDesc() == null ? weather.getCondition().getTag().toLowerCase() : weather.getDesc());
                ratingActivity.log("RatingActivity: condition " + weather.getCondition().getTag() + " " + weather.getDesc());
                textView5.setVisibility(0);
            } else {
                textView5.setVisibility(8);
            }
        }
        if (ratingActivity.didTurnOnWifi) {
            ratingActivity.turnOffWifi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestWeather(Context context, final View view) {
        log("Get location for weather");
        if (LocationService.getLastLocation(context, new LocationService.LocationCallback() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.4
            @Override // com.urbandroid.sleep.location.LocationService.LocationCallback
            public void updateLocation(final Location location) {
                RatingActivity.this.log("Has location for weather: " + location);
                RatingActivity.this.cannotGetLocation(view);
                new AsyncTask<Void, Void, Weather>() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.4.1
                    @Override // android.os.AsyncTask
                    public Weather doInBackground(Void... voidArr) {
                        Logger.logInfo("Loading weather in background");
                        Weather weather = new NorwegianWeatherService().getWeather(location.getCoarse());
                        if (weather == null) {
                            weather = new OpenWeatherMapWeatherService().getWeather(location.getCoarse());
                        }
                        RatingActivity.this.weather = weather;
                        return weather;
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(Weather weather) {
                        if (weather != null) {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            RatingActivity.this.renderWeather(view, weather, location);
                            RatingActivity ratingActivity = RatingActivity.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append(Weather.getTemperatureString(RatingActivity.this, weather));
                            sb.append(" ");
                            sb.append(weather.getDesc() == null ? weather.getCondition().getTag().toLowerCase() : weather.getDesc());
                            TtsService.speak(ratingActivity, sb.toString());
                        }
                    }

                    @Override // android.os.AsyncTask
                    public void onPreExecute() {
                        super.onPreExecute();
                        Logger.logInfo("before loading weather");
                        if (RatingActivity.this.findViewById(R.id.weather_affiliation) != null) {
                            RatingActivity.this.findViewById(R.id.weather_affiliation).setVisibility(8);
                        }
                        if (view.findViewById(R.id.weather_condition) != null) {
                            ((TextView) view.findViewById(R.id.weather_condition)).setText(RatingActivity.this.getString(R.string.weather) + " " + RatingActivity.this.getString(R.string.stats_caption_loading).toLowerCase());
                        }
                    }
                }.execute(new Void[0]);
            }
        })) {
            return;
        }
        cannotGetLocation(view);
    }

    private void reveal() {
        this.morningStatsHidden = false;
        if (findViewById(R.id.major_measures) != null) {
            findViewById(R.id.major_measures).setVisibility(0);
        }
        findViewById(R.id.graph).setVisibility(0);
        findViewById(R.id.hypnogram).setVisibility(0);
        findViewById(R.id.sensor_graph).setVisibility(0);
        if (!this.largeScreen) {
            findViewById(R.id.sensor_graph).setVisibility(8);
        }
        findViewById(R.id.reveal).setVisibility(8);
        findViewById(R.id.graph_detail).setVisibility(0);
    }

    private void save() {
        if (this.record != null) {
            float rating = this.ratingBar.getRating();
            String string = this.comment.getText().toString();
            this.record.rateAndComment(string, rating);
            log("rating " + string + " " + rating);
            SharedApplicationContext.getInstance().getSleepRecordRepository().recordRatingUpdated(this.originalRecord, this.record, null);
            if (this.record.isNiceRecord()) {
                if (rating <= 0.0f || rating >= 4.0f) {
                    Settings.setGoodTimeToRate(true);
                }
            }
        }
    }

    public static void showRating(Context context, SleepRecord sleepRecord, boolean z) {
        Intent intent = new Intent(context, (Class<?>) MorningActivity.class);
        SleepRecord sleepRecord2 = new SleepRecord(sleepRecord, false);
        if (!sleepRecord2.isFinished()) {
            sleepRecord2.finish(new Date());
        }
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord2);
        intent.setFlags(603979776);
        if (z) {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        context.startActivity(intent);
    }

    public static void showRatingIfEnabled(Context context, SleepRecord sleepRecord) {
        int morningScreen = SharedApplicationContext.getSettings().getMorningScreen();
        if (morningScreen != 0) {
            if (morningScreen == 2) {
                SleepDetailActivity.start(context, sleepRecord, true);
                return;
            }
            if (morningScreen != 3) {
                showRating(context, sleepRecord);
                FrequentGeoService.start(context);
            } else {
                Intent intent = new Intent(context, (Class<?>) AlarmClock.class);
                intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                intent.putExtra("keyguard", true);
                context.startActivity(intent);
            }
        }
    }

    private void turnOffWifi() {
        if (Build.VERSION.SDK_INT < 30) {
            ((WifiManager) getApplicationContext().getSystemService("wifi")).setWifiEnabled(false);
            return;
        }
        try {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } catch (Exception unused) {
            Toast.makeText(this, R.string.general_unspecified_error, 1).show();
        }
    }

    private void turnOnWifi() {
        if (Build.VERSION.SDK_INT < 30) {
            ((WifiManager) getApplicationContext().getSystemService("wifi")).setWifiEnabled(true);
            return;
        }
        try {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } catch (Exception unused) {
            Toast.makeText(this, R.string.general_unspecified_error, 1).show();
        }
    }

    public boolean hasConnectivity(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Logger.logSevere(th);
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 1234 && i2 == -1 && (stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS")) != null) {
            this.comment.setText(((Object) this.comment.getText()) + " " + stringArrayListExtra.get(0));
            save();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        save();
        finish();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        log("RATING onCreate()");
        GlobalInitializator.initializeIfRequired(this);
        setTitle(R.string.good_morning);
        KeyguardUtil.disableWhenKeyboardUsagePossible(this);
        setContentView(R.layout.activity_rating);
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.bg_main));
        ToolbarUtil.apply(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_action_accept);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scroll);
        if (nestedScrollView != null) {
            nestedScrollView.setNestedScrollingEnabled(true);
        }
        this.comment = (EditText) findViewById(R.id.sleep_rating_comment);
        if (bundle != null) {
            boolValueOf = bundle.containsKey("stats_already_displayed") ? Boolean.valueOf(bundle.getBoolean("stats_already_displayed")) : null;
            this.didTurnOnWifi = bundle.getBoolean("did_turn_on_wifi", false);
            if (bundle.containsKey("weather")) {
                this.weather = (Weather) bundle.getSerializable("weather");
            }
            Logger.logInfo("RatingActivity: restoring weather " + this.weather);
        }
        buildActivityFromIntent(getIntent(), bundle, boolValueOf);
        maybeAskForAddonRating();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rating_menu, menu);
        this.airplaneMenu = menu.findItem(R.id.menu_airplane);
        this.shareMenu = menu.findItem(R.id.menu_share);
        if (!SharedApplicationContext.getSettings().isAutoSharingEnabled() && SharedApplicationContext.getInstance().getShareService().isConnected(this)) {
            this.shareMenu.setTitle(SharedApplicationContext.getInstance().getShareService().getName(this));
        }
        if (!SharedApplicationContext.getSettings().isAirplaneModeOn()) {
            this.airplaneMenu.setVisible(false);
        }
        MenuUtil.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        log("RATING Destroying rating activity " + getChangingConfigurations());
        if (getChangingConfigurations() == 0) {
            log("RATING Destroyed not by config change - doing auto sharing");
            afterRatingDone(this, this.record);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("RATING onNewIntent()");
        buildActivityFromIntent(intent, null, Boolean.valueOf(!this.morningStatsHidden));
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_GRAPH_CHANGED");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        float rating = this.ratingBar.getRating();
        String string = this.comment.getText().toString();
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                save();
                finish();
                break;
            case R.id.menu_airplane /* 2131362511 */:
                AirplaneModeUtil.disableAirplaneMode(this);
                this.airplaneMenu.setVisible(false);
                break;
            case R.id.menu_delete /* 2131362520 */:
                new MaterialAlertDialogBuilder(this).setIcon(R.drawable.ic_alert).setTitle(R.string.are_you_sure).setMessage(R.string.realy_delete_confirm_generic).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.RatingActivity.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RatingActivity.this.log("Deleting record from rating activity");
                        if (RatingActivity.this.record != null) {
                            UndoOperationGroup undoOperationGroup = new UndoOperationGroup(RatingActivity.this.getString(R.string.deleted), new SleepRecord(RatingActivity.this.record, false));
                            SharedApplicationContext.getInstance().deleteRecord(RatingActivity.this.record, undoOperationGroup);
                            SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
                            RatingActivity.this.record = null;
                        }
                        RatingActivity.this.finish();
                    }
                }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                break;
            case R.id.menu_share /* 2131362552 */:
                if (!SharedApplicationContext.getSettings().isAutoSharingEnabled() && SharedApplicationContext.getInstance().getShareService().isConnected(this)) {
                    this.record.rateAndComment(string, rating);
                    ShareAfterDismissService.shareExplicit(this, this.record);
                    this.shareMenu.setVisible(false);
                } else {
                    this.record.rateAndComment(string, rating);
                    String str = "graph_detail_" + DateUtil.getDatetimestamp(this.record.getFrom()) + ".png";
                    try {
                        Intent intentCreateIntent = ShareDataUtil.createIntent(this, str, new SleepRecordStringBuilder(getApplicationContext()).setPrependSleep(true).setAppendMeasures(true, Measure.ALL_MEASURES).setAppendAppName(true).build(this.record));
                        ShareDataUtil.saveData(this, str, SleepGraphImageGenerator.generateSleepGraph((Context) this, findViewById(R.id.root), true));
                        startActivity(Intent.createChooser(intentCreateIntent, getString(R.string.share_android)));
                    } catch (Exception unused) {
                        Toast.makeText(this, R.string.save_to_card_failed, 0).show();
                    }
                }
                break;
        }
        return true;
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 73309) {
            if (iArr[0] != 0) {
                Logger.logInfo("Permissions: WIFI Denied ");
                return;
            } else {
                Logger.logInfo("Permissions: WIFI Granted ");
                turnOnWifi();
                return;
            }
        }
        if (i != 73319) {
            return;
        }
        if (iArr[0] != 0) {
            Logger.logInfo("Permissions: LOCATION Denied ");
        } else {
            Logger.logInfo("Permissions: LOCATION Granted ");
            requestWeather(this, findViewById(R.id.weather));
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.h.removeCallbacks(this.showNextAlarmRunnable);
        this.h.postDelayed(this.showNextAlarmRunnable, 2000L);
        SleepRecord sleepRecordLoad = SharedApplicationContext.getInstance().getSleepRecordRepository().load(this.originalRecord.getFrom().getTime());
        if (sleepRecordLoad == null || sleepRecordLoad.getComment() == null || sleepRecordLoad.getComment().equals(this.comment.getText().toString())) {
            return;
        }
        this.comment.setText(sleepRecordLoad.getComment());
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("stats_already_displayed", !this.morningStatsHidden);
            bundle.putBoolean("did_turn_on_wifi", this.didTurnOnWifi);
            Weather weather = this.weather;
            if (weather != null) {
                bundle.putSerializable("weather", weather);
            }
            Logger.logInfo("RatingActivity: saving weather " + this.weather);
            if (this.record != null) {
                save();
                bundle.putParcelable("SleepRecord", this.record);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (SharedApplicationContext.getSettings().isWeather()) {
            loadWeather(this, findViewById(R.id.root));
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        BroadcastReceiver broadcastReceiver = this.connectivityReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.connectivityReceiver = null;
        }
        if (this.didTurnOnWifi) {
            turnOffWifi();
        }
    }

    public static void showRating(Context context, SleepRecord sleepRecord) {
        showRating(context, sleepRecord, true);
    }

    public static void showRatingIfEnabled(Context context, SleepRecord sleepRecord, boolean z) {
        if (SharedApplicationContext.getSettings().isShowRatingScreen()) {
            showRating(context, sleepRecord, z);
        }
    }
}
