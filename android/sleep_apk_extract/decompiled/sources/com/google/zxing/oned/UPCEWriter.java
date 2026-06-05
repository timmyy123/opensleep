package com.google.zxing.oned;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class UPCEWriter extends UPCEANWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + UPCEANReader.getStandardUPCEANChecksum(UPCEReader.convertUPCEtoUPCA(str));
            } catch (FormatException e) {
                OggIO$$ExternalSyntheticBUOutline0.m((Throwable) e);
                return null;
            }
        } else {
            if (length != 8) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
                return null;
            }
            try {
                if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Illegal contents");
                return null;
            }
        }
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Number system must be 0 or 1");
            return null;
        }
        int i = UPCEReader.NUMSYS_AND_CHECK_DIGIT_PATTERNS[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iAppendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true);
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit2 = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit2 += 10;
            }
            iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, UPCEANReader.L_AND_G_PATTERNS[iDigit2], false);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, UPCEANReader.END_PATTERN, false);
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can only encode UPC_E, but got ".concat(String.valueOf(barcodeFormat)));
        return null;
    }
}
