package com.urbandroid.sleep.hr.berry.parser;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.hr.berry.BerryOximeterBLEClient$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public class PackageParserBCI {
    private final OximeterResultListener listener;
    private int packetNo = 0;
    private int lastPulseBeep = 0;

    public PackageParserBCI(OximeterResultListener oximeterResultListener) {
        this.listener = oximeterResultListener;
    }

    public void parse(int[] iArr) {
        if (iArr.length != 5) {
            Fragment$$ExternalSyntheticBUOutline0.m(iArr.length, "Invalid length: ");
            return;
        }
        int i = this.packetNo + 1;
        this.packetNo = i;
        int i2 = iArr[0];
        if ((i2 & 64) > 0) {
            int i3 = this.lastPulseBeep;
            if (i3 > 0) {
                int i4 = i2 & 15;
                if (i4 > 7) {
                    i4 = -1;
                }
                int i5 = iArr[3] | ((iArr[2] & 64) << 1);
                int i6 = iArr[4];
                int i7 = (i - i3) * 10;
                ((BerryOximeterBLEClient$$ExternalSyntheticLambda0) this.listener).newPulse(new OximeterResult(i6, i5, i4, i7));
            }
            this.lastPulseBeep = this.packetNo;
        }
    }
}
