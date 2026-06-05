package com.google.android.gms.internal.clearcut;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzky' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcq {
    public static final zzcq zzkx;
    public static final zzcq zzky;
    public static final zzcq zzkz;
    public static final zzcq zzla;
    public static final zzcq zzlb;
    public static final zzcq zzlc;
    public static final zzcq zzld;
    public static final zzcq zzle;
    public static final zzcq zzlf;
    public static final zzcq zzlg;
    private static final /* synthetic */ zzcq[] zzlk;
    private final Class<?> zzlh;
    private final Class<?> zzli;
    private final Object zzlj;

    static {
        zzcq zzcqVar = new zzcq("VOID", 0, Void.class, Void.class, null);
        zzkx = zzcqVar;
        Class cls = Integer.TYPE;
        zzcq zzcqVar2 = new zzcq("INT", 1, cls, Integer.class, 0);
        zzky = zzcqVar2;
        zzcq zzcqVar3 = new zzcq("LONG", 2, Long.TYPE, Long.class, 0L);
        zzkz = zzcqVar3;
        zzcq zzcqVar4 = new zzcq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzla = zzcqVar4;
        zzcq zzcqVar5 = new zzcq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zzlb = zzcqVar5;
        zzcq zzcqVar6 = new zzcq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzlc = zzcqVar6;
        zzcq zzcqVar7 = new zzcq("STRING", 6, String.class, String.class, "");
        zzld = zzcqVar7;
        zzcq zzcqVar8 = new zzcq("BYTE_STRING", 7, zzbb.class, zzbb.class, zzbb.zzfi);
        zzle = zzcqVar8;
        zzcq zzcqVar9 = new zzcq("ENUM", 8, cls, Integer.class, null);
        zzlf = zzcqVar9;
        zzcq zzcqVar10 = new zzcq("MESSAGE", 9, Object.class, Object.class, null);
        zzlg = zzcqVar10;
        zzlk = new zzcq[]{zzcqVar, zzcqVar2, zzcqVar3, zzcqVar4, zzcqVar5, zzcqVar6, zzcqVar7, zzcqVar8, zzcqVar9, zzcqVar10};
    }

    private zzcq(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzlh = cls;
        this.zzli = cls2;
        this.zzlj = obj;
    }

    public static zzcq[] values() {
        return (zzcq[]) zzlk.clone();
    }

    public final Class<?> zzbq() {
        return this.zzli;
    }
}
