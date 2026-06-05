package j$.time.format;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import java.lang.ref.SoftReference;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends s {
    public static final Map i = new ConcurrentHashMap();
    public final f0 e;
    public final boolean f;
    public final Map g;
    public final Map h;

    public t(f0 f0Var, boolean z) {
        super(j$.time.temporal.p.e, "ZoneText(" + f0Var + ")");
        this.g = new HashMap();
        this.h = new HashMap();
        Objects.requireNonNull(f0Var, "textStyle");
        this.e = f0Var;
        this.f = z;
    }

    @Override // j$.time.format.s
    public final m a(v vVar) {
        m mVar;
        if (this.e == f0.NARROW) {
            return super.a(vVar);
        }
        Locale locale = vVar.a.b;
        boolean z = vVar.b;
        Set set = j$.time.zone.h.d;
        int size = set.size();
        Map map = z ? this.g : this.h;
        Map.Entry entry = (Map.Entry) map.get(locale);
        if (entry != null && ((Integer) entry.getKey()).intValue() == size && (mVar = (m) ((SoftReference) entry.getValue()).get()) != null) {
            return mVar;
        }
        m mVar2 = vVar.b ? new m("", null, null) : new l("", null, null);
        for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
            String str = strArr[0];
            if (set.contains(str)) {
                mVar2.a(str, str);
                HashMap map2 = (HashMap) g0.d;
                String str2 = (String) map2.get(str);
                if (str2 == null) {
                    HashMap map3 = (HashMap) g0.g;
                    if (map3.containsKey(str)) {
                        str = (String) map3.get(str);
                        str2 = (String) map2.get(str);
                    }
                }
                if (str2 != null) {
                    Map map4 = (Map) ((HashMap) g0.f).get(str2);
                    str = (map4 == null || !map4.containsKey(locale.getCountry())) ? (String) ((HashMap) g0.e).get(str2) : (String) map4.get(locale.getCountry());
                }
                HashMap map5 = (HashMap) g0.g;
                if (map5.containsKey(str)) {
                    str = (String) map5.get(str);
                }
                for (int i2 = this.e == f0.FULL ? 1 : 2; i2 < strArr.length; i2 += 2) {
                    mVar2.a(strArr[i2], str);
                }
            }
        }
        map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(mVar2)));
        return mVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    @Override // j$.time.format.s, j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean o(x xVar, StringBuilder sb) {
        boolean zG;
        f0 f0Var;
        String str;
        f0 f0Var2;
        String[] strArr;
        ZoneId zoneId = (ZoneId) xVar.b(j$.time.temporal.p.a);
        if (zoneId == null) {
            return false;
        }
        String id = zoneId.getId();
        if (!(zoneId instanceof ZoneOffset)) {
            TemporalAccessor temporalAccessor = xVar.a;
            if (this.f) {
                zG = 2;
                Locale locale = xVar.b.b;
                f0Var = f0.NARROW;
                str = null;
                Map concurrentHashMap = null;
                f0Var2 = this.e;
                if (f0Var2 != f0Var) {
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) i;
                    SoftReference softReference = (SoftReference) concurrentHashMap2.get(id);
                    if (softReference == null || (concurrentHashMap = (Map) softReference.get()) == null || (strArr = (String[]) concurrentHashMap.get(locale)) == null) {
                        TimeZone timeZone = TimeZone.getTimeZone(id);
                        String[] strArr2 = {id, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), id, id};
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        concurrentHashMap.put(locale, strArr2);
                        concurrentHashMap2.put(id, new SoftReference(concurrentHashMap));
                        strArr = strArr2;
                    }
                    str = zG != 0 ? zG != 1 ? strArr[f0Var2.a + 5] : strArr[f0Var2.a + 3] : strArr[f0Var2.a + 1];
                }
                if (str != null) {
                    id = str;
                }
            } else {
                if (temporalAccessor.h(j$.time.temporal.a.INSTANT_SECONDS)) {
                    zG = zoneId.getRules().g(Instant.from(temporalAccessor));
                } else {
                    j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
                    if (temporalAccessor.h(aVar)) {
                        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_DAY;
                        if (temporalAccessor.h(aVar2)) {
                            LocalDateTime localDateTimeOf = LocalDateTime.of(LocalDate.O(temporalAccessor.i(aVar)), LocalTime.H(temporalAccessor.i(aVar2)));
                            if (zoneId.getRules().e(localDateTimeOf) == null) {
                                zG = zoneId.getRules().g(localDateTimeOf.w(zoneId).toInstant());
                            }
                        }
                    }
                }
                Locale locale2 = xVar.b.b;
                f0Var = f0.NARROW;
                str = null;
                Map concurrentHashMap3 = null;
                f0Var2 = this.e;
                if (f0Var2 != f0Var) {
                }
                if (str != null) {
                }
            }
        }
        sb.append(id);
        return true;
    }
}
