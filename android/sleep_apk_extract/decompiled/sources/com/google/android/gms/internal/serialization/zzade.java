package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public enum zzade implements zzzk {
    EVENT_IMPORTANCE_UNSPECIFIED(0),
    EVENT_IMPORTANCE_PRODUCTION_CRITICAL(1),
    EVENT_IMPORTANCE_PRODUCTION_STANDARD(2),
    EVENT_IMPORTANCE_INFO(3),
    EVENT_IMPORTANCE_DEBUG(4),
    UNRECOGNIZED(-1);

    private final int zzg;

    zzade(int i) {
        this.zzg = i;
    }

    @Override // com.google.android.gms.internal.serialization.zzzk
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.zzg;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(getNumber());
    }
}
