package com.urbandroid.sleep.sensor.extra;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/LightSensorExtraDataProducer;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataProducer;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function2;", "", "", "", "onNewValue", "start", "(Lkotlin/jvm/functions/Function2;)V", "stop", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Landroid/hardware/SensorEventListener;", "sensorListener", "Landroid/hardware/SensorEventListener;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LightSensorExtraDataProducer implements ExtraDataProducer, FeatureLogger {
    private final Context context;
    private SensorEventListener sensorListener;
    private final String tag;

    public LightSensorExtraDataProducer(Context context) {
        context.getClass();
        this.context = context;
        this.tag = "DataCollector Lux";
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public void start(final Function2<? super Float, ? super Long, Unit> onNewValue) {
        onNewValue.getClass();
        Sensor lightSensor = ContextExtKt.getLightSensor(this.context);
        if (lightSensor != null) {
            this.sensorListener = new SensorEventListener() { // from class: com.urbandroid.sleep.sensor.extra.LightSensorExtraDataProducer$start$1$1
                @Override // android.hardware.SensorEventListener
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }

                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent event) {
                    float[] fArr;
                    Float fValueOf = (event == null || (fArr = event.values) == null) ? null : Float.valueOf(fArr[0]);
                    if (fValueOf != null) {
                        onNewValue.invoke(Float.valueOf(Math.min(fValueOf.floatValue(), 300.0f)), Long.valueOf(System.currentTimeMillis()));
                    }
                }
            };
            String str = "sensor registered " + ContextExtKt.getSensorManager(this.context).registerListener(this.sensorListener, lightSensor, 3);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        }
        if (lightSensor == null) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": light sensor missing", null);
        }
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public void stop() {
        SensorEventListener sensorEventListener = this.sensorListener;
        if (sensorEventListener != null) {
            ContextExtKt.getSensorManager(this.context).unregisterListener(sensorEventListener, ContextExtKt.getLightSensor(this.context));
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": sensor unregistered", null);
    }
}
