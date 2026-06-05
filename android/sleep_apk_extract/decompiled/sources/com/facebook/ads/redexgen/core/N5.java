package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public /* synthetic */ class N5 {
    public static final /* synthetic */ int[] A00 = new int[AdPlacementType.values().length];

    static {
        try {
            A00[AdPlacementType.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            A00[AdPlacementType.MEDIUM_RECTANGLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            A00[AdPlacementType.INTERSTITIAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            A00[AdPlacementType.NATIVE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            A00[AdPlacementType.NATIVE_BANNER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            A00[AdPlacementType.REWARDED_VIDEO.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
