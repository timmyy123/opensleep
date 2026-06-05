package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import com.google.android.gms.internal.serialization.zzzm;

/* JADX INFO: loaded from: classes4.dex */
public enum NullValue implements zzzk {
    NULL_VALUE(0);

    private static final zzzl<NullValue> internalValueMap = new zzzl<NullValue>() { // from class: com.google.home.platform.traits.NullValue.1
        @Override // com.google.android.gms.internal.serialization.zzzl
        public NullValue findValueByNumber(int i) {
            return NullValue.forNumber(i);
        }
    };
    private final int value;

    public static final class NullValueVerifier implements zzzm {
        static final zzzm INSTANCE = new NullValueVerifier();

        private NullValueVerifier() {
        }

        @Override // com.google.android.gms.internal.serialization.zzzm
        public boolean isInRange(int i) {
            return NullValue.forNumber(i) != null;
        }
    }

    NullValue(int i) {
        this.value = i;
    }

    public static NullValue forNumber(int i) {
        if (i != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static zzzm internalGetVerifier() {
        return NullValueVerifier.INSTANCE;
    }

    @Override // com.google.android.gms.internal.serialization.zzzk
    public final int getNumber() {
        return this.value;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(getNumber());
    }
}
