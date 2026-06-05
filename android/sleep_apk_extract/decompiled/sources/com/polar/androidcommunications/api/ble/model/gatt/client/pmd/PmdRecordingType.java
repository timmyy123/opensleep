package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u0007j\u0002\b\fj\u0002\b\r\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdRecordingType;", "", "Lkotlin/UByte;", "numVal", "<init>", "(Ljava/lang/String;IB)V", "asBitField-w2LRezQ", "()B", "asBitField", "B", "getNumVal-w2LRezQ", "Companion", "ONLINE", "OFFLINE", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdRecordingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PmdRecordingType[] $VALUES;
    private final byte numVal;
    public static final PmdRecordingType ONLINE = new PmdRecordingType("ONLINE", 0, (byte) 0);
    public static final PmdRecordingType OFFLINE = new PmdRecordingType("OFFLINE", 1, (byte) 1);

    private static final /* synthetic */ PmdRecordingType[] $values() {
        return new PmdRecordingType[]{ONLINE, OFFLINE};
    }

    static {
        PmdRecordingType[] pmdRecordingTypeArr$values = $values();
        $VALUES = pmdRecordingTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pmdRecordingTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private PmdRecordingType(String str, int i, byte b) {
        this.numVal = b;
    }

    public static PmdRecordingType valueOf(String str) {
        return (PmdRecordingType) Enum.valueOf(PmdRecordingType.class, str);
    }

    public static PmdRecordingType[] values() {
        return (PmdRecordingType[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: asBitField-w2LRezQ, reason: not valid java name */
    public final byte m884asBitFieldw2LRezQ() {
        return UByte.m2367constructorimpl((byte) UInt.m2389constructorimpl(UInt.m2389constructorimpl(this.numVal & 255) << 7));
    }
}
