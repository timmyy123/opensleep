package com.google.android.gms.internal.play_billing;

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
public final class zzhs {
    public static final zzhs zza;
    public static final zzhs zzb;
    public static final zzhs zzc;
    public static final zzhs zzd;
    public static final zzhs zze;
    public static final zzhs zzf;
    public static final zzhs zzg;
    public static final zzhs zzh;
    public static final zzhs zzi;
    public static final zzhs zzj;
    private static final /* synthetic */ zzhs[] zzk;
    private final Class zzl;

    static {
        zzhs zzhsVar = new zzhs("VOID", 0, Void.class, Void.class, null);
        zza = zzhsVar;
        Class cls = Integer.TYPE;
        zzhs zzhsVar2 = new zzhs("INT", 1, cls, Integer.class, 0);
        zzb = zzhsVar2;
        zzhs zzhsVar3 = new zzhs("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzhsVar3;
        zzhs zzhsVar4 = new zzhs("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzhsVar4;
        zzhs zzhsVar5 = new zzhs("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzhsVar5;
        zzhs zzhsVar6 = new zzhs("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzhsVar6;
        zzhs zzhsVar7 = new zzhs("STRING", 6, String.class, String.class, "");
        zzg = zzhsVar7;
        zzhs zzhsVar8 = new zzhs("BYTE_STRING", 7, zzgk.class, zzgk.class, zzgk.zzb);
        zzh = zzhsVar8;
        zzhs zzhsVar9 = new zzhs("ENUM", 8, cls, Integer.class, null);
        zzi = zzhsVar9;
        zzhs zzhsVar10 = new zzhs("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzhsVar10;
        zzk = new zzhs[]{zzhsVar, zzhsVar2, zzhsVar3, zzhsVar4, zzhsVar5, zzhsVar6, zzhsVar7, zzhsVar8, zzhsVar9, zzhsVar10};
    }

    private zzhs(String str, int i, Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    public static zzhs[] values() {
        return (zzhs[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
