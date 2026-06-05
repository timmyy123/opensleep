package com.google.android.gms.internal.serialization;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzace {
    public static final zzace zza;
    public static final zzace zzb;
    public static final zzace zzc;
    public static final zzace zzd;
    public static final zzace zze;
    public static final zzace zzf;
    public static final zzace zzg;
    public static final zzace zzh;
    public static final zzace zzi;
    public static final zzace zzj;
    public static final zzace zzk;
    public static final zzace zzl;
    public static final zzace zzm;
    public static final zzace zzn;
    public static final zzace zzo;
    public static final zzace zzp;
    public static final zzace zzq;
    public static final zzace zzr;
    private static final /* synthetic */ zzace[] zzu;
    private final zzacf zzs;
    private final int zzt;

    static {
        zzace zzaceVar = new zzace("DOUBLE", 0, zzacf.DOUBLE, 1);
        zza = zzaceVar;
        zzace zzaceVar2 = new zzace("FLOAT", 1, zzacf.FLOAT, 5);
        zzb = zzaceVar2;
        zzacf zzacfVar = zzacf.LONG;
        zzace zzaceVar3 = new zzace("INT64", 2, zzacfVar, 0);
        zzc = zzaceVar3;
        zzace zzaceVar4 = new zzace("UINT64", 3, zzacfVar, 0);
        zzd = zzaceVar4;
        zzacf zzacfVar2 = zzacf.INT;
        zzace zzaceVar5 = new zzace("INT32", 4, zzacfVar2, 0);
        zze = zzaceVar5;
        zzace zzaceVar6 = new zzace("FIXED64", 5, zzacfVar, 1);
        zzf = zzaceVar6;
        zzace zzaceVar7 = new zzace("FIXED32", 6, zzacfVar2, 5);
        zzg = zzaceVar7;
        zzace zzaceVar8 = new zzace("BOOL", 7, zzacf.BOOLEAN, 0);
        zzh = zzaceVar8;
        zzace zzaceVar9 = new zzace("STRING", 8, zzacf.STRING, 2);
        zzi = zzaceVar9;
        zzacf zzacfVar3 = zzacf.MESSAGE;
        zzace zzaceVar10 = new zzace("GROUP", 9, zzacfVar3, 3);
        zzj = zzaceVar10;
        zzace zzaceVar11 = new zzace("MESSAGE", 10, zzacfVar3, 2);
        zzk = zzaceVar11;
        zzace zzaceVar12 = new zzace("BYTES", 11, zzacf.BYTE_STRING, 2);
        zzl = zzaceVar12;
        zzace zzaceVar13 = new zzace("UINT32", 12, zzacfVar2, 0);
        zzm = zzaceVar13;
        zzace zzaceVar14 = new zzace("ENUM", 13, zzacf.ENUM, 0);
        zzn = zzaceVar14;
        zzace zzaceVar15 = new zzace("SFIXED32", 14, zzacfVar2, 5);
        zzo = zzaceVar15;
        zzace zzaceVar16 = new zzace("SFIXED64", 15, zzacfVar, 1);
        zzp = zzaceVar16;
        zzace zzaceVar17 = new zzace("SINT32", 16, zzacfVar2, 0);
        zzq = zzaceVar17;
        zzace zzaceVar18 = new zzace("SINT64", 17, zzacfVar, 0);
        zzr = zzaceVar18;
        zzu = new zzace[]{zzaceVar, zzaceVar2, zzaceVar3, zzaceVar4, zzaceVar5, zzaceVar6, zzaceVar7, zzaceVar8, zzaceVar9, zzaceVar10, zzaceVar11, zzaceVar12, zzaceVar13, zzaceVar14, zzaceVar15, zzaceVar16, zzaceVar17, zzaceVar18};
    }

    private zzace(String str, int i, zzacf zzacfVar, int i2) {
        this.zzs = zzacfVar;
        this.zzt = i2;
    }

    public static zzace[] values() {
        return (zzace[]) zzu.clone();
    }

    public final zzacf zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
