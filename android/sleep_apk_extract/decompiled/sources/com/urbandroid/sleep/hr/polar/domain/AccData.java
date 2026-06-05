package com.urbandroid.sleep.hr.polar.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.hr.polar.domain.DeltaFrames;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccData {
    public final List<AccSample> accSamples = new ArrayList();
    public final long timeStamp;

    public static class AccSample {
        public final int x;
        public final int y;
        public final int z;

        public AccSample(int i, int i2, int i3) {
            this.x = i;
            this.y = i2;
            this.z = i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AccSample{");
            sb.append(this.x);
            sb.append(", ");
            sb.append(this.y);
            sb.append(", ");
            return FileInsert$$ExternalSyntheticOutline0.m(this.z, "}", sb);
        }
    }

    public AccData(byte[] bArr, float f, int i, long j) {
        this.timeStamp = j;
        for (DeltaFrames.ThreeAxisDeltaFramedData.ThreeAxisSample threeAxisSample : new DeltaFrames.ThreeAxisDeltaFramedData(bArr, f * 1000.0f, i, j).axisSamples) {
            this.accSamples.add(new AccSample((int) threeAxisSample.x, (int) threeAxisSample.y, (int) threeAxisSample.z));
        }
    }

    public String toString() {
        return "AccData{timeStamp=" + this.timeStamp + ", accSamples=" + this.accSamples + "}";
    }

    public AccData(byte b, byte[] bArr, long j) {
        this.timeStamp = j;
        int iCeil = (int) Math.ceil(((double) ((b + 1) * 8)) / 8.0d);
        int i = 0;
        while (i < bArr.length) {
            int iConvertArrayToSignedInt = BleUtils.convertArrayToSignedInt(bArr, i, iCeil);
            int i2 = i + iCeil;
            int iConvertArrayToSignedInt2 = BleUtils.convertArrayToSignedInt(bArr, i2, iCeil);
            int i3 = i2 + iCeil;
            int iConvertArrayToSignedInt3 = BleUtils.convertArrayToSignedInt(bArr, i3, iCeil);
            i = i3 + iCeil;
            this.accSamples.add(new AccSample(iConvertArrayToSignedInt, iConvertArrayToSignedInt2, iConvertArrayToSignedInt3));
        }
    }
}
