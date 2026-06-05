package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.An, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC0360An {
    public static String[] A00 = {"VStuONYpXyrMGhumGQCd4bHjLXsNGp", "S1S3Jkw9LUb6cnfGpNPRKNDuu8", "2Ke6uX99C2Ej86uaQGDkeBX7MGwE90Sm", "dgZWZs76mC1kc7pglMOV4zGYG00Fgfg1", "zUp6mo1SLV7D1o1luAQ3GrC3onIbmqNA", "JcKr7RKMAl41fNyv8geFl14jFO0goPB3", "MpC9eEu67wFQV2mBNkYCIiAxmHcER7Xb", "vtL7ulxwpA8TBFBRvxP"};

    public static /* synthetic */ boolean A00(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                if (A00[6].charAt(15) == 'T') {
                    throw new RuntimeException();
                }
                A00[6] = "DqCazpM1ekD0ZgQHfzEk4TgsAWjX7kxP";
                return false;
            }
        }
        return true;
    }
}
