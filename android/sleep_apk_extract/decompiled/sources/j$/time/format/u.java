package j$.time.format;

import com.facebook.internal.AnalyticsEvents;
import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final j$.time.s h = new j$.time.s(1);
    public static final Map i;
    public u a;
    public final u b;
    public final List c;
    public final boolean d;
    public int e;
    public char f;
    public int g;

    static {
        HashMap map = new HashMap();
        i = map;
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.a;
        map.put('Q', hVar);
        map.put('q', hVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.l.a);
    }

    public u() {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = null;
        this.d = false;
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d dVar = dateTimeFormatter.a;
        if (dVar.b) {
            dVar = new d(dVar.a, false);
        }
        c(dVar);
    }

    public final void b(j$.time.temporal.a aVar, int i2, int i3, boolean z) {
        if (i2 != i3 || z) {
            c(new f(aVar, i2, i3, z));
        } else {
            k(new f(aVar, i2, i3, z));
        }
    }

    public final int c(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        u uVar = this.a;
        int i2 = uVar.e;
        if (i2 > 0) {
            k kVar = new k(eVar, i2, uVar.f);
            uVar.e = 0;
            uVar.f = (char) 0;
            eVar = kVar;
        }
        ((ArrayList) uVar.c).add(eVar);
        this.a.g = -1;
        return ((ArrayList) r4.c).size() - 1;
    }

    public final void d(char c) {
        c(new c(c));
    }

    public final void e(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            c(new c(str.charAt(0)));
        } else {
            c(new h(str, 1));
        }
    }

    public final void f(f0 f0Var) {
        Objects.requireNonNull(f0Var, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        if (f0Var != f0.FULL && f0Var != f0.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        c(new h(f0Var, 0));
    }

    public final void g(String str, String str2) {
        c(new j(str, str2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017e A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0382 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(String str) {
        boolean z;
        int i2;
        int i3;
        Objects.requireNonNull(str, "pattern");
        int i4 = 0;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i5 = i4 + 1;
                while (i5 < str.length() && str.charAt(i5) == cCharAt) {
                    i5++;
                }
                int i6 = i5 - i4;
                if (cCharAt == 'p') {
                    if (i5 >= str.length() || (((cCharAt = str.charAt(i5)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i2 = i5;
                        i3 = i6;
                        i6 = 0;
                    } else {
                        i2 = i5 + 1;
                        while (i2 < str.length() && str.charAt(i2) == cCharAt) {
                            i2++;
                        }
                        i3 = i2 - i5;
                    }
                    if (i6 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: ".concat(str));
                    }
                    if (i6 < 1) {
                        j$.time.g.h("The pad width must be at least one but was ", i6);
                        return;
                    }
                    u uVar = this.a;
                    uVar.e = i6;
                    uVar.f = ' ';
                    uVar.g = -1;
                    i6 = i3;
                    i5 = i2;
                }
                j$.time.temporal.o oVar = (j$.time.temporal.o) ((HashMap) i).get(Character.valueOf(cCharAt));
                if (oVar != null) {
                    if (cCharAt == 'A') {
                        n(oVar, i6, 19, e0.NOT_NEGATIVE);
                    } else {
                        if (cCharAt == 'Q') {
                            z = false;
                        } else if (cCharAt == 'S') {
                            b(j$.time.temporal.a.NANO_OF_SECOND, i6, i6, false);
                        } else if (cCharAt == 'a') {
                            if (i6 != 1) {
                                j$.time.g.j("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            j(oVar, f0.SHORT);
                        } else if (cCharAt == 'k') {
                            if (i6 == 1) {
                                l(oVar);
                            } else {
                                if (i6 != 2) {
                                    j$.time.g.j("Too many pattern letters: ", cCharAt);
                                    return;
                                }
                                m(oVar, i6);
                            }
                        } else if (cCharAt == 'q') {
                            z = true;
                        } else if (cCharAt != 's') {
                            if (cCharAt == 'u' || cCharAt == 'y') {
                                if (i6 == 2) {
                                    LocalDate localDate = o.h;
                                    Objects.requireNonNull(localDate, "baseDate");
                                    k(new o(oVar, 2, 2, localDate, 0));
                                } else if (i6 < 4) {
                                    n(oVar, i6, 19, e0.NORMAL);
                                } else {
                                    n(oVar, i6, 19, e0.EXCEEDS_PAD);
                                }
                            } else if (cCharAt == 'g') {
                                n(oVar, i6, 19, e0.NORMAL);
                            } else if (cCharAt != 'h' && cCharAt != 'm') {
                                if (cCharAt != 'n') {
                                    switch (cCharAt) {
                                        case 'D':
                                            if (i6 == 1) {
                                                l(oVar);
                                            } else {
                                                if (i6 != 2 && i6 != 3) {
                                                    j$.time.g.j("Too many pattern letters: ", cCharAt);
                                                    return;
                                                }
                                                n(oVar, i6, 3, e0.NOT_NEGATIVE);
                                            }
                                            break;
                                        case 'E':
                                            z = false;
                                            break;
                                        case 'F':
                                            if (i6 != 1) {
                                                j$.time.g.j("Too many pattern letters: ", cCharAt);
                                                return;
                                            }
                                            l(oVar);
                                            break;
                                        case 'G':
                                            if (i6 == 1 || i6 == 2 || i6 == 3) {
                                                j(oVar, f0.SHORT);
                                            } else if (i6 == 4) {
                                                j(oVar, f0.FULL);
                                            } else {
                                                if (i6 != 5) {
                                                    j$.time.g.j("Too many pattern letters: ", cCharAt);
                                                    return;
                                                }
                                                j(oVar, f0.NARROW);
                                            }
                                            break;
                                        default:
                                            switch (cCharAt) {
                                                case 'K':
                                                    break;
                                                case 'L':
                                                    z = true;
                                                    break;
                                                case 'M':
                                                    z = false;
                                                    break;
                                                case 'N':
                                                    break;
                                                default:
                                                    switch (cCharAt) {
                                                        case 'c':
                                                            if (i6 == 1) {
                                                                int i7 = i6;
                                                                k(new r(cCharAt, i7, i7, i7, 0));
                                                            } else {
                                                                if (i6 == 2) {
                                                                    throw new IllegalArgumentException("Invalid pattern \"cc\"");
                                                                }
                                                                z = true;
                                                            }
                                                            break;
                                                        case 'd':
                                                            break;
                                                        case 'e':
                                                            z = false;
                                                            break;
                                                        default:
                                                            if (i6 != 1) {
                                                                m(oVar, i6);
                                                            } else {
                                                                l(oVar);
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                        case 'H':
                                            break;
                                    }
                                }
                            }
                        }
                        if (i6 == 1 || i6 == 2) {
                            if (cCharAt == 'e') {
                                int i8 = i6;
                                k(new r(cCharAt, i8, i8, i8, 0));
                            } else if (cCharAt == 'E') {
                                j(oVar, f0.SHORT);
                            } else if (i6 == 1) {
                                l(oVar);
                            } else {
                                m(oVar, 2);
                            }
                        } else if (i6 == 3) {
                            j(oVar, z ? f0.SHORT_STANDALONE : f0.SHORT);
                        } else if (i6 == 4) {
                            j(oVar, z ? f0.FULL_STANDALONE : f0.FULL);
                        } else {
                            if (i6 != 5) {
                                j$.time.g.j("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            j(oVar, z ? f0.NARROW_STANDALONE : f0.NARROW);
                        }
                    }
                } else if (cCharAt == 'z') {
                    if (i6 > 4) {
                        j$.time.g.j("Too many pattern letters: ", cCharAt);
                        return;
                    } else if (i6 == 4) {
                        c(new t(f0.FULL, false));
                    } else {
                        c(new t(f0.SHORT, false));
                    }
                } else if (cCharAt == 'V') {
                    if (i6 != 2) {
                        j$.time.g.j("Pattern letter count must be 2: ", cCharAt);
                        return;
                    }
                    c(new s(j$.time.temporal.p.a, "ZoneId()"));
                } else if (cCharAt != 'v') {
                    String str2 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i6 < 4) {
                            g("+HHMM", "+0000");
                        } else if (i6 == 4) {
                            f(f0.FULL);
                        } else {
                            if (i6 != 5) {
                                j$.time.g.j("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            g("+HH:MM:ss", "Z");
                        }
                    } else if (cCharAt == 'O') {
                        if (i6 == 1) {
                            f(f0.SHORT);
                        } else {
                            if (i6 != 4) {
                                j$.time.g.j("Pattern letter count must be 1 or 4: ", cCharAt);
                                return;
                            }
                            f(f0.FULL);
                        }
                    } else if (cCharAt == 'X') {
                        if (i6 > 5) {
                            j$.time.g.j("Too many pattern letters: ", cCharAt);
                            return;
                        }
                        g(j.d[i6 + (i6 == 1 ? 0 : 1)], "Z");
                    } else if (cCharAt == 'x') {
                        if (i6 > 5) {
                            j$.time.g.j("Too many pattern letters: ", cCharAt);
                            return;
                        }
                        if (i6 == 1) {
                            str2 = "+00";
                        } else if (i6 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        g(j.d[i6 + (i6 == 1 ? 0 : 1)], str2);
                    } else if (cCharAt != 'W') {
                        int i9 = i6;
                        if (cCharAt == 'w') {
                            if (i9 > 2) {
                                j$.time.g.j("Too many pattern letters: ", cCharAt);
                                return;
                            }
                            k(new r(cCharAt, i9, i9, 2, 0));
                        } else if (cCharAt != 'Y') {
                            j$.time.g.j("Unknown pattern letter: ", cCharAt);
                            return;
                        } else if (i9 == 2) {
                            k(new r(cCharAt, i9, i9, 2, 0));
                        } else {
                            k(new r(cCharAt, i9, i9, 19, 0));
                        }
                    } else if (i6 > 1) {
                        j$.time.g.j("Too many pattern letters: ", cCharAt);
                        return;
                    } else {
                        int i10 = i6;
                        k(new r(cCharAt, i10, i10, i10, 0));
                    }
                } else if (i6 == 1) {
                    c(new t(f0.SHORT, true));
                } else {
                    if (i6 != 4) {
                        j$.time.g.j("Wrong number of  pattern letters: ", cCharAt);
                        return;
                    }
                    c(new t(f0.FULL, true));
                }
                i4 = i5 - 1;
            } else if (cCharAt == '\'') {
                int i11 = i4 + 1;
                int i12 = i11;
                while (i12 < str.length()) {
                    if (str.charAt(i12) == '\'') {
                        int i13 = i12 + 1;
                        if (i13 < str.length() && str.charAt(i13) == '\'') {
                            i12 = i13;
                        } else {
                            if (i12 < str.length()) {
                                throw new IllegalArgumentException("Pattern ends with an incomplete string literal: ".concat(str));
                            }
                            String strSubstring = str.substring(i11, i12);
                            if (strSubstring.isEmpty()) {
                                d('\'');
                            } else {
                                e(strSubstring.replace("''", "'"));
                            }
                            i4 = i12;
                        }
                    }
                    i12++;
                }
                if (i12 < str.length()) {
                }
            } else if (cCharAt == '[') {
                p();
            } else if (cCharAt == ']') {
                if (this.a.b == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                o();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                d(cCharAt);
            }
            i4++;
        }
    }

    public final void i(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        f0 f0Var = f0.FULL;
        c(new q(aVar, f0Var, new a(new z(Collections.singletonMap(f0Var, linkedHashMap)))));
    }

    public final void j(j$.time.temporal.o oVar, f0 f0Var) {
        Objects.requireNonNull(f0Var, "textStyle");
        c(new q(oVar, f0Var, a0.c));
    }

    public final void k(i iVar) {
        i iVarD;
        u uVar = this.a;
        int i2 = uVar.g;
        if (i2 < 0) {
            uVar.g = c(iVar);
            return;
        }
        i iVar2 = (i) ((ArrayList) uVar.c).get(i2);
        int i3 = iVar.b;
        int i4 = iVar.c;
        if (i3 == i4 && iVar.d == e0.NOT_NEGATIVE) {
            iVarD = iVar2.e(i4);
            c(iVar.d());
            this.a.g = i2;
        } else {
            iVarD = iVar2.d();
            this.a.g = c(iVar);
        }
        ((ArrayList) this.a.c).set(i2, iVarD);
    }

    public final void l(j$.time.temporal.o oVar) {
        k(new i(oVar, 1, 19, e0.NORMAL));
    }

    public final void m(j$.time.temporal.o oVar, int i2) {
        Objects.requireNonNull(oVar, "field");
        if (i2 < 1 || i2 > 19) {
            j$.time.g.h("The width must be from 1 to 19 inclusive but was ", i2);
        } else {
            k(new i(oVar, i2, i2, e0.NOT_NEGATIVE));
        }
    }

    public final void n(j$.time.temporal.o oVar, int i2, int i3, e0 e0Var) {
        if (i2 == i3 && e0Var == e0.NOT_NEGATIVE) {
            m(oVar, i3);
            return;
        }
        Objects.requireNonNull(oVar, "field");
        Objects.requireNonNull(e0Var, "signStyle");
        if (i2 < 1 || i2 > 19) {
            j$.time.g.h("The minimum width must be from 1 to 19 inclusive but was ", i2);
            return;
        }
        if (i3 < 1 || i3 > 19) {
            j$.time.g.h("The maximum width must be from 1 to 19 inclusive but was ", i3);
            return;
        }
        if (i3 >= i2) {
            k(new i(oVar, i2, i3, e0Var));
            return;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
    }

    public final void o() {
        u uVar = this.a;
        if (uVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) uVar.c).size();
        u uVar2 = this.a;
        if (size <= 0) {
            this.a = uVar2.b;
            return;
        }
        d dVar = new d(uVar2.c, uVar2.d);
        this.a = this.a.b;
        c(dVar);
    }

    public final void p() {
        u uVar = this.a;
        uVar.g = -1;
        this.a = new u(uVar);
    }

    public final DateTimeFormatter q(d0 d0Var, j$.time.chrono.k kVar) {
        return r(Locale.getDefault(), d0Var, kVar);
    }

    public final DateTimeFormatter r(Locale locale, d0 d0Var, j$.time.chrono.k kVar) {
        Objects.requireNonNull(locale, SpotifyService.LOCALE);
        while (this.a.b != null) {
            o();
        }
        d dVar = new d(this.c, false);
        b0 b0Var = b0.a;
        return new DateTimeFormatter(dVar, locale, d0Var, kVar);
    }

    public u(u uVar) {
        this.a = this;
        this.c = new ArrayList();
        this.g = -1;
        this.b = uVar;
        this.d = true;
    }
}
