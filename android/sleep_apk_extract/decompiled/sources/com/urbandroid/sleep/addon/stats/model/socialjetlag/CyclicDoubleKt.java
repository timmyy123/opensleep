package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.facebook.AuthenticationTokenClaims;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u0013\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a%\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\b\u001a%\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\b\u001a5\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u0012¨\u0006\u0013"}, d2 = {"", "x", "cycle", "normalize", "(DD)D", "fixRoundingErrors", "y", AuthenticationTokenClaims.JSON_KEY_SUB, "(DDD)D", "distance", "refPoint", "signedDistance", "weightX", "weightY", "center", "(DDDDD)D", "", "xs", "([DD)D", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CyclicDoubleKt {
    public static final double center(double d, double d2, double d3, double d4, double d5) {
        if (d2 < 0.0d) {
            Home$$ExternalSyntheticBUOutline0.m("weightX must be non-negative: ", d2);
            return 0.0d;
        }
        if (d4 < 0.0d) {
            Home$$ExternalSyntheticBUOutline0.m("weightY must be non-negative: ", d4);
            return 0.0d;
        }
        double dNormalize = normalize(d, d5);
        double dNormalize2 = normalize(d3, d5);
        double dDistance = distance(dNormalize, dNormalize2, d5);
        return dNormalize < dNormalize2 ? dNormalize2 - dNormalize < d5 / 2.0d ? normalize(((dDistance * d4) / (d2 + d4)) + dNormalize, d5) : normalize(dNormalize - ((dDistance * d4) / (d2 + d4)), d5) : dNormalize - dNormalize2 < d5 / 2.0d ? normalize(((dDistance * d2) / (d2 + d4)) + dNormalize2, d5) : normalize(dNormalize2 - ((dDistance * d2) / (d2 + d4)), d5);
    }

    public static final double distance(double d, double d2, double d3) {
        return Math.min(sub(d, d2, d3), sub(d2, d, d3));
    }

    private static final double fixRoundingErrors(double d, double d2) {
        if (d < 0.0d || d >= d2) {
            return 0.0d;
        }
        return d;
    }

    public static final double normalize(double d, double d2) {
        if (d2 > 0.0d) {
            return d >= 0.0d ? d < d2 ? d : fixRoundingErrors(d - (Math.floor(d / d2) * d2), d2) : d > (-d2) ? fixRoundingErrors(d + d2, d2) : fixRoundingErrors((d2 + d) - (Math.ceil(d / d2) * d2), d2);
        }
        Home$$ExternalSyntheticBUOutline0.m("Cycle must be positive: ", d2);
        return 0.0d;
    }

    public static final double signedDistance(double d, double d2, double d3) {
        double dNormalize = normalize(d, d3);
        double dNormalize2 = normalize(d2, d3);
        double dDistance = distance(dNormalize, dNormalize2, d3);
        if (dNormalize < dNormalize2) {
            if (dNormalize2 - dNormalize < d3 / 2.0d) {
                return -dDistance;
            }
        } else if (dNormalize - dNormalize2 >= d3 / 2.0d) {
            return -dDistance;
        }
        return dDistance;
    }

    public static final double sub(double d, double d2, double d3) {
        return normalize(d - d2, d3);
    }

    public static final double center(double[] dArr, double d) {
        dArr.getClass();
        if (dArr.length == 0) {
            return Double.NaN;
        }
        double d2 = dArr[0];
        int length = dArr.length;
        double dCenter = d2;
        for (int i = 1; i < length; i++) {
            dCenter = center(dCenter, i, dArr[i], 1.0d, d);
        }
        return dCenter;
    }
}
