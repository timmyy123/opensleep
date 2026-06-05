package com.urbandroid.sleep.hr.polar.domain;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PpiData {
    public final List<PPSample> ppSamples = new ArrayList();
    public final long timeStamp;

    public static class PPSample {
        public final int blockerBit;
        public final int hr;
        public final int ppErrorEstimate;
        public final int ppInMs;
        public final int skinContactStatus;
        public final int skinContactSupported;

        public PPSample(byte[] bArr) {
            this.hr = (int) (((long) bArr[0]) & 255);
            this.ppInMs = (int) BleUtils.convertArrayToUnsignedLong(bArr, 1, 2);
            this.ppErrorEstimate = (int) BleUtils.convertArrayToUnsignedLong(bArr, 3, 2);
            byte b = bArr[5];
            this.blockerBit = b & 1;
            this.skinContactStatus = (b & 2) >> 1;
            this.skinContactSupported = (b & 4) >> 2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("PPSample{hr=");
            sb.append(this.hr);
            sb.append(", ppInMs=");
            sb.append(this.ppInMs);
            sb.append(", ppErrorEstimate=");
            sb.append(this.ppErrorEstimate);
            sb.append(", blockerBit=");
            sb.append(this.blockerBit);
            sb.append(", skinContactStatus=");
            sb.append(this.skinContactStatus);
            sb.append(", skinContactSupported=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.skinContactSupported, '}');
        }
    }

    public PpiData(byte[] bArr, long j) {
        this.timeStamp = j;
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 6;
            this.ppSamples.add(new PPSample(Arrays.copyOfRange(bArr, i, i2)));
            i = i2;
        }
    }

    public String toString() {
        return "PpiData{timeStamp=" + this.timeStamp + ", ppSamples=" + this.ppSamples + "}";
    }
}
