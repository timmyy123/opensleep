package com.google.zxing.aztec.encoder;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Encoder {
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bitMatrix.set(i5, i4);
                    bitMatrix.set(i5, i6);
                    bitMatrix.set(i4, i5);
                    bitMatrix.set(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i3 / 5) + (i2 - 5) + i3;
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AztecCode encode(byte[] bArr, int i, int i2) {
        BitArray bitArrayStuffBits;
        int i3;
        boolean z;
        int iAbs;
        int i4;
        int i5;
        int i6;
        BitArray bitArrayEncode = new HighLevelEncoder(bArr).encode();
        int size = ((bitArrayEncode.getSize() * i) / 100) + 11;
        int size2 = bitArrayEncode.getSize() + size;
        int i7 = 1;
        if (i2 == 0) {
            BitArray bitArrayStuffBits2 = null;
            int i8 = 0;
            int i9 = 0;
            while (i8 <= 32) {
                boolean z2 = i8 <= 3 ? i7 : 0;
                int i10 = z2 != 0 ? i8 + 1 : i8;
                int i11 = totalBitsInLayer(i10, z2);
                if (size2 <= i11) {
                    if (bitArrayStuffBits2 == null || i9 != WORD_SIZE[i10]) {
                        int i12 = WORD_SIZE[i10];
                        i9 = i12;
                        bitArrayStuffBits2 = stuffBits(bitArrayEncode, i12);
                    }
                    int i13 = i11 - (i11 % i9);
                    if ((z2 == 0 || bitArrayStuffBits2.getSize() <= (i9 << 6)) && bitArrayStuffBits2.getSize() + size <= i13) {
                        bitArrayStuffBits = bitArrayStuffBits2;
                        i3 = i9;
                        z = z2;
                        iAbs = i10;
                        i4 = i11;
                    }
                }
                i8++;
                i7 = i7;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Data too large for an Aztec code");
            return null;
        }
        boolean z3 = i2 < 0;
        iAbs = Math.abs(i2);
        if (iAbs > (z3 ? 4 : 32)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i2, "Illegal value ", " for layers"));
            return null;
        }
        i4 = totalBitsInLayer(iAbs, z3);
        i3 = WORD_SIZE[iAbs];
        int i14 = i4 - (i4 % i3);
        bitArrayStuffBits = stuffBits(bitArrayEncode, i3);
        z = z3;
        if (bitArrayStuffBits.getSize() + size > i14) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Data to large for user specified layer");
            return null;
        }
        if (z3) {
            z = z3;
            if (bitArrayStuffBits.getSize() > (i3 << 6)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Data to large for user specified layer");
                return null;
            }
        }
        BitArray bitArrayGenerateCheckWords = generateCheckWords(bitArrayStuffBits, i4, i3);
        int size3 = bitArrayStuffBits.getSize() / i3;
        BitArray bitArrayGenerateModeMessage = generateModeMessage(z, iAbs, size3);
        int i15 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i15];
        int i16 = 2;
        if (z) {
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[i17] = i17;
            }
            i5 = i15;
        } else {
            int i18 = i15 / 2;
            i5 = (((i18 - 1) / 15) * 2) + i15 + 1;
            int i19 = i5 / 2;
            for (int i20 = 0; i20 < i18; i20++) {
                iArr[(i18 - i20) - i7] = (i19 - r14) - 1;
                iArr[i18 + i20] = (i20 / 15) + i20 + i19 + i7;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i5);
        int i21 = 0;
        int i22 = 0;
        while (i21 < iAbs) {
            int i23 = ((iAbs - i21) << i16) + (z ? 9 : 12);
            for (int i24 = 0; i24 < i23; i24++) {
                int i25 = i24 << 1;
                int i26 = 0;
                while (i26 < i16) {
                    int i27 = i16;
                    if (bitArrayGenerateCheckWords.get(i22 + i25 + i26)) {
                        int i28 = i21 << 1;
                        i6 = i7;
                        bitMatrix.set(iArr[i28 + i26], iArr[i28 + i24]);
                    } else {
                        i6 = i7;
                    }
                    if (bitArrayGenerateCheckWords.get((i23 << 1) + i22 + i25 + i26)) {
                        int i29 = i21 << 1;
                        bitMatrix.set(iArr[i29 + i24], iArr[((i15 - 1) - i29) - i26]);
                    }
                    if (bitArrayGenerateCheckWords.get((i23 << 2) + i22 + i25 + i26)) {
                        int i30 = (i15 - 1) - (i21 << 1);
                        bitMatrix.set(iArr[i30 - i26], iArr[i30 - i24]);
                    }
                    if (bitArrayGenerateCheckWords.get((i23 * 6) + i22 + i25 + i26)) {
                        int i31 = i21 << 1;
                        bitMatrix.set(iArr[((i15 - 1) - i31) - i24], iArr[i31 + i26]);
                    }
                    i26++;
                    i16 = i27;
                    i7 = i6;
                }
            }
            i22 += i23 << 3;
            i21++;
            i16 = i16;
        }
        drawModeMessage(bitMatrix, z, i5, bitArrayGenerateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i5 / 2, 5);
        } else {
            int i32 = i5 / 2;
            drawBullsEye(bitMatrix, i32, 7);
            int i33 = 0;
            int i34 = 0;
            while (i34 < (i15 / 2) - 1) {
                for (int i35 = i32 & 1; i35 < i5; i35 += 2) {
                    int i36 = i32 - i33;
                    bitMatrix.set(i36, i35);
                    int i37 = i32 + i33;
                    bitMatrix.set(i37, i35);
                    bitMatrix.set(i35, i36);
                    bitMatrix.set(i35, i37);
                }
                i34 += 15;
                i33 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i5);
        aztecCode.setLayers(iAbs);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] iArrBitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(iArrBitsToWords, i3 - size);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int i4 : iArrBitsToWords) {
            bitArray2.appendBits(i4, i2);
        }
        return bitArray2;
    }

    public static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i) {
        if (i == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Unsupported word size ".concat(String.valueOf(i)));
        return null;
    }

    public static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
