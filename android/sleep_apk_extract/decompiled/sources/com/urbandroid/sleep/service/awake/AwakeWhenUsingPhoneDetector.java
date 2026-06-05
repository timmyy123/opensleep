package com.urbandroid.sleep.service.awake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Minutes;
import com.urbandroid.common.Seconds;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.sensor.AxisThresholdGuard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0019\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\u0002068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010+R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010+¨\u0006>"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AwakeWhenUsingPhoneDetector;", "Landroid/hardware/SensorEventListener;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "range", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;)V", "", "stopSensor", "()V", "onScreenOn", "onScreenOff", "", "isScreenOn", "()Z", "isAwake", "forceAwakeNow", "forceNotAwake", "Landroid/hardware/SensorEvent;", "event", "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "Landroid/hardware/Sensor;", "sensor", "", "accuracy", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "stop", "Landroid/content/Context;", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "", "ts", "J", "getTs", "()J", "setTs", "(J)V", "screenOnMinTime", "isScreenSaver", "Z", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/SensorManager;", "accelSensor", "Landroid/hardware/Sensor;", "Lcom/urbandroid/sleep/sensor/AxisThresholdGuard;", "axisThresholdGuard", "Lcom/urbandroid/sleep/sensor/AxisThresholdGuard;", "sensitivity", "I", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "awakeOrientation", "awakeAcceleration", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AwakeWhenUsingPhoneDetector implements SensorEventListener, AwakeDetector, FeatureLogger {
    private final Sensor accelSensor;
    private boolean awakeAcceleration;
    private boolean awakeOrientation;
    private AxisThresholdGuard axisThresholdGuard;
    private final Context context;
    private boolean isScreenSaver;
    private final ExpectedTrackingRange range;
    private final long screenOnMinTime;
    private final int sensitivity;
    private final SensorManager sensorManager;
    private final String tag;
    private long ts;
    private static final long SCREEN_ON_MIN_TIME_FROM = Utils.getSeconds(30);
    private static final long SCREEN_ON_MIN_TIME_TO = Utils.getMinutes(5);
    private static final long SCREEN_ON_MAX_TIME = Utils.getMinutes(120);
    private static final long SCREEN_ON_MAX_TIME_SCREENSAVER = Utils.getMinutes(60);

    public AwakeWhenUsingPhoneDetector(Context context, ExpectedTrackingRange expectedTrackingRange) {
        context.getClass();
        this.context = context;
        this.range = expectedTrackingRange;
        this.ts = -1L;
        int awakeDetectionWhenUsingPhoneSensitivity = new Settings(context).getAwakeDetectionWhenUsingPhoneSensitivity();
        this.sensitivity = awakeDetectionWhenUsingPhoneSensitivity;
        this.tag = expectedTrackingRange != null ? "Awake" : "Awake AutoTracking";
        this.awakeOrientation = true;
        int i = Settings.System.getInt(context.getContentResolver(), "screen_off_timeout", -1);
        this.isScreenSaver = 1 == Settings.Secure.getInt(context.getContentResolver(), "screensaver_enabled", 0);
        SleepLockManager lockManager = SharedApplicationContext.getInstance().getLockManager();
        if (lockManager != null && lockManager.isBatteryStatusKnown() && this.isScreenSaver && !lockManager.isPluggedIn()) {
            Logger.logInfo("Screensaver not plugged ");
            this.isScreenSaver = false;
        }
        Logger.logInfo(" Screensaver " + this.isScreenSaver + " config " + Settings.Secure.getInt(context.getContentResolver(), "screensaver_enabled", 0));
        if (awakeDetectionWhenUsingPhoneSensitivity >= 3) {
            this.screenOnMinTime = 30000L;
        } else {
            this.screenOnMinTime = MathKt.roundToInt(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(Minutes.m984getMillisimpl(SCREEN_ON_MIN_TIME_TO), i + 1000), Seconds.m992getMillisimpl(SCREEN_ON_MIN_TIME_FROM)));
        }
        Logger.logInfo("min detection time " + this.screenOnMinTime);
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorManager = sensorManager;
        this.accelSensor = sensorManager.getDefaultSensor(1);
    }

    private final void stopSensor() {
        Sensor sensor = this.accelSensor;
        if (sensor != null) {
            this.sensorManager.unregisterListener(this, sensor);
            this.awakeOrientation = false;
            this.awakeAcceleration = false;
        }
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void forceAwakeNow() {
        this.ts = (System.currentTimeMillis() - this.screenOnMinTime) - 1;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void forceNotAwake() {
        this.ts = -1L;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        boolean z = isScreenOn() && (this.awakeOrientation || this.sensitivity >= 3) && (this.awakeAcceleration || this.sensitivity >= 2);
        if (z) {
            Logger.logInfo("isAwake USING PHONE");
        }
        return z;
    }

    public final boolean isScreenOn() {
        return this.ts != -1;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        sensor.getClass();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void onScreenOff() {
        this.ts = -1L;
        stopSensor();
        this.axisThresholdGuard = null;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void onScreenOn() {
        this.ts = System.currentTimeMillis();
        Sensor sensor = this.accelSensor;
        if (sensor != null) {
            this.sensorManager.registerListener(this, sensor, 3);
        }
        this.axisThresholdGuard = new AxisThresholdGuard(100, this.isScreenSaver ? 0.3f : this.sensitivity >= 2 ? 0.075f : 0.15f);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event == null) {
            return;
        }
        AxisThresholdGuard axisThresholdGuard = this.axisThresholdGuard;
        if (axisThresholdGuard != null) {
            axisThresholdGuard.getClass();
            axisThresholdGuard.update(event);
            AxisThresholdGuard axisThresholdGuard2 = this.axisThresholdGuard;
            axisThresholdGuard2.getClass();
            this.awakeAcceleration = axisThresholdGuard2.overThreshold();
        }
        boolean z = this.awakeOrientation;
        if (!z) {
            float f = event.values[2];
            if (f > -8.8f && f < 8.8f) {
                this.awakeOrientation = true;
                return;
            }
        }
        if (z) {
            float f2 = event.values[2];
            if (f2 < -8.8f || f2 > 8.8f) {
                this.awakeOrientation = false;
            }
        }
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
        stopSensor();
    }
}
