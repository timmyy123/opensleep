package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaei {
    public static final zzaei zza;
    public static final zzaei zzb;
    public static final zzaei zzc;
    public static final zzaei zzd;
    public static final zzaei zze;
    public static final zzaei zzf;
    public static final zzaei zzg;
    public static final zzaei zzh;
    public static final zzaei zzi;
    public static final zzaei zzj;
    private static final /* synthetic */ zzaei[] zzl;
    private final Class zzk;

    static {
        zzaei zzaeiVar = new zzaei("VOID", 0, Void.class, Void.class, null);
        zza = zzaeiVar;
        Class cls = Integer.TYPE;
        zzaei zzaeiVar2 = new zzaei("INT", 1, cls, Integer.class, 0);
        zzb = zzaeiVar2;
        zzaei zzaeiVar3 = new zzaei("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzaeiVar3;
        zzaei zzaeiVar4 = new zzaei("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzaeiVar4;
        zzaei zzaeiVar5 = new zzaei("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzaeiVar5;
        zzaei zzaeiVar6 = new zzaei("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzaeiVar6;
        zzaei zzaeiVar7 = new zzaei("STRING", 6, String.class, String.class, "");
        zzg = zzaeiVar7;
        zzaei zzaeiVar8 = new zzaei("BYTE_STRING", 7, zzacr.class, zzacr.class, zzacr.zza);
        zzh = zzaeiVar8;
        zzaei zzaeiVar9 = new zzaei("ENUM", 8, cls, Integer.class, null);
        zzi = zzaeiVar9;
        zzaei zzaeiVar10 = new zzaei("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzaeiVar10;
        zzl = new zzaei[]{zzaeiVar, zzaeiVar2, zzaeiVar3, zzaeiVar4, zzaeiVar5, zzaeiVar6, zzaeiVar7, zzaeiVar8, zzaeiVar9, zzaeiVar10};
    }

    private zzaei(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls2;
    }

    public static zzaei[] values() {
        return (zzaei[]) zzl.clone();
    }

    public final Class zza() {
        return this.zzk;
    }
}
