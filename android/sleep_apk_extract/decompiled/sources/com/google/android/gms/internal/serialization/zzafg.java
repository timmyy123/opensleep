package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public enum zzafg implements zzzk {
    AUTH_STATE_UNSPECIFIED(0),
    AUTH_STATE_AUTHENTICATED(1),
    AUTH_STATE_UNAUTHENTICATED(2),
    UNRECOGNIZED(-1);

    private final int zze;

    zzafg(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.serialization.zzzk
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.zze;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(getNumber());
    }
}
