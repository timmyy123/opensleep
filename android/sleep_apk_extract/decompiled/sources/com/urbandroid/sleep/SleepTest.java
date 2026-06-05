package com.urbandroid.sleep;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.headset.HeadsetPlugChecker;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.gui.SafeSliderWrapper;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.sensor.AccelManager;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.sleep.sensor.sonar.SonarConsumer;
import com.urbandroid.sleep.sensor.sonar.SonarConsumerFactory;
import com.urbandroid.sleep.sensor.sonar.SonarTestAccelManager;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.VolumeUtil;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class SleepTest extends BaseActivity {
    private static boolean sensorTestRunning = false;
    private IAccelManager accelManager;
    private Animation animPulse;
    private volatile AudioRecorder audioRecorder;
    private GraphView graph;
    private Handler h;
    private PowerManager.WakeLock screenLock;
    private SmartWatch smartWatch;
    private SonarConsumer sonarConsumer;
    private boolean checkSonarSupport = false;
    private Boolean sonarSupported = null;
    private boolean supportDetected = false;
    private Runnable sleepWatcher = new Runnable() { // from class: com.urbandroid.sleep.SleepTest.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                SleepTest sleepTest = SleepTest.this;
                sleepTest.processChanges(sleepTest.accelManager.resetChanges(false));
            } finally {
                try {
                } finally {
                }
            }
        }
    };
    private boolean deepSleep = true;
    private boolean hasValues = false;
    private boolean sonarBoxShown = false;
    private List<Float> valueList = new ArrayList();
    private HeadsetPlugChecker headsetChecker = null;
    private Snackbar headphonesSnackBar = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHeadsetWarning() {
        Snackbar snackbar = this.headphonesSnackBar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    public static boolean isSensorTestRunning() {
        return sensorTestRunning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupVolumeBar$0(int i, SafeSliderWrapper safeSliderWrapper, int i2, int i3, Slider slider, float f, boolean z) {
        float f2 = i;
        if (f < f2) {
            safeSliderWrapper.setValue(f2);
            f = f2;
        }
        VolumeUtil.setStreamVolume(getApplicationContext(), i2, Math.round(f));
        SharedApplicationContext.getSettings().setSonarVolumeOffset(i3 - Math.round(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processChanges(float[] fArr) {
        for (float f : fArr) {
            Logger.logInfo("SleepTest: change " + f);
        }
        if (this.valueList.size() > 60) {
            this.valueList.remove(0);
        }
        for (float f2 : fArr) {
            this.valueList.add(Float.valueOf(f2));
            if (!this.hasValues && f2 > 0.0f) {
                findViewById(R.id.progress).setVisibility(4);
                this.hasValues = true;
            }
        }
        this.graph.setEquidistantValues(this.valueList, this.sonarConsumer == null);
        this.graph.invalidate();
        SonarConsumer sonarConsumer = this.sonarConsumer;
        if (sonarConsumer != null) {
            if (sonarConsumer.getSignalStrength() <= 0.0d || this.sonarSupported == null) {
                ((TextView) findViewById(R.id.sonar_signal_strength)).setTextColor(ContextCompat.getColor(this, R.color.primary));
                ((TextView) findViewById(R.id.sonar_signal_strength)).setText(getResources().getString(R.string.please_wait));
            } else {
                ((TextView) findViewById(R.id.sonar_signal_strength)).setTextColor(ContextCompat.getColor(this, R.color.primary));
                TextView textView = (TextView) findViewById(R.id.sonar_signal_strength);
                StringBuilder sb = new StringBuilder("<big><big>");
                sb.append(this.sonarConsumer.getSignalStrength() > 0.0d ? Long.valueOf(Math.min(Math.round(this.sonarConsumer.getSignalStrength()), 10000L)) : getResources().getString(R.string.please_wait_long) + "<br/>" + getResources().getString(R.string.please_wait_long));
                sb.append("</big></big> ");
                sb.append(getResources().getString(R.string.signal_strength));
                textView.setText(Html.fromHtml(sb.toString()));
                if (!this.sonarSupported.booleanValue()) {
                    ((TextView) findViewById(R.id.sonar_signal_strength)).setTextColor(ContextCompat.getColor(this, this.sonarSupported.booleanValue() ? R.color.primary : R.color.negative_light));
                }
            }
            if (this.sonarConsumer.getUltrasoundSupported() != null) {
                boolean zBooleanValue = this.sonarConsumer.getUltrasoundSupported().booleanValue();
                Boolean bool = this.sonarSupported;
                if (!zBooleanValue) {
                    if (bool == null || bool.booleanValue()) {
                        showSonarNotSupportedBox();
                        Toast.makeText(this, getResources().getString(R.string.not_supported, getResources().getString(R.string.sensor_sonar)), 0).show();
                    }
                    this.sonarSupported = Boolean.FALSE;
                    if (this.checkSonarSupport) {
                        setResult(6);
                        return;
                    }
                    return;
                }
                if (bool == null || !bool.booleanValue()) {
                    if (SharedApplicationContext.getSettings().showShowCaseIfNotShown("sc_sonar_audible_warn")) {
                        try {
                            TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.sonar_volume), getResources().getString(R.string.supported, getResources().getString(R.string.sensor_sonar)), getResources().getString(R.string.sonar_audible_artifacts)).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color).targetCircleColor(R.color.bg_main).icon(getResources().getDrawable(R.drawable.ic_volume_high)).tintTarget(false).cancelable(true).textColor(R.color.primary), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.SleepTest.2
                                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                                public void onTargetCancel(TapTargetView tapTargetView) {
                                    super.onTargetCancel(tapTargetView);
                                }

                                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                                public void onTargetClick(TapTargetView tapTargetView) {
                                    super.onTargetClick(tapTargetView);
                                }
                            });
                        } catch (Exception e) {
                            Logger.logSevere(e);
                        }
                    }
                    Toast.makeText(this, getResources().getString(R.string.supported, getResources().getString(R.string.sensor_sonar)), 0).show();
                }
                this.sonarSupported = Boolean.TRUE;
                if (this.sonarConsumer.getSignalStrength() > 400.0d) {
                    Settings.isGoodTimeToRate();
                }
                if (this.checkSonarSupport) {
                    setResult(5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartSonar(final Spinner spinner) {
        this.sonarConsumer.resetSignalStrength();
        this.sonarSupported = null;
        SonarConsumer sonarConsumerCreateSonarConsumer = new SonarConsumerFactory(getApplicationContext()).createSonarConsumer(SharedApplicationContext.getSettings().getSonarMethod());
        this.sonarConsumer = sonarConsumerCreateSonarConsumer;
        this.accelManager = new SonarTestAccelManager(sonarConsumerCreateSonarConsumer);
        StringBuilder sb = new StringBuilder("SleepTest: restartSonar: audioRecorder hashcode=");
        sb.append(this.audioRecorder != null ? Integer.valueOf(this.audioRecorder.hashCode()) : null);
        Logger.logInfo(sb.toString());
        if (this.audioRecorder != null) {
            if (spinner != null) {
                spinner.setEnabled(false);
            }
            this.audioRecorder.destroy(new AudioRecorder.OnDestroyListener() { // from class: com.urbandroid.sleep.SleepTest.9
                @Override // com.urbandroid.sleep.audio.AudioRecorder.OnDestroyListener
                public void destroyed() {
                    SleepTest sleepTest = SleepTest.this;
                    sleepTest.audioRecorder = new AudioRecorder(sleepTest.getApplicationContext());
                    SleepTest.this.audioRecorder.addConsumer((AudioRecorder.Consumer) SleepTest.this.sonarConsumer);
                    new Thread(SleepTest.this.audioRecorder).start();
                    Spinner spinner2 = spinner;
                    if (spinner2 != null) {
                        spinner2.setEnabled(true);
                    }
                }

                @Override // com.urbandroid.sleep.audio.AudioRecorder.OnDestroyListener
                public void timeouted() {
                    Spinner spinner2 = spinner;
                    if (spinner2 != null) {
                        spinner2.setEnabled(true);
                    }
                    Toast.makeText(SleepTest.this.getApplicationContext(), SharedApplicationContext.getSettings().getSonarMethod() + " failure", 0).show();
                }
            }, 20);
        }
    }

    private void setWakeLock(boolean z) {
        if (this.screenLock == null) {
            this.screenLock = ((PowerManager) getSystemService("power")).newWakeLock(6, SleepLockManager.getWakeLockTag(this, "SleepTest"));
        }
        PowerManager.WakeLock wakeLock = this.screenLock;
        if (z) {
            if (wakeLock.isHeld()) {
                return;
            }
            this.screenLock.acquire();
        } else if (wakeLock.isHeld()) {
            this.screenLock.release();
        }
    }

    private void setupVolumeBar(final SafeSliderWrapper safeSliderWrapper, final int i) {
        final int streamMaxVolume = ((AudioManager) getSystemService("audio")).getStreamMaxVolume(i);
        int sonarVolume = SharedApplicationContext.getSettings().getSonarVolume(i);
        final int i2 = streamMaxVolume / 4;
        safeSliderWrapper.setValueFrom(0.0f);
        safeSliderWrapper.setValueTo(streamMaxVolume);
        safeSliderWrapper.setValue(sonarVolume);
        safeSliderWrapper.getSlider().addOnChangeListener(new Slider.OnChangeListener() { // from class: com.urbandroid.sleep.SleepTest$$ExternalSyntheticLambda0
            @Override // com.google.android.material.slider.Slider.OnChangeListener
            public final void onValueChange(Slider slider, float f, boolean z) {
                this.f$0.lambda$setupVolumeBar$0(i2, safeSliderWrapper, i, streamMaxVolume, slider, f, z);
            }
        });
        safeSliderWrapper.getSlider().addOnSliderTouchListener(new BaseOnSliderTouchListener() { // from class: com.urbandroid.sleep.SleepTest.10
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStartTrackingTouch(Slider slider) {
                SleepTest.this.sonarConsumer.resetSignalStrength();
                SleepTest.this.sonarSupported = null;
            }

            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStopTrackingTouch(Slider slider) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHeadsetWarning() {
        Snackbar snackbarMake = Snackbar.make(findViewById(R.id.main), R.string.sonar_headset, -2);
        this.headphonesSnackBar = snackbarMake;
        snackbarMake.show();
    }

    private void showSonarNotSupportedBox() {
        if (this.sonarBoxShown) {
            return;
        }
        ((TextView) findViewById(R.id.sonar_not_supported_box_title)).setText(getResources().getString(R.string.not_supported, getResources().getString(R.string.sensor_sonar)) + " :_(");
        ((TextView) findViewById(R.id.sonar_not_supported_box_summary)).setText(getResources().getString(R.string.sonar_not_supported) + "\n\n" + getResources().getString(R.string.sonar_not_supported_phaser) + " - " + getResources().getString(R.string.sleep_phaser_desc).toLowerCase());
        findViewById(R.id.sonar_not_supported_box).setVisibility(0);
        findViewById(R.id.button_phaser).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.SleepTest.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewIntent.url(SleepTest.this, SleepTest.this.getResources().getString(R.string.addons_sleepphaser_link) + "/?t=st");
            }
        });
        findViewById(R.id.sonar_not_supported_box_close).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.SleepTest.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SleepTest.this.findViewById(R.id.sonar_not_supported_box).setVisibility(8);
            }
        });
        this.sonarBoxShown = true;
    }

    public static void start(Context context) {
        if (!SharedApplicationContext.getSettings().isSmartwatchEnabled()) {
            Intent intent = new Intent(context, (Class<?>) SleepTest.class);
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent);
        } else {
            Intent intent2 = new Intent(context, (Class<?>) SmartWatchActivity.class);
            intent2.putExtra("test_sensors", true);
            intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent2);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        this.checkSonarSupport = getIntent().hasExtra("check_sonar_support");
        this.animPulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        this.h = new Handler();
        if (SleepService.isRunning()) {
            startActivity(new Intent(this, (Class<?>) Sleep.class));
            Toast.makeText(this, R.string.tracking_in_progress_battery_warning, 0).show();
            finish();
            return;
        }
        setContentView(R.layout.activity_sleep_test);
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setStatusBarColor(ColorUtil.i(this, R.color.bg_main));
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.bg_main));
        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.menu_test));
        sb.append(" — ");
        sb.append((SharedApplicationContext.getSettings().isUltrasonicTracking() || this.checkSonarSupport) ? getResources().getStringArray(R.array.non_deep_sleep_method_entries)[1] : getResources().getStringArray(R.array.non_deep_sleep_method_entries)[0]);
        setTitle(sb.toString());
        if (this.graph == null) {
            GraphView graphView = (GraphView) findViewById(R.id.graph);
            this.graph = graphView;
            graphView.setYAxisLabels(null);
            this.graph.setDoDrawGraphLine(true);
            this.graph.setDoTrimming(false);
            this.graph.setDoGradient(false);
            this.graph.setGradientFullColor(ColorUtil.i(this, R.color.transparent));
            this.graph.setGradientTransColor(ColorUtil.i(this, R.color.transparent));
            this.graph.setDrawAverage(false);
            this.graph.setDrawYAxis(false);
            this.graph.setDoDrawAxisLine(false);
            this.graph.setDrawXAxisBars(false);
            this.graph.setForceXAxisOffset(true);
            this.graph.setxAxisOffsetDpi(40);
            this.graph.setDrawAverage(false);
            this.graph.setCardColor(ContextCompat.getColor(this, R.color.bg_main));
            this.graph.setSleepGraphColor(ColorUtil.i(this, R.color.transparent));
            this.graph.setSleepGraphLineColor(ColorUtil.i(this, R.color.tint));
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        finish();
        return false;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        findViewById(R.id.sonar_control_bar).setVisibility(8);
        Logger.logInfo("Sensor test running");
        sensorTestRunning = true;
        setWakeLock(true);
        if (this.smartWatch == null) {
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
            this.smartWatch = smartWatch;
            if (smartWatch != null) {
                setTitle(getResources().getString(R.string.menu_test) + " — " + getResources().getString(R.string.smartwatch));
                Toast.makeText(this, R.string.sw_sensor_test, 1).show();
                this.smartWatch.startTracking(new SmartWatchListener() { // from class: com.urbandroid.sleep.SleepTest.5
                });
                this.smartWatch.setBatchSize(1);
            }
        }
        if (this.accelManager == null) {
            SmartWatch smartWatch2 = this.smartWatch;
            this.accelManager = smartWatch2 != null ? smartWatch2.getAccelManager() : new AccelManager(this, false, 0);
            if (this.smartWatch == null && (this.checkSonarSupport || SharedApplicationContext.getSettings().isUltrasonicTracking())) {
                Logger.logInfo("SleepTest: using Sonar");
                findViewById(R.id.sonar_control_bar).setVisibility(0);
                SafeSliderWrapper safeSliderWrapper = new SafeSliderWrapper((Slider) findViewById(R.id.sonar_volume));
                safeSliderWrapper.getSlider().setCustomThumbDrawable(R.drawable.ic_progress_volume);
                safeSliderWrapper.getSlider().setThumbRadius(ActivityUtils.getDip(this, 20));
                setupVolumeBar(safeSliderWrapper, SharedApplicationContext.getSettings().getSonarStream());
                if (!SharedApplicationContext.getSettings().hasRequiredSampleRateForUltrasonicTracking()) {
                    Toast.makeText(this, getResources().getString(R.string.not_supported, getResources().getString(R.string.sensor_sonar)), 0).show();
                    if (this.checkSonarSupport) {
                        setResult(6);
                        showSonarNotSupportedBox();
                        return;
                    }
                    return;
                }
                this.sonarConsumer = new SonarConsumerFactory(getApplicationContext()).createSonarConsumer(SharedApplicationContext.getSettings().getSonarMethod());
                findViewById(R.id.sonar_signal_strength).setVisibility(0);
                findViewById(R.id.sonar_signal_strength).startAnimation(this.animPulse);
                final Spinner spinner = (Spinner) findViewById(R.id.sonar_method);
                String[] stringArray = getResources().getStringArray(R.array.sonar_method_entries);
                String[] stringArray2 = getResources().getStringArray(R.array.sonar_method_values);
                SonarConfig.SonarMethod sonarMethod = new Settings(getApplicationContext()).getSonarMethod();
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, R.layout.spinner, stringArray));
                ((ArrayAdapter) spinner.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                try {
                    int i = 0;
                    for (String str : stringArray2) {
                        Logger.logInfo(str + " " + sonarMethod.name() + " " + i);
                        if (str.equals(sonarMethod.name())) {
                            break;
                        }
                        i++;
                    }
                    spinner.setSelection(i);
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.SleepTest.6
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                        new Settings(SleepTest.this.getApplicationContext()).setSonarMethod(SonarConfig.SonarMethod.valueOf(SleepTest.this.getResources().getStringArray(R.array.sonar_method_values)[i2]));
                        SleepTest.this.restartSonar(spinner);
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                this.audioRecorder = new AudioRecorder(getApplicationContext());
                this.audioRecorder.addConsumer((AudioRecorder.Consumer) this.sonarConsumer);
                this.accelManager = new SonarTestAccelManager(this.sonarConsumer);
                new Thread(this.audioRecorder).start();
                HeadsetPlugChecker headsetPlugCheckerStart = HeadsetPlugChecker.from(this).start(new HeadsetPlugChecker.Listener() { // from class: com.urbandroid.sleep.SleepTest.8
                    @Override // com.urbandroid.common.headset.HeadsetPlugChecker.Listener
                    public void headsetPlugged() {
                        Logger.logSevere("Headset plug");
                        SleepTest.this.showHeadsetWarning();
                    }

                    @Override // com.urbandroid.common.headset.HeadsetPlugChecker.Listener
                    public void headsetUnplugged() {
                        Logger.logSevere("Headset unplug");
                        SleepTest.this.hideHeadsetWarning();
                    }
                });
                this.headsetChecker = headsetPlugCheckerStart;
                if (headsetPlugCheckerStart.isPlugged()) {
                    Logger.logSevere("Headset PLUG");
                    showHeadsetWarning();
                }
            }
            this.accelManager.start();
        }
        this.h.post(this.sleepWatcher);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Logger.logInfo("SleepTest: Sensor test STOP");
        setWakeLock(false);
        this.h.removeCallbacks(this.sleepWatcher);
        IAccelManager iAccelManager = this.accelManager;
        if (iAccelManager != null) {
            iAccelManager.stop();
            this.accelManager = null;
        }
        SmartWatch smartWatch = this.smartWatch;
        if (smartWatch != null) {
            smartWatch.stopTracking();
            this.smartWatch = null;
        }
        if (this.audioRecorder != null) {
            this.audioRecorder.stop();
        }
        if (!SleepService.isRunning()) {
            SmartWatchProvider.releaseSmartwatch();
        }
        HeadsetPlugChecker headsetPlugChecker = this.headsetChecker;
        if (headsetPlugChecker != null) {
            headsetPlugChecker.close();
        }
        sensorTestRunning = false;
    }
}
