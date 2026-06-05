package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class WP implements Runnable {
    public static String[] A00 = {"Sq0yZcwOgTGXIMbLXRKfOSdr7WdDOtyr", "WnfyQ5g3TOMlbPuUI1S38a6tMB", "BxTfzMbMUk2Qmg34ayslQfc8Uzo4QxVA", "G4BpHh0l6RWcqwLcVWEAByBTvG", "Wi1pgJHqhNt1rkC03e0JnQGSkCoA4pQ8", "kTE0MmPx9fRa1cZyXVlJ3kyazaX8qf2", "b5YZOJ5Dove32nH3VcyYtuQbqE02hip", "2Ait9FMgROtB2NZo6j3UC5dnhoYmjwMQ"};
    public static final AtomicReference<Throwable> A01 = new AtomicReference<>();

    public abstract void A01();

    public static Throwable A00() {
        Throwable th = A01.get();
        String[] strArr = A00;
        if (strArr[6].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[6] = "SrEDgE7BL0uBLmhOMBZPSVpD24D14xc";
        strArr2[5] = "UbLf4323SSK9wFof04kcdZ3h6JYQV0q";
        return th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            A01();
        } catch (Throwable th) {
            A01.set(th);
            throw th;
        }
    }
}
