package io.reactivex.rxjava3.internal.functions;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.reactivex.rxjava3.functions.BiPredicate;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = new BiObjectPredicate();

    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
    }

    public static long verifyPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }

    public static int verifyPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        Gson$$ExternalSyntheticBUOutline0.m(str, " > 0 required but it was ", i);
        return 0;
    }
}
