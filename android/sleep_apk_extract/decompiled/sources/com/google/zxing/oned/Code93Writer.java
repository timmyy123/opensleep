package com.google.zxing.oned;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    private static int appendPattern(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 80) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            return null;
        }
        int[] iArr = new int[9];
        int length2 = ((str.length() + 4) * 9) + 1;
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
        boolean[] zArr = new boolean[length2];
        int iAppendPattern = appendPattern(zArr, 0, iArr);
        for (int i = 0; i < length; i++) {
            toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            iAppendPattern += appendPattern(zArr, iAppendPattern, iArr);
        }
        int iComputeChecksumIndex = computeChecksumIndex(str, 20);
        int[] iArr2 = Code93Reader.CHARACTER_ENCODINGS;
        toIntArray(iArr2[iComputeChecksumIndex], iArr);
        int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, iArr);
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str);
        sbM.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex));
        toIntArray(iArr2[computeChecksumIndex(sbM.toString(), 15)], iArr);
        int iAppendPattern3 = iAppendPattern2 + appendPattern(zArr, iAppendPattern2, iArr);
        toIntArray(iArr2[47], iArr);
        zArr[iAppendPattern3 + appendPattern(zArr, iAppendPattern3, iArr)] = true;
        return zArr;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
        return null;
    }
}
