package com.urbandroid.sleep.smartwatch.phaser.actdata;

import com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient;
import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBufferVX;", "Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBuffer;", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;", "phaser", "<init>", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;)V", "getDelegate", "()Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBuffer;", "", "reset", "()V", "", "getRawData", "()[F", "getAndResetAggregatedData", "", "getMaxBackfillSize", "()I", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "rawBatch", "Lcom/urbandroid/util/StringBufferPersister;", "rawDataLog", "", "process", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;Lcom/urbandroid/util/StringBufferPersister;)Z", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/SleepPhaserBLEClient;", "delegate", "Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBuffer;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActivityDataBufferVX implements ActivityDataBuffer {
    private ActivityDataBuffer delegate;
    private final SleepPhaserBLEClient phaser;

    public ActivityDataBufferVX(SleepPhaserBLEClient sleepPhaserBLEClient) {
        sleepPhaserBLEClient.getClass();
        this.phaser = sleepPhaserBLEClient;
        this.delegate = new NullActivityDataBuffer();
    }

    private final synchronized ActivityDataBuffer getDelegate() {
        try {
            int firmwareVersion = this.phaser.getInfo().getFirmwareVersion();
            if (firmwareVersion <= 0) {
                this.delegate = new NullActivityDataBuffer();
            } else if (1 > firmwareVersion || firmwareVersion >= 34) {
                if (firmwareVersion < 34) {
                    throw new IllegalStateException("Should never happen");
                }
                if (!(this.delegate instanceof ActivityDataBufferV2)) {
                    Logger.logInfo("ActivityDataBufferVX: creating V2");
                    this.delegate = new ActivityDataBufferV2(300, new Callables$$ExternalSyntheticLambda0(this, 2));
                }
            } else if (!(this.delegate instanceof ActivityDataBufferV1)) {
                Logger.logInfo("ActivityDataBufferVX: creating V1");
                this.delegate = new ActivityDataBufferV1(300);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActigraphyResult getDelegate$lambda$0(ActivityDataBufferVX activityDataBufferVX) {
        return (ActigraphyResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new ActivityDataBufferVX$getDelegate$1$1(activityDataBufferVX, null), 1, null);
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public float[] getAndResetAggregatedData() {
        return getDelegate().getAndResetAggregatedData();
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public int getMaxBackfillSize() {
        return getDelegate().getMaxBackfillSize();
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public float[] getRawData() {
        return getDelegate().getRawData();
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public boolean process(ActigraphyResult rawBatch, StringBufferPersister rawDataLog) {
        rawBatch.getClass();
        return getDelegate().process(rawBatch, rawDataLog);
    }

    public synchronized void reset() {
        this.delegate = new NullActivityDataBuffer();
    }
}
