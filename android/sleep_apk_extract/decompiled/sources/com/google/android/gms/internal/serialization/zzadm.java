package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public enum zzadm implements zzzk {
    TYPE_UNSPECIFIED(0),
    TRAIT_SUPPORTED(1),
    TRAIT_NOT_SUPPORTED(2),
    OBJECT_TYPE_SUPPORTED(3),
    OBJECT_TYPE_NOT_SUPPORTED(4),
    EXACT_STRING(7),
    UNRECOGNIZED(-1);

    private final int zzh;

    zzadm(int i) {
        this.zzh = i;
    }

    @Override // com.google.android.gms.internal.serialization.zzzk
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.zzh;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(getNumber());
    }
}
