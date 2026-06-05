package com.google.home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/home/PermissionsResultStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "CANCELLED", "ERROR", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionsResultStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionsResultStatus[] $VALUES;
    public static final PermissionsResultStatus SUCCESS = new PermissionsResultStatus("SUCCESS", 0);
    public static final PermissionsResultStatus CANCELLED = new PermissionsResultStatus("CANCELLED", 1);
    public static final PermissionsResultStatus ERROR = new PermissionsResultStatus("ERROR", 2);

    private static final /* synthetic */ PermissionsResultStatus[] $values() {
        return new PermissionsResultStatus[]{SUCCESS, CANCELLED, ERROR};
    }

    static {
        PermissionsResultStatus[] permissionsResultStatusArr$values = $values();
        $VALUES = permissionsResultStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(permissionsResultStatusArr$values);
    }

    private PermissionsResultStatus(String str, int i) {
    }

    public static PermissionsResultStatus valueOf(String str) {
        return (PermissionsResultStatus) Enum.valueOf(PermissionsResultStatus.class, str);
    }

    public static PermissionsResultStatus[] values() {
        return (PermissionsResultStatus[]) $VALUES.clone();
    }
}
