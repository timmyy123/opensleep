package j$.time.format;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements e {
    public final j$.time.temporal.o a;
    public final f0 b;
    public final a0 c;
    public volatile i d;

    public q(j$.time.temporal.o oVar, f0 f0Var, a0 a0Var) {
        this.a = oVar;
        this.b = f0Var;
        this.c = a0Var;
    }

    @Override // j$.time.format.e
    public final boolean o(x xVar, StringBuilder sb) {
        Long lA = xVar.a(this.a);
        DateTimeFormatter dateTimeFormatter = xVar.b;
        if (lA == null) {
            return false;
        }
        j$.time.chrono.k kVar = (j$.time.chrono.k) xVar.a.d(j$.time.temporal.p.b);
        String strC = (kVar == null || kVar == j$.time.chrono.r.c) ? this.c.c(this.a, lA.longValue(), this.b, dateTimeFormatter.b) : this.c.b(kVar, this.a, lA.longValue(), this.b, dateTimeFormatter.b);
        if (strC != null) {
            sb.append(strC);
            return true;
        }
        if (this.d == null) {
            this.d = new i(this.a, 1, 19, e0.NORMAL);
        }
        return this.d.o(xVar, sb);
    }

    @Override // j$.time.format.e
    public final int t(v vVar, CharSequence charSequence, int i) {
        a0 a0Var = this.c;
        j$.time.temporal.o oVar = this.a;
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        boolean z = vVar.c;
        DateTimeFormatter dateTimeFormatter = vVar.a;
        f0 f0Var = z ? this.b : null;
        j$.time.chrono.k kVar = vVar.c().c;
        if (kVar == null && (kVar = vVar.a.e) == null) {
            kVar = j$.time.chrono.r.c;
        }
        j$.time.chrono.k kVar2 = kVar;
        Iterator itE = (kVar2 == null || kVar2 == j$.time.chrono.r.c) ? a0Var.e(oVar, f0Var, dateTimeFormatter.b) : a0Var.d(kVar2, oVar, f0Var, dateTimeFormatter.b);
        if (itE != null) {
            while (itE.hasNext()) {
                Map.Entry entry = (Map.Entry) itE.next();
                String str = (String) entry.getKey();
                if (vVar.g(str, 0, charSequence, i, str.length())) {
                    return vVar.f(this.a, ((Long) entry.getValue()).longValue(), i, str.length() + i);
                }
            }
            if (oVar == j$.time.temporal.a.ERA && !vVar.c) {
                Iterator it = kVar2.eras().iterator();
                while (it.hasNext()) {
                    String string = ((j$.time.chrono.l) it.next()).toString();
                    if (vVar.g(string, 0, charSequence, i, string.length())) {
                        return vVar.f(this.a, r8.getValue(), i, string.length() + i);
                    }
                }
            }
            if (vVar.c) {
                return ~i;
            }
        }
        if (this.d == null) {
            this.d = new i(this.a, 1, 19, e0.NORMAL);
        }
        return this.d.t(vVar, charSequence, i);
    }

    public final String toString() {
        f0 f0Var = f0.FULL;
        f0 f0Var2 = this.b;
        j$.time.temporal.o oVar = this.a;
        if (f0Var2 == f0Var) {
            return "Text(" + oVar + ")";
        }
        return "Text(" + oVar + "," + f0Var2 + ")";
    }
}
