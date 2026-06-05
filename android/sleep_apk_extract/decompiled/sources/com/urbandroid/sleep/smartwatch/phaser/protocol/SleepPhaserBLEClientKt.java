package com.urbandroid.sleep.smartwatch.phaser.protocol;

import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"parseActigraphyResult", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "bytes", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SleepPhaserBLEClientKt {
    public static final ActigraphyResult parseActigraphyResult(byte[] bArr) {
        bArr.getClass();
        int i = BLEUtilKt.toInt(bArr[0], bArr[1]);
        Status status = new Status(bArr[2]);
        int length = (bArr.length - 3) / 2;
        float[] fArr = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            fArr[i2] = BLEUtilKt.toInt(bArr[i3 + 3], bArr[i3 + 4]);
        }
        return new ActigraphyResult(i, status, fArr);
    }
}
