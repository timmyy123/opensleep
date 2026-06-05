package com.google.android.gms.internal.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public enum zzaet implements zzzk {
    CHANGE_TYPE_UNSPECIFIED(0),
    CHANGE_TYPE_TRANSPORT_DISCONNECTED(1),
    CHANGE_TYPE_PERMISSIONS_UPDATED(2),
    CHANGE_TYPE_DATA_RECOMPUTATION_REQUIRED(3),
    CHANGE_TYPE_CONNECTIVITY_UPDATED(4),
    UNRECOGNIZED(-1);

    private final int zzg;

    zzaet(int i) {
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
