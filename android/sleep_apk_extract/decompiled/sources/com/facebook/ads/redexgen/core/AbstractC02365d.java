package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC02365d {
    public static void A00(InterfaceC1917pF interfaceC1917pF) {
        if (interfaceC1917pF != null) {
            try {
                interfaceC1917pF.close();
            } catch (IOException unused) {
            }
        }
    }
}
