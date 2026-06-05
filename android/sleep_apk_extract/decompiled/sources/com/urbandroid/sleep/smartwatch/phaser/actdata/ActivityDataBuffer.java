package com.urbandroid.sleep.smartwatch.phaser.actdata;

import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.util.StringBufferPersister;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/smartwatch/phaser/actdata/ActivityDataBuffer;", "", "", "getRawData", "()[F", "getAndResetAggregatedData", "", "getMaxBackfillSize", "()I", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "rawBatch", "Lcom/urbandroid/util/StringBufferPersister;", "rawDataLog", "", "process", "(Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;Lcom/urbandroid/util/StringBufferPersister;)Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ActivityDataBuffer {
    float[] getAndResetAggregatedData();

    int getMaxBackfillSize();

    float[] getRawData();

    boolean process(ActigraphyResult rawBatch, StringBufferPersister rawDataLog);
}
