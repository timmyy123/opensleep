package com.google.android.gms.internal.p000authapi;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zbbk extends zbbj {
    static final zbbj zba = new zbbk(new Object[0], 0);
    final transient Object[] zbb;
    private final transient int zbc;

    public zbbk(Object[] objArr, int i) {
        this.zbb = objArr;
        this.zbc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zbbd.zba(i, this.zbc, "index");
        Object obj = this.zbb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    public final Object[] zbb() {
        return this.zbb;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    public final int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    public final int zbd() {
        return this.zbc;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbg
    public final boolean zbf() {
        return false;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbbj, com.google.android.gms.internal.p000authapi.zbbg
    public final int zbg(Object[] objArr, int i) {
        Object[] objArr2 = this.zbb;
        int i2 = this.zbc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
