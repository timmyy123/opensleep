package com.google.android.gms.internal.vision;

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
/* JADX INFO: loaded from: classes4.dex */
public final class zzjm {
    public static final zzjm zza;
    public static final zzjm zzb;
    public static final zzjm zzc;
    public static final zzjm zzd;
    public static final zzjm zze;
    public static final zzjm zzf;
    public static final zzjm zzg;
    public static final zzjm zzh;
    public static final zzjm zzi;
    public static final zzjm zzj;
    private static final /* synthetic */ zzjm[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        zzjm zzjmVar = new zzjm("VOID", 0, Void.class, Void.class, null);
        zza = zzjmVar;
        Class cls = Integer.TYPE;
        zzjm zzjmVar2 = new zzjm("INT", 1, cls, Integer.class, 0);
        zzb = zzjmVar2;
        zzjm zzjmVar3 = new zzjm("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzjmVar3;
        zzjm zzjmVar4 = new zzjm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzjmVar4;
        zzjm zzjmVar5 = new zzjm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzjmVar5;
        zzjm zzjmVar6 = new zzjm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzjmVar6;
        zzjm zzjmVar7 = new zzjm("STRING", 6, String.class, String.class, "");
        zzg = zzjmVar7;
        zzjm zzjmVar8 = new zzjm("BYTE_STRING", 7, zzht.class, zzht.class, zzht.zza);
        zzh = zzjmVar8;
        zzjm zzjmVar9 = new zzjm("ENUM", 8, cls, Integer.class, null);
        zzi = zzjmVar9;
        zzjm zzjmVar10 = new zzjm("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzjmVar10;
        zzn = new zzjm[]{zzjmVar, zzjmVar2, zzjmVar3, zzjmVar4, zzjmVar5, zzjmVar6, zzjmVar7, zzjmVar8, zzjmVar9, zzjmVar10};
    }

    private zzjm(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static zzjm[] values() {
        return (zzjm[]) zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
