package com.google.home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/ConnectivityState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ONLINE", "OFFLINE", "PARTIALLY_ONLINE", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConnectivityState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectivityState[] $VALUES;
    public static final ConnectivityState UNKNOWN = new ConnectivityState("UNKNOWN", 0);
    public static final ConnectivityState ONLINE = new ConnectivityState("ONLINE", 1);
    public static final ConnectivityState OFFLINE = new ConnectivityState("OFFLINE", 2);
    public static final ConnectivityState PARTIALLY_ONLINE = new ConnectivityState("PARTIALLY_ONLINE", 3);

    private static final /* synthetic */ ConnectivityState[] $values() {
        return new ConnectivityState[]{UNKNOWN, ONLINE, OFFLINE, PARTIALLY_ONLINE};
    }

    static {
        ConnectivityState[] connectivityStateArr$values = $values();
        $VALUES = connectivityStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectivityStateArr$values);
    }

    private ConnectivityState(String str, int i) {
    }

    public static ConnectivityState valueOf(String str) {
        return (ConnectivityState) Enum.valueOf(ConnectivityState.class, str);
    }

    public static ConnectivityState[] values() {
        return (ConnectivityState[]) $VALUES.clone();
    }
}
