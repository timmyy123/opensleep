package j$.time.format;

import j$.time.DayOfWeek;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends i {
    public final char g;
    public final int h;

    public r(char c, int i, int i2, int i3, int i4) {
        super(null, i2, i3, e0.NOT_NEGATIVE, i4);
        this.g = c;
        this.h = i;
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new r(this.g, this.h, this.b, this.c, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i) {
        return new r(this.g, this.h, this.b, this.c, this.e + i);
    }

    public final i f(Locale locale) {
        j$.time.temporal.t tVar;
        ConcurrentMap concurrentMap = j$.time.temporal.u.g;
        Objects.requireNonNull(locale, SpotifyService.LOCALE);
        j$.time.temporal.u uVarA = j$.time.temporal.u.a(DayOfWeek.a[((((int) (((long) (r7.getFirstDayOfWeek() - 1)) % 7)) + 7) + DayOfWeek.SUNDAY.ordinal()) % 7], Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
        char c = this.g;
        if (c == 'W') {
            tVar = uVarA.d;
        } else {
            if (c == 'Y') {
                j$.time.temporal.t tVar2 = uVarA.f;
                int i = this.h;
                if (i == 2) {
                    return new o(tVar2, 2, 2, o.h, this.e);
                }
                return new i(tVar2, i, 19, i < 4 ? e0.NORMAL : e0.EXCEEDS_PAD, this.e);
            }
            if (c == 'c' || c == 'e') {
                tVar = uVarA.c;
            } else {
                if (c != 'w') {
                    throw new IllegalStateException("unreachable");
                }
                tVar = uVarA.e;
            }
        }
        return new i(tVar, this.b, this.c, e0.NOT_NEGATIVE, this.e);
    }

    @Override // j$.time.format.i, j$.time.format.e
    public final boolean o(x xVar, StringBuilder sb) {
        return f(xVar.b.b).o(xVar, sb);
    }

    @Override // j$.time.format.i, j$.time.format.e
    public final int t(v vVar, CharSequence charSequence, int i) {
        return f(vVar.a.b).t(vVar, charSequence, i);
    }

    @Override // j$.time.format.i
    public final String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Localized(");
        int i = this.h;
        char c = this.g;
        if (c != 'Y') {
            if (c == 'W') {
                sb.append("WeekOfMonth");
            } else if (c == 'c' || c == 'e') {
                sb.append("DayOfWeek");
            } else if (c == 'w') {
                sb.append("WeekOfWeekBasedYear");
            }
            sb.append(",");
            sb.append(i);
        } else if (i == 1) {
            sb.append("WeekBasedYear");
        } else if (i == 2) {
            sb.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
        } else {
            sb.append("WeekBasedYear,");
            sb.append(i);
            sb.append(",19,");
            sb.append(i < 4 ? e0.NORMAL : e0.EXCEEDS_PAD);
        }
        sb.append(")");
        return sb.toString();
    }
}
