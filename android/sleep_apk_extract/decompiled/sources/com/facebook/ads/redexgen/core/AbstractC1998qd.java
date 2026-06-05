package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00070\u0006H\u0001\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"enumEntries", "Lkotlin/enums/EnumEntries;", "T", "", "E", "entriesProvider", "Lkotlin/Function0;", "", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractC1998qd {
    public static byte[] A00;
    public static String[] A01 = {"CFAR5D2KzriYQAsOH0D7pU8M4hZwzvIf", "O0mirbIFzClHmiQexpJCcYhfB2GNllwd", "8sSkOPQI173xL0yddX9GvFbQV9q1hctA", "iek8nxHtxR73nppi5XM6ZxNXB8pcKiAZ", "enbzQ56cd", "WKz9sdTUAmARQIiAGrL3MFtxaOYNqSOQ", "4PpVFsMxGBshPnQvCkcdhqZ", "VEDkRu5LWg5lhF235hZXx"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[1].charAt(25) != '2') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[0] = "jvvklgZz86ILQho3AkuU13PaaICs87Lx";
            strArr[5] = "q8rLmj0eAA9rQJU4cqrTwQQmAb56Km6n";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 107);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{44, 39, 61, 59, 32, 44, 58};
    }

    static {
        A02();
    }

    public static final <E extends Enum<E>> InterfaceC0351Ac<E> A01(E[] eArr) {
        C1995qY.A09(eArr, A00(0, 7, 34));
        return new AnonymousClass13(eArr);
    }
}
