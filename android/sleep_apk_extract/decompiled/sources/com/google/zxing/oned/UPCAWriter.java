package com.google.zxing.oned;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCAWriter implements Writer {
    private final EAN13Writer subWriter = new EAN13Writer();

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.subWriter.encode(AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str)), BarcodeFormat.EAN_13, i, i2, map);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
        return null;
    }
}
