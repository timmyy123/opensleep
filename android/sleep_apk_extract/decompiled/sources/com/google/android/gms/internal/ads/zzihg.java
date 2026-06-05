package com.google.android.gms.internal.ads;

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
public final class zzihg {
    public static final zzihg zza;
    public static final zzihg zzb;
    public static final zzihg zzc;
    public static final zzihg zzd;
    public static final zzihg zze;
    public static final zzihg zzf;
    public static final zzihg zzg;
    public static final zzihg zzh;
    public static final zzihg zzi;
    public static final zzihg zzj;
    public static final zzihg zzk;
    public static final zzihg zzl;
    public static final zzihg zzm;
    public static final zzihg zzn;
    public static final zzihg zzo;
    public static final zzihg zzp;
    public static final zzihg zzq;
    public static final zzihg zzr;
    private static final /* synthetic */ zzihg[] zzu;
    private final zzihh zzs;
    private final int zzt;

    static {
        zzihg zzihgVar = new zzihg("DOUBLE", 0, zzihh.DOUBLE, 1);
        zza = zzihgVar;
        zzihg zzihgVar2 = new zzihg("FLOAT", 1, zzihh.FLOAT, 5);
        zzb = zzihgVar2;
        zzihh zzihhVar = zzihh.LONG;
        zzihg zzihgVar3 = new zzihg("INT64", 2, zzihhVar, 0);
        zzc = zzihgVar3;
        zzihg zzihgVar4 = new zzihg("UINT64", 3, zzihhVar, 0);
        zzd = zzihgVar4;
        zzihh zzihhVar2 = zzihh.INT;
        zzihg zzihgVar5 = new zzihg("INT32", 4, zzihhVar2, 0);
        zze = zzihgVar5;
        zzihg zzihgVar6 = new zzihg("FIXED64", 5, zzihhVar, 1);
        zzf = zzihgVar6;
        zzihg zzihgVar7 = new zzihg("FIXED32", 6, zzihhVar2, 5);
        zzg = zzihgVar7;
        zzihg zzihgVar8 = new zzihg("BOOL", 7, zzihh.BOOLEAN, 0);
        zzh = zzihgVar8;
        zzihg zzihgVar9 = new zzihg("STRING", 8, zzihh.STRING, 2);
        zzi = zzihgVar9;
        zzihh zzihhVar3 = zzihh.MESSAGE;
        zzihg zzihgVar10 = new zzihg("GROUP", 9, zzihhVar3, 3);
        zzj = zzihgVar10;
        zzihg zzihgVar11 = new zzihg("MESSAGE", 10, zzihhVar3, 2);
        zzk = zzihgVar11;
        zzihg zzihgVar12 = new zzihg("BYTES", 11, zzihh.BYTE_STRING, 2);
        zzl = zzihgVar12;
        zzihg zzihgVar13 = new zzihg("UINT32", 12, zzihhVar2, 0);
        zzm = zzihgVar13;
        zzihg zzihgVar14 = new zzihg("ENUM", 13, zzihh.ENUM, 0);
        zzn = zzihgVar14;
        zzihg zzihgVar15 = new zzihg("SFIXED32", 14, zzihhVar2, 5);
        zzo = zzihgVar15;
        zzihg zzihgVar16 = new zzihg("SFIXED64", 15, zzihhVar, 1);
        zzp = zzihgVar16;
        zzihg zzihgVar17 = new zzihg("SINT32", 16, zzihhVar2, 0);
        zzq = zzihgVar17;
        zzihg zzihgVar18 = new zzihg("SINT64", 17, zzihhVar, 0);
        zzr = zzihgVar18;
        zzu = new zzihg[]{zzihgVar, zzihgVar2, zzihgVar3, zzihgVar4, zzihgVar5, zzihgVar6, zzihgVar7, zzihgVar8, zzihgVar9, zzihgVar10, zzihgVar11, zzihgVar12, zzihgVar13, zzihgVar14, zzihgVar15, zzihgVar16, zzihgVar17, zzihgVar18};
    }

    private zzihg(String str, int i, zzihh zzihhVar, int i2) {
        this.zzs = zzihhVar;
        this.zzt = i2;
    }

    public static zzihg[] values() {
        return (zzihg[]) zzu.clone();
    }

    public final zzihh zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
