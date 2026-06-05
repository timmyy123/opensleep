package com.facebook.ads.redexgen.core;

import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RV implements Comparator<Thread> {
    public static String[] A02 = {"I2VmByDixuV", "bEgjeHiCKL8bN0Y2xmhvt", "Ep8bZoaW9qgdmenOEM", "U1x4f2Mle4YpVecP", "6pFKFCdnQFQQrPpkBrBSvGNPTjtJIqqH", "uR6rFONyTXbT3WTsrhnl74", "HWYTd9Yr1UQKCKQrjsxmT8cIIu2", "gbeo1KbNmS02dvrZyrXpgnCOAkkwIw0y"};
    public final /* synthetic */ RW A00;
    public final /* synthetic */ Thread A01;

    public RV(RW rw, Thread thread) {
        this.A00 = rw;
        this.A01 = thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(Thread thread, Thread thread2) {
        if (thread != thread2) {
            if (thread == this.A01) {
                return -1;
            }
            if (thread2 == this.A01) {
                return 1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
        String[] strArr = A02;
        if (strArr[2].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        A02[6] = "KlossopSTK0WgZ36dTrk3tViYspVBMBU";
        return 0;
    }
}
