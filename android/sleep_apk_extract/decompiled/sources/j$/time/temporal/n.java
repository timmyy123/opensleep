package j$.time.temporal;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements m {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ n(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    @Override // j$.time.temporal.m
    public final Temporal f(Temporal temporal) {
        int i = this.a;
        int i2 = this.b;
        switch (i) {
            case 0:
                int iG = temporal.g(a.DAY_OF_WEEK);
                if (iG == i2) {
                    return temporal;
                }
                return temporal.b(iG - i2 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int iG2 = temporal.g(a.DAY_OF_WEEK);
                if (iG2 == i2) {
                    return temporal;
                }
                return temporal.c(i2 - iG2 >= 0 ? 7 - r2 : -r2, b.DAYS);
        }
    }
}
