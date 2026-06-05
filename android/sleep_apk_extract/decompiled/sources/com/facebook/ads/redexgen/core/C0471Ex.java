package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0471Ex {
    public static String[] A05 = {"LpJTwMN2G", "VgMO4aUKUhad1vQS8qeWccWG6TZwybQB", "ACcLkDhyx", "Vz4L8Yk2qa8xi00BpA99exXw347yn2OW", "M93qmyVYUpuFuHp", "Ixo", "WCFkueysi57ip8GEP7BFiSRGMX4T5ofH", "LFY6A3GYQmBEHARGrOHSwwc2jPi1aXj0"};
    public final int A00;
    public final C1936pY A01;
    public final Object A02;
    public final C03037s[] A03;
    public final InterfaceC1793nE[] A04;

    public C0471Ex(C03037s[] c03037sArr, InterfaceC1793nE[] interfaceC1793nEArr, C1936pY c1936pY, Object obj) {
        this.A03 = c03037sArr;
        this.A04 = (InterfaceC1793nE[]) interfaceC1793nEArr.clone();
        this.A01 = c1936pY;
        this.A02 = obj;
        this.A00 = c03037sArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(C0471Ex c0471Ex, int i) {
        if (c0471Ex == null) {
            return false;
        }
        C03037s[] c03037sArr = this.A03;
        if (A05[5].length() == 3) {
            A05[1] = "2a41zxf8OUQisEdMYeAN8aC4JNcLEgEy";
            if (!C5C.A1E(c03037sArr[i], c0471Ex.A03[i])) {
                return false;
            }
            InterfaceC1793nE interfaceC1793nE = this.A04[i];
            InterfaceC1793nE interfaceC1793nE2 = c0471Ex.A04[i];
            String[] strArr = A05;
            if (strArr[2].length() == strArr[0].length()) {
                A05[4] = "ShAZgc6gkhlm9OR";
                return C5C.A1E(interfaceC1793nE, interfaceC1793nE2);
            }
        }
        throw new RuntimeException();
    }
}
