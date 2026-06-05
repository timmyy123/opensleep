package com.google.home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/PermissionsState;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "NOT_GRANTED", "PERMISSIONS_STATE_UNAVAILABLE", "PERMISSIONS_STATE_UNINITIALIZED", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionsState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionsState[] $VALUES;
    public static final PermissionsState GRANTED = new PermissionsState("GRANTED", 0);
    public static final PermissionsState NOT_GRANTED = new PermissionsState("NOT_GRANTED", 1);
    public static final PermissionsState PERMISSIONS_STATE_UNAVAILABLE = new PermissionsState("PERMISSIONS_STATE_UNAVAILABLE", 2);
    public static final PermissionsState PERMISSIONS_STATE_UNINITIALIZED = new PermissionsState("PERMISSIONS_STATE_UNINITIALIZED", 3);

    private static final /* synthetic */ PermissionsState[] $values() {
        return new PermissionsState[]{GRANTED, NOT_GRANTED, PERMISSIONS_STATE_UNAVAILABLE, PERMISSIONS_STATE_UNINITIALIZED};
    }

    static {
        PermissionsState[] permissionsStateArr$values = $values();
        $VALUES = permissionsStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(permissionsStateArr$values);
    }

    private PermissionsState(String str, int i) {
    }

    public static PermissionsState valueOf(String str) {
        return (PermissionsState) Enum.valueOf(PermissionsState.class, str);
    }

    public static PermissionsState[] values() {
        return (PermissionsState[]) $VALUES.clone();
    }
}
