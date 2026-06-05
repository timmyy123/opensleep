package com.urbandroid.sleep.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.awake.AwakeDetector;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Experiments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\b\u0004*\u00011\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f0\u00188\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingSoundReceiver;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "range", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;)V", "", "init", "()V", "destroy", "", "isAwake", "()Z", "stop", "Landroid/content/Context;", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "Lcom/urbandroid/sleep/snoring/SoundClass;", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "averageWeightBuffers", "Ljava/util/Map;", "getAverageWeightBuffers", "()Ljava/util/Map;", "", "averageWeights", "getAverageWeights", "", "lastSoundEventReceived", "J", "getLastSoundEventReceived", "()J", "setLastSoundEventReceived", "(J)V", "soundEventReceiverRegistered", "Z", "", "sensitivityAdjustment", "D", "talkThreshold", "babyThreshold", "sickThreshold", "com/urbandroid/sleep/autostart/AutoTrackingSoundReceiver$soundEventReceiver$1", "soundEventReceiver", "Lcom/urbandroid/sleep/autostart/AutoTrackingSoundReceiver$soundEventReceiver$1;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoTrackingSoundReceiver implements FeatureLogger, AwakeDetector {
    private final Map<SoundClass, FloatFunction> averageWeightBuffers;
    private final Map<SoundClass, Float> averageWeights;
    private final double babyThreshold;
    private final Context context;
    private long lastSoundEventReceived;
    private final ExpectedTrackingRange range;
    private final double sensitivityAdjustment;
    private final double sickThreshold;
    private final AutoTrackingSoundReceiver$soundEventReceiver$1 soundEventReceiver;
    private volatile boolean soundEventReceiverRegistered;
    private final String tag;
    private final double talkThreshold;

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.urbandroid.sleep.autostart.AutoTrackingSoundReceiver$soundEventReceiver$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AutoTrackingSoundReceiver(Context context, ExpectedTrackingRange expectedTrackingRange) {
        double dMin;
        double dMin2;
        double dMin3;
        double d;
        double d2;
        context.getClass();
        this.context = context;
        this.range = expectedTrackingRange;
        this.tag = "AutoTracking:Sound";
        this.averageWeightBuffers = new LinkedHashMap();
        this.averageWeights = new LinkedHashMap();
        int awakeDetectionTalkSensitivity = SharedApplicationContext.getSettings().getAwakeDetectionTalkSensitivity();
        double d3 = awakeDetectionTalkSensitivity != 1 ? awakeDetectionTalkSensitivity != 2 ? awakeDetectionTalkSensitivity != 3 ? Double.POSITIVE_INFINITY : 0.5d : 1.0d : 2.0d;
        this.sensitivityAdjustment = d3;
        if (Experiments.getInstance().isTensorflowV4()) {
            int soundRecognitionSensitivityTalk = SharedApplicationContext.getSettings().getSoundRecognitionSensitivityTalk();
            if (soundRecognitionSensitivityTalk != 1) {
                if (soundRecognitionSensitivityTalk != 2) {
                    d2 = soundRecognitionSensitivityTalk == 3 ? d3 * 0.3d : d2;
                } else {
                    d2 = d3 * 0.6d;
                }
                dMin = d2;
            } else {
                dMin = Math.min(0.95d, d3 * 0.9d);
            }
        } else {
            int soundRecognitionSensitivityTalk2 = SharedApplicationContext.getSettings().getSoundRecognitionSensitivityTalk();
            dMin = soundRecognitionSensitivityTalk2 != 1 ? soundRecognitionSensitivityTalk2 != 2 ? soundRecognitionSensitivityTalk2 != 3 ? Double.POSITIVE_INFINITY : d3 * 0.15d : d3 * 0.3d : Math.min(0.8d, d3 * 0.6d);
        }
        this.talkThreshold = dMin;
        if (Experiments.getInstance().isTensorflowV4()) {
            int soundRecognitionSensitivityBabyCry = SharedApplicationContext.getSettings().getSoundRecognitionSensitivityBabyCry();
            dMin2 = soundRecognitionSensitivityBabyCry != 1 ? soundRecognitionSensitivityBabyCry != 2 ? soundRecognitionSensitivityBabyCry != 3 ? Double.POSITIVE_INFINITY : d3 * 0.25d : d3 * 0.5d : Math.min(0.95d, d3 * 0.9d);
        } else {
            int soundRecognitionSensitivityBabyCry2 = SharedApplicationContext.getSettings().getSoundRecognitionSensitivityBabyCry();
            if (soundRecognitionSensitivityBabyCry2 == 1) {
                dMin2 = Math.min(0.8d, d3 * 0.6d);
            } else if (soundRecognitionSensitivityBabyCry2 == 2) {
                dMin2 = d3 * 0.3d;
            } else if (soundRecognitionSensitivityBabyCry2 == 3) {
                dMin2 = 0.15d * d3;
            }
        }
        this.babyThreshold = dMin2;
        if (Experiments.getInstance().isTensorflowV4()) {
            int soundRecognitionSensitivitySick = SharedApplicationContext.getSettings().getSoundRecognitionSensitivitySick();
            dMin3 = soundRecognitionSensitivitySick != 1 ? soundRecognitionSensitivitySick != 2 ? soundRecognitionSensitivitySick != 3 ? Double.POSITIVE_INFINITY : 0.25d * d3 : d3 * 0.5d : Math.min(0.95d, d3 * 0.9d);
        } else {
            int soundRecognitionSensitivitySick2 = SharedApplicationContext.getSettings().getSoundRecognitionSensitivitySick();
            if (soundRecognitionSensitivitySick2 != 1) {
                if (soundRecognitionSensitivitySick2 != 2) {
                    d = soundRecognitionSensitivitySick2 == 3 ? 0.1d : 0.2d;
                }
                dMin3 = d3 * d;
            } else {
                dMin3 = Math.min(0.8d, d3 * 0.4d);
            }
        }
        this.sickThreshold = dMin3;
        Logger.addFilter(Filters.filter$default(Matchers.regex(".*Sound events stopped coming, reset.*"), FrequencyGuards.maxCountPerInterval(5, 2), 0, 4, null));
        this.soundEventReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.autostart.AutoTrackingSoundReceiver$soundEventReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (context2 == null || intent == null) {
                    return;
                }
                SoundEvent soundEventFromIntent = SoundEvent.fromIntent(intent);
                soundEventFromIntent.getClass();
                SoundClass soundClass = soundEventFromIntent.getSoundClass();
                if (SetsKt.setOf((Object[]) new SoundClass[]{SoundClass.TALK, SoundClass.COUGH, SoundClass.BABY}).contains(soundClass)) {
                    Map<SoundClass, FloatFunction> averageWeightBuffers = this.this$0.getAverageWeightBuffers();
                    FloatFunction floatFunctionAvg = averageWeightBuffers.get(soundClass);
                    if (floatFunctionAvg == null) {
                        floatFunctionAvg = Moving.avg(Experiments.getInstance().isTensorflowV4() ? 20 : 60);
                        floatFunctionAvg.getClass();
                        averageWeightBuffers.put(soundClass, floatFunctionAvg);
                    }
                    this.this$0.getAverageWeights().put(soundClass, Float.valueOf(floatFunctionAvg.apply((float) soundEventFromIntent.getWeight())));
                    this.this$0.setLastSoundEventReceived(System.currentTimeMillis());
                }
            }
        };
    }

    public final void destroy() {
        if (this.soundEventReceiverRegistered) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.soundEventReceiver);
        }
        this.soundEventReceiverRegistered = false;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceAwakeNow() {
        super.forceAwakeNow();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceNotAwake() {
        super.forceNotAwake();
    }

    public final Map<SoundClass, FloatFunction> getAverageWeightBuffers() {
        return this.averageWeightBuffers;
    }

    public final Map<SoundClass, Float> getAverageWeights() {
        return this.averageWeights;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void init() {
        if (this.soundEventReceiverRegistered) {
            return;
        }
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.soundEventReceiver, new IntentFilter("action_sound_event_raw"));
        this.soundEventReceiverRegistered = true;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        Float fValueOf = Float.valueOf(0.0f);
        if (this.lastSoundEventReceived > 0 && System.currentTimeMillis() - this.lastSoundEventReceived > 60000) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": Sound events stopped coming, reset.", null);
            this.averageWeightBuffers.clear();
            this.averageWeights.clear();
            return false;
        }
        Float f = this.averageWeights.get(SoundClass.BABY);
        if (f == null) {
            f = fValueOf;
        }
        float fFloatValue = f.floatValue();
        Float f2 = this.averageWeights.get(SoundClass.TALK);
        if (f2 == null) {
            f2 = fValueOf;
        }
        float fFloatValue2 = f2.floatValue();
        Float f3 = this.averageWeights.get(SoundClass.COUGH);
        if (f3 != null) {
            fValueOf = f3;
        }
        float fFloatValue3 = fValueOf.floatValue();
        double d = fFloatValue2;
        double d2 = this.talkThreshold;
        boolean z = d >= d2 || ((double) fFloatValue) >= this.babyThreshold || ((double) fFloatValue3) >= this.sickThreshold;
        if (z) {
            boolean z2 = z;
            String str = "isAwake SOUND BABY " + fFloatValue + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.babyThreshold + ", TALK " + fFloatValue2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + d2 + ", SICK " + fFloatValue3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.sickThreshold;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            return z2;
        }
        boolean z3 = z;
        if (fFloatValue2 + fFloatValue + fFloatValue3 > 0.05d) {
            String str2 = "NOT Awake SOUND BABY " + fFloatValue + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.babyThreshold + ", TALK " + fFloatValue2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + d2 + ", SICK " + fFloatValue3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.sickThreshold;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
        }
        return z3;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOff() {
        super.onScreenOff();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOn() {
        super.onScreenOn();
    }

    public final void setLastSoundEventReceived(long j) {
        this.lastSoundEventReceived = j;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
        destroy();
    }
}
