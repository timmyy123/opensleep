package j$.time.format;

import j$.time.LocalTime;
import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter RFC_1123_DATE_TIME;
    public static final DateTimeFormatter f;
    public static final DateTimeFormatter g;
    public final d a;
    public final Locale b;
    public final b0 c;
    public final d0 d;
    public final j$.time.chrono.k e;

    static {
        u uVar = new u();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        e0 e0Var = e0.EXCEEDS_PAD;
        uVar.n(aVar, 4, 10, e0Var);
        uVar.d('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        uVar.m(aVar2, 2);
        uVar.d('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        uVar.m(aVar3, 2);
        d0 d0Var = d0.STRICT;
        j$.time.chrono.r rVar = j$.time.chrono.r.c;
        DateTimeFormatter dateTimeFormatterQ = uVar.q(d0Var, rVar);
        ISO_LOCAL_DATE = dateTimeFormatterQ;
        u uVar2 = new u();
        p pVar = p.INSENSITIVE;
        uVar2.c(pVar);
        uVar2.a(dateTimeFormatterQ);
        j jVar = j.e;
        uVar2.c(jVar);
        uVar2.q(d0Var, rVar);
        u uVar3 = new u();
        uVar3.c(pVar);
        uVar3.a(dateTimeFormatterQ);
        uVar3.p();
        uVar3.c(jVar);
        uVar3.q(d0Var, rVar);
        u uVar4 = new u();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        uVar4.m(aVar4, 2);
        uVar4.d(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        uVar4.m(aVar5, 2);
        uVar4.p();
        uVar4.d(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        uVar4.m(aVar6, 2);
        uVar4.p();
        uVar4.b(j$.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterQ2 = uVar4.q(d0Var, null);
        u uVar5 = new u();
        uVar5.c(pVar);
        uVar5.a(dateTimeFormatterQ2);
        uVar5.c(jVar);
        uVar5.q(d0Var, null);
        u uVar6 = new u();
        uVar6.c(pVar);
        uVar6.a(dateTimeFormatterQ2);
        uVar6.p();
        uVar6.c(jVar);
        uVar6.q(d0Var, null);
        u uVar7 = new u();
        uVar7.c(pVar);
        uVar7.a(dateTimeFormatterQ);
        uVar7.d('T');
        uVar7.a(dateTimeFormatterQ2);
        DateTimeFormatter dateTimeFormatterQ3 = uVar7.q(d0Var, rVar);
        u uVar8 = new u();
        uVar8.c(pVar);
        uVar8.a(dateTimeFormatterQ3);
        p pVar2 = p.LENIENT;
        uVar8.c(pVar2);
        uVar8.c(jVar);
        p pVar3 = p.STRICT;
        uVar8.c(pVar3);
        DateTimeFormatter dateTimeFormatterQ4 = uVar8.q(d0Var, rVar);
        u uVar9 = new u();
        uVar9.a(dateTimeFormatterQ4);
        uVar9.p();
        uVar9.d('[');
        p pVar4 = p.SENSITIVE;
        uVar9.c(pVar4);
        j$.time.s sVar = u.h;
        uVar9.c(new s(sVar, "ZoneRegionId()"));
        uVar9.d(']');
        f = uVar9.q(d0Var, rVar);
        u uVar10 = new u();
        uVar10.a(dateTimeFormatterQ3);
        uVar10.p();
        uVar10.c(jVar);
        uVar10.p();
        uVar10.d('[');
        uVar10.c(pVar4);
        uVar10.c(new s(sVar, "ZoneRegionId()"));
        uVar10.d(']');
        ISO_DATE_TIME = uVar10.q(d0Var, rVar);
        u uVar11 = new u();
        uVar11.c(pVar);
        uVar11.n(aVar, 4, 10, e0Var);
        uVar11.d('-');
        uVar11.m(j$.time.temporal.a.DAY_OF_YEAR, 3);
        uVar11.p();
        uVar11.c(jVar);
        uVar11.q(d0Var, rVar);
        u uVar12 = new u();
        uVar12.c(pVar);
        uVar12.n(j$.time.temporal.j.c, 4, 10, e0Var);
        uVar12.e("-W");
        uVar12.m(j$.time.temporal.j.b, 2);
        uVar12.d('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        uVar12.m(aVar7, 1);
        uVar12.p();
        uVar12.c(jVar);
        uVar12.q(d0Var, rVar);
        u uVar13 = new u();
        uVar13.c(pVar);
        uVar13.c(new g());
        g = uVar13.q(d0Var, null);
        u uVar14 = new u();
        uVar14.c(pVar);
        uVar14.m(aVar, 4);
        uVar14.m(aVar2, 2);
        uVar14.m(aVar3, 2);
        uVar14.p();
        uVar14.c(pVar2);
        uVar14.g("+HHMMss", "Z");
        uVar14.c(pVar3);
        uVar14.q(d0Var, rVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        u uVar15 = new u();
        uVar15.c(pVar);
        uVar15.c(pVar2);
        uVar15.p();
        uVar15.i(aVar7, map);
        uVar15.e(", ");
        uVar15.o();
        uVar15.n(aVar3, 1, 2, e0.NOT_NEGATIVE);
        uVar15.d(' ');
        uVar15.i(aVar2, map2);
        uVar15.d(' ');
        uVar15.m(aVar, 4);
        uVar15.d(' ');
        uVar15.m(aVar4, 2);
        uVar15.d(':');
        uVar15.m(aVar5, 2);
        uVar15.p();
        uVar15.d(':');
        uVar15.m(aVar6, 2);
        uVar15.o();
        uVar15.d(' ');
        uVar15.g("+HHMM", "GMT");
        RFC_1123_DATE_TIME = uVar15.q(d0.SMART, rVar);
    }

    public DateTimeFormatter(d dVar, Locale locale, d0 d0Var, j$.time.chrono.k kVar) {
        b0 b0Var = b0.a;
        this.a = dVar;
        Objects.requireNonNull(locale, SpotifyService.LOCALE);
        this.b = locale;
        this.c = b0Var;
        Objects.requireNonNull(d0Var, "resolverStyle");
        this.d = d0Var;
        this.e = kVar;
    }

    public static DateTimeFormatter ofPattern(String str) {
        u uVar = new u();
        uVar.h(str);
        return uVar.r(Locale.getDefault(), d0.SMART, null);
    }

    public final String a(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        try {
            this.a.o(new x(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new j$.time.c(e.getMessage(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c0 b(CharSequence charSequence) {
        long j;
        int i = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        v vVar = new v(this);
        int iT = this.a.t(vVar, charSequence, parsePosition.getIndex());
        if (iT < 0) {
            parsePosition.setErrorIndex(~iT);
            vVar = null;
        } else {
            parsePosition.setIndex(iT);
        }
        if (vVar != null) {
            DateTimeFormatter dateTimeFormatter = vVar.a;
            if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() >= charSequence.length()) {
                c0 c0VarC = vVar.c();
                j$.time.chrono.k kVar = vVar.c().c;
                if (kVar == null && (kVar = dateTimeFormatter.e) == null) {
                    kVar = j$.time.chrono.r.c;
                }
                c0VarC.c = kVar;
                ZoneId zoneId = c0VarC.b;
                if (zoneId == null) {
                    dateTimeFormatter.getClass();
                    zoneId = null;
                }
                c0VarC.b = zoneId;
                c0VarC.e = this.d;
                c0VarC.o();
                c0VarC.x(c0VarC.c.E(c0VarC.a, c0VarC.e));
                c0VarC.t();
                if (((HashMap) c0VarC.a).size() > 0) {
                    loop0: while (i < 50) {
                        Iterator it = ((HashMap) c0VarC.a).entrySet().iterator();
                        while (it.hasNext()) {
                            j$.time.temporal.o oVar = (j$.time.temporal.o) ((Map.Entry) it.next()).getKey();
                            TemporalAccessor temporalAccessorX = oVar.x(c0VarC.a, c0VarC, c0VarC.e);
                            if (temporalAccessorX == null) {
                                if (!((HashMap) c0VarC.a).containsKey(oVar)) {
                                    break;
                                }
                            } else {
                                if (temporalAccessorX instanceof ChronoZonedDateTime) {
                                    ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) temporalAccessorX;
                                    ZoneId zoneId2 = c0VarC.b;
                                    if (zoneId2 == null) {
                                        c0VarC.b = chronoZonedDateTime.getZone();
                                    } else if (!zoneId2.equals(chronoZonedDateTime.getZone())) {
                                        throw new j$.time.c("ChronoZonedDateTime must use the effective parsed zone: " + c0VarC.b);
                                    }
                                    temporalAccessorX = chronoZonedDateTime.toLocalDateTime();
                                }
                                if (temporalAccessorX instanceof ChronoLocalDateTime) {
                                    ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) temporalAccessorX;
                                    c0VarC.u(chronoLocalDateTime.toLocalTime(), Period.d);
                                    c0VarC.x(chronoLocalDateTime.toLocalDate());
                                } else if (temporalAccessorX instanceof j$.time.chrono.b) {
                                    c0VarC.x((j$.time.chrono.b) temporalAccessorX);
                                } else {
                                    if (!(temporalAccessorX instanceof LocalTime)) {
                                        j$.time.g.a("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                                        return null;
                                    }
                                    c0VarC.u((LocalTime) temporalAccessorX, Period.d);
                                }
                            }
                            i++;
                        }
                    }
                    if (i == 50) {
                        j$.time.g.a("One of the parsed fields has an incorrectly implemented resolve method");
                        return null;
                    }
                    if (i > 0) {
                        c0VarC.o();
                        c0VarC.x(c0VarC.c.E(c0VarC.a, c0VarC.e));
                        c0VarC.t();
                    }
                }
                if (c0VarC.g == null) {
                    Map map = c0VarC.a;
                    j$.time.temporal.a aVar = j$.time.temporal.a.MILLI_OF_SECOND;
                    boolean zContainsKey = ((HashMap) map).containsKey(aVar);
                    Map map2 = c0VarC.a;
                    if (zContainsKey) {
                        long jLongValue = ((Long) ((HashMap) map2).remove(aVar)).longValue();
                        Map map3 = c0VarC.a;
                        j$.time.temporal.a aVar2 = j$.time.temporal.a.MICRO_OF_SECOND;
                        boolean zContainsKey2 = ((HashMap) map3).containsKey(aVar2);
                        Map map4 = c0VarC.a;
                        if (zContainsKey2) {
                            long jLongValue2 = (((Long) ((HashMap) map4).get(aVar2)).longValue() % 1000) + (jLongValue * 1000);
                            c0VarC.y(aVar, aVar2, Long.valueOf(jLongValue2));
                            ((HashMap) c0VarC.a).remove(aVar2);
                            ((HashMap) c0VarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue2 * 1000));
                        } else {
                            ((HashMap) map4).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue * 1000000));
                        }
                    } else {
                        j$.time.temporal.a aVar3 = j$.time.temporal.a.MICRO_OF_SECOND;
                        if (((HashMap) map2).containsKey(aVar3)) {
                            ((HashMap) c0VarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(((Long) ((HashMap) c0VarC.a).remove(aVar3)).longValue() * 1000));
                        }
                    }
                    Map map5 = c0VarC.a;
                    j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
                    Long l = (Long) ((HashMap) map5).get(aVar4);
                    if (l != null) {
                        Map map6 = c0VarC.a;
                        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
                        Long l2 = (Long) ((HashMap) map6).get(aVar5);
                        Map map7 = c0VarC.a;
                        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
                        Long l3 = (Long) ((HashMap) map7).get(aVar6);
                        Map map8 = c0VarC.a;
                        j$.time.temporal.a aVar7 = j$.time.temporal.a.NANO_OF_SECOND;
                        Long l4 = (Long) ((HashMap) map8).get(aVar7);
                        if ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null)) {
                            j = 1000000;
                            c0VarC.s(l.longValue(), l2 != null ? l2.longValue() : 0L, l3 != null ? l3.longValue() : 0L, l4 != null ? l4.longValue() : 0L);
                            ((HashMap) c0VarC.a).remove(aVar4);
                            ((HashMap) c0VarC.a).remove(aVar5);
                            ((HashMap) c0VarC.a).remove(aVar6);
                            ((HashMap) c0VarC.a).remove(aVar7);
                        } else {
                            j = 1000000;
                        }
                    } else {
                        j = 1000000;
                    }
                    if (c0VarC.e != d0.LENIENT && ((HashMap) c0VarC.a).size() > 0) {
                        for (Map.Entry entry : ((HashMap) c0VarC.a).entrySet()) {
                            j$.time.temporal.o oVar2 = (j$.time.temporal.o) entry.getKey();
                            if (oVar2 instanceof j$.time.temporal.a) {
                                j$.time.temporal.a aVar8 = (j$.time.temporal.a) oVar2;
                                if (aVar8.J()) {
                                    aVar8.I(((Long) entry.getValue()).longValue());
                                }
                            }
                        }
                    }
                }
                j$.time.chrono.b bVar = c0VarC.f;
                if (bVar != null) {
                    c0VarC.n(bVar);
                }
                LocalTime localTime = c0VarC.g;
                if (localTime != null) {
                    c0VarC.n(localTime);
                    if (c0VarC.f != null && ((HashMap) c0VarC.a).size() > 0) {
                        c0VarC.n(c0VarC.f.z(c0VarC.g));
                    }
                }
                if (c0VarC.f != null && c0VarC.g != null) {
                    Period period = c0VarC.h;
                    period.getClass();
                    Period period2 = Period.d;
                    if (period != period2) {
                        c0VarC.f = c0VarC.f.D(c0VarC.h);
                        c0VarC.h = period2;
                    }
                }
                if (c0VarC.g == null) {
                    if (!((HashMap) c0VarC.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
                        if (!((HashMap) c0VarC.a).containsKey(j$.time.temporal.a.SECOND_OF_DAY)) {
                            if (((HashMap) c0VarC.a).containsKey(j$.time.temporal.a.SECOND_OF_MINUTE)) {
                                Map map9 = c0VarC.a;
                                j$.time.temporal.a aVar9 = j$.time.temporal.a.NANO_OF_SECOND;
                                boolean zContainsKey3 = ((HashMap) map9).containsKey(aVar9);
                                Map map10 = c0VarC.a;
                                if (zContainsKey3) {
                                    long jLongValue3 = ((Long) ((HashMap) map10).get(aVar9)).longValue();
                                    ((HashMap) c0VarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue3 / 1000));
                                    ((HashMap) c0VarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue3 / j));
                                } else {
                                    ((HashMap) map10).put(aVar9, 0L);
                                    ((HashMap) c0VarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                                    ((HashMap) c0VarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                                }
                            }
                        }
                    }
                }
                if (c0VarC.f != null && c0VarC.g != null) {
                    Long l5 = (Long) ((HashMap) c0VarC.a).get(j$.time.temporal.a.OFFSET_SECONDS);
                    if (l5 != null) {
                        ((HashMap) c0VarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(c0VarC.f.z(c0VarC.g).w(ZoneOffset.ofTotalSeconds(l5.intValue())).toEpochSecond()));
                        return c0VarC;
                    }
                    if (c0VarC.b != null) {
                        ((HashMap) c0VarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(c0VarC.f.z(c0VarC.g).w(c0VarC.b).toEpochSecond()));
                    }
                }
                return c0VarC;
            }
        }
        String string = charSequence.length() > 64 ? charSequence.subSequence(0, 64).toString() + "..." : charSequence.toString();
        if (parsePosition.getErrorIndex() >= 0) {
            String str = "Text '" + string + "' could not be parsed at index " + parsePosition.getErrorIndex();
            parsePosition.getErrorIndex();
            throw new DateTimeParseException(str, charSequence);
        }
        String str2 = "Text '" + string + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
        parsePosition.getIndex();
        throw new DateTimeParseException(str2, charSequence);
    }

    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }

    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        u uVar = new u();
        uVar.h(str);
        return uVar.r(locale, d0.SMART, null);
    }
}
