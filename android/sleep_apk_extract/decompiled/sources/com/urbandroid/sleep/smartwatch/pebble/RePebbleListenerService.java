package com.urbandroid.sleep.smartwatch.pebble;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.rebble.pebblekit2.client.BasePebbleListenerService;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.common.model.ReceiveResult;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u0004\u0018\u00010\t2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/pebble/RePebbleListenerService;", "Lio/rebble/pebblekit2/client/BasePebbleListenerService;", "<init>", "()V", "", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lio/rebble/pebblekit2/common/model/PebbleDictionary;", "data", "", "readAccelUpdateBatch", "(Ljava/util/Map;)[I", "Ljava/util/UUID;", "watchappUUID", "Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "watch", "Lio/rebble/pebblekit2/common/model/ReceiveResult;", "onMessageReceived-PjNdOfI", "(Ljava/util/UUID;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMessageReceived", "", "onAppOpened-kxV8hDc", "(Ljava/util/UUID;Ljava/lang/String;)V", "onAppOpened", "onAppClosed-kxV8hDc", "onAppClosed", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "getH", "()Landroid/os/Handler;", "Ljava/lang/Runnable;", "startAppRunnable", "Ljava/lang/Runnable;", "getStartAppRunnable", "()Ljava/lang/Runnable;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RePebbleListenerService extends BasePebbleListenerService {
    private final Handler h = new Handler();
    private final Runnable startAppRunnable = new Endpoint$$ExternalSyntheticLambda0(this, 9);

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onMessageReceived_PjNdOfI$lambda$1(String str) {
        str.getClass();
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onMessageReceived_PjNdOfI$lambda$3(String str) {
        str.getClass();
        return str;
    }

    private final int[] readAccelUpdateBatch(Map<UInt, ? extends PebbleDictionaryItem> data2) {
        try {
            PebbleDictionaryItem pebbleDictionaryItem = data2.get(UInt.m2388boximpl(9));
            pebbleDictionaryItem.getClass();
            byte[] value = ((PebbleDictionaryItem.Bytes) pebbleDictionaryItem).getValue();
            int[] iArr = new int[value.length / 2];
            for (int i = 0; i < value.length; i += 2) {
                iArr[i / 2] = (value[i] * 127) + value[i + 1];
            }
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAppRunnable$lambda$0(RePebbleListenerService rePebbleListenerService) {
        SmartWatch smartWatch;
        if (SleepService.isRunning() && (smartWatch = SmartWatchProvider.getSmartWatch(rePebbleListenerService)) != null && (smartWatch instanceof RePebble)) {
            ((RePebble) smartWatch).startApp();
        }
    }

    @Override // io.rebble.pebblekit2.client.BasePebbleListenerService
    /* JADX INFO: renamed from: onAppClosed-kxV8hDc, reason: not valid java name */
    public void mo2137onAppClosedkxV8hDc(UUID watchappUUID, String watch) {
        watchappUUID.getClass();
        watch.getClass();
        Logger.logInfo("RePebble: app closed " + watchappUUID + " " + WatchIdentifier.m2354toStringimpl(watch));
        this.h.removeCallbacks(this.startAppRunnable);
        if (SleepService.isRunning()) {
            this.h.postDelayed(this.startAppRunnable, 30000L);
        }
    }

    @Override // io.rebble.pebblekit2.client.BasePebbleListenerService
    /* JADX INFO: renamed from: onAppOpened-kxV8hDc, reason: not valid java name */
    public void mo2138onAppOpenedkxV8hDc(UUID watchappUUID, String watch) {
        watchappUUID.getClass();
        watch.getClass();
        Logger.logInfo("RePebble: requested tracking startup " + watchappUUID + " " + WatchIdentifier.m2354toStringimpl(watch));
        this.h.removeCallbacks(this.startAppRunnable);
        ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_TRACKING_UPDATE_SMARTWATCH"), null, 2, null);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new RePebble(applicationContext));
        if (SleepService.isRunning() || AlarmKlaxon.isRunning()) {
            return;
        }
        if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
            new SleepStarter().startSleep(this);
        } else {
            new SleepStarter().startSleepSkipUiButStartManually(this);
        }
    }

    @Override // io.rebble.pebblekit2.client.BasePebbleListenerService
    /* JADX INFO: renamed from: onMessageReceived-PjNdOfI, reason: not valid java name */
    public Object mo2139onMessageReceivedPjNdOfI(UUID uuid, Map<UInt, ? extends PebbleDictionaryItem> map, String str, Continuation<? super ReceiveResult> continuation) {
        String strJoinToString$default;
        Set<UInt> setKeySet = map.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(" " + UInt.m2392toStringimpl(((UInt) it.next()).getData()));
        }
        Logger.logInfo("RePebble: message " + CollectionsKt.joinToString$default(arrayList, null, null, null, new URLUtilsKt$$ExternalSyntheticLambda0(5), 31));
        if (setKeySet.contains(UInt.m2388boximpl(2))) {
            Logger.logInfo("RePebble: Snooze received");
            ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"), null, 2, null);
        }
        if (setKeySet.contains(UInt.m2388boximpl(3))) {
            Logger.logInfo("RePebble: Dismiss received");
            ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"), null, 2, null);
        }
        if (setKeySet.contains(UInt.m2388boximpl(999))) {
            Logger.logInfo("RePebble: timeline received");
            Settings settings = SharedApplicationContext.getSettings();
            PebbleDictionaryItem pebbleDictionaryItem = map.get(UInt.m2388boximpl(999));
            pebbleDictionaryItem.getClass();
            settings.setPebbleTimelineToken(((PebbleDictionaryItem.Text) pebbleDictionaryItem).getValue());
        }
        if (setKeySet.contains(UInt.m2388boximpl(9))) {
            Logger.logInfo("RePebble: accel received");
            int[] accelUpdateBatch = readAccelUpdateBatch(map);
            if (accelUpdateBatch != null) {
                ArrayList arrayList2 = new ArrayList(accelUpdateBatch.length);
                for (int i : accelUpdateBatch) {
                    arrayList2.add(" " + i);
                }
                strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, null, null, null, new URLUtilsKt$$ExternalSyntheticLambda0(6), 31);
            } else {
                strJoinToString$default = null;
            }
            zza$$ExternalSyntheticOutline0.m("RePebble: accel ", strJoinToString$default);
            if (accelUpdateBatch != null) {
                if (System.currentTimeMillis() % 40 == 0 && accelUpdateBatch.length != 0) {
                    Logger.logDebug("RePebble: accel data received: first " + accelUpdateBatch[0] + " size " + accelUpdateBatch.length);
                }
                for (int i2 : accelUpdateBatch) {
                    SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
                    Logger.logDebug("RePebble: smartwatch " + smartWatch);
                    if (smartWatch != null && (smartWatch instanceof RePebble)) {
                        float f = i2;
                        Logger.logDebug("RePebble: smartwatch " + smartWatch + " push " + f);
                        IAccelManager accelManager = ((RePebble) smartWatch).getAccelManager();
                        accelManager.getClass();
                        ((PebbleAccelManager) accelManager).pushNewData(f);
                    }
                }
            }
        }
        if (setKeySet.contains(UInt.m2388boximpl(4))) {
            Logger.logInfo("RePebble: Pause received");
            ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"), null, 2, null);
        }
        if (setKeySet.contains(UInt.m2388boximpl(7))) {
            Logger.logInfo("RePebble: Resume received");
            ContextExtKt.sendExplicitBroadcast$default(this, new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"), null, 2, null);
        }
        if (setKeySet.contains(UInt.m2388boximpl(8))) {
            try {
                PebbleDictionaryItem pebbleDictionaryItem2 = map.get(UInt.m2388boximpl(8));
                pebbleDictionaryItem2.getClass();
                byte bByteValue = ((PebbleDictionaryItem.Int8) pebbleDictionaryItem2).getValue().byteValue();
                Logger.logInfo("RePebble: HR " + ((int) bByteValue));
                if (bByteValue > -1) {
                    HrDataProducer.INSTANCE.produce(this, bByteValue, System.currentTimeMillis());
                }
            } catch (Exception unused) {
            }
        }
        return super.mo2139onMessageReceivedPjNdOfI(uuid, map, str, continuation);
    }
}
