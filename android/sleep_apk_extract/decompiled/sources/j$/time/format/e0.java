package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static final e0 ALWAYS;
    public static final e0 EXCEEDS_PAD;
    public static final e0 NEVER;
    public static final e0 NORMAL;
    public static final e0 NOT_NEGATIVE;
    public static final /* synthetic */ e0[] a;

    static {
        e0 e0Var = new e0("NORMAL", 0);
        NORMAL = e0Var;
        e0 e0Var2 = new e0("ALWAYS", 1);
        ALWAYS = e0Var2;
        e0 e0Var3 = new e0("NEVER", 2);
        NEVER = e0Var3;
        e0 e0Var4 = new e0("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = e0Var4;
        e0 e0Var5 = new e0("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = e0Var5;
        a = new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5};
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) a.clone();
    }
}
