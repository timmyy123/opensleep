package kotlinx.io.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.Regex$$ExternalSyntheticBUOutline0;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "beginIndex", "endIndex", "", "commonToUtf8String", "([BII)Ljava/lang/String;", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class _Utf8Kt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[PHI: r6
      0x0069: PHI (r6v32 int) = (r6v5 int), (r6v20 int), (r6v20 int), (r6v23 int), (r6v31 int), (r6v40 int), (r6v41 int) binds: [B:93:0x0167, B:67:0x00f2, B:69:0x00f8, B:56:0x00c9, B:41:0x0090, B:29:0x0061, B:28:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        bArr.getClass();
        if (i6 < 0 || i2 > bArr.length || i6 > i2) {
            StringBuilder sb = new StringBuilder("size=");
            Fragment$$ExternalSyntheticOutline1.m(sb, bArr.length, " beginIndex=", i6, " endIndex=");
            Regex$$ExternalSyntheticBUOutline0.m(sb, i2);
            return null;
        }
        char[] cArr = new char[i2 - i6];
        int i7 = 0;
        while (i6 < i2) {
            byte b = bArr[i6];
            if (b >= 0) {
                int i8 = i7 + 1;
                cArr[i7] = (char) b;
                i6++;
                while (i6 < i2) {
                    byte b2 = bArr[i6];
                    if (b2 < 0) {
                        break;
                    }
                    i6++;
                    cArr[i8] = (char) b2;
                    i8++;
                }
                Unit unit = Unit.INSTANCE;
                i7 = i8;
            } else {
                if ((b >> 5) == -2) {
                    int i9 = i6 + 1;
                    if (i2 <= i9) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                    } else {
                        byte b3 = bArr[i9];
                        if ((b3 & 192) == 128) {
                            int i10 = (b << 6) ^ (b3 ^ 3968);
                            if (i10 < 128) {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                int i11 = i7 + 1;
                                cArr[i7] = (char) i10;
                                Unit unit3 = Unit.INSTANCE;
                                i3 = i11;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                        }
                    }
                    Unit unit4 = Unit.INSTANCE;
                } else if ((b >> 4) == -2) {
                    int i12 = i6 + 2;
                    if (i2 <= i12) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                        Unit unit5 = Unit.INSTANCE;
                        int i13 = i6 + 1;
                        i5 = (i2 <= i13 || (bArr[i13] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b4 = bArr[i6 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i12];
                            if ((b5 & 192) == 128) {
                                int i14 = (b << MqttWireMessage.MESSAGE_TYPE_PINGREQ) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                                if (i14 < 2048) {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                } else if (55296 > i14 || i14 >= 57344) {
                                    int i15 = i7 + 1;
                                    cArr[i7] = (char) i14;
                                    Unit unit6 = Unit.INSTANCE;
                                    i3 = i15;
                                    i5 = 3;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                }
                                Unit unit7 = Unit.INSTANCE;
                                i5 = 3;
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                                Unit unit8 = Unit.INSTANCE;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                            Unit unit9 = Unit.INSTANCE;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i16 = i6 + 3;
                    if (i2 <= i16) {
                        i3 = i7 + 1;
                        cArr[i7] = 65533;
                        Unit unit10 = Unit.INSTANCE;
                        int i17 = i6 + 1;
                        if (i2 > i17 && (bArr[i17] & 192) == 128) {
                            int i18 = i6 + 2;
                            if (i2 > i18 && (bArr[i18] & 192) == 128) {
                                i5 = 3;
                            }
                        }
                    } else {
                        byte b6 = bArr[i6 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i6 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i16];
                                if ((b8 & 192) == 128) {
                                    int i19 = (b << 18) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << MqttWireMessage.MESSAGE_TYPE_PINGREQ));
                                    if (i19 > 1114111) {
                                        i3 = i7 + 1;
                                        cArr[i7] = 65533;
                                    } else if ((55296 > i19 || i19 >= 57344) && i19 >= 65536) {
                                        if (i19 != 65533) {
                                            cArr[i7] = (char) ((i19 >>> 10) + 55232);
                                            i4 = i7 + 2;
                                            cArr[i7 + 1] = (char) ((i19 & 1023) + 56320);
                                        } else {
                                            cArr[i7] = 65533;
                                            i4 = i7 + 1;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        i3 = i4;
                                        i5 = 4;
                                    } else {
                                        i3 = i7 + 1;
                                        cArr[i7] = 65533;
                                    }
                                    Unit unit12 = Unit.INSTANCE;
                                    i5 = 4;
                                } else {
                                    i3 = i7 + 1;
                                    cArr[i7] = 65533;
                                    Unit unit13 = Unit.INSTANCE;
                                    i5 = 3;
                                }
                            } else {
                                i3 = i7 + 1;
                                cArr[i7] = 65533;
                                Unit unit14 = Unit.INSTANCE;
                            }
                        } else {
                            i3 = i7 + 1;
                            cArr[i7] = 65533;
                            Unit unit15 = Unit.INSTANCE;
                        }
                    }
                } else {
                    i3 = i7 + 1;
                    cArr[i7] = 65533;
                    i6++;
                    i7 = i3;
                }
                i6 += i5;
                i7 = i3;
            }
        }
        return StringsKt.concatToString(cArr, 0, i7);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
