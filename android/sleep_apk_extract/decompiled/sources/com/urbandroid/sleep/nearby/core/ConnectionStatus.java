package com.urbandroid.sleep.nearby.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/nearby/core/ConnectionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ConnectionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectionStatus[] $VALUES;
    public static final ConnectionStatus DISCONNECTED = new ConnectionStatus("DISCONNECTED", 0);
    public static final ConnectionStatus CONNECTING = new ConnectionStatus("CONNECTING", 1);
    public static final ConnectionStatus CONNECTED = new ConnectionStatus("CONNECTED", 2);

    private static final /* synthetic */ ConnectionStatus[] $values() {
        return new ConnectionStatus[]{DISCONNECTED, CONNECTING, CONNECTED};
    }

    static {
        ConnectionStatus[] connectionStatusArr$values = $values();
        $VALUES = connectionStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectionStatusArr$values);
    }

    private ConnectionStatus(String str, int i) {
    }

    public static ConnectionStatus valueOf(String str) {
        return (ConnectionStatus) Enum.valueOf(ConnectionStatus.class, str);
    }

    public static ConnectionStatus[] values() {
        return (ConnectionStatus[]) $VALUES.clone();
    }
}
