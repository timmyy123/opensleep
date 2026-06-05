package kotlin.uuid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a3\u0010\r\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlin/uuid/Uuid;", "uuid", "", "serializedUuid", "(Lkotlin/uuid/Uuid;)Ljava/lang/Object;", "", "", "dst", "", "dstOffset", "startIndex", "endIndex", "", "formatBytesInto", "(J[BIII)V", "", "hexDashString", "uuidParseHexDash", "(Ljava/lang/String;)Lkotlin/uuid/Uuid;", "hexString", "uuidParseHex", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
abstract class UuidKt__UuidJVMKt {
    public static final void formatBytesInto(long j, byte[] bArr, int i, int i2, int i3) {
        bArr.getClass();
        UuidKt__UuidKt.formatBytesIntoCommonImpl(j, bArr, i, i2, i3);
    }

    public static final Object serializedUuid(Uuid uuid) {
        uuid.getClass();
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final Uuid uuidParseHex(String str) {
        str.getClass();
        return UuidKt__UuidKt.uuidParseHexCommonImpl(str);
    }

    public static final Uuid uuidParseHexDash(String str) {
        str.getClass();
        return UuidKt__UuidKt.uuidParseHexDashCommonImpl(str);
    }
}
