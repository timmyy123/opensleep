package com.google.common.hash;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Hashing {
    static final int GOOD_FAST_HASH_SEED = (int) System.currentTimeMillis();

    public static HashFunction murmur3_128() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
