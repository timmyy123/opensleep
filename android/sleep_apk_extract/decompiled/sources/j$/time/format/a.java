package j$.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends a0 {
    public final /* synthetic */ z d;

    public a(z zVar) {
        this.d = zVar;
    }

    @Override // j$.time.format.a0
    public final String b(j$.time.chrono.k kVar, j$.time.temporal.o oVar, long j, f0 f0Var, Locale locale) {
        return this.d.a(j, f0Var);
    }

    @Override // j$.time.format.a0
    public final String c(j$.time.temporal.o oVar, long j, f0 f0Var, Locale locale) {
        return this.d.a(j, f0Var);
    }

    @Override // j$.time.format.a0
    public final Iterator d(j$.time.chrono.k kVar, j$.time.temporal.o oVar, f0 f0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(f0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }

    @Override // j$.time.format.a0
    public final Iterator e(j$.time.temporal.o oVar, f0 f0Var, Locale locale) {
        List list = (List) ((HashMap) this.d.b).get(f0Var);
        if (list != null) {
            return list.iterator();
        }
        return null;
    }
}
