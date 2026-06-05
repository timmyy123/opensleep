package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandServiceToClient;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "ONLINE_MEASUREMENT_STOPPED", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdControlPointCommandServiceToClient {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PmdControlPointCommandServiceToClient[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PmdControlPointCommandServiceToClient ONLINE_MEASUREMENT_STOPPED = new PmdControlPointCommandServiceToClient("ONLINE_MEASUREMENT_STOPPED", 0, 1);
    private final int code;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandServiceToClient$Companion;", "", "()V", "fromByte", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandServiceToClient;", "cpByte", "", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PmdControlPointCommandServiceToClient fromByte(byte cpByte) {
            int i = cpByte & 255;
            for (PmdControlPointCommandServiceToClient pmdControlPointCommandServiceToClient : PmdControlPointCommandServiceToClient.values()) {
                if (pmdControlPointCommandServiceToClient.getCode() == i) {
                    return pmdControlPointCommandServiceToClient;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PmdControlPointCommandServiceToClient[] $values() {
        return new PmdControlPointCommandServiceToClient[]{ONLINE_MEASUREMENT_STOPPED};
    }

    static {
        PmdControlPointCommandServiceToClient[] pmdControlPointCommandServiceToClientArr$values = $values();
        $VALUES = pmdControlPointCommandServiceToClientArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pmdControlPointCommandServiceToClientArr$values);
        INSTANCE = new Companion(null);
    }

    private PmdControlPointCommandServiceToClient(String str, int i, int i2) {
        this.code = i2;
    }

    public static PmdControlPointCommandServiceToClient valueOf(String str) {
        return (PmdControlPointCommandServiceToClient) Enum.valueOf(PmdControlPointCommandServiceToClient.class, str);
    }

    public static PmdControlPointCommandServiceToClient[] values() {
        return (PmdControlPointCommandServiceToClient[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
