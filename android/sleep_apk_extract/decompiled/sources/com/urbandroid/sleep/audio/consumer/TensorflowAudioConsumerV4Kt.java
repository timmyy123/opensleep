package com.urbandroid.sleep.audio.consumer;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.audio.event.SoundEvent;
import com.urbandroid.sleep.snoring.SoundClass;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0002\u001a.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¨\u0006\u0010"}, d2 = {"thresholdValue", "", "thresholdSetting", "", "t1", "t2", "t3", "nullHandler", "Lkotlin/Function1;", "", "commonHandler", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "broadcastClass", "Lcom/urbandroid/sleep/snoring/SoundClass;", "threshold", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class TensorflowAudioConsumerV4Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Float, Boolean> commonHandler(Context context, final SoundClass soundClass, final float f) {
        final LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.getClass();
        final FloatFunction floatFunctionAvg = Moving.avg(10);
        return new Function1() { // from class: com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV4Kt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TensorflowAudioConsumerV4Kt.commonHandler$lambda$0(soundClass, floatFunctionAvg, f, localBroadcastManager, ((Float) obj).floatValue()));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean commonHandler$lambda$0(SoundClass soundClass, FloatFunction floatFunction, float f, LocalBroadcastManager localBroadcastManager, float f2) {
        if (soundClass != null) {
            localBroadcastManager.sendBroadcast(SoundEvent.newRawEvent(soundClass, f2).toIntent());
        }
        return floatFunction.apply(f2) > f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Float, Boolean> nullHandler() {
        return new AiPrompt$$ExternalSyntheticLambda0(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean nullHandler$lambda$0(float f) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float thresholdValue(int i, float f, float f2, float f3) {
        if (i == 1) {
            return f;
        }
        if (i == 2) {
            return f2;
        }
        if (i != 3) {
            return Float.POSITIVE_INFINITY;
        }
        return f3;
    }
}
