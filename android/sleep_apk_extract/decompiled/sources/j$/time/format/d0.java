package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {
    public static final d0 LENIENT;
    public static final d0 SMART;
    public static final d0 STRICT;
    public static final /* synthetic */ d0[] a;

    static {
        d0 d0Var = new d0("STRICT", 0);
        STRICT = d0Var;
        d0 d0Var2 = new d0("SMART", 1);
        SMART = d0Var2;
        d0 d0Var3 = new d0("LENIENT", 2);
        LENIENT = d0Var3;
        a = new d0[]{d0Var, d0Var2, d0Var3};
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) a.clone();
    }
}
