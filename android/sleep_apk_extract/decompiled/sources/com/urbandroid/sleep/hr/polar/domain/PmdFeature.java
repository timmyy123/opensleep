package com.urbandroid.sleep.hr.polar.domain;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes.dex */
public class PmdFeature {
    public final boolean accSupported;
    public final boolean ambientSupported;
    public final boolean barometerSupported;
    public final boolean bioZSupported;
    public final boolean ecgSupported;
    public final boolean gyroSupported;
    public final boolean magnetometerSupported;
    public final boolean ppgSupported;
    public final boolean ppiSupported;

    public PmdFeature(byte[] bArr) {
        byte b = bArr[1];
        this.ecgSupported = (b & 1) != 0;
        this.ppgSupported = (b & 2) != 0;
        this.accSupported = (b & 4) != 0;
        this.ppiSupported = (b & 8) != 0;
        this.bioZSupported = (b & 16) != 0;
        this.gyroSupported = (b & 32) != 0;
        this.magnetometerSupported = (b & 64) != 0;
        this.barometerSupported = (b & 128) != 0;
        this.ambientSupported = (bArr[2] & 1) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PmdFeature{ecgSupported=");
        sb.append(this.ecgSupported);
        sb.append(", ppgSupported=");
        sb.append(this.ppgSupported);
        sb.append(", accSupported=");
        sb.append(this.accSupported);
        sb.append(", ppiSupported=");
        sb.append(this.ppiSupported);
        sb.append(", bioZSupported=");
        sb.append(this.bioZSupported);
        sb.append(", gyroSupported=");
        sb.append(this.gyroSupported);
        sb.append(", magnetometerSupported=");
        sb.append(this.magnetometerSupported);
        sb.append(", barometerSupported=");
        sb.append(this.barometerSupported);
        sb.append(", ambientSupported=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.ambientSupported, '}');
    }
}
