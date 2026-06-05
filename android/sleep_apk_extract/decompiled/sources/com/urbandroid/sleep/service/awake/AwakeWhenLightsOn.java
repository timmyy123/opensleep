package com.urbandroid.sleep.service.awake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.service.Settings;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AwakeWhenLightsOn;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "Landroid/hardware/SensorEventListener;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "range", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;)V", "tag", "", "getTag", "()Ljava/lang/String;", "sunState", "", "lux", "", "sensitivity", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "isAwake", "", "stop", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AwakeWhenLightsOn implements AwakeDetector, SensorEventListener, FeatureLogger {
    private final Context context;
    private float lux;
    private final ExpectedTrackingRange range;
    private final int sensitivity;
    private int sunState;
    private final String tag;

    public AwakeWhenLightsOn(Context context, ExpectedTrackingRange expectedTrackingRange) {
        context.getClass();
        this.context = context;
        this.range = expectedTrackingRange;
        this.tag = expectedTrackingRange != null ? "Awake Lux" : "Awake Lux AutoTracking";
        this.lux = -1.0f;
        this.sensitivity = new Settings(context).getAwakeDetectionLightSensitivity();
        Sensor lightSensor = ContextExtKt.getLightSensor(context);
        if (lightSensor != null) {
            ContextExtKt.getSensorManager(context).registerListener(this, lightSensor, 3);
        }
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceAwakeNow() {
        super.forceAwakeNow();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceNotAwake() {
        super.forceNotAwake();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        boolean z;
        float f;
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if ((record != null ? record.getTimezone() : null) == null) {
            record = null;
        }
        if (record == null) {
            return false;
        }
        try {
            Location locationComputeLocation = LocationService.computeLocation(record.getGeo());
            if (locationComputeLocation == null) {
                locationComputeLocation = new Settings(this.context).getLocation();
            }
            if (locationComputeLocation == null && this.sensitivity < 3) {
                if (this.sunState != 1) {
                    this.sunState = 1;
                    Logger.logInfo(Logger.defaultTag, getTag() + ": Awake: No location assuming it is NOT dark as sensitivity lower than high", null);
                }
                return false;
            }
            if (locationComputeLocation == null) {
                if (this.sunState != 2) {
                    this.sunState = 2;
                    Logger.logInfo(Logger.defaultTag, getTag() + ": Awake: No location assuming it is dark as sensitivity is high", null);
                }
                z = false;
            } else {
                Calendar calendar = Calendar.getInstance();
                z = false;
                try {
                    SunriseSunsetCalculator sunriseSunsetCalculator = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(locationComputeLocation.getLat(), locationComputeLocation.getLon()), DesugarTimeZone.getTimeZone(record.getTimezone()));
                    Calendar civilSunriseCalendarForDate = sunriseSunsetCalculator.getCivilSunriseCalendarForDate(calendar);
                    if (!calendar.after(sunriseSunsetCalculator.getCivilSunsetForDate(calendar)) && !calendar.before(civilSunriseCalendarForDate)) {
                        if (this.sunState != 1) {
                            this.sunState = 1;
                            Logger.logInfo(Logger.defaultTag, getTag() + ": Awake: Not yet dark", null);
                        }
                        return false;
                    }
                    if (this.sunState != 2) {
                        this.sunState = 2;
                        Logger.logInfo(Logger.defaultTag, getTag() + ": Awake: It's dark", null);
                    }
                } catch (Exception e) {
                    e = e;
                    Logger.logSevere(Logger.defaultTag, getTag(), e);
                    return z;
                }
            }
            int i = this.sensitivity;
            if (i == 0) {
                f = 30000.0f;
            } else if (i != 1) {
                f = 60.0f;
                if (i != 2 && i == 3) {
                    f = 30.0f;
                }
            } else {
                f = 90.0f;
            }
            float f2 = this.lux;
            boolean z2 = f2 >= f ? true : z;
            if (z2) {
                String str = "isAwake LUX " + f2 + " threshold " + f;
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            }
            return z2;
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOff() {
        super.onScreenOff();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOn() {
        super.onScreenOn();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        float[] fArr;
        this.lux = (event == null || (fArr = event.values) == null) ? -1.0f : fArr[0];
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
        ContextExtKt.getSensorManager(this.context).unregisterListener(this, ContextExtKt.getLightSensor(this.context));
    }
}
