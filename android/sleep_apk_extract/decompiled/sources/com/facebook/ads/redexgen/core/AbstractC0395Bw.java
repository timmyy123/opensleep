package com.facebook.ads.redexgen.core;

import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0395Bw extends AbstractC1615k6<String> {
    public static String[] A05 = {"Y6GgR6t8IKI", "VFkkD7m5TZieTdIGcMhjlI6kmFQATLKN", "mG5qNJ2cuZKVjOSNlAyh8B4xR9rE0ZKh", "CM7cohX4W2k9cinGHwlxigjKg6gGPkMn", "nFCnUuwWiAgAe84yG3jEJO62AyGyzlur", "7r", "4QyinOl4Or1zHXh0KCFmZglNOrfMdCYS", "IPc7SPgKd69USKaPje1bIKNcFeLlsWuv"};
    public int A00;
    public int A01 = 0;
    public final CC A02;
    public final CharSequence A03;
    public final boolean A04;

    public abstract int A04(int separatorPosition);

    public abstract int A05(int start);

    public AbstractC0395Bw(C1658kp splitter, CharSequence toSplit) {
        this.A02 = splitter.A01;
        this.A04 = splitter.A03;
        this.A00 = splitter.A00;
        this.A03 = toSplit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    @Override // com.facebook.ads.redexgen.core.AbstractC1615k6
    @CheckForNull
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String A03() {
        int i = this.A01;
        while (nextStart != -1) {
            int nextStart = this.A01;
            int separatorPosition = A05(nextStart);
            if (separatorPosition == -1) {
                separatorPosition = this.A03.length();
                this.A01 = -1;
            } else {
                int nextStart2 = A04(separatorPosition);
                this.A01 = nextStart2;
            }
            int nextStart3 = this.A01;
            if (nextStart3 == i) {
                int nextStart4 = this.A01;
                this.A01 = nextStart4 + 1;
                int start = this.A01;
                int nextStart5 = this.A03.length();
                if (start > nextStart5) {
                    this.A01 = -1;
                }
            } else {
                while (i < separatorPosition && this.A02.A09(this.A03.charAt(i))) {
                    i++;
                }
                while (separatorPosition > i) {
                    int nextStart6 = separatorPosition - 1;
                    if (!this.A02.A09(this.A03.charAt(nextStart6))) {
                        break;
                    }
                    separatorPosition--;
                }
                boolean z = this.A04;
                int start2 = A05[7].charAt(13);
                if (start2 == 89) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[5] = "Ef";
                strArr[0] = "Em1AIG0CRO3";
                if (z && i == separatorPosition) {
                    i = this.A01;
                } else {
                    int i2 = this.A00;
                    String[] strArr2 = A05;
                    String str = strArr2[3];
                    String str2 = strArr2[1];
                    int start3 = str.charAt(15);
                    int nextStart7 = str2.charAt(15);
                    if (start3 == nextStart7) {
                        String[] strArr3 = A05;
                        strArr3[3] = "tCIj44jeXfrUIeKGqWzYJFtUtJKCQpO9";
                        strArr3[1] = "3BTz6P6YlFAqNOcGdApEEEFNm8KDvcbh";
                        if (i2 == 1) {
                        }
                    } else if (i2 == 1) {
                        separatorPosition = this.A03.length();
                        String[] strArr4 = A05;
                        String str3 = strArr4[4];
                        String str4 = strArr4[6];
                        int start4 = str3.charAt(10);
                        int nextStart8 = str4.charAt(10);
                        if (start4 != nextStart8) {
                            String[] strArr5 = A05;
                            strArr5[4] = "SuB8QNIalYE0K4C3aNFCBNECGLTpXTA5";
                            strArr5[6] = "ZMjLx3riby3c0ZsVFXnt0BJdbQ1Fsr1P";
                            this.A01 = -1;
                        } else {
                            A05[7] = "d3Q1ejutGvqDbQDKCEC2qDkOl0TUQWTa";
                            this.A01 = -1;
                        }
                        while (separatorPosition > i) {
                            int nextStart9 = separatorPosition - 1;
                            if (!this.A02.A09(this.A03.charAt(nextStart9))) {
                                break;
                            }
                            separatorPosition--;
                        }
                    } else {
                        int nextStart10 = this.A00;
                        this.A00 = nextStart10 - 1;
                    }
                    return this.A03.subSequence(i, separatorPosition).toString();
                }
            }
        }
        return A02();
    }
}
