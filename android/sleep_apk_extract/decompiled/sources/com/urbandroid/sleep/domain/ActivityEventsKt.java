package com.urbandroid.sleep.domain;

import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/domain/SensorType;", "sensorType", "", SDKConstants.PARAM_VALUE, "Landroid/content/Intent;", "createRawActivityIntent", "(Lcom/urbandroid/sleep/domain/SensorType;F)Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "Lkotlin/Pair;", "unpackRawActivityIntent", "(Landroid/content/Intent;)Lkotlin/Pair;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ActivityEventsKt {
    public static final Intent createRawActivityIntent(SensorType sensorType, float f) {
        sensorType.getClass();
        Intent intent = new Intent("action_raw_activity");
        intent.putExtra("action_raw_activity_sensor", sensorType);
        intent.putExtra("action_raw_activity_data", f);
        return intent;
    }

    public static final Pair<SensorType, Float> unpackRawActivityIntent(Intent intent) {
        intent.getClass();
        Serializable serializableExtra = intent.getSerializableExtra("action_raw_activity_sensor");
        serializableExtra.getClass();
        return new Pair<>((SensorType) serializableExtra, Float.valueOf(intent.getFloatExtra("action_raw_activity_data", 0.0f)));
    }
}
