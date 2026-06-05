package com.urbandroid.sleep.hr.berry.parser;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.sleep.hr.berry.BerryOximeterBLEClient$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;

/* JADX INFO: loaded from: classes.dex */
public class PackageParserIsrael {
    private final FloatFunction hrSmoothing = Moving.quantilePrecise(10, 0.5f);
    private final OximeterResultListener listener;

    public PackageParserIsrael(OximeterResultListener oximeterResultListener) {
        this.listener = oximeterResultListener;
    }

    public void parse(int[] iArr) {
        if (iArr.length != 12) {
            Fragment$$ExternalSyntheticBUOutline0.m(iArr.length, "Invalid length: ");
            return;
        }
        if ((iArr[7] & 8) > 0) {
            int i = iArr[6];
            int i2 = (((iArr[10] & PHIpAddressSearchManager.END_IP_SCAN) << 8) | iArr[9]) * 2;
            ((BerryOximeterBLEClient$$ExternalSyntheticLambda0) this.listener).newPulse(new OximeterResult(i, Math.round(this.hrSmoothing.apply(60000 / i2)), 7, i2));
        }
    }
}
