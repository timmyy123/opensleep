package kotlin.time;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b'\b\u0087@\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001]B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u000fJ\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u000fJ\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\u000fJ\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b#\u0010\u000fJ\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010,\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u000f\u00100\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J?\u0010:\u001a\u000207*\u000601j\u0002`22\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u0010)\u001a\u00020-2\u0006\u00106\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u00109J\r\u0010<\u001a\u00020-¢\u0006\u0004\b;\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010=R\u0014\u0010?\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0005R\u0014\u0010B\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\bC\u0010\u0005R\u001a\u0010I\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bG\u0010H\u001a\u0004\bE\u0010FR\u001a\u0010L\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bK\u0010H\u001a\u0004\bJ\u0010FR\u001a\u0010O\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bN\u0010H\u001a\u0004\bM\u0010FR\u001a\u0010R\u001a\u00020\u00068@X\u0081\u0004¢\u0006\f\u0012\u0004\bQ\u0010H\u001a\u0004\bP\u0010FR\u0011\u0010T\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0011\u0010V\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bU\u0010\u0005R\u0011\u0010X\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u0011\u0010Z\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bY\u0010\u0005R\u0011\u0010\\\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b[\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006^"}, d2 = {"Lkotlin/time/Duration;", "", "", "rawValue", "constructor-impl", "(J)J", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "isInNanos-impl", "(J)Z", "isInNanos", "isInMillis-impl", "isInMillis", "unaryMinus-UwyO8pc", "unaryMinus", "plus-LRDsOJo", "(JJ)J", "plus", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "addValuesMixedRanges", "isNegative-impl", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(JJ)I", "compareTo", "Lkotlin/time/DurationUnit;", "unit", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLong", "", "toString-impl", "(J)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "appendFractional", "toIsoString-impl", "toIsoString", "J", "getValue-impl", SDKConstants.PARAM_VALUE, "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "getAbsoluteValue-UwyO8pc", "absoluteValue", "getHoursComponent-impl", "(J)I", "getHoursComponent$annotations", "()V", "hoursComponent", "getMinutesComponent-impl", "getMinutesComponent$annotations", "minutesComponent", "getSecondsComponent-impl", "getSecondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "getNanosecondsComponent$annotations", "nanosecondsComponent", "getInWholeDays-impl", "inWholeDays", "getInWholeHours-impl", "inWholeHours", "getInWholeMinutes-impl", "inWholeMinutes", "getInWholeSeconds-impl", "inWholeSeconds", "getInWholeMilliseconds-impl", "inWholeMilliseconds", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m2529constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    private static final long INVALID = m2529constructorimpl(9223372036854759646L);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0015\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010¨\u0006\u0019"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "", "rawValue", "Lkotlin/time/Duration;", "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "fromRawValue", "", SDKConstants.PARAM_VALUE, "parseIsoString-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "INFINITE", "J", "getINFINITE-UwyO8pc", "()J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "INVALID_RAW_VALUE", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: fromRawValue-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2558fromRawValueUwyO8pc$kotlin_stdlib(long rawValue) {
            long jM2529constructorimpl = Duration.m2529constructorimpl(rawValue);
            if (DurationJvmKt.getDurationAssertionsEnabled()) {
                if (Duration.m2547isInNanosimpl(jM2529constructorimpl)) {
                    long jM2543getValueimpl = Duration.m2543getValueimpl(jM2529constructorimpl);
                    if (-4611686018426999999L > jM2543getValueimpl || jM2543getValueimpl >= 4611686018427000000L) {
                        throw new AssertionError(Duration.m2543getValueimpl(jM2529constructorimpl) + " ns is out of nanoseconds range");
                    }
                } else {
                    long jM2543getValueimpl2 = Duration.m2543getValueimpl(jM2529constructorimpl);
                    if (-4611686018427387903L >= jM2543getValueimpl2 || jM2543getValueimpl2 >= 4611686018427387903L) {
                        long jM2543getValueimpl3 = Duration.m2543getValueimpl(jM2529constructorimpl);
                        if (jM2543getValueimpl3 != 4611686018427387903L && jM2543getValueimpl3 != -4611686018427387903L) {
                            throw new AssertionError(Duration.m2543getValueimpl(jM2529constructorimpl) + " ms is out of milliseconds range");
                        }
                    }
                    long jM2543getValueimpl4 = Duration.m2543getValueimpl(jM2529constructorimpl);
                    if (-4611686018426L <= jM2543getValueimpl4 && jM2543getValueimpl4 < 4611686018427L) {
                        throw new AssertionError(Duration.m2543getValueimpl(jM2529constructorimpl) + " ms is denormalized");
                    }
                }
            }
            return jM2529constructorimpl;
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m2559getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* JADX INFO: renamed from: getINVALID-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2560getINVALIDUwyO8pc$kotlin_stdlib() {
            return Duration.INVALID;
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2561getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m2562parseIsoStringUwyO8pc(String value) {
            value.getClass();
            try {
                long duration$default = DurationKt.parseDuration$default(value, true, false, 4, null);
                if (Duration.m2531equalsimpl0(duration$default, Duration.INSTANCE.m2560getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed");
                }
                return duration$default;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(FileInsert$$ExternalSyntheticOutline0.m("Invalid ISO duration string format: '", value, "'."), e);
            }
        }

        private Companion() {
        }
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m2525addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long jAddMillisWithoutOverflow = DurationKt.addMillisWithoutOverflow(j2, jNanosToMillis);
        if (-4611686018426L > jAddMillisWithoutOverflow || jAddMillisWithoutOverflow >= 4611686018427L) {
            return DurationKt.durationOfMillis(jAddMillisWithoutOverflow);
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(jAddMillisWithoutOverflow) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m2526appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt__StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strPadStart, 0, i6);
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m2527boximpl(long j) {
        return new Duration(j);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m2528compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m2549isNegativeimpl(j) ? -i : i;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2529constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2530equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).getRawValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2531equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m2532getAbsoluteValueUwyO8pc(long j) {
        return m2549isNegativeimpl(j) ? m2555unaryMinusUwyO8pc(j) : j;
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m2533getHoursComponentimpl(long j) {
        if (m2548isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2535getInWholeHoursimpl(j) % 24);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m2534getInWholeDaysimpl(long j) {
        return m2553toLongimpl(j, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m2535getInWholeHoursimpl(long j) {
        return m2553toLongimpl(j, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m2536getInWholeMillisecondsimpl(long j) {
        return (m2546isInMillisimpl(j) && m2545isFiniteimpl(j)) ? m2543getValueimpl(j) : m2553toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m2537getInWholeMinutesimpl(long j) {
        return m2553toLongimpl(j, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m2538getInWholeSecondsimpl(long j) {
        return m2553toLongimpl(j, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m2539getMinutesComponentimpl(long j) {
        if (m2548isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2537getInWholeMinutesimpl(j) % 60);
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m2540getNanosecondsComponentimpl(long j) {
        if (m2548isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2546isInMillisimpl(j) ? DurationKt.millisToNanos(m2543getValueimpl(j) % 1000) : m2543getValueimpl(j) % 1000000000);
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m2541getSecondsComponentimpl(long j) {
        if (m2548isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m2538getInWholeSecondsimpl(j) % 60);
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m2542getStorageUnitimpl(long j) {
        return m2547isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final long m2543getValueimpl(long j) {
        return j >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2544hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m2545isFiniteimpl(long j) {
        return !m2548isInfiniteimpl(j);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m2546isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    public static final boolean m2547isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m2548isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m2549isNegativeimpl(long j) {
        return j < 0;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m2550isPositiveimpl(long j) {
        return j > 0;
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m2551plusLRDsOJo(long j, long j2) {
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return m2546isInMillisimpl(j) ? m2525addValuesMixedRangesUwyO8pc(j, m2543getValueimpl(j), m2543getValueimpl(j2)) : m2525addValuesMixedRangesUwyO8pc(j, m2543getValueimpl(j2), m2543getValueimpl(j));
        }
        if (m2547isInNanosimpl(j)) {
            return DurationKt.durationOfNanosNormalized(m2543getValueimpl(j) + m2543getValueimpl(j2));
        }
        long jAddMillisWithoutOverflow = DurationKt.addMillisWithoutOverflow(m2543getValueimpl(j), m2543getValueimpl(j2));
        if (jAddMillisWithoutOverflow != 9223372036854759646L) {
            return (jAddMillisWithoutOverflow == 4611686018427387903L || jAddMillisWithoutOverflow == -4611686018427387903L) ? DurationKt.durationOfMillis(jAddMillisWithoutOverflow) : DurationKt.durationOfMillisNormalized(jAddMillisWithoutOverflow);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Summing infinite durations of different signs yields an undefined result.");
        return 0L;
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m2552toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m2549isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM2532getAbsoluteValueUwyO8pc = m2532getAbsoluteValueUwyO8pc(j);
        long jM2535getInWholeHoursimpl = m2535getInWholeHoursimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2539getMinutesComponentimpl = m2539getMinutesComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2541getSecondsComponentimpl = m2541getSecondsComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2540getNanosecondsComponentimpl = m2540getNanosecondsComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        long j2 = m2548isInfiniteimpl(j) ? 9999999999999L : jM2535getInWholeHoursimpl;
        boolean z = false;
        boolean z2 = j2 != 0;
        boolean z3 = (iM2541getSecondsComponentimpl == 0 && iM2540getNanosecondsComponentimpl == 0) ? false : true;
        if (iM2539getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(j2);
            sb.append('H');
        }
        if (z) {
            sb.append(iM2539getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m2526appendFractionalimpl(j, sb, iM2541getSecondsComponentimpl, iM2540getNanosecondsComponentimpl, 9, "S", true);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m2553toLongimpl(long j, DurationUnit durationUnit) {
        durationUnit.getClass();
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m2543getValueimpl(j), m2542getStorageUnitimpl(j), durationUnit);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2554toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM2549isNegativeimpl = m2549isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM2549isNegativeimpl) {
            sb.append('-');
        }
        long jM2532getAbsoluteValueUwyO8pc = m2532getAbsoluteValueUwyO8pc(j);
        long jM2534getInWholeDaysimpl = m2534getInWholeDaysimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2533getHoursComponentimpl = m2533getHoursComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2539getMinutesComponentimpl = m2539getMinutesComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2541getSecondsComponentimpl = m2541getSecondsComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int iM2540getNanosecondsComponentimpl = m2540getNanosecondsComponentimpl(jM2532getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM2534getInWholeDaysimpl != 0;
        boolean z2 = iM2533getHoursComponentimpl != 0;
        boolean z3 = iM2539getMinutesComponentimpl != 0;
        boolean z4 = (iM2541getSecondsComponentimpl == 0 && iM2540getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM2534getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM2533getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM2539getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM2541getSecondsComponentimpl != 0 || z || z2 || z3) {
                m2526appendFractionalimpl(j, sb, iM2541getSecondsComponentimpl, iM2540getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM2540getNanosecondsComponentimpl >= 1000000) {
                m2526appendFractionalimpl(j, sb, iM2540getNanosecondsComponentimpl / 1000000, iM2540getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM2540getNanosecondsComponentimpl >= 1000) {
                m2526appendFractionalimpl(j, sb, iM2540getNanosecondsComponentimpl / 1000, iM2540getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM2540getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM2549isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m2555unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m2543getValueimpl(j), ((int) j) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m2556compareToLRDsOJo(duration.getRawValue());
    }

    public boolean equals(Object other) {
        return m2530equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m2544hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m2554toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m2556compareToLRDsOJo(long j) {
        return m2528compareToLRDsOJo(this.rawValue, j);
    }
}
