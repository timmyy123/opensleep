package com.google.home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/google/home/LocalityType;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "DIRECT", "PEER", "REMOTE", "MIXED", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalityType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LocalityType[] $VALUES;
    public static final LocalityType UNSPECIFIED = new LocalityType("UNSPECIFIED", 0);
    public static final LocalityType DIRECT = new LocalityType("DIRECT", 1);
    public static final LocalityType PEER = new LocalityType("PEER", 2);
    public static final LocalityType REMOTE = new LocalityType("REMOTE", 3);
    public static final LocalityType MIXED = new LocalityType("MIXED", 4);

    private static final /* synthetic */ LocalityType[] $values() {
        return new LocalityType[]{UNSPECIFIED, DIRECT, PEER, REMOTE, MIXED};
    }

    static {
        LocalityType[] localityTypeArr$values = $values();
        $VALUES = localityTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(localityTypeArr$values);
    }

    private LocalityType(String str, int i) {
    }

    public static LocalityType valueOf(String str) {
        return (LocalityType) Enum.valueOf(LocalityType.class, str);
    }

    public static LocalityType[] values() {
        return (LocalityType[]) $VALUES.clone();
    }
}
