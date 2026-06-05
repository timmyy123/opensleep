package com.google.android.gms.internal.ads;

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
public final class zziev {
    public static final zziev zza;
    public static final zziev zzb;
    public static final zziev zzc;
    public static final zziev zzd;
    public static final zziev zze;
    public static final zziev zzf;
    public static final zziev zzg;
    public static final zziev zzh;
    public static final zziev zzi;
    public static final zziev zzj;
    private static final /* synthetic */ zziev[] zzl;
    private final Class zzk;

    static {
        zziev zzievVar = new zziev("VOID", 0, Void.class, Void.class, null);
        zza = zzievVar;
        Class cls = Integer.TYPE;
        zziev zzievVar2 = new zziev("INT", 1, cls, Integer.class, 0);
        zzb = zzievVar2;
        zziev zzievVar3 = new zziev("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzievVar3;
        zziev zzievVar4 = new zziev("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzievVar4;
        zziev zzievVar5 = new zziev("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzievVar5;
        zziev zzievVar6 = new zziev("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzievVar6;
        zziev zzievVar7 = new zziev("STRING", 6, String.class, String.class, "");
        zzg = zzievVar7;
        zziev zzievVar8 = new zziev("BYTE_STRING", 7, zzida.class, zzida.class, zzida.zza);
        zzh = zzievVar8;
        zziev zzievVar9 = new zziev("ENUM", 8, cls, Integer.class, null);
        zzi = zzievVar9;
        zziev zzievVar10 = new zziev("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzievVar10;
        zzl = new zziev[]{zzievVar, zzievVar2, zzievVar3, zzievVar4, zzievVar5, zzievVar6, zzievVar7, zzievVar8, zzievVar9, zzievVar10};
    }

    private zziev(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls2;
    }

    public static zziev[] values() {
        return (zziev[]) zzl.clone();
    }

    public final Class zza() {
        return this.zzk;
    }
}
