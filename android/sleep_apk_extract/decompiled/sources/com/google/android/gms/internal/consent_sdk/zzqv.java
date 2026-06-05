package com.google.android.gms.internal.consent_sdk;

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
public final class zzqv {
    public static final zzqv zza;
    public static final zzqv zzb;
    public static final zzqv zzc;
    public static final zzqv zzd;
    public static final zzqv zze;
    public static final zzqv zzf;
    public static final zzqv zzg;
    public static final zzqv zzh;
    public static final zzqv zzi;
    public static final zzqv zzj;
    private static final /* synthetic */ zzqv[] zzk;
    private final Class zzl;

    static {
        zzqv zzqvVar = new zzqv("VOID", 0, Void.class, Void.class, null);
        zza = zzqvVar;
        Class cls = Integer.TYPE;
        zzqv zzqvVar2 = new zzqv("INT", 1, cls, Integer.class, 0);
        zzb = zzqvVar2;
        zzqv zzqvVar3 = new zzqv("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzqvVar3;
        zzqv zzqvVar4 = new zzqv("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzqvVar4;
        zzqv zzqvVar5 = new zzqv("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzqvVar5;
        zzqv zzqvVar6 = new zzqv("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzqvVar6;
        zzqv zzqvVar7 = new zzqv("STRING", 6, String.class, String.class, "");
        zzg = zzqvVar7;
        zzqv zzqvVar8 = new zzqv("BYTE_STRING", 7, zzpm.class, zzpm.class, zzpm.zzb);
        zzh = zzqvVar8;
        zzqv zzqvVar9 = new zzqv("ENUM", 8, cls, Integer.class, null);
        zzi = zzqvVar9;
        zzqv zzqvVar10 = new zzqv("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzqvVar10;
        zzk = new zzqv[]{zzqvVar, zzqvVar2, zzqvVar3, zzqvVar4, zzqvVar5, zzqvVar6, zzqvVar7, zzqvVar8, zzqvVar9, zzqvVar10};
    }

    private zzqv(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public static zzqv[] values() {
        return (zzqv[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
