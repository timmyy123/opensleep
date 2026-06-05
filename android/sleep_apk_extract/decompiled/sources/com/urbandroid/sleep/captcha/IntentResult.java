package com.urbandroid.sleep.captcha;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes4.dex */
public final class IntentResult {
    private final String contents;
    private final String errorCorrectionLevel;
    private final String formatName;
    private final Integer orientation;
    private final byte[] rawBytes;

    public IntentResult(String str, String str2, byte[] bArr, Integer num, String str3) {
        this.contents = str;
        this.formatName = str2;
        this.rawBytes = bArr;
        this.orientation = num;
        this.errorCorrectionLevel = str3;
    }

    public String getContents() {
        return this.contents;
    }

    public String toString() {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(100, "Format: ");
        sbM.append(this.formatName);
        sbM.append("\nContents: ");
        sbM.append(this.contents);
        sbM.append("\nRaw bytes: (");
        byte[] bArr = this.rawBytes;
        sbM.append(bArr == null ? 0 : bArr.length);
        sbM.append(" bytes)\nOrientation: ");
        sbM.append(this.orientation);
        sbM.append("\nEC level: ");
        return FileInsert$$ExternalSyntheticOutline0.m(sbM, this.errorCorrectionLevel, '\n');
    }

    public IntentResult() {
        this(null, null, null, null, null);
    }
}
