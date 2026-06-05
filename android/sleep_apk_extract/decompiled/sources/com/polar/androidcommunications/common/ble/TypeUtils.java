package com.polar.androidcommunications.common.ble;

import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0012\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lcom/polar/androidcommunications/common/ble/TypeUtils;", "", "<init>", "()V", "", "data", "Lkotlin/UByte;", "convertArrayToUnsignedByte-Wa3L5BU", "([B)B", "convertArrayToUnsignedByte", "", SpotifyService.OFFSET, "length", "Lkotlin/UInt;", "convertArrayToUnsignedInt-_W1zjd8", "([BII)I", "convertArrayToUnsignedInt", "convertArrayToUnsignedInt-OGnWXxg", "([B)I", "Lkotlin/ULong;", "convertArrayToUnsignedLong-qJGtvoU", "([BII)J", "convertArrayToUnsignedLong", "convertArrayToUnsignedLong-I7RO_PI", "([B)J", "convertArrayToSignedInt", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeUtils {
    public static final TypeUtils INSTANCE = new TypeUtils();

    private TypeUtils() {
    }

    public final int convertArrayToSignedInt(byte[] data2) {
        data2.getClass();
        int length = data2.length;
        boolean z = false;
        if (1 <= length && length < 5) {
            z = true;
        }
        BleUtils.validate(z, "Array bigger than 4 cannot be converted to Int. Input data size was " + data2.length);
        int iM896convertArrayToUnsignedIntOGnWXxg = m896convertArrayToUnsignedIntOGnWXxg(data2);
        return ArraysKt.last(data2) < 0 ? UInt.m2389constructorimpl(iM896convertArrayToUnsignedIntOGnWXxg | UInt.m2389constructorimpl((-1) << (data2.length * 8))) : iM896convertArrayToUnsignedIntOGnWXxg;
    }

    /* JADX INFO: renamed from: convertArrayToUnsignedByte-Wa3L5BU, reason: not valid java name */
    public final byte m895convertArrayToUnsignedByteWa3L5BU(byte[] data2) {
        data2.getClass();
        boolean z = data2.length == 1;
        BleUtils.validate(z, "Array other than 1 cannot be converted to UByte. Input data size was " + data2.length);
        return UByte.m2367constructorimpl(data2[0]);
    }

    /* JADX INFO: renamed from: convertArrayToUnsignedInt-OGnWXxg, reason: not valid java name */
    public final int m896convertArrayToUnsignedIntOGnWXxg(byte[] data2) {
        data2.getClass();
        int length = data2.length;
        boolean z = 1 <= length && length < 5;
        BleUtils.validate(z, "Array bigger than 4 cannot be converted to UInt. Input data size was " + data2.length);
        int length2 = data2.length;
        int iM2389constructorimpl = 0;
        for (int i = 0; i < length2; i++) {
            iM2389constructorimpl = UInt.m2389constructorimpl(iM2389constructorimpl | UInt.m2389constructorimpl(UInt.m2389constructorimpl(UByte.m2367constructorimpl(data2[i]) & 255) << (i * 8)));
        }
        return iM2389constructorimpl;
    }

    /* JADX INFO: renamed from: convertArrayToUnsignedInt-_W1zjd8, reason: not valid java name */
    public final int m897convertArrayToUnsignedInt_W1zjd8(byte[] data2, int offset, int length) {
        data2.getClass();
        return m896convertArrayToUnsignedIntOGnWXxg(ArraysKt.copyOfRange(data2, offset, length + offset));
    }

    /* JADX INFO: renamed from: convertArrayToUnsignedLong-I7RO_PI, reason: not valid java name */
    public final long m898convertArrayToUnsignedLongI7RO_PI(byte[] data2) {
        data2.getClass();
        int length = data2.length;
        boolean z = 1 <= length && length < 9;
        BleUtils.validate(z, "Array bigger than 8 cannot be converted to ULong. Input data size was " + data2.length);
        long jM2411constructorimpl = ULong.m2411constructorimpl(0L);
        int length2 = data2.length;
        for (int i = 0; i < length2; i++) {
            jM2411constructorimpl = ULong.m2411constructorimpl(jM2411constructorimpl | ULong.m2411constructorimpl(ULong.m2411constructorimpl(((long) UByte.m2367constructorimpl(data2[i])) & 255) << (i * 8)));
        }
        return jM2411constructorimpl;
    }

    /* JADX INFO: renamed from: convertArrayToUnsignedLong-qJGtvoU, reason: not valid java name */
    public final long m899convertArrayToUnsignedLongqJGtvoU(byte[] data2, int offset, int length) {
        data2.getClass();
        return m898convertArrayToUnsignedLongI7RO_PI(ArraysKt.copyOfRange(data2, offset, length + offset));
    }

    public final int convertArrayToSignedInt(byte[] data2, int offset, int length) {
        data2.getClass();
        return convertArrayToSignedInt(ArraysKt.copyOfRange(data2, offset, length + offset));
    }
}
