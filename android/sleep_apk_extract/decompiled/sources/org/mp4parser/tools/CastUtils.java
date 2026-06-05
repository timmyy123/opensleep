package org.mp4parser.tools;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CastUtils {
    public static int l2i(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        Types$$ExternalSyntheticBUOutline0.m$2(zzba$$ExternalSyntheticOutline0.m("A cast to int has gone wrong. Please contact the mp4parser discussion group (", ")", j));
        return 0;
    }
}
