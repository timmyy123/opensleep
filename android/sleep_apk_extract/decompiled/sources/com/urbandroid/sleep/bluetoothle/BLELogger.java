package com.urbandroid.sleep.bluetoothle;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import java.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/BLELogger;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "debugMode", "", "logFile", "Lcom/urbandroid/util/StringBufferPersister;", "startLogFile", "", "endLogFile", "major", "message", "e", "", "minor", "bytes", "", "persist", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLELogger implements FeatureLogger {
    private final boolean debugMode;
    private volatile StringBufferPersister logFile;
    private final String tag = "BLEClient";

    public BLELogger() {
        if (this.debugMode) {
            return;
        }
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag() + ":"), FrequencyGuards.maxCountPerInterval(60, 600), 0, 4, null));
    }

    private final void persist(String message) {
        StringBufferPersister stringBufferPersister = this.logFile;
        if (stringBufferPersister != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.getClass();
            stringBufferPersister.update(Utils.format(calendar, "yyyy-MM-dd HH:mm:ss.SSS") + " " + message);
        }
    }

    public final void endLogFile() {
        StringBufferPersister stringBufferPersister = this.logFile;
        if (stringBufferPersister != null) {
            stringBufferPersister.flush();
        }
        this.logFile = null;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void major(String message, Throwable e) {
        message.getClass();
        e.getClass();
        Logger.logWarning(Logger.defaultTag, getTag() + ": " + message, e);
        persist(Fragment$$ExternalSyntheticOutline1.m(message, ": ", e.getClass().getName(), ": ", e.getMessage()));
    }

    public final void minor(String message, byte[] bytes) {
        message.getClass();
        bytes.getClass();
        if (this.debugMode) {
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(message, " ", BLEUtilKt.toString(bytes));
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM$1, null);
        }
        if (this.logFile != null) {
            persist(FileInsert$$ExternalSyntheticOutline0.m$1(message, " ", BLEUtilKt.toString(bytes)));
        }
    }

    public final void startLogFile() {
        if (Experiments.getInstance().isDetailedGattLoggingExperiment()) {
            this.logFile = new StringBufferPersister("BLE_activity", 10000, true);
        }
    }

    public final void major(String message) {
        message.getClass();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + message, null);
        persist(message);
    }

    public final void minor(String message, Throwable e) {
        message.getClass();
        e.getClass();
        if (this.debugMode) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + message, e);
        }
        if (this.logFile != null) {
            persist(Fragment$$ExternalSyntheticOutline1.m(message, ": ", e.getClass().getName(), ": ", e.getMessage()));
        }
    }

    public final void minor(String message) {
        message.getClass();
        if (this.debugMode) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + message, null);
        }
        persist(message);
    }
}
