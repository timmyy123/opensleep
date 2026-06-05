package com.urbandroid.sleep.smartwatch;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.smartwatch.generic.GenericWatch;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0011J\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/MultiSmartWatch;", "Lcom/urbandroid/sleep/smartwatch/SmartWatch;", "<init>", "()V", "watch", "", "add", "(Lcom/urbandroid/sleep/smartwatch/SmartWatch;)V", "", "timestamp", "updateAlarm", "(J)V", "ts", "updatePause", "", "delay", "startAlarm", "(I)V", "stopAlarm", "Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;", "listener", "startTracking", "(Lcom/urbandroid/sleep/smartwatch/SmartWatchListener;)V", "stopTracking", "batchSize", "setBatchSize", "", "suspended", "setSuspended", "(Z)V", "repeat", ViewHierarchyConstants.HINT_KEY, "Lcom/urbandroid/sleep/sensor/IAccelManager;", "getAccelManager", "()Lcom/urbandroid/sleep/sensor/IAccelManager;", "", "getPlatform", "()Ljava/lang/String;", "", "watches", "Ljava/util/List;", "getWatches", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MultiSmartWatch implements SmartWatch {
    private final List<SmartWatch> watches = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getPlatform$lambda$0(SmartWatch smartWatch) {
        smartWatch.getClass();
        String platform = smartWatch.getPlatform();
        platform.getClass();
        return platform;
    }

    public final void add(SmartWatch watch) {
        watch.getClass();
        if (this.watches.isEmpty() || !(this.watches.get(0) instanceof GenericWatch) || (watch instanceof GenericWatch)) {
            this.watches.add(watch);
        } else {
            this.watches.add(0, watch);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        if (this.watches.size() > 0) {
            return this.watches.get(0).getAccelManager();
        }
        return null;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return FileInsert$$ExternalSyntheticOutline0.m("MULTI-", CollectionsKt.joinToString$default(this.watches, null, null, null, new URLUtilsKt$$ExternalSyntheticLambda0(2), 31));
    }

    public final List<SmartWatch> getWatches() {
        return this.watches;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int repeat) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).hint(repeat);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int batchSize) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).setBatchSize(batchSize);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean suspended) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).setSuspended(suspended);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int delay) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).startAlarm(delay);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener listener) {
        for (SmartWatch smartWatch : this.watches) {
            Logger.logInfo("SmartWatch: Multi start tracking " + smartWatch);
            smartWatch.startTracking(listener);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).stopAlarm();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).stopTracking();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long timestamp) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).updateAlarm(timestamp);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long ts) {
        Iterator<T> it = this.watches.iterator();
        while (it.hasNext()) {
            ((SmartWatch) it.next()).updateAlarm(ts);
        }
    }
}
