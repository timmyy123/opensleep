package com.urbandroid.sleep.sensor.extra;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0004¢\u0006\u0004\b\u0014\u0010\u001aJ'\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001d\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/BTLEDataProducer;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataProducer;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function2;", "", "", "", "onNewValue", "start", "(Lkotlin/jvm/functions/Function2;)V", "stop", "()V", "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, "", "Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "extract", "(Landroid/content/Intent;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "", "extraName", "Lkotlin/ranges/IntRange;", "range", "(Landroid/content/Intent;Ljava/lang/String;Lkotlin/ranges/IntRange;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "extractValuesBatch", "(Landroid/content/Intent;Lkotlin/ranges/IntRange;)[Lcom/urbandroid/sleep/sensor/extra/ExtraValue;", "extractSingleValue", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BTLEDataProducer implements ExtraDataProducer, FeatureLogger {
    private final Context context;
    private BroadcastReceiver receiver;

    public BTLEDataProducer(Context context) {
        context.getClass();
        this.context = context;
    }

    public abstract ExtraValue[] extract(Intent intent);

    public final ExtraValue[] extract(Intent intent, String extraName, IntRange range) {
        intent.getClass();
        extraName.getClass();
        range.getClass();
        if (intent.hasExtra(extraName)) {
            return intent.hasExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH") ? extractValuesBatch(intent, range) : extractSingleValue(intent, extraName, range);
        }
        return null;
    }

    public ExtraValue[] extractSingleValue(Intent intent, String extraName, IntRange range) {
        intent.getClass();
        extraName.getClass();
        range.getClass();
        long longExtra = intent.getLongExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", System.currentTimeMillis());
        Float fValueOf = Float.valueOf(intent.getFloatExtra(extraName, -1.0f));
        float fFloatValue = fValueOf.floatValue();
        int first = range.getFirst();
        int last = range.getLast();
        int i = (int) fFloatValue;
        if (first > i || i > last) {
            fValueOf = null;
        }
        if (fValueOf == null) {
            fValueOf = null;
        }
        if (fValueOf != null) {
            return new ExtraValue[]{new ExtraValue(fValueOf.floatValue(), longExtra)};
        }
        return null;
    }

    public ExtraValue[] extractValuesBatch(Intent intent, IntRange range) {
        intent.getClass();
        range.getClass();
        long longExtra = intent.getLongExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", System.currentTimeMillis());
        long longExtra2 = intent.getLongExtra("com.urbandroid.sleep.EXTRA_DATA_FRAMERATE", 1000L);
        float[] floatArrayExtra = intent.getFloatArrayExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH");
        if (floatArrayExtra == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(floatArrayExtra.length);
        int length = floatArrayExtra.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(new ExtraValue(floatArrayExtra[i], longExtra - (((long) ((floatArrayExtra.length - i2) - 1)) * longExtra2)));
            i++;
            i2++;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            int first = range.getFirst();
            int last = range.getLast();
            int value = (int) ((ExtraValue) obj).getValue();
            if (first <= value && value <= last) {
                arrayList2.add(obj);
            }
        }
        return (ExtraValue[]) arrayList2.toArray(new ExtraValue[0]);
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public synchronized void start(final Function2<? super Float, ? super Long, Unit> onNewValue) {
        onNewValue.getClass();
        if (this.receiver != null) {
            return;
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.sensor.extra.BTLEDataProducer.start.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ExtraValue[] extraValueArrExtract;
                context.getClass();
                intent.getClass();
                if (Intrinsics.areEqual("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE", intent.getAction()) && (extraValueArrExtract = BTLEDataProducer.this.extract(intent)) != null) {
                    Function2<Float, Long, Unit> function2 = onNewValue;
                    for (ExtraValue extraValue : extraValueArrExtract) {
                        function2.invoke(Float.valueOf(extraValue.getValue()), Long.valueOf(extraValue.getTimestamp()));
                    }
                }
            }
        };
        try {
            Context context = this.context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
            Unit unit = Unit.INSTANCE;
            ContextExtKt.registerLocalReceiver(context, broadcastReceiver, intentFilter);
            Logger.logInfo(Logger.defaultTag, getTag() + ": receiver registered", null);
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, getTag() + ": registering receiver failed", e);
            broadcastReceiver = null;
        }
        this.receiver = broadcastReceiver;
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataProducer
    public synchronized void stop() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            try {
                Logger.logInfo(Logger.defaultTag, getTag() + ": unregistering receiver", null);
                ContextExtKt.unregisterLocalReceiver(this.context, broadcastReceiver);
            } catch (Exception unused) {
                Logger.logWarning(Logger.defaultTag, getTag() + ": unregistering receiver failed", null);
            }
            this.receiver = null;
        }
    }
}
