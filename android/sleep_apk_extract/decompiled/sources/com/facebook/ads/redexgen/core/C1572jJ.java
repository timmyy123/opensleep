package com.facebook.ads.redexgen.core;

import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$CreatingEvent;", "", "timeMs", "", "isVideo", "", "codecName", "", ShareConstants.FEED_SOURCE_PARAM, "Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "<init>", "(JZLjava/lang/String;Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;)V", "getTimeMs", "()J", "()Z", "getCodecName", "()Ljava/lang/String;", "getSource", "()Lcom/facebook/video/heroplayer/exocustom/MediaCodecPoolTracker$Source;", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1572jJ {
    public static byte[] A04;
    public static String[] A05 = {"FdJsnjKhTHlRRZJsIFJWfCFzDWj0EqEQ", "oDI6LLqtxTHYYroBPkpD1FGx8rMeQ43n", "nlfwyCf1dimp0Krp16vrJ7MqKa9LBcpB", "eJAHNFq1OwqAaXsvDo9s6AkeG9akNcus", "1DIZmXcKgSC14jfFcgqN4PxJzEVkuxyt", "Jm4JVeQO5B6WQGQYARoPg9oMTbSP82vf", "cNIPfDtzZYrRRS6cyr8Z3qTZk6c2gOD8", "3wJHcoy4TgbkzWEHR"};
    public final long A00;
    public final EnumC1574jL A01;
    public final String A02;
    public final boolean A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[7].length() == 28) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "eLKf7avg3Muh8C7yGH81adsNP2b5Zl22";
            strArr[2] = "Hs4ShvoKAnPy3QOup7XkprNsl61FjOhV";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 37;
            String[] strArr2 = A05;
            if (strArr2[3].charAt(20) != strArr2[2].charAt(20)) {
                String[] strArr3 = A05;
                strArr3[6] = "pmIQjq0HOs5rGfK0IVnzbRqQA9jP3AeW";
                strArr3[1] = "UvIaysu1mB6kOnFi13Y0WsJ66WIV2xdb";
                bArrCopyOfRange[i4] = (byte) i5;
                i4++;
            } else {
                bArrCopyOfRange[i4] = (byte) i5;
                i4++;
            }
        }
    }

    public static void A01() {
        A04 = new byte[]{122, 118, 125, 124, 122, 87, 120, 116, 124, 89, 69, 95, 88, 73, 79};
    }

    static {
        A01();
    }

    public C1572jJ(long j, boolean z, String str, EnumC1574jL enumC1574jL) {
        C1995qY.A09(str, A00(0, 9, 60));
        C1995qY.A09(enumC1574jL, A00(9, 6, 15));
        this.A00 = j;
        this.A03 = z;
        this.A02 = str;
        this.A01 = enumC1574jL;
    }
}
