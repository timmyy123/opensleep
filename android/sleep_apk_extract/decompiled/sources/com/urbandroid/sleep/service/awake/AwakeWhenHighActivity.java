package com.urbandroid.sleep.service.awake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.ActivityEventsKt;
import com.urbandroid.sleep.domain.SensorType;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0010\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/service/awake/AwakeWhenHighActivity;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "range", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;)V", "UNINITIALIZED", "Lkotlin/Function1;", "", "", "isActivityOverThreshold", "lastAwakeDetected", "", "eventReceiver", "com/urbandroid/sleep/service/awake/AwakeWhenHighActivity$eventReceiver$1", "Lcom/urbandroid/sleep/service/awake/AwakeWhenHighActivity$eventReceiver$1;", "isAwake", "stop", "", "createClassifierForPhoneAccel", "createClassifierForSmartwatch", "createAverageActivityOverThresholdClassifier", "mediumValue", "scalingFactor", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AwakeWhenHighActivity implements AwakeDetector {
    private final Function1<Float, Boolean> UNINITIALIZED;
    private final Context context;
    private final AwakeWhenHighActivity$eventReceiver$1 eventReceiver;
    private Function1<? super Float, Boolean> isActivityOverThreshold;
    private long lastAwakeDetected;
    private final ExpectedTrackingRange range;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.content.BroadcastReceiver, com.urbandroid.sleep.service.awake.AwakeWhenHighActivity$eventReceiver$1] */
    public AwakeWhenHighActivity(Context context, ExpectedTrackingRange expectedTrackingRange) {
        context.getClass();
        this.context = context;
        this.range = expectedTrackingRange;
        AiPrompt$$ExternalSyntheticLambda0 aiPrompt$$ExternalSyntheticLambda0 = new AiPrompt$$ExternalSyntheticLambda0(22);
        this.UNINITIALIZED = aiPrompt$$ExternalSyntheticLambda0;
        this.isActivityOverThreshold = aiPrompt$$ExternalSyntheticLambda0;
        ?? r3 = new BroadcastReceiver() { // from class: com.urbandroid.sleep.service.awake.AwakeWhenHighActivity$eventReceiver$1

            /* JADX INFO: loaded from: classes4.dex */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SensorType.values().length];
                    try {
                        iArr[SensorType.PHONE_ACCEL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SensorType.SMARTWATCH.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SensorType.BLE_ACCEL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Function1 function1CreateClassifierForPhoneAccel;
                context2.getClass();
                if (intent == null) {
                    return;
                }
                Pair<SensorType, Float> pairUnpackRawActivityIntent = ActivityEventsKt.unpackRawActivityIntent(intent);
                SensorType sensorTypeComponent1 = pairUnpackRawActivityIntent.component1();
                float fFloatValue = pairUnpackRawActivityIntent.component2().floatValue();
                if (Intrinsics.areEqual(this.this$0.isActivityOverThreshold, this.this$0.UNINITIALIZED)) {
                    AwakeWhenHighActivity awakeWhenHighActivity = this.this$0;
                    int i = WhenMappings.$EnumSwitchMapping$0[sensorTypeComponent1.ordinal()];
                    if (i == 1) {
                        function1CreateClassifierForPhoneAccel = this.this$0.createClassifierForPhoneAccel();
                    } else if (i != 2) {
                        AwakeWhenHighActivity awakeWhenHighActivity2 = this.this$0;
                        function1CreateClassifierForPhoneAccel = i != 3 ? awakeWhenHighActivity2.UNINITIALIZED : awakeWhenHighActivity2.createClassifierForSmartwatch();
                    } else {
                        function1CreateClassifierForPhoneAccel = this.this$0.createClassifierForSmartwatch();
                    }
                    awakeWhenHighActivity.isActivityOverThreshold = function1CreateClassifierForPhoneAccel;
                }
                if (((Boolean) this.this$0.isActivityOverThreshold.invoke(Float.valueOf(fFloatValue))).booleanValue()) {
                    this.this$0.lastAwakeDetected = System.currentTimeMillis();
                }
            }
        };
        this.eventReceiver = r3;
        LocalBroadcastManager.getInstance(context).registerReceiver(r3, new IntentFilter("action_raw_activity"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean UNINITIALIZED$lambda$0(float f) {
        return false;
    }

    private final Function1<Float, Boolean> createAverageActivityOverThresholdClassifier(float mediumValue, float scalingFactor) {
        int awakeDetectionHighActivitySensitivity = SharedApplicationContext.getSettings().getAwakeDetectionHighActivitySensitivity();
        if (awakeDetectionHighActivitySensitivity == 1) {
            mediumValue *= scalingFactor;
        } else if (awakeDetectionHighActivitySensitivity == 3) {
            mediumValue /= scalingFactor;
        }
        return new AnonymousClass1(new AverageActivityOverThreshold(mediumValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<Float, Boolean> createClassifierForPhoneAccel() {
        return createAverageActivityOverThresholdClassifier(1.5f, 1.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<Float, Boolean> createClassifierForSmartwatch() {
        return createAverageActivityOverThresholdClassifier(2.5f, 1.5f);
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceAwakeNow() {
        super.forceAwakeNow();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void forceNotAwake() {
        super.forceNotAwake();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        return System.currentTimeMillis() - this.lastAwakeDetected < 60000;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOff() {
        super.onScreenOff();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public /* bridge */ void onScreenOn() {
        super.onScreenOn();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
        LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.eventReceiver);
        this.isActivityOverThreshold = this.UNINITIALIZED;
        this.lastAwakeDetected = 0L;
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.awake.AwakeWhenHighActivity$createAverageActivityOverThresholdClassifier$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Float, Boolean> {
        public AnonymousClass1(Object obj) {
            super(1, obj, AverageActivityOverThreshold.class, "update", "update(F)Z", 0);
        }

        public final Boolean invoke(float f) {
            return Boolean.valueOf(((AverageActivityOverThreshold) this.receiver).update(f));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
            return invoke(f.floatValue());
        }
    }
}
