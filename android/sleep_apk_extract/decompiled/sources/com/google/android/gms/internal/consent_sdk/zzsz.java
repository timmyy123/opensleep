package com.google.android.gms.internal.consent_sdk;

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
public final class zzsz {
    public static final zzsz zza;
    public static final zzsz zzb;
    public static final zzsz zzc;
    public static final zzsz zzd;
    public static final zzsz zze;
    public static final zzsz zzf;
    public static final zzsz zzg;
    public static final zzsz zzh;
    public static final zzsz zzi;
    public static final zzsz zzj;
    public static final zzsz zzk;
    public static final zzsz zzl;
    public static final zzsz zzm;
    public static final zzsz zzn;
    public static final zzsz zzo;
    public static final zzsz zzp;
    public static final zzsz zzq;
    public static final zzsz zzr;
    private static final /* synthetic */ zzsz[] zzs;
    private final zzta zzt;
    private final int zzu;

    static {
        zzsz zzszVar = new zzsz("DOUBLE", 0, zzta.DOUBLE, 1);
        zza = zzszVar;
        zzsz zzszVar2 = new zzsz("FLOAT", 1, zzta.FLOAT, 5);
        zzb = zzszVar2;
        zzta zztaVar = zzta.LONG;
        zzsz zzszVar3 = new zzsz("INT64", 2, zztaVar, 0);
        zzc = zzszVar3;
        zzsz zzszVar4 = new zzsz("UINT64", 3, zztaVar, 0);
        zzd = zzszVar4;
        zzta zztaVar2 = zzta.INT;
        zzsz zzszVar5 = new zzsz("INT32", 4, zztaVar2, 0);
        zze = zzszVar5;
        zzsz zzszVar6 = new zzsz("FIXED64", 5, zztaVar, 1);
        zzf = zzszVar6;
        zzsz zzszVar7 = new zzsz("FIXED32", 6, zztaVar2, 5);
        zzg = zzszVar7;
        zzsz zzszVar8 = new zzsz("BOOL", 7, zzta.BOOLEAN, 0);
        zzh = zzszVar8;
        zzsz zzszVar9 = new zzsz("STRING", 8, zzta.STRING, 2);
        zzi = zzszVar9;
        zzta zztaVar3 = zzta.MESSAGE;
        zzsz zzszVar10 = new zzsz("GROUP", 9, zztaVar3, 3);
        zzj = zzszVar10;
        zzsz zzszVar11 = new zzsz("MESSAGE", 10, zztaVar3, 2);
        zzk = zzszVar11;
        zzsz zzszVar12 = new zzsz("BYTES", 11, zzta.BYTE_STRING, 2);
        zzl = zzszVar12;
        zzsz zzszVar13 = new zzsz("UINT32", 12, zztaVar2, 0);
        zzm = zzszVar13;
        zzsz zzszVar14 = new zzsz("ENUM", 13, zzta.ENUM, 0);
        zzn = zzszVar14;
        zzsz zzszVar15 = new zzsz("SFIXED32", 14, zztaVar2, 5);
        zzo = zzszVar15;
        zzsz zzszVar16 = new zzsz("SFIXED64", 15, zztaVar, 1);
        zzp = zzszVar16;
        zzsz zzszVar17 = new zzsz("SINT32", 16, zztaVar2, 0);
        zzq = zzszVar17;
        zzsz zzszVar18 = new zzsz("SINT64", 17, zztaVar, 0);
        zzr = zzszVar18;
        zzs = new zzsz[]{zzszVar, zzszVar2, zzszVar3, zzszVar4, zzszVar5, zzszVar6, zzszVar7, zzszVar8, zzszVar9, zzszVar10, zzszVar11, zzszVar12, zzszVar13, zzszVar14, zzszVar15, zzszVar16, zzszVar17, zzszVar18};
    }

    private zzsz(String str, int i, zzta zztaVar, int i2) {
        this.zzt = zztaVar;
        this.zzu = i2;
    }

    public static zzsz[] values() {
        return (zzsz[]) zzs.clone();
    }

    public final int zza() {
        return this.zzu;
    }

    public final zzta zzb() {
        return this.zzt;
    }
}
