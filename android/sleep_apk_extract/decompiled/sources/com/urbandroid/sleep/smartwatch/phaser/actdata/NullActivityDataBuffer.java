package com.urbandroid.sleep.smartwatch.phaser.actdata;

import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/actdata/NullActivityDataBuffer;", "Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBuffer;", "<init>", "()V", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "rawBatch", "Lcom/urbandroid/util/StringBufferPersister;", "rawDataLog", "", "process", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;Lcom/urbandroid/util/StringBufferPersister;)Z", "", "getRawData", "()[F", "getAndResetAggregatedData", "", "getMaxBackfillSize", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NullActivityDataBuffer implements ActivityDataBuffer {
    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public float[] getAndResetAggregatedData() {
        return new float[0];
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public int getMaxBackfillSize() {
        return 0;
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public float[] getRawData() {
        return new float[0];
    }

    @Override // com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBuffer
    public boolean process(ActigraphyResult rawBatch, StringBufferPersister rawDataLog) {
        rawBatch.getClass();
        return true;
    }
}
