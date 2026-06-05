package j$.time.format;

import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements e {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ h(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public static void a(StringBuilder sb, int i) {
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
    }

    public static int b(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < '0' || cCharAt > '9') {
            return -1;
        }
        return cCharAt - '0';
    }

    @Override // j$.time.format.e
    public final boolean o(x xVar, StringBuilder sb) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Long lA = xVar.a(j$.time.temporal.a.OFFSET_SECONDS);
                if (lA != null) {
                    sb.append("GMT");
                    int intExact = Math.toIntExact(lA.longValue());
                    if (intExact != 0) {
                        int iAbs = Math.abs((intExact / 3600) % 100);
                        int iAbs2 = Math.abs((intExact / 60) % 60);
                        int iAbs3 = Math.abs(intExact % 60);
                        sb.append(intExact < 0 ? "-" : MqttTopic.SINGLE_LEVEL_WILDCARD);
                        if (((f0) obj) != f0.FULL) {
                            if (iAbs >= 10) {
                                sb.append((char) ((iAbs / 10) + 48));
                            }
                            sb.append((char) ((iAbs % 10) + 48));
                            if (iAbs2 != 0 || iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs2);
                                if (iAbs3 != 0) {
                                    sb.append(':');
                                    a(sb, iAbs3);
                                }
                            }
                        } else {
                            a(sb, iAbs);
                            sb.append(':');
                            a(sb, iAbs2);
                            if (iAbs3 != 0) {
                                sb.append(':');
                                a(sb, iAbs3);
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                sb.append((String) obj);
                break;
        }
        return true;
    }

    @Override // j$.time.format.e
    public final int t(v vVar, CharSequence charSequence, int i) {
        int i2;
        int iB;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.a;
        Object obj = this.b;
        switch (i7) {
            case 0:
                int length = charSequence.length();
                if (vVar.g(charSequence, i, "GMT", 0, 3)) {
                    int i8 = i + 3;
                    if (i8 == length) {
                        return vVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i, i8);
                    }
                    char cCharAt = charSequence.charAt(i8);
                    if (cCharAt == '+') {
                        i2 = 1;
                    } else {
                        if (cCharAt != '-') {
                            return vVar.f(j$.time.temporal.a.OFFSET_SECONDS, 0L, i, i8);
                        }
                        i2 = -1;
                    }
                    int i9 = i + 4;
                    int i10 = 0;
                    if (((f0) obj) == f0.FULL) {
                        int i11 = i + 5;
                        int iB2 = b(charSequence, i9);
                        int i12 = i + 6;
                        int iB3 = b(charSequence, i11);
                        if (iB2 >= 0 && iB3 >= 0) {
                            int i13 = i + 7;
                            if (charSequence.charAt(i12) == ':') {
                                iB = (iB2 * 10) + iB3;
                                int iB4 = b(charSequence, i13);
                                i6 = i + 9;
                                int iB5 = b(charSequence, i + 8);
                                if (iB4 >= 0 && iB5 >= 0) {
                                    i5 = (iB4 * 10) + iB5;
                                    int i14 = i + 11;
                                    if (i14 < length && charSequence.charAt(i6) == ':') {
                                        int iB6 = b(charSequence, i + 10);
                                        int iB7 = b(charSequence, i14);
                                        if (iB6 >= 0 && iB7 >= 0) {
                                            i10 = (iB6 * 10) + iB7;
                                            i6 = i + 12;
                                        }
                                    }
                                    i3 = i10;
                                    i4 = i6;
                                }
                            }
                        }
                    } else {
                        int i15 = i + 5;
                        iB = b(charSequence, i9);
                        if (iB >= 0) {
                            if (i15 < length) {
                                int iB8 = b(charSequence, i15);
                                if (iB8 >= 0) {
                                    iB = (iB * 10) + iB8;
                                    i15 = i + 6;
                                }
                                int i16 = i15 + 2;
                                if (i16 < length && charSequence.charAt(i15) == ':' && i16 < length && charSequence.charAt(i15) == ':') {
                                    int iB9 = b(charSequence, i15 + 1);
                                    int iB10 = b(charSequence, i16);
                                    if (iB9 >= 0 && iB10 >= 0) {
                                        i5 = (iB9 * 10) + iB10;
                                        int i17 = i15 + 3;
                                        int i18 = i15 + 5;
                                        if (i18 < length && charSequence.charAt(i17) == ':') {
                                            int iB11 = b(charSequence, i15 + 4);
                                            int iB12 = b(charSequence, i18);
                                            if (iB11 >= 0 && iB12 >= 0) {
                                                i10 = (iB11 * 10) + iB12;
                                                i6 = i15 + 6;
                                                i3 = i10;
                                                i4 = i6;
                                            }
                                        }
                                        i4 = i17;
                                        i3 = 0;
                                    }
                                }
                            }
                            i3 = 0;
                            i4 = i15;
                            return vVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i10) * 60) + (((long) iB) * 3600) + ((long) i3)) * ((long) i2), i, i4);
                        }
                    }
                    i10 = i5;
                    return vVar.f(j$.time.temporal.a.OFFSET_SECONDS, ((((long) i10) * 60) + (((long) iB) * 3600) + ((long) i3)) * ((long) i2), i, i4);
                }
                return ~i;
            default:
                String str = (String) obj;
                if (i > charSequence.length() || i < 0) {
                    throw new IndexOutOfBoundsException();
                }
                return !vVar.g(charSequence, i, str, 0, str.length()) ? ~i : str.length() + i;
        }
    }

    public final String toString() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return "LocalizedOffset(" + ((f0) obj) + ")";
            default:
                return "'" + ((String) obj).replace("'", "''") + "'";
        }
    }
}
