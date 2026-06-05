package kotlin.time;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\t\u001a)\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0018\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001b\u001a\u00020\u0006*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001d\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001d\u0010\u0007\u001a\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u001d\u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010 \u001a\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010$\u001a\u0017\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010$\u001a\u0017\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010$\u001a\u001f\u0010-\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010$\u001a\u0017\u00100\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010$\"\u001e\u00105\u001a\u00020\b*\u00020\u00018BX\u0082\u0004¢\u0006\f\u0012\u0004\b3\u00104\u001a\u0004\b1\u00102\"\u0018\u00108\u001a\u00020\u0006*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107\"\u0018\u0010;\u001a\u00020\u0000*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "", SDKConstants.PARAM_VALUE, "", "strictIso", "throwException", "parseDuration", "(Ljava/lang/String;ZZ)J", "startIndex", "parseIsoStringFormat", "(Ljava/lang/String;IZ)J", "hasSign", "parseDefaultStringFormat", "(Ljava/lang/String;IZZ)J", "other", "addMillisWithoutOverflow", "(JJ)J", "endIndex", "parseFractionFallback", "(Ljava/lang/String;IILkotlin/time/DurationUnit;)J", "fractionDigitsToNanos", "start", "defaultDurationUnitByShortNameOrNull", "(Ljava/lang/String;I)Lkotlin/time/DurationUnit;", "isoDurationUnitByShortNameOrNull", "nanos", "nanosToMillis", "(J)J", "millis", "millisToNanos", "normalNanos", "durationOfNanos", "normalMillis", "durationOfMillis", "normalValue", "unitDiscriminator", "durationOf", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "fractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "fallbackFractionMultiplier", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "shortNameLength", "kotlin-stdlib"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class DurationKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            try {
                iArr[DurationUnit.MICROSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DurationUnit.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DurationUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DurationUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DurationUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DurationUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long addMillisWithoutOverflow(long j, long j2) {
        if (j != 4611686018427387903L && j != -4611686018427387903L) {
            return (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : RangesKt___RangesKt.coerceIn(j + j2, -4611686018427387903L, 4611686018427387903L);
        }
        if ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) {
            return 9223372036854759646L;
        }
        return j;
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        char cCharAt2 = i < StringsKt.getLastIndex(str) ? str.charAt(i + 1) : (char) 0;
        if (cCharAt == 'd') {
            return DurationUnit.DAYS;
        }
        if (cCharAt == 'h') {
            return DurationUnit.HOURS;
        }
        if (cCharAt == 's') {
            return DurationUnit.SECONDS;
        }
        if (cCharAt == 'u') {
            if (cCharAt2 == 's') {
                return DurationUnit.MICROSECONDS;
            }
            return null;
        }
        if (cCharAt == 'm') {
            return cCharAt2 == 's' ? DurationUnit.MILLISECONDS : DurationUnit.MINUTES;
        }
        if (cCharAt == 'n' && cCharAt2 == 's') {
            return DurationUnit.NANOSECONDS;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOf(long j, int i) {
        return Duration.INSTANCE.m2558fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + ((long) i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillis(long j) {
        return Duration.INSTANCE.m2558fromRawValueUwyO8pc$kotlin_stdlib((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfMillisNormalized(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? durationOfMillis(RangesKt___RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L)) : durationOfNanos(millisToNanos(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanos(long j) {
        return Duration.INSTANCE.m2558fromRawValueUwyO8pc$kotlin_stdlib(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationOfNanosNormalized(long j) {
        return (-4611686018426999999L > j || j >= 4611686018427000000L) ? durationOfMillis(nanosToMillis(j)) : durationOfNanos(j);
    }

    private static final long fractionDigitsToNanos(long j, DurationUnit durationUnit) {
        return MathKt.roundToLong(j * getFractionMultiplier(durationUnit));
    }

    private static final long getFallbackFractionMultiplier(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        if (i == 5) {
            return 60000000000L;
        }
        if (i == 6) {
            return 3600000000000L;
        }
        if (i == 7) {
            return 86400000000000L;
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Invalid unit: ", (Object) durationUnit, (Object) " for fallback fraction multiplier");
        return 0L;
    }

    private static final double getFractionMultiplier(DurationUnit durationUnit) {
        switch (WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()]) {
            case 1:
                return 1.0E-12d;
            case 2:
                return 1.0E-15d;
            case 3:
                return 1.0E-9d;
            case 4:
                return 1.0E-6d;
            case 5:
                return 6.0E-5d;
            case 6:
                return 0.0036d;
            case 7:
                return 0.0864d;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m("Unknown unit: ", durationUnit);
                return 0.0d;
        }
    }

    private static final int getShortNameLength(DurationUnit durationUnit) {
        int i = WhenMappings.$EnumSwitchMapping$0[durationUnit.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? 2 : 1;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String str, int i) {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'D') {
            return DurationUnit.DAYS;
        }
        if (cCharAt == 'H') {
            return DurationUnit.HOURS;
        }
        if (cCharAt == 'M') {
            return DurationUnit.MINUTES;
        }
        if (cCharAt != 'S') {
            return null;
        }
        return DurationUnit.SECONDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long nanosToMillis(long j) {
        return j / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x025b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseDefaultStringFormat(String str, int i, boolean z, boolean z2) {
        boolean z3;
        int i2;
        char c;
        boolean z4;
        int i3;
        int i4;
        long j;
        long j2;
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        char cCharAt4;
        int length = str.length();
        boolean z5 = !z;
        long j3 = 0;
        if (z && str.charAt(i) == '(' && str.charAt(length - 1) == ')') {
            i2 = i + 1;
            length--;
            if (i2 == length) {
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("No components");
                return 0L;
            }
            z3 = true;
        } else {
            z3 = z5;
            i2 = i;
        }
        DurationUnit durationUnit = null;
        long jAddMillisWithoutOverflow = 0;
        long jFractionDigitsToNanos = 0;
        boolean z6 = true;
        while (i2 < length) {
            if (!z6 && z3) {
                while (i2 < str.length() && str.charAt(i2) == ' ') {
                    i2++;
                }
            }
            LongParser longParser = LongParser.INSTANCE.getDefault();
            int i5 = (longParser.allowSign && ((cCharAt4 = str.charAt(i2)) == '+' || cCharAt4 == '-')) ? i2 + 1 : i2;
            while (true) {
                c = '0';
                if (i5 >= str.length() || str.charAt(i5) != '0') {
                    break;
                }
                i5++;
            }
            long j4 = j3;
            while (i5 < str.length() && '0' <= (cCharAt2 = str.charAt(i5)) && cCharAt2 < ':') {
                int i6 = cCharAt2 - '0';
                if (j3 <= longParser.overflowThreshold) {
                    boolean z7 = z3;
                    if (j3 != longParser.overflowThreshold || i6 <= longParser.lastDigitMax) {
                        j3 = ((long) i6) + (j3 << 3) + (j3 << 1);
                        i5++;
                        z3 = z7;
                    }
                }
                while (i5 < str.length() && '0' <= (cCharAt3 = str.charAt(i5)) && cCharAt3 < ':') {
                    i5++;
                }
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("");
                return j4;
            }
            boolean z8 = z3;
            if (i5 == i2 || i5 == length) {
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("");
                return j4;
            }
            boolean z9 = str.charAt(i5) == '.';
            if (z9) {
                int i7 = i5 + 1;
                FractionalParser fractionalParser = FractionalParser.INSTANCE;
                int iMin = Math.min(i5 + 7, str.length());
                int i8 = i7;
                int i9 = 0;
                while (i8 < iMin) {
                    char cCharAt5 = str.charAt(i8);
                    if (c > cCharAt5 || cCharAt5 >= ':') {
                        break;
                    }
                    i9 = (cCharAt5 - '0') + (i9 << 3) + (i9 << 1);
                    i8++;
                    c = '0';
                }
                int i10 = i9;
                for (int i11 = 0; i11 < 6 - (i8 - i7); i11++) {
                    i10 = (i10 << 3) + (i10 << 1);
                }
                int iMin2 = Math.min(i8 + 9, str.length());
                i3 = i8;
                int i12 = 0;
                while (true) {
                    z4 = z9;
                    if (i3 >= iMin2) {
                        break;
                    }
                    char cCharAt6 = str.charAt(i3);
                    int i13 = iMin2;
                    if ('0' > cCharAt6 || cCharAt6 >= ':') {
                        break;
                    }
                    i12 = (cCharAt6 - '0') + (i12 << 3) + (i12 << 1);
                    i3++;
                    z9 = z4;
                    iMin2 = i13;
                }
                int i14 = 9 - (i3 - i8);
                int i15 = i12;
                for (int i16 = 0; i16 < i14; i16++) {
                    i15 = (i15 << 3) + (i15 << 1);
                }
                while (i3 < str.length() && '0' <= (cCharAt = str.charAt(i3)) && cCharAt < ':') {
                    i3++;
                }
                if (i3 == i7 || i3 == length) {
                    if (!z2) {
                        return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$2("");
                    return j4;
                }
                i4 = i5;
                j = (((long) i10) * 1000000000) + ((long) i15);
            } else {
                z4 = z9;
                i3 = i5;
                i4 = -1;
                j = j4;
            }
            DurationUnit durationUnitDefaultDurationUnitByShortNameOrNull = defaultDurationUnitByShortNameOrNull(str, i3);
            if (durationUnitDefaultDurationUnitByShortNameOrNull == null) {
                String str2 = "Unknown duration unit short name: " + str.charAt(i3);
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(str2);
                return j4;
            }
            if (durationUnit != null && durationUnit.compareTo(durationUnitDefaultDurationUnitByShortNameOrNull) <= 0) {
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("Unexpected order of duration components");
                return j4;
            }
            int i17 = WhenMappings.$EnumSwitchMapping$0[durationUnitDefaultDurationUnitByShortNameOrNull.ordinal()];
            if (i17 == 1) {
                j2 = (j3 / 1000) + jAddMillisWithoutOverflow;
                if (j2 <= 4611686018426L) {
                    jFractionDigitsToNanos = (j3 % 1000) * 1000;
                }
            } else if (i17 != 2) {
                jAddMillisWithoutOverflow = addMillisWithoutOverflow(jAddMillisWithoutOverflow, DurationUnitKt__DurationUnitKt.convertDurationUnitToMilliseconds(j3, durationUnitDefaultDurationUnitByShortNameOrNull));
                int shortNameLength = getShortNameLength(durationUnitDefaultDurationUnitByShortNameOrNull) + i3;
                if (z4) {
                    if (shortNameLength < length) {
                        if (!z2) {
                            return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$2("Fractional component must be last");
                        return j4;
                    }
                    jFractionDigitsToNanos += (durationUnitDefaultDurationUnitByShortNameOrNull.compareTo(DurationUnit.MINUTES) < 0 || shortNameLength - i4 <= 15) ? fractionDigitsToNanos(j, durationUnitDefaultDurationUnitByShortNameOrNull) : parseFractionFallback(str, i4, shortNameLength - getShortNameLength(durationUnitDefaultDurationUnitByShortNameOrNull), durationUnitDefaultDurationUnitByShortNameOrNull);
                }
                z3 = z8;
                i2 = shortNameLength;
                durationUnit = durationUnitDefaultDurationUnitByShortNameOrNull;
                j3 = j4;
                z6 = false;
            } else {
                j2 = (j3 / 1000000) + jAddMillisWithoutOverflow;
                jFractionDigitsToNanos += j3 % 1000000;
            }
            jAddMillisWithoutOverflow = j2;
            int shortNameLength2 = getShortNameLength(durationUnitDefaultDurationUnitByShortNameOrNull) + i3;
            if (z4) {
            }
            z3 = z8;
            i2 = shortNameLength2;
            durationUnit = durationUnitDefaultDurationUnitByShortNameOrNull;
            j3 = j4;
            z6 = false;
        }
        return Duration.m2551plusLRDsOJo(toDuration(jAddMillisWithoutOverflow, DurationUnit.MILLISECONDS), toDuration(jFractionDigitsToNanos, DurationUnit.NANOSECONDS));
    }

    private static final long parseDuration(String str, boolean z, boolean z2) {
        int i;
        int i2;
        long jM2559getINFINITEUwyO8pc;
        if (str.length() == 0) {
            if (!z2) {
                return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("The string is empty");
            return 0L;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '+') {
            i2 = cCharAt != '-' ? 0 : 1;
            i = i2;
        } else {
            i = 0;
            i2 = 1;
        }
        boolean z3 = i2 > 0;
        if (str.length() <= i2) {
            if (!z2) {
                return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("No components");
            return 0L;
        }
        if (str.charAt(i2) == 'P') {
            jM2559getINFINITEUwyO8pc = parseIsoStringFormat(str, i2 + 1, z2);
        } else {
            if (z) {
                if (!z2) {
                    return Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib();
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2("");
                return 0L;
            }
            jM2559getINFINITEUwyO8pc = StringsKt__StringsJVMKt.regionMatches(str, i2, "Infinity", 0, Math.max(str.length() - i2, 8), true) ? Duration.INSTANCE.m2559getINFINITEUwyO8pc() : parseDefaultStringFormat(str, i2, z3, z2);
        }
        return (i == 0 || Duration.m2531equalsimpl0(jM2559getINFINITEUwyO8pc, Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib())) ? jM2559getINFINITEUwyO8pc : Duration.m2555unaryMinusUwyO8pc(jM2559getINFINITEUwyO8pc);
    }

    public static /* synthetic */ long parseDuration$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return parseDuration(str, z, z2);
    }

    private static final long parseFractionFallback(String str, int i, int i2, DurationUnit durationUnit) {
        str.getClass();
        return MathKt.roundToLong(Double.parseDouble(str.substring(i, i2)) * getFallbackFractionMultiplier(durationUnit));
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012c  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:42:0x0089
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseIsoStringFormat(java.lang.String r25, int r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.parseIsoStringFormat(java.lang.String, int, boolean):long");
    }

    public static final long toDuration(long j, DurationUnit durationUnit) {
        durationUnit.getClass();
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long jConvertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(4611686018426999999L, durationUnit2, durationUnit);
        if ((-jConvertDurationUnitOverflow) <= j && j <= jConvertDurationUnitOverflow) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j, durationUnit, durationUnit2));
        }
        DurationUnit durationUnit3 = DurationUnit.MILLISECONDS;
        return durationUnit.compareTo(durationUnit3) >= 0 ? durationOfMillis(((long) MathKt.getSign(j)) * DurationUnitKt__DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(j, -9223372036854775807L)), durationUnit)) : durationOfMillis(RangesKt___RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j, durationUnit, durationUnit3), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(int i, DurationUnit durationUnit) {
        durationUnit.getClass();
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i, durationUnit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i, durationUnit);
    }

    public static final long toDuration(double d, DurationUnit durationUnit) {
        durationUnit.getClass();
        double dConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, durationUnit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(dConvertDurationUnit)) {
            long jRoundToLong = MathKt.roundToLong(dConvertDurationUnit);
            if (-4611686018426999999L <= jRoundToLong && jRoundToLong < 4611686018427000000L) {
                return durationOfNanos(jRoundToLong);
            }
            return durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, durationUnit, DurationUnit.MILLISECONDS)));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Duration value cannot be NaN.");
        return 0L;
    }
}
