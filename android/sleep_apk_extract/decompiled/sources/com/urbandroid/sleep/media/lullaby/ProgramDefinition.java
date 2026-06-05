package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class ProgramDefinition {
    public static int PREV_REPEAT = -1;
    public static int PROGRAM_DEFINITION_LENGTH = 300;
    private P[] values;

    public ProgramDefinition(P[] pArr) {
        this.values = pArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        r15 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        if (r9 >= r2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        r3[r15] = r7;
        r1.append(r7);
        r1.append(" ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
    
        r15 = r15 + 1;
        r9 = r9 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] generateProgram() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = PROGRAM_DEFINITION_LENGTH;
            int[] iArr = new int[i];
            P[] pArr = this.values;
            int length = pArr.length;
            int i2 = 1;
            int i3 = 20;
            int i4 = 0;
            int i5 = 0;
            loop0: while (true) {
                if (i4 >= length) {
                    break;
                }
                P p = pArr[i4];
                for (int i6 = 0; i6 <= Math.abs(p.to - p.from); i6++) {
                    int i7 = p.to;
                    int i8 = p.from;
                    i3 = i7 >= i8 ? i8 + i6 : i8 - i6;
                    int i9 = p.repeat;
                    if (i9 != PREV_REPEAT) {
                        i2 = i9;
                    }
                    for (int i10 = 0; i10 < i2; i10++) {
                        iArr[i5] = i3;
                        sb.append(i3);
                        sb.append(" ");
                        i5++;
                        if (i5 == i) {
                            break loop0;
                        }
                    }
                }
                i4++;
            }
            return iArr;
        } finally {
            Logger.logInfo("Program ".concat(sb.toString()));
        }
    }
}
